package com.cnten.bdlocation.busiapprove.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cnten.bdlocation.busiapprove.service.BusinApproveService;
import com.cnten.bdlocation.corsRepay.service.CorsAccountRepayService;
import com.cnten.bdlocation.corsapply.service.CorsApplyService;
import com.cnten.platform.dao.Page;
import com.cnten.platform.web.SuccessOrFailure;
import com.cnten.po.CorsAccountRepay;
import com.cnten.po.CorsApply;
import com.cnten.po.CorsBusiApprove;
import com.cnten.po.CorsRepayRel;
import com.cnten.vo.BusiApproveVO;

@Controller
public class BusinApproveController {
	
	@Autowired
	private BusinApproveService businApproveService;
	@Autowired
	private CorsApplyService corsApplyService;
	@Autowired
	private CorsAccountRepayService corsAccountRepayService;

	@RequestMapping(value = "/corsApprove/showApproves")
	public void showApproves() {

	}
	
	@RequestMapping(value = "client/mgtCenter/corsOrders/queryApplys")
	public void queryApplys(BusiApproveVO busiApproveVO, Integer pageIndex,
							Integer pageSize, Model model) {
		Page page = businApproveService.getApprovesPage(busiApproveVO,
				pageIndex, pageSize);
		model.addAttribute(page);
	}
	
	@RequestMapping(value = "client/mgtCenter/corsOrders/detailOrder")
	public void showDetailOrder(String corsApplyId,Model model){
		Map<String,Object> account = businApproveService.getApprove(corsApplyId);
		model.addAllAttributes(account);
		CorsBusiApprove busiApprove = businApproveService.getCorsBusiApprove(corsApplyId);
		model.addAttribute("busiApprove",busiApprove);
	}

	@RequestMapping(value = "/corsApprove/queryApproves")
		public void queryApproves(BusiApproveVO busiApproveVO, Integer pageIndex,
								Integer pageSize, Model model) {
		Page page = businApproveService.getApprovesPage(busiApproveVO,
				pageIndex, pageSize);
		model.addAttribute(page);
	}
	@RequestMapping(value = "/corsApprove/showApprove")
	public void showApprove(String corsApproveId, Model model) {
		Map<String,Object> account = businApproveService.getApprove(corsApproveId);
		model.addAllAttributes(account);
	}
	@RequestMapping(value = "/corsApprove/showApproveOpinion")
	public void showApproveOption(String corsApproveId, Model model) {
		Map<String,Object> account = businApproveService.getApprove(corsApproveId);
		model.addAllAttributes(account);
	}

	@RequestMapping(value = "/corsApprove/detailAccount")
	public void detailAccount(String orderBussinkey, Model model) {
		List<CorsRepayRel> account = businApproveService.getAccount(orderBussinkey);
		model.addAttribute("account", account);
	}

	@ResponseBody
	@RequestMapping(value = "/corsApprove/passAccount")
	public SuccessOrFailure passAccount(BusiApproveVO busiApproveVO) {
		try {
			return businApproveService.updatePassAccount(busiApproveVO);
		} catch (Exception e) {
			e.printStackTrace();
			return SuccessOrFailure.FAILURE(e.getMessage());
		}
	}
	
	@ResponseBody
	@RequestMapping(value = "/corsApprove/rejectAccount")
	public SuccessOrFailure rejectAccount(BusiApproveVO busiApproveVO) {
		try {
			businApproveService.updateRejectAccount(busiApproveVO);
			return SuccessOrFailure.SUCCESS(null);
		} catch (Exception e) {
			return SuccessOrFailure.FAILURE(e.getMessage());
		}
	}

	@RequestMapping(value = "/companyExamine/showExamines")
	public void showExamines() {
	}

	@RequestMapping(value = "/companyExamine/queryExamines")
	public void queryExamines(BusiApproveVO busiApproveVO,
							  Integer pageIndex, Integer pageSize, Model model) {
		Page page = businApproveService.getCompanyDataExaminePage(busiApproveVO, pageIndex, pageSize);
		model.addAttribute(page);
	}

	@RequestMapping(value = "/companyExamine/editExamines")
	public void queryExamine(String busiApproveId, Model model) {
		Map<String, Object> busicompayExamine = businApproveService.getBusicompayExamine(busiApproveId);
		model.addAllAttributes(busicompayExamine);
	}

	@ResponseBody
	@RequestMapping(value = "/companyExamine/saveQueryExamine")
	public SuccessOrFailure saveApproveQueryExamine(BusiApproveVO busiApproveVO) {
		try {
			businApproveService.saveApproveQueryExamine(busiApproveVO);
			return SuccessOrFailure.SUCCESS(busiApproveVO.getBusiApproveId());
		} catch (Exception e) {
			return SuccessOrFailure.FAILURE(e.getMessage());
		}
	}

	@ResponseBody
	@RequestMapping(value = "/companyExamine/saveRejectExamine")
	public SuccessOrFailure saveRejectExamine(BusiApproveVO busiApproveVO) {
		try {
			businApproveService.saveRejectExamine(busiApproveVO);
			return SuccessOrFailure.SUCCESS(busiApproveVO.getBusiApproveId());
		} catch (Exception e) {
			return SuccessOrFailure.FAILURE(e.getMessage());
		}
	}
	
	/**查看订单详情*/
	@RequestMapping(value="/corsApprove/showBuyOrderDetail")
	public void showBuyOrderDetail(String orderBussinkey,Model model){
		CorsApply corsApply = corsApplyService.getCorsApply(orderBussinkey);
		model.addAttribute("corsApply", corsApply);
	}
	
	@RequestMapping(value="/corsApprove/showRepayOrderDetail")
	public void showRepayOrderDetail(String orderBussinkey,Model model){
		CorsAccountRepay corsAccountRepay = corsApplyService.getCorsRepayApply(orderBussinkey);
		model.addAttribute("corsRepay",corsAccountRepay);
	}
	
	@RequestMapping(value = "/corsApprove/repayDetailOrderTable")
	public void showRepayDetailOrderTable(String corsApplyId, Integer pageSize, Integer pageIndex,Model model){
		Page corsAccountRepay = corsApplyService.getCorsRepayApplyPage(corsApplyId, pageSize, pageIndex);
		model.addAttribute(corsAccountRepay);
	}
}
