$(function(){
	refreshPage("corsActivesForm","corsActivesDiv");
});

function lookAccount(sender){
	var entityId = $(sender).closest("tr").attr('entityId'),
		url = CONTEXT_PATH + "/corsActive/showAccounts",
		params = {corsActiveId:entityId};
		dom = $("<div/>");
	dom.load(url,params,function(){
		dialog({
			title : "账号信息",
			content : dom,
			width:1200
		}).showModal();
	});
}

function doActive(sender){
	
	var checkbox = $("input[type='checkbox']:checked",$("#corsActivesTable"));
	if(checkbox && checkbox.length != 1 ) {
		myAlert("请选择一条数据");
		return;
	}
	
	var entityId = $(checkbox[0]).closest('tr').attr('entityId'),
	sender = 'ACTIVE';
	url = CONTEXT_PATH + "/corsActive/showAccounts?doAction="+sender+"&activeId="+entityId+"&corsActiveType="+sender,
	params = {corsActiveId:entityId};
	dom = $("<div/>");
	dom.load(url,params,function(){
		dialog({
			title : "账号信息",
			content : dom,
			width:1200
		}).showModal();
	});
}


function activeOrRepay(){
	var checkbox = $("input[name='data']:checked",$("#corsAccountsTable"));
	if(checkbox && checkbox.length < 1 ) {
		myAlert("请选择一条数据");
		return;
	}
	myConfirm('您确定进行激活操作吗?',function(){
		var corsAccountIds = [],
		corsAccountTr = [];
		for(var i=0,l=checkbox.length; i<l; i++){
			corsAccountTr.push($(checkbox[i]).closest('tr'));
			corsAccountIds.push($(checkbox[i]).closest('tr').attr("entityId"));
		}
		var url = CONTEXT_PATH + "/corsActive/activeAccounts";
		var params = {
			"corsAccountIds": corsAccountIds.join(","),
			"corsActiveId":$("#corsActiveId").val(),
			"corsActiveType":$("#corsActiveType").val()
		};
		
		$.post(url,params,function(data){
			myAlert(data.message);
			for(var j=0,jl=corsAccountTr.length; j<jl; j++){
				$("#corsActiveState",corsAccountTr[j]).html("已完成");
				refreshPage("corsActivesForm","corsActivesDiv");
			}
		});
	});
}