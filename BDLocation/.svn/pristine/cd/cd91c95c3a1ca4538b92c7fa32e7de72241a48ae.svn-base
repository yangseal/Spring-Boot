<!doctype html>
<html>
<head>
<#include "/head.ftl"/>
<script type="text/javascript" src="${rc.contextPath}/public/js/baseStation/customer/showProjects.js"></script>
<script type="text/javascript" src="${rc.contextPath}/public/js/baseStation/baseStation.js"></script>
</head>
<body>
<form id="projectForm" class="form-horizontal">
	<div class="form-group pt15">
		<label id="projectNoLabel" for="projectNo" class="col-sm-2 control-label">项目编号</label>
		<div class="col-sm-8">
			<input type="text" class="form-control" id="projectNo" name="projectNo" value="<#if project??>${project.projectNo!}</#if>" isNotNull />
		</div>
		<label id="projectNoTip" class="control-label" style="color:red">*</label>
	</div>
	<div class="form-group">
		<label id="projectNameLabel" for="projectName" class="col-sm-2 control-label">项目名称</label>
		<div class="col-sm-8">
			<input type="text" class="form-control" id="projectName" name="projectName" value="<#if project??>${project.projectName!}</#if>" isNotNull />
		</div>
		<label id="projectNameTip" class="control-label" style="color:red">*</label>
	</div>
	<div class="form-group">
		<label id="planNumberLabel" for="planNumber" class="col-sm-2 control-label">基站规划数量</label>
		<div class="col-sm-8">
			<input type="number" min="1" maxlength="3" class="form-control" id="planNumber" name="planNumber" value="<#if project??>${project.planNumber!}</#if>"  />
		</div>
		<label id="planNumberTip" class="control-label" style="color:red"></label>
	</div>
	<#--<div class="form-group">
		<label id="custUserTelLabel" for="custUserTel" class="col-sm-2 control-label">项目客户负责人</label>
		<div class="col-sm-8">
			<input type="text" class="form-control" id="custUserTel" name="custUserTel" value="<#if project??>${project.custUserTel!}</#if>" isNotNull />
		</div>
		<label id="custUserTelTip" class="control-label" style="color:red">*</label>
	</div>
	<div class="form-group">
		<label id="custUserEmailLabel" for="custUserEmail" class="col-sm-2 control-label">客户负责人电话</label>
		<div class="col-sm-8">
			<input type="text" class="form-control" id="custUserEmail" name="custUserEmail" validateExp="(^(1\d{10})$|^((\d{7,8})|(\d{4}|\d{3})-(\d{7,8})|(\d{4}|\d{3})-(\d{7,8})-(\d{4}|\d{3}|\d{2}|\d{1})|(\d{7,8})-(\d{4}|\d{3}|\d{2}|\d{1}))$)" value="<#if project??>${project.custUserEmail!}</#if>" isNotNull/>
		</div>
		<label id="custUserEmailTip" class="control-label" style="color:red">*</label>
	</div> -->
	<div class="form-group has-feedback">
		<label id="startDateLabel" for="startDate" class="col-sm-2 control-label">立项时间</label>
		<div class="col-sm-8">
			<input type="text" class="form-control" id="startDate" name="startDate" readOnly  value="<#if project??>${project.startDate}<#else>${.now?string("yyyy-MM-dd HH:mm:ss")}</#if>" onclick="initSelectTime();" />
			<span class="glyphicon glyphicon-menu-hamburger form-control-feedback"></span>
		</div>
		<label id="startDateTip" class="control-label" style="color:red"></label>
	</div>
	<div class="form-group has-feedback">
		<label id="endDateLabel" for="endDate" class="col-sm-2 control-label">结项时间</label>
		<div class="col-sm-8">
			<input type="text" class="form-control" id="endDate" name="endDate" readOnly  value="<#if project??>${project.endDate!}</#if>" onclick="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm:ss',minDate:'#F{$dp.$D(\'startDate\')}'})" />
			<span class="glyphicon glyphicon-menu-hamburger form-control-feedback"></span>
		</div>
		<label id="endDateTip" class="control-label" style="color:red"></label>
	</div>
	<div class="form-group has-feedback">
		<label id="baseCustomerContractLabel" for="baseCustomerContract" class="col-sm-2 control-label">所属合同</label>
		<div class="col-sm-8">
			<input type="text" class="form-control" style="cursor:pointer" readOnly id="baseCustomerContract"  value="<#if project?? && project.baseCustomerContract??>${project.baseCustomerContract.custContractName!}</#if>" onclick="selectCustomerContract('<#if baseCustomerId??>${baseCustomerId!}</#if>');" isNotNull/>
			<span class="glyphicon glyphicon-menu-hamburger form-control-feedback"></span>
			<input type="hidden" id="baseCustomerContractId" name="baseCustomerContract.baseCustomerContractId" value="<#if project?? && project.baseCustomerContract??>${project.baseCustomerContract.baseCustomerContractId!}</#if>" />
		</div>
		<label id="baseCustomerContractTip" class="control-label" style="color:red">*</label>
	</div>
	<div class="form-group">
		<label id="projectRemarkLabel" for="projectRemark" class="col-sm-2 control-label">备注</label>
		<div class="col-sm-8">
			<input type="text" class="form-control" id="projectRemark" name="projectRemark" value="<#if project??>${project.projectRemark!}</#if>" />
		</div>
		<label id="projectRemarkTip" class="control-label" style="color:red"></label>
	</div>
	<input type="hidden" name="baseProjectId" id="baseProjectId" value="<#if project??>${project.baseProjectId!}</#if>">
	<input type="hidden" name="baseCustomer.baseCustomerId" id="baseCustomer" value="">
	<input type="hidden" name="createTime" id="createTime" value="<#if project??>${project.createTime!}</#if>">
	<input type="hidden" name="createUser" id="createUser" value="<#if project??>${project.createUser!}</#if>">
</form>
<#if !RequestParameters["isQuery"]?? || RequestParameters["isQuery"]=="">
<div class="form-group">
      <label class="col-sm-2 control-label"></label>
      <div class="col-sm-8" style="text-align:center;">
	<a  class="btn btn-success" onclick="saveProject();">
		<i class="glyphicon glyphicon-save"></i>
		<span>保存</span>
	</a>
	</div>
</div>
</#if>
</body>
</html>