/**
 *
 */
var stationId;
$(document).ready(function() {
	var para = GetRequest();
	if (para != null) {
		if (para.stationId != null && para.stationId != undefined) {
			stationId = para.stationId;
		}
	}

	var para = {
		"stationId" : stationId
	};
	$.post(rootDirectoryURL + "/oamBaseStationMap/getInfoByStaiton", para, getInfo);
});
function closebox1() {
	window.parent.document.body.removeChild(window.parent.document.getElementById("dialogCase"))
}

function getInfo(data) {
	if (data != undefined && data != "") {
		var json = data.message;
		$("#name").html(json.oamBaseStationName);
		$("#name1").html(json.oamBaseStationName);
		$("#baseCode").html(json.stationCode);
		$("#companyName").html(json.customerName);
		$("#projectName").html(json.projectName);
		$("#address").html(json.address);
		$("#ContactName").html(json.contacts);
		$("#Tel").html(json.contact);
		var work = [];
		if (json.aDSL == "1") {
			work.push("ADSL");
		}
		if (json.opticalFiber == "1") {
			work.push('光纤');
		}
		if (json.interchanger == "1") {
			work.push('交换机');
		}
		if (json.router == "1") {
			work.push('路由器');
		}
		if (json.otherNetwork != null && json.otherNetwork != "") {
			work.push(json.otherNetwork);
		}
		$("#NetWire").html(work.join(','));
		var strArray = [];
		var params = {
			"entityName" : "oamBaseStation",
			"fieldName" : "attachments",
			"entityId" : json.oamBaseStationId
		};
		$.ajax({
			async : false,
			cache : false,
			type : 'POST',
			data : params,
			dataType : "json",
			url : rootDirectoryURL + "/oamBaseStationMap/getAttachments", //请求的action路径
			error : function() {//请求失败处理函数
				myAlert('获得节点类型数据失败');
			},
			success : function(data) {//请求成功后处理函数。
				if (data.message != null && data.message.length > 0) {
					$(data.message).each(function(n, item) {
						var id = "";
						if (n == 0)
							id = ' id="startAtMe" ';
						strArray.push('<a href="#"><img src='+rootDirectoryURL +'/oamBaseStationMap/download?attachmentId=' + item.attachmentId + '" alt="Demo image"  width="497"   style="max-height:360px  border:0"' + id + ' /></a>');
					});
					$(strArray.join("")).appendTo("#imglist");
					$("#makeMeScrollable").smoothDivScroll({
						autoScroll : "onstart",
						autoScrollDirection : "backandforth",
						autoScrollStep : 1,
						autoScrollInterval : 15,
						startAtElementId : "startAtMe",
						visibleHotSpots : "always"
					});
				} else {
					$("#makeMeScrollable").remove();
				}
			}
		});
	} else {
		$("#makeMeScrollable").remove();
	}
}

function c() {
	if (parent.document.getElementById("ifr_popup0") != null) {
		parent.document.getElementById("ifr_popup0").style.height = document.body.scrollHeight + "px";
	}
	var sScrollTop = parent.document.body.scrollTop;
	var sClientHeight = parent.document.body.clientHeight;
	var iTop = (sClientHeight / 2 + sScrollTop) - (document.body.scrollHeight / 2);
	iTop = iTop > 0 ? iTop : 20;
	parent.document.getElementById("dialogBox").style.top = iTop + "px";
}