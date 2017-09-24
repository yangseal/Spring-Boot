 
function InitMapByName(name) {
    mapObj = new AMap.Map('container');
    if (name != "") {
        mapObj.setCity(name);
    }
    mapObj.plugin(["AMap.ToolBar"], function() {
        //加载工具条
        var tool = new AMap.ToolBar();
        mapObj.addControl(tool);
    });
    mapObj.plugin(["AMap.Scale"], function() {
        //加载比例尺
        var scale = new AMap.Scale();
        mapObj.addControl(scale);
    });
    //加载鹰眼
    mapObj.plugin(["AMap.OverView"], function() {
        view = new AMap.OverView();
        mapObj.addControl(view);
    });

    //设置折线的属性
    var polylineOption = {
        strokeColor: "#FF33FF",
        strokeOpacity: 1,
        strokeWeight: 2
    }; 
}


function drawMap() {
    mapObj = new AMap.Map('container');
    if (name != "") {
        mapObj.setCity(name);
    }
    mapObj.plugin(["AMap.ToolBar"], function() {
        //加载工具条
        var tool = new AMap.ToolBar();
        mapObj.addControl(tool);
    }); 
    //设置折线的属性
    var polylineOption = {
        strokeColor: "#FF33FF",
        strokeOpacity: 1,
        strokeWeight: 2
    }; 
}

function InitMapMove() {
    AMap.event.addListener(mapObj, 'mapmove', function(e) {
        moveInfoWindow();
    });

    //拖拽地图结束
    AMap.event.addListener(mapObj, 'moveend', function(e) {
        moveInfoWindow();
    });
}


var mapMarkerCityList = function(item, recallClick) {
    this.item = item;
    this.markerroot;
    this.inforoot;
    this.recallClick = recallClick;
}

mapMarkerCityList.prototype.draw = function() {
    var item = this.item;
    var Lng = item.longitude;
    var Lat = item.latitude;
    var recallClick = this.recallClick;
    var position = new AMap.LngLat(Lng, Lat);
    var markerContent = document.createElement("div");
    markerContent.onclick = function() {
        if (recallClick != undefined && recallClick != "") {
            recallClick(item);
        }
    }
    var icon = "";

    if (item.buildStage == "0") {
        markerContent.className = "markerContentStyleBuild";
        icon = rootDirectoryURL + "/public/img/station_02.png";
    }
    else {
        markerContent.className = "markerContentStyleUse";
        icon = rootDirectoryURL + "/public/img/station_01.png";
    }

    var markerImg = document.createElement("img");
    markerImg.className = "markerlnglat";
    markerImg.src = icon;
    markerContent.appendChild(markerImg);

    var markerSpan = document.createElement("span");
    markerSpan.innerHTML = item.shortName;
    markerSpan.id = item.oamBaseStationId;
    markerContent.appendChild(markerSpan); 

    var marker = new AMap.Marker({//创建自定义点标注                 
        map: mapObj,
        position: position,
        offset: new AMap.Pixel(-6, -2),
        draggable: false,
        content: markerContent
    });

    if (item.buildStage == "1") {
        var circle = new AMap.Circle({
            map: mapObj,
            center: new AMap.LngLat(Lng, Lat),
            radius: 30000, //半径
            strokeColor: "#009f40", //线颜色
            strokeOpacity: 1, //线透明度
            strokeWeight: 1, //线粗细度
            fillColor: "#cce978", //填充颜色
            fillOpacity: 0.4//填充透明度
        });
    }
    else {
        var circle = new AMap.Circle({
            map: mapObj,
            center: new AMap.LngLat(Lng, Lat),
            radius: 30000, //半径
            strokeColor: "#F26011", //线颜色
            strokeOpacity: 1, //线透明度
            strokeWeight: 1, //线粗细度
            fillColor: "#ffef01", //填充颜色
            fillOpacity: 0.2//填充透明度
        });
    } 
}  

//关闭信息窗体
function closeInfoWindow() {
    mapObj.clearInfoWindow();
} 

/*自定义点标记 城市基站数*/
var myMarkerCount = function(point, item, recallClick) {
    this.point = point;
    this.markerroot;
    this.item = item;
    this.recallClick = recallClick;
}

myMarkerCount.prototype.draw = function() {
    var point = this.point;
    var item = this.item;
    var recallClick = this.recallClick;
    var markerContent = document.createElement("div");

    var icon = "";

    if (item.stationNumber2 == 0) {
        if (item.stationNumber2 == 0) {
            markerContent.className = "markerContentStylePlan";
            icon = rootDirectoryURL + "/public/img/penoncel_red.png";
        }
        else {
            markerContent.className = "markerContentStyleBuild";
            icon = rootDirectoryURL + "/public/img/penoncel_yellow.png";
        }
    }
    else {
        markerContent.className = "markerContentStyleUse";
        icon = rootDirectoryURL + "/public/img/penoncel_green.png";
    }


    var markerImg = document.createElement("img");
    markerImg.className = "markerlnglat";
    markerImg.src = icon;
    markerContent.appendChild(markerImg);

    var markerSpan = document.createElement("span");
    if(item.stationNumber == "0") {
        markerSpan.innerHTML = item.oamAreaName + " " + item.plan;
    } else {
        markerSpan.innerHTML = item.oamAreaName + " " + item.stationNumber;
    }
    markerContent.appendChild(markerSpan);


    markerSpan.onmouseover = function() {
        if (recallClick != undefined && recallClick != "") {
            recallClick(item);
        }
    }
    markerSpan.onmouseout = function() {
        closeInfo(item.oamAreaId);
    }
    markerSpan.onclick = function() {
     if (item.stationNumber2 != "0" || item.stationNumber2 != "0") {
            window.open(rootDirectoryURL + "/oamBaseStationMap/bs_mainList?cityID=" + item.oamAreaId);
        }
    }
    var marker = new AMap.Marker({
        map: mapObj,
        position: point,
        offset: new AMap.Pixel(-3, -3),
        draggable: false,
        content: markerContent
    });
    this.markerroot = marker;

}

 


/*自定义点标记 城市监控*/
var myMarkerMonitor = function(point, item, recallClick) {
    this.point = point;
    this.markerroot;
    this.item = item;
    this.recallClick = recallClick;
}

myMarkerMonitor.prototype.draw = function() {
    var point = this.point;
    var item = this.item;
    var recallClick = this.recallClick;
    var markerContent = document.createElement("div");
   
    var icon = rootDirectoryURL + "/public/img/penoncel_green.png";
    if (item.stationNumber != item.stationNumber2) {
        markerContent.className = "markerContentStyleOffline";
        icon = rootDirectoryURL + "/public/img/penoncel_yellow.png";
    }
    else {
        markerContent.className = "markerContentStyleOnline";
    }
    var markerImg = document.createElement("img");
    markerImg.className = "markerlnglat";
    markerImg.src = icon;
    markerContent.appendChild(markerImg);


    var markerSpan = document.createElement("span");
    markerSpan.style.display = 'inline-block';
    markerSpan.innerHTML = item.oamAreaName + "   " + item.stationNumber + "，" + item.stationNumber2;
    markerContent.appendChild(markerSpan);

    markerSpan.onmouseover = function() {
        if (recallClick != undefined && recallClick != "") {
            recallClick(item);
        }
    }
    markerSpan.onmouseout = function() {
        closeInfo(item.oamAreaId);
    }
    markerSpan.onclick = function() {
        window.open(rootDirectoryURL + "/oamBaseStationMap/bs_monitorCity?AreaId=" + item.oamAreaId);
    }

    var marker = new AMap.Marker({
        map: mapObj,
        position: point,
        offset: new AMap.Pixel(-3, -3),
        draggable: false,
        content: markerContent
    });
    this.markerroot = marker;
}




var mapMarkerCityMonitor = function(item, recallClick) {
    this.item = item;
    this.markerroot;
    this.inforoot;
    this.recallClick = recallClick;
}

mapMarkerCityMonitor.prototype.draw = function() {
    var item = this.item;
    var Lng = item.longitude;
    var Lat = item.latitude;
    var position = new AMap.LngLat(Lng, Lat);
    var recallClick = this.recallClick;
 
    var markerContent = document.createElement("div");
    markerContent.onclick = function() {
        if (recallClick != undefined && recallClick != "") {
            recallClick(item);
        }
    }
    var icon = "";

    if (item.state == "0") {
        markerContent.className = "markerContentStyleOff";
        icon = rootDirectoryURL + "/public/img/station_03.png";
    }
    else {
        markerContent.className = "markerContentStyleOn";
        icon = rootDirectoryURL + "/public/img/station_01.png";
    }

    var markerImg = document.createElement("img");
    markerImg.className = "markerlnglat";
    markerImg.src = icon;
    markerContent.appendChild(markerImg);

    var markerSpan = document.createElement("span"); 
    markerSpan.innerHTML = item.shortName;
    markerContent.appendChild(markerSpan);

     
    var marker = new AMap.Marker({//创建自定义点标注                 
        map: mapObj,
        position: position,
        offset: new AMap.Pixel(-6, -2),
        draggable: false,
        content: markerContent
    });

    if (item.state == "0") {
        var circle = new AMap.Circle({
            map: mapObj,
            center: new AMap.LngLat(Lng, Lat),
            radius: 30000, //半径
            strokeColor: "#D0D8D6", //线颜色
            strokeOpacity: 1, //线透明度
            strokeWeight: 1, //线粗细度
            fillColor: "#f1f7f7", //填充颜色
            fillOpacity: 0.4//填充透明度
        });
    }
    else {
        var circle = new AMap.Circle({
            map: mapObj,
            center: new AMap.LngLat(Lng, Lat),
            radius: 30000, //半径
            strokeColor: "#009f40", //线颜色
            strokeOpacity: 1, //线透明度
            strokeWeight: 1, //线粗细度
            fillColor: "#cce976", //填充颜色
            fillOpacity: 0.4//填充透明度
        });
    } 
  
}


