$(function(){
	$("iframe").height($("body").height()-globalTabHeight);
});

function saveCorsAccount(){
	if(!validateForm("corsAccountForm")){
		return;
	}
	
	var url = CONTEXT_PATH + "/corsAccount/saveCorsAccount";
	var params = $("#corsAccountForm").serialize();
	jQuery.post(url, params, function(data) {
		if(data.success){
			var opener = window.top.getOpener();
			opener.refreshPage("corsAccountsForm","corsAccountsDiv");
			if($("#corsAccountId").val()){
				myAlert(globalSaveSuccessTip);
				return;
			}
			myAlert(globalSaveSuccessTip,function(){
				opener.showCorsAccount(data.message);
			});
		}else{
			myAlert(data.message);
		}
	});
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
function selectCorsApply(){
	_fkFieldCode = "corsApply";
	var dom = $("<div/>");
	var url = CONTEXT_PATH + "/corsApply/selectCorsApply";
	dom.load(url,null,function(){
		dialog({
			title : "选择申请批次",
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
