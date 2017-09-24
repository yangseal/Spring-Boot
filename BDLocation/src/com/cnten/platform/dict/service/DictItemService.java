package com.cnten.platform.dict.service;

import java.util.HashMap;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cnten.platform.dao.CommonDAO;
import com.cnten.platform.dao.Page;
import com.cnten.po.Dict;
import com.cnten.po.DictItem;

@Service
public class DictItemService {

	@Autowired
	CommonDAO commonDAO;
	
	public Page getDictItemsPage(Dict dict, Integer pageIndex, Integer pageSize) {
		String hql = "from DictItem where isDelete is null";
		HashMap<String,Object> params = new HashMap<String,Object>();
		if(!StringUtils.isEmpty(dict.getDictId())){
			hql += " and dict.dictId = :dictId";
			params.put("dictId", dict.getDictId());
		}
		if(!StringUtils.isEmpty(dict.getDictName())){
			hql += " and dict.dictName = :dictName";
			params.put("dictName", dict.getDictName());
		}
		return commonDAO.getPage(hql, pageIndex, pageSize, params);
	}

	public DictItem getDictItem(String dictItemId) {
		return commonDAO.get(DictItem.class, dictItemId);
	}

	public void saveDictItem(DictItem dictItem) {
		if(StringUtils.isEmpty(dictItem.getDictId())){
			dictItem.setDict(null);
		}else{
			dictItem.setDict(new Dict(dictItem.getDictId()));
		}
		String dictItemId = dictItem.getDictItemId();
		if(StringUtils.isEmpty(dictItemId)){
			commonDAO.save(dictItem);
		}else{
			DictItem oldDictItem = commonDAO.load(DictItem.class, dictItemId);
			oldDictItem.setDictItemName(dictItem.getDictItemName());
			oldDictItem.setDictItemCode(dictItem.getDictItemCode());
			commonDAO.update(oldDictItem);
		}
	}

	public void deleteDictItem(String dictItemIds){
		String[] dictItemIdArray = dictItemIds.split(",");
		for(String dictItemId : dictItemIdArray){
			DictItem oldDictItem = commonDAO.load(DictItem.class, dictItemId);
			oldDictItem.setIsDelete("Y");
			commonDAO.update(oldDictItem);
		}
	}
}
