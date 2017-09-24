$(function(){
	var isQuery = $.QueryString("isQuery");
	/**基站验收资料附件上传*/
	var entityId = $("#baseCheckMatetialId").val(),
		entityName = 'checkInfo';
	/**基建资料附件上传*/
	var buildEntityId = $("#baseMaterialId").val(),
	    buildEntityName = 'buildInfo';
	/**选址资料附件上传*/
	var addressEntityId = $("#baseAddressId").val(),
		addressEntityName = 'addressInfo';
	/**测试资料附件上传*/
	var baseStationTestId = $("#baseStationTestId").val(),
		materialEntityName = 'materialInfo';
	var params = [{divId:'checkReports',isQuery:isQuery,entityName:entityName,fieldName:'checkReports',entityId:entityId},
	              {divId:'guancePho',isQuery:isQuery,entityName:buildEntityName,fieldName:'guancePho',entityId:buildEntityId},
	              {divId:'videoPho',isQuery:isQuery,entityName:buildEntityName,fieldName:'videoPho',entityId:buildEntityId},
	              {divId:'fangleiPho',isQuery:isQuery,entityName:buildEntityName,fieldName:'fangleiPho',entityId:buildEntityId},
	              {divId:'jizhunConfig',isQuery:isQuery,entityName:buildEntityName,fieldName:'jizhunConfig',entityId:buildEntityId},
	              {divId:'jizhunNetConfig',isQuery:isQuery,entityName:buildEntityName,fieldName:'jizhunNetConfig',entityId:buildEntityId},
	              {divId:'jizhunPlan',isQuery:isQuery,entityName:buildEntityName,fieldName:'jizhunPlan',entityId:buildEntityId},
	              {divId:'jizhunReport',isQuery:isQuery,entityName:buildEntityName,fieldName:'jizhunReport',entityId:buildEntityId},
	              {divId:'deviceReport',isQuery:isQuery,entityName:buildEntityName,fieldName:'deviceReport',entityId:buildEntityId},
	              {divId:'addressPho',isQuery:isQuery,entityName:addressEntityName,fieldName:'addressPho',entityId:addressEntityId},
	              {divId:'testReport',isQuery:isQuery,entityName:addressEntityName,fieldName:'testReport',entityId:addressEntityId},
	              {divId:'otherData',isQuery:isQuery,entityName:addressEntityName,fieldName:'otherData',entityId:addressEntityId},
	              {divId:'unionPlan',isQuery:isQuery,entityName:materialEntityName,fieldName:'unionPlan',entityId:baseStationTestId},
	              {divId:'dataDeal',isQuery:isQuery,entityName:materialEntityName,fieldName:'dataDeal',entityId:baseStationTestId},
	              {divId:'localControl',isQuery:isQuery,entityName:materialEntityName,fieldName:'localControl',entityId:baseStationTestId},
	              {divId:'testPhoto',isQuery:isQuery,entityName:materialEntityName,fieldName:'testPhoto',entityId:baseStationTestId},
	              {divId:'systemPlan',isQuery:isQuery,entityName:materialEntityName,fieldName:'systemPlan',entityId:baseStationTestId},
	              {divId:'testPlanTable',isQuery:isQuery,entityName:materialEntityName,fieldName:'testPlanTable',entityId:baseStationTestId},
	              {divId:'sysTestRep',isQuery:isQuery,entityName:materialEntityName,fieldName:'sysTestRep',entityId:baseStationTestId},
	              {divId:'sceneTest',isQuery:isQuery,entityName:materialEntityName,fieldName:'sceneTest',entityId:baseStationTestId}
	              ];
	uploadFile(params);
	
	$.each($("div[name='addData']"),function(index,item){
	    var arr = $(item).find("input").val().split(",");
		$.each(arr,function(sindex,sitem){
			$.each($(item).prev().prev().find("input"),function(ssindex,ssitem){
				if(sitem == $(ssitem).val()){
					$(ssitem).attr("checked","checked");
					$(item).find("input").val($(item).find("input").val().replace(sitem,""));
				}
			});
		});
		$(item).find("input").val($(item).find("input").val().replace(/,/gm,""));
	});
	
	validateRealTime("constructForm");
});

/** 添加行*/
/**
 */
function addTableLine(){
	var tableBody = $("#testParamsTable"),
		trTemp = $("#testParamsTemp").clone();
		trTemp.removeAttr('style').removeAttr('id').attr('datatr','yes');
	tableBody.append(trTemp);
}

/** 删除行*/
function delParam(sender){
	$(sender).closest('tr').remove();
}

/**保存基建资料*/
function saveBuildInfo(){
	if(!validateForm("constructForm")){
		myAlert("页面输入有误,请更正后再次保存!");
		return;
	}
	var url = CONTEXT_PATH + "/baseStation/construction/saveBuildInfo";
	var params = $("#constructForm").serialize();
	jQuery.post(url, params, function(data) {
		if(data.success){
			myAlert(globalSaveSuccessTip);
			baseBuildInfoInput();
		}else{
			myAlert(data.message);
		}
	});
	
}

/** 保存验收资料 */
function saveCheckInfo(){
	if(!validateForm("constructForm")){
		myAlert("页面输入有误,请更正后再次保存!");
		return;
	}
	var url = CONTEXT_PATH + "/baseStation/construction/saveBaseCheckMaterial";
	var params = $("#constructForm").serialize();
	jQuery.post(url, params, function(data) {
		if(data.success){
			myAlert(globalSaveSuccessTip);
			baseValidateInfoInput();
		}else{
			myAlert(data.message);
		}
	});
}




//保存选址资料
function saveBaseAddress(){
	if(!validateForm("constructForm")){
		myAlert("页面输入有误,请更正后再次保存!");
		return;
	}
	var url = CONTEXT_PATH + "/baseStation/construction/saveBaseAddress";
	addData();
	var params = $("#constructForm").serialize();
	$.post(url,params,function(data){
		if(data.success){
			myAlert(globalSaveSuccessTip);
			selectAddressInput();
		}
	});
}



//多选框拼值统一算法
function addData(){
	$.each($("div[name='addData']"),function(index,item){
		var params = "";
		$.each($(item).prev().prev().find(":checked"),function(sindex,sitem){
			if($(item).find("input").val()=="" && $(item).prev().prev().find(":checked").length == 1){
				params += $(sitem).val();
			}else if($(item).find("input").val()=="" && $(item).prev().prev().find(":checked").length >1 && sindex == $(item).prev().prev().find(":checked").length-1) {
				params += $(sitem).val();
			}else{
				params += $(sitem).val()+",";
			}
		});
		$(item).next("input").val(params+$(item).find("input").val());
	});
}


//保存测试资料
function saveBaseStationTest(){
	if(!validateForm("constructForm")){
		myAlert("页面输入有误,请更正后再次保存!");
		return;
	}
	 //遍历 起始点 table中的行，添加序列化 name 属性
	$("tr[datatr]",$('#testParamsTable')).each(function(i,obj){
		var index = i;
		$(obj).find('input').each(function(){
			var _name = $(this).attr('data_name');
			if(_name == 'pointName') $(this).attr('name','baseLinkPoint['+index+'].pointName');
			if(_name == 'pointPosition') $(this).attr('name','baseLinkPoint['+index+'].pointPosition');
			if(_name == 'uniteNo') $(this).attr('name','baseLinkPoint['+index+'].uniteNo');
		});
	});
	var url = CONTEXT_PATH + "/baseStation/construction/saveBaseStationTest";
	addData();
	var params = $("#constructForm").serialize();
	$.post(url,params,function(data){
		if(data.success){
			myAlert(globalSaveSuccessTip);
			baseTestInfoInput();
		}
	});
}


function submitConstructMaterial(){
	myConfirm("提交后将不可修改,确定要提交吗?",function(){
			var url = CONTEXT_PATH + "/baseStation/construction/updateConstructStage";
			$.post(url,{'baseConstructId':$("#baseConstructId").val()},function(data){
				if(data.success){
					myAlert("提交成功!");
					var opener = window.top.getOpener();
					opener.refreshPage("baseConstructForm","baseConstructDiv");
					return;
				}
				
				myAlert("提交失败!");
			});
	});
}
