$(function(){
	$(".tab-content").append("<div role='tabpanel' class='tab-pane' id='oamAccountsTab'>"
      + "<iframe code='oamAccounts' frameborder=0 width='100%' src='"+CONTEXT_PATH+"/oamAccount/showOamAccounts?"+QUERY_STRING+"'</iframe></div>");
	$("iframe").height($("body").height()-globalTabHeight);
});

function saveOamCustomer(){
	if(!validateForm("oamCustomerForm")){
		return;
	}
	var url = CONTEXT_PATH + "/oamCustomer/saveOamCustomer";
	var params = $("#oamCustomerForm").serialize();
	jQuery.post(url, params, function(data) {
		if(data.success){
			var opener = window.top.getOpener();
			opener.refreshPage("oamCustomersForm","oamCustomersDiv");
			if($("#oamCustomerId").val()){
				myAlert(globalSaveSuccessTip);
				return;
			}
			alert(globalSaveSuccessTip);
			opener.showOamCustomer(data.message);
		}else{
			myAlert(data.message);
		}
	});
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
