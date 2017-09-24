//打开页面即执行查询
$(function(){
	refreshPage("dictItemsForm","dictItemsDiv");
});

function showDictItem(dictItemId,isQuery){
	var url = CONTEXT_PATH + "/dictItem/showDictItem";
	var title = "新增字典项";
	if(dictItemId){
		url += "?dictItemId=" + dictItemId;
		title = "编辑字典项";
	}
	if(isQuery){
		url += "&isQuery=true";
		title = "查看字典项";
	}
	if($.QueryString()){
		if(url.indexOf("?")>0){
			url += "&";
		}else{
			url += "?";
		}
		url += $.QueryString()._queryString_;
	}
	openTab("dictItem",title,url);
}

function viewDictItem(){
	var dictItemId = getSelectedEntityId("dictItemsTable");
	if(!dictItemId){
		myAlert("请选择待查看字典项");
		return;
	}
	showDictItem(dictItemId,true);
}

function editDictItem(){
	var dictItemId = getSelectedEntityId("dictItemsTable");
	if(!dictItemId){
		myAlert("请选择待编辑字典项");
		return;
	}
	showDictItem(dictItemId);
}

function deleteDictItem(){
	var dictItemIds = getCheckedEntityIds("dictItemsTable");
	if(!dictItemIds){
		myAlert("请勾选待删除字典项");
		return;
	}
	myConfirm(globalDeleteTip,function(){
		var url = CONTEXT_PATH + "/dictItem/deleteDictItem";
		var params = {dictItemIds:dictItemIds};
		jQuery.post(url, params, function(data) {
			if(data.success){
				refreshPage("dictItemsForm","dictItemsDiv");
			}else{
				myAlert(data.message);
			}
		});
	});
}
