package com.cnten.platform.dict.service;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cnten.platform.dao.CommonDAO;
import com.cnten.platform.dao.Page;
import com.cnten.po.Dict;

@Service
public class DictService {

	@Autowired
	CommonDAO commonDAO;
	
	public Page getDictsPage(String dictName, Integer pageIndex, Integer pageSize) {
		String hql = "from Dict where isDelete is null and dictName like ?";
		dictName = "%" + dictName + "%";
		return commonDAO.getPageByVariableParam(hql, pageIndex, pageSize, dictName);
	}

	public Dict getDict(String dictId) {
		return commonDAO.get(Dict.class, dictId);
	}

	public void saveDict(Dict dict) {
		String dictId = dict.getDictId();
		if(StringUtils.isEmpty(dictId)){
			commonDAO.save(dict);
		}else{
			Dict oldDict = commonDAO.load(Dict.class, dictId);
			oldDict.setDictName(dict.getDictName());
			oldDict.setDictCode(dict.getDictCode());
			commonDAO.update(oldDict);
		}
	}

	public void deleteDict(String dictIds){
		String[] dictIdArray = dictIds.split(",");
		for(String dictId : dictIdArray){
			Dict oldDict = commonDAO.load(Dict.class, dictId);
			oldDict.setIsDelete("Y");
			commonDAO.update(oldDict);
		}
	}
}
