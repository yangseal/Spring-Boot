
function detailAccount(bussinessId){
	var dom = $("<div/>");
	var url = CONTEXT_PATH +"/corsInit/queryAccounts";
	var params = {"bussinessId":bussinessId};
	dom.load(url,params,function(){
		dialog({
			title : "账号详情",
			content : dom,
			width:800
		}).showModal();
	});		
}		
function doneInit(bussinessId){
	myConfirm("你确定生成吗？",function(){
		var url = CONTEXT_PATH + "/corsInit/doneInit";
		var accountPrefix = $("#accountPrefix").val();
		var remark = $("#remark").val();
		var params = {"bussinessId":bussinessId,"accountPrefix":accountPrefix,"remark":remark};
		$.post(url,params,function(){
			location.href = CONTEXT_PATH + "/corsInit/showCorsInits";
		});
	});
}

function clearMsg(){

	$("#accountPrefix").val("");
	$("#remark").val("");
	
	
}