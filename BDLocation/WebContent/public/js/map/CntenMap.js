/** CntenMap Define：begin */
var CntenMap = function(mapOption){
	
	this.map = null;		//地图对象
	
	this.mapOption = mapOption;		//初始化参数
	
	/**
	 * 初始化地图
	 */
	this.init = function(){
		var _self = this;
		_self.map = new _self.mapOption.mapClass(_self.mapOption);		//创建地图对象
		_self.map.init();			//初始化地图组件
	};
	
	/**
	 * 画线
	 */
	this.drawLine = function(line){
		if(!this.map){
			this.init();
		}
		this.map.drawLine(line);
	};
	
	/**
	 * 画点
	 */
	this.drawPoint = function(point){
		if(!this.map){
			this.init();
		}
		this.map.drawPoint(point);
	};
	/**
	 * 地图经纬度坐标转换为平面地图像素坐标
	 */
	this.fromLngLatToContainerPixel = function(point) {
		if(!this.map){
			this.init();
		}
		return this.map.fromLngLatToContainerPixel(point);
	}
	/**
	 * 平面地图像素坐标转换为地图经纬度坐标
	 */
	this.fromContainerPixelToLngLat = function(point) {
		if(!this.map){
			this.init();
		}
		return this.map.fromContainerPixelToLngLat(point);
	}
	/**
	 * 根据覆盖物设置合适的视野
	 */
	this.setFitView = function() {
		if(!this.map){
			this.init();
		}
		this.map.setFitView();
	}
	
	/**
	 * 设置中心点
	 * lng 纬度
	 * lat 经度
	 */
	this.centerAt = function(lng, lat, callBack){
		this.map.centerAt(lng, lat, callBack);
	};
	
	/**
	 * 设置级别
	 * zoom  Number
	 */
	this.setZoom = function(zoom){
		this.map.setZoom(zoom);
	};
	
	/**
	 * 获取级别
	 * zoom  Number
	 */
	this.getZoom = function(){
		return this.map.getZoom();
	};
	/**
	 * 地图可视区域
	 * 返回对象： MapBounds
	 */
	this.getBounds = function(){
		return this.map.getBounds();
	};
	
	
};
CntenMap.CLASS_NAME = "CntenMap";
/** CntenMap Define：end */