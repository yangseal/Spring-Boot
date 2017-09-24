$(function(){
	$("iframe").height($("body").height()-globalTabHeight);
});

function saveOamProjectTesting(){
	if(!validateForm("oamProjectTestingForm")){
		return;
	}
	var url = CONTEXT_PATH + "/oamProjectTesting/saveOamProjectTesting";
	var params = $("#oamProjectTestingForm").serialize();
	jQuery.post(url, params, function(data) {
		if(data.success){
			var opener = window.top.getOpener();
			opener.refreshPage("oamProjectTestingsForm","oamProjectTestingsDiv");
			if($("#oamProjectTestingId").val()){
				myAlert(globalSaveSuccessTip);
				return;
			}
			alert(globalSaveSuccessTip);
			opener.showOamProjectTesting(data.message);
		}else{
			myAlert(data.message);
		}
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
