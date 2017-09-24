$(function(){
	$("iframe").height($("body").height()-globalTabHeight);
	$("#attachments").myFileUpload({
		isQuery : $.QueryString("isQuery"),
		entityName : "CorsApplyMaterial",
		fieldName : "attachments",
		entityId : $("#applyMaterialId").val()
	});
});

function saveMaterialByPage(){
	debugger;
	var url = CONTEXT_PATH + "/corsApplyMaterial/saveMaterials";;
	var applyMaterialId = $("#applyMaterialId").val();
	if(applyMaterialId){
		url = CONTEXT_PATH + "/corsApplyMaterial/updateMaterials";
	}
	var params = $("#materialsForm").serialize();
	jQuery.post(url, params, function(data) {
		if(data.success){
			var opener = window.top.getOpener();
			opener.refreshPage("materialsForm","materialsDiv");
			myAlert("保存成功！");
			if(!$("#applyMaterialId").val())
				$("#applyMaterialId").val(data.message);
			setTimeout(function(){
				opener.showMaterial($("#orderBussinkey").val());
			},2000);
		}else{
			myAlert("保存成功！");
		}
	});
}