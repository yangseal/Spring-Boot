!function ($) {
	$.extend({
		getJSONP : function (a) {
			$.ajax({  
		        async : false,  
		        cache : false,  
		        type : 'POST',  
		        dataType : "json",  
		        url : a,  
		        error : function (e) {//请求失败处理函数 
		        	myAlert('获取地址数据失败');  
		        },  
		        success:function(data){ //请求成功后处理函数。
		        	getAreaListcallback(data);
		        }
		    }); 
		}
	});
}(jQuery);

var iplocation = null;

var provinceCityJson = null;

//根据省份ID获取名称
function getNameById(provinceId){
	for(var o in iplocation){
		if (iplocation[o]&&iplocation[o].id==provinceId){
			return o;
		}
	}
	return "北京";
}

var isUseServiceLoc = true; //是否默认使用服务端地址

/**
 * 选择省
 * @param provinceId
 */
function chooseProvince(provinceId){
	provinceContainer.hide();
	currentAreaInfo.currentLevel = 1;
	currentAreaInfo.currentProvinceId = provinceId;
	currentAreaInfo.currentProvinceName = getNameById(provinceId);
	if(!page_load){
		currentAreaInfo.currentCityId = 0;
		currentAreaInfo.currentCityName = "";
		currentAreaInfo.currentAreaId = 0;
		currentAreaInfo.currentAreaName = "";
		currentAreaInfo.currentTownId = 0;
		currentAreaInfo.currentTownName = "";
	}
	areaTabContainer.eq(0).removeClass("curr").find("em").html(currentAreaInfo.currentProvinceName);
	areaTabContainer.eq(2).hide();
	areaTabContainer.eq(3).hide();
	areaContainer.hide();
	townaContainer.hide();
	if(provinceCityJson[""+provinceId] && provinceCityJson[""+provinceId].length > 0){
		areaTabContainer.eq(1).addClass("curr").show().find("em").html("请选择");
		cityContainer.show();
		cityContainer.html(getAreaList(provinceCityJson[""+provinceId]));
		cityContainer.find("a").click(function(){
			stopPropagation();
			if(page_load){
				page_load = false;
			}
			$("#store-selector", locationContainer).unbind("mouseout");
			chooseCity($(this).attr("data-value"),$(this).html());
		});
		if(page_load){ //初始化加载
			if(currentAreaInfo.currentCityId){
				chooseCity(currentAreaInfo.currentCityId,cityContainer.find("a[data-value='"+currentAreaInfo.currentCityId+"']").html());
			}
			else{
				chooseCity(cityContainer.find("a").eq(0).attr("data-value"),cityContainer.find("a").eq(0).html());
			}
		}
	}else {
		areaTabContainer.eq(0).addClass("curr").show().find("em").html("请选择");
		provinceContainer.show();
		currentAreaInfo.currentCityId = 0;
		currentAreaInfo.currentCityName = "";
		$('#store-selector', locationContainer).removeClass('hover');
		if(page_load){
			page_load = false;
		}
		$("input[location='city']", locationContainer).val("");
		if($("input[location='province']"), locationContainer)
			$("input[location='province']", locationContainer).val(currentAreaInfo.currentProvinceId);
		if($("input[location='oamAreaId']"), locationContainer)
			$("input[location='oamAreaId']", locationContainer).val(currentAreaInfo.currentProvinceId);
			
		var address = currentAreaInfo.currentProvinceName;
		$("#store-selector .text div", locationContainer).html(currentAreaInfo.currentProvinceName).attr("title",address);
	}
}


/**
 * 选择市
 * @param cityId
 * @param cityName
 */
function chooseCity(cityId,cityName){
	provinceContainer.hide();
	currentAreaInfo.currentLevel = 2;
	currentAreaInfo.currentCityId = cityId;
	currentAreaInfo.currentCityName = cityName;
	if(!page_load){
		currentAreaInfo.currentAreaId = 0;
		currentAreaInfo.currentAreaName = "";
		currentAreaInfo.currentTownId = 0;
		currentAreaInfo.currentTownName = "";
	}
	$('#store-selector', locationContainer).removeClass('hover');
	if(page_load){
		page_load = false;
	}
	if($("input[location='province']"), locationContainer)
		$("input[location='province']", locationContainer).val(currentAreaInfo.currentProvinceId);
	if($("input[location='city']"), locationContainer)
		$("input[location='city']", locationContainer).val(currentAreaInfo.currentCityId);
	if($("input[location='oamAreaId']"), locationContainer)
		$("input[location='oamAreaId']", locationContainer).val(currentAreaInfo.currentCityId);	
	
	var address = currentAreaInfo.currentProvinceName + " " + currentAreaInfo.currentCityName + " " + 
					currentAreaInfo.currentAreaName + " " + currentAreaInfo.currentTownName;
	$("#store-selector .text div", locationContainer).html(currentAreaInfo.currentProvinceName + " " +
			cleanKuohao(currentAreaInfo.currentCityName)).attr("title",address);
}

/**
 * 选择市
 * @param cityId
 * @param cityName
 */
function chooseCity_bak(cityId,cityName){
	provinceContainer.hide();
	cityContainer.hide();
	currentAreaInfo.currentLevel = 2;
	currentAreaInfo.currentCityId = cityId;
	currentAreaInfo.currentCityName = cityName;
	if(!page_load){
		currentAreaInfo.currentAreaId = 0;
		currentAreaInfo.currentAreaName = "";
		currentAreaInfo.currentTownId = 0;
		currentAreaInfo.currentTownName = "";
	}
	areaTabContainer.eq(1).removeClass("curr").find("em").html(cityName);
	areaTabContainer.eq(2).addClass("curr").show().find("em").html("请选择");
	areaTabContainer.eq(3).hide();
	areaContainer.show().html("<div class='iloading'>正在加载中，请稍候...</div>");
	townaContainer.hide();
	currentDom = areaContainer;
	$.getJSONP( CONTEXT_PATH + "/oamArea/getAreaByPid?pId=" + cityId);
}

function getAreaList(result){
	var html = ["<ul class='area-list'>"];
	var longhtml = [];
	var longerhtml = [];
	if (result&&result.length > 0){
		for (var i=0,j=result.length;i<j ;i++ ){
			result[i].name = result[i].name.replace(" ","");
			if(result[i].name.length > 12){
				longerhtml.push("<li class='longer-area'><a href='javascript:void(0);' data-value='"+result[i].id+"'>"+result[i].name+"</a></li>");
			}
			else if(result[i].name.length > 5){
				longhtml.push("<li class='long-area'><a href='javascript:void(0);' data-value='"+result[i].id+"'>"+result[i].name+"</a></li>");
			}
			else{
				html.push("<li><a href='javascript:void(0);' data-value='"+result[i].id+"'>"+result[i].name+"</a></li>");
			}
		}
	}
	else{
		html.push("<li><a href='javascript:void(0);' data-value='"+currentAreaInfo.currentFid+"'> </a></li>");
	}
	html.push(longhtml.join(""));
	html.push(longerhtml.join(""));
	html.push("</ul>");
	return html.join("");
}

/**
 * 清除括号
 * @param str
 * @returns
 */
function cleanKuohao(str){
	if(str&&str.indexOf("(")>0){
		str = str.substring(0,str.indexOf("("));
	}
	if(str&&str.indexOf("（")>0){
		str = str.substring(0,str.indexOf("（"));
	}
	return str;
}

function getStockOpt(id,name){
	if(currentAreaInfo.currentLevel==3){
		currentAreaInfo.currentAreaId = id;
		currentAreaInfo.currentAreaName = name;
		if(!page_load){
			currentAreaInfo.currentTownId = 0;
			currentAreaInfo.currentTownName = "";
		}
	}else if(currentAreaInfo.currentLevel==4){
		currentAreaInfo.currentTownId = id;
		currentAreaInfo.currentTownName = name;
	}
	//添加20140224
	$('#store-selector', locationContainer).removeClass('hover');
	if(page_load){
		page_load = false;
	}
	//替换gSC
	var address = currentAreaInfo.currentProvinceName + " " + currentAreaInfo.currentCityName + " " + 
	currentAreaInfo.currentAreaName + " " +currentAreaInfo.currentTownName;
	$("#store-selector .text div", locationContainer).html(currentAreaInfo.currentProvinceName
			+ " " + cleanKuohao(currentAreaInfo.currentCityName) + " " + cleanKuohao(currentAreaInfo.currentAreaName) + " " + 
			cleanKuohao(currentAreaInfo.currentTownName)).attr("title",address);
}

/**
 * 返回数据处理
 * @param r
 */
function getAreaListcallback(r){
	currentDom.html(getAreaList(r));
	if (currentAreaInfo.currentLevel >= 2){
		currentDom.find("a").click(function(){
			stopPropagation();
			if(page_load){
				page_load = false;
			}
			if(currentDom.attr("id")=="stock_area_item"){
				currentAreaInfo.currentLevel=3;
			}
			else if(currentDom.attr("id")=="stock_town_item"){
				currentAreaInfo.currentLevel=4;
			}
			getStockOpt($(this).attr("data-value"),$(this).html());
		});
		if(page_load){ //初始化加载
			currentAreaInfo.currentLevel = currentAreaInfo.currentLevel==2?3:4;
			if(currentAreaInfo.currentAreaId){
				getStockOpt(currentAreaInfo.currentAreaId,currentDom.find("a[data-value='"+currentAreaInfo.currentAreaId+"']").html());
			}else{
				getStockOpt(currentDom.find("a").eq(0).attr("data-value"),currentDom.find("a").eq(0).html());
			}
		}
	}
}

function chooseArea(areaId,areaName){
	provinceContainer.hide();
	cityContainer.hide();
	areaContainer.hide();
	currentAreaInfo.currentLevel = 3;
	currentAreaInfo.currentAreaId = areaId;
	currentAreaInfo.currentAreaName = areaName;
	if(!page_load){
		currentAreaInfo.currentTownId = 0;
		currentAreaInfo.currentTownName = "";
	}
	areaTabContainer.eq(2).removeClass("curr").find("em").html(areaName);
	areaTabContainer.eq(3).addClass("curr").show().find("em").html("请选择");
	townaContainer.show().html("<div class='iloading'>正在加载中，请稍候...</div>");
	currentDom = townaContainer;
	$.getJSONP(CONTEXT_PATH + "/oamArea/getAreaByPid?pId=" + areaId);
}

//选择器
var areaTabContainer = null;
var provinceContainer = null;
var cityContainer = null;
var areaContainer = null;
var townaContainer = null;
var currentDom = null;

function getCookie(name) {
	var start = document.cookie.indexOf(name + "=");
	var len = start + name.length + 1;
	if ((!start) && (name != document.cookie.substring(0, name.length))) {
		return null;
	}
	if (start == -1) return null;
	var end = document.cookie.indexOf(';', len);
	if (end == -1) end = document.cookie.length;
	return unescape(document.cookie.substring(len, end));
};


//当前地域信息
var currentAreaInfo;

/**
 * 初始化当前地域信息
 */
function currentAreaInfoInit(areaInfo){
	currentAreaInfo =  {"currentTownId":0,
						"currentTownName":""};
	var ipLoc =  getCookie("ipLoc-djd");
	ipLoc = areaInfo || (ipLoc ? ipLoc.split("-"):[]);
	if(ipLoc.length>0&&ipLoc[0]){
		currentAreaInfo.currentProvinceId = ipLoc[0];
		currentAreaInfo.currentProvinceName = getNameById(ipLoc[0]);
	}
	if(ipLoc.length>1&&ipLoc[1]){
		currentAreaInfo.currentCityId = ipLoc[1];
	}
	if(ipLoc.length>2 && ipLoc[2]){
		currentAreaInfo.currentAreaId = ipLoc[2];
	}
	if(ipLoc.length>3 && ipLoc[3]){
		currentAreaInfo.currentTownId = ipLoc[3];
	}
}

var provinceHtmlPre = '<div class="content"><div data-widget="tabs" class="m JD-stock" id="JD-stock">'
					+'<div class="mt">'
					+'    <ul class="tab">'
					+'        <li data-index="0" data-widget="tab-item" class="curr"><a href="javascript:void(0);" class="hover"><em>请选择</em><i></i></a></li>'
					+'        <li data-index="1" data-widget="tab-item" style="display:none;"><a href="javascript:void(0);" class=""><em>请选择</em><i></i></a></li>'
					+'        <li data-index="2" data-widget="tab-item" style="display:none;"><a href="javascript:void(0);" class=""><em>请选择</em><i></i></a></li>'
					+'        <li data-index="3" data-widget="tab-item" style="display:none;"><a href="javascript:void(0);" class=""><em>请选择</em><i></i></a></li>'
					+'    </ul>'
					+'    <div class="stock-line"></div>'
					+'</div>'
					+'<div class="mc" data-area="0" data-widget="tab-content" id="stock_province_item">'
					+'    <ul class="area-list">' ;
					
var provinceHtmlAfter = '    </ul>'
			+'</div>'
			+'<div class="mc" data-area="1" data-widget="tab-content" id="stock_city_item"></div>'
			+'<div class="mc" data-area="2" data-widget="tab-content" id="stock_area_item"></div>'
			+'<div class="mc" data-area="3" data-widget="tab-content" id="stock_town_item"></div>'
			+'</div>' +
			'</div>';

function initArea(locationContainer){
	
	$.ajax({  
        async : false,  
        cache : false,  
        type : 'POST',  
        dataType : "json",  
        url : CONTEXT_PATH + '/oamArea/getPCity',  
        error : function (e) {//请求失败处理函数 
        	myAlert('获取地址数据失败');  
        },  
        success:function(data){ //请求成功后处理函数。
        	iplocation = data.pJson;
        	provinceCityJson = data.cJson;
        	var pHtml = "";
        	if(iplocation){
        		for(var p in iplocation){
        			pHtml += '<li><a href="javascript:void(0);" data-value="' + iplocation[p].id + '">' + p + '</a></li>';
        		}
        	}
        	
        	$("#store-selector .text", locationContainer).after(provinceHtmlPre + pHtml + provinceHtmlAfter);
        	areaTabContainer = $("#JD-stock .tab li", locationContainer);
        	provinceContainer = $("#stock_province_item", locationContainer);
        	cityContainer = $("#stock_city_item", locationContainer);
        	areaContainer = $("#stock_area_item", locationContainer);
        	townaContainer = $("#stock_town_item", locationContainer);
        	currentDom = provinceContainer;
        }  
    }); 
}

var page_load = true;
//var locationContainer = $('body');
var Location = {
		init : function(areaInfo, container){
			(function(areaInfo, container){
				$(document.body).unbind('click').bind('click',function(){
					$('#store-selector', locationContainer).removeClass('hover');
				});
				
				if(container)
					locationContainer = container;
				$("#store-selector", container).unbind("mouseover").bind("mouseover", function(){
					 locationContainer = container;
					 areaTabContainer = $("#JD-stock .tab li", locationContainer);
			         provinceContainer = $("#stock_province_item", locationContainer);
			         cityContainer = $("#stock_city_item", locationContainer);
					 
					$('#store-selector', container).addClass('hover');
					$("#store-selector .content,#JD-stock", container).show();
				}).find("dl").remove();
				
				$("#store-selector", container).unbind("mouseout").bind("mouseout", function(){
					locationContainer = container;
					$('#store-selector', container).removeClass('hover');
					$("#store-selector .content,#JD-stock", container).hide();
				});
				
				$("#store-selector div.close",container).unbind('click').bind('click', function(){
					locationContainer = container;
					stopPropagation();
					$('#store-selector', container).removeClass('hover');
				});
				initArea(container);
				currentAreaInfoInit(areaInfo);
				var _new = $("#JD-stock .tab li", locationContainer);
				areaTabContainer.eq(0).find("a").click(function(){
					
					stopPropagation();
					areaTabContainer.removeClass("curr");
					areaTabContainer.eq(0).addClass("curr").show();
					provinceContainer.show();
					cityContainer.hide();
					areaContainer.hide();
					townaContainer.hide();
					areaTabContainer.eq(1).hide();
					areaTabContainer.eq(2).hide();
					areaTabContainer.eq(3).hide();
				});
				
				areaTabContainer.eq(1).find("a").click(function(){
					stopPropagation();
					areaTabContainer.removeClass("curr");
					areaTabContainer.eq(1).addClass("curr").show();
					provinceContainer.hide();
					cityContainer.show();
					areaContainer.hide();
					townaContainer.hide();
					areaTabContainer.eq(2).hide();
					areaTabContainer.eq(3).hide();
				});
				areaTabContainer.eq(2).find("a").click(function(){
					stopPropagation();
					areaTabContainer.removeClass("curr");
					areaTabContainer.eq(2).addClass("curr").show();
					provinceContainer.hide();
					cityContainer.hide();
					areaContainer.show();
					townaContainer.hide();
					areaTabContainer.eq(3).hide();
				});
				provinceContainer.find("a").click(function() {
					stopPropagation();
					if(page_load){
						page_load = false;
					}
					$("#store-selector", locationContainer).unbind("mouseout");
					chooseProvince($(this).attr("data-value"));
				}).end();
				if(currentAreaInfo.currentProvinceId)
					chooseProvince(currentAreaInfo.currentProvinceId);
				else if(areaInfo && areaInfo[4])
					$("#store-selector .text div", locationContainer).html(areaInfo[4]).attr("title", areaInfo[4]);
				else
					$("#store-selector .text div", locationContainer).html("请选择地址").attr("title", "请选择地址");
			})(areaInfo, container);
		}
};