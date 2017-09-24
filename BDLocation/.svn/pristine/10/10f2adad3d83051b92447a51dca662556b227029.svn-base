$(function(){
	refreshPage("projectsForm","projectsDiv",0);
	$("#baseCustomer").val($.QueryString('baseCustomerId'));
	validateRealTime("projectForm");
});

function initSelectTime(){
	var endDate=$dp.$('endDate');
	WdatePicker({dateFmt:'yyyy-MM-dd HH:mm:ss',onpicked: function(){endDate.click();}});
}

//查看,新增,修改通用方法
function showProject(projectId,isQuery){
	var url = CONTEXT_PATH+"/baseStation/customer/showProject";
	var title = "新增项目";
	var baseCustomerId = $("#baseCustomerId").val();
	url += "?baseCustomerId="+baseCustomerId;
	if(projectId){
		url += "&projectId="+projectId;
		title = "修改项目";
	}
	if(isQuery){
		url += "&isQuery=true";
		title = "查看项目";
	}
	openTab("project",title,url);
}

function addProject(){
	showProject();
}

function editProject(){
	if(getSelectedEntityIdForOne("projectsTable")){
		var entityId =	getSelectedEntityIdForOne("projectsTable");
		showProject(entityId);
	}
	return;
}

function viewProject(){
	 var entityId =	getSelectedEntityIdForOne("projectsTable");
	 showProject(entityId,true);
}

function deleteProject(){
	var projectIds = getCheckedEntityIds("projectsTable");
	if(!projectIds){
		myAlert("请勾选待删除项目");
		return;
	}
	myConfirm(globalDeleteTip,function(){
		var url = CONTEXT_PATH + "/baseStation/customer/deleteProject";
		var params = {projectIds:projectIds};
		jQuery.post(url, params, function(data) {
			if(data.success){
				refreshPage("projectsForm","projectsDiv");
			}else{
				myAlert(data.message);
			}
		});
	});
}

function saveProject(){
	if(!validateForm("projectForm")){
		return;
	}
	var url = CONTEXT_PATH+"/baseStation/customer/saveProject";
	var params = $("#projectForm").serialize();
	$.post(url,params,function(data){
		if(data.success){
			var opener = window.top.getOpener();
			opener.refreshPage("projectsForm","projectsDiv");
			if(!$("#baseProjectId").val())
				$("#baseProjectId").val(data.message);
				myAlert(globalSaveSuccessTip);
		} else {
			myAlert(data.message);
		}
	});
}

function toStationByProjectId(projectId){
	
	var url = CONTEXT_PATH+"/baseStation/customer/showBSConstructs";
	var title ="基站信息";
	url+="?projectId="+projectId;
	openTab("BSconstructs",title,url);
}