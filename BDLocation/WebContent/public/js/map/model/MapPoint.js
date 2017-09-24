var MapPoint = function(option){
	
	this.lat = option.lat;					//纬度
	
	this.lng = option.lng;					//经度
	
	this.mPoint = option.mPoint;			//个性化参数
	
	this.getLat = function(){
		return this.lat;
	};
	
	this.getLng = function(){
		return this.lng;
	};
};
MapPoint.CLASS_NAME = "MapPoint";