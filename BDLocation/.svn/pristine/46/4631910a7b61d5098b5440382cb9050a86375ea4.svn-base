//打开页面即执行查询
$(function(){
	refreshPage("measurePointsForm","measurePointsDiv");
});

function showMeasurePoint(measurePointId,isQuery){
	var url = CONTEXT_PATH + "/measurePoint/showMeasurePoint";
	var title = "新增测量点";
	if(measurePointId){
		url += "?measurePointId=" + measurePointId;
		title = "编辑测量点";
	}
	if(isQuery){
		url += "&isQuery=true";
		title = "查看测量点";
	}
	if($.QueryString()){
		if(url.indexOf("?")>0){
			url += "&";
		}else{
			url += "?";
		}
		url += $.QueryString()._queryString_;
	}
	openTab("measurePoint",title,url);
}

function viewMeasurePoint(){
	var measurePointId = getSelectedEntityId("measurePointsTable");
	if(!measurePointId){
		myAlert("请选择待查看测量点");
		return;
	}
	showMeasurePoint(measurePointId,true);
}

function editMeasurePoint(){
	var measurePointId = getSelectedEntityId("measurePointsTable");
	if(!measurePointId){
		myAlert("请选择待编辑测量点");
		return;
	}
	showMeasurePoint(measurePointId);
}

function deleteMeasurePoint(){
	var measurePointIds = getCheckedEntityIds("measurePointsTable");
	if(!measurePointIds){
		myAlert("请勾选待删除测量点");
		return;
	}
	myConfirm(globalDeleteTip,function(){
		var url = CONTEXT_PATH + "/measurePoint/deleteMeasurePoint";
		var params = {measurePointIds:measurePointIds};
		jQuery.post(url, params, function(data) {
			if(data.success){
				refreshPage("measurePointsForm","measurePointsDiv");
			}else{
				myAlert(data.message);
			}
		});
	});
}

function exportMeasurePoints(){
	var url = CONTEXT_PATH + "/measurePoint/exportMeasurePoints?" + $("#measurePointsForm").serialize();
	window.location.href = url;
}

function viewMeasurePointMap(){
	var selectPoints = getCheckedEntityIds("measurePointsTable");
	if(!selectPoints){
		myAlert("请选择待查看测量点");
		return;
	}
	var url = CONTEXT_PATH +"/measurePoint/measurePointMap?"+ "selectPoints=" + selectPoints;
	window.open(url,"_blank");
}
