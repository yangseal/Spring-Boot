//打开页面即执行查询
$(function(){
	refreshPage("oamProjectsForm","oamProjectsDiv");
});

function showOamProject(oamProjectId,isQuery){
	var url = CONTEXT_PATH + "/oamProject/showOamProject";
	var title = "新增项目";
	if(oamProjectId){
		url += "?oamProjectId=" + oamProjectId;
		title = "编辑项目";
	}
	if(isQuery){
		url += "&isQuery=true";
		title = "查看项目";
	}
	if($.QueryString()){
		if(url.indexOf("?")>0){
			url += "&";
		}else{
			url += "?";
		}
		url += $.QueryString()._queryString_;
	}
	openTab("oamProject",title,url);
}

function viewOamProject(){
	var oamProjectId = getSelectedEntityId("oamProjectsTable");
	if(!oamProjectId){
		myAlert("请选择待查看项目");
		return;
	}
	showOamProject(oamProjectId,true);
}

function editOamProject(){
	var oamProjectId = getSelectedEntityId("oamProjectsTable");
	if(!oamProjectId){
		myAlert("请选择待编辑项目");
		return;
	}
	showOamProject(oamProjectId);
}

function deleteOamProject(){
	var oamProjectIds = getCheckedEntityIds("oamProjectsTable");
	if(!oamProjectIds){
		myAlert("请勾选待删除项目");
		return;
	}
	myConfirm(globalDeleteTip,function(){
		var url = CONTEXT_PATH + "/oamProject/deleteOamProject";
		var params = {oamProjectIds:oamProjectIds};
		jQuery.post(url, params, function(data) {
			if(data.success){
				refreshPage("oamProjectsForm","oamProjectsDiv");
			}else{
				myAlert(data.message);
			}
		});
	});
}

function exportOamProjects(){
	var url = CONTEXT_PATH + "/oamProject/exportOamProjects?" + $("#oamProjectsForm").serialize();
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
