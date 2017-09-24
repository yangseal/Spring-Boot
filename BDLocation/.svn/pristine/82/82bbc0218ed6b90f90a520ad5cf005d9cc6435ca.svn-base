$(function(){
	$("iframe").height($("body").height()-globalTabHeight);
});

function saveOamAccount(){
	if(!validateForm("oamAccountForm")){
		return;
	}
	var url = CONTEXT_PATH + "/oamAccount/saveOamAccount";
	var params = $("#oamAccountForm").serialize();
	jQuery.post(url, params, function(data) {
		if(data.success){
			var opener = window.top.getOpener();
			opener.refreshPage("oamAccountsForm","oamAccountsDiv");
			if($("#oamAccountId").val()){
				myAlert(globalSaveSuccessTip);
				return;
			}
			alert(globalSaveSuccessTip);
			opener.showOamAccount(data.message);
		}else{
			myAlert(data.message);
		}
	});
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
