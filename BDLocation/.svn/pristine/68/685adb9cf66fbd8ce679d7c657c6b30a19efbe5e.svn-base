$(function(){
	 var mapObj, cityid = "0";
	  $("#top").load(rootDirectoryURL+"/oamBaseStationMap/bs_head", function() {
            $("#footer").load(rootDirectoryURL+"/oamBaseStationMap/bs_footer", function() {
                CurentTime();
                var para = GetRequest();
                if (para != null) {
                    if (para["cityID"] != null && para["cityID"] != undefined) {
                        cityid = para["cityID"];
                    }
                }
                InitMapByName("");
                if (cityid != "0") {
                   var para = {"oamAreaId":cityid};
                   $.post(rootDirectoryURL+"/oamBaseStationMap/getInfoByCityId",para,getCityList);
                }
            });
      });
});
var ListArray = [];

function getCityList(data) {
    if (data != undefined) {
        var jsonobj = data;
        document.title = jsonobj.BaseStation[0].oamArea.oamAreaName + "--北斗基站";
        var _tempArray = [];
        var stationArray = [];
        $(jsonobj.BaseStation).each(function(n, item) { 
                if (item.latitude != undefined && item.latitude != "" && item.longitude != undefined && item.longitude != "") {
                    var StationId = item.oamBaseStationId;
                    var marker = new mapMarkerCityList(item, recallClick);
                    marker.draw();

                    var point = new AMap.LngLat(item.longitude, item.latitude);
                    var par = {};
                    par.point = point;
                    par.stage = item.buildStage;
                    stationArray.push(par);

                    ListArray["C" + StationId] = { obj: marker, item: item };
                }
               
        });
         $(jsonobj.Address).each(function(n, item) {
         	var img = rootDirectoryURL + "/public/img/cors.jpg";
         	
         	 _tempArray.push("<div class=\"stand_list fix\">");
             _tempArray.push("<dl class=\"l stand_dl\">");
           	if(item != null) {
         		var params = {"entityName":"oamBaseStation","fieldName":"attachments","entityId":item.oamBaseStation.oamBaseStationId};
                $.ajax({  
			        async : false,  
			        cache:false,  
			        type: 'POST', 
			        data: params, 
			        dataType : "json",  
			        url: rootDirectoryURL+"/oamBaseStationMap/getAttachments",//请求的action路径  
			        error: function () {//请求失败处理函数  
			        	myAlert('获得节点类型数据失败');  
			        },  
			        success:function(data){ //请求成功后处理函数。
			        	if(data.message != null && data.message.length > 0) {
			        		img = rootDirectoryURL + "/oamBaseStationMap/download?attachmentId="+data.message[0].attachmentId;
			        	}
			        	_tempArray.push("<dt class=\"stand_dl_img\"><img src=\"" + img + "\"  style='width:90px;height:70px'  onclick=\"recallClickById('" + item.oamBaseStation.oamBaseStationId + "')\" onmouseover=\"showInfo('" + item.oamBaseStation.oamBaseStationId + "')\" onmouseout=\"hiddenInfo('" + item.oamBaseStation.oamBaseStationId + "')\"/></dt> ");
			        }  
			    });
			    _tempArray.push(" <dd class=\"stand_dd\">");
                _tempArray.push("  <h2 class=\"stand_dl_bt b f14\" style='cursor:pointer'  onclick=\"recallClickById('" + item.oamBaseStation.oamBaseStationId + "')\"  onmouseover=\"showInfo('" + item.oamBaseStation.oamBaseStationId + "')\" onmouseout=\"hiddenInfo('" + item.oamBaseStation.oamBaseStationId + "')\">" + item.oamBaseStation.oamBaseStationName + "</h2>");
                var name = item.contacts + "     " + item.contact;
                if (getByteLen(name) > 20) {
                    name = name.substring(0, 16) + "...";
                }
                _tempArray.push(" <span title='" + item.contacts + "     " + item.contact + "'>联系人：" + name + "</span>");
                _tempArray.push("<br/>");
                var add = item.address;
                if (add.length > 10) {
                    add = add.substring(0, 7) + "...";
                }
                _tempArray.push(" <span> 地    &nbsp;址：<span title='" + item.address + "'>" + add + "</span> </span></dd> ");
         	} else {
         		_tempArray.push("<dt class=\"stand_dl_img\"><img src=\"" + img + "\"  style='width:90px;height:70px'  onclick=\"recallClickById('" + jsonobj.BaseStation[n].oamBaseStationId + "')\" onmouseover=\"showInfo('" + jsonobj.BaseStation[n].oamBaseStationId + "')\" onmouseout=\"hiddenInfo('" + jsonobj.BaseStation[n].oamBaseStationId + "')\"/></dt> ");
         		_tempArray.push(" <dd class=\"stand_dd\">");
                _tempArray.push("  <h2 class=\"stand_dl_bt b f14\" style='cursor:pointer'  onclick=\"recallClickById('" + jsonobj.BaseStation[n].oamBaseStationId + "')\"  onmouseover=\"showInfo('" + jsonobj.BaseStation[n].oamBaseStationId + "')\" onmouseout=\"hiddenInfo('" + jsonobj.BaseStation[n].oamBaseStationId + "')\">" + jsonobj.BaseStation[n].oamBaseStationName + "</h2>");
         		 _tempArray.push(" <span title=''>联系人：</span>");
                _tempArray.push("<br/>");
         	    _tempArray.push(" <span> 地    &nbsp;址：<span title=''></span> </span></dd> ");
         	} 
            _tempArray.push("  </dl> ");
            _tempArray.push(" </div>  ");
         });
        drawStationLine(stationArray);
        mapObj.setFitView();
        var entityFormWrap = $(_tempArray.join("")).appendTo("#post_list");
        $('#post_list').rollbar({ zIndex: 100 });
    }
}

//返回val的字节长度
function getByteLen(val) {
    var len = 0;
    for (var i = 0; i < val.length; i++) {
        if (val[i].match(/[^\x00-\xff]/ig) != null) //全角
            len += 2;
        else
            len += 1;
    }
    return len;
}




function GetValueForToolTip(obj) {
    var tValue = obj.innerText;
    obj.setAttribute("title", tValue);
}

function showInfo(stationId) {
    $("#" + stationId).css("border", "2px solid #0093E8");
}

function hiddenInfo(stationId) {
    $("#" + stationId).css("border", "2px solid #FFF");
}

function drawStationLine(stationArray) {
    //连接所有的点  其中点的属性含有建设中，该线黑色，其他蓝色
    for (var i = 0; i < stationArray.length; i++) {
        for (var j = i + 1; j < stationArray.length; j++) {
            var line = [];
            line.push(stationArray[i].point);
            line.push(stationArray[j].point);

            var color = "#009DDA";
            if (stationArray[i].stage == "0" || stationArray[j].stage == "0") {
                color = "black";
            }
            var polyline = new AMap.Polyline({
                map: mapObj,
                path: line,
                strokeColor: color,
                strokeOpacity: 0.4,
                strokeWeight: 1
            });
        }
    }
    mapObj.setFitView();
}



function recallClick(item) {
    var height = 660;
    if (item["Attr"] == "") {
        height = 261;
    }
    var pop = new Popup({ contentType: 1, scrollType: 'no', isReloadOnClose: false, width: 700,height:height });
        pop.setContent("contentUrl", "bs_stationInfo?stationId=" + item.oamBaseStationId);
        pop.build();
        pop.show(); 
}
function recallClickById(StationId) {
    var obj = ListArray["C" + StationId];
    if(obj != undefined ) {
    	var item = obj.item;
    	recallClick(item);
    }  
}

function switchTab(n) {
    for (var i = 1; i <= 2; i++) {
        document.getElementById("tab_" + i).className = "";
        document.getElementById("tab_con_" + i).style.display = "none";
    }
    document.getElementById("tab_" + n).className = "on";
    document.getElementById("tab_con_" + n).style.display = "block";
}


 