//var map;
var cntenMap;
//点集合，用以定位地图的显示层级与中心点
var lngLatArr = [];

function MapLoad() {
	//初始化地图对象
	/*map = new TMap("map-wrap");

	var navigationConfig = {
		type : "TMAP_NAVIGATION_CONTROL_LARGE", //缩放平移的显示类型
		anchor : "TMAP_ANCHOR_TOP_LEFT", //缩放平移控件显示的位置
		offset : [ 0, 0 ], //缩放平移控件的偏移值
		showZoomInfo : true
	//是否显示级别提示信息，true表示显示，false表示隐藏。
	};

	var control = new TNavigationControl(navigationConfig);
	//添加缩放平移控件
	map.addControl(control);
	//允许鼠标滚轮缩放地图
	map.enableHandleMouseScroll();
	var scale = new TScaleControl();
	//添加比例尺控件
	map.addControl(scale);
	//设置显示地图的中心点和级别 
	map.centerAndZoom(new TLngLat(116.422693, 39.977873), 15);*/
	
	if (companylat && companylat != "null" && companylat != "" && companylat != '""') {
		
	} else {
		companylng = 116.422693;
		companylat = 39.977873;
	}
	var mapOption = {
			'mapWrap' : 'map-wrap',						//地图容器
			'centerPoint' : {'x':companylng ,'y':companylat},		//中心点
			'mapClass' : AutoNaviMap				//地图组件
		};
	cntenMap = new CntenMap(mapOption);
	cntenMap.init();
	
	
}

function getLngLat(){
	
	var url = rootDirectoryURL +"/accuratePosition/getLngLatByIds";
	$.post(url,{'selectPoints':selectPoints},function(data){
		for(var i=0; i<data.length; i++){
			//alert(data[i].longitude);
			//alert(data[i].latitude);
			//alert(data[i].attachmentId);
			writePoint(data[i].longitude, data[i].latitude, data[i].attachmentId);
		} 
		
//		var pointsArr = res.data.data;
//		$.each(pointsArr,function(index,point){
//			writePoint(data.longitude, data.latitude, data.attachmentId);
//		});
//		map.setViewport(lngLatArr);
		cntenMap.setFitView();
//		map.zoomOut();
	},'json');
}

function writePoint(lng, lat, pic) {
	
	/*var point = new TLngLat(Number(lng), Number(lat));
	var markerOptions = new TMarkerOptions();
	if(pic != "") {
		markerOptions.icon = new TIcon(rootDirectoryURL
				+ '/file?id=' + pic,
				new TSize(18, 18), {
					anchor : new TPixel(12, 24)
				});
	} else {
		markerOptions.icon = new TIcon(rootDirectoryURL
				+ '/public/img/markerBlue.png',
				new TSize(18, 18), {
			anchor : new TPixel(12, 24)
		});
	}
	var marker = new TMarker(point, markerOptions);
	map.addOverLay(marker);
	lngLatArr.push(point);*/
	//画点
	var point;
	if(pic != "" && pic != null) {
		point = {
				'lng':Number(lng),
				'lat':Number(lat), 
				'type': {
					imgUrl:rootDirectoryURL + '/attachment/showPicture?attachmentId=' + pic +'&isThumbnail=true',
					width:18,
					height:18,
					xoffset:-12,
					yoffset:-24
				}
			};
	} else{
		point = {
				'lng':Number(lng),
				'lat':Number(lat), 
				'type': {
					imgUrl:rootDirectoryURL + '/public/img/markerBlue.png',
					width:18,
					height:18,
					xoffset:-12,
					yoffset:-24
				}
			};
	}
	cntenMap.drawPoint(point);
	
}

//切换地图模式 
function piChange() {
	$(".mapChange").toggleClass('mapPic');

	if ($(".mapChange").hasClass('mapPic')) {
		//卫星图
		map.setMapType(TMAP_SATELLITE_MAP);
	} else {
		//街道图
		map.setMapType(TMAP_NORMAL_MAP);
	}

}
$(function() {
	MapLoad();
	getLngLat();
//	piChange();
});