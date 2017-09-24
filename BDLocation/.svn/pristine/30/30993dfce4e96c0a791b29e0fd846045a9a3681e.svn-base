package com.cnten.platform.dict.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cnten.platform.dao.Page;
import com.cnten.platform.dict.service.DictItemService;
import com.cnten.platform.web.SuccessOrFailure;
import com.cnten.po.Dict;
import com.cnten.po.DictItem;

@Controller
public class DictItemController {

	@Autowired
	private DictItemService dictItemService;
	
	@RequestMapping(value = "/dictItem/showDictItems")
	public void showDictItems() {
	}
	
	@RequestMapping(value = "/dictItem/showDictItem")
	public void showDictItem(String dictItemId, Model model) {
		DictItem dictItem = dictItemService.getDictItem(dictItemId);
		model.addAttribute("dictItem", dictItem);
	}
	
	@RequestMapping(value = "/dictItem/queryDictItems")
	public void queryDictItems(Dict dict, Integer pageIndex, Integer pageSize, Model model) {
		Page page = dictItemService.getDictItemsPage(dict, pageIndex, pageSize);
		model.addAttribute(page);
	}
	
	@RequestMapping(value = "/dictItem/selectDictItem")
	public void selectDictItem() {
	}
	
	@RequestMapping(value = "/dictItem/selectDictItems")
	public void selectDictItems(Dict dict, Integer pageIndex, Integer pageSize, Model model) {
		Page page = dictItemService.getDictItemsPage(dict, pageIndex, pageSize);
		model.addAttribute(page);
	}
	
	@ResponseBody
	@RequestMapping(value = "/dictItem/saveDictItem")
	public SuccessOrFailure saveDictItem(DictItem dictItem){
		try {
			dictItemService.saveDictItem(dictItem);
			return SuccessOrFailure.SUCCESS(dictItem.getDictItemId());
		} catch (Exception e) {
			return SuccessOrFailure.FAILURE(e.getMessage());
		}
	}
	
	@ResponseBody
	@RequestMapping(value = "/dictItem/deleteDictItem")
	public SuccessOrFailure deleteDictItem(String dictItemIds){
		try {
			dictItemService.deleteDictItem(dictItemIds);
			return SuccessOrFailure.SUCCESS;
		} catch (Exception e) {
			return SuccessOrFailure.FAILURE(e.getMessage());
		}
	}
}
