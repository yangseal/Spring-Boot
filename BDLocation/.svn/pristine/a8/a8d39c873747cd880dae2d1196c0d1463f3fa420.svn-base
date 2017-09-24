$(function(){
	refreshPage("contractsForm","contractsDiv",0);
	$("#attachments").myFileUpload({
		isQuery : "",
		entityName : "BaseCustomerContractMaterial",
		fieldName : "attachments",
		entityId : $("#baseCustomerContractId").val()
	});
	validateRealTime("contractForm");
});

//查看,新增,修改通用方法
function showContract(contractId,isQuery){
	var url = CONTEXT_PATH+"/baseStation/customer/showContract";
	var baseCustomerId = $("#baseCustomerId").val();
	url += "?baseCustomerId="+baseCustomerId;
	var title ="新增合同";
	if(contractId){
		url+="&contractId="+contractId;
		title="修改合同";
	}
	if(isQuery){
		url += "&isQuery=true";
		title="查看合同";
	}
	openTab("contract",title,url);
}

function addContract(){
	
	showContract();
}

function editContract(){
	if(getSelectedEntityIdForOne("contractsTable")){
		var entityId =	getSelectedEntityIdForOne("contractsTable");
		showContract(entityId);
	}
	return;
}

function viewContract(){
	var entityId =	getSelectedEntityIdForOne("contractsTable");
	 showContract(entityId,true);
}

function saveContract(){
	if(!validateForm("contractForm")){
		myAlert("页面输入有误，请更正后继续保存!");
		return;
	}
	var url = CONTEXT_PATH+"/baseStation/customer/saveContract";
	var params = $("#contractForm").serialize();
	$.post(url,params,function(data){
		if(data.success){
			var opener = window.top.getOpener();
			opener.refreshPage("contractsForm","contractsDiv");
			if(!$("#baseCustomerContractId").val())
				$("#baseCustomerContractId").val(data.message);
				myAlert(globalSaveSuccessTip);
				setTimeout(function(){
					opener.showContract(data.message);
				},2000);
			}else{
				myAlert(data.message);
			}
		
	});
}