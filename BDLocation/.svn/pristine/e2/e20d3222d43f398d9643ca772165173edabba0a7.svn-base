$(function(){
	getCorsUseSituation(new Date(new Date().getTime() - 86400000).Format("yyyy-MM-dd"));
});

function searchStatisticByDay(){
	var searchVal = $("#statisticTime").val();
	if(searchVal){
		getCorsUseSituation(searchVal);
	}
}

function getCorsUseSituation(daystr){
	var url = CONTEXT_PATH + "/statistic/station/getCorsUseSituation",
		params = {'daystr':daystr};
	commonPost(url,params,function(data){
		debugger;
		var dayUseSituation = data.corsDaySituation,
			monthUseSituation = data.corsMonthSituation;
		if(dayUseSituation.length>0){
			var dayTable = $("#corsDailyUseSituationTable").empty();
			for(var i=0,len=dayUseSituation.length; i<len; i++){
				var dayTr = $("#corsUseSituationTrTemp").clone().removeAttr('id');
				dayTr.find("td[name='accesstime']").text(dayUseSituation[i].access_time);
				dayTr.find("td[name='companyname']").text(dayUseSituation[i].company_name);
				dayTr.find("td[name='totalaccount']").text(dayUseSituation[i].total_account);
				dayTr.find("td[name='activeaccount']").text(dayUseSituation[i].active_account);
				dayTr.find("td[name='activefate']").text(dayUseSituation[i].active_fate);
				dayTr.find("td[name='broaddata']").text(dayUseSituation[i].broad_data);
				dayTable.append(dayTr);
			}
		}
		
		if(monthUseSituation.length>0){
			var monthTable = $("#corsMonthUseSituationTable").empty();
			for(var j=0,jlen=monthUseSituation.length; j<jlen; j++){
				var monthTr = $("#corsUseSituationTrTemp").clone().removeAttr('id');
				monthTr.find("td[name='accesstime']").text(monthUseSituation[j].access_time);
				monthTr.find("td[name='companyname']").text(monthUseSituation[j].company_name);
				monthTr.find("td[name='totalaccount']").text(monthUseSituation[j].total_account);
				monthTr.find("td[name='activeaccount']").text(monthUseSituation[j].active_account);
				monthTr.find("td[name='activefate']").text(monthUseSituation[j].active_fate);
				monthTr.find("td[name='broaddata']").text(monthUseSituation[j].broad_data);
				monthTable.append(monthTr);
			}
		}
	});
}



function resetCondition(){
	$("#statisticTime").val('');
	getCorsUseSituation(new Date(new Date().getTime() - 86400000).Format("yyyy-MM-dd"));
}