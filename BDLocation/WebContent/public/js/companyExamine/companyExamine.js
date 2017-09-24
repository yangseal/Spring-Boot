//打开页面即执行查询
$(function(){
	refreshPage("companyExamineForm","companyExamineDiv");
});
function showCompanyTemp(busiApproveId,isQuery){
	var url = CONTEXT_PATH + "/companyExamine/editExamines";
	var title = "新增注册企业";
	if(busiApproveId){
		url += "?busiApproveId=" + busiApproveId;
		title = "编辑注册企业";
	}
	if(isQuery){
		url += "&isQuery=true";
		title = "查看注册企业";
	}
	if($.QueryString()){
		if(url.indexOf("?")>0){
			url += "&";
		}else{
			url += "?";
		}
		url += $.QueryString()._queryString_;
	}
	openTab("corsBusiApprove",title,url);
}

function viewCompanyExamine(){
	var checkbox = $("input[type='checkbox']:checked",$("#vbusicompayExamineTable"));
	if(checkbox && checkbox.length != 1 ) {
		myAlert("请选择一条数据进行查看");
		return;
	}
	var busiApproveId = $(checkbox[0]).closest('tr').attr('entityId');
	if(!busiApproveId){
		myAlert("请选择待查看注册企业");
		return;
	}
	showCompanyTemp(busiApproveId,true);
}

function editCompanyExamine(){
	var checkbox = $("input[type='checkbox']:checked",$("#vbusicompayExamineTable"));
	if(checkbox && checkbox.length != 1 ) {
		myAlert("请选择一条数据进行审批");
		return;
	}
	var busiApproveId = $(checkbox[0]).closest('tr').attr('entityId');
	var companyMaterialState = getSelectedEntity("vbusicompayExamineTable").attr("entityStatus");
	if(!busiApproveId){
		myAlert("请选择待审批的企业");
		return;
	}
	if(companyMaterialState && "2"==companyMaterialState){
		myAlert("该企业已通过审核");
		return;
	}
	if(companyMaterialState && "3"==companyMaterialState){
		myAlert("该企业审核已拒绝");
		return;
	}
	showCompanyTemp(busiApproveId,false);
}