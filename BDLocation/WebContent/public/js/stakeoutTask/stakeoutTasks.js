//打开页面即执行查询
$(function(){
	refreshPage("stakeoutTasksForm","stakeoutTasksDiv");
});

function showStakeoutTask(stakeoutTaskId,isQuery){
	var url = CONTEXT_PATH + "/stakeoutTask/showStakeoutTask";
	var title = "新增点放样任务";
	if(stakeoutTaskId){
		url += "?stakeoutTaskId=" + stakeoutTaskId;
		title = "编辑点放样任务";
	}
	if(isQuery){
		url += "&isQuery=true";
		title = "查看点放样任务";
	}
	if($.QueryString()){
		if(url.indexOf("?")>0){
			url += "&";
		}else{
			url += "?";
		}
		url += $.QueryString()._queryString_;
	}
	openTab("stakeoutTask",title,url);
}

function viewStakeoutTask(){
	var stakeoutTaskId = getSelectedEntityId("stakeoutTasksTable");
	if(!stakeoutTaskId){
		myAlert("请选择待查看点放样任务");
		return;
	}
	showStakeoutTask(stakeoutTaskId,true);
}

function editStakeoutTask(){
	var stakeoutTaskId = getSelectedEntityId("stakeoutTasksTable");
	if(!stakeoutTaskId){
		myAlert("请选择待编辑点放样任务");
		return;
	}
	showStakeoutTask(stakeoutTaskId);
}

function deleteStakeoutTask(){
	var stakeoutTaskIds = getCheckedEntityIds("stakeoutTasksTable");
	if(!stakeoutTaskIds){
		myAlert("请勾选待删除点放样任务");
		return;
	}
	myConfirm(globalDeleteTip,function(){
		var url = CONTEXT_PATH + "/stakeoutTask/deleteStakeoutTask";
		var params = {stakeoutTaskIds:stakeoutTaskIds};
		jQuery.post(url, params, function(data) {
			if(data.success){
				refreshPage("stakeoutTasksForm","stakeoutTasksDiv");
			}else{
				myAlert(data.message);
			}
		});
	});
}

function updateStakeoutTaskState(){
	var stakeoutTaskIds = getCheckedEntityIds("stakeoutTasksTable");
	if(!stakeoutTaskIds){
		myAlert("请勾选要下发的点放样任务");
		return;
	}
	myConfirm("确定要下发任务？",function(){
		var url = CONTEXT_PATH + "/stakeoutTask/updateStakeoutTaskState";
		var params = {stakeoutTaskIds:stakeoutTaskIds};
		jQuery.post(url, params, function(data) {
			if(data.success){
				refreshPage("stakeoutTasksForm","stakeoutTasksDiv");
			}else{
				myAlert(data.message);
			}
		});
	});
}



function exportStakeoutTasks(){
	var url = CONTEXT_PATH + "/stakeoutTask/exportStakeoutTasks?" + $("#stakeoutTasksForm").serialize();
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