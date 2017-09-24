//打开页面即执行查询
$(function(){
	refreshPage("oamAccountsForm","oamAccountsDiv");
});

function showOamAccount(oamAccountId,isQuery){
	var url = CONTEXT_PATH + "/oamAccount/showOamAccount";
	var title = "新增账号";
	if(oamAccountId){
		url += "?oamAccountId=" + oamAccountId;
		title = "编辑账号";
	}
	if(isQuery){
		url += "&isQuery=true";
		title = "查看账号";
	}
	if($.QueryString()){
		if(url.indexOf("?")>0){
			url += "&";
		}else{
			url += "?";
		}
		url += $.QueryString()._queryString_;
	}
	openTab("oamAccount",title,url);
}

function viewOamAccount(){
	var oamAccountId = getSelectedEntityId("oamAccountsTable");
	if(!oamAccountId){
		myAlert("请选择待查看账号");
		return;
	}
	showOamAccount(oamAccountId,true);
}

function editOamAccount(){
	var oamAccountId = getSelectedEntityId("oamAccountsTable");
	if(!oamAccountId){
		myAlert("请选择待编辑账号");
		return;
	}
	showOamAccount(oamAccountId);
}

function deleteOamAccount(){
	var oamAccountIds = getCheckedEntityIds("oamAccountsTable");
	if(!oamAccountIds){
		myAlert("请勾选待删除账号");
		return;
	}
	myConfirm(globalDeleteTip,function(){
		var url = CONTEXT_PATH + "/oamAccount/deleteOamAccount";
		var params = {oamAccountIds:oamAccountIds};
		jQuery.post(url, params, function(data) {
			if(data.success){
				refreshPage("oamAccountsForm","oamAccountsDiv");
			}else{
				myAlert(data.message);
			}
		});
	});
}

function exportOamAccounts(){
	var url = CONTEXT_PATH + "/oamAccount/exportOamAccounts?" + $("#oamAccountsForm").serialize();
	window.location.href = url;
}

function selectOamCustomer(){
	var dom = $("<div fkFieldCode='oamCustomer'/>");
	var url = CONTEXT_PATH + "/oamCustomer/selectOamCustomer";
	dom.load(url,null,function(){
		dialog({
			id:'oamCustomer',
			title : "选择所属客户",
			content : dom
		}).showModal();
	});
}
