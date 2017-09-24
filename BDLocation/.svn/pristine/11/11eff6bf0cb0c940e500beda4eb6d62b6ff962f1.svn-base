$(function(){
	getStationUseSituation(new Date(new Date().getTime() - 86400000).Format("yyyy-MM-dd"));
});

function searchStatisticByDay(){
	var searchVal = $("#statisticTime").val();
	if(searchVal){
		getStationUseSituation(searchVal);
	}
}


function getStationUseSituation(daystr){
	var url = CONTEXT_PATH + "/statistic/station/getStationUseStation",
	params = {'daystr':daystr};
	commonPost(url,params,function(data){
		var stationDaySituation = data.stationDaySituation,
			stationMonSituation = data.stationMonthSituation;
		
		if(stationDaySituation.length >0){
			var dayTable = $("#stationDailyUseTable").empty();
			for(var i=0,len=stationDaySituation.length; i<len; i++){
				var dayTr = $("#stationUseSituationTrTemp").clone().removeAttr('id');
				dayTr.find("td[name='jointime']").text(stationDaySituation[i].join_time);
				dayTr.find("td[name='stationname']").text(stationDaySituation[i].station_name);
				dayTr.find("td[name='stationno']").text(stationDaySituation[i].station_no);
				dayTr.find("td[name='connectnums']").text(stationDaySituation[i].connect_nums);
				dayTr.find("td[name='broaddata']").text(stationDaySituation[i].broad_data);
				dayTr.find("td[name='offlinenums']").text(stationDaySituation[i].offline_nums);
				dayTable.append(dayTr);
			}
		}
		
		if(stationMonSituation.length >0){
			var monTable = $("#stationMonUseTable").empty();
			for(var j=0,jlen=stationDaySituation.length; j<jlen; j++){
				var monTr = $("#stationUseSituationTrTemp").clone().removeAttr('id');
				monTr.find("td[name='jointime']").text(stationMonSituation[j].join_time);
				monTr.find("td[name='stationname']").text(stationMonSituation[j].station_name);
				monTr.find("td[name='stationno']").text(stationMonSituation[j].station_no);
				monTr.find("td[name='connectnums']").text(stationDaySituation[j].connect_nums);
				monTr.find("td[name='broaddata']").text(stationMonSituation[j].broad_data);
				monTr.find("td[name='offlinenums']").text(stationMonSituation[j].offline_nums);
				monTable.append(monTr);
			}
		}
		
		console.log("--------rlt: " + JSON.stringify(data));
	});
}



function resetCondition(){
	$("#statisticTime").val('');
	getStationUseSituation(new Date(new Date().getTime() - 86400000).Format("yyyy-MM-dd"));
};