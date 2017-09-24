$(function(){
	
	$("iframe").height($("body").height()-globalTabHeight);
	$("#attachments").myFileUpload({
		isQuery : 'true',
		entityName : "companyLicense",
		fieldName : "attachments",
		entityId : $("#orderBussinkey").val()
	});
});
function approveCompanyExamine(){
	
	if(!validateForm("companyExamineForm")){
		return;
	}
	myConfirm("您确定通过该公司的申请吗?",function(){
		var url = CONTEXT_PATH + "/companyExamine/saveQueryExamine";
		var params = $("#companyExamineForm").serialize();
		jQuery.post(url, params, function(data) {
			if(data.success){
				var opener = window.top.getOpener();
				opener.refreshPage("companyExamineForm","companyExamineDiv");
				myAlert("已通过！");
				setTimeout(function(){
					location.href = CONTEXT_PATH +"/companyExamine/showExamines";
				},3000);
			}else{
				myAlert(data.message);
			}
		});
	});
}
function rejectCompanyExamine(){
	if(!validateForm("companyTempForm")){
		return;
	}
	
	myConfirm("您确定拒绝该公司的申请吗?",function(){
		var url = CONTEXT_PATH + "/companyExamine/saveRejectExamine";
		var params = $("#companyExamineForm").serialize();
		jQuery.post(url, params, function(data) {
			if(data.success){
				var opener = window.top.getOpener();
				opener.refreshPage("companyExamineForm","companyExamineDiv");
				myAlert("已拒绝！");
				setTimeout(function(){
					location.href = CONTEXT_PATH +"/companyExamine/showExamines";
				},3000);
			}else{
				myAlert(data.message);
			}
		});
	});
}
