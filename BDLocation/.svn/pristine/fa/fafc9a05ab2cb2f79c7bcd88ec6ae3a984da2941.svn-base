$(function(){
	// 底部收缩
	$(".tip_box p").click(function(){
	  $('.select_con').show();
	});
	$(".sel_box i").click(function(){
	  $('.select_con').hide();
	});
	
	MapLoad();
	getLngLat();
	
	writePoint(116.422693,39.977873);
});

function MapLoad() {
	if (companylat && companylat != "null" && companylat != "" && companylat != '""') {
		
	} else {
		companylng = 116.422693;
		companylat = 39.977873;
	}
	var mapOption = {
			'mapWrap' : 'map-wrap',						//地图容器
			'centerPoint' : {'x':companylng ,'y':companylat},		//中心点
			'mapClass' : AutoNaviMap,				//地图组件
			'zoom':7							//初始级别
		};
	cntenMap = new CntenMap(mapOption);
	cntenMap.init();
	
	$("#stationCountNumber").text('102');
	$("#onStationNumber").text('96');
	$("#offStationNumber").text('6');
}

function getLngLat(){
	
	var url = CONTEXT_PATH + "/statistic/getStationRunState";
	$.post(url,null,function(data){
		//console.log("-----data:" + JSON.stringify(data));
		for(var i=0; i<data.length; i++){
			
			if(i == 27 || i == 36 || i == 37 || i == 96 || i == 47 || i == 33){
				data[i].isOnline = 0;
			}
			writePoint(data[i].base_lng, data[i].base_lat,data[i]);
		} 
		//cntenMap.setFitView();
	},'json');
}

var pointList = [];

function writePoint(lng, lat, obj) {
	//画点
	var htmlStr = "<div class='site_info'>" +
	    	"<p>基站名称: " + obj.station_name + "</p>" +
	    	"<p>所属客户: " + obj.customer_name + "</p>" +
	    	" <p>所在地: " + obj.own_city_name + "</p>" +
	    	"</div>";
	var _imgUrl = "/public/img/site_on.png";
	if(obj.isOnline == 0){
		_imgUrl = "/public/img/site_off.png";
	}
	
	var point = {
				'id':obj.base_construct_id,
				'lng':Number(lng),
				'lat':Number(lat), 
				'type': {
					imgUrl:CONTEXT_PATH + _imgUrl,
					width:48,
					height:48,
					xoffset:-12,
					yoffset:-24,
					infowindow: {
					     content: htmlStr,
					     xoffset: 0,
					     yoffset:-30,
					     width:230,
					     height:0
					}
				},
				'data':obj
			};
	pointList.push(point);
	cntenMap.drawPoint(point);
}

var searchByQueryRlt = [];
function queryWithCondition(){
	debugger;
	searchByQueryRlt.length = 0;
	
	var province = $('#provinceSelect option:selected').val(),
		owmCompany = $('#oweCompanyName').val(),
		OnOrOffline = $('input:radio[name="onOrOffline"]:checked').val(),
		searchCondition = "";
	
	if(province){
		searchCondition += "province == _point.data.own_province_name";
	}
	
	for(var i=0,len= pointList.length; i<len; i++){
		var _point = pointList[i];
		
		if(province && owmCompany){
			if(province == _point.data.own_province_name && 
					owmCompany && _point.data.customer_name.indexOf(owmCompany) != -1 &&
					OnOrOffline == _point.data.isOnline){
				searchByQueryRlt.push(_point);	
			}
		}else if(province){
			if(province == _point.data.own_province_name && 
					OnOrOffline == _point.data.isOnline){
				searchByQueryRlt.push(_point);	
			}
		}else if(owmCompany){
			if(_point.data.customer_name.indexOf(owmCompany) != -1 && 
					OnOrOffline == _point.data.isOnline){
				searchByQueryRlt.push(_point);	
			}
		}else{
			if(OnOrOffline == _point.data.isOnline){
				searchByQueryRlt.push(_point);	
			}
		}
		
	}
	var searchRltContent = $("#searchRltContent").empty();
	for(var j=0,jlen =searchByQueryRlt.length; j<jlen; j++){
		var searchPoint = searchByQueryRlt[j],
			online = 'site_on';
		if(searchPoint.data.isOnline == 0){
			online = 'site_off';
		}
		var $item = $("<li onclick=itemOnClick(this)>" + searchPoint.data.station_name + "<i class='" + online + "'></i></li>").data("entityData",searchPoint);
		searchRltContent.append($item);
	}
}

function itemOnClick(self){
	var entity = $(self).data('entityData');
	cntenMap.centerAt(entity.data.base_lng, entity.data.base_lng,function(){
		cntenMap.setZoom(7);
	});
}