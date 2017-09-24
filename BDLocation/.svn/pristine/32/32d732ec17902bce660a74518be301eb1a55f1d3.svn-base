package com.cnten.bdlocation.companytemp.service;

import java.io.OutputStream;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cnten.bdlocation.constants.CorsAccountConsts;
import com.cnten.bdlocation.constants.ForumConsts;
import com.cnten.enums.UserFeature;
import com.cnten.platform.dao.CommonDAO;
import com.cnten.platform.dao.Page;
import com.cnten.platform.export.PoiExporter;
import com.cnten.platform.util.EncryptUtils;
import com.cnten.platform.web.Constants;
import com.cnten.platform.web.SuccessOrFailure;
import com.cnten.po.Company;
import com.cnten.po.CompanyOrg;
import com.cnten.po.CompanyTemp;
import com.cnten.po.PostUser;
import com.cnten.po.Role;
import com.cnten.po.RoleUser;
import com.cnten.po.User;

@Service
public class CompanyTempService {

	@Autowired
	CommonDAO commonDAO;
	
	public Page getCompanyTempsPage(CompanyTemp companyTemp, Integer pageIndex, Integer pageSize) {
		String hql = "from CompanyTemp where is_delete is null";
		HashMap<String,Object> params = new HashMap<String,Object>();
		if(StringUtils.isNotBlank(companyTemp.getCompanyTempName())){
			hql += " and companyTempName like :companyTempName";
			params.put("companyTempName", "%"+companyTemp.getCompanyTempName()+"%");
		}
		if(StringUtils.isNotBlank(companyTemp.getStatus())) {
			if(companyTemp.getStatus().equals("null")) {
				hql += " and status is null";
			} else {
				hql += " and status = :status";
				params.put("status", companyTemp.getStatus());
			}
		}
		hql += " order by createDate desc";
		return commonDAO.getPage(hql, pageIndex, pageSize, params);
	}

	public CompanyTemp getCompanyTemp(String companyTempId) {
		return commonDAO.get(CompanyTemp.class, companyTempId);
	}
	
	public void saveCompanyTemp(CompanyTemp companyTemp) {
		String companyTempId = companyTemp.getCompanyTempId();
		if(StringUtils.isEmpty(companyTempId)){
			commonDAO.save(companyTemp);
		}else{
			CompanyTemp oldCompanyTemp = commonDAO.load(CompanyTemp.class, companyTempId);
			oldCompanyTemp.setCompanyTempName(companyTemp.getCompanyTempName());
			oldCompanyTemp.setAddress(companyTemp.getAddress());
			oldCompanyTemp.setTel(companyTemp.getTel());
			oldCompanyTemp.setContacts(companyTemp.getContacts());
			oldCompanyTemp.setPhone(companyTemp.getPhone());
			oldCompanyTemp.setEmail(companyTemp.getEmail());
			commonDAO.update(oldCompanyTemp);
		}
	}

	public void deleteCompanyTemp(String companyTempIds){
		String[] companyTempIdArray = companyTempIds.split(",");
		for(String companyTempId : companyTempIdArray){
			CompanyTemp oldCompanyTemp = commonDAO.load(CompanyTemp.class, companyTempId);
			oldCompanyTemp.setIs_delete("Y");
			commonDAO.update(oldCompanyTemp);
		}
	}
	
	public void exportCompanyTemps(CompanyTemp companyTemp, HttpServletResponse response) throws Exception{
		String hql = "from CompanyTemp where is_delete is null";
		HashMap<String,Object> params = new HashMap<String,Object>();
		if(StringUtils.isNotBlank(companyTemp.getCompanyTempName())){
			hql += " and companyTempName like :companyTempName";
			params.put("companyTempName", "%"+companyTemp.getCompanyTempName()+"%");
		}
		List<CompanyTemp> companyTemps = commonDAO.queryList(hql, params);
		HSSFWorkbook workbook = new HSSFWorkbook();
		HSSFSheet sheet = workbook.createSheet("企业注册临时表信息");
		sheet.setDefaultColumnWidth(20);
		HSSFRow row = sheet.createRow(0);
		String[] headers = {"企业名称","企业地址","企业电话","联系人(企业管理员)","联系人电话","联系人邮箱"};
		PoiExporter.fillHeader(row, headers);
		int i = 1;
		HSSFCell cell;
		for(CompanyTemp companyTempData : companyTemps){
			row = sheet.createRow(i);
			cell = row.createCell(0);
			if(companyTempData.getCompanyTempName() != null){
				cell.setCellValue(companyTempData.getCompanyTempName());
			}
			cell = row.createCell(1);
			if(companyTempData.getAddress() != null){
				cell.setCellValue(companyTempData.getAddress());
			}
			cell = row.createCell(2);
			if(companyTempData.getTel() != null){
				cell.setCellValue(companyTempData.getTel());
			}
			cell = row.createCell(3);
			if(companyTempData.getContacts() != null){
				cell.setCellValue(companyTempData.getContacts());
			}
			cell = row.createCell(4);
			if(companyTempData.getPhone() != null){
				cell.setCellValue(companyTempData.getPhone());
			}
			cell = row.createCell(5);
			if(companyTempData.getEmail() != null){
				cell.setCellValue(companyTempData.getEmail());
			}
			i++;
		}
		response.setHeader("Content-Disposition", "attachment; filename=" 
				+ java.net.URLEncoder.encode("企业注册临时表信息.xls", "UTF-8"));
		OutputStream os = response.getOutputStream();
		workbook.write(os);
		os.close();
	}
	
	public void saveCompanyTempByPage(CompanyTemp companyTemp) {
		commonDAO.save(companyTemp);
	}

	public boolean saveApproveCompanyTemp(CompanyTemp companyTemp) {
		try{
			Company company = new Company();
			if(StringUtils.isNotEmpty(companyTemp.getCompanyTempName()))company.setCompanyName(companyTemp.getCompanyTempName());
			if(StringUtils.isNotEmpty(companyTemp.getCompanyCode()))company.setCompanyCode(companyTemp.getCompanyCode());
			if(StringUtils.isNotEmpty(companyTemp.getEmail())) company.setEmail(companyTemp.getEmail());
			company.setCompanyMaterialState(CorsAccountConsts.ACCOUNT_STATE_EXAMINE_NOTE);
			commonDAO.save(company);
			
			String password = EncryptUtils.encrypt(companyTemp.getUserCode()+companyTemp.getPassword()); //用户名+密码
			User user = new User();
			user.setUserCode(companyTemp.getUserCode());
			user.setPassword(password);
			user.setUserName(companyTemp.getCompanyTempName());
			user.setPhone(companyTemp.getPhone());
			user.setEmail(companyTemp.getEmail());
			user.setCreateDate(new Date());
			user.setCompany(company);
			user.setUserFeature(UserFeature.Company_Register.getValue());
			commonDAO.save(user);
			
			PostUser postUser = new PostUser();
			postUser.setUser(user);
			postUser.setPostUserNickname(companyTemp.getCompanyCode());
			postUser.setPostCount(ForumConsts.ZERO);
			postUser.setPostUserExperience(ForumConsts.ZERO);
			postUser.setPostUserPoints(ForumConsts.ZERO);
			postUser.setPostUserGrade(ForumConsts.POST_USER_GRADE_ONE);
			commonDAO.save(postUser);
			
			//设置角色
			RoleUser roleUser = new RoleUser();
			roleUser.setUser(user);
			Role role = new Role();
			role.setRoleId(Constants.REGISTER_USER_ROLE_KEY);
			roleUser.setRole(role);
			commonDAO.save(roleUser);
			return true;
		}catch(Exception e){
			return false;
		}
	}

	public void saveRejectCompanyTemp(CompanyTemp companyTemp) {
		String companyTempId = companyTemp.getCompanyTempId();
		CompanyTemp oldCompanyTemp = commonDAO.load(CompanyTemp.class, companyTempId);
		oldCompanyTemp.setCompanyTempName(companyTemp.getCompanyTempName());
		oldCompanyTemp.setAddress(companyTemp.getAddress());
		oldCompanyTemp.setTel(companyTemp.getTel());
		oldCompanyTemp.setContacts(companyTemp.getContacts());
		oldCompanyTemp.setPhone(companyTemp.getPhone());
		oldCompanyTemp.setEmail(companyTemp.getEmail());
		oldCompanyTemp.setStatus("0");
		commonDAO.update(oldCompanyTemp);
		
	}

	public long getCompanyTempByName(String name) {
		String hql = "from CompanyTemp where is_delete is null";
		HashMap<String,Object> params = new HashMap<String,Object>();
		if(StringUtils.isNotBlank(name)){
			hql += " and companyTempName = :companyTempName";
			params.put("companyTempName", name);
		}
		hql += " and status = :status";
		params.put("status", "1");
		long num =commonDAO.getCount(hql, params);
		return num;
	}
	
	private void deleteCompanyTempByName(CompanyTemp companyTemp) {
		String hql = "from CompanyTemp where is_delete is null";
		HashMap<String,Object> params = new HashMap<String,Object>();
		if(StringUtils.isNotBlank(companyTemp.getCompanyTempName())){
			hql += " and companyTempName = :companyTempName";
			params.put("companyTempName", companyTemp.getCompanyTempName());
		}
		hql += " and companyTempId != :companyTempId";
		params.put("companyTempId", companyTemp.getCompanyTempId());
		List<CompanyTemp> list = commonDAO.queryList(hql, params);
		if(list.size() > 0){
			for(int i=0; i<list.size(); i++){
				CompanyTemp oldCompanyTemp = commonDAO.load(CompanyTemp.class, list.get(i).getCompanyTempId());
				oldCompanyTemp.setIs_delete("Y");
				commonDAO.update(oldCompanyTemp);
			}
		}
	}
	
	public SuccessOrFailure getUserCode(String userCode){
		String hql="from User a where a.userCode = :userCode";
		HashMap<String, Object> params = new HashMap<String,Object>();
		params.put("userCode", userCode);
		User user = commonDAO.get(hql, params);
		if(user != null){
			return SuccessOrFailure.FAILURE("该账号已被注册!");
		}else{
			return SuccessOrFailure.SUCCESS("恭喜,该账号可以使用!");
		}
	}
	
	public SuccessOrFailure validateCompanyCode(String companyCode){
		String hql = "from Company a where a.companyCode = :companyCode";
		HashMap<String, Object> params = new HashMap<String,Object>();
		params.put("companyCode", companyCode);
		Company company = commonDAO.get(hql, params);
		if(company != null){
			return SuccessOrFailure.FAILURE("该企业编码已经存在!");
		}else{
			return SuccessOrFailure.SUCCESS("该企业编码可以使用!");
		}
	}
	
}
