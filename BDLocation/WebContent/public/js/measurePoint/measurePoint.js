$(function(){
	$("#attachments").myFileUpload({
		isQuery : $.QueryString("isQuery"),
		entityName : "measurePoint",
		fieldName : "attachments",
		entityId : $("#measurePointId").val()
	});
	$("iframe").height($("body").height()-globalTabHeight);
});

function saveMeasurePoint(){
	if(!validateForm("measurePointForm")){
		return;
	}
	var url = CONTEXT_PATH + "/measurePoint/saveMeasurePoint";
	var params = $("#measurePointForm").serialize();
	jQuery.post(url, params, function(data) {
		if(data.success){
			var opener = window.top.getOpener();
			opener.refreshPage("measurePointsForm","measurePointsDiv");
			if($("#measurePointId").val()){
				myAlert(globalSaveSuccessTip);
				return;
			}
			alert(globalSaveSuccessTip);
			opener.showMeasurePoint(data.message);
		}else{
			myAlert(data.message);
		}
	});
}

function selectAffiliationPointType(){
	var dom = $("<div fkFieldCode='affiliationPointType'/>");
	var url = CONTEXT_PATH + "/pointType/selectPointType";
	dom.load(url,null,function(){
		dialog({
			id:'affiliationPointType',
			title : "选择所属点类型",
			content : dom
		}).showModal();
	});
}
function selectAffiliationProject(){
	var dom = $("<div fkFieldCode='affiliationProject'/>");
	var url = CONTEXT_PATH + "/measureProject/selectMeasureProject";
	dom.load(url,null,function(){
		dialog({
			id:'affiliationProject',
			title : "选择所属工程",
			content : dom
		}).showModal();
	});
}
