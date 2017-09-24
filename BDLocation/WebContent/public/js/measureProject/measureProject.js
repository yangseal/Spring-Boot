$(function(){
	$("iframe").height($("body").height()-globalTabHeight);
});

function saveMeasureProject(){
	if(!validateForm("measureProjectForm")){
		return;
	}
	var url = CONTEXT_PATH + "/measureProject/saveMeasureProject";
	var params = $("#measureProjectForm").serialize();
	jQuery.post(url, params, function(data) {
		if(data.success){
			var opener = window.top.getOpener();
			opener.refreshPage("measureProjectsForm","measureProjectsDiv");
			if($("#measureProjectId").val()){
				myAlert(globalSaveSuccessTip);
				return;
			}
			alert(globalSaveSuccessTip);
			opener.showMeasureProject(data.message);
		}else{
			myAlert(data.message);
		}
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
function selectCreateUser(){
	var dom = $("<div fkFieldCode='createUser'/>");
	var url = CONTEXT_PATH + "/user/selectUser";
	dom.load(url,null,function(){
		dialog({
			id:'createUser',
			title : "选择创建用户",
			content : dom
		}).showModal();
	});
}

function exportMeasureProject(){
	var measureProjectId = document.getElementById("measureProjectId").value;
	var url = CONTEXT_PATH + "/measureProject/exportMeasureProject?" + "measureProjectId=" + measureProjectId;
	window.location.href = url;
}
