/**
 *
 */
var mapObj, cityid, ruler;
var infoArrayO = {};
$(function() {
	$("#top").load(rootDirectoryURL+"/oamBaseStationMap/bs_head.ftl", function() {
		$("#footer").load(rootDirectoryURL+"/oamBaseStationMap/bs_footer.ftl", function() {
			CurentTime();
			var para = GetRequest();
			if (para != null) {
				if (para["AreaId"] != null && para["AreaId"] != undefined) {
					cityid = para["AreaId"];
				}
			}
			InitMapByName("");

			var para = {
				"oamAreaId" : cityid
			};
			$.post(rootDirectoryURL+"/oamBaseStationMap/getCityMonitor", para, CityStation);

			/*地图标记动画效果*/
			setInterval(function() {
				var stepSrc = $(".markerContentStyleOn img").attr("src");
				if (stepSrc == rootDirectoryURL+'/public/img/station_01.png') {
					$(".markerContentStyleOn img").attr("src", rootDirectoryURL+'/public/img/station_01_step2.png');
				} else if (stepSrc == rootDirectoryURL+'/public/img/station_01_step2.png') {
					$(".markerContentStyleOn img").attr("src", rootDirectoryURL+'/public/img/station_01_step3.png');
				} else if (stepSrc == rootDirectoryURL+'/public/img/station_01_step3.png') {
					$(".markerContentStyleOn img").attr("src", rootDirectoryURL+'/public/img/station_01.png');
				}
				;
			}, 500);
		});
	});
});

function CityStation(data) {
	if (data != undefined && data != "") {
		var objson = data.message;
		document.title = objson[0].oamArea.oamAreaName + "--北斗基站监控";
		var Station = objson;
		var Customers = [];
		var infos = [];
		var startMarker;
		var endMarker;
		var stationArray = [];
		$(Station).each(function(n, item) {
			var marker = new mapMarkerCityMonitor(item, undefined);
			marker.draw();
			if (n == 0) {
				startMarker = marker;
			}
			if (n == 1) {
				endMarker = marker;
			}
			var point = new AMap.LngLat(item.longitude, item.latitude);
			var par = {};
			par.point = point;
			par.stage = (item.state == "0") ? "不正常" : "正常";
			stationArray.push(par);
		});
		drawStationLine(stationArray);
		mapObj.setFitView();
		var lOptions = {
			strokeStyle : "solid",
			strokeColor : "#FF33FF",
			strokeOpacity : 1,
			strokeWeight : 2
		};
		$.ajax({
			async : false,
			cache : false,
			type : 'POST',
			data : {
				"areaId" : data.message[0].oamArea.oamAreaId
			},
			dataType : "json",
			url : rootDirectoryURL+"/oamBaseStationMap/getAccounts", //请求的action路径
			error : function() {//请求失败处理函数
				myAlert('获得节点类型数据失败');
			},
			success : function(data) {//请求成功后处理函数。
				if (data.message != null && data.message.length > 0) {
					$(data.message).each(function(n, item) {
						infos.push("<tr class=' h30 lh30 tc'>");
						var status = (item.accountStatus == "1") ? "在线" : "不在线";
						infos.push("<td>" + item.oamCustomer.oamCustomerName + "</td><td>" + item.oamAccountName + "</td><td>" + status + "</td><td>" + item.loginNum + "</td> ");
						infos.push("</tr>");
					});
				} else {

				}
			}
		});
		$(infos.join("")).appendTo("#userinfo");
	}

}

function drawStationLine(stationArray) {
	//连接所有的点  其中点的属性含有建设中，该线黑色，其他蓝色(同一个项目的相连，不同项目不连）
	for (var i = 0; i < stationArray.length; i++) {
		for (var j = i + 1; j < stationArray.length; j++) {
			var line = [];
			line.push(stationArray[i].point);
			line.push(stationArray[j].point);
			var color = "#009DDA";
			if (stationArray[i].stage == undefined || stationArray[i].stage == "不正常" || stationArray[j].stage == "不正常") {
				color = "black";
			}
			var polyline = new AMap.Polyline({
				map : mapObj,
				path : line,
				strokeColor : color,
				strokeOpacity : 0.4,
				strokeWeight : 1
			});
		}
	}
	mapObj.setFitView();
} 