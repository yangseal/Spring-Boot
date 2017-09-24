package com.cnten.platform.system.service;

import java.util.Date;
import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cnten.platform.dao.CommonDAO;
import com.cnten.platform.dao.Page;
import com.cnten.platform.util.ContextUtil;
import com.cnten.platform.util.EncryptUtils;
import com.cnten.platform.util.StringUtil;
import com.cnten.platform.web.Constants;
import com.cnten.platform.web.SuccessOrFailure;
import com.cnten.po.Company;
import com.cnten.po.CorsAccount;
import com.cnten.po.User;

@Service
public class UserService {

	@Autowired
	CommonDAO commonDAO;
	@Autowired
	CompanyService companyService;

	public Page getApprovalUsersPage(User user, Integer pageIndex, Integer pageSize) {
		String hql = "from User where isDelete is null and userName like :userName";
		String userName = "%" + user.getUserName() + "%";
		HashMap<String, Object> params = new HashMap<String, Object>();
		params.put("userName", userName);
		String roleName = "null";
		if(ContextUtil.getCurrentUser().getRole()!=null) roleName = ContextUtil.getCurrentUser().getRole().getRoleName();
		if ("业务管理员".equals(roleName)) {
			hql += " and (approvalStatus is null or approvalStatus='0')";
		} else if ("财务管理员".equals(roleName)) {
			hql += " and approvalStatus='1'";
		} else if ("账号管理员".equals(roleName)) {
			hql += " and approvalStatus='2'";
		}
		if (StringUtils.isNotBlank(user.getCompanyId())) {
			hql += " and company.companyId = :companyId";
			params.put("companyId", user.getCompanyId());
		} else if (!ContextUtil.isSystemUser() && !"CNTEN".equalsIgnoreCase(ContextUtil.getCurrentUser().getCompany().getCompanyCode())) {
			hql += " and company.companyId = :companyId";
			String companyId = ContextUtil.getCurrentUser().getCompany().getCompanyId();
			params.put("companyId", companyId);
		}
		hql += " order by createDate desc";
		return commonDAO.getPage(hql, pageIndex, pageSize, params);
	}
	
	public Page getUsersPage(User user, Integer pageIndex, Integer pageSize) {
		String hql = "from User where isDelete is null and userName like :userName";
		String userName = "%" + user.getUserName() + "%";
//		String approvalStatus = user.getApprovalStatus();
		HashMap<String, Object> params = new HashMap<String, Object>();
		params.put("userName", userName);
//		if(StringUtils.isNotBlank(approvalStatus)){
//			if("0".equals(approvalStatus)) {
//				hql += " and (approvalStatus is null or approvalStatus = :approvalStatus)";
//			} else {
//				hql += " and approvalStatus = :approvalStatus";
//			}
//			params.put("approvalStatus", approvalStatus);
//		}
		if (StringUtils.isNotBlank(user.getCompanyId())) {
			hql += " and company.companyId = :companyId";
			params.put("companyId", user.getCompanyId());
		} else if (!ContextUtil.isSystemUser() && !"CNTEN".equalsIgnoreCase(ContextUtil.getCurrentUser().getCompany().getCompanyCode())) {
			hql += " and company.companyId = :companyId";
			String companyId = ContextUtil.getCurrentUser().getCompany().getCompanyId();
			params.put("companyId", companyId);
		}
		hql += " order by createDate desc";
		return commonDAO.getPage(hql, pageIndex, pageSize, params);
	}
	
	public Page getRoleUsersPage(User user, Integer pageIndex, Integer pageSize){
		String sql = "SELECT cc.*,b.company_name AS companyName FROM "+
				" ( "+
				" SELECT "+
				" user_id AS userId,"+
				"  create_date AS createDate,"+
				" is_delete AS isDelete,"+
				" PASSWORD,"+
				" phone,"+
				" user_code AS userCode,"+
				" user_name AS userName,"+
				" company_id AS companyId,"+
				" is_company_admin AS isCompanyAdmin,"+
				" approval_status AS approvalStatus,"+
				"  email,"+
				"  user_feature AS userFeature,"+
				" plain_pwd AS plainPwd,"+
				"  company_org_id AS companyOrgId "+
				" FROM"+
				"  user a "+
				" WHERE is_delete IS NULL "+
				" AND a.user_id IN "+
				"  (SELECT "+
				"    user_id "+
				"  FROM"+
				"  role_user a "+
				"  WHERE a.role_id = :roleId) ";
		
		HashMap<String,Object> params = new HashMap<String,Object>();
		params.put("roleId", user.getRole().getRoleId());
		if(StringUtils.isNotBlank(user.getUserName())){
			sql += " and user_name like :userName";
			params.put("userName", "%" + user.getUserName() + "%");
		} else if (StringUtils.isNotBlank(user.getCompanyId())) {
			sql += " and company_id = :companyId";
			params.put("companyId", user.getCompanyId());
		} else if (!ContextUtil.isSystemUser() && !"CNTEN".equalsIgnoreCase(ContextUtil.getCurrentUser().getCompany().getCompanyCode())) {
			sql += " and company_id = :companyId";
			String companyId = ContextUtil.getCurrentUser().getCompany().getCompanyId();
			params.put("companyId", companyId);
		}
		sql += " ) cc ";
		sql += " LEFT JOIN company b ON cc.companyId = b.company_id ";
		sql += " ORDER BY createDate DESC";
		
		return commonDAO.sqlGetPage(sql, pageIndex, pageSize, params);
	}

	public User getUser(String userId) {
		return commonDAO.get(User.class, userId);
	}
	
	public User getUserByCompany(String companyId){
		String hql = "from User a where a.company.companyId = :companyId";
		HashMap<String,Object> params = new HashMap<String,Object>();
		params.put("companyId", companyId);
		return (User)commonDAO.get(hql, params);
	}

	public User login(String companyCode, String userCode, String password) {
		User user = null;
		String password1 = EncryptUtils.encrypt(password);
		String password2 = EncryptUtils.encrypt(userCode+password);
		String hql = "from User where isDelete is null and userCode = ?"
				+ " and (upper(password) = ? or upper(password) = ?)";
		if(StringUtils.isNotEmpty(companyCode)) {
			hql += " and company.companyCode = ?";
			user = commonDAO.getByVariableParam(hql, userCode, password1.toUpperCase(),password2.toUpperCase(),companyCode);
		} else {
			user = commonDAO.getByVariableParam(hql, userCode, password1.toUpperCase(),password2.toUpperCase());
		}
		
		return user;
	}
	
	public CorsAccount corsLogin(String userCode,String password){
		CorsAccount corsAccount = null;
		
		String hql = "from CorsAccount where isDelete is null and corsAccountCode= ? "
				+ " and corsAccountPwd = ? ";
		corsAccount = commonDAO.getByVariableParam(hql, userCode,password);
		
		return corsAccount;
	}

	public boolean isDuplicateUser(User user) {
		if (StringUtils.isNotBlank(user.getUserId())) {
			return false;
		}
		String hql = "from User where isDelete is null and userCode = ? and company.companyId = ?";
		String userCode = user.getUserCode();
		String companyId = user.getCompanyId();
		User oldUser = commonDAO.getByVariableParam(hql, userCode, companyId);
		if (oldUser != null) {
			return true;
		}
		return false;
	}

	public void saveUser(User user) {
		if (StringUtils.isEmpty(user.getCompanyId())) {
			user.setCompany(null);
		} else {
			user.setCompany(new Company(user.getCompanyId()));
		}
		
		String userId = user.getUserId();
		if (StringUtils.isEmpty(userId)) { 
			String password = EncryptUtils.encrypt(user.getUserCode()+user.getPassword());
			user.setPassword(password);
			user.setCreateDate(new Date());
			commonDAO.save(user);
		} else {
			User oldUser = commonDAO.load(User.class, userId);
			oldUser.setUserName(user.getUserName());
			oldUser.setUserCode(user.getUserCode());
			oldUser.setPhone(user.getPhone());
			oldUser.setCompany(user.getCompany());
			oldUser.setIsCompanyAdmin(user.getIsCompanyAdmin());
			commonDAO.update(oldUser);
		}
	}

	public void deleteUser(String userIds) {
		String[] userIdArray = userIds.split(",");
		for (String userId : userIdArray) {
			User oldUser = commonDAO.load(User.class, userId);
			oldUser.setIsDelete("Y");
			commonDAO.update(oldUser);
		}
	}

	// added by lanj 2016-06-27 重置密码
	public void updatePassword(String userIds) {
		String[] userIdArray = userIds.split(",");
		for (String userId : userIdArray) {
			User oldUser = commonDAO.load(User.class, userId);
			String password = EncryptUtils.encrypt(oldUser.getUserCode()+"123456");
			oldUser.setPassword(password);
			commonDAO.update(oldUser);
		}
	}

	public SuccessOrFailure updatePassword(String oldPassword, String newPassword, HttpServletRequest request) {
		User user = (User) request.getSession().getAttribute(Constants.USER_SESSION_KEY);
		oldPassword = EncryptUtils.encrypt(user.getUserCode()+oldPassword);
		if (!oldPassword.equalsIgnoreCase(user.getPassword())) {
			return SuccessOrFailure.FAILURE("旧密码输入有误");
		}
		newPassword = EncryptUtils.encrypt(user.getUserCode()+newPassword);
		if(oldPassword.equalsIgnoreCase(newPassword)) {
			return SuccessOrFailure.FAILURE("新旧密码相同");
		}
		user.setPassword(newPassword);
		commonDAO.update(user);
		return SuccessOrFailure.SUCCESS;
	}
	
	public List<User> getUsers() {
		String hql = "from User where isDelete is null";
		HashMap<String, Object> params = new HashMap<String, Object>();
		hql += " and company.companyId = :companyId)";
		String companyId = ContextUtil.getCurrentUser().getCompany().getCompanyId();
		if("SYS".equals(ContextUtil.getCurrentUser().getCompany().getCompanyCode())) {
			Company company = new Company();
			company.setCompanyCode("CNTEN");
			companyId = companyService.getCompanyId(company);
		}
		params.put("companyId", companyId);
		List<User> users = commonDAO.queryList(hql, params);
		return users;
	}
	
	public void saveApproval(String recordId, String status) {
		if (StringUtils.isNotBlank(recordId) && StringUtils.isNotBlank(status)) {
			User user = commonDAO.load(User.class, recordId);
			user.setApprovalStatus(status);
			commonDAO.update(user);
		}
	}
}
