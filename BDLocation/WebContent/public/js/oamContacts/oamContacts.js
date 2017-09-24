$(function(){
	$("iframe").height($("body").height()-globalTabHeight);
});

function saveOamContacts(){
	if(!validateForm("oamContactsForm")){
		return;
	}
	var url = CONTEXT_PATH + "/oamContacts/saveOamContacts";
	var params = $("#oamContactsForm").serialize();
	jQuery.post(url, params, function(data) {
		if(data.success){
			var opener = window.top.getOpener();
			opener.refreshPage("oamContactssForm","oamContactssDiv");
			if($("#oamContactsId").val()){
				myAlert(globalSaveSuccessTip);
				return;
			}
			alert(globalSaveSuccessTip);
			opener.showOamContacts(data.message);
		}else{
			myAlert(data.message);
		}
	});
}

function selectOamCustomer(){
	var dom = $("<div fkFieldCode='oamCustomer'/>");
	var url = CONTEXT_PATH + "/oamCustomer/selectOamCustomer";
	dom.load(url,null,function(){
		dialog({
			id:'oamCustomer',
			title : "选择所属客户",
			content : dom
		}).showModal();
	});
}
