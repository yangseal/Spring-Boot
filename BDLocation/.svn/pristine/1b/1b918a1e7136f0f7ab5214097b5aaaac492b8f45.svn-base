//打开页面即执行查询
$(function(){
	refreshPage("corsAccountsForm","corsAccountsDiv");
});

function showCorsAccount(corsAccountId,isQuery){
	var url = CONTEXT_PATH + "/corsAccount/showCorsAccount";
	var title = "新增CORS账号";
	if(corsAccountId){
		url += "?corsAccountId=" + corsAccountId;
		title = "编辑CORS账号";
	}
	if(isQuery){
		url += "&isQuery=true";
		title = "查看CORS账号";
	}
	if($.QueryString()){
		if(url.indexOf("?")>0){
			url += "&";
		}else{
			url += "?";
		}
		url += $.QueryString()._queryString_;
	}
	openTab("corsAccount",title,url);
}

function viewCorsAccount(){
	var corsAccountId = getSelectedEntityId("corsAccountsTable");
	if(!corsAccountId){
		myAlert("请选择待查看CORS账号");
		return;
	}
	showCorsAccount(corsAccountId,true);
}

function editCorsAccount(){
	var corsAccountId = getSelectedEntityId("corsAccountsTable");
	if(!corsAccountId){
		myAlert("请选择待编辑CORS账号");
		return;
	}
	showCorsAccount(corsAccountId);
}

function deleteCorsAccount(){
	var corsAccountIds = getCheckedEntityIds("corsAccountsTable");
	if(!corsAccountIds){
		myAlert("请勾选待删除CORS账号");
		return;
	}
	myConfirm(globalDeleteTip,function(){
		var url = CONTEXT_PATH + "/corsAccount/deleteCorsAccount";
		var params = {corsAccountIds:corsAccountIds};
		jQuery.post(url, params, function(data) {
			if(data.success){
				refreshPage("corsAccountsForm","corsAccountsDiv");
			}else{
				myAlert(data.message);
			}
		});
	});
}

function exportCorsAccounts(){
	var url = CONTEXT_PATH + "/corsAccount/exportCorsAccounts?" + $("#corsAccountsForm").serialize();
	window.location.href = url;
}

function selectCompany(){
	_fkFieldCode = "company";
	var dom = $("<div/>");
	var url = CONTEXT_PATH + "/company/selectCompany";
	dom.load(url,null,function(){
		dialog({
			title : "选择所属企业",
			content : dom
		}).showModal();
	});
}
function selectOamArea(){
	_fkFieldCode = "oamArea";
	var dom = $("<div/>");
	var url = CONTEXT_PATH + "/oamArea/selectOamArea";
	dom.load(url,null,function(){
		dialog({
			title : "选择应用区域",
			content : dom
		}).showModal();
	});
}
