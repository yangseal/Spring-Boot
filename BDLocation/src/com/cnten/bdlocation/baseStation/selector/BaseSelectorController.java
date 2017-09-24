package com.cnten.bdlocation.baseStation.selector;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.cnten.bdlocation.baseStation.customer.service.BaseContractService;
import com.cnten.bdlocation.baseStation.customer.service.BaseCustomerService;
import com.cnten.bdlocation.baseStation.customer.service.BaseProjectService;
import com.cnten.bdlocation.baseStation.provider.service.BaseProviderService;
import com.cnten.platform.dao.Page;
import com.cnten.po.BaseCustomer;
import com.cnten.po.BaseCustomerContract;
import com.cnten.po.BaseProject;
import com.cnten.po.BaseProvider;
import com.cnten.po.OamArea;

@Controller
@RequestMapping(value="/baseStation/selector")
public class BaseSelectorController {
	@Autowired
	private BaseCustomerService baseCustomerService;
	
	@Autowired
	private BaseProjectService baseProjectService;
	
	@Autowired
	private BaseProviderService baseProviderService;
	
	@Autowired
	private BaseContractService baseContractService;
	
	@RequestMapping(value = "/selectBaseCustomer")
	public void selectBaseCustomer() {
	}
	
	@RequestMapping(value="/selectBaseCustomers")
	public void selectBaseCustomers(String areaId,BaseCustomer baseCustomer, Integer pageIndex, Integer pageSize, Model model){
		if(null == baseCustomer.getOamArea()) {
			OamArea oamArea = new OamArea(areaId);
			baseCustomer.setOamArea(oamArea);
		} else {
			baseCustomer.getOamArea().setOamAreaId(areaId);
		}
		Page page = baseCustomerService.getBaseCustomersPage(baseCustomer, pageIndex, pageSize);
		model.addAttribute(page);
	}
	
	@RequestMapping(value = "/selectBaseProject")
	public void selectBaseProject() {
	}
	
	@RequestMapping(value = "/selectBaseProjects")
	public void selectBaseProjects(String baseProjectName,String projectNo,BaseCustomer baseCustomer, Integer pageIndex, Integer pageSize, Model model) {
		BaseProject baseProject = new BaseProject();
		baseProject.setProjectName(baseProjectName);
		baseProject.setProjectNo(projectNo);
		baseProject.setBaseCustomer(baseCustomer);
		Page page = baseProjectService.getBaseProjectsPage(baseProject, pageIndex, pageSize);
		model.addAttribute(page);
	}
	
	@RequestMapping(value = "/selectBaseProvider")
	public void selectBaseProvider() {
	}
	
	@RequestMapping(value = "/selectBaseProviders")
	public void selectBaseProviders(BaseProvider baseProvider, Integer pageIndex, Integer pageSize, Model model) {
		Page page = baseProviderService.getBaseProvider(baseProvider, pageIndex, pageSize);
		model.addAttribute(page);
	}
	
	@RequestMapping(value = "/selectCustomerContract")
	public void selectCustomerContract(String baseCustomerId,Model model) {
		model.addAttribute("baseCustomerId",baseCustomerId);
	}
	
	@RequestMapping(value = "/selectCustomerContracts")
	public void selectCustomerContracts(BaseCustomerContract baseCustomerContract,Integer pageIndex, Integer pageSize, Model model) {
		Page page = baseContractService.getContractsPage(baseCustomerContract,pageIndex, pageSize);
		model.addAttribute(page);
	}
}
