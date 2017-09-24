$(function(){
	$("iframe").height($("body").height()-globalTabHeight);
	$("#attachments").myFileUpload({
		isQuery : $.QueryString("isQuery"),
		entityName : "oamBaseStation",
		fieldName : "attachments",
		entityId : $("#oamBaseStationId").val()
	});
});

function saveOamBaseStation(){
	if(!validateForm("oamBaseStationForm")){
		return;
	}
	var url = CONTEXT_PATH + "/oamBaseStation/saveOamBaseStation";
	var params = $("#oamBaseStationForm").serialize();
	jQuery.post(url, params, function(data) {
		if(data.success){
			var opener = window.top.getOpener();
			opener.refreshPage("oamBaseStationsForm","oamBaseStationsDiv");
			if($("#oamBaseStationId").val()){
				myAlert(globalSaveSuccessTip);
				return;
			}
			alert(globalSaveSuccessTip);
			opener.showOamBaseStation(data.message);
		}else{
			myAlert(data.message);
		}
	});
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
