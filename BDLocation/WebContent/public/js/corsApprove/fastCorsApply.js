$(function(){
	$("#inputAccountPeriod").focus(function(){
		$("input:radio[name='accountPeriod']").attr("checked",false); 
	});
	
	$('input:radio[name="accountPeriod"]').focus(function(){
		$('#inputAccountPeriod').val('');
	});
	
	
	//默认选中正式，隐藏使用期限
	$("div#col-sm-6_test").hide();
	$("#accountTypeTest").focus(function(){
		$("div#col-sm-6_test").show();
		$("div#col-sm-6_formal").hide();
		selectList.length = 0;
		displayRightRegion();
	});
	$("#accountTypeFormal").focus(function(){
		$("div#col-sm-6_test").hide();
		$("div#col-sm-6_formal").show();
		selectList.length = 0;
		displayRightRegion();
	});
});

function selectCompany(){
	var dom = $("<div fkFieldCode='company'/>");
	var url = CONTEXT_PATH + "/company/selectCompany";
	dom.load(url,null,function(){
		dialog({
			id:'company',
			title : "选择申请企业",
			content : dom
		}).showModal();
	});
}

var selectList = [];
function addRightCard(){
	var companyId = $("#companyId").val(),
		applyCount = $("#applyCount").val(),
		bdDeviceAccuracy = $('input:radio[name="bdDeviceAccuracy"]:checked').val(),
		bdDeviceAccuracyName = $('input:radio[name="bdDeviceAccuracy"]:checked').attr('nameValue'),
		accountType = $('input:radio[name="accountType"]:checked').val(),
		accountTypeName = $('input:radio[name="accountType"]:checked').attr('nameValue'),
		accountPeriod = $('input:radio[name="accountPeriod"]:checked').val(),
		inputAccountPeriod = $('#inputAccountPeriod').val();
	if(!companyId){
		myAlert("请选择申请公司!");
		return ;
	}
	if(!applyCount){
		myAlert("请输入申请数量!");
		return ;
	}
	if(!bdDeviceAccuracy){
		myAlert("请选择入网精度!");
		return ;
	}
	if(!accountType){
		myAlert("请选择账号类型!");
		return ;
	}
	if(accountType == 'formal' && !accountPeriod && !inputAccountPeriod){
		myAlert("请选择或输入使用期限!");
		return ;
	}
	_accountPeriod = accountType == 'formal' ?(accountPeriod?accountPeriod:inputAccountPeriod) :'3个月' ;
	if(selectList.length == 0){
		var obj = {};
		obj.companyId = companyId;
		obj.applyCount = applyCount;
		obj.bdDeviceAccuracy = bdDeviceAccuracy;
		obj.bdDeviceAccuracyName = bdDeviceAccuracyName;
		obj.accountType = accountType;
		obj.accountTypeName = accountTypeName;
		obj.accountPeriod = _accountPeriod;
		selectList.push(obj);
	}else{
		var checkRlt = false;
		for(var i=0,len=selectList.length; i<len; i++){
			if(selectList[i].bdDeviceAccuracy == bdDeviceAccuracy 
					&& selectList[i].accountType == accountType
					&& selectList[i].accountPeriod == _accountPeriod){
				selectList[i].applyCount = (selectList[i].applyCount-0)+(applyCount-0);
				checkRlt = true;
				break;
			}
		}
		if(!checkRlt){
			var obj = {};
			obj.companyId = companyId;
			obj.applyCount = applyCount;
			obj.bdDeviceAccuracy = bdDeviceAccuracy;
			obj.bdDeviceAccuracyName = bdDeviceAccuracyName;
			obj.accountType = accountType;
			obj.accountTypeName = accountTypeName;
			obj.accountPeriod = _accountPeriod;
			selectList.push(obj);
		}
	}
	displayRightRegion();
}

function displayRightRegion(){
	var rightServiceRegionTable = $("#rightServiceRegionTable");
	$("#rightServiceRegionTable tr:gt(1)").remove();
	if(selectList.length >0){
		for(var i=0,len=selectList.length; i<len; i++){
			var rightServiceRegionTr = $("#rightServiceRegionTr").clone().removeAttr("style").attr("indexId",i);
			rightServiceRegionTr.find("td[name='bdDeviceAccuracy']").text(selectList[i].bdDeviceAccuracyName);
			rightServiceRegionTr.find("td[name='accountPeriod']").text(selectList[i].accountPeriod);
			rightServiceRegionTr.find("td[name='accountType']").text(selectList[i].accountTypeName);
			rightServiceRegionTr.find("td[name='applyCount']").text(selectList[i].applyCount);
			rightServiceRegionTable.append(rightServiceRegionTr);
		}
	}
}

function delSelectList(self,index){
	var targetTr = $(self).closest('tr');
	selectList.splice(targetTr.attr('entityId'),1);
	targetTr.remove();
	displayRightRegion();
}
/**
 * 提交快速 cors申请
 */
function saveFastCorsApply(){
	var applyParam = "",
		companyId = "",
		url = CONTEXT_PATH + "/fastApply/submitCorsApply";
		params = {};
	if(selectList.length > 0){
		for(var i=0,len=selectList.length; i<len; i++){
			if(!companyId){
				companyId = selectList[i].companyId;
			}
			var obj = selectList[i];
			applyParam = applyParam + selectList[i].bdDeviceAccuracy +",";
			applyParam = applyParam + selectList[i].accountType +",";
			applyParam = applyParam + selectList[i].accountPeriod +",";
			applyParam = applyParam + selectList[i].applyCount +"#";
		}
	}
	params = {'applyData':applyParam.substring(0,applyParam.length-1),'companyId':companyId};
	commonPost(url,params,function(data){
		if(data.success){
			myAlert("申请成功!");
			return ;
		}
		myAlert("申请失败!");
	});
	
}