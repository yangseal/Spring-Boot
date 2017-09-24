//打开页面即执行查询
$(function(){
	refreshPage("dictsForm","dictsDiv");
});

function showDict(dictId,isQuery){
	var url = CONTEXT_PATH + "/dict/showDict";
	var title = "新增字典";
	if(dictId){
		url += "?dictId=" + dictId;
		title = "编辑字典";
	}
	if(isQuery){
		url += "&isQuery=true";
		title = "查看字典";
	}
	if($.QueryString()){
		if(url.indexOf("?")>0){
			url += "&";
		}else{
			url += "?";
		}
		url += $.QueryString()._queryString_;
	}
	openTab("dict",title,url);
}

function viewDict(){
	var dictId = getSelectedEntityId("dictsTable");
	if(!dictId){
		myAlert("请选择待查看字典");
		return;
	}
	showDict(dictId,true);
}

function editDict(){
	var dictId = getSelectedEntityId("dictsTable");
	if(!dictId){
		myAlert("请选择待编辑字典");
		return;
	}
	showDict(dictId);
}

function deleteDict(){
	var dictIds = getCheckedEntityIds("dictsTable");
	if(!dictIds){
		myAlert("请勾选待删除字典");
		return;
	}
	myConfirm(globalDeleteTip,function(){
		var url = CONTEXT_PATH + "/dict/deleteDict";
		var params = {dictIds:dictIds};
		jQuery.post(url, params, function(data) {
			if(data.success){
				refreshPage("dictsForm","dictsDiv");
			}else{
				myAlert(data.message);
			}
		});
	});
}
