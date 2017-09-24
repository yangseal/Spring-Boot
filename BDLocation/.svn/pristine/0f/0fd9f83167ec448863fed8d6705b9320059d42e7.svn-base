$(function(){
	$("iframe").height($("body").height()-globalTabHeight);
});

function saveOamStationTesting(){
	if(!validateForm("oamStationTestingForm")){
		return;
	}
	var url = CONTEXT_PATH + "/oamStationTesting/saveOamStationTesting";
	var params = $("#oamStationTestingForm").serialize();
	jQuery.post(url, params, function(data) {
		if(data.success){
			var opener = window.top.getOpener();
			opener.refreshPage("oamStationTestingsForm","oamStationTestingsDiv");
			if($("#oamStationTestingId").val()){
				myAlert(globalSaveSuccessTip);
				return;
			}
			alert(globalSaveSuccessTip);
			opener.showOamStationTesting(data.message);
		}else{
			myAlert(data.message);
		}
	});
}

function selectOamProjectTesting(){
	var dom = $("<div fkFieldCode='oamProjectTesting'/>");
	var url = CONTEXT_PATH + "/oamProjectTesting/selectOamProjectTesting";
	dom.load(url,null,function(){
		dialog({
			id:'oamProjectTesting',
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
