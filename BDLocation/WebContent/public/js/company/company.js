$(function(){
	$("iframe").height($("body").height()-globalTabHeight);
	$("#attachments").myFileUpload({
		isQuery : $.QueryString("isQuery"),
		entityName : "company",
		fieldName : "attachments",
		entityId : $("#companyId").val()
	});
});
function saveCompany(){
	if(!validateForm("companyForm")){
		return;
	}
	var url = CONTEXT_PATH + "/company/saveCompany";
	var params = $("#companyForm").serialize();
	jQuery.post(url, params, function(data) {
		if(data.success){
			var opener = window.top.getOpener();
			opener.refreshPage("companysForm","companysDiv");
			if($("#companyId").val()){
				myAlert(globalSaveSuccessTip);
				return;
			}
			alert(globalSaveSuccessTip);
			opener.showCompany(data.message);
		}else{
			myAlert(data.message);
		}
	});
}
//资料提交，声成审批信息 0：未提交  1：已提交  2：审批通过  3：审批未通过
function ComData(){
	if($("#companyMaterialState").val()=='1' || $("#companyMaterialState").val()=='2'){
		myAlert("该企业已提交资料或审核已通过");
		return;
	}
	//var user_commy = CURRENT_USER.companyId;
	var url1 = CONTEXT_PATH + "/company/saveApprove";
	var params = $("#companyForm").serialize();
	jQuery.post(url1, params, function(data) {
		if(data.success){
			var opener = window.top.getOpener();
			opener.refreshPage("companysForm","companysDiv");
			if($("#companyId").val()){
				myAlert(globalSaveSuccessTip);
				return;
			}
			alert(globalSaveSuccessTip);
			opener.showCompany(data.message);
		}else{
			myAlert(data.message);
		}
	});
}