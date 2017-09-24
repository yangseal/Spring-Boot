/**
 * 地图可视区域对象
 * southLng, southLat 西南坐标
 * northLng, northLat 东北坐标
 */
var MapBounds = function(southLng, southLat, northLng, northLat){
	
	var southWest = new MapPoint({'lat': southLat, 'lng': southLng}) ;
	
	var northEast = new MapPoint({'lat': northLat, 'lng': northLng}) ;;
	
	this.getSouthWest = function(){
		
		return southWest;
	};
	
	this.getNorthEast = function(){
		
		return northEast;
	}
};
MapBounds.CLASS_NAME = "MapBounds";