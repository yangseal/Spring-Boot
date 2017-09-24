$(function(){
	$("iframe").height($("body").height()-globalTabHeight);
	$("#attachments").myFileUpload({
		isQuery : $.QueryString("isQuery"),
		entityName : "oamStationConstruction",
		fieldName : "attachments",
		entityId : $("#oamStationConstructionId").val()
	});
});

function saveOamStationConstruction(){
	if(!validateForm("oamStationConstructionForm")){
		return;
	}
	var url = CONTEXT_PATH + "/oamStationConstruction/saveOamStationConstruction";
	var params = $("#oamStationConstructionForm").serialize();
	jQuery.post(url, params, function(data) {
		if(data.success){
			var opener = window.top.getOpener();
			opener.refreshPage("oamStationConstructionsForm","oamStationConstructionsDiv");
			if($("#oamStationConstructionId").val()){
				myAlert(globalSaveSuccessTip);
				return;
			}
			alert(globalSaveSuccessTip);
			opener.showOamStationConstruction(data.message);
		}else{
			myAlert(data.message);
		}
	});
}

function selectOamProjectConstruction(){
	var dom = $("<div fkFieldCode='oamProjectConstruction'/>");
	var url = CONTEXT_PATH + "/oamProjectConstruction/selectOamProjectConstruction";
	dom.load(url,null,function(){
		dialog({
			id:'oamProjectConstruction',
			title : "选择项目建设",
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
