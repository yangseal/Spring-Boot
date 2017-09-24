//打开页面即执行查询
$(function(){
	refreshPage("feedbacksForm","feedbacksDiv");
});

function showFeedback(feedbackId,isQuery){
	var url = CONTEXT_PATH + "/feedback/showFeedback";
	var title = "新增信息反馈";
	if(feedbackId){
		url += "?feedbackId=" + feedbackId;
		title = "编辑信息反馈";
	}
	if(isQuery){
		url += "&isQuery=true";
		title = "查看信息反馈";
	}
	if($.QueryString()){
		if(url.indexOf("?")>0){
			url += "&";
		}else{
			url += "?";
		}
		url += $.QueryString()._queryString_;
	}
	openTab("feedback",title,url);
}

function viewFeedback(){
	var feedbackId = getSelectedEntityId("feedbacksTable");
	if(!feedbackId){
		myAlert("请选择待查看信息反馈");
		return;
	}
	showFeedback(feedbackId,true);
}

function editFeedback(){
	var feedbackId = getSelectedEntityId("feedbacksTable");
	if(!feedbackId){
		myAlert("请选择待编辑信息反馈");
		return;
	}
	showFeedback(feedbackId);
}

function deleteFeedback(){
	var feedbackIds = getCheckedEntityIds("feedbacksTable");
	if(!feedbackIds){
		myAlert("请勾选待删除信息反馈");
		return;
	}
	myConfirm(globalDeleteTip,function(){
		var url = CONTEXT_PATH + "/feedback/deleteFeedback";
		var params = {feedbackIds:feedbackIds};
		jQuery.post(url, params, function(data) {
			if(data.success){
				refreshPage("feedbacksForm","feedbacksDiv");
			}else{
				myAlert(data.message);
			}
		});
	});
}

function exportFeedbacks(){
	var url = CONTEXT_PATH + "/feedback/exportFeedbacks?" + $("#feedbacksForm").serialize();
	window.location.href = url;
}

function selectCompany(){
	var dom = $("<div fkFieldCode='company'/>");
	var url = CONTEXT_PATH + "/company/selectCompany";
	dom.load(url,null,function(){
		dialog({
			id:'company',
			title : "选择反馈企业",
			content : dom
		}).showModal();
	});
}
