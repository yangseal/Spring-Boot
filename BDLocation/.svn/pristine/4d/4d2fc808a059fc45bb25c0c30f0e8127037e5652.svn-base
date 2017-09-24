function onPageLoad() {
	MessagePush.onPageLoad();
}
//推送信息
function showStationRealMessage(autoMessage) {
	console.log("autoMessage base station：" + autoMessage);
	var stationLogsArr = JSON.parse(autoMessage);
	alert("---------dddddd:" + stationLogsArr.length);
	if(stationLogsArr.length >0){
		var stationLogsTable = $("#corsTableRealtimeLogsTemp").clone()
		.removeAttr('id')
		.removeAttr("style").attr('style',"width:85%;margin-left:7%;"),
		
		tiemSpan = $("#rendCurrTableTime").removeAttr('id')
			.removeAttr("style").attr('style','margin-left:7%;margin-top:5px;color:red;')
			.text(new Date().Format("yyyy-MM-dd hh:mm:ss"));
		
		$("#logsMainContent").append(tiemSpan);
	}
	
	for(var i=0,len = stationLogsArr.length; i<len; i++){
		var stationTr = $("#corsTrRealtimeLogsTemp").clone().removeAttr('id').removeAttr("style");
		stationTr.find("td[name='compay']").text(stationLogsArr[i].companyName);
		stationTr.find("td[name='stationName']").text(stationLogsArr[i].stationName);
		stationTr.find("td[name='stationNo']").text(stationLogsArr[i].stationNo);
		stationTr.find("td[name='joinPointer']").text(stationLogsArr[i].joinPointer);
		stationTr.find("td[name='joinTime']").text(stationLogsArr[i].joinTime);
		stationTr.find("td[name='connectNums']").text(stationLogsArr[i].connectNums);
		stationTr.find("td[name='stationState']").text(stationLogsArr[i].stationState);
		stationTr.find("td[name='broadcastData']").text(stationLogsArr[i].broadcastData);
		stationLogsTable.append(stationTr);
	}
	$("#logsMainContent").append(stationLogsTable);
}