//打开页面即执行查询
$(function(){
	refreshPage("measureProjectsForm","measureProjectsDiv");
});

function showMeasureProject(measureProjectId,isQuery){
	var url = CONTEXT_PATH + "/measureProject/showMeasureProject";
	var title = "新增测量工程";
	if(measureProjectId){
		url += "?measureProjectId=" + measureProjectId;
		title = "编辑测量工程";
	}
	if(isQuery){
		url += "&isQuery=true";
		title = "查看测量工程";
	}
	if($.QueryString()){
		if(url.indexOf("?")>0){
			url += "&";
		}else{
			url += "?";
		}
		url += $.QueryString()._queryString_;
	}
	openTab("measureProject",title,url);
}

function viewMeasureProject(){
	var measureProjectId = getSelectedEntityId("measureProjectsTable");
	if(!measureProjectId){
		myAlert("请选择待查看测量工程");
		return;
	}
	showMeasureProject(measureProjectId,true);
}

function editMeasureProject(){
	var measureProjectId = getSelectedEntityId("measureProjectsTable");
	if(!measureProjectId){
		myAlert("请选择待编辑测量工程");
		return;
	}
	showMeasureProject(measureProjectId);
}

function deleteMeasureProject(){
	var measureProjectIds = getCheckedEntityIds("measureProjectsTable");
	if(!measureProjectIds){
		myAlert("请勾选待删除测量工程");
		return;
	}
	myConfirm(globalDeleteTip,function(){
		var url = CONTEXT_PATH + "/measureProject/deleteMeasureProject";
		var params = {measureProjectIds:measureProjectIds};
		jQuery.post(url, params, function(data) {
			if(data.success){
				refreshPage("measureProjectsForm","measureProjectsDiv");
			}else{
				myAlert(data.message);
			}
		});
	});
}
function saveloft(){
	var measureProjectIds = getCheckedEntityIds("measureProjectsTable");
	if(!measureProjectIds){
		myAlert("请勾选待放样测量工程");
		return;
	}
	myConfirm("确实要放样数据吗？",function(){
		var url = CONTEXT_PATH + "/measureProject/saveloft";
		var params = {measureProjectIds:measureProjectIds};
		jQuery.post(url, params, function(data) {
			if(data.success){
				refreshPage("measureProjectsForm","measureProjectsDiv");
			}else{
				myAlert(data.message);
			}
		});
	});
}

function exportMeasureProjects(){
	var url = CONTEXT_PATH + "/measureProject/exportMeasureProjects?" + $("#measureProjectsForm").serialize();
	window.location.href = url;
}

function selectAffiliationCompany(){
	var dom = $("<div fkFieldCode='affiliationCompany'/>");
	var url = CONTEXT_PATH + "/company/selectCompany";
	dom.load(url,null,function(){
		dialog({
			id:'affiliationCompany',
			title : "选择所属企业",
			content : dom
		}).showModal();
	});
}
//工程项目信息导出
function editProjectInfo(){
	var measureProjectId ="";
	$("#measureProjectsTable input[type='checkbox']:checked").each(function(){
		measureProjectId += $(this).parent().parent().attr("entityid")+",";
	});
	measureProjectId = measureProjectId.substr(0,measureProjectId.length-1);
	var url = CONTEXT_PATH + "/measureProject/editProjectInfo?" + "measureProjectId=" + measureProjectId;
	window.location.href = url;
}