$(function(){
	$("iframe").height($("body").height()-globalTabHeight);
});

function saveOamProvider(){
	if(!validateForm("oamProviderForm")){
		return;
	}
	var url = CONTEXT_PATH + "/oamProvider/saveOamProvider";
	var params = $("#oamProviderForm").serialize();
	jQuery.post(url, params, function(data) {
		if(data.success){
			var opener = window.top.getOpener();
			opener.refreshPage("oamProvidersForm","oamProvidersDiv");
			if($("#oamProviderId").val()){
				myAlert(globalSaveSuccessTip);
				return;
			}
			alert(globalSaveSuccessTip);
			opener.showOamProvider(data.message);
		}else{
			myAlert(data.message);
		}
	});
}

