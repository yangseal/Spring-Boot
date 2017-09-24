//打开页面即执行查询
$(function(){
	refreshPage("oamProjectTestingsForm","oamProjectTestingsDiv");
});

function showOamProjectTesting(oamProjectTestingId,isQuery){
	var url = CONTEXT_PATH + "/oamProjectTesting/showOamProjectTesting";
	var title = "新增项目测试";
	if(oamProjectTestingId){
		url += "?oamProjectTestingId=" + oamProjectTestingId;
		title = "编辑项目测试";
	}
	if(isQuery){
		url += "&isQuery=true";
		title = "查看项目测试";
	}
	if($.QueryString()){
		if(url.indexOf("?")>0){
			url += "&";
		}else{
			url += "?";
		}
		url += $.QueryString()._queryString_;
	}
	openTab("oamProjectTesting",title,url);
}

function viewOamProjectTesting(){
	var oamProjectTestingId = getSelectedEntityId("oamProjectTestingsTable");
	if(!oamProjectTestingId){
		myAlert("请选择待查看项目测试");
		return;
	}
	showOamProjectTesting(oamProjectTestingId,true);
}

function editOamProjectTesting(){
	var oamProjectTestingId = getSelectedEntityId("oamProjectTestingsTable");
	if(!oamProjectTestingId){
		myAlert("请选择待编辑项目测试");
		return;
	}
	showOamProjectTesting(oamProjectTestingId);
}

function deleteOamProjectTesting(){
	var oamProjectTestingIds = getCheckedEntityIds("oamProjectTestingsTable");
	if(!oamProjectTestingIds){
		myAlert("请勾选待删除项目测试");
		return;
	}
	myConfirm(globalDeleteTip,function(){
		var url = CONTEXT_PATH + "/oamProjectTesting/deleteOamProjectTesting";
		var params = {oamProjectTestingIds:oamProjectTestingIds};
		jQuery.post(url, params, function(data) {
			if(data.success){
				refreshPage("oamProjectTestingsForm","oamProjectTestingsDiv");
			}else{
				myAlert(data.message);
			}
		});
	});
}

function exportOamProjectTestings(){
	var url = CONTEXT_PATH + "/oamProjectTesting/exportOamProjectTestings?" + $("#oamProjectTestingsForm").serialize();
	window.location.href = url;
}

function selectOamProject(){
	var dom = $("<div fkFieldCode='oamProject'/>");
	var url = CONTEXT_PATH + "/oamProject/selectOamProject";
	dom.load(url,null,function(){
		dialog({
			id:'oamProject',
			title : "选择所属项目",
			content : dom
		}).showModal();
	});
}
