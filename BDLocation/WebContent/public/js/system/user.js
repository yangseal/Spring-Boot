$(function(){
	if($.QueryString()){
		var companyIdValue = $.QueryString("companyId");
		var companyNameValue = $.QueryString("companyName");
		if(companyIdValue){
			$("#companyId").val(companyIdValue);
			$("#company").val(decodeURIComponent(companyNameValue));
		}
	}
});

function saveUser(){
	if(!validateForm("userForm")){
		return;
	}
	var url = CONTEXT_PATH + "/user/saveUser";
	var params = $("#userForm").serialize();
	jQuery.post(url, params, function(data) {
		if(data.success){
			var opener = window.top.getOpener();
			opener.refreshPage("usersForm","usersDiv");
			if($("#userId").val()){
				myAlert(globalSaveSuccessTip);
				return;
			}
			alert(globalSaveSuccessTip);
			opener.showUser(data.message);
		}else{
			myAlert(data.message);
		}
	});
}

function selectCompany(){
	var dom = $("<div fkFieldCode='company'/>");
	var url = CONTEXT_PATH + "/company/selectCompany";
	dom.load(url,null,function(){
		dialog({
			id:'company',
			title : "选择企业",
			content : dom
		}).showModal();
	});
}

