/**
 * 
 */
$(function(){
	 var mapObj;
      $("#top").load(rootDirectoryURL+"/oamBaseStationMap/bs_head.ftl", function() {
            $("#footer").load(rootDirectoryURL+"/oamBaseStationMap/bs_footer.htm", function() {
                CurentTime();
                InitMapByName("");
                var para = [];
                GetJson("getCityAndStationCount", para, CityStation);
                $("#myframe").load(function() {
                    $(this).height($(this).contents().find("#content").height());
                });
            });
       }); 
});

var infoArrayO = {};
function CityStation(data) {
    var info = [];
    var textinfo = []; 
    if (data != undefined && data != "") { 
        var jsonobj = data;
        var sum = 0;
        $(jsonobj.CityInfo).each(function(n, item) {
            info.push("<tr class=' h30 lh30 tc'>");
            textinfo.push("<li>■ 云信息资讯内容提要11111111111</li>");
            var url = "";
            if(item.stationNumber2 != 0) {
            	url = rootDirectoryURL+"/oamBaseStationMap/bs_mainList.ftl?cityID=" + item.oamAreaId;
            } else {
            	url ="#";
            }
            info.push("<td ><a href='" + url + "' target='_blank'>" + item.oamAreaName + "</a></td>");
            info.push("<td >" + item.plan + "</td>");
            info.push("<td >" + (item.stationNumber-item.stationNumber2) + "</td>"); //建设中数量
            info.push("<td >" + item.stationNumber2 + "</td>"); //已完成数量
            info.push("</tr>");
            sum += item.stationNumber;
            if (item.plan != "0") {
                var lat = item.latitude;
                var lng = item.longitude;
                var point = new AMap.LngLat(lng, lat);
                var marker = new myMarkerCount(point, item, recallClick);
                marker.draw();
            }
        });


        mapObj.setFitView();
    }
    $(info.join("")).appendTo("#cityList");
    $("#basecount").html(sum+"/");
} 
 

function closeInfo(cityId) {
    var obj = infoArrayO["Info" + cityId];
    if (obj.getIsOpen()) {
        obj.close();
    }
}

function recallClick(item) {
  var cityID=item.oamAreaId;

  var infoobj = infoArrayO["Info" + cityID];
  if (infoobj == undefined) {
      //构建信息窗体中显示的内容
      var info = [];    
      info.push("<div style=\"padding:0px 0px 0px 4px;\" ><b>" + item.oamAreaName + "</b>");
      info.push("已完成：" + item.stationNumber2);
      info.push("建设中：" + (item.stationNumber-item.stationNumber2));
      info.push("初步规划数量：" + item.plan);

      var infoWindow = new AMap.InfoWindow({
          size: new AMap.Size(160, 80),
          content: info.join("<br/>")  //使用默认信息窗体框样式，显示信息内容
      });
      infoWindow.open(mapObj, new AMap.LngLat(item.longitude, item.latitude));
      var cityID = item.oamAreaId;
      infoArrayO["Info" + cityID] = infoWindow;
  }
  else {
      infoobj.open(mapObj, new AMap.LngLat(item.longitude, item.latitude));
  }
}