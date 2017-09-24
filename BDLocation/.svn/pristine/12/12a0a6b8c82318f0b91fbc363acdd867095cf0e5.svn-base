//打开页面即执行查询
$(function(){
	refreshPage("dynamicFieldsForm","dynamicFieldsDiv");
});

function showDynamicField(dataCode,isQuery,isEdit){
	var url = CONTEXT_PATH + "/pointType/showDynamicField";
	var title = "新增动态字段";
	if(dataCode){
		url += "?dataCode=" + dataCode;
	}
	if(isQuery){
		url += "&isQuery=true";
		title = "查看动态字段";
	}
	if(isEdit) {
		url += "&isEdit=true";
		title = "编辑动态字段";
	}
	if($.QueryString()){
		if(url.indexOf("?")>0){
			url += "&";
		}else{
			url += "?";
		}
		url += $.QueryString()._queryString_;
	}
	openTab("dynamicField",title,url);
}

function viewDynamicField(){
	var dataCode = getSelectedEntityId("dynamicFieldsTable");
	if(!dataCode){
		myAlert("请选择待查看点类型");
		return;
	}
	showDynamicField(dataCode,true);
}

function editDynamicField(){
	var dataCode = getSelectedEntityId("dynamicFieldsTable");
	if(!dataCode){
		myAlert("请选择待查看点类型");
		return;
	}
	showDynamicField(dataCode,false,true);
}

function deleteDynamicField(){
	var dataCodes = getCheckedEntityIds("dynamicFieldsTable");
	if(!dataCodes){
		myAlert("请勾选待删除点类型");
		return;
	}
	myConfirm(globalDeleteTip,function(){
		var url = CONTEXT_PATH + "/pointType/deleteDynamicField?"+ $.QueryString()._queryString_;
		var params = {"dataCodes":dataCodes};
		jQuery.post(url, params, function(data) {
			if(data.success){
				refreshPage("dynamicFieldsForm","dynamicFieldsDiv");
				parent.$("#mainContentDiv").children("[code='pointType']")[0].contentWindow.$("#dynamicField").val(data.message);
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