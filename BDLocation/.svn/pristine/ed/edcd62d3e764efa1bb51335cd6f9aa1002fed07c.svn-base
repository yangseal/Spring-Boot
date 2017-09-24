$(function(){
	refreshPage("customerCaresForm","customerCaresDiv");
});

/**
 * window.open with post method
 */
function openWindowWithPost(url, name) {
    var newWindow = window.open(url, name,'width=1195px,height=695px');
    if (!newWindow){
        return false;
    }
    var html = "";
    html += "<html><head></head><body><form id='formid' method='post' action='"    + url + "'>";
	html += "<input type='hidden' name='userType' value='cuservice'/>";
	html += "</form><script type='text/javascript'>document.getElementById('formid').submit()<\/script><\/body><\/html>";
	 
    newWindow.document.write(html);
    return newWindow;
}
function clientLogin(){
	var url = CONTEXT_PATH + "/msg/login";
	openWindowWithPost(url,'讯腾客服');
}

function showCustomerCare(customerCareId){
	var title = "新增客服";
	var url = CONTEXT_PATH + "/customerCare/showCustomerCare";
	if(customerCareId){
		title = "编辑客服";
		url += "?customerCareId="+customerCareId;
	}
	openTab("customerCare",title,url);
}

function addCustomerCare(){
	showCustomerCare();
	
}

function editCustomerCare(){
	var checkbox = $("input[type='checkbox']:checked",$("#customerCaresTable"));
	if(checkbox && checkbox.length != 1 ) {
		myAlert("请选择一条记录");
		return;
	}
	var customerCareId = $(checkbox[0]).closest('tr').attr('entityId');
	if(customerCareId == null){
		myAlert("请选择后再操作！");
		return;
	}
	showCustomerCare(customerCareId);
}

function deleteCustomerCare(){
	//获取当前客服Id
	var customerCareIds = getCheckedEntityIds("customerCaresTable");
	if(!customerCareIds){
		myAlert("请勾选待删除客服");
		return;
	}
	myConfirm(globalDeleteTip,function(){
		var url = CONTEXT_PATH + "/customerCare/deleteCustomerCare";
		var params = {"customerCareIds":customerCareIds};
		$.post(url,params,function(data){	
			debugger;
			if(data.success){
				refreshPage("customerCaresForm","customerCaresDiv");
			}else{
				myAlert(data.message);
			}
		});
   });
}

function saveCustomerCare(){
	if(!validateForm("customerCareForm")){
		return;
	}
	var url = CONTEXT_PATH + "/customerCare/saveCustomerCare";
	var params = $("#customerCareForm").serialize();
	$.post(url,params,function(data){
		if(data.success){
			var opener = window.top.getOpener();
			opener.refreshPage("customerCaresForm","customerCaresDiv");
			if($("#customerCareId").val()){
				myAlert(globalSaveSuccessTip);
				return;
			}
			alert(globalSaveSuccessTip);
			opener.showCustomerCare(data.message);
		}else{
			myAlert(data.message);
		}
	});
	
}