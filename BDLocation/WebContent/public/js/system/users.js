//打开页面即执行查询
$(function(){
	refreshPage("usersForm","usersDiv");
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

function editUser(){
	var userId = getSelectedEntityId("usersTable");
	if(!userId){
		myAlert("请选择待编辑用户");
		return;
	}
	showUser(userId);
}

//added by lanj 2016-06-27 增加密码重置功能
function updatePassword(){
	var userIds = getCheckedEntityIds("usersTable");
	if(!userIds){
		myAlert("请选择要进行密码重置的用户!");
		return;
	}
	myConfirm("密码将重置为123456,确定要进行重置？",function(){
		var url = CONTEXT_PATH + "/user/updatePassword";
		var params = {userIds:userIds};
		jQuery.post(url, params, function(data) {
			if(data.success){
				refreshPage("usersForm","usersDiv");
				myAlert("重置成功");
			}else{
				myAlert(data.message);
			}
		});
	});
}


function deleteUser(){
	var userIds = getCheckedEntityIds("usersTable");
	if(!userIds){
		myAlert("请勾选待删除用户");
		return;
	}
	myConfirm(globalDeleteTip,function(){
		var url = CONTEXT_PATH + "/user/deleteUser";
		var params = {userIds:userIds};
		jQuery.post(url, params, function(data) {
			if(data.success){
				refreshPage("usersForm","usersDiv");
			}else{
				myAlert(data.message);
			}
		});
	});
}

function approval(){
	var userId = getSelectedEntityId("usersTable");
	if(!userId){
		myAlert("请选择用户");
		return;
	}
	var url = CONTEXT_PATH + "/user/approval";
	var params = {recordId:userId};
	jQuery.post(url, params, function(data) {
		if(data.success){
			refreshPage("usersForm","usersDiv");
		}else{
			myAlert(data.message);
		}
	});
}

function reject() {
	var userId = getSelectedEntityId("usersTable");
	if(!userId){
		myAlert("请选择用户");
		return;
	}
	var url = CONTEXT_PATH + "/user/reject";
	var params = {recordId:userId};
	jQuery.post(url, params, function(data) {
		if(data.success){
			refreshPage("usersForm","usersDiv");
		}else{
			myAlert(data.message);
		}
	});
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

