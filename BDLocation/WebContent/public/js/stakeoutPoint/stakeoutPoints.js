//打开页面即执行查询
$(function(){
	refreshPage("stakeoutPointsForm","stakeoutPointsDiv");
});

function showStakeoutPoint(stakeoutPointId,isQuery){
	var url = CONTEXT_PATH + "/stakeoutPoint/showStakeoutPoint";
	var title = "新增放样点";
	if(stakeoutPointId){
		url += "?stakeoutPointId=" + stakeoutPointId;
		title = "编辑放样点";
	}
	if(isQuery){
		url += "&isQuery=true";
		title = "查看放样点";
	}
	if($.QueryString()){
		if(url.indexOf("?")>0){
			url += "&";
		}else{
			url += "?";
		}
		url += $.QueryString()._queryString_;
	}
	openTab("stakeoutPoint",title,url);
}

function viewStakeoutPoint(){
	var stakeoutPointId = getSelectedEntityId("stakeoutPointsTable");
	if(!stakeoutPointId){
		myAlert("请选择待查看放样点");
		return;
	}
	showStakeoutPoint(stakeoutPointId,true);
}

function editStakeoutPoint(){
	var stakeoutPointId = getSelectedEntityId("stakeoutPointsTable");
	if(!stakeoutPointId){
		myAlert("请选择待编辑放样点");
		return;
	}
	showStakeoutPoint(stakeoutPointId);
}

function deleteStakeoutPoint(){
	var stakeoutPointIds = getCheckedEntityIds("stakeoutPointsTable");
	if(!stakeoutPointIds){
		myAlert("请勾选待删除放样点");
		return;
	}
	myConfirm(globalDeleteTip,function(){
		var url = CONTEXT_PATH + "/stakeoutPoint/deleteStakeoutPoint";
		var params = {stakeoutPointIds:stakeoutPointIds};
		jQuery.post(url, params, function(data) {
			if(data.success){
				refreshPage("stakeoutPointsForm","stakeoutPointsDiv");
			}else{
				myAlert(data.message);
			}
		});
	});
}

function exportStakeoutPoints(){
	var url = CONTEXT_PATH + "/stakeoutPoint/exportStakeoutPoints?" + $("#stakeoutPointsForm").serialize();
	window.location.href = url;
}