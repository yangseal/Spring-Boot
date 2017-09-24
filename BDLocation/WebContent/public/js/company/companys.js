//打开页面即执行查询
$(function(){
	refreshPage("companysForm","companysDiv");
});

function showCompany(companyId,isQuery){
	var url = CONTEXT_PATH + "/company/showCompany";
	var title = "新增企业";
	if(companyId){
		url += "?companyId=" + companyId;
		title = "编辑企业";
	}
	if(isQuery){
		url += "&isQuery=true";
		title = "查看企业";
	}
	if($.QueryString()){
		if(url.indexOf("?")>0){
			url += "&";
		}else{
			url += "?";
		}
		url += $.QueryString()._queryString_;
	}
	openTab("company",title,url);
}

function viewCompany(){
	var companyId = getSelectedEntityId("companysTable");
	if(!companyId){
		myAlert("请选择待查看企业");
		return;
	}
	showCompany(companyId,true);
}

function editCompany(){
	var companyId = getSelectedEntityId("companysTable");
	if(!companyId){
		myAlert("请选择待编辑企业");
		return;
	}
	showCompany(companyId);
}

function deleteCompany(){
	var companyIds = getCheckedEntityIds("companysTable");
	if(!companyIds){
		myAlert("请勾选待删除企业");
		return;
	}
	myConfirm(globalDeleteTip,function(){
		var url = CONTEXT_PATH + "/company/deleteCompany";
		var params = {companyIds:companyIds};
		jQuery.post(url, params, function(data) {
			if(data.success){
				refreshPage("companysForm","companysDiv");
			}else{
				myAlert(data.message);
			}
		});
	});
}

function exportCompanys(){
	var url = CONTEXT_PATH + "/company/exportCompanys?" + $("#companysForm").serialize();
	window.location.href = url;
}