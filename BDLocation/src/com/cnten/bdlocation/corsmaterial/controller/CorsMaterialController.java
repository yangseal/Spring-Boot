package com.cnten.bdlocation.corsmaterial.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cnten.bdlocation.busiapprove.service.BusinApproveService;
import com.cnten.bdlocation.constants.CorsAccountConsts;
import com.cnten.bdlocation.corsmaterial.service.CorsMaterialService;
import com.cnten.platform.dao.Page;
import com.cnten.platform.web.SuccessOrFailure;
import com.cnten.po.CorsApplyMaterial;
import com.cnten.vo.BusiApproveVO;


@Controller
@RequestMapping(value = "/corsApplyMaterial")
public class CorsMaterialController {
	@Autowired
	private CorsMaterialService corsMaterialService;
	@Autowired
	private BusinApproveService businApproveService;
	
	@RequestMapping(value = "/showMaterials")
	public void showExamines() {
	}
	
	@RequestMapping(value = "/queryMaterials")
	public void queryMaterials(BusiApproveVO busiApproveVO, Integer pageIndex, Integer pageSize, Model model) {
		busiApproveVO.setApplyMaterialOrderType(CorsAccountConsts.CORS_ORDER_TYPE_TRIAL);
		busiApproveVO.setApplyStatus(CorsAccountConsts.BUSI_APPROVE_STATE_PASS);
		Page page = businApproveService.getApprovesPage(busiApproveVO, pageIndex, pageSize);
		model.addAttribute(page);
	}
	
	@RequestMapping(value = "/editMaterials")
	public void queryMaterials(String orderBussinkey, Model model) {
		Map<String,Object> orderMaterial = corsMaterialService.getCorsOrderMaterial(orderBussinkey);
		model.addAllAttributes(orderMaterial);
	}
	@ResponseBody
	@RequestMapping(value = "/saveMaterials")
	public SuccessOrFailure saveMaterials(CorsApplyMaterial corsApplyMaterial){
		try {
			corsMaterialService.saveMaterials(corsApplyMaterial);
			return SuccessOrFailure.SUCCESS(corsApplyMaterial.getApplyMaterialId());
		} catch (Exception e) {
			return SuccessOrFailure.FAILURE(e.getMessage());
		}
	}
	
	@ResponseBody
	@RequestMapping(value = "/updateMaterials")
	public void updateMaterials(CorsApplyMaterial corsApplyMaterial) {
		 corsMaterialService.updateMaterials(corsApplyMaterial);
	}
	
}
