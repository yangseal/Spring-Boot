$(function(){
	$("iframe").height($("body").height()-globalTabHeight);
});

function saveConversionProjection(){
	if(!validateForm("conversionProjectionForm")){
		return;
	}
	var url = CONTEXT_PATH + "/conversionProjection/saveConversionProjection";
	var params = $("#conversionProjectionForm").serialize();
	jQuery.post(url, params, function(data) {
		if(!data.success){
			myAlert(data.message);
			return;
		}
		var opener = window.top.getOpener();
		opener.refreshPage("conversionProjectionsForm","conversionProjectionsDiv");
		if($("#conversionProjectionId").val()){
			myAlert(globalSaveSuccessTip);
			return;
		}
		myAlert(globalSaveSuccessTip,function(){
			opener.showConversionProjection(data.message);
		});
	});
}

