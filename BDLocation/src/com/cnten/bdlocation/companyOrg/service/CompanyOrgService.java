package com.cnten.bdlocation.companyOrg.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cnten.enums.UserFeature;
import com.cnten.platform.dao.CommonDAO;
import com.cnten.platform.util.ContextUtil;
import com.cnten.platform.util.EncryptUtils;
import com.cnten.platform.web.SuccessOrFailure;
import com.cnten.po.Company;
import com.cnten.po.CompanyOrg;
import com.cnten.po.Role;
import com.cnten.po.RoleUser;
import com.cnten.po.User;

@Service
public class CompanyOrgService {
	@Autowired
	private CommonDAO commonDAO;
	
	public List<User> getCompanyAdmin(String companyOrgId,Company company){
		String hql = "select new com.cnten.vo.UserVO(a.userId,a.userCode,a.userName,a.password,a.companyOrg.companyOrgId) from User a where a.company = :company and a.isDelete is null and a.companyOrg.companyOrgId = :companyOrgId ";
		HashMap<String,Object> params = new HashMap<String,Object>();
		params.put("company",company);
		params.put("companyOrgId",companyOrgId);
		return commonDAO.queryList(hql, params);
	}
	
	public List<CompanyOrg> getCompanyOrgs(Company company){
		try {
			String hql = "from CompanyOrg a where a.company = :company and a.isDelete is null order by a.orgLevel asc";
			HashMap<String,Object> params = new HashMap<String,Object>();
			params.put("company", company);
			List<CompanyOrg> orgs = commonDAO.queryList(hql, params);
			List<CompanyOrg> sortedOrgs = new ArrayList<CompanyOrg>();
			for(CompanyOrg orgItem : orgs){
				if(StringUtils.isEmpty(orgItem.getParentOrgId())){
					sortedOrgs.add(orgItem);
					addChildren(orgItem,orgs,sortedOrgs);
				}
			}
			return sortedOrgs;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	private void addChildren(CompanyOrg org,List<CompanyOrg> orgs,List<CompanyOrg> sortedOrgs){
		for(CompanyOrg o : orgs){
			if(org.getCompanyOrgId().equals(o.getParentOrgId())){
				sortedOrgs.add(o);
				addChildren(o, orgs, sortedOrgs);
			}
		}
	}
	
	public CompanyOrg getCompanyOrg(String orgId){
		return commonDAO.get(CompanyOrg.class, orgId);
	}
	
	public String saveOrg(CompanyOrg org) {
		String orgId = org.getCompanyOrgId();
		if(StringUtils.isEmpty(orgId)){
			org.setCompany(ContextUtil.getCurrentUser().getCompany());
			commonDAO.save(org);
			return org.getCompanyOrgId();
		}else{
			CompanyOrg oldOrg = commonDAO.load(CompanyOrg.class, orgId);
			oldOrg.setOrgName(org.getOrgName());
			oldOrg.setAdminCode(org.getAdminCode());
			oldOrg.setAdminPwd(org.getAdminPwd());
			commonDAO.update(oldOrg);
			return null;
		}
	}
	
	public String saveOrgAdmin(User user){
		try {
			String userId = user.getUserId();
			Company company = ContextUtil.getCurrentUser().getCompany();
			if(StringUtils.isEmpty(userId)){
				user.setPlainPwd(user.getPassword());
				String password = EncryptUtils.encrypt(user.getUserCode()+user.getPassword());
				user.setPassword(password);
				user.setCreateDate(new Date());
				user.setUserFeature(UserFeature.Company_Dispach_Admin.getValue());
				user.setCompany(company);
				commonDAO.save(user);
				
				//绑定角色
				String hql = "from Role a where a.company = ? and a.isDelete is null and a.roleCode = ? ";
				Role role = commonDAO.getByVariableParam(hql, company,company.getCompanyCode()+"admin");
				RoleUser roleUser = new RoleUser();
				roleUser.setRole(role);
				roleUser.setUser(user);;
				commonDAO.save(roleUser);
				return user.getUserId();
			}else{
				User oldUser = commonDAO.load(User.class, userId);
				oldUser.setUserName(user.getUserName());
				commonDAO.update(oldUser);
				return null;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public void deleteOrgAdmin(String userId){
		commonDAO.delete(User.class, userId);
		String hql = " from RoleUser a where a.user.userId = ?";
		RoleUser roleUser = commonDAO.getByVariableParam(hql, userId);
		if(roleUser != null){
			commonDAO.delete(roleUser);
		}
	}
	
	public SuccessOrFailure deleteOrg(String companyOrgId){
		//判断该节点下是否还配有管理员，没有，可以删除，有，提示不能删除
		String hql = " from User a where a.isDelete is null and a.companyOrg.companyOrgId = ? ";
		Long userNum = commonDAO.getCountByVariableParam(hql, companyOrgId);
		
		String hql2 = " from CorsAccount a where a.isDelete is null and a.companyOrg.companyOrgId = ?";
		Long corsNum = commonDAO.getCountByVariableParam(hql2, companyOrgId);
		
		if(userNum>0 || corsNum>0 ){ //存在账号，不能删除
			return SuccessOrFailure.FAILURE("请删除账号后，在尝试删除机构");
		}
		commonDAO.delete(CompanyOrg.class, companyOrgId);
		
		return SuccessOrFailure.SUCCESS;
	}
	
	/**
	 * 获取当前机构 和 子机构 id
	 * @return
	 */
	public List<String> querySelfAndChildOrg(){
		List<String> rlt = new ArrayList<String>();
		String sql = " select * from company_org where is_delete is null and FIND_IN_SET(company_org_id,getChildLst(?))";
		List<Map<String,Object>> lmap = commonDAO.sqlQueryListByVP(sql, ContextUtil.getCurrentUser().getCompanyOrg().getCompanyOrgId());
		
		for (Map<String, Object> map : lmap) {
			rlt.add((String) map.get("company_org_id"));
		}
		return rlt;
	}
}
