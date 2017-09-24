package com.cnten.bdlocation.regionnumber.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class RegionNumberController {
	
	@RequestMapping(value = "/regionNum/showRegion")
	public void showRegion(String menuId,Model model) {
	}
}
