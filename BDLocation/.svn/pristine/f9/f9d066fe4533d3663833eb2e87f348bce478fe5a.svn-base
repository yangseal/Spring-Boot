package com.cnten.bdlocation.accountView.service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cnten.platform.dao.CommonDAO;
import com.cnten.platform.dao.Page;
import com.cnten.bdlocation.constants.CorsAccountConsts;
import com.cnten.platform.util.ContextUtil;
import com.cnten.platform.util.StringUtil;
import com.cnten.platform.web.SuccessOrFailure;
import com.cnten.po.Company;
import com.cnten.po.CorsAccount;
import com.cnten.po.CorsAccountActive;
import com.cnten.po.CorsActiveRel;
import com.cnten.po.CorsRepayTemp;

@Service
public class AccountViewService {
	private static final Logger log4j = LoggerFactory.getLogger(AccountViewService.class);
	@Autowired
	CommonDAO commonDAO;
	
	public Page getAccountViewsPage(CorsAccount corsAccount, Integer pageIndex, Integer pageSize){
		String hql = "from CorsAccount as a where isDelete is null";
		HashMap<String,Object> params = new HashMap<String,Object>();
		if(corsAccount.getCompany() != null && StringUtils.isNotBlank(corsAccount.getCompany().getCompanyId())){
			hql += " and a.company.companyId = :companyId";
			params.put("companyId", corsAccount.getCompany().getCompanyId());
		} else if (!ContextUtil.isSystemUser() && !"CNTEN".equalsIgnoreCase(ContextUtil.getCurrentUser().getCompany().getCompanyCode())) {
			hql += " and company.companyId = :companyId";
			String companyId = ContextUtil.getCurrentUser().getCompany().getCompanyId();
			params.put("companyId", companyId);
		} 
		if(corsAccount.getCorsAccountState() != null && StringUtils.isNotBlank(corsAccount.getCorsAccountState())) {
			hql += " and a.corsAccountState = :corsAccountState";
			params.put("corsAccountState", corsAccount.getCorsAccountState());
		} 
		if(corsAccount.getBdDeviceAccuracy() != null && StringUtils.isNotBlank(corsAccount.getBdDeviceAccuracy())) {
			hql += " and a.bdDeviceAccuracy = :bdDeviceAccuracy";
			params.put("bdDeviceAccuracy", corsAccount.getBdDeviceAccuracy());
		}
		hql += " and a.corsFeature = :corsFeature order by a.corsCreateDate desc";
		params.put("corsFeature", CorsAccountConsts.CORS_FEATURE_REALCORS);
		return commonDAO.getPage(hql, pageIndex, pageSize, params);
	}
	
	public SuccessOrFailure getCorsAccountState(String corsAccountId) {
		return null;
	}
	
	/**
	 * 在激活 完成后不能进行 绑定区域操作(仅限正式账号)
	 * 激活 完成后 	可以进行 绑定区域操作(试用账号)
	 * @param corsAccount
	 * @return
	 */
	public SuccessOrFailure saveCorsAccount(CorsAccount corsAccount) {
		try{
			String corsAccountId = corsAccount.getCorsAccountId();
			CorsAccount oldCorsAccount = commonDAO.load(CorsAccount.class, corsAccountId);
			String corsAccountStage = oldCorsAccount.getCorsAccountStage();
			if(corsAccount.getOamArea() != null && StringUtils.isNotBlank(corsAccount.getOamArea().getOamAreaId())) {
				if(CorsAccountConsts.ACCOUNT_STAGE_ACTIVED.equals(corsAccountStage))
					return SuccessOrFailure.SUCCESS("账号激活完成,区域不可更改!");
				oldCorsAccount.setOamArea(corsAccount.getOamArea());
			}
			if(corsAccount.getRemark() != null && StringUtils.isNotBlank(corsAccount.getRemark())) {
				oldCorsAccount.setRemark(corsAccount.getRemark());
			}
			if(corsAccount.getBdDevice() != null && StringUtils.isNotBlank(corsAccount.getBdDevice())) {
				if(CorsAccountConsts.ACCOUNT_STAGE_ACTIVED.equals(corsAccountStage) 
						&& CorsAccountConsts.ACCOUNT_TYPE_NORMAL.equals(corsAccount.getCorsAccountType())){
					return SuccessOrFailure.SUCCESS("账号激活完成,设备不可更改!");
				}
				oldCorsAccount.setBdDevice(corsAccount.getBdDevice());
			}
			if(corsAccount.getBdDeviceSn() != null && StringUtils.isNotBlank(corsAccount.getBdDeviceSn())) {
				oldCorsAccount.setBdDeviceSn(corsAccount.getBdDeviceSn());
			}
			commonDAO.update(oldCorsAccount);
			
	
		}catch(Exception e) {
			log4j.info("-----出错了："+e);
		}
		return null;
	}
	
	//获取CorsAccountActive对象
	public HashMap<String,Object> getCorsAccountActive(Company company,String corsAccountType) {
		 HashMap<String,Object> obj  = null;
		try{
			SimpleDateFormat format = new SimpleDateFormat ("yyyy-MM-dd"); 
			String nowDate = format.format(new Date());
			String hql = "select a.* from cors_account_active a "
					+ "where DATE_FORMAT(a.account_active_time,'%Y-%m-%d') = :nowDate "
					+ "and company_id= :companyId "
					+ "and cors_account_type = :corsAccountType";
			HashMap<String,Object> params = new HashMap<String,Object>();
			params.put("nowDate", nowDate);
			params.put("companyId", company.getCompanyId());
			params.put("corsAccountType", corsAccountType);
			obj = (HashMap<String, Object>) commonDAO.sqlGet(hql, params);
		}catch(Exception e){
			System.out.println(e);
		}
		return obj;
	}
	/**
	 * 查询当前是否以后激活申请如果有的话，直接更新个数,添加关联表中数据
	 * @param corsAccountId
	 * @return
	 */
	public SuccessOrFailure saveActiveApply(String corsAccountId) {
		try {
			SuccessOrFailure corsState = getAccountState(corsAccountId,CorsAccountConsts.ACCOUNT_ACTIVE_TYPE_ACTIVE);
			if(corsState != null)
				return corsState;
			
			CorsAccount corsAccount = commonDAO.load(CorsAccount.class, corsAccountId);
			
			//检测是否已有当天是否已有申请
			HashMap<String,Object> activeObj = getCorsAccountActive(corsAccount.getCompany(),corsAccount.getCorsAccountType());  
			
			CorsAccountActive accountActive = null;
			
			String accountActiveId = "";
			if(activeObj != null) {
				accountActiveId = (String) activeObj.get("account_active_id");
				accountActive = commonDAO.load(CorsAccountActive.class, accountActiveId);
				accountActive.setAccountActiveNum(accountActive.getAccountActiveNum()+1);
				accountActive.setAccountActiveState(CorsAccountConsts.ACCOUNT_ACTIVE_DEAL_STATE_0);
				commonDAO.update(accountActive);
			} else {
				accountActive = new CorsAccountActive();
				accountActive.setCompany(corsAccount.getCompany());
				accountActive.getAccountActiveId();
				accountActive.setAccountActiveNum(1);
				accountActive.setAccountActiveType(CorsAccountConsts.ACCOUNT_ACTIVE_TYPE_ACTIVE);
				accountActive.setAccountActiveState(CorsAccountConsts.ACCOUNT_ACTIVE_DEAL_STATE_0);
				accountActive.setCorsAccountType(corsAccount.getCorsAccountType());
				commonDAO.save(accountActive);
				accountActiveId = accountActive.getAccountActiveId();
			}
			
			CorsActiveRel busiRel = new CorsActiveRel();
			busiRel.setCorsAccount(corsAccount);
			busiRel.setCorsActive(accountActive);
			commonDAO.save(busiRel);
			
			//修改账号操作阶段
			corsAccount.setCorsAccountStage(CorsAccountConsts.ACCOUNT_STAGE_ACTIVE_REQUEST);
			commonDAO.update(corsAccount);
			return SuccessOrFailure.SUCCESS("激活申请成功!");
		} catch (Exception e) {
			SuccessOrFailure.FAILURE("激活申请失败");
		}
		return null;
	}
	
	//获取CorsAccountActive对象
	/**
	 * 根据公司、使用期限、申请状态(已提交)进行查询
	 * @param company
	 * @param userPeriod
	 * @return
	 */
	public HashMap<String,Object> getCorsAccountRepay(Integer userPeriod,String accountRepayType,String accountAccuracy) {
		 HashMap<String,Object> obj  = null;
		try{
//			SimpleDateFormat format = new SimpleDateFormat ("yyyy-MM-dd"); 
//			String nowDate = format.format(new Date());
			String hql = "select a.* from cors_account_repay a"
					+ " where DATE_FORMAT(a.account_repay_time,'%Y-%m-%d') = :nowDate"
					+ " and company_id = :companyId"
					+ " and account_repay_period = :accountRepayPeriod"
					+ " and account_repay_state = :accountRepayState"
					+ " and account_repay_type = :accountRepayType"
					+ " and account_accuracy = :accountAccuracy";;
			HashMap<String,Object> params = new HashMap<String,Object>();
			params.put("nowDate", StringUtil.formatDate(new Date()));
			params.put("companyId", ContextUtil.getCurrentUser().getCompany().getCompanyId());
			params.put("accountRepayPeriod", userPeriod);
			params.put("accountRepayState", CorsAccountConsts.BUSI_APPROVE_STATE_SUBMIT);
			params.put("accountRepayType", accountRepayType);
			params.put("accountAccuracy", accountAccuracy);
			obj = (HashMap<String, Object>) commonDAO.sqlGet(hql, params);
		}catch(Exception e){
			System.out.println(e);
		}
	
		return obj;
	}
		
	public void saveRepayApply(CorsRepayTemp corsRepayTemp){
		commonDAO.save(corsRepayTemp);
	    CorsAccount corsAccount = commonDAO.get(CorsAccount.class, corsRepayTemp.getCorsAccount().getCorsAccountId());
	    corsAccount.setCorsAccountStage(CorsAccountConsts.ACCOUNT_STAGE_REPAY_UNREQUEST);
	    commonDAO.update(corsAccount);
	}
	
	public List <CorsRepayTemp> getCorsRepayTemp(){
		String hql = "from CorsRepayTemp a where a.corsAccount.company = :company and a.isDelete is null";
		HashMap<String, Object> params = new HashMap<String,Object>();
		params.put("company", ContextUtil.getCurrentUser().getCompany());
		List <CorsRepayTemp> corsRepayTemps = commonDAO.queryList(hql, params);
		return corsRepayTemps;
	}
	
	public void deleteRepayApply(String corsRepayTempId){
		CorsRepayTemp corsRepayTemp = commonDAO.get(CorsRepayTemp.class, corsRepayTempId);
		CorsAccount corsAccount = commonDAO.get(CorsAccount.class, corsRepayTemp.getCorsAccount().getCorsAccountId());
		corsAccount.setCorsAccountStage(CorsAccountConsts.ACCOUNT_STAGE_ACTIVED);
		commonDAO.update(corsAccount);
		corsRepayTemp.setIsDelete(CorsAccountConsts.IS_DELETE);
		commonDAO.update(corsRepayTemp);
	}
	
	public Map<String, Object> getCorsStatistics(){
		Map<String,Object> rltMap = new HashMap<String,Object>();
		rltMap.put("companyCorsStatistic", getCompanyCorsStatistic());
		rltMap.put("corsType", getCorsTypes());
		rltMap.put("corsPrecision", getCorsPrecision());
		rltMap.put("corsCompanyType", getCorsCompanyType());
		return rltMap;
	}
	
	public CorsAccount getCorsAccount(String corsAccountId) {
		return commonDAO.get(CorsAccount.class, corsAccountId);
	}
	
	private List<Map<String,Object>> getCompanyCorsStatistic(){
		String sql = " select distinct a.company_id as companyId,e.company_name as companyName, "+
				" (select count(*) from cors_account b where b.is_delete is null and b.company_id = a.company_id) companyCorsNumber,"+
				" (select count(*) from cors_account c where c.is_delete is null and c.cors_account_state = 'unactive' and c.company_id = a.company_id) unactive,"+
				" (select count(*) from cors_account d where d.is_delete is null and d.cors_account_state != 'unactive' and d.company_id = a.company_id) active"+
				" from cors_account a "+
				" left join company e on a.company_id = e.company_id order by companyCorsNumber desc";
		return commonDAO.sqlQueryList(sql, null);
	}
	
	private List<Map<String,Object>> getCorsTypes(){
		String sql = " select count(*) as corsNumber, 'formal' as corsAccountType from cors_account a where a.is_delete is null and a.cors_account_type = :corsAccountType1 "+ 
					 " union all "+
					 " select count(*) as corsNumber,'test' as corsAccountType  from cors_account a where a.is_delete is null and a.cors_account_type = :corsAccountType2 ";
		HashMap<String,Object> params = new HashMap<String,Object>();
		params.put("corsAccountType1", CorsAccountConsts.ACCOUNT_TYPE_NORMAL);
		params.put("corsAccountType2", CorsAccountConsts.ACCOUNT_TYPE_TEST);
		List<Map<String,Object>> search = commonDAO.sqlQueryList(sql, params);
		for (Map<String, Object> map : search) {
			map.put("corsTypeName", StringUtil.getDictName((String)map.get("corsAccountType"), CorsAccount.corsAccountTypeDictStatement));
		}
		return search;
	}
	
	private List<Map<String,Object>> getCorsPrecision(){
		String sql = " select count(*) as corsNumber, 'centimeter' as corsPrecision from cors_account a where a.is_delete is null and a.bd_device_accuracy = :bdDeviceAccuracy1 "+ 
					 " union all "+ 
					 " select count(*) as corsNumber,'meter' as corsPrecision  from cors_account a where a.is_delete is null and a.bd_device_accuracy = :bdDeviceAccuracy2 "+ 
					 " union all "+ 
					 " select count(*) as corsNumber,'milevel' as corsPrecision  from cors_account a where a.is_delete is null and a.bd_device_accuracy = :bdDeviceAccuracy3  ";
		HashMap<String,Object> params = new HashMap<String,Object>();
		params.put("bdDeviceAccuracy1", CorsAccountConsts.ACCOUNT_NET_PRECISION_centimeter);
		params.put("bdDeviceAccuracy2", CorsAccountConsts.ACCOUNT_NET_PRECISION_meter);
		params.put("bdDeviceAccuracy3", CorsAccountConsts.ACCOUNT_NET_PRECISION_mi);
		List<Map<String,Object>> search = commonDAO.sqlQueryList(sql, params);
		for (Map<String, Object> map : search) {
			map.put("deviceAccuracyName", StringUtil.getDictName((String)map.get("corsPrecision"), CorsAccount.bdDeviceAccuracyDictStatement));
		}
		return search;
	}
	
	private List<Map<String,Object>> getCorsCompanyType(){
		String sql = " select count(*) as companyNumber, IFNULL(a.company_material_state, :companyMaterialState) as companyType from company a where a.is_delete is null and a.company_material_state = :companyMaterialState "+  
				     " union all "+
				     " select count(*) as companyNumber, IFNULL(a.company_material_state, :companyMaterialState0) as companyType  from company a where a.is_delete is null and a.company_material_state != :companyMaterialState  ";
		HashMap<String,Object> params = new HashMap<String,Object>();
		params.put("companyMaterialState", CorsAccountConsts.ACCOUNT_STATE_EXAMINE_PASS);
		params.put("companyMaterialState0", CorsAccountConsts.ACCOUNT_STATE_EXAMINE_NOTE);
		List<Map<String,Object>> search = commonDAO.sqlQueryList(sql, params);
		for (Map<String, Object> map : search) {
			map.put("companyTypeName", StringUtil.getDictName((String)map.get("companyType"), Company.stateDictStatementDictStatement));
		}
		return search;
	}

	public SuccessOrFailure getAccountState(String corsAccountId,String requestBusiType) {
		try {
			CorsAccount corsAccount = commonDAO.get(CorsAccount.class, corsAccountId);
			if(CorsAccountConsts.ACCOUNT_STATE_UNACTIVE.equals(corsAccount.getCorsAccountState())&& CorsAccountConsts.ACCOUNT_ACTIVE_TYPE_REPAY.equals(requestBusiType)){
				return SuccessOrFailure.SUCCESS("账号未激活,无法进行续费操作!");
			}
			if(!CorsAccountConsts.ACCOUNT_STATE_UNACTIVE.equals(corsAccount.getCorsAccountState())
					&& CorsAccountConsts.ACCOUNT_ACTIVE_TYPE_ACTIVE.equals(requestBusiType)) {
				return SuccessOrFailure.SUCCESS("账号已经激活,无需再次激活!");
			} else if(CorsAccountConsts.ACCOUNT_STAGE_ACTIVE_REQUEST.equals(corsAccount.getCorsAccountStage())
					&& CorsAccountConsts.ACCOUNT_ACTIVE_TYPE_ACTIVE.equals(requestBusiType)) {
				return SuccessOrFailure.SUCCESS("激活申请已提交,无需重复操作!");
			} else if(CorsAccountConsts.ACCOUNT_STAGE_REPAY_UNREQUEST.equals(corsAccount.getCorsAccountStage())
					&& CorsAccountConsts.ACCOUNT_ACTIVE_TYPE_REPAY.equals(requestBusiType)) {  
				return SuccessOrFailure.SUCCESS("已加入续费清单,无需重复操作!");
			} 
		}catch(Exception e) {
			return SuccessOrFailure.FAILURE(e.getMessage());
		}
		return null;
	}
}
