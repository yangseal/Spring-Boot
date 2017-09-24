//打开页面即执行查询
$(function(){
	refreshPage("oamContactssForm","oamContactssDiv");
});

function showOamContacts(oamContactsId,isQuery){
	var url = CONTEXT_PATH + "/oamContacts/showOamContacts";
	var title = "新增联系人";
	if(oamContactsId){
		url += "?oamContactsId=" + oamContactsId;
		title = "编辑联系人";
	}
	if(isQuery){
		url += "&isQuery=true";
		title = "查看联系人";
	}
	if($.QueryString()){
		if(url.indexOf("?")>0){
			url += "&";
		}else{
			url += "?";
		}
		url += $.QueryString()._queryString_;
	}
	openTab("oamContacts",title,url);
}

function viewOamContacts(){
	var oamContactsId = getSelectedEntityId("oamContactssTable");
	if(!oamContactsId){
		myAlert("请选择待查看联系人");
		return;
	}
	showOamContacts(oamContactsId,true);
}

function editOamContacts(){
	var oamContactsId = getSelectedEntityId("oamContactssTable");
	if(!oamContactsId){
		myAlert("请选择待编辑联系人");
		return;
	}
	showOamContacts(oamContactsId);
}

function deleteOamContacts(){
	var oamContactsIds = getCheckedEntityIds("oamContactssTable");
	if(!oamContactsIds){
		myAlert("请勾选待删除联系人");
		return;
	}
	myConfirm(globalDeleteTip,function(){
		var url = CONTEXT_PATH + "/oamContacts/deleteOamContacts";
		var params = {oamContactsIds:oamContactsIds};
		jQuery.post(url, params, function(data) {
			if(data.success){
				refreshPage("oamContactssForm","oamContactssDiv");
			}else{
				myAlert(data.message);
			}
		});
	});
}

function exportOamContactss(){
	var url = CONTEXT_PATH + "/oamContacts/exportOamContactss?" + $("#oamContactssForm").serialize();
	window.location.href = url;
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
