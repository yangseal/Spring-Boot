/** 放置 baseStation 下通用的js方法*/
$(function(){
	//备案附件初始化
	uploadFile([{divId:'recordAttaches',
				 isQuery:"",
				 entityName:'recordAttaches',
				 fieldName:'recordAttaches',
				 entityId:$('#baseConstructId').val()
			  }]);
});

/**
 * 基站客户选择
 */
function selectBaseCustomer(){
	var dom = $("<div fkFieldCode='baseCustomer'/>");
	var url = CONTEXT_PATH + "/baseStation/selector/selectBaseCustomer";
	dom.load(url,null,function(){
		dialog({
			id:'baseCustomer',
			title : "选择所属客户",
			content : dom
		}).showModal();
	});
}

/**
 * 基站项目选择
 */
function selectBaseProject(){
	var dom = $("<div fkFieldCode='baseProject'/>");
	var url = CONTEXT_PATH + "/baseStation/selector/selectBaseProject";
	dom.load(url,null,function(){
		dialog({
			id:'baseProject',
			title : "选择所属项目",
			content : dom
		}).showModal();
	});
}

/**
 * 选择 供应商
 */
function selectBaseProvider(){
	var dom = $("<div fkFieldCode='_baseProviders'/>");
	var url = CONTEXT_PATH + "/baseStation/selector/selectBaseProvider";
	dom.load(url,null,function(){
		dialog({
			id:'_baseProviders',
			title : "选择所属供应商",
			content : dom
		}).showModal();
	});
}

/**
 * 选择 服务合同
 */
function selectCustomerContract(baseCustomerId){
	var dom = $("<div fkFieldCode='baseCustomerContract'/>");
	var url = CONTEXT_PATH + "/baseStation/selector/selectCustomerContract";
	url += "?baseCustomerId="+baseCustomerId;
	dom.load(url,null,function(){
		dialog({
			id:'baseCustomerContract',
			title : "选择服务合同",
			content : dom
		}).showModal();
	});
}

/**
* 验收 -- 通过
* 
* 对象	 baseConstruct
* 结果：通过 、 驳回
*/
function baseCheckApprove(sender){
	var tips = "您确定通过验收吗?",
		url = CONTEXT_PATH + "/baseStation/construction/baseCheckApprove";
	if(sender == 'NO') tips = "您确定驳回验收吗?";
	myConfirm(tips, function(){
		var _params = $('#baseConstructCheckForm').serialize();
			params = _params + "&approveRlt="+sender;
		$.post(url,params,function(data){
			if(data.success){
				myAlert("操作成功!");
				$("#footer").hide();
				refreshPage("baseConstructForm","baseConstructDiv");
				return ;
			}
			myAlert("操作失败!");
		});
	});
}

/**
* 备案 -- 保存
*/
function saveRecordInfo(){
	if(!validateForm("constructRecordForm")){
		return;
	}
	var url = CONTEXT_PATH + "/baseStation/construction/saveConstructRecordInfo",
		params = $("#constructRecordForm").serialize();
	$.post(url,params,function(data){
		if(data.success){
			myAlert("操作成功!");
			refreshPage("baseConstructForm","baseConstructDiv");
			return;
		}
		myAlert("操作失败!");
	});
}