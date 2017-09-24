$(function(){
	$("#attachments").myFileUpload({
		isQuery : $.QueryString("isQuery"),
		entityName : "pointType",
		fieldName : "attachments",
		entityId : $("#pointTypeId").val()
	});
	$("iframe").height($("body").height()-50);
});

function savePointType(){
	if(!validateForm("pointTypeForm")){
		return;
	}
	var url = CONTEXT_PATH + "/pointType/savePointType";
	var params = $("#pointTypeForm").serialize();
	jQuery.post(url, params, function(data) {
		if(data.success){
			var opener = window.top.getOpener();
			opener.refreshPage("pointTypesForm","pointTypesDiv");
			if($("#pointTypeId").val()){
				myAlert(globalSaveSuccessTip);
				return;
			}
			alert(globalSaveSuccessTip);
			opener.showPointType(data.message);
		}else{
			myAlert(data.message);
		}
	});
}

function showDynamicFields() {
	var pointTypeId = $("#pointTypeId").val();
	var url = CONTEXT_PATH + "/pointType/showDynamicFields?isQuery=true&pointTypeId="+pointTypeId;
	var title = "动态字段";
	openTab("pointTypesDiv",title,url);
}

function editDynamicFields() {
	var pointTypeId = $("#pointTypeId").val();
	var url = CONTEXT_PATH + "/pointType/showDynamicFields?pointTypeId="+pointTypeId;
	var title = "动态字段";
	openTab("pointTypesDiv",title,url);
}
