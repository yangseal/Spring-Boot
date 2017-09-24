package com.cnten.bdlocation.accountView.controller;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cnten.bdlocation.accountView.service.AccountViewService;
import com.cnten.bdlocation.constants.CorsAccountConsts;
import com.cnten.platform.dao.Page;
import com.cnten.platform.web.SuccessOrFailure;
import com.cnten.po.CorsAccount;
import com.cnten.po.CorsRepayTemp;


@Controller
@RequestMapping(value = "/accountView")
public class AccountViewController {
	private static final Logger log4j = LoggerFactory.getLogger(AccountViewController.class);
	@Autowired
	private AccountViewService accountViewService;
	
	@Autowired
	//private CorsAccountService corsAccountService;
	
	@RequestMapping(value="/showAccountViews")
	public void showAccountViews(){
	}
	
	@RequestMapping(value="/showAccountStatistics")
	public void showAccountStatistics(){
	}
	
	@RequestMapping(value="/queryAccountViews")
	public void queryAccountViews(CorsAccount corsAccount,Integer pageIndex, Integer pageSize, Model model){
		Page page = accountViewService.getAccountViewsPage(corsAccount, pageIndex, CorsAccountConsts.FRONT_DISPLAY_PAGER_SIZE);
		model.addAttribute(page);
	}
	
	@RequestMapping(value="/showRegion")
	public void showRegion(String corsAccountId, Model model){
		CorsAccount corsAccount = accountViewService.getCorsAccount(corsAccountId);
		model.addAttribute(corsAccount);
	}
	
	@RequestMapping(value="/showDevice")
	public void showDevice(String corsAccountId, Model model){
		CorsAccount corsAccount = accountViewService.getCorsAccount(corsAccountId);
		model.addAttribute(corsAccount);
	}
	@RequestMapping(value="/showRepay")
	public void showRepay(String corsAccountId, Model model) {
		CorsAccount corsAccount = accountViewService.getCorsAccount(corsAccountId);
		model.addAttribute(corsAccount);
	}
	
	@ResponseBody
	@RequestMapping(value="/saveRegion")
	public SuccessOrFailure saveRegion(CorsAccount corsAccount) {
		try{
			if(!CorsAccountConsts.ACCOUNT_STAGE_UNACTIVE.equals(corsAccount.getCorsAccountStage())
				&& CorsAccountConsts.ACCOUNT_TYPE_NORMAL.equals(corsAccount.getCorsAccountType()))
				return SuccessOrFailure.SUCCESS("提交激活申请后,应用区域将不能改变!");
			
			SuccessOrFailure result = accountViewService.saveCorsAccount(corsAccount);
			if(result == null){
				return SuccessOrFailure.SUCCESS("保存成功!");
			} else {
				return result;
			}
			
		}catch(Exception e){
			return SuccessOrFailure.FAILURE(e.getMessage());
		}
		
	}
	
//	@ResponseBody
//	@RequestMapping(value="/validateSt")
//	public SuccessOrFailure getAccountState(String corsAccountId,String requestBusiType) {
//		try {
//			CorsAccount corsAccount = corsAccountService.getCorsAccount(corsAccountId);
//			if(CorsAccountConsts.ACCOUNT_STATE_UNACTIVE.equals(corsAccount.getCorsAccountState())&& CorsAccountConsts.ACCOUNT_ACTIVE_TYPE_REPAY.equals(requestBusiType)){
//				return SuccessOrFailure.SUCCESS("账号未激活,无法进行续费操作!");
//			}
//			if(!CorsAccountConsts.ACCOUNT_STATE_UNACTIVE.equals(corsAccount.getCorsAccountState())
//					&& CorsAccountConsts.ACCOUNT_ACTIVE_TYPE_ACTIVE.equals(requestBusiType)) {
//				return SuccessOrFailure.SUCCESS("账号已经激活,无需再次激活!");
//			} else if(CorsAccountConsts.ACCOUNT_STAGE_ACTIVE_REQUEST.equals(corsAccount.getCorsAccountStage())
//					&& CorsAccountConsts.ACCOUNT_ACTIVE_TYPE_ACTIVE.equals(requestBusiType)) {
//				return SuccessOrFailure.SUCCESS("激活申请已提交,无需重复操作!");
//			} else if(CorsAccountConsts.ACCOUNT_STAGE_REPAY_UNREQUEST.equals(corsAccount.getCorsAccountStage())
//					&& CorsAccountConsts.ACCOUNT_ACTIVE_TYPE_REPAY.equals(requestBusiType)) {  
//				return SuccessOrFailure.SUCCESS("已加入续费清单,无需重复操作!");
//			} 
//		}catch(Exception e) {
//			return SuccessOrFailure.FAILURE(e.getMessage());
//		}
//		return null;
//	}
	
	/**
	 * 提交激活申请
	 * @param corsAccountId
	 * @param request
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value="/insertActiveApply")
	public SuccessOrFailure insertActiveApply(String corsAccountId,HttpServletRequest request){
		try {
//			SuccessOrFailure validate = getAccountState(corsAccountId,CorsAccountConsts.ACCOUNT_ACTIVE_TYPE_ACTIVE);
//			if(validate != null) return validate;
			return accountViewService.saveActiveApply(corsAccountId);
		}catch(Exception e){
			return SuccessOrFailure.FAILURE(e.getMessage());
		}
	}
	
	/**
	 * 添加续费申请
	 */
	@ResponseBody
	@RequestMapping(value="/addRepayApply")
	public SuccessOrFailure addRepayApply(CorsRepayTemp corsRepayTemp){
		try {
			accountViewService.saveRepayApply(corsRepayTemp);
			return SuccessOrFailure.SUCCESS("添加成功！");
		} catch (Exception e) {
			return SuccessOrFailure.FAILURE(e.getMessage());
		}
	}
	/**
	 * 续费清单列表
	 */
	@RequestMapping(value="/showRepayList")
	public void showRepayList(Model model){
		List <CorsRepayTemp> corsRepayTemps = accountViewService.getCorsRepayTemp();
		model.addAttribute("corsRepayTemps", corsRepayTemps);
	}
	/**
	 * 取消当前临时续费
	 */
	@ResponseBody
	@RequestMapping(value = "/deleteRepayApply")
	public SuccessOrFailure deleteRepayApply(String corsRepayTempId){
		try {
			accountViewService.deleteRepayApply(corsRepayTempId);
			return SuccessOrFailure.SUCCESS;
		} catch (Exception e) {
			return SuccessOrFailure.FAILURE(e.getMessage());
		}
	}
	
	/**
	 * 获取CORS账号统计信息
	 */
	@ResponseBody
	@RequestMapping(value = "/getCorsAccountStatistics")
	public Map<String,Object> getCorsAccountStatistics(){
		try {
			return accountViewService.getCorsStatistics();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
}
