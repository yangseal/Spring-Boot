package com.cnten.vo;

import java.util.ArrayList;
import java.util.List;

public class ConverAreaVO {

	private String id;//地区id
	private String parentId;//地区父id
	private String name;//地区名称
	private String no;//地区编号
	private List<ConverAreaVO> children = new ArrayList<ConverAreaVO>(); //地区子节点
	
	public ConverAreaVO(String id, String parentId, String name, String no) {
		super();
		this.id = id;
		this.parentId = parentId;
		this.name = name;
		this.no = no;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getParentId() {
		return parentId;
	}

	public void setParentId(String parentId) {
		this.parentId = parentId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getNo() {
		return no;
	}

	public void setNo(String no) {
		this.no = no;
	}
	
	public List<ConverAreaVO> getChildren() {
		return children;
	}

	public void setChildren(List<ConverAreaVO> children) {
		this.children = children;
	}
	
}
