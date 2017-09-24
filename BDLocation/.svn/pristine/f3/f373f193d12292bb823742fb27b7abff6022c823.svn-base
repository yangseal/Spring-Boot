$(function(){
	refreshPage("providerUserForm","providerUserDiv");
	validateRealTime("proUserForm");
});

function showProUser(providerUserId){
	var baseProviderId = $("#baseProviderId").val();
	var url = CONTEXT_PATH + "/baseStation/provider/openProUser?baseProviderId=" + baseProviderId;
	var title = "新增联系人";
	if(providerUserId){
		url += "&providerUserId=" + providerUserId;
		title = "编辑联系人";
	}
	openTab("proUser",title,url);
}

function editProUser(){
	var tableId = "providerUserTable";
	if(getSelectedEntityIdForOne(tableId)){
		var entityId = getSelectedEntityIdForOne(tableId);
		showProUser(entityId);
	}
}

function delProUser(){
	var providerUserIds = getCheckedEntityIds("providerUserTable");
	if(!providerUserIds){
		myAlert("请勾选待删除的联系人");
		return;
	}
	myConfirm(globalDeleteTip,function(){
		var url = CONTEXT_PATH + "/baseStation/provider/deleteProUser";
		var params = {providerUserIds:providerUserIds};
		jQuery.post(url, params, function(data) {
			if(data.success){
				refreshPage("providerUserForm","providerUserDiv");
			}else{
				myAlert(data.message);
			}
		});
	});
}

function saveProUser(){
	if(!validateForm("proUserForm")){
		return;
	}
	var baseProviderId = $("#baseProviderId").val();
	var url = CONTEXT_PATH + "/baseStation/provider/saveProUser?baseProviderId=" + baseProviderId;
	var params = $("#proUserForm").serialize();
	jQuery.post(url, params, function(data) {
		if(data.success){
			var opener = window.top.getOpener();
			opener.refreshPage("providerUserForm","providerUserDiv");
			if(!$("#baseProviderUserId").val())
				$("#baseProviderUserId").val(data.message);
			myAlert(globalSaveSuccessTip);
		}else{
			myAlert(data.message);
		}
	});
}


