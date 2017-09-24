package com.cnten.bdlocation.measureproject.service;

public enum PointEnum {
	//营业点需导出信息及对应编码
	YYD("101401" ,new String[]{"xuhao", "shouquanpaibianma","jigouma","dianming","xiangxidizhi","lianxidianhua","coordinatex","coordinatey","longitude","latitude","lianxiren","dianneipeizhisheshi","wangdianxingshi","zhaopian1","zhaopian2","xingzhengquyu","gongzuoquyu","beizhu"}, 
			new String[]{"序号","授权牌编码","机构码","店名","详细地址","联系电话","城建坐标X","城建坐标Y","经度","纬度","联系人","店内配置设备","网点形式","网点照片1","网点照片2","行政区域","工作区域","备注"});
	//调压箱需导出信息
	/*
	 * TYX("101101" ,new String[]{"field1", "field2"}, 
			new String[]{"字段1","字段2"});
	*/
	private final String[] fieldCode;
	private final String[] fieldName;
	private final String type;
	
	private PointEnum(String type, String[] fieldCode, String[] fieldName){
		this.fieldCode = fieldCode;
		this.fieldName = fieldName;
		this.type = type;
	}

	public String[] getFieldCode() {
		return fieldCode;
	}

	public String[] getFieldName() {
		return fieldName;
	}
	//获取编码列表
	public static String[] getEnameCode(String type){
		PointEnum[] point = PointEnum.values();
		for(int i = 0; i < point.length; i++){
			if(point[i].type.equals(type)){
				return point[i].fieldCode;
			}
		}
		return null;
	}
	//获取名称列表
	public static String[] getEnameName(String type){
		PointEnum[] point = PointEnum.values();
		for(int i = 0; i < point.length; i++){
			if(point[i].type.equals(type)){
				return point[i].fieldName;
			}
		}
		return null;
	}
}
