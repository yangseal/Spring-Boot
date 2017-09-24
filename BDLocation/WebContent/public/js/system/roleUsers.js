//打开页面即执行查询
$(function(){
	var roleId = $.QueryString("roleId");
	if(roleId){
		$("#roleId").val(roleId);
	}
	
	refreshPage("roleUsersForm","roleUsersDiv");
});

function showUser(userId,isQuery,companyName,companyId){
	var url = CONTEXT_PATH + "/user/showUser";
	var title = "新增用户";
	if(userId){
		url += "?userId=" + userId;
		title = "编辑用户";
	}
	if(isQuery){
		url += "&isQuery=true";
		title = "查看用户";
	}
	if(companyId && companyName && !userId){
		url += "?companyId=" + companyId;
		url += "&companyName=" + encodeURIComponent(companyName);
	}
	if($.QueryString()){
		if(url.indexOf("?")>0){
			url += "&";
		}else{
			url += "?";
		}
		url += $.QueryString()._queryString_;
	}
	openTab("user",title,url);
}

function viewUser(){
	var userId = getSelectedEntityId("usersTable");
	if(!userId){
		myAlert("请选择待查看用户");
		return;
	}
	showUser(userId,true);
}

function selectCompany(){
	var dom = $("<div fkFieldCode='company'/>");
	var url = CONTEXT_PATH + "/company/selectCompany";
	dom.load(url,null,function(){
		dialog({
			id:'company',
			title : "选择企业",
			content : dom
		}).showModal();
	});
}

