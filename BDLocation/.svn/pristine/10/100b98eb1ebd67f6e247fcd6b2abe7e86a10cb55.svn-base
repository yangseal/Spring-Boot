/** 高德autonavi 地图API Define：begin */
var AutoNaviMap = function(mapOption){
	
	this.map = null;													//高德autonavi地图对象
	
	var mapWrap = mapOption.mapWrap;									//地图容器
	
	var mapRange = mapOption.mapRange;									//地图范围
	
	var centerPoint = mapOption.centerPoint;							//中心点
	
	var mousetool = null;
	
	this.zoom = mapOption.zoom || 14;									//初始化地图级别
	this.init = function(){
		var _self = this;
		if(!_self.map){ 
			var option = {resizeEnable : true,						//监控地图容器尺寸变化，默认为false
							zoom : _self.zoom, 							    //显示级别
							logo : false};
			if(centerPoint && !$.isEmptyObject(centerPoint)){					//设置中心点
				var transCoordinate = {};
				transCoordinate.lng = centerPoint.x;
				transCoordinate.lat = centerPoint.y;
				if(!mapOption.noTransAmap) {
					centerPoint.lng = centerPoint.x;
					centerPoint.lat = centerPoint.y;
					transCoordinate = _self.get_GCJLngLat(centerPoint);
        		}
				option['center'] = new AMap.LngLat(transCoordinate.lng, transCoordinate.lat);
			}
			_self.map = new AMap.Map(mapWrap, option);
			//地图单击事件
			if(mapOption.click && $.isFunction(mapOption.click)) {
				_self.map.on('click',function(e){
					var mapPoint = getMapPoint(e);			//经纬度
					var screenPoint = getScreenPoint(e);
					mapOption.click(mapPoint, screenPoint);
				});  //点事件的获取
			}
			//设置地图范围
			if(mapRange && !$.isEmptyObject(mapRange)){						//设置地图范围
				var bounds = new AMap.Bounds([mapRange.xmin, mapRange.ymin],[mapRange.xmax, mapRange.ymax]);
				_self.map.setBounds(bounds);
			}
			//工具条
			if(mapOption.isAddNavigationControl) {
				AMap.plugin(["AMap.ToolBar"], function() {
					_self.map.addControl(new AMap.ToolBar());
				});
			}
			if(mapOption.isAddControl) {
				AMap.plugin(['AMap.MapType'],function(){
					_self.map.addControl(new AMap.MapType());
			    });
			}
		}
	};
	
	
	
	
	this.drawLine = function(mLine){
		var _self = this;
		var polyLine = {};
		var coordinatesList = [];
	    if (mLine.pionts.length > 0) {
	        $.each(mLine.pionts, function(coordinateIndex, coordinateEntry) {
	        	if(coordinateEntry.lng && coordinateEntry.lat && Number(coordinateEntry.lng)>0 && Number(coordinateEntry.lat)>0){
	        		//若不是从天地图转换为高德地图，则不用转换坐标系
	        		var transCoordinate = coordinateEntry;
	        		if(!mLine.noTransAmap) {
	        			transCoordinate = _self.get_GCJLngLat(coordinateEntry);
	        		}
		            coordinatesList.push(new AMap.LngLat(transCoordinate.lng, transCoordinate.lat));
	        	}
	        });
	        if(coordinatesList.length>0) {
	        	polyLine = new AMap.Polyline({
	        		map:_self.map,
	        		path: coordinatesList,          //设置线覆盖物路径
	        		strokeColor: mLine.color, //线颜色
	        		strokeOpacity: mLine.opacity,       //线透明度
	        		strokeWeight: mLine.width,        //线宽
	        		strokeStyle: mLine.style,   //线样式
	        		lineJoin   : 'round',
	        		strokeDasharray: mLine.dasharray //补充线样式
	        	});
	        }
	        
	        if(mLine.infowindow && !$.isEmptyObject(mLine.infowindow)) {
				/*var infowindow = new AMap.InfoWindow({
					content:mLine.infowindow.content,
					offset:new AMap.Pixel(mLine.infowindow.xoffset,mLine.infowindow.yoffset),
					size:new AMap.Size(mLine.infowindow.width,mLine.infowindow.height)
				});*/
	        	if(!$('body').find('#infowindow').length>0) {
	        		var html = '<div id="infowindow" style="position:absolute;display:none" class="box_wraper"><div class="box_con"><p></p></div><div class="box_img"><img src="/platform/images/box_img.png"/></div></div>';
	        		$('body').append(html);
	        	}
				polyLine.on('mouseover',function(e) {
//					infowindow.open(_self.map,e.target.getPosition());
					$('body').find('#infowindow p').html(mLine.infowindow.content);
					$('#infowindow').show();
					//获取地图容器在浏览器中的偏移
					var offset = $('#'+ mapWrap).offset();
					$('#infowindow').css("left",e.pixel.x-$('#infowindow').width()/2 + offset.left);
					$('#infowindow').css("top",e.pixel.y-$('#infowindow').height() + offset.top);
				});
				polyLine.on('mouseout',function(e) {
//					infowindow.close();
					$('#infowindow').hide();
				});
			}
	    }
	    return polyLine;
	};
	
	this.drawPoint = function(mPoint){
		var _self = this;
		var transCoordinate = mPoint;
		//若不是从天地图转换为高德地图，则不用转换坐标系
		if(!mPoint.noTransAmap) {
			transCoordinate = _self.get_GCJLngLat(mPoint);
		}
		var marker = {};
		if(mPoint.lng && mPoint.lat && Number(mPoint.lng)>0 && Number(mPoint.lat)>0){
			var icon = new AMap.Icon({
				size : new AMap.Size(mPoint.type.width,mPoint.type.height),
				imageSize:new AMap.Size(mPoint.type.width,mPoint.type.height),
				image:mPoint.type.imgUrl
			});
			var pointOpitons = {
				map:_self.map,
				icon:icon,
				position:[transCoordinate.lng,transCoordinate.lat],
				offset:new AMap.Pixel(mPoint.type.xoffset, mPoint.type.yoffset),  //偏移量
				title:mPoint.type.title,         //点的文字提示
				extData:mPoint
			};
			marker = new AMap.Marker(pointOpitons);
			if(mPoint.type.onClick && $.isFunction(mPoint.type.onClick)) {
				marker.on('click',function(e){
					mPoint.type.onClick(e.target.getExtData(),null);
				});  //点事件的获取
			}
			
			if(mPoint.type.infowindow && !$.isEmptyObject(mPoint.type.infowindow)) {
				/*var infowindow = new AMap.InfoWindow({
					content:mPoint.type.infowindow.content,
					offset:new AMap.Pixel(mPoint.type.infowindow.xoffset,mPoint.type.infowindow.yoffset),
					size:new AMap.Size(mPoint.type.infowindow.width,mPoint.type.infowindow.height)
				});*/
				if(!$('body').find('#infowindow').length>0) {
					var html = '<div id="infowindow" style="position:absolute;display:none" class="box_wraper"><div class="box_con"><p></p></div><div class="box_img"><img src="/BDLocation/public/img/box_img.png"/></div></div>';
					$('body').append(html);
				}
				
				marker.on('mouseover',function(e) {
					$('body').find('#infowindow p').html(mPoint.type.infowindow.content);
					var tmpPixel = _self.map.lngLatToContainer(e.target.getPosition());
					$('#infowindow').show();
					//获取地图容器在浏览器中的偏移
					var offset = $('#'+ mapWrap).offset();
					$('#infowindow').css("left",tmpPixel.x-$('#infowindow').width()/2 + offset.left);
					$('#infowindow').css("top",tmpPixel.y-$('#infowindow').height() + offset.top - Math.abs(e.target.getOffset().y));
				});
				marker.on('mouseout',function(e) {
					$('#infowindow').hide();
				});
			}
		}
		
//		if(mPoint.type.infowindow && !$.isEmptyObject(mPoint.type.infowindow)) {
//			/*var infowindow = new AMap.InfoWindow({
//				content:mPoint.type.infowindow.content,
//				offset:new AMap.Pixel(mPoint.type.infowindow.xoffset,mPoint.type.infowindow.yoffset),
//				size:new AMap.Size(mPoint.type.infowindow.width,mPoint.type.infowindow.height)
//			});*/
//			if(!$('body').find('#infowindow').length>0) {
//				var html = '<div id="infowindow" style="position:absolute;display:none" class="box_wraper"><div class="box_con"><p></p></div><div class="box_img"><img src="/BDLocation/public/img/box_img.png"/></div></div>';
//				$('body').append(html);
//			}
//			
//			marker.on('mouseover',function(e) {
//				$('body').find('#infowindow p').html(mPoint.type.infowindow.content);
//				var tmpPixel = _self.map.lngLatToContainer(e.target.getPosition());
//				$('#infowindow').show();
//				//获取地图容器在浏览器中的偏移
//				var offset = $('#'+ mapWrap).offset();
//				$('#infowindow').css("left",tmpPixel.x-$('#infowindow').width()/2 + offset.left);
//				$('#infowindow').css("top",tmpPixel.y-$('#infowindow').height() + offset.top - Math.abs(e.target.getOffset().y));
//			});
//			marker.on('mouseout',function(e) {
//				$('#infowindow').hide();
//			});
//		}
		return marker;
	};
	
	
	this.fromLngLatToContainerPixel = function(mPoint) {
		var _self = this;
		var retObj = _self.map.lnglatToPixel(new AMap.LngLat(mPoint.lng,mPoint.lat));
		return new SreenPoint(retObj);
	};
	
	this.fromContainerPixelToLngLat = function(mPoint) {
		var _self = this;
		var retObj = _self.map.pixelToLngLat(new AMap.Pixel(mPoint.x,mPoint.y));
		return new MapPoint(retObj);
	};
	this.setFitView = function() {
		var _self = this;
		_self.map.setFitView();
	};
	this.get_GCJLngLat = function(mPoint) {
		var retObj = {};
		var CT = new CoordinateTransform(mPoint.lat, mPoint.lng, CoordinateSys.WGS84);//CoordinateSys.WGS84 是转换前的坐标系
        if (CT.WGS84ToBD09()== false)//WGS84ToBD09()方法 WGS84转BD坐标，如果是转成火星坐标改调用WGS84ToGCJ02()
        console.info(CT.get_ErrMsg());
        retObj.lat = CT.get_GCJLat() == 0 ? mPoint.lat : CT.get_GCJLat();//获取转换后的高德坐标纬度
        retObj.lng = CT.get_GCJLng() == 0 ? mPoint.lng : CT.get_GCJLng();//获取转换后的高德坐标精度
		return retObj;
	};
	
	/**
	 * 设置中心点
	 * lng 纬度
	 * lat 经度
	 */
	this.centerAt = function(lng, lat,callFunc){
		this.map.setCenter(new AMap.LngLat(lng, lat));
		callFunc();
	};
	/**
	 * 删除点
	 * point 为map地图对象， drawPoint时返回
	 */
	this.removePoint = function(point){
		this.map.remove(point);
	};
	/**
	 * 删除线
	 * line 为map地图对象， drawLine时返回
	 */
	this.removeLine = function(line){
		this.map.remove(line);
	};
	/**
	 * 设置级别
	 * zoom  Number
	 */
	this.setZoom = function(zoom){
		this.map.setZoom(zoom);
	};
	/**
	 * 获取可视区域
	 */
	this.getBounds = function(){
		//TODO 返回MapBounds 对象
		var bounds = this.map.getBounds();
//		alert('lng:' + bounds.xmin + ';lat:' + bounds.ymin);	//左下角， 西南坐标
//		alert('lng:' + bounds.xmax + ';lat:' + bounds.ymax);	//右上角， 东北坐标
		return new MapBounds(bounds.southwest.lng, bounds.southwest.lat, bounds.northeast.lng, bounds.northeast.lat);
	}
	
	/**
	 * e 鼠标事件对象
	 */
	function getScreenPoint(e){
		return new SreenPoint({x:e.pixel.x, y:e.pixel.y});
	};
	
	/**
	 * e 鼠标事件对象
	 */
	function getMapPoint(e){
		return new MapPoint({'lng' : e.lnglat.lng, 'lat' : e.lnglat.lat});
	};
	
	/**
	 * 圈选覆盖物
	 */
	this.selectOverlay = function(callBack){
		var _self = this;
		AMap.plugin(["AMap.MouseTool"], function() {
			_self.map.setDefaultCursor("crosshair");
	        mousetool = new AMap.MouseTool(_self.map);
			//通过rectOptions更改拉框放大时鼠标绘制的矩形框样式
	        var rectOptions = {
                strokeStyle: "solid",
                strokeColor: "#FF0000",
                fillColor: "#C0C0C0",
                fillOpacity: 0.5,
                strokeOpacity: 1,
                strokeWeight: 2
	        };
	        mousetool.rectangle(rectOptions);    
	        AMap.event.addListener(mousetool ,"draw",function(e){
	        	var curBounds = e.obj.getBounds();
	        	var allPoints = _self.map.getAllOverlays("marker");
	        	var resultMarker = [];
	        	for(var i = 0; i<allPoints.length;i++) {
	        		if(curBounds.contains(allPoints[i].getPosition())) {
	        			resultMarker.push(allPoints[i].getExtData());
	        		}
	        	}
	        	_self.map.remove(e.obj);
	        	mousetool.close();
	        	_self.map.setDefaultCursor("pointer");
	        	if($.isFunction(callBack)) {
	        		callBack(resultMarker);
	        	}
	        });
		 });
	};
};
AutoNaviMap.CLASS_NAME = "AutoNaviMap";
/** Arcgis 地图API Define：end */