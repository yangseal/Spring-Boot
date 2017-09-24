$(function(){
	refreshPage("proContractForm","proContractDiv");
	$("#attachments").myFileUpload({
		isQuery : "",
		entityName : "baseProContract",
		fieldName : "attachments",
		entityId : $("#baseProContractId").val()
	});
	validateRealTime("providerContractForm");
});

function showProContract(proContractId){
	var baseProviderId = $("#baseProviderId").val();
	var url = CONTEXT_PATH + "/baseStation/provider/openProContract?baseProviderId=" + baseProviderId;
	var title = "新增合同";
	if(proContractId){
		url += "&proContractId=" + proContractId;
		title = "修改合同";
	}
	openTab("proContractNew",title,url);
}

function editProContract(){
	var tableId = "proContractTable";
	if(getSelectedEntityIdForOne(tableId)){
		var entityId = getSelectedEntityIdForOne(tableId);
		showProContract(entityId,baseProviderId);
	}
}

function saveProContract(){
	if(!validateForm("providerContractForm")){
		return;
	}
	var baseProviderId = $("#baseProviderId").val();
	var url = CONTEXT_PATH + "/baseStation/provider/saveProContract?baseProviderId=" + baseProviderId;
	var params = $("#providerContractForm").serialize();
	jQuery.post(url, params, function(data) {
		if(data.success){
			var opener = window.top.getOpener();
			opener.refreshPage("proContractForm","proContractDiv");
			if(!$("#baseProContractId").val())
				$("#baseProContractId").val(data.message);
			myAlert(globalSaveSuccessTip);
			setTimeout(function(){
				opener.showProContract(data.message);
			},2000);
		}else{
			myAlert(data.message);
		}
	});
}
