$(function(){
	refreshPage("baseCustomersForm","baseCustomersDiv",0);
	Location.init(["","",0,0,$("#addressName").val()], $('#baseCustomerForm'));
	validateRealTime('baseCustomerForm');
});

function cusShowCustomers(baseCustomerId){
	var url = CONTEXT_PATH+"/baseStation/customer/showCustomers";
	var title ="联系人管理";
	url+="?baseCustomerId="+baseCustomerId;
	openTab("p_customer",title,url);
}

function cusShowContracts(baseCustomerId){
	var url = CONTEXT_PATH+"/baseStation/customer/showContracts";
	var title ="服务合同管理";
	url+="?baseCustomerId="+baseCustomerId;
	openTab("p_contract",title,url);
}

function cusShowProjects(baseCustomerId){
	var url = CONTEXT_PATH+"/baseStation/customer/showProjects";
	var title ="基站项目管理";
	url+="?baseCustomerId="+baseCustomerId;
	openTab("p_project",title,url);
}

function showBaseCustomer(baseCustomerId,isQuery){
	var url = CONTEXT_PATH+"/baseStation/customer/showBaseCustomer";
	var title = "新增基站客户";
	if(baseCustomerId){
		title = "修改基站客户 ";
		url += "?baseCustomerId="+baseCustomerId;
	}
	if(isQuery){
		title = "查看基站客户";
	}
	openTab("baseCustomer",title,url);
}

function addBaseCustomer(){
	
	showBaseCustomer();
	
}

function editBaseCustomer(){
	if(getSelectedEntityIdForOne("baseCustomersTable")){
		var entityId = getSelectedEntityIdForOne("baseCustomersTable");
		showBaseCustomer(entityId);
	}
	return;
}

function saveBaseCustomer(){
	if(validateForm("baseCustomerForm")){
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
	
	var url = CONTEXT_PATH+"/baseStation/customer/saveBaseCustomer";
	var params = $("#baseCustomerForm").serialize();
	$.post(url,params,function(data){
		if(data.success){
			var opener = window.top.getOpener();
			opener.refreshPage("baseCustomersForm","baseCustomersDiv");
			if(!$("#baseCustomerId").val())
				$("#baseCustomerId").val(data.message);
				myAlert(globalSaveSuccessTip);
			}else{
			myAlert(data.message);
		}
	  
	});
}
