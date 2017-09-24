package com.cnten.bdlocation.baseStation.construction.controller;
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

import com.cnten.bdlocation.baseStation.construction.service.BaseConstructService;
import com.cnten.bdlocation.constants.BaseStationConsts;
import com.cnten.platform.dao.Page;
import com.cnten.platform.web.SuccessOrFailure;
import com.cnten.po.BaseConstruct;

@Controller
@RequestMapping(value="/baseStation/construction")
public class BaseConstructController {
	@InitBinder
	protected void initBinder(HttpServletRequest request, ServletRequestDataBinder binder) throws Exception {
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		CustomDateEditor editor = new CustomDateEditor(df, true);
		binder.registerCustomEditor(Date.class, editor);
	}
	@Autowired
	private BaseConstructService baseConstructService;
	
	@RequestMapping(value="/showConstructs")
	public void showConstructs(){
	}
	
	@RequestMapping(value="/queryConstructs")
	public void queryContructs(BaseConstruct baseConstruct, Integer pageIndex, Integer pageSize, Model model){
		Page page = baseConstructService.getConstructByPage(baseConstruct, pageIndex, pageSize);
		model.addAttribute(page);
	}
	
	@RequestMapping(value="/showConstruct")
	public void showConstruct(String baseConstructId, Model model){
		 BaseConstruct baseConstruct = baseConstructService.getConstruct(baseConstructId);
		 model.addAttribute("baseConstruct", baseConstruct);
	}
	
	@RequestMapping(value="/showCheck")
	public void showCheck(String baseConstructId, Model model){
		BaseConstruct baseConstruct = baseConstructService.getConstruct(baseConstructId);
		model.addAttribute("baseConstruct", baseConstruct);
	}
	
	@RequestMapping(value="/showRecord")
	public void showRecord(String baseConstructId, Model model){
		BaseConstruct baseConstruct = baseConstructService.getConstruct(baseConstructId);
		model.addAttribute("baseConstruct", baseConstruct);
	}
	
	@ResponseBody
	@RequestMapping(value="/saveConstruct")
	public SuccessOrFailure saveConstruct(BaseConstruct baseConstruct){
		try {
			baseConstructService.saveConstruct(baseConstruct);
			return SuccessOrFailure.SUCCESS(baseConstruct.getBaseConstructId());
		} catch (Exception e) {
			return SuccessOrFailure.FAILURE(e.getMessage());
		}
	}
	
	@ResponseBody
	@RequestMapping(value="/updateConstructState")
	public SuccessOrFailure updateConstructState(String ids){
		try {
			baseConstructService.updateConstructState(ids);
			return SuccessOrFailure.SUCCESS;
		} catch (Exception e) {
			return SuccessOrFailure.FAILURE(e.getMessage());
		}
	}
	
	@ResponseBody
	@RequestMapping(value="/updateConstructStage")
	public SuccessOrFailure updateConstructStage(String baseConstructId){
		try {
			baseConstructService.updateConstructStage(baseConstructId);
			return SuccessOrFailure.SUCCESS;
		} catch (Exception e) {
			return SuccessOrFailure.FAILURE(e.getMessage());
		}
	}
	
	/**
	 * 验收资料审批
	 * @param baseConstruct
	 * @param approveRlt 
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value="/baseCheckApprove")
	public SuccessOrFailure baseConstructCheckApprove(BaseConstruct baseConstruct,String approveRlt){
		try{
			baseConstructService.updateConstructCheckApprove(baseConstruct, approveRlt);
			return SuccessOrFailure.SUCCESS;
		}catch(Exception e){
			return SuccessOrFailure.FAILURE(e.getMessage());
		}
	}
	
	@ResponseBody
	@RequestMapping(value="/saveConstructRecordInfo")
	public SuccessOrFailure saveConstructRecordInfo(BaseConstruct baseConstruct){
		try{
			baseConstructService.saveConstructRecord(baseConstruct);
			return SuccessOrFailure.SUCCESS;
		}catch(Exception e){
			return SuccessOrFailure.FAILURE(e.getMessage());
		}
	}
	
}
