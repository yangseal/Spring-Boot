$(function(){
	refreshPage("corsRepaysForm","corsRepaysDiv");
	refreshPage("showRepayDetailOrderForm","showRepayDetailOrderDiv");
});

function corsRepay(corsRepayId){
	
	var url = CONTEXT_PATH + "/corsRepay/corsRepayActive?corsRepayId=" + corsRepayId;
	var params = {};
	myConfirm("确定进行续费操作吗?",function(){
		$.post(url,params,function(data){
			if(data.success){
				myAlert("续费成功!");
				refreshPage("corsRepaysForm","corsRepaysDiv",$("#corsRepaysForm_pageIndex").val());
			} else {
				myAlert("续费失败!");
			}
		});
	});
}

//查看订单详情
function showOrderDetail(orderBussinkey){
	var url = CONTEXT_PATH + "/corsApprove/showRepayOrderDetail?orderBussinkey="+orderBussinkey;
	var title = "查看订单详情";
	openTab("corsOrderDetail",title,url);
}
