$(function(){
	
	$("iframe").height($("body").height()-globalTabHeight);
});

function saveCompanyTemp(){
	
	if(!validateForm("companyTempForm")){
		return;
	}
	var url = CONTEXT_PATH + "/companyTemp/saveCompanyTemp";
	var params = $("#companyTempForm").serialize();
	jQuery.post(url, params, function(data) {
		if(data.success){
			var opener = window.top.getOpener();
			opener.refreshPage("companyTempsForm","companyTempsDiv");
			if($("#companyTempId").val()){
				myAlert(globalSaveSuccessTip);
				return;
			}
			alert(globalSaveSuccessTip);
			opener.showCompanyTemp(data.message);
		}else{
			myAlert(data.message);
		}
	});
}

function saveCompanyTempByPage(){
	if(!validateForm("companyTempForm")){
		return;
	}
	var url = CONTEXT_PATH + "/companyTemp/saveCompanyTempByPage";
	var params = $("#companyTempForm").serialize();
	jQuery.post(url, params, function(data) {
		if(data.success){
			myAlert("注册成功！");
			setTimeout(function(){
				window.location.href=CONTEXT_PATH + "/login";
			},2000);
		}else{
			myAlert(data.message);
		}
	});
}

function approveCompanyTemps(){
	if(!validateForm("companyTempForm")){
		return;
	}
	var url = CONTEXT_PATH + "/companyTemp/saveApproveCompanyTemp";
	var params = $("#companyTempForm").serialize();
	jQuery.post(url, params, function(data) {
		if(data.success){
			var opener = window.top.getOpener();
			opener.refreshPage("companyTempsForm","companyTempsDiv");
			alert("已通过！");
		}else{
			myAlert(data.message);
		}
	});
	
}
function rejectCompanyTemp(){
	if(!validateForm("companyTempForm")){
		return;
	}
	var url = CONTEXT_PATH + "/companyTemp/saveRejectCompanyTemp";
	var params = $("#companyTempForm").serialize();
	jQuery.post(url, params, function(data) {
		if(data.success){
			var opener = window.top.getOpener();
			opener.refreshPage("companyTempsForm","companyTempsDiv");
			alert("已拒绝！");
		}else{
			myAlert(data.message);
		}
	});
	
}
