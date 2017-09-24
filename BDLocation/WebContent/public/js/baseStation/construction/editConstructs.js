$(function(){
	refreshPage("baseConstructForm","baseConstructDiv");
	$("#isQuery").val($.QueryString("isQuery"));
	selectAddressInput();
	
	uploadFile([{divId:'recordAttaches',
		 isQuery:"true",
		 entityName:'recordAttaches',
		 fieldName:'recordAttaches',
		 entityId:$('#baseConstructId').val()
	  }]);
	showValue("powerName","powerCondition");
	showValue("netGName","netConfig");
	showValue("netCName","netCondition");
	showValue("netTName","netType");
});

function showValue(name,id){
	var val = "";
	$("input[name='"+name+"']").each(function(index,item){
		val += $(item).val()+" ";
	});
	$("#"+id+"").val(val);
}

function addrInitSelectTime(){
	var addrEndTime=$dp.$('addrEndTime');
	WdatePicker({dateFmt:'yyyy-MM-dd HH:mm:ss',onpicked: function(){addrEndTime.click();}});
}

function buildInitSelectTime(){
	var buildEndTime=$dp.$('buildEndTime');
	WdatePicker({dateFmt:'yyyy-MM-dd HH:mm:ss',onpicked: function(){buildEndTime.click();}});
}

function testInitSelectTime(){
	var addrEndTime=$dp.$('addrEndTime');
	WdatePicker({dateFmt:'yyyy-MM-dd HH:mm:ss',onpicked: function(){addrEndTime.click();}});
}

function editConstructBuildInfo(baseConstructId,isQuery){
	var url = CONTEXT_PATH + "/baseStation/construction/showConstructBuildInfo";
	var title = "编辑建设信息";
	if(baseConstructId){
		url += "?baseConstructId=" + baseConstructId;
		title = "编辑建设信息";
	}
	if(isQuery){
		url += "&isQuery=true";
		title = "查看建设信息";
	}
	if($.QueryString()){
		if(url.indexOf("?")>0){
			url += "&";
		}else{
			url += "?";
		}
		url += $.QueryString()._queryString_;
	}
	openTab("constructBuildInfo",title,url);
}

/**选址资料填写 */
function selectAddressInput(){
	var url = CONTEXT_PATH + "/baseStation/construction/showAddressInput",
		params = {"baseConstructId":$("#baseConstructId").val()};
	loadContent(url, params);
}

/**基建资料填写 */
function baseBuildInfoInput(){
	var url = CONTEXT_PATH + "/baseStation/construction/showBuildInfoInput",
	params = {"baseConstructId":$("#baseConstructId").val()};
	loadContent(url, params);
}

/**测试资料填写 */
function baseTestInfoInput(){
	var url = CONTEXT_PATH + "/baseStation/construction/showTestInfoInput",
		params = {"baseConstructId":$("#baseConstructId").val()};
	loadContent(url, params);
}

/**基站验收资料填写 */
function baseValidateInfoInput(){
	var url = CONTEXT_PATH + "/baseStation/construction/showValidateInfoInput",
	params = {"baseConstructId":$("#baseConstructId").val()};
	loadContent(url, params);
}

function loadContent(url,params){
	params.isQuery = $("#isQuery").val();
	$("#changeContentRegion").load(url,params,function(){
	});
}
/** /baseStation/customer/showProject?projectId=4028811d58ddbdb80158ddc29d110004   */
function showProjectDetail(projectId){
	
	var url = CONTEXT_PATH + "/baseStation/customer/showProject";
	var title = "查看项目";
		url += "?projectId=" + projectId + "&isQuery=true";
	openTab("project",title,url);
}
