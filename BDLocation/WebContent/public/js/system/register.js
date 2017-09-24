$(function(){
	$("iframe").height($("body").height()-globalTabHeight);
	Location.init(["","",0,0], $('#companyTempForm'));
	validateRealTime("companyTempForm");
});

function saveCompanyTempByPage(){
	if(!validateForm('companyTempForm')) return;
	
	var url = CONTEXT_PATH + "/companyTemp/saveCompanyTempByPage";
	$("#address").val($(".text").text()+" "+$("#addressDetail").val());
	var params = $("#companyTempForm").serialize();
	jQuery.post(url, params, function(data) {
		if(data.success){
			myAlert("注册成功！正在跳转页面中...");
			setTimeout(function(){window.location.href=CONTEXT_PATH + "/login";},3000);
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
			title : "选择所属省市",
			content : dom
		}).showModal();
	});
}

function toLogin(){
	var url = CONTEXT_PATH +"/login";
	window.location = url;
}


