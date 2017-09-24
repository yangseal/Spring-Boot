$(function(){
	refreshPage("conversionProjectionsForm","conversionProjectionsDiv");
});

function showConversionProjection(conversionProjectionId,isQuery){
	var url = CONTEXT_PATH + "/conversionProjection/showConversionProjection";
	var title = "新增转换投影";
	if(conversionProjectionId){
		url += "?conversionProjectionId=" + conversionProjectionId;
		title = "编辑转换投影";
	}
	if(isQuery){
		url += "&isQuery=true";
		title = "查看转换投影";
	}
	if($.QueryString()){
		if(url.indexOf("?")>0){
			url += "&";
		}else{
			url += "?";
		}
		url += $.QueryString()._queryString_;
	}
	openTab("conversionProjection",title,url);
}

function viewConversionProjection(){
	var conversionProjectionId = getSelectedEntityId("conversionProjectionsTable");
	if(!conversionProjectionId){
		myAlert("请选择待查看转换投影");
		return;
	}
	showConversionProjection(conversionProjectionId,true);
}

function editConversionProjection(){
	var conversionProjectionId = getSelectedEntityId("conversionProjectionsTable");
	if(!conversionProjectionId){
		myAlert("请选择待编辑转换投影");
		return;
	}
	showConversionProjection(conversionProjectionId);
}

function deleteConversionProjection(){
	var conversionProjectionIds = getCheckedEntityIds("conversionProjectionsTable");
	if(!conversionProjectionIds){
		myAlert("请勾选待删除转换投影");
		return;
	}
	myConfirm(globalDeleteTip,function(){
		var url = CONTEXT_PATH + "/conversionProjection/deleteConversionProjection";
		var params = {conversionProjectionIds:conversionProjectionIds};
		jQuery.post(url, params, function(data) {
			if(data.success){
				refreshPage("conversionProjectionsForm","conversionProjectionsDiv");
			}else{
				myAlert(data.message);
			}
		});
	});
}

function exportConversionProjections(){
	var url = CONTEXT_PATH + "/conversionProjection/exportConversionProjections?" + $("#conversionProjectionsForm").serialize();
	window.location.href = url;
}

