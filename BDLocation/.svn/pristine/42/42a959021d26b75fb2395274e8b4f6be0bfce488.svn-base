$(function(){

});

function saveStakeoutPoint(){
	if(!validateForm("stakeoutPointForm")){
		return;
	}
	
	if(!validateLngAndLat()) {
		myAlert("经纬度或城建坐标至少填写一对");
		return;
	}
	
	var url = CONTEXT_PATH + "/stakeoutPoint/saveStakeoutPoint";
	var params = $("#stakeoutPointForm").serialize();
	jQuery.post(url, params, function(data) {
		if(data.success){
			var opener = window.top.getOpener();
			opener.refreshPage("stakeoutPointsForm","stakeoutPointsDiv");
			alert(globalSaveSuccessTip);
			opener.showStakeoutPoint(data.message);
		}else{
			myAlert(data.message);
		}
	});
}

//验证经纬度或城建坐标是否填写完整
function validateLngAndLat() {
	var result = true;
	var longitude = $("#longitude").val();
	var latitude = $("#latitude").val();
	var coordinateX = $("#coordinateX").val();
	var coordinateY = $("#coordinateY").val();
	
	if( (longitude != "" && latitude != "") || (coordinateX != "" && coordinateY != "") ) {
	} else {
		result = false;
	}
	
	return result;
}

function selectAffiliationPointType(){
	var dom = $("<div fkFieldCode='affiliationPointType'/>");
	var url = CONTEXT_PATH + "/pointType/selectPointType";
	dom.load(url,null,function(){
		dialog({
			id:'affiliationPointType',
			title : "选择所属点类型",
			content : dom
		}).showModal();
	});
}
function selectAffiliationStakeoutTask(){
	_fkFieldCode = "affiliationStakeoutTask";
	var dom = $("<div/>");
	var url = CONTEXT_PATH + "/stakeoutTask/selectStakeoutTask";
	dom.load(url,null,function(){
		dialog({
			title : "选择所属放样任务",
			content : dom
		}).showModal();
	});
}
