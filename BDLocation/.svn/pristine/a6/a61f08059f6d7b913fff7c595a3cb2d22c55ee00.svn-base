package com.cnten.vo;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

public class ParamVO {
	
	private String list;
	
	private String map;

	public String getList() {
		return list;
	}

	public void setList(String list) {
		this.list = list;
	}

	public String getMap() {
		return map;
	}

	public void setMap(String map) {
		this.map = map;
	}
	
	public JSONArray getListJson(){
		return JSON.parseArray(list);
	}
	
	public JSONObject getMapJson(){
		return JSON.parseObject(map);
	}
	
}
