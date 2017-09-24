package com.cnten.bdlocation.corsInit.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;



import com.cnten.bdlocation.accountView.controller.AccountViewController;
import com.cnten.bdlocation.corsInit.service.CorsInitService;
import com.cnten.platform.dao.Page;
import com.cnten.platform.web.SuccessOrFailure;
import com.cnten.po.CorsAccount;
import com.cnten.po.CorsApply;


@Controller
@RequestMapping(value="/corsInit")
public class CorsInitController {
	@Autowired
	private CorsInitService corsInitService;
	private static final Logger log4j = LoggerFactory.getLogger(AccountViewController.class);
	@RequestMapping(value="/showCorsInits")
	public void showCorsInits(){
		
		
	}
	//单个查看
	@RequestMapping(value="/showCorsInit")
	public void showCorsInit(String bussinessId,Model model){
		CorsApply corsApply = corsInitService.getCorsInit(bussinessId);
		model.addAttribute("corsApply",corsApply);
	}
	
	//单个查看
	@RequestMapping(value="/showCorsAccounts")
	public void showCorsAccounts(String bussinessIds,Model model){
		List<CorsApply> corsApplys = corsInitService.getCorsApplys(bussinessIds);
		model.addAttribute("corsApply",corsApplys);
	}
	
	//查看已生成账号信息
	@RequestMapping(value="/queryAccounts")
	public void queryAccounts(String bussinessId,Model model){
		List<CorsAccount> account = corsInitService.getCorsAccounts(bussinessId);
		model.addAttribute("account", account);
	}
	
	@RequestMapping(value="/queryCorsInits")
	public void queryCorsInit(CorsApply corsApply,Integer pageIndex,Integer pageSize,Model model){
		Page page = corsInitService.getPageApply(corsApply,pageIndex,pageSize);
		model.addAttribute(page);
		
	}
	//生成账号
	@RequestMapping(value="/doInit")
	public void doInit(String bussinessId,Model model){
		CorsApply corsApply = corsInitService.getCorsInit(bussinessId);
		model.addAttribute("corsApply",corsApply);
	}
	@ResponseBody
	@RequestMapping(value="/doneInit")
	public SuccessOrFailure doneInit(String bussinessId){
		try {
			corsInitService.updateAccount(bussinessId);
			return SuccessOrFailure.SUCCESS(null);
		} catch (Exception e) {
			log4j.info("-----msg:" + e.getMessage());
			return SuccessOrFailure.FAILURE(e.getMessage());
			
		}
	}
	
	
	
}
