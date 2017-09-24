//打开页面即执行查询
$(function(){
	refreshPage("oamProvidersForm","oamProvidersDiv");
});

function showOamProvider(oamProviderId,isQuery){
	var url = CONTEXT_PATH + "/oamProvider/showOamProvider";
	var title = "新增供应商";
	if(oamProviderId){
		url += "?oamProviderId=" + oamProviderId;
		title = "编辑供应商";
	}
	if(isQuery){
		url += "&isQuery=true";
		title = "查看供应商";
	}
	if($.QueryString()){
		if(url.indexOf("?")>0){
			url += "&";
		}else{
			url += "?";
		}
		url += $.QueryString()._queryString_;
	}
	openTab("oamProvider",title,url);
}

function viewOamProvider(){
	var oamProviderId = getSelectedEntityId("oamProvidersTable");
	if(!oamProviderId){
		myAlert("请选择待查看供应商");
		return;
	}
	showOamProvider(oamProviderId,true);
}

function editOamProvider(){
	var oamProviderId = getSelectedEntityId("oamProvidersTable");
	if(!oamProviderId){
		myAlert("请选择待编辑供应商");
		return;
	}
	showOamProvider(oamProviderId);
}

function deleteOamProvider(){
	var oamProviderIds = getCheckedEntityIds("oamProvidersTable");
	if(!oamProviderIds){
		myAlert("请勾选待删除供应商");
		return;
	}
	myConfirm(globalDeleteTip,function(){
		var url = CONTEXT_PATH + "/oamProvider/deleteOamProvider";
		var params = {oamProviderIds:oamProviderIds};
		jQuery.post(url, params, function(data) {
			if(data.success){
				refreshPage("oamProvidersForm","oamProvidersDiv");
			}else{
				myAlert(data.message);
			}
		});
	});
}

function exportOamProviders(){
	var url = CONTEXT_PATH + "/oamProvider/exportOamProviders?" + $("#oamProvidersForm").serialize();
	window.location.href = url;
}

