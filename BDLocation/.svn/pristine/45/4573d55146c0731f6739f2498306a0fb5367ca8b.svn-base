//打开页面即执行查询
$(function(){
	refreshPage("corsQueryForm","corsQueryDiv");
});
function selectCompany(){
	_fkFieldCode = "company";
	var dom = $("<div/>");
	var url = CONTEXT_PATH + "/company/selectCompany";
	dom.load(url,null,function(){
		dialog({
			title : "选择所属企业",
			content : dom
		}).showModal();
	});
}
function selectCorsAccountUse(sender){
	var corsAccountId = getCheckedEntityIds("corsAllCountTable");
	if(!corsAccountId){
		myAlert("请勾选账号");
		return;
	}
	var dom = $("<div/>");
	var url = CONTEXT_PATH + "/corsAccount/showCorsAccountUse";
	var params = {corsAccountIds:corsAccountId};
	dom.load(url,params,function(){
		dialog({
			title : "用途区域",
			content : dom,
			width:600
		}).showModal();
	});	
}

function saveCorsAccoutUse(){
	var url=CONTEXT_PATH +"/corsAccount/saveCorsAccountUse";
	var corsAccountId=$('#corsAccountIds').val();
	var corsUse=$('#taskStatus').val();
	var params={'corsAccountIds':corsAccountId,'corsUse':corsUse};
	commonPost(url,params,function(data){
		if(data.success){
		    $(".ui-dialog-close").trigger('click');  
			refreshPage('corsQueryForm','corsQueryDiv',$('#corsQueryForm_pageIndex').val());
		}
	});
}
