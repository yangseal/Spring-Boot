//打开页面即执行查询
$(function(){
	refreshPage("corsApplysForm","corsApplysDiv");
});

function showCorsApply(corsApplyId,isQuery){
	var url = CONTEXT_PATH + "/corsApply/showCorsApply";
	var title = "新增CORS账号申请";
	if(corsApplyId){
		url += "?corsApplyId=" + corsApplyId;
		title = "编辑CORS账号申请";
	}
	if(isQuery){
		url += "&isQuery=true";
		title = "查看CORS账号申请";
	}
	if($.QueryString()){
		if(url.indexOf("?")>0){
			url += "&";
		}else{
			url += "?";
		}
		url += $.QueryString()._queryString_;
	}
	openTab("corsApply",title,url);
}

function viewCorsApply(){
	var corsApplyId = getSelectedEntityId("corsApplysTable");
	if(!corsApplyId){
		myAlert("请选择待查看申请记录");
		return;
	}
	showCorsApply(corsApplyId,true);
}

function editCorsApply(){
	var corsApplyId = getSelectedEntityId("corsApplysTable");
	if(!corsApplyId){
		myAlert("请选择待编辑申请记录");
		return;
	}
	showCorsApply(corsApplyId);
}

/**
 *申请用户编辑账号申请记录 
 */
function editApply(){
	var corsApplyId = getSelectedEntity("corsApplysTable").attr("entityId");
	if(!corsApplyId){
		myAlert("请选择待编辑申请记录");
		return;
	}
	var applyStatus = getSelectedEntity("corsApplysTable").attr("entityStatus");
	if(applyStatus && ("1" == applyStatus | "2" == applyStatus | "3" == applyStatus)){
		myAlert("该申请记录已通过无需编辑");
		return;
	}
	showCorsApply(corsApplyId);
}

//function deleteCorsApply(){
//	var corsApplyIds = getCheckedEntityIds("corsApplysTable");
//	if(!corsApplyIds){
//		myAlert("请勾选待删除申请记录");
//		return;
//	}
//	myConfirm(globalDeleteTip,function(){
//		var url = CONTEXT_PATH + "/corsApply/deleteCorsApply";
//		var params = {corsApplyIds:corsApplyIds};
//		jQuery.post(url, params, function(data) {
//			if(data.success){
//				refreshPage("corsApplysForm","corsApplysDiv");
//			}else{
//				myAlert(data.message);
//			}
//		});
//	});
//}

//function exportCorsApplys(){
//	var url = CONTEXT_PATH + "/corsApply/exportCorsApplys?" + $("#corsApplysForm").serialize();
//	window.location.href = url;
//}

//function exportCorsApply(){
//	var applyId = getSelectedEntityId("corsApplysTable");
//	if(!applyId){
//		myAlert("请选择申请记录");
//		return;
//	}
//	var applyStatus = getSelectedEntity("corsApplysTable").attr("entityStatus");
//	if(applyStatus != "2") {
//		myAlert("该申请未审批,不能打印");
//		return;
//	}
//	var url = CONTEXT_PATH + "/corsApply/exportCorsApply?applyId=" + applyId;
//	window.location.href = url;
//}

function approval(){
//	var applyId = getSelectedEntityId("corsApplysTable");
//	if(!applyId){
//		myAlert("请选择申请记录");
//		return;
//	}
//	var applyStatus = getSelectedEntity("corsApplysTable").attr("entityStatus");
//	if(applyStatus && "2" == applyStatus){
//		myAlert("该申请记录已通过无需审批");
//		return;
//	}
//	shwoMyFeedback(applyId, true);
	jQuery.post(CONTEXT_PATH +"/corsApprove/passAccount",{"corsApproveId":"4028811d5852434c01585258f4720005"},function(data) {
		if(data.success){
			refreshPage("corsApplysForm","corsApplysDiv");
		}else{
			myAlert(data.message);
		}
	});
}

function reject() {
	var applyId = getSelectedEntityId("corsApplysTable");
	if(!applyId){
		myAlert("请选择申请记录");
		return;
	}
	var applyStatus = getSelectedEntity("corsApplysTable").attr("entityStatus");
	if(!!applyStatus && "2" == applyStatus){
		myAlert("该申请记录已通过无需审批");
		return;
	}
	shwoMyFeedback(applyId, false);
}

function shwoMyFeedback(applyId, action){
	var dom = $("<div fkFieldCode='myApplyFeedback'/>");
	var url = CONTEXT_PATH + "/corsApply/showApplySuggestion?applyId="+applyId+"&action="+action;
	dom.load(url,null,function(){
		dialog({
			id:'myApplyFeedback',
			title : "请输入审批信息",
			content : dom
		}).showModal();
	});
}

function selectCompany(){
	var dom = $("<div fkFieldCode='company'/>");
	var url = CONTEXT_PATH + "/company/selectCompany";
	dom.load(url,null,function(){
		dialog({
			id:'company',
			title : "选择申请企业",
			content : dom
		}).showModal();
	});
}

//提交申请
function submitApply(){
	
	var url = CONTEXT_PATH + "/corsApply/submitApply";
	var corsApplyId = getSelectedEntity("corsApplysTable").attr("entityId");
	if(!corsApplyId){
		myAlert("请选择需提交的申请记录");
		return;
	}
	var applyStatus = getSelectedEntity("corsApplysTable").attr("entityStatus");
	if(applyStatus && ("1" == applyStatus | "2" == applyStatus | "3" == applyStatus)){
		myAlert("该申请记录已通过或正在审批中，无需提交");
		return;
	}
	var params = {corsApplyId:corsApplyId};
	jQuery.post(url,params,function(data) {
		if(data.success){
			refreshPage("corsApplysForm","corsApplysDiv");
		}else{
			myAlert(data.message);
		}
	});
}
