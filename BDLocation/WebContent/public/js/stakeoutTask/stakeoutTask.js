$(function(){
	$("iframe").height($("body").height()-50);
});

function saveStakeoutTask(){
	if(!validateForm("stakeoutTaskForm")){
		return;
	}
	var url = CONTEXT_PATH + "/stakeoutTask/saveStakeoutTask";
	var params = $("#stakeoutTaskForm").serialize();
	jQuery.post(url, params, function(data) {
		if(data.success){
			var opener = window.top.getOpener();
			opener.refreshPage("stakeoutTasksForm","stakeoutTasksDiv");
			if($("#stakeoutTaskId").val()){
				myAlert(globalSaveSuccessTip);
				return;
			}
			alert(globalSaveSuccessTip);
			opener.showStakeoutTask(data.message);
		}else{
			myAlert(data.message);
		}
	});
}

function selectCreateUser(){
	var dom = $("<div fkFieldCode='createUser'/>");
	var url = CONTEXT_PATH + "/user/selectUser";
	dom.load(url,null,function(){
		dialog({
			id:'createUser',
			title : "选择创建人",
			content : dom
		}).showModal();
	});
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

function selectConversionArea(){
	var dom = $("<div fkFieldCode='conversionParam'/>");
	var url = CONTEXT_PATH + "/conversionParam/selectConversionParam";
	dom.load(url,null,function(){
		dialog({
			id:'conversionParam',
			title : "选择所属企业",
			content : dom
		}).showModal();
	});
}
