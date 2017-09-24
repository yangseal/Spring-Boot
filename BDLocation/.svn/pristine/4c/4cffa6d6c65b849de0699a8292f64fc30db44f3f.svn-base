//打开页面即执行查询
$(function(){
	refreshPage("oamStationConstructionsForm","oamStationConstructionsDiv");
});

function showOamStationConstruction(oamStationConstructionId,isQuery){
	var url = CONTEXT_PATH + "/oamStationConstruction/showOamStationConstruction";
	var title = "新增基站建设";
	if(oamStationConstructionId){
		url += "?oamStationConstructionId=" + oamStationConstructionId;
		title = "编辑基站建设";
	}
	if(isQuery){
		url += "&isQuery=true";
		title = "查看基站建设";
	}
	if($.QueryString()){
		if(url.indexOf("?")>0){
			url += "&";
		}else{
			url += "?";
		}
		url += $.QueryString()._queryString_;
	}
	openTab("oamStationConstruction",title,url);
}

function viewOamStationConstruction(){
	var oamStationConstructionId = getSelectedEntityId("oamStationConstructionsTable");
	if(!oamStationConstructionId){
		myAlert("请选择待查看基站建设");
		return;
	}
	showOamStationConstruction(oamStationConstructionId,true);
}

function editOamStationConstruction(){
	var oamStationConstructionId = getSelectedEntityId("oamStationConstructionsTable");
	if(!oamStationConstructionId){
		myAlert("请选择待编辑基站建设");
		return;
	}
	showOamStationConstruction(oamStationConstructionId);
}

function deleteOamStationConstruction(){
	var oamStationConstructionIds = getCheckedEntityIds("oamStationConstructionsTable");
	if(!oamStationConstructionIds){
		myAlert("请勾选待删除基站建设");
		return;
	}
	myConfirm(globalDeleteTip,function(){
		var url = CONTEXT_PATH + "/oamStationConstruction/deleteOamStationConstruction";
		var params = {oamStationConstructionIds:oamStationConstructionIds};
		jQuery.post(url, params, function(data) {
			if(data.success){
				refreshPage("oamStationConstructionsForm","oamStationConstructionsDiv");
			}else{
				myAlert(data.message);
			}
		});
	});
}

function exportOamStationConstructions(){
	var url = CONTEXT_PATH + "/oamStationConstruction/exportOamStationConstructions?" + $("#oamStationConstructionsForm").serialize();
	window.location.href = url;
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
