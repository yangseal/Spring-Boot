$(function(){
	$("iframe").height($("body").height()-globalTabHeight);
//	$("#attachments").myFileUpload({
//		isQuery : $.QueryString("isQuery"),
//		entityName : "corsApply",
//		fieldName : "attachments",
//		entityId : $("#corsApplyId").val()
//	});
});
function detailAccount(sender){
	
	var dom = $("<div/>");
	var url = CONTEXT_PATH + "/corsApprove/detailAccount";
	url+="?bussinessId=";
	var params = {};
	if(sender){
		window.curRow = $(sender).closest("tr");
		params.parentId = curRow.attr("id");
	}else{
		window.curRow = null;
	}
	dom.load(url,params,function(){
		dialog({
			title : "账号详情",
			content : dom,
			width:800
		}).showModal();
	});
}