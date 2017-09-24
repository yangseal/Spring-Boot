//打开页面即执行查询
$(function(){
	refreshPage("corsApprovesForm","corsApprovesDiv");
	refreshPage("showRepayDetailOrderForm","showRepayDetailOrderDiv");
});
//查看页面
function showCorsApprove(corsApproveId,isQuery,action){
	var url="";
	url = CONTEXT_PATH + "/corsApprove/showApprove";
	url +="?corsApproveId="+corsApproveId;
	var title = "";
	if(action == "read"){
		url += "&isQuery=true";
		title="查看CORS账号审核";
	}else if (action == "do"){
		title="CORS账号审核";
	}
	openTab("corsApprove",title,url);
}
function viewCorsApprove(action){
	var checkbox = $("input[type='checkbox']:checked",$("#corsApprovesTable"));
	if(checkbox && checkbox.length != 1 ) {
		myAlert("请选择一条记录进行操作");
		return;
	}
	var corsApproveId = $(checkbox[0]).closest('tr').attr('entityId');
	var applyStatus = $(checkbox[0]).closest('tr').attr('applyStatus');
	if(applyStatus != 4 && action == 'do'){
		myAlert("该记录已审批!");
		return;
	}
	showCorsApprove(corsApproveId,true,action);
}

//确认审批通过
function passAccount(corsApproveId,busiApproveType,accountType,applyCount){
	var url = CONTEXT_PATH + "/corsApprove/passAccount";
	var param = "busiApproveType="+busiApproveType+"&orderBussinkey="+corsApproveId+"&accountType="+accountType+"&applyCount="+applyCount+"&busiApproveOpinion="
	//var params = $("#corsApprovesForm").serialize();
	myConfirm("确定通过吗?",function(){
	$.post(url,param,function(data){
		if(data.success){
			myAlert("审批成功!");
			setTimeout(function(){
				location.href = CONTEXT_PATH +"/corsApprove/showApproves";
			},3000);
			
		} else {
			myAlert("审批失败!");
		}
				
	});
	});
}

//审批拒绝
function acncelAccount(corsApproveId){
	var dom = $("<div/>");
	url = CONTEXT_PATH + "/corsApprove/showApproveOpinion";
			//window.curRow = $(sender).closest("tr");
	var params = {corsApproveId:corsApproveId};
	dom.load(url,params,function(){
		dialog({
			title : "审批意见",
			content : dom,
			width:800
		}).showModal();
	});
}

//查看订单详情
function showOrderDetail(orderBussinkey,orderType){
	var url = CONTEXT_PATH + "/corsApprove/showBuyOrderDetail?orderBussinkey="+orderBussinkey;
	if(orderType == 'rorder')
		url = CONTEXT_PATH + "/corsApprove/showRepayOrderDetail?orderBussinkey="+orderBussinkey;
	var title = "查看订单详情";
	openTab("corsOrderDetail",title,url);
}

