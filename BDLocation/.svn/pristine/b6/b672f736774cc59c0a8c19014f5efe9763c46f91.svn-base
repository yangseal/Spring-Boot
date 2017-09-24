package com.cnten.platform.dict.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cnten.platform.dao.Page;
import com.cnten.platform.dict.service.DictService;
import com.cnten.platform.web.SuccessOrFailure;
import com.cnten.po.Dict;

@Controller
public class DictController {

	@Autowired
	private DictService dictService;
	
	@RequestMapping(value = "/dict/showDicts")
	public void showDicts() {
	}
	
	@RequestMapping(value = "/dict/showDict")
	public void showDict(String dictId, Model model) {
		Dict dict = dictService.getDict(dictId);
		model.addAttribute("dict", dict);
	}
	
	@RequestMapping(value = "/dict/queryDicts")
	public void queryDicts(String dictName, Integer pageIndex, Integer pageSize, Model model) {
		Page page = dictService.getDictsPage(dictName, pageIndex, pageSize);
		model.addAttribute(page);
	}
	
	@ResponseBody
	@RequestMapping(value = "/dict/saveDict")
	public SuccessOrFailure saveDict(Dict dict){
		try {
			dictService.saveDict(dict);
			return SuccessOrFailure.SUCCESS(dict.getDictId());
		} catch (Exception e) {
			return SuccessOrFailure.FAILURE(e.getMessage());
		}
	}
	
	@ResponseBody
	@RequestMapping(value = "/dict/deleteDict")
	public SuccessOrFailure deleteDict(String dictIds){
		try {
			dictService.deleteDict(dictIds);
			return SuccessOrFailure.SUCCESS;
		} catch (Exception e) {
			return SuccessOrFailure.FAILURE(e.getMessage());
		}
	}
}
