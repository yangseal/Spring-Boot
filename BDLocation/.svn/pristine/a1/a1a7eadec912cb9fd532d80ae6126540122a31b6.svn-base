//$(function(){
//	$("iframe").height($("body").height()-globalTabHeight);
//	$("#attachments").myFileUpload({
//		isQuery : $.QueryString("isQuery"),
//		entityName : "corsApply",
//		fieldName : "attachments",
//		entityId : $("#corsApplyId").val()
//	});
//});
//
//function redioControl(){
//	$("input[type='redio']").click(function(){
//		
//	});
//}
//
//
//function addOamArea() {
//	var dom = $("<div/>");
//	var url = CONTEXT_PATH + "/regionNum/showRegion";
//	var params = {};
//	dom.load(url,params,function(){
//		dialog({
//			title : "新增区域",
//			content : dom,
//			width:700
//		}).showModal();
//	});
//}
//
//
//function saveCorsApply(){
//	/*if(!validateForm("corsApplyForm")){
//		return;
//	}*/
//	var url = CONTEXT_PATH + "/corsApply/saveCorsApply";
//	var params = $("#corsApplyForm").serialize();
//
//	
//	var checkval = $("input[type='radio']:checked").val();
//	params = params + "&accountUserPeriod="+checkval;
//
//	$('.btn-success').addClass('disabled');
//
//	jQuery.post(url, params, function(data) {
//
//	if(data.success){
//
//		$('.btn-success').removeClass('disabled');
//		if(data.success){
//
//			var opener = window.top.getOpener();
//			opener.refreshPage("corsApplysForm","corsApplysDiv");
//			if($("#corsApplyId").val()){
//				myAlert(globalSaveSuccessTip);
//				return;
//			}
//			alert(globalSaveSuccessTip);
//			opener.showCorsApply(data.message);
//		}else{
//			if(data.message) {
//				myAlert(data.message);
//				var opener = window.top.getOpener();
//				opener.refreshPage("corsApplysForm","corsApplysDiv");
//			} else {
//				$("#purposeDescTip").text("存在非法字符!");
//			}
//		}
//	}
//	});
//}
//
//function selectCompany(){
//	var dom = $("<div fkFieldCode='company'/>");
//	var url = CONTEXT_PATH + "/company/selectCompany";
//	dom.load(url,null,function(){
//		dialog({
//			id:'company',
//			title : "选择申请企业",
//			content : dom
//		}).showModal();
//	});
//}
////function selectUser(){
////	var dom = $("<div fkFieldCode='user'/>");
////	var url = CONTEXT_PATH + "/user/selectUser";
////	dom.load(url,null,function(){
////		dialog({
////			id:'user',
////			title : "选择申请人员",
////			content : dom
////		}).showModal();
////	});
////}
////
////function selectOamArea(){
////	var dom = $("<div fkFieldCode='oamArea'/>");
////	var url = CONTEXT_PATH + "/oamArea/selectOamArea";
////	dom.load(url,null,function(){
////		dialog({
////			id:'oamArea',
////			title : "选择所属省市",
////			content : dom
////		}).showModal();
////	});
////}