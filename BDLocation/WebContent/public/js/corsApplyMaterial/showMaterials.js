//打开页面即执行查询
$(function(){
	refreshPage("materialsForm","materialsDiv");
});
function showMaterial(orderBussinkey,isQuery){
	
	var url = CONTEXT_PATH + "/corsApplyMaterial/editMaterials";
	var title = "";
	if(orderBussinkey){
		url += "?orderBussinkey=" + orderBussinkey;
		title = "编辑财务资料";
	}
	if(isQuery){
		url += "&isQuery=true";
		title = "查看财务资料";
	}
	if($.QueryString()){
		if(url.indexOf("?")>0){
			url += "&";
		}else{
			url += "?";
		}
		url += $.QueryString()._queryString_;
	}
	openTab("corsBusiApprove",title,url);
}

function viewCompanyExamine(){
	var checkbox = $("input[type='checkbox']:checked",$("#corsApplyMaterialsTable"));
	if(checkbox && checkbox.length != 1 ) {
		myAlert("请选择一条数据进行查看");
		return;
	}
	var busiApproveId = $(checkbox[0]).closest('tr').attr('entityId');
	if(!busiApproveId){
		myAlert("请选择待查看的记录");
		return;
	}
	showMaterial(busiApproveId,busiApproveId,true);
}

function addCompanyExamine(){
	var busiApproveId = getSelectedEntityId("corsApplyMaterialsTable");
	if(!busiApproveId){
		myAlert("请选择待完善的申请");
		return;
	}
	showMaterial(busiApproveId,false);
}

function editCompanyExamine(sender){
	var checkboxs = $("input[name='trdata']:checked",$("#corsApplyMaterialsTable"));
	if(checkboxs.length != 1){
		myAlert("请选择一条数据进行编辑!");
		return ;
	}
	var tr = $(checkboxs).closest("tr"),
		orderBussinkey = tr.attr("entityId");
	showMaterial(orderBussinkey,false);
}

//查看订单详情
function showOrderDetail(orderBussinkey,orderType){
	var url = CONTEXT_PATH + "/corsApprove/showBuyOrderDetail?orderBussinkey="+orderBussinkey;
	if(orderType == 'rorder')
		url = CONTEXT_PATH + "/corsApprove/showRepayOrderDetail?orderBussinkey="+orderBussinkey;
	var title = "查看订单详情";
	openTab("corsOrderDetail",title,url);
}
