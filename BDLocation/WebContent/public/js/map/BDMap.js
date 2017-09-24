/** BMap 百度地图API define：start*/
var BDMap = function(mapOption) {
	
	var BMAP_NAVIGATION_CONTROL_TYPE = {
			LARGE:'BMAP_NAVIGATION_CONTROL_LARGE',
			SMALL:'BMAP_NAVIGATION_CONTROL_SMALL',
			PAN:'BMAP_NAVIGATION_CONTROL_PAN',
			ZOOM:'BMAP_NAVIGATION_CONTROL_ZOOM'
	};
	
	this.map = null;							    												//百度地图对象
	
	//require
	this.mapWrap = mapOption.mapWrap;           													//地图容器
	this.centerPoint = new BMap.Point(mapOption.centerPoint.x,mapOption.centerPoint.y);			 	//中心点
	
	//option
	this.zoom = mapOption.zoom || 15;															    //地图缩放级别，为3-19	
	this.isAddControl = mapOption.isAddControl || false;											//添加地图类型控件        默认不添加		
	this.enableScrollWheelZoom = mapOption.enableScrollWheelZoom && true;									//开启鼠标滚轮缩放		  默认开启
	this.isAddNavigationControl = mapOption.isAddNavigationControl || false;								//添加地图导航空间        默认不添加
	this.navigationControlType = BMAP_NAVIGATION_CONTROL_TYPE[mapOption.navigationControlType]		//传参：'LARGE','SMALL','PAN','ZOOM' 默认LARGE
		|| BMAP_NAVIGATION_CONTROL_TYPE.LARGE;

	this.isEnableDragging = mapOption.isEnableDragging && true;										//是否开启拖拽
	//this.isEnableRangeSearch = mapOption.isEnableRangeSearch && true;								//是否开启区域搜索(划定一个矩形区域，获取区域中添加的坐标)
	
	var mapRange = mapOption.mapRange;									//地图范围
	

	//地图初始化方法
	this.init = function() {
		var self = this;
		if (!self.map) {
			self.map = new BMap.Map(self.mapWrap);
			self.map.centerAndZoom(self.centerPoint,self.zoom);	
			
			if(self.enableScrollWheelZoom) 															//是否启动滚轮缩放
				self.map.enableScrollWheelZoom();	
			
			if(self.isEnableDragging)	self.map.enableDragging();   									//开启拖拽
			else self.map.disableDragging();     													    //禁止拖拽
		}
		if (self.isAddControl) 																		//地图类型切换												
			self.map.addControl(new BMap.MapTypeControl());	 
		
		if (self.isAddNavigationControl) 
			self.map.addControl(new BMap.NavigationControl({type:self.navigationControlType}));
		
		if(mapRange && !$.isEmptyObject(mapRange)){												//设置地图范围
			setBounds(self.map,mapRange);
		}
		//if(self.isEnableRangeSearch) startDrawRect(self.map);                             //此功能需要引入DrawingManager_min.js/DrawingManager_min.css
		
		
		//添加地图事件
		self.map.addEventListener("click", function(e){
			var mapPoint = getMapPoint(e);			//经纬度
			var screenPoint = getScreenPoint(e);
			if($.isFunction(mapOption.click))
				mapOption.click(mapPoint, screenPoint);
		});
	};
	
	function setBounds(_map,range){
		//var b = new BMap.Bounds(new BMap.Point(range.xmin, range.ymin),new BMap.Point(range.xmax, range.ymax));
		var b = new BMap.Bounds(new BMap.Point(116.027143, 39.772348),new BMap.Point(116.832025, 40.126349));
		try {	
			BMapLib.AreaRestriction.setBounds(_map, b);
		} catch (e) {
			alert(e);
		}
	}
	
	
	/************************私有定义方法 开始********************************/
	/**
	 * e 鼠标事件对象
	 */
	function getScreenPoint(e){
		return new SreenPoint({x:e.pixel.x, y:e.pixel.y});
	}
	
	/**
	 * e 鼠标事件对象
	 */
	function getMapPoint(e){
		return new MapPoint({'lng' : e.point.lng, 'lat' : e.point.lat});
	}
	
	/************************私有定义方法 结束********************************/
	
	
	//百度地图画点方法
	this.drawPoint = function(mPoint) {
		var self = this,
			marker = null;
		if (mPoint.lng && mPoint.lat && Number(mPoint.lng)>0 && Number(mPoint.lat)>0 ) {
			var point = new BMap.Point(mPoint.lng,mPoint.lat);
			
			var iconWith = mPoint.type.width || 25;
			var iconHeight = mPoint.type.height || 25;
			var offsetX = mPoint.type.xoffset || 0;
			var offsetY = mPoint.type.yoffset || 0;
			var myIcon = new BMap.Icon(
				mPoint.type.imgUrl,
				new BMap.Size(iconWith,iconHeight),
				{
					offset:new BMap.Size(offsetX,offsetY),    //图片中央下端的尖叫位置	
				}
			);
		
		    marker = new BMap.Marker(point,{icon:myIcon});
		    marker.markerType = 'self-define';
		    marker.data = mPoint;
		    if (!$.isEmptyObject(mPoint.type)&& $.isFunction(mPoint.type.onClick)) {
		    	marker.addEventListener("click",function(e){
		    		mPoint.type.onClick(mPoint,null);
		    		// 阻止事件冒泡
					var ev = e || window.event;
					if (ev.stopPropagation) {
						ev.stopPropagation();
					} else if (window.event) {
						window.event.cancelBubble = true;		// 兼容IE
					}
				});
		    }
			self.map.addOverlay(marker);
		}
		return marker;	
	};
	
	//百度地图画线方法
	this.drawLine = function(mLine) {
		var self = this,
			line = null;
		var coordinatesList = [];
		if (mLine.pionts.length > 0) {
	        $.each(mLine.pionts, function(coordinateIndex, coordinateEntry) {
	        	if(coordinateEntry.lng && coordinateEntry.lat && Number(coordinateEntry.lng)>0 && Number(coordinateEntry.lat)>0){
		            coordinatesList.push(new BMap.Point(coordinateEntry.lng, coordinateEntry.lat));
	        	}
	        });
	        if(coordinatesList.length>0) {
	           line = new BMap.Polyline(coordinatesList,{
					strokeColor:mLine.color,
					strokeWeight:mLine.width,
					strokeOpacity:mLine.opacity || 1
				});
	            self.map.addOverlay(line);
	        }
	    }
		return line;
	};
	
	
	//地图经纬度坐标转换为平面地图像素坐标(pointToPixel)
	this.fromLngLatToContainerPixel = function(point) {
		var self = this;
		var lng = point.lng, lat = point.lat;
		var bPoint = new BMap.Point(lng,lat);
		var pixel = self.map.pointToPixel(bPoint);
		var screenPointOption = {
			x:pixel.x,
			y:pixel.y
		};
		return new SreenPoint(screenPointOption);
	};

	//平面地图像素坐标转换为地图经纬度坐标(pixelToPoint)
	this.fromContainerPixelToLngLat = function(point) {
		var self = this;
		var x = point.x,y = point.y;
		var bPixel = new BMap.Pixel(x,y);
		var point = self.map.pixelToPoint(bPixel);
		var pointOption = {
			lng:point.lng,
			lat:point.lat
		};
		return new MapPoint(pointOption);
	};
	
	
	//根据覆盖物设置合适的地图视窗
	this.setFitView = function() {
		var self = this;
		var overlays = this.map.getOverlays();
		var i=0,len=overlays.length;
		var points = [];
		for(i; i<len; i++) {
			var maker = overlays[i];
			if (maker instanceof BMap.Marker) {
				points.push(maker.getPosition());
			}
		}
		self.map.setViewport(points);
	};
	
	//设置地图中心点
	this.centerAt = function(lng,lat) {
		var self = this;
		self.map.setCenter(new BMap.Point(lng,lat));
	};
	
	//移除覆盖物
	this.removePoint = function(overlay) {
		var self = this;
		self.map.removeOverlay(overlay);
	};
	
	//移除覆盖物
	this.removeLine = function(overlay) {
		var self = this;
		self.map.removeOverlay(overlay);
	};
	
	//设置地图缩放比例
	this.setZoom = function(zoom) {
		var self = this;
		self.map.setZoom(zoom);
	};
	
	//获取可视区域
	this.getBounds = function() {
		var self = this;
		var bounds = self.map.getBounds();
		return new MapBounds(bounds.getSouthWest().lng,bounds.getSouthWest().lat,bounds.getNorthEast().lng,bounds.getNorthEast().lat);
	};
	
	/******************************************************区域范围查找点功能 start************************************************************/
	
	/**
	 * 创建鼠标画图对象
	 */
	function createDrawingManager(map){
		var drawingManager = null;
		var styleOptions = {
		        strokeColor:"red",    //边线颜色。
		        fillColor:"white",      //填充颜色。当参数为空时，圆形将没有填充效果。
		        strokeWeight: 1,       //边线的宽度，以像素为单位。
		        strokeOpacity: 1,	   //边线透明度，取值范围0 - 1。
		        fillOpacity: 0.6,      //填充的透明度，取值范围0 - 1。
		        strokeStyle: 'dashed' //边线的样式，solid或dashed。
		    };
		
		//实例化鼠标绘制工具
		if(!drawingManager) {
		    drawingManager = new BMapLib.DrawingManager(map, {  
				//使用鼠标工具需要引入鼠标工具开源库DrawingManager_min.js及样式文件DrawingManager_min.css  
						isOpen: false, //是否开启绘制模式  
						enableDrawingTool: true, //是否显示工具栏  
						drawingToolOptions: {  
							anchor: BMAP_ANCHOR_TOP_RIGHT, //位置  
							offset: new BMap.Size(5, 5), //偏离值  
							scale: 0.8, //工具栏缩放比例  
							drawingModes: [
								BMAP_DRAWING_RECTANGLE 
							]
						},
						
						rectangleOptions: styleOptions //矩形的样式
				}); 
				drawingManager.setDrawingMode(BMAP_DRAWING_RECTANGLE);  
		}
		return drawingManager;
	}
	
	/**
	 * 获取地图全选框中的点
	 */
	this.selectOverlay = function(callBack) {
		debugger;
		var self = this;
		//创建画图对象
		var drawingManager = createDrawingManager(self.map);
		drawingManager.open();
		
		drawingManager.addEventListener('rectanglecomplete', function(e,overlay) {  

	        drawingManager.close();  
			var _b = e.getBounds();
			
			var overlays =  self.map.getOverlays(),
				inRangeMarkers = [];						//清空数组中以前的数据
			for(var i=0,l=overlays.length; i<l; i++) {
				var _m = overlays[i];
				if(_m instanceof BMap.Marker && _m.markerType == 'self-define') {
					if(_b.containsPoint(_m.getPosition())) {
						inRangeMarkers.push(_m.data);   //将点中的业务数据以数组形式返回
					}
				}
			}
			
			//返回后清除覆盖物
			if(overlay)  self.map.removeOverlay(overlay);
			
			if($.isFunction(callBack)){
				callBack(inRangeMarkers);
				drawingManager = null;
			}
			
			
		});
	};
	
	/******************************************************区域范围查找点功能 end**************************************************************/
			
			
	
	/******************************************************添加右键菜单功能 start**************************************************************/
	var menuItems = [], //传递进来的item
		hideMenuItems = [],
		BdMapMenuItems = [], //地图item对象
		menu = null;
	//地图添加右键菜单
	/*
	 *  item 格式
	 * var txtMenuItem = [
			{
				id:"xx1",
				text:'放大',
				callback:function(){map.zoomIn();}
				hide:true|false	  //默认展示
			},
			{
				id:"xx2",
				text:'缩小',
				callback:function(){map.zoomOut();}
				hide:true|false   //默认展示
			}
		];
	 */
	function addContextMenu(target) {
		menu = new BMap.ContextMenu();
		for(var i=0,l=menuItems.length; i < l; i++){
			if(menuItems[i] && !menuItems[i].hide) {
				var menuItem = new BMap.MenuItem(menuItems[i].text,menuItems[i].callback,100);
				BdMapMenuItems.push(menuItem);
				menu.addItem(menuItem);
			}
		}
		target.addContextMenu(menu);
	};
	
	//增加菜单项
	this.addRightMenu = function(items) {
		debugger;
		var self = this;
		self.map.addContextMenu(null);
		menuItems = menuItems.concat(items);
		addContextMenu(self.map);
	};
	
	function getMenuItemTextName(id){
		for(var i=0,l=menuItems.length; i<l; i++){
			if(menuItems[i].id === id)
				return menuItems[i].text;
		}
	}
	
	
	//隐藏特定菜单项(传一系列菜单ID 或者一个ID数组)
	this.removeMenuItem = function(itemIds) {
		hideMenuItems = hideMenuItems.concat(itemIds);
		for(var i=0,il=hideMenuItems.length; i<il;i++){
			for(var j=0,jl=BdMapMenuItems.length; j < jl; j++){
				if(BdMapMenuItems[j] && BdMapMenuItems[j].Vg === getMenuItemTextName(hideMenuItems[i])) {
					var menuItem = BdMapMenuItems[j];
					menu.removeItem(menuItem);
				}
			}
		}
	};
	
	//在指定位置插入按钮项(一个一个添加)
	this.addMenuItem = function(item) {
		if(item) {
			var menuItem = new BMap.MenuItem(item.text,item.callback,100);
			BdMapMenuItems.push(menuItem);
			menu.addItem(menuItem);
		}
	};
	/******************************************************添加右键菜单功能 end**************************************************************/
};
BDMap.CLASS_NAME = 'BDMap';
/** BMap 百度地图API define：end*/