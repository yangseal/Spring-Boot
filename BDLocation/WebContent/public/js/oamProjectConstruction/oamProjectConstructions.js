//打开页面即执行查询
$(function(){
	refreshPage("oamProjectConstructionsForm","oamProjectConstructionsDiv");
});

function showOamProjectConstruction(oamProjectConstructionId,isQuery){
	var url = CONTEXT_PATH + "/oamProjectConstruction/showOamProjectConstruction";
	var title = "新增项目建设";
	if(oamProjectConstructionId){
		url += "?oamProjectConstructionId=" + oamProjectConstructionId;
		title = "编辑项目建设";
	}
	if(isQuery){
		url += "&isQuery=true";
		title = "查看项目建设";
	}
	if($.QueryString()){
		if(url.indexOf("?")>0){
			url += "&";
		}else{
			url += "?";
		}
		url += $.QueryString()._queryString_;
	}
	openTab("oamProjectConstruction",title,url);
}

function viewOamProjectConstruction(){
	var oamProjectConstructionId = getSelectedEntityId("oamProjectConstructionsTable");
	if(!oamProjectConstructionId){
		myAlert("请选择待查看项目建设");
		return;
	}
	showOamProjectConstruction(oamProjectConstructionId,true);
}

function editOamProjectConstruction(){
	var oamProjectConstructionId = getSelectedEntityId("oamProjectConstructionsTable");
	if(!oamProjectConstructionId){
		myAlert("请选择待编辑项目建设");
		return;
	}
	showOamProjectConstruction(oamProjectConstructionId);
}

function deleteOamProjectConstruction(){
	var oamProjectConstructionIds = getCheckedEntityIds("oamProjectConstructionsTable");
	if(!oamProjectConstructionIds){
		myAlert("请勾选待删除项目建设");
		return;
	}
	myConfirm(globalDeleteTip,function(){
		var url = CONTEXT_PATH + "/oamProjectConstruction/deleteOamProjectConstruction";
		var params = {oamProjectConstructionIds:oamProjectConstructionIds};
		jQuery.post(url, params, function(data) {
			if(data.success){
				refreshPage("oamProjectConstructionsForm","oamProjectConstructionsDiv");
			}else{
				myAlert(data.message);
			}
		});
	});
}

function exportOamProjectConstructions(){
	var url = CONTEXT_PATH + "/oamProjectConstruction/exportOamProjectConstructions?" + $("#oamProjectConstructionsForm").serialize();
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
