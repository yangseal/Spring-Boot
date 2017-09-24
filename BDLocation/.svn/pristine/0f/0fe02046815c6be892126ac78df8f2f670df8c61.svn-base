$(function(){
	$("iframe").height($("body").height()-globalTabHeight);
});

function saveOamProject(){
	if(!validateForm("oamProjectForm")){
		return;
	}
	var url = CONTEXT_PATH + "/oamProject/saveOamProject";
	var params = $("#oamProjectForm").serialize();
	jQuery.post(url, params, function(data) {
		if(data.success){
			var opener = window.top.getOpener();
			opener.refreshPage("oamProjectsForm","oamProjectsDiv");
			if($("#oamProjectId").val()){
				myAlert(globalSaveSuccessTip);
				return;
			}
			alert(globalSaveSuccessTip);
			opener.showOamProject(data.message);
		}else{
			myAlert(data.message);
		}
	});
}

function selectOamCustomer(){
	var dom = $("<div fkFieldCode='customer'/>");
	var url = CONTEXT_PATH + "/oamCustomer/selectOamCustomer";
	dom.load(url,null,function(){
		dialog({
			id:'customer',
			title : "选择所属客户",
			content : dom
		}).showModal();
	});
}
function selectUser(){
	var dom = $("<div fkFieldCode='user'/>");
	var url = CONTEXT_PATH + "/user/selectUser";
	dom.load(url,null,function(){
		dialog({
			id:'user',
			title : "选择记录人",
			content : dom
		}).showModal();
	});
}
