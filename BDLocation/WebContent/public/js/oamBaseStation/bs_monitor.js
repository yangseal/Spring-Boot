/**
 *
 */
var mapObj;
var infoArrayO = {};
$(document).ready(function() {
	$("#top").load(rootDirectoryURL+"/oamBaseStationMap/bs_head.ftl", function() {
		$("#footer").load(rootDirectoryURL+"/oamBaseStationMap/bs_footer.ftl", function() {
			CurentTime();
			InitMapByName("");
			var para = [];
			GetJson("getMonitor", para, CityStation);
		});
	});
});

function CityStation(data) {
	var infos = [];
	var textinfo = [];
	var count = 0;
	if (data != undefined) {
		var objson = data.message;
		$(objson).each(function(n, item) {
			count += Number(item.stationNumber);

			var lat = item.latitude;
			var lng = item.longitude;
			var point = new AMap.LngLat(lng, lat);
			var marker = new myMarkerMonitor(point, item, recallClick);
			marker.draw();

			var url = rootDirectoryURL+"/oamBaseStationMap/bs_monitorCity?AreaId=" + item.oamAreaId;
			infos.push("<tr class=' h30 lh30 tc'>");
			infos.push("<td ><a href='" + url + "' target='_blank'>" + item.oamAreaName + "</a></td>");
			infos.push("<td >" + item.stationNumber + "</td>");
			infos.push("<td >" + item.stationNumber2 + "</td>");
			infos.push("</tr>");
			textinfo.push("<li>■ 云信息资讯内容提要11111111111</li>");

		});
		mapObj.setFitView();
		$(infos.join("")).appendTo("#cityList");
		$(textinfo.join("")).appendTo("#textlist");
		$("#basecount").html(count + "/");
	}
}

function recallClick(item) {

	var cityID = item.oamAreaId;
	var infoobj = infoArrayO["Info" + cityID];
	if (infoobj == undefined) {
		var info = [];
		info.push("<div style=\"padding:0px 0px 0px 4px;\" ><b>" + item.oamAreaName + "</b>");
		info.push("基站数量：" + item.stationNumber);
		info.push("运行数量：" + item.stationNumber2);

		var infoWindow = new AMap.InfoWindow({
			size : new AMap.Size(160, 80),
			content : info.join("<br/>") //使用默认信息窗体框样式，显示信息内容
		});
		infoWindow.open(mapObj, new AMap.LngLat(item.longitude, item.latitude));
		infoArrayO["Info" + cityID] = infoWindow;
	} else {
		infoobj.open(mapObj, new AMap.LngLat(item.longitude, item.latitude));
	}
}

function closeInfo(cityId) {
	var obj = infoArrayO["Info" + cityId];
	if (obj.getIsOpen()) {
		obj.close();
	}
} 