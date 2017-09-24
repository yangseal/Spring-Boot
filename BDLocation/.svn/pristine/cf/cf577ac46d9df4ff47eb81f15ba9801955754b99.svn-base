//打开页面即执行查询
$(function(){
	refreshPage("oamDeviceArchivessForm","oamDeviceArchivessDiv");
});

function showOamDeviceArchives(oamDeviceArchivesId,isQuery){
	var url = CONTEXT_PATH + "/oamDeviceArchives/showOamDeviceArchives";
	var title = "新增北斗设备档案";
	if(oamDeviceArchivesId){
		url += "?oamDeviceArchivesId=" + oamDeviceArchivesId;
		title = "编辑北斗设备档案";
	}
	if(isQuery){
		url += "&isQuery=true";
		title = "查看北斗设备档案";
	}
	if($.QueryString()){
		if(url.indexOf("?")>0){
			url += "&";
		}else{
			url += "?";
		}
		url += $.QueryString()._queryString_;
	}
	openTab("oamDeviceArchives",title,url);
}

function viewOamDeviceArchives(){
	var oamDeviceArchivesId = getSelectedEntityId("oamDeviceArchivessTable");
	if(!oamDeviceArchivesId){
		myAlert("请选择待查看北斗设备档案");
		return;
	}
	showOamDeviceArchives(oamDeviceArchivesId,true);
}

function editOamDeviceArchives(){
	var oamDeviceArchivesId = getSelectedEntityId("oamDeviceArchivessTable");
	if(!oamDeviceArchivesId){
		myAlert("请选择待编辑北斗设备档案");
		return;
	}
	showOamDeviceArchives(oamDeviceArchivesId);
}

function deleteOamDeviceArchives(){
	var oamDeviceArchivesIds = getCheckedEntityIds("oamDeviceArchivessTable");
	if(!oamDeviceArchivesIds){
		myAlert("请勾选待删除北斗设备档案");
		return;
	}
	myConfirm(globalDeleteTip,function(){
		var url = CONTEXT_PATH + "/oamDeviceArchives/deleteOamDeviceArchives";
		var params = {oamDeviceArchivesIds:oamDeviceArchivesIds};
		jQuery.post(url, params, function(data) {
			if(data.success){
				refreshPage("oamDeviceArchivessForm","oamDeviceArchivessDiv");
			}else{
				myAlert(data.message);
			}
		});
	});
}

function exportOamDeviceArchivess(){
	var url = CONTEXT_PATH + "/oamDeviceArchives/exportOamDeviceArchivess?" + $("#oamDeviceArchivessForm").serialize();
	window.location.href = url;
}

