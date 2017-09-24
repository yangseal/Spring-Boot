function onPageLoad() {
	MessagePush.onPageLoad();
}
//推送信息
function showCorsRealMessage(autoMessage) {
	debugger;
	console.log("----corsRealTime:" + autoMessage);
	var corsLogsArr = JSON.parse(autoMessage);
	alert("corsLogsArr length :" + corsLogsArr.length);
	if(!corsLogsArr) return;
	if(corsLogsArr.length >0){
		var corsLogsTable = $("#corsTableRealtimeLogsTemp").clone().removeAttr("style").attr('style',"width:85%;margin-left:7%;"),
			tiemSpan = $("#rendCurrTableTime").removeAttr('id')
				.removeAttr("style").attr('style','margin-left:7%;margin-top:5px;color:red;')
				.text(new Date().Format("yyyy-MM-dd hh:mm:ss"));
		$("#logsMainContent").append(tiemSpan);
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
	$("#logsMainContent").append(corsLogsTable);
}

function showStationRealMessage(autoMessage){
	
}