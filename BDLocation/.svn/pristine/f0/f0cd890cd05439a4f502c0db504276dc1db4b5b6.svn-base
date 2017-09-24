$(function(){
	refreshPage("customersForm","customersDiv",0);
	validateRealTime("customerForm");
});

//查看,新增,修改通用方法
function showCustomer(customerId,isQuery){
	var url = CONTEXT_PATH+"/baseStation/customer/showCustomer";
	var title ="新增联系人";
	var baseCustomerId = $("#baseCustomerId").val();
	url += "?baseCustomerId="+baseCustomerId;
	if(customerId){
		url+="&customerId="+customerId;
		title="修改联系人";
	}
	if(isQuery){
		url += "&isQuery=true";
		title="查看联系人";
	}
	openTab("customer",title,url);
}

function addCustomer(){
	showCustomer();
}

function editCustomer(){
	if(getSelectedEntityIdForOne("customersTable")){
		var entityId =	getSelectedEntityIdForOne("customersTable");
		showCustomer(entityId);
	}
	return;
}

function viewCustomer(){
	 var entityId =	getSelectedEntityIdForOne("customersTable");
	 showCustomer(entityId,true);
}

//删除联系人
function deleteCustomer(){
	var customerIds = getCheckedEntityIds("customersTable");
	if(!customerIds){
		myAlert("请勾选待删除联系人");
		return;
	}
	myConfirm(globalDeleteTip,function(){
		var url = CONTEXT_PATH + "/baseStation/customer/deleteCustomer";
		var params = {customerIds:customerIds};
		jQuery.post(url, params, function(data) {
			if(data.success){
				refreshPage("customersForm","customersDiv");
			}else{
				myAlert(data.message);
			}
		});
	});
}
//保存联系人
function saveCustomer(){ 
	if(!validateForm("customerForm")){
		return;
	}
	var url = CONTEXT_PATH + "/baseStation/customer/saveCustomer";;
	var params = $("#customerForm").serialize();
	$.post(url,params,function(data){
		if(data.success){
			var opener = window.top.getOpener();
			opener.refreshPage("customersForm","customersDiv");
			if(!$("#baseCustomerUserId").val())
				$("#baseCustomerUserId").val(data.message);
				myAlert(globalSaveSuccessTip);
		    }else{
				myAlert(data.message);
			}
});
}
