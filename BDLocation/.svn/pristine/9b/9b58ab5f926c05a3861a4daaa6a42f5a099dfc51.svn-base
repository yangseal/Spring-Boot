//打开页面即执行查询
$(function(){
	refreshPage("accountViewsForm","accountViewsDiv");
});
function selectOamArea(){
	
	var dom = $("<div fkFieldCode='oamArea'/>");
	var url = CONTEXT_PATH + "/oamArea/selectOamArea";
	commonLoad(dom,url,null,function(self){
		dialog({
			id:'oamArea',
			title : "选择所属省市",
			content : dom
		}).showModal();
	});
	
//	var dom = $("<div fkFieldCode='oamArea'/>");
//	var url = CONTEXT_PATH + "/oamArea/selectOamArea";
//	dom.load(url,null,function(){
//		dialog({
//			id:'oamArea',
//			title : "选择所属省市",
//			content : dom
//		}).showModal();
//	});
}

/*function addMenu(sender){
	var dom = $("<div/>");
	var url = CONTEXT_PATH + "/menu/showMenu";
	var params = {};
	if(sender){
		window.curRow = $(sender).closest("tr");
		params.parentId = curRow.attr("id");
	}else{
		window.curRow = null;
	}
	dom.load(url,params,function(){
		dialog({
			title : "新增菜单",
			content : dom,
			width:600
		}).showModal();
	});
	
	
	function editMenu(sender){
	var dom = $("<div/>");
	var url = CONTEXT_PATH + "/menu/showMenu";
	window.curRow = $(sender).closest("tr");
	var params = {menuId:curRow.attr("id")};
	dom.load(url,params,function(){
		dialog({
			title : "编辑菜单",
			content : dom,
			width:800
		}).showModal();
	});
}
}*/


/**
 * 绑定应用区域
 */
function bindRegion(sender) {
	var dom = $("<div/>");
	var url = CONTEXT_PATH + "/accountView/showRegion";
	var corsId = $(sender).parent().parent().find('input').first().val();
	var params = {corsAccountId:corsId};
	dom.load(url,params,function(){
		dialog({
			title : "应用区域",
			content : dom,
			width:600
		}).showModal();
	});
}

/**
 * 绑定使用设备
 */
function bindDevice(sender) {
	var dom = $("<div/>");
	var url = CONTEXT_PATH + "/accountView/showDevice";
	var corsId = $(sender).parent().parent().find('input').first().val();
	var params = {corsAccountId:corsId};
	dom.load(url,params,function(){
		dialog({
			title : "应用区域",
			content : dom,
			width:600
		}).showModal();
	});
}

/**
 * 激活当前账号（提交激活申请）
 */
function onActive(sender) {
	var url = CONTEXT_PATH + "/accountView/insertActiveApply";
	var corsId = $(sender).parent().parent().find('input').first().val();
	var params = {corsAccountId:corsId};
	commonPost(url,params,function(data){
		myAlert(data.message);
		refreshPage("accountViewsForm","accountViewsDiv",$("#showAccountsForm_pageIndex").val());
	});
	
	
//	var url = CONTEXT_PATH + "/accountView/insertActiveApply";
//	var corsId = $(sender).parent().parent().find('input').first().val();
//	var params = {corsAccountId:corsId};
//	jQuery.post(url,params,function(data){
//		myAlert(data.message);
//		refreshPage("accountViewsForm","accountViewsDiv",$("#showAccountsForm_pageIndex").val());
//	});
}

/**
 * 续费当前账号（提交续费申请）
 */
//function onRepay(sender) {
//	var dom = $("<div/>");
//	var url = CONTEXT_PATH + "/accountView/showRepay";
//	var corsId = $(sender).parent().parent().find('input').first().val();
//	alert("-------corsId---------: " + corsId);
//	var params = {corsAccountId:corsId};
//	radioChange("accountPeriod");
//	dom.load(url,params,function(){
//		dialog({
//			title : "续费信息",
//			content : dom,
//			width:600
//		}).showModal();
//	});
//}

/**
 * 验证是否可进行
 */
function isOperate(){
	
}