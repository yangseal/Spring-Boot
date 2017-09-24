$(function(){
	$("iframe").height($("body").height()-globalTabHeight);
});

function saveOamStationAddress(){
	if(!validateForm("oamStationAddressForm")){
		return;
	}
	var url = CONTEXT_PATH + "/oamStationAddress/saveOamStationAddress";
	var params = $("#oamStationAddressForm").serialize();
	jQuery.post(url, params, function(data) {
		if(data.success){
			var opener = window.top.getOpener();
			opener.refreshPage("oamStationAddresssForm","oamStationAddresssDiv");
			if($("#oamStationAddressId").val()){
				myAlert(globalSaveSuccessTip);
				return;
			}
			alert(globalSaveSuccessTip);
			opener.showOamStationAddress(data.message);
		}else{
			myAlert(data.message);
		}
	});
}

function selectOamProject(){
	var dom = $("<div fkFieldCode='oamProject'/>");
	var url = CONTEXT_PATH + "/oamProject/selectOamProject";
	dom.load(url,null,function(){
		dialog({
			id:'oamProject',
			title : "选择所属项目",
			content : dom
		}).showModal();
	});
}
function selectOamBaseStation(){
	var dom = $("<div fkFieldCode='oamBaseStation'/>");
	var url = CONTEXT_PATH + "/oamBaseStation/selectOamBaseStation";
	dom.load(url,null,function(){
		dialog({
			id:'oamBaseStation',
			title : "选择基站",
			content : dom
		}).showModal();
	});
}
