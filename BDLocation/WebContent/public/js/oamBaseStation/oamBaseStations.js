//打开页面即执行查询
$(function(){
	refreshPage("oamBaseStationsForm","oamBaseStationsDiv");
});

function showOamBaseStation(oamBaseStationId,isQuery){
	var url = CONTEXT_PATH + "/oamBaseStation/showOamBaseStation";
	var title = "新增基站";
	if(oamBaseStationId){
		url += "?oamBaseStationId=" + oamBaseStationId;
		title = "编辑基站";
	}
	if(isQuery){
		url += "&isQuery=true";
		title = "查看基站";
	}
	if($.QueryString()){
		if(url.indexOf("?")>0){
			url += "&";
		}else{
			url += "?";
		}
		url += $.QueryString()._queryString_;
	}
	openTab("oamBaseStation",title,url);
}

function viewOamBaseStation(){
	var oamBaseStationId = getSelectedEntityId("oamBaseStationsTable");
	if(!oamBaseStationId){
		myAlert("请选择待查看基站");
		return;
	}
	showOamBaseStation(oamBaseStationId,true);
}

function editOamBaseStation(){
	var oamBaseStationId = getSelectedEntityId("oamBaseStationsTable");
	if(!oamBaseStationId){
		myAlert("请选择待编辑基站");
		return;
	}
	showOamBaseStation(oamBaseStationId);
}

function deleteOamBaseStation(){
	var oamBaseStationIds = getCheckedEntityIds("oamBaseStationsTable");
	if(!oamBaseStationIds){
		myAlert("请勾选待删除基站");
		return;
	}
	myConfirm(globalDeleteTip,function(){
		var url = CONTEXT_PATH + "/oamBaseStation/deleteOamBaseStation";
		var params = {oamBaseStationIds:oamBaseStationIds};
		jQuery.post(url, params, function(data) {
			if(data.success){
				refreshPage("oamBaseStationsForm","oamBaseStationsDiv");
			}else{
				myAlert(data.message);
			}
		});
	});
}

function exportOamBaseStations(){
	var url = CONTEXT_PATH + "/oamBaseStation/exportOamBaseStations?" + $("#oamBaseStationsForm").serialize();
	window.location.href = url;
}

function selectOamArea(){
	var dom = $("<div fkFieldCode='oamArea'/>");
	var url = CONTEXT_PATH + "/oamArea/selectOamArea";
	dom.load(url,null,function(){
		dialog({
			id:'oamArea',
			title : "选择所属地区",
			content : dom
		}).showModal();
	});
}
