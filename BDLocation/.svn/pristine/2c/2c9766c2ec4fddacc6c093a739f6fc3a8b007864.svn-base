$(function(){
	refreshPage("baseProviderForm","baseProviderDiv");
	Location.init(["","",0,0,$("#address").val()], $('#openBaseProviderForm'));
	validateRealTime("openBaseProviderForm");
});

function showProvider(baseProviderId){
	
	var url = CONTEXT_PATH + "/baseStation/provider/openBaseProvider";
	var title = "新增供应商";
	if(baseProviderId){
		url += "?baseProviderId=" + baseProviderId;
		title = "编辑供应商";
	}
	openTab("provider",title,url);
}

function toProContract(providerId){
	debugger;
	var url = CONTEXT_PATH+"/baseStation/provider/showProContract";
	var title ="基建合同管理";
	url+="?baseProviderId="+providerId;
	openTab("proContract",title,url);
}

function toProviderUsers(providerId){
	var url = CONTEXT_PATH+"/baseStation/provider/showProviderUsers";
	var title ="联系人管理";
	url+="?baseProviderId="+providerId;
	openTab("providerUsers",title,url);
}

function editProvider(){
	var tableId = "baseProviderTable";
	var entityId = getSelectedEntityIdForOne(tableId);
	if(entityId){
		showProvider(entityId);
	}
}

function saveBaseProvider(){
	if(validateForm("openBaseProviderForm")){
		var oamId = $("input[location='oamAreaId']").val();
		if(!oamId){
			$("#oamAreaTip").css("color","red");
			$("#oamAreaTip").html("所在区域不能为空");
			return false;
		}else{
			$("#oamAreaTip").html("*");
		}
	}else{
		myAlert("信息不完整,请检查无误后再次保存!");
		return false;
	}
	
	var url = CONTEXT_PATH + "/baseStation/provider/saveBaseProvider";
	var params = $("#openBaseProviderForm").serialize();
	jQuery.post(url, params, function(data) {
		if(data.success){
			var opener = window.top.getOpener();
			opener.refreshPage("baseProviderForm","baseProviderDiv");
			if(!$("#baseProviderId").val())
				$("#baseProviderId").val(data.message);
			myAlert(globalSaveSuccessTip);
		}else{
			myAlert(data.message);
		}
	});
}