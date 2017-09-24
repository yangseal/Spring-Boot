$(function(){
	refreshPage("baseConstructForm","baseConstructDiv");
	refreshPage("baseStationConstructForm","baseStationConstructDiv");
	Location.init(["","",0,0,$("#address").val()], $('#constructForm'));
	var constructSendDownState = $("#baseConstructSendDownState").val();
	if(constructSendDownState && constructSendDownState =='senddowned'){
		$('input[name]').each(function(i,obj){
			$(this).prop('readOnly',true);
		});
		$("#store-selector", $("#constructForm")).unbind("mouseover");
	};
	
	validateRealTime("constructForm");
});

function showConstruct(baseConstructId,isQuery){
	var url = CONTEXT_PATH + "/baseStation/construction/showConstruct";
	var title = "新增基站项目";
	if(baseConstructId){
		url += "?baseConstructId=" + baseConstructId;
		title = "编辑基站项目";
	}
	if(isQuery){
		url += "&isQuery=true";
		title = "查看基站项目";
	}
	if($.QueryString()){
		if(url.indexOf("?")>0){
			url += "&";
		}else{
			url += "?";
		}
		url += $.QueryString()._queryString_;
	}
	openTab("doConstruct",title,url);
}

function addConstruct(){
	showConstruct();
}

function editConstruct(){
	var tableId = "constructsTable";
	if(getSelectedEntityIdForOne(tableId)){
		var entityId =	getSelectedEntityIdForOne(tableId),
			sendDownState = $("tr[entityid='"+entityId+"']").attr('senddownstate');
		if(sendDownState == 'senddowned') showConstruct(entityId,true);
		else showConstruct(entityId);
	}
}

function saveConstruct(){
	if(validateForm("constructForm")){
		var oamId = $("input[location='oamAreaId']").val();
		if(!oamId){
			$("#oamAreaTip").css("color","red");
			$("#oamAreaTip").html("所在区域不能为空");
			return false;
		}else{
			$("#oamAreaTip").html("*");
		}
	}else{
		myAlert("信息不完整,请检查无误后再次保存!");
		return false;
	}
	
	var url = CONTEXT_PATH + "/baseStation/construction/saveConstruct";
	var params = $("#constructForm").serialize();
	jQuery.post(url, params, function(data) {
		if(data.success){
			var opener = window.top.getOpener();
			opener.refreshPage("baseConstructForm","baseConstructDiv");
			if(!$("#baseConstructId").val()){
				$("#baseConstructId").val(data.message);
			}
			myAlert(globalSaveSuccessTip);
			
		}else{
			myAlert(data.message);
		}
	});
}

/**
 * 下发基建任务
 */
function sendDownConstruct(){
	var checkboxs = $("input[datatr][type='checkbox']:checked",$("#constructsTable")),
		idArr = [],
		checkRlt = true;
	if(checkboxs.length == 0){
		myAlert("请选择下发的任务!");
		return;
	}
	
	checkboxs.each(function(i,obj){
		var tr = $(obj).closest('tr');
		if(tr.attr('sendDownState') != 'unsenddown'){
			myAlert("请选择未下发的任务进行下发!");
			checkRlt = false;
			return false;
		}
		idArr.push(tr.attr('entityId'));
	});
	if(checkRlt){
		myConfirm('确定进行任务下发?',function(r){
			var url = CONTEXT_PATH + "/baseStation/construction/updateConstructState";
			params = {'ids':idArr.join(',')};
			$.post(url,params,function(data){
				if(data.success){
					myAlert("任务下发成功!");
					refreshPage("baseConstructForm","baseConstructDiv",$("#baseConstructForm_pageIndex").val());
					return;
				}
				myAlert("任务下发失败!");
			});
		});
	}
}

/**基站详情*/
function baseStationDetail(baseConstructId){
	var url = CONTEXT_PATH + "/baseStation/construction/showBaseStationDetail";
	url += "?baseConstructId="+baseConstructId;
	var title = "查看基站详情";
	url += "&isQuery=true";
	openTab("baseStationDetail",title,url);
}

/**
 * 验收
 */
function showCheck(sender){
	url = CONTEXT_PATH + "/baseStation/construction/showCheck",
	params = {baseConstructId:sender};
	dom = $("<div/>");
	dom.load(url,params,function(){
		dialog({
			title : "验收信息",
			content : dom,
			width:800
		}).showModal();
	});
}

/**
 * 备案
 */
function showRecord(sender){
	url = CONTEXT_PATH + "/baseStation/construction/showRecord",
	params = {baseConstructId:sender};
	dom = $("<div/>");
	dom.load(url,params,function(){
		dialog({
			title : "备案信息",
			content : dom,
			width:800
		}).showModal();
	});
}
function showConstuctBuildInfo(baseConstructId, isQuery){
	var url = CONTEXT_PATH + "/baseStation/construction/showConstructBuildInfo" +
			 "?baseConstructId="+baseConstructId +"&isQuery="+true;
	var title = "查看建设信息";
	openTab("constructBuildInfo",title,url);
}