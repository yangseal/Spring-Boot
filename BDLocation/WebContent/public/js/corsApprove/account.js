$(function(){
	$("iframe").height($("body").height()-globalTabHeight);
});
function detailAccount(bussinessId){
	var dom = $("<div/>");
	var url = CONTEXT_PATH + "/corsApprove/detailAccount";
	var params = {"orderBussinkey":bussinessId};
	
	dom.load(url,params,function(){
		dialog({
			title : "账号详情",
			content : dom,
			width:800
		}).showModal();
	});
}

//拒绝
function rejectAccount(){
	var url = CONTEXT_PATH + "/corsApprove/rejectAccount";
	
		if($("#busiApproveOpinion").val()==""){
		myAlert("请您填写取消意见!");
		return;
	}
	var params = $("#accountForm").serialize();
		myConfirm("确定拒绝吗?",function(){
			$.post(url,params,function(data){
			if(data.success){
				myAlert("审批成功!");
				setTimeout(function(){
				location.href =CONTEXT_PATH +"/corsApprove/showApproves";
				},3000);
			} else {
				myAlert("审批失败!");
			}
		});
	});
}
////续费通过
//function passRepayAccount(bussinessId){
//	
//	var url = CONTEXT_PATH + "/corsApprove/passRepayAccount";
//	var params ={};
//	params["company_id"] = $("#companyId").val();
//	params["bussinessId"] = bussinessId;
//	params["count"] = $("#count").val();
//	params["account_type"] = $("#account_type").val();
//	params["opinion"] = $("#opinion").val();
//	$.post(url,{"object":JSON.stringify(params)},function(data){
//		myConfirm("确定吗?",function(){
//			location.href =CONTEXT_PATH +"/corsApprove/showApproves";
//		});
//	});
//}
//
////续费拒绝
//function rejectRepayAccount(bussinessId){
//	var url = CONTEXT_PATH + "/corsApprove/rejectRepayAccount";
//	var opinion = $("#opinion").val();
//	var params = {"bussinessId":bussinessId,"opinion":opinion};
//	$.post(url,params,function(data){
//		myConfirm("确定吗?",function(){
//			location.href =CONTEXT_PATH +"/corsApprove/showApproves";
//		});
//	});
//}