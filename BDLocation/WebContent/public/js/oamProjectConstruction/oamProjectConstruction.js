$(function(){
	$("iframe").height($("body").height()-globalTabHeight);
});

function saveOamProjectConstruction(){
	if(!validateForm("oamProjectConstructionForm")){
		return;
	}
	var url = CONTEXT_PATH + "/oamProjectConstruction/saveOamProjectConstruction";
	var params = $("#oamProjectConstructionForm").serialize();
	jQuery.post(url, params, function(data) {
		if(data.success){
			var opener = window.top.getOpener();
			opener.refreshPage("oamProjectConstructionsForm","oamProjectConstructionsDiv");
			if($("#oamProjectConstructionId").val()){
				myAlert(globalSaveSuccessTip);
				return;
			}
			alert(globalSaveSuccessTip);
			opener.showOamProjectConstruction(data.message);
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
