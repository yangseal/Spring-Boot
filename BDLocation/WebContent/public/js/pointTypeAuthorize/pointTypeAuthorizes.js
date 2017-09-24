//打开页面即执行查询
$(function(){
	refreshPage("pointTypeAuthorizesForm","pointTypeAuthorizesDiv");
});

function showPointTypeAuthorize(pointTypeAuthorizeId,isQuery){
	var url = CONTEXT_PATH + "/pointTypeAuthorize/showPointTypeAuthorize";
	var title = "新增点类型授权";
	if(pointTypeAuthorizeId){
		url += "?pointTypeAuthorizeId=" + pointTypeAuthorizeId;
		title = "编辑点类型授权";
	}
	if(isQuery){
		url += "&isQuery=true";
		title = "查看点类型授权";
	}
	if($.QueryString()){
		if(url.indexOf("?")>0){
			url += "&";
		}else{
			url += "?";
		}
		url += $.QueryString()._queryString_;
	}
	openTab("pointTypeAuthorize",title,url);
}

function viewPointTypeAuthorize(){
	var pointTypeAuthorizeId = getSelectedEntityId("pointTypeAuthorizesTable");
	if(!pointTypeAuthorizeId){
		myAlert("请选择待查看点类型授权");
		return;
	}
	showPointTypeAuthorize(pointTypeAuthorizeId,true);
}

function editPointTypeAuthorize(){
	var pointTypeAuthorizeId = getSelectedEntityId("pointTypeAuthorizesTable");
	if(!pointTypeAuthorizeId){
		myAlert("请选择待编辑点类型授权");
		return;
	}
	showPointTypeAuthorize(pointTypeAuthorizeId);
}

function deletePointTypeAuthorize(){
	var pointTypeAuthorizeIds = getCheckedEntityIds("pointTypeAuthorizesTable");
	if(!pointTypeAuthorizeIds){
		myAlert("请勾选待删除点类型授权");
		return;
	}
	myConfirm(globalDeleteTip,function(){
		var url = CONTEXT_PATH + "/pointTypeAuthorize/deletePointTypeAuthorize";
		var params = {pointTypeAuthorizeIds:pointTypeAuthorizeIds};
		jQuery.post(url, params, function(data) {
			if(data.success){
				refreshPage("pointTypeAuthorizesForm","pointTypeAuthorizesDiv");
			}else{
				myAlert(data.message);
			}
		});
	});
}

function exportPointTypeAuthorizes(){
	var url = CONTEXT_PATH + "/pointTypeAuthorize/exportPointTypeAuthorizes?" + $("#pointTypeAuthorizesForm").serialize();
	window.location.href = url;
}