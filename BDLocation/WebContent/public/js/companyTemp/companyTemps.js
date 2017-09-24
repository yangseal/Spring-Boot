//打开页面即执行查询
$(function(){
	
	refreshPage("companyTempsForm","companyTempsDiv");
});

function showCompanyTemp(companyTempId,isQuery){
	var url = CONTEXT_PATH + "/companyTemp/showCompanyTemp";
	var title = "新增注册企业";
	if(companyTempId){
		url += "?companyTempId=" + companyTempId;
		title = "编辑注册企业";
	}
	if(isQuery){
		url += "&isQuery=true";
		title = "查看注册企业";
	}
	if($.QueryString()){
		if(url.indexOf("?")>0){
			url += "&";
		}else{
			url += "?";
		}
		url += $.QueryString()._queryString_;
	}
	openTab("companyTemp",title,url);
}

function viewCompanyTemp(){
	var companyTempId = getSelectedEntityId("companyTempsTable");
	if(!companyTempId){
		myAlert("请选择待查看注册企业");
		return;
	}
	showCompanyTemp(companyTempId,true);
}

function editCompanyTemp(){
	var companyTempId = getSelectedEntityId("companyTempsTable");
	var companyTempStatus = getSelectedEntity("companyTempsTable").attr("entityStatus");
	if(!companyTempId){
		myAlert("请选择待编辑注册企业");
		return;
	}
	if(!!companyTempStatus && "true"==companyTempStatus){
		myAlert("该注册企业已通过审核");
		return;
	}
	showCompanyTemp(companyTempId);
}

function deleteCompanyTemp(){
	var companyTempIds = getCheckedEntityIds("companyTempsTable");
	if(!companyTempIds){
		myAlert("请勾选待删除注册企业");
		return;
	}
	myConfirm(globalDeleteTip,function(){
		var url = CONTEXT_PATH + "/companyTemp/deleteCompanyTemp";
		var params = {companyTempIds:companyTempIds};
		jQuery.post(url, params, function(data) {
			if(data.success){
				refreshPage("companyTempsForm","companyTempsDiv");
			}else{
				myAlert(data.message);
			}
		});
	});
}

function exportCompanyTemps(){
	var url = CONTEXT_PATH + "/companyTemp/exportCompanyTemps?" + $("#companyTempsForm").serialize();
	window.location.href = url;
}