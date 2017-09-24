$(function(){

});

function saveDictItem(){
	if(!validateForm("dictItemForm")){
		return;
	}
	var url = CONTEXT_PATH + "/dictItem/saveDictItem";
	var params = $("#dictItemForm").serialize();
	jQuery.post(url, params, function(data) {
		if(data.success){
			var opener = window.top.getOpener();
			opener.refreshPage("dictItemsForm","dictItemsDiv");
			if($("#dictItemId").val()){
				myAlert(globalSaveSuccessTip);
				return;
			}
			alert(globalSaveSuccessTip);
			opener.showDictItem(data.message);
		}else{
			myAlert(data.message);
		}
	});
}