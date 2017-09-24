$(function(){
	$("iframe").height($("body").height()-50);
});

function saveRole(){
	if(!validateForm("roleForm")){
		return;
	}
	var url = CONTEXT_PATH + "/role/saveRole";
	var params = $("#roleForm").serialize();
	jQuery.post(url, params, function(data) {
		if(data.success){
			var opener = window.top.getOpener();
			opener.refreshPage("rolesForm","rolesDiv");
			if($("#roleId").val()){
				myAlert(globalSaveSuccessTip);
				return;
			}
			alert(globalSaveSuccessTip);
			opener.showRole(data.message);
		}else{
			myAlert(data.message);
		}
	});
}