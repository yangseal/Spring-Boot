$(function(){
	$("iframe").height($("body").height()-globalTabHeight);
});

function saveOamDeviceArchives(){
	if(!validateForm("oamDeviceArchivesForm")){
		return;
	}
	var url = CONTEXT_PATH + "/oamDeviceArchives/saveOamDeviceArchives";
	var params = $("#oamDeviceArchivesForm").serialize();
	jQuery.post(url, params, function(data) {
		if(data.success){
			var opener = window.top.getOpener();
			opener.refreshPage("oamDeviceArchivessForm","oamDeviceArchivessDiv");
			if($("#oamDeviceArchivesId").val()){
				myAlert(globalSaveSuccessTip);
				return;
			}
			alert(globalSaveSuccessTip);
			opener.showOamDeviceArchives(data.message);
		}else{
			myAlert(data.message);
		}
	});
}

