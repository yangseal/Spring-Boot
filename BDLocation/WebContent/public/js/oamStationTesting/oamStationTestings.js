//打开页面即执行查询
$(function(){
	refreshPage("oamStationTestingsForm","oamStationTestingsDiv");
});

function showOamStationTesting(oamStationTestingId,isQuery){
	var url = CONTEXT_PATH + "/oamStationTesting/showOamStationTesting";
	var title = "新增基站测试";
	if(oamStationTestingId){
		url += "?oamStationTestingId=" + oamStationTestingId;
		title = "编辑基站测试";
	}
	if(isQuery){
		url += "&isQuery=true";
		title = "查看基站测试";
	}
	if($.QueryString()){
		if(url.indexOf("?")>0){
			url += "&";
		}else{
			url += "?";
		}
		url += $.QueryString()._queryString_;
	}
	openTab("oamStationTesting",title,url);
}

function viewOamStationTesting(){
	var oamStationTestingId = getSelectedEntityId("oamStationTestingsTable");
	if(!oamStationTestingId){
		myAlert("请选择待查看基站测试");
		return;
	}
	showOamStationTesting(oamStationTestingId,true);
}

function editOamStationTesting(){
	var oamStationTestingId = getSelectedEntityId("oamStationTestingsTable");
	if(!oamStationTestingId){
		myAlert("请选择待编辑基站测试");
		return;
	}
	showOamStationTesting(oamStationTestingId);
}

function deleteOamStationTesting(){
	var oamStationTestingIds = getCheckedEntityIds("oamStationTestingsTable");
	if(!oamStationTestingIds){
		myAlert("请勾选待删除基站测试");
		return;
	}
	myConfirm(globalDeleteTip,function(){
		var url = CONTEXT_PATH + "/oamStationTesting/deleteOamStationTesting";
		var params = {oamStationTestingIds:oamStationTestingIds};
		jQuery.post(url, params, function(data) {
			if(data.success){
				refreshPage("oamStationTestingsForm","oamStationTestingsDiv");
			}else{
				myAlert(data.message);
			}
		});
	});
}

function exportOamStationTestings(){
	var url = CONTEXT_PATH + "/oamStationTesting/exportOamStationTestings?" + $("#oamStationTestingsForm").serialize();
	window.location.href = url;
}

function selectOamProjectTesting(){
	_fkFieldCode = "oamProjectTesting";
	var dom = $("<div/>");
	var url = CONTEXT_PATH + "/oamProjectTesting/selectOamProjectTesting";
	dom.load(url,null,function(){
		dialog({
			title : "选择所属项目测试",
			content : dom
		}).showModal();
	});
}
function selectOamBaseStation(){
	var dom = $("<div fkFieldCode='oamBaseStation'/>");
	var url = CONTEXT_PATH + "/oamBaseStation/selectOamBaseStation";
	dom.load(url,null,function(){
		dialog({
			id:'oamBaseStation',
			title : "选择基站",
			content : dom
		}).showModal();
	});
}
