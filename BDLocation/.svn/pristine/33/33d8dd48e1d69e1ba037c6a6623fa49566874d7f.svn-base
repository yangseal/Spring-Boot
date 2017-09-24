$(function(){
	$("iframe").height($("body").height()-50);
});

function saveDict(){
	if(!validateForm("dictForm")){
		return;
	}
	var url = CONTEXT_PATH + "/dict/saveDict";
	var params = $("#dictForm").serialize();
	jQuery.post(url, params, function(data) {
		if(data.success){
			var opener = window.top.getOpener();
			opener.refreshPage("dictsForm","dictsDiv");
			if($("#dictId").val()){
				myAlert(globalSaveSuccessTip);
				return;
			}
			alert(globalSaveSuccessTip);
			opener.showDict(data.message);
		}else{
			myAlert(data.message);
		}
	});
}