package com.cnten.bdlocation.companyOrg.service;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cnten.platform.dao.CommonDAO;
import com.cnten.platform.util.ContextUtil;
import com.cnten.platform.web.SuccessOrFailure;
import com.cnten.po.Company;
import com.cnten.po.CorsAccount;
import com.cnten.po.Role;
import com.cnten.po.RoleUser;
import com.cnten.po.User;

@Service
public class CompanyOrgCorsService {
	
	@Autowired
	private CommonDAO commonDAO;
	
	/**
	 * 加载  公司未分配的账号
	 * @param company
	 * @return
	 */
	public List<CorsAccount> getCompanyCorsOfNoDevide(Company company){
		String hql = " select new com.cnten.vo.CorsAccountVO(a.corsAccountId,a.corsAccountCode) from CorsAccount a where a.isDelete is null and a.companyOrg is null "
				+ "and a.company = :company order by a.corsAccountOrder asc";
		HashMap<String,Object> params = new HashMap<String,Object>();
		params.put("company", company);
		return commonDAO.queryList(hql, params);
	}
	
	/**
	 *	获取当前机构  已持有的cors  和 公司 待分配 的cors
	 */
	public HashMap<String,Object> getOrgCorsAndBlankCors(String companyOrgId){
		Company company = ContextUtil.getCurrentUser().getCompany();
		HashMap<String,Object> rlt = new HashMap<String,Object>();
		try {
			String currOrgCors = "select new com.cnten.vo.CorsAccountVO(a.corsAccountId,a.corsAccountCode) from CorsAccount a where a.isDelete is null and a.company = ? and a.companyOrg.companyOrgId = ?";
			List<CorsAccount> currOrgCorsList = commonDAO.queryListByVariableParam(currOrgCors, company,companyOrgId);
			rlt.put("currOrgCorsList", currOrgCorsList);
			
			String blankCors = " select new com.cnten.vo.CorsAccountVO(a.corsAccountId,a.corsAccountCode) from CorsAccount a where a.isDelete is null and a.companyOrg is null and a.company = ?";
			List<CorsAccount> blankCorsList = commonDAO.queryListByVariableParam(blankCors, company);
			rlt.put("blankCorsList", blankCorsList);
			return rlt;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	/**
	 * 
	 * @param oldCors  装在需要更新 company_org_id = null 的数据
	 * @param newCors  装在需要更新 company_org_id = 当前组织机构id  的数据
	 * @param companyOrgId
	 * @return
	 */
	public SuccessOrFailure updateCorsCompanyOrg(String oldCors, String newCors, String companyOrgId){
		try {
			if(oldCors.length() > 0){
				updateCorsOrgId(oldCors.split(","),companyOrgId,"old");
			}
			if(newCors.length() > 0){
				updateCorsOrgId(newCors.split(","),companyOrgId,"new");
			}
			return SuccessOrFailure.SUCCESS;
		} catch (Exception e) {
			e.printStackTrace();
			return SuccessOrFailure.FAILURE("操作失败");
		}
	}
	
	private void updateCorsOrgId(String[] arr, String companyOrgId, String type){
		Company company = ContextUtil.getCurrentUser().getCompany();
		for(int i=0,len=arr.length; i<len; i++){
			String sql = "update cors_account a set a.company_org_id = ? where a.cors_account_id = ?";
			if("old".equals(type)){
				commonDAO.updateByVPSQLQuery(sql, null, arr[i]);
				String del = "delete from role_user  where is_delete is null and user_id = ?";
				commonDAO.updateByVPSQLQuery(del, arr[i]);
			} else {
				commonDAO.updateByVPSQLQuery(sql, companyOrgId, arr[i]);
				
				//绑定业务员角色
				String roleSql = " from Role a where a.isDelete is null and a.roleCode = ? and a.company = ?";
				Role role = commonDAO.getByVariableParam(roleSql, company.getCompanyCode()+"busi",company);
				User user = new User();
				user.setUserId(arr[i]);
				RoleUser roleUser = new RoleUser();
				roleUser.setUser(user);
				roleUser.setRole(role);
				commonDAO.save(roleUser);
			}
		}
		
	}
}
