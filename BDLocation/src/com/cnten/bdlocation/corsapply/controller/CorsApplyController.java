package com.cnten.bdlocation.corsapply.controller;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.ServletRequestDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cnten.bdlocation.corsapply.service.CorsApplyService;
import com.cnten.platform.dao.Page;
import com.cnten.platform.web.SuccessOrFailure;
import com.cnten.po.CorsAccountRepay;
import com.cnten.po.CorsApply;

@Controller
public class CorsApplyController {

	@InitBinder
	protected void initBinder(HttpServletRequest request, ServletRequestDataBinder binder) throws Exception {
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		CustomDateEditor editor = new CustomDateEditor(df, true);
		binder.registerCustomEditor(Date.class, editor);
	}

	@Autowired
	private CorsApplyService corsApplyService;
	
//	@RequestMapping(value = "/corsApply/showCorsApplys")
//	public void showCorsApplys() {
//	}
//	
//	@RequestMapping(value = "/corsApply/showApplys")
//	public void showApplys() {
//	}
	
	@RequestMapping(value = "client/mgtCenter/corsOrders/showOrders")
	public void showCompanyApplys() {
	}
	
	@RequestMapping(value = "client/mgtCenter/corsOrders/buyDetailOrder")
	public void showBuyDetailOrder(String corsApplyId,Model model){
		CorsApply corsApply = corsApplyService.getCorsApply(corsApplyId);
		model.addAttribute("corsApply", corsApply);
	}
	
	@RequestMapping(value = "client/mgtCenter/corsOrders/repayDetailOrder")
	public void showRepayDetailOrder(String corsApplyId,Model model){
		CorsAccountRepay corsAccountRepay = corsApplyService.getCorsRepayApply(corsApplyId);
		model.addAttribute("corsRepay",corsAccountRepay);
	}
	
	@RequestMapping(value = "client/mgtCenter/corsOrders/repayDetailOrderTable")
	public void showRepayDetailOrderTable(String corsApplyId, Integer pageSize, Integer pageIndex,Model model){
		Page corsAccountRepay = corsApplyService.getCorsRepayApplyPage(corsApplyId, pageSize, pageIndex);
		model.addAttribute(corsAccountRepay);
	}
	
	@RequestMapping(value="corsApprove/fastApplyCors")
	public void showFastCorsApply(){
	}
	
	/**
	 * 快速生成 cors申请
	 * @param applyData
	 * @param companyId
	 * centimeter,formal,1,5#meter,formal,1,15#milevel,formal,1,25#centimeter,formal,2,25 ---> 服务类型(bdDeviceAccuracy),账号类型(accountType),服务时长(accountPeriod),申请数量(applyCount)#
	 * @return 
	 */
	@ResponseBody
	@RequestMapping(value="fastApply/submitCorsApply")
	public SuccessOrFailure submitCorsApply(String applyData, String companyId){
		try{
			return corsApplyService.saveFastCorsApply(applyData, companyId);
		}catch(Exception e){
			return SuccessOrFailure.FAILURE(e.getMessage());
		}
	}
	
//	@RequestMapping(value = "/corsApply/showApplySuggestion")
//	public void showApplySuggestion() {
//	}
	
//	@RequestMapping(value = "/corsApply/showCorsApply")
//	public void showCorsApply(String corsApplyId, Model model) {
//		CorsApply corsApply = corsApplyService.getCorsApply(corsApplyId);
//		model.addAttribute("corsApply", corsApply);
//	}
	
//	@RequestMapping(value = "/corsApply/queryCorsApplys")
//	public void queryCorsApplys(CorsApply corsApply, Integer pageIndex, Integer pageSize, Model model) {
//		Page page = corsApplyService.getCorsApplysPage(corsApply, pageIndex, pageSize);
//		model.addAttribute(page);
//	}
	
//	@RequestMapping(value = "/corsApply/queryApplys")
//	public void queryApplys(CorsApply corsApply, Integer pageIndex, Integer pageSize, Model model) {
//		Page page = corsApplyService.getApplysPage(corsApply, pageIndex, pageSize);
//		model.addAttribute(page);
//	}
//	
//	@RequestMapping(value = "/corsApply/selectCorsApply")
//	public void selectCorsApply() {
//	}
//	
//	@RequestMapping(value = "/corsApply/selectCorsApplys")
//	public void selectCorsApplys(CorsApply corsApply, Integer pageIndex, Integer pageSize, Model model) {
//		Page page = corsApplyService.getCorsApplysPage(corsApply, pageIndex, pageSize);
//		model.addAttribute(page);
//	}
//	
//	@ResponseBody
//	@RequestMapping(value = "/corsApply/saveCorsApply")
//	public SuccessOrFailure saveCorsApply(CorsApply corsApply){
//		try {
//			corsApplyService.saveCorsApply(corsApply);
//			return SuccessOrFailure.SUCCESS(corsApply.getCorsApplyId());
//		} catch (Exception e) {
//			return SuccessOrFailure.FAILURE(e.getMessage());
//		}
//	}
//	
//	@ResponseBody
//	@RequestMapping(value = "/corsApply/deleteCorsApply")
//	public SuccessOrFailure deleteCorsApply(String corsApplyIds){
//		try {
//			corsApplyService.deleteCorsApply(corsApplyIds);
//			return SuccessOrFailure.SUCCESS;
//		} catch (Exception e) {
//			return SuccessOrFailure.FAILURE(e.getMessage());
//		}
//	}
	
//	@RequestMapping(value = "/corsApply/exportCorsApplys")
//	public void exportCorsApplys(CorsApply corsApply, HttpServletResponse response) {
//		try {
//			corsApplyService.exportCorsApplys(corsApply, response);
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//	}
	
//	@RequestMapping(value = "/corsApply/exportCorsApply")
//	public void exportCorsApply(String applyId, HttpServletResponse response, HttpServletRequest request) {
//		try {
//			CorsApply corsApply = corsApplyService.getCorsApply(applyId);
//			if(corsApply == null) return;
//			corsApplyService.exportCorsApply(corsApply, response, request);
//		} catch (Exception e) {
//			e.printStackTrace();
//			try {
//				response.sendError(500, "导出过程出现错误");
//			} catch (IOException e1) {
//				e1.printStackTrace();
//			}
//		}
//	}
	
//	@ResponseBody
//	@RequestMapping(value = "/corsApply/approval")
//	private SuccessOrFailure approval(CorsApply suggestion,HttpServletResponse response) {
//		if(suggestion==null || suggestion.getCorsApplyId()==null) return SuccessOrFailure.FAILURE("未找到申请记录！"); 
//		CorsApply corsApply = corsApplyService.getCorsApply(suggestion.getCorsApplyId());
//		if(corsApply == null) return SuccessOrFailure.FAILURE("未找到申请记录！");
//		int approval = 0;
//		if(corsApply.getApplyStatus()!=null && corsApply.getApplyStatus().trim().length()>0) {
//			approval = Integer.parseInt(corsApply.getApplyStatus());
//		}
//		try {
//			corsApplyService.saveApproval(suggestion, Integer.toString(++approval));
//		} catch (Exception e) {
//			e.printStackTrace();
//			return SuccessOrFailure.FAILURE(e.getMessage());
//		}
//		return SuccessOrFailure.SUCCESS;
//	}
	
//	@ResponseBody
//	@RequestMapping(value = "/corsApply/reject")
//	private SuccessOrFailure reject(CorsApply suggestion) {
//		if(suggestion==null || suggestion.getCorsApplyId()==null)  return SuccessOrFailure.FAILURE("未找到申请记录！"); 
//		CorsApply corsApply = corsApplyService.getCorsApply(suggestion.getCorsApplyId());
//		if(corsApply == null) return SuccessOrFailure.FAILURE("未找到申请记录！");
//		if("3".equals(corsApply.getApplyStatus())) return SuccessOrFailure.FAILURE("审批已完成无法操作");
//		try {
//			corsApplyService.saveApproval(suggestion, "-1");
//		} catch (Exception e) {
//			e.printStackTrace();
//			return SuccessOrFailure.FAILURE(e.getMessage());
//		}
//		return SuccessOrFailure.SUCCESS;
//	}
//	
//	@ResponseBody
//	@RequestMapping(value = "/corsApply/submitApply")
//	private SuccessOrFailure submitApply(String corsApplyId){
//		try {
//			corsApplyService.saveApply(corsApplyId);
//			return SuccessOrFailure.SUCCESS;
//		} catch (Exception e) {
//			return SuccessOrFailure.FAILURE(e.getMessage());
//		}
//	}
}
