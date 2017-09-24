//打开页面即执行查询
$(function(){
	refreshPage("rolesForm","rolesDiv");
});

function showRole(roleId,isQuery){
	var url = CONTEXT_PATH + "/role/showRole";
	var title = "新增角色";
	if(roleId){
		url += "?roleId=" + roleId;
		title = "编辑角色";
	}
	if(isQuery){
		url += "&isQuery=true";
		title = "查看角色";
	}
	if($.QueryString()){
		if(url.indexOf("?")>0){
			url += "&";
		}else{
			url += "?";
		}
		url += $.QueryString()._queryString_;
	}
	openTab("role",title,url);
}

function viewRole(){
	var roleId = getSelectedEntityId("rolesTable");
	if(!roleId){
		myAlert("请选择待查看角色");
		return;
	}
	showRole(roleId,true);
}

function editRole(){
	var roleId = getSelectedEntityId("rolesTable");
	if(!roleId){
		myAlert("请选择待编辑角色");
		return;
	}
	showRole(roleId);
}

function deleteRole(){
	var roleIds = getCheckedEntityIds("rolesTable");
	if(!roleIds){
		myAlert("请勾选待删除角色");
		return;
	}
	myConfirm(globalDeleteTip,function(){
		var url = CONTEXT_PATH + "/role/deleteRole";
		var params = {roleIds:roleIds};
		jQuery.post(url, params, function(data) {
			if(data.success){
				refreshPage("rolesForm","rolesDiv");
			}else{
				myAlert(data.message);
			}
		});
	});
}
