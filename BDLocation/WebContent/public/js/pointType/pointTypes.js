//打开页面即执行查询
$(function(){
	refreshPage("pointTypesForm","pointTypesDiv");
});

function showPointType(pointTypeId,isQuery){
	var url = CONTEXT_PATH + "/pointType/showPointType";
	var title = "新增点类型";
	if(pointTypeId){
		url += "?pointTypeId=" + pointTypeId;
		title = "编辑点类型";
	}
	if(isQuery){
		url += "&isQuery=true";
		title = "查看点类型";
	}
	if($.QueryString()){
		if(url.indexOf("?")>0){
			url += "&";
		}else{
			url += "?";
		}
		url += $.QueryString()._queryString_;
	}
	openTab("pointType",title,url);
}

function viewPointType(){
	var pointTypeId = getSelectedEntityId("pointTypesTable");
	if(!pointTypeId){
		myAlert("请选择待查看点类型");
		return;
	}
	showPointType(pointTypeId,true);
}

function editPointType(){
	var pointTypeId = getSelectedEntityId("pointTypesTable");
	if(!pointTypeId){
		myAlert("请选择待编辑点类型");
		return;
	}
	showPointType(pointTypeId);
}

function deletePointType(){
	var pointTypeIds = getCheckedEntityIds("pointTypesTable");
	if(!pointTypeIds){
		myAlert("请勾选待删除点类型");
		return;
	}
	myConfirm(globalDeleteTip,function(){
		var url = CONTEXT_PATH + "/pointType/deletePointType";
		var params = {pointTypeIds:pointTypeIds};
		jQuery.post(url, params, function(data) {
			if(data.success){
				refreshPage("pointTypesForm","pointTypesDiv");
			}else{
				myAlert(data.message);
			}
		});
	});
}

function exportPointTypes(){
	var url = CONTEXT_PATH + "/pointType/exportPointTypes?" + $("#pointTypesForm").serialize();
	window.location.href = url;
}