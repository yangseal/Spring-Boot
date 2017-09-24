$(function(){
	refreshPage("corsInitsForm","corsInitsDiv");
	refreshPage("showRepayDetailOrderForm","showRepayDetailOrderDiv");
});

//查看
function showCorsInit(){
	var checkbox = $("input[type='checkbox']:checked",$("#corsInitsTable"));
	if(checkbox && checkbox.length != 1 ) {
		myAlert("请选择一条数据查看");
		return;
	}
	var entityId = $(checkbox[0]).closest('tr').attr('entityId');
	if(entityId == null){
		myAlert("请选择后再查看！");
		return;
	}
	var url =CONTEXT_PATH+"/corsInit/showCorsInit";
	url += "?bussinessId="+ entityId;
	var title ="查看CORS账号";
	openTab(entityId,title,url);
}

function doInit(){
	var checkbox = $("input[type='checkbox']:checked",$("#corsInitsTable"));
	if(checkbox && checkbox.length != 1 ) {
		myAlert("请选择一条记录生成账号");
		return;
	}
	var entityId = $(checkbox[0]).closest('tr').attr('entityId');
	var state = $(checkbox[0]).closest('tr').attr("state");
	if(entityId == null){
		myAlert("请选择后再生成！");
		return;
	}
	if(state == "YES"){
		myAlert("当前为已生成账号！");
		return;
	}
		myConfirm("你确定生成吗？",function(){
			var url = CONTEXT_PATH + "/corsInit/doneInit";
			var accountPrefix = $("#accountPrefix").val();
			var remark = $("#remark").val();
			var params = {"bussinessId":entityId,"accountPrefix":accountPrefix,"remark":remark};
			$.post(url,params,function(){
				myAlert("生成成功！");
				location.href = CONTEXT_PATH + "/corsInit/showCorsInits";
			});
		});
}

function showAccounts(bussinessId){
	var dom =$("<div/>");
	var url = CONTEXT_PATH +"/corsInit/queryAccounts";
	var params ={"bussinessId":bussinessId};
	dom.load(url,params,function(){
		dialog({
			title : "账号详情",
			content : dom,
			width : 800
		}).showModal();
	});
}

function printOrders(){
	
	var entityIds = "";
	var checkboxs = $("input[name=data]:checked");
	if(checkboxs.length < 1){
		myAlert("请选择打印预览数据!");
		return;
	}
	for(var i=0,l=checkboxs.length; i<l; i++){
		var tr = $(checkboxs[i]).closest("tr");
		entityIds += tr.attr("entityId")+",";
	}
	entityIds = entityIds.substring(0, entityIds.length-1);
	var url =CONTEXT_PATH+"/corsInit/showCorsAccounts";
	url += "?bussinessIds="+ entityIds;
	var title ="CORS账号打印预览";
	openTab(entityIds,title,url);
}

//查看订单详情
function showOrderDetail(orderBussinkey,orderType){
	var url = CONTEXT_PATH + "/corsApprove/showBuyOrderDetail?orderBussinkey="+orderBussinkey;
	if(orderType == 'rorder')
		url = CONTEXT_PATH + "/corsApprove/showRepayOrderDetail?orderBussinkey="+orderBussinkey;
	var title = "查看订单详情";
	openTab("corsOrderDetail",title,url);
}
