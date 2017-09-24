package com.cnten.bdlocation.corsmaterial.service;

import java.util.HashMap;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cnten.platform.dao.CommonDAO;
import com.cnten.platform.dao.Page;
import com.cnten.bdlocation.constants.CorsAccountConsts;
import com.cnten.po.CorsAccountRepay;
import com.cnten.po.CorsApply;
import com.cnten.po.CorsApplyMaterial;
import com.cnten.vo.ApplyMaterialSupplyVO;
@Service
public class CorsMaterialService {
	@Autowired
	CommonDAO commonDAO;
	
	private static final String APPLY_MATERIAL_SUPPLY_SQL = " select f.busiApproveId,busiApproveType,orderBussinkey,busiApproveTime,busiApproveRlt,accountUsePeriod,"+
			 " applyMaterialState,applyCount,accountType,applyMaterialId,applyContractNo,applyInvoiceNo,isIntoAccount,"+
			 " applyMaterialRemark,companyName,contacts,"+
			 " case busiApproveType when 'open' then '申请完善' when 'repay' then '续费完善' end as busiApproveTypeName,"+
			 " case accountType when 'test' then '试用' else '正式' end as accountTypeName,"+
			 " case applyMaterialState when 'YWS' then '已完善' else '未完善' end as applyMaterialStateName,"+
			 " case bdDeviceAccuracy when 'centimeter' then '厘米级' when 'meter' then '亚米级' else '米级' end as bdDeviceAccuracyName "+
			 " from "+
			 " (  select "+
			 " xk.*,cy.company_name as companyName,cy.contacts as contacts,m.apply_material_id AS applyMaterialId, "+
			 " m.apply_contract_no AS applyContractNo,m.apply_invoice_no AS applyInvoiceNo, "+
			 " m.is_into_account AS isIntoAccount, m.apply_material_remark AS applyMaterialRemark"+
			 " from "+
			 " (  SELECT "+
			 " a.busi_approve_id AS busiApproveId,a.busi_approve_type AS busiApproveType,"+
			 " a.company_id as companyId,a.order_bussinkey AS orderBussinkey, "+
			 " a.busi_approve_time AS busiApproveTime,a.busi_approve_rlt as busiApproveRlt,"+
			 " b.apply_count AS applyCount,b.account_use_period AS accountUsePeriod, "+
			 " b.apply_material_state AS applyMaterialState,b.account_type AS accountType,"+
			 " b.bd_device_accuracy as bdDeviceAccuracy "+
			 " FROM "+
			 " cors_busi_approve a, "+
			 " cors_apply b "+
			 " where a.order_bussinkey = b.cors_apply_id "+
			 " union all"+
			 " SELECT c.busi_approve_id AS busiApproveId,c.busi_approve_type AS busiApproveType,"+
			 " c.order_bussinkey AS orderBussinkey,c.busi_approve_time AS busiApproveTime,"+
			 " c.busi_approve_rlt as busiApproveRlt,c.company_id as companyId, "+
			 " d.account_repay_num AS applyCount,d.account_repay_period AS accountUsePeriod,"+
			 " d.apply_material_state AS applyMaterialState,d.account_repay_type AS accountType,"+
			 " d.accuracy as bdDeviceAccuracy" +
			 " FROM "+
			 " cors_busi_approve c, "+
			 " cors_account_repay d "+
			 " where c.order_bussinkey = d.account_repay_id "+  
			 " ) xk  "+
			 " LEFT JOIN company cy on cy.company_id = companyId "+  
			 " left join cors_apply_material m on m.order_bussinkey = orderBussinkey "+
			 " where busiApproveRlt = 'YES') f";
	
	
	public static final String CORS_ORDER_MATERAIL = " select "+
			" d.orderBussinkey, "+
			" d.companyId, "+
			" d.applyCount, "+
			" d.orderType, "+
			" d.approveState, "+
			" d.busiApproveRlt, d.busiApproveType, "+
			" e.company_name as companyName, "+
			" ca.apply_material_id as applyMaterialId, "+
			" ca.apply_contract_no as applyContractNo, "+
			" ca.apply_invoice_no as applyInvoiceNo, "+
			" ca.is_into_account as isIntoAccount, "+
			" ca.apply_material_remark as applyMaterialRemark "+
			"  from "+
			" 		(SELECT "+
			"     		a.order_bussinkey AS orderBussinkey, "+
			"     		a.company_id AS companyId, "+
			" 			a.busi_approve_rlt as busiApproveRlt, a.busi_approve_type as busiApproveType, "+
			"      		c.account_repay_num AS applyCount, "+
			" 			c.order_type as orderType, "+
			" 			a.approve_state AS approveState "+
						"   FROM "+
						"     	cors_busi_approve a , "+
						"   	cors_account_repay c    "+
						"     where "+
						"     a.order_bussinkey = c.account_repay_id   "+
			"   	union all"+
			"       SELECT "+
			"     		a.order_bussinkey AS orderBussinkey, "+
			"     		a.company_id AS companyId, "+
			" 			a.busi_approve_rlt as busiApproveRlt, a.busi_approve_type as busiApproveType,"+
			"    		c.apply_count AS applyCount, "+
			" 			c.order_type as orderType, "+
			" 			a.approve_state AS approveState "+
						"  	FROM "+
						"     	cors_busi_approve a, "+
						"    	cors_apply c  "+  
						"   where "+
						"   a.order_bussinkey = c.cors_apply_id "+
			"  ) d   "+
			" left join "+
			"    company e  "+
			"       on d.companyId = e.company_id "+
			" left join  "+
			" 	cors_apply_material ca  "+
			" 		on ca.order_bussinkey = d.orderBussinkey";
        	
	public Page getCompanyDataExaminePage(ApplyMaterialSupplyVO applyMaterialSupplyVO, Integer pageIndex, Integer pageSize) {
		String sql = APPLY_MATERIAL_SUPPLY_SQL +  " where 1=1 " ;
		HashMap<String,Object> params = new HashMap<String,Object>();
		sql += " and accountType = :accountType";
		params.put("accountType", CorsAccountConsts.ACCOUNT_TYPE_NORMAL);
		if(applyMaterialSupplyVO.getCompanyName() != null && StringUtils.isNotBlank(applyMaterialSupplyVO.getCompanyName())){
			sql += " and companyName like :companyName";
			params.put("companyName", "%"+applyMaterialSupplyVO.getCompanyName()+"%");
		}
		sql += " order by busiApproveTime desc";
		return commonDAO.sqlGetPage(sql, pageIndex, pageSize, params);
	}
	
	public Map<String,Object> getCompanyDataExamine(String orderBussinkey) {
		String sql = APPLY_MATERIAL_SUPPLY_SQL +  " where orderBussinkey = :orderBussinkey" ;
		HashMap<String,Object> params = new HashMap<String,Object>();
		params.put("orderBussinkey", orderBussinkey);
		return commonDAO.sqlGet(sql, params);
	}
	
	public Map<String,Object> getCorsOrderMaterial(String orderBussinkey){
		String sql = CORS_ORDER_MATERAIL +  " where orderBussinkey = :orderBussinkey "
				+ " and orderType != :orderType"
				+ " and busiApproveRlt = :busiApproveRlt" ;
		HashMap<String,Object> params = new HashMap<String,Object>();
		params.put("orderBussinkey", orderBussinkey);
		params.put("orderType", CorsAccountConsts.CORS_ORDER_TYPE_TRIAL);
		params.put("busiApproveRlt", CorsAccountConsts.APPROVE_RESULT_YES);
		return commonDAO.sqlGet(sql, params);
	}
	
	public void saveMaterials(CorsApplyMaterial corsApplyMaterial ) {
		String orderBussinkey =corsApplyMaterial.getOrderBussinkey();
		String busiApproveType = corsApplyMaterial.getBusiApproveType();
		//更改续费申请资料完善状态
 		if (busiApproveType.equals("repay")){
			CorsAccountRepay corsAccountRepay = commonDAO.load(CorsAccountRepay.class, orderBussinkey);
			corsAccountRepay.setApplyMaterialState(CorsAccountConsts.APPLY_MATERIAL_STATE_YWS);
			commonDAO.update(corsAccountRepay);
		}
		//修改账号申请资料完善 状态
		if (busiApproveType.equals("open")){
			CorsApply corsApply = commonDAO.load(CorsApply.class, orderBussinkey);
			corsApply.setApplyMaterialState(CorsAccountConsts.APPLY_MATERIAL_STATE_YWS);
			commonDAO.update(corsApply);
		}
		commonDAO.save(corsApplyMaterial);
	}
	
	public void updateMaterials(CorsApplyMaterial corsApplyMaterial ) {
			commonDAO.update(corsApplyMaterial);
	}
	
}
