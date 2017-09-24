$(function(){
	$("iframe").height($("body").height()-globalTabHeight);
});

function saveFeedback(){
	if(!validateForm("feedbackForm")){
		return;
	}
	var url = CONTEXT_PATH + "/feedback/saveFeedback";
	var params = $("#feedbackForm").serialize();
	jQuery.post(url, params, function(data) {
		if(data.success){
			var opener = window.top.getOpener();
			opener.refreshPage("feedbacksForm","feedbacksDiv");
			if($("#feedbackId").val()){
				myAlert(globalSaveSuccessTip);
				return;
			}
			alert(globalSaveSuccessTip);
			opener.showFeedback(data.message);
		}else{
			myAlert(data.message);
		}
	});
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
function selectUser(){
	var dom = $("<div fkFieldCode='user'/>");
	var url = CONTEXT_PATH + "/user/selectUser";
	dom.load(url,null,function(){
		dialog({
			id:'user',
			title : "选择反馈人员",
			content : dom
		}).showModal();
	});
}
