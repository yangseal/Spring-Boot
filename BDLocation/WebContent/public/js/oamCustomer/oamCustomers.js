//打开页面即执行查询
$(function(){
	refreshPage("oamCustomersForm","oamCustomersDiv");
});

function showOamCustomer(oamCustomerId,isQuery){
	var url = CONTEXT_PATH + "/oamCustomer/showOamCustomer";
	var title = "新增客户";
	if(oamCustomerId){
		url += "?oamCustomerId=" + oamCustomerId;
		title = "编辑客户";
	}
	if(isQuery){
		url += "&isQuery=true";
		title = "查看客户";
	}
	if($.QueryString()){
		if(url.indexOf("?")>0){
			url += "&";
		}else{
			url += "?";
		}
		url += $.QueryString()._queryString_;
	}
	openTab("oamCustomer",title,url);
}

function viewOamCustomer(){
	var oamCustomerId = getSelectedEntityId("oamCustomersTable");
	if(!oamCustomerId){
		myAlert("请选择待查看客户");
		return;
	}
	showOamCustomer(oamCustomerId,true);
}

function editOamCustomer(){
	var oamCustomerId = getSelectedEntityId("oamCustomersTable");
	if(!oamCustomerId){
		myAlert("请选择待编辑客户");
		return;
	}
	showOamCustomer(oamCustomerId);
}

function deleteOamCustomer(){
	var oamCustomerIds = getCheckedEntityIds("oamCustomersTable");
	if(!oamCustomerIds){
		myAlert("请勾选待删除客户");
		return;
	}
	myConfirm(globalDeleteTip,function(){
		var url = CONTEXT_PATH + "/oamCustomer/deleteOamCustomer";
		var params = {oamCustomerIds:oamCustomerIds};
		jQuery.post(url, params, function(data) {
			if(data.success){
				refreshPage("oamCustomersForm","oamCustomersDiv");
			}else{
				myAlert(data.message);
			}
		});
	});
}

function exportOamCustomers(){
	var url = CONTEXT_PATH + "/oamCustomer/exportOamCustomers?" + $("#oamCustomersForm").serialize();
	window.location.href = url;
}

function selectOamArea(){
	var dom = $("<div fkFieldCode='oamArea'/>");
	var url = CONTEXT_PATH + "/oamArea/selectOamArea";
	dom.load(url,null,function(){
		dialog({
			id:'oamArea',
			title : "选择所属省市",
			content : dom
		}).showModal();
	});
}
