function onPageLoad() {
	MessagePush.onPageLoad();
}
//推送信息
function showCorsRealMessage(autoMessage) {
	console.log("----corsRealTime:" + autoMessage);
	var corsLogsArr = JSON.parse(autoMessage);
	if(!corsLogsArr) return;
	if(corsLogsArr.length >0){
		var corsLogsTable = $("#corsTableRealtimeLogsTemp").clone().removeAttr("style"),
			timeSpan = $("#rendCurrTableTime").clone().removeAttr("id")
					.removeAttr("style").attr('style','margin-top:5px;color:red;')
					.text(new Date().Format("yyyy-MM-dd hh:mm:ss"));
		
		$("#corsRealtimeContent").append(timeSpan);
	}
	
	for(var i=0,len = corsLogsArr.length; i<len; i++){
		var corsTr = $("#corsTrRealtimeLogsTemp").clone().removeAttr("style");
		corsTr.find("td[name='compay']").text(corsLogsArr[i].companyName);
		corsTr.find("td[name='corsCode']").text(corsLogsArr[i].accountCode);
		corsTr.find("td[name='deviceSn']").text(corsLogsArr[i].deviceSn);
		corsTr.find("td[name='accessTime']").text(corsLogsArr[i].accessTime);
		corsTr.find("td[name='access']").text(corsLogsArr[i].access);
		corsTr.find("td[name='onlineTime']").text(corsLogsArr[i].onlineTime);
		corsTr.find("td[name='resolveType']").text(corsLogsArr[i].resolveType);
		corsTr.find("td[name='receiveData']").text(corsLogsArr[i].receiveData);
		corsTr.find("td[name='sendData']").text(corsLogsArr[i].sendData);
		corsLogsTable.append(corsTr);
	}
	$("#corsRealtimeContent").append(corsLogsTable);
}

//推送信息
function showStationRealMessage(autoMessage) {
	debugger;
	console.log("autoMessage base station：" + autoMessage);
	var stationLogsArr = JSON.parse(autoMessage);
	if(!stationLogsArr) return;
	if(stationLogsArr.length >0){
		var stationLogsTable = $("#corsTableRealtimeLogsTemp").clone()
		.removeAttr('id')
		.removeAttr("style"),
		
		timeSpan = $("#rendCurrTableTime").clone().removeAttr('id')
			.removeAttr("style").attr('style','margin-top:5px;color:red;')
			.text(new Date().Format("yyyy-MM-dd hh:mm:ss"));
		
		$("#stationRealtimeContent").append(timeSpan);
	}
	
	for(var i=0,len = stationLogsArr.length; i<len; i++){
		var stationTr = $("#corsTrRealtimeLogsTemp").clone().removeAttr('id').removeAttr("style");
		stationTr.find("td[name='compay']").text(stationLogsArr[i].companyName);
		stationTr.find("td[name='stationName']").text(stationLogsArr[i].stationName);
		stationTr.find("td[name='stationNo']").text(stationLogsArr[i].stationNo);
		stationTr.find("td[name='access']").text(stationLogsArr[i].access);
		stationTr.find("td[name='joinTime']").text(stationLogsArr[i].joinTime);
		stationTr.find("td[name='connectNums']").text(stationLogsArr[i].connectNums);
		stationTr.find("td[name='stationState']").text(stationLogsArr[i].stationState);
		stationTr.find("td[name='broadcastData']").text(stationLogsArr[i].broadcastData);
		stationLogsTable.append(stationTr);
	}
	$("#stationRealtimeContent").append(stationLogsTable);
}