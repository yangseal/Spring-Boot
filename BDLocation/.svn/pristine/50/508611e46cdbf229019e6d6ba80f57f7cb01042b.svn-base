//打开页面即执行查询
$(function(){
	refreshPage("oamStationAddresssForm","oamStationAddresssDiv");
});

function showOamStationAddress(oamStationAddressId,isQuery){
	var url = CONTEXT_PATH + "/oamStationAddress/showOamStationAddress";
	var title = "新增基站选址";
	if(oamStationAddressId){
		url += "?oamStationAddressId=" + oamStationAddressId;
		title = "编辑基站选址";
	}
	if(isQuery){
		url += "&isQuery=true";
		title = "查看基站选址";
	}
	if($.QueryString()){
		if(url.indexOf("?")>0){
			url += "&";
		}else{
			url += "?";
		}
		url += $.QueryString()._queryString_;
	}
	openTab("oamStationAddress",title,url);
}

function viewOamStationAddress(){
	var oamStationAddressId = getSelectedEntityId("oamStationAddresssTable");
	if(!oamStationAddressId){
		myAlert("请选择待查看基站选址");
		return;
	}
	showOamStationAddress(oamStationAddressId,true);
}

function editOamStationAddress(){
	var oamStationAddressId = getSelectedEntityId("oamStationAddresssTable");
	if(!oamStationAddressId){
		myAlert("请选择待编辑基站选址");
		return;
	}
	showOamStationAddress(oamStationAddressId);
}

function deleteOamStationAddress(){
	var oamStationAddressIds = getCheckedEntityIds("oamStationAddresssTable");
	if(!oamStationAddressIds){
		myAlert("请勾选待删除基站选址");
		return;
	}
	myConfirm(globalDeleteTip,function(){
		var url = CONTEXT_PATH + "/oamStationAddress/deleteOamStationAddress";
		var params = {oamStationAddressIds:oamStationAddressIds};
		jQuery.post(url, params, function(data) {
			if(data.success){
				refreshPage("oamStationAddresssForm","oamStationAddresssDiv");
			}else{
				myAlert(data.message);
			}
		});
	});
}

function exportOamStationAddresss(){
	var url = CONTEXT_PATH + "/oamStationAddress/exportOamStationAddresss?" + $("#oamStationAddresssForm").serialize();
	window.location.href = url;
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
