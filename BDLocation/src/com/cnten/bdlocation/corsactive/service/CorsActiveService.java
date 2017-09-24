package com.cnten.bdlocation.corsactive.service;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cnten.bdlocation.constants.CorsAccountConsts;
import com.cnten.platform.dao.CommonDAO;
import com.cnten.platform.dao.Page;
import com.cnten.platform.dao.PageBean;
import com.cnten.platform.web.SuccessOrFailure;
import com.cnten.po.CorsAccount;
import com.cnten.po.CorsAccountActive;
import com.cnten.po.CorsActiveRel;

@Service
public class CorsActiveService {
	private static final Logger log4j = LoggerFactory.getLogger(CorsActiveService.class);
	@Autowired
	CommonDAO commonDAO;
	
	public Page getActiveByPage(CorsAccountActive corsActive, Integer pageIndex, Integer pageSize) {
		String hql = " from CorsAccountActive a where 1=1 ";
		HashMap<String,Object> params = new HashMap<String,Object>();
		if(corsActive.getCompany() != null && StringUtils.isNotBlank(corsActive.getCompany().getCompanyName())) {
			hql += " and a.company.companyName like :companyName";
			params.put("companyName", "%" + corsActive.getCompany().getCompanyName() + "%");
		}
		if(StringUtils.isNotBlank(corsActive.getAccountActiveState())){
			hql += " and a.accountActiveState = :accountActiveState ";
			params.put("accountActiveState", corsActive.getAccountActiveState());
		}
//		SimpleDateFormat format = new SimpleDateFormat ("yyyy-MM-dd"); 
//		String nowDate = format.format(new Date());
//		hql += " and DATE_FORMAT(a.accountActiveTime,'%Y-%m-%d') < :nowDate ";
//		params.put("nowDate", nowDate);
		hql += " order by accountActiveTime desc";
		return commonDAO.getPage(hql, pageIndex, pageSize, params);
	}
	
	public Page getCorsAccountActive(String orderBussinkey, Integer pageIndex, Integer pageSize ) {
		String sql = " SELECT "+
					 " b.cors_account_id AS corsAccountId, "+
					 " b.cors_account_code AS corsAccountCode, "+
					 " c.oam_area_name AS oamArea, "+
					 " b.bd_device_accuracy AS bdDeviceAccuracy, "+
					 " case b.bd_device_accuracy when 'centimeter' then '厘米级' "+  
					 " when 'meter' then '亚米级' "+  
					 " else '米级' End  as  bdDeviceAccuracyName, "+
					 " b.cors_account_type AS corsAccountType, "+
					 " case b.cors_account_type when 'formal' then '正式账号'"+ 
					 " else '试用账号' End  as  corsAccountTypeName, "+
					 " b.cors_account_period AS corsAccountPeriod, "+
					 " b.bd_device AS bdDevice, "+
					 " b.bd_device_sn AS bdDeviceSn, "+
					 " b.cors_account_state AS corsAccountState, "+
					 " b.cors_account_stage AS corsAccountStage "+
					 " FROM "+
					 " cors_active_rel a "+
					 " LEFT JOIN cors_account b ON a.cors_account_id = b.cors_account_id "+
					 " LEFT JOIN oam_area c ON c.oam_area_id = b.oam_area_id "+
					 " where a.account_active_id = :orderBussinkey";	
					
		HashMap<String,Object> params = new HashMap<String,Object>();
		params.put("orderBussinkey", orderBussinkey);
		List<Map<String, Object>> dataList = commonDAO.sqlQueryList(sql, params);
		
		Page page = new Page();
		PageBean pagebean = new PageBean();
		pagebean.setCount(dataList.size());
		if(pageIndex != null) pagebean.setPageIndex(pageIndex);
		if(pageSize != null) pagebean.setPageSize(pageSize);
		page.setPageBean(pagebean);
		page.setResult(dataList);
		return page;
	}
	
	private void updateCorsAccountActiveState(CorsAccountActive corsActive){
		if(CorsAccountConsts.ACCOUNT_ACTIVE_DEAL_STATE_1.equals(corsActive.getAccountActiveState()))
			return;
		
		boolean updateFlag = true;
		if(CorsAccountConsts.ACCOUNT_ACTIVE_TYPE_ACTIVE.equals(corsActive.getAccountActiveType())){ //激活
			for (CorsActiveRel corsActiveRel : corsActive.getActiveRelList()) {
				if(CorsAccountConsts.ACCOUNT_STAGE_ACTIVE_REQUEST.equals(corsActiveRel.getCorsAccount().getCorsAccountStage())){
					updateFlag = false;
					break;
				}
			}
		}
		
		if(updateFlag){
			corsActive.setAccountActiveState(CorsAccountConsts.ACCOUNT_ACTIVE_DEAL_STATE_1);
			commonDAO.update(corsActive);
		}
	}
	
	/**
	 * 账号激活操作(申请激活、续费激活)
	 * 1. 账号激活表中 激活状态 给为 激活已处理
	 * 2. 申请激活
	 *		根据	  cors_account_period(使用期限) 设置生效时间、失效时间 、账号状态、账号操作阶段等
	 * 3. 续费激活
	 * 		正式账号：
	 * 	  	    1.账号未激活   	修改使用期限    更改操作阶段(续费)
	 * 		    2.账号 正常(即将过期)		取当前时间  + 续费期限 = 失效时间、账号操作阶段
	 * 		    3.账号过期				生效时间、取当前时间 + 续费期限 = 失效时间、 账号状态、账号操作阶段
	 * 
	 * 		试用账号：
	 * 			1.未激活			修改使用期限    更改操作阶段(续费)
	 * 			2.账号 正常(即将过期)		取当前时间  + 续费期限 = 失效时间、账号操作阶段
	 * 			3.账号过期				生效时间、取当前时间 + 续费期限 = 失效时间、 账号状态、账号操作阶段
	 * @param corsActiveId
	 */
	public SuccessOrFailure updateAccountActive(String corsActiveId,String corsAccountIds,String corsActiveType){
		try {
			CorsAccountActive corsActive = null;
			if(CorsAccountConsts.ACCOUNT_ACTIVE_TYPE_ACTIVE.equals(corsActiveType)){
				corsActive = commonDAO.get(CorsAccountActive.class, corsActiveId);
			} else {
				String hql = "from CorsAccountActive a where a.orderBussinkey = :orderBussinkey";
				HashMap<String,Object> params = new HashMap<String,Object>();
				params.put("orderBussinkey", corsActiveId);
				corsActive = commonDAO.get(hql, params);
			}
			
			//1.账号激活表中 激活状态 给为 激活已处理
			if(CorsAccountConsts.ACCOUNT_ACTIVE_DEAL_STATE_1.equals(corsActive.getAccountActiveState())){
				return SuccessOrFailure.SUCCESS("该申请下的账号均已激活,无需重复操作!");
			}
			
			String[] corsAccountIdArr = corsAccountIds.split(",");
			
			
			for(int i=0,l=corsAccountIdArr.length; i<l; i++){
				
				CorsAccount corsAccount = commonDAO.get(CorsAccount.class, corsAccountIdArr[i]);
				//只有未激活 才需要激活操作
				if(CorsAccountConsts.ACCOUNT_STATE_UNACTIVE.equals(corsAccount.getCorsAccountState())){
					corsAccount.setCorsAccountState(CorsAccountConsts.ACCOUNT_STATE_NORMAL);
					
					corsAccount.setCorsAccountStage(CorsAccountConsts.ACCOUNT_STAGE_ACTIVED);
					
					Date nowDate = new Date();  
					Calendar resultDate = Calendar.getInstance();  
					resultDate.setTime(nowDate);
					if(CorsAccountConsts.ACCOUNT_TYPE_TEST.equals(corsAccount.getCorsAccountType())){
						resultDate.add(Calendar.MONTH, CorsAccountConsts.ACCOUNT_TYPE_TEST_PERIOD);
					}else {
						resultDate.add(Calendar.YEAR,corsAccount.getCorsAccountPeriod());
					}
					Date afterPeriod = resultDate.getTime();  
					corsAccount.setEffectiveDate(nowDate);
					corsAccount.setExprieDate(afterPeriod);
					commonDAO.update(corsAccount);
				}  
			}
			
			//处理激活数据状态(CorsAccountActive)
			 updateCorsAccountActiveState(corsActive);
			
			return SuccessOrFailure.SUCCESS("操作成功!");
		} catch(Exception e) {
			log4j.info("---异常错误---：" + e.getMessage());
		}
		return null;
	}
}
