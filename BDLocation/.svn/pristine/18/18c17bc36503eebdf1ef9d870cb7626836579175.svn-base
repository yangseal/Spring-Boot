<!doctype html>
<html>
<head>
	<#include "/head.ftl"/>
	<script type="text/javascript" src="${rc.contextPath}/public/js/stakeoutTask/stakeoutTask.js"></script>
</head>
<body>
<#if RequestParameters["stakeoutTaskId"]??>
<ul class="nav nav-tabs" role="tablist">
    <li role="presentation" class="active"><a href="#basicTab" aria-controls="basicTab" role="tab" data-toggle="tab">基础信息</a></li>
    <li role="presentation"><a href="#stakeoutPointsTab" aria-controls="stakeoutPointsTab" role="tab" data-toggle="tab">放样点列表</a></li>
</ul>
<div class="tab-content">
    <div role="tabpanel" class="tab-pane active" id="basicTab">
	</#if>
	<form id="stakeoutTaskForm" class="form-horizontal">
		<div class="form-group pt15">
			<label id="stakeoutTaskNameLabel" for="stakeoutTaskName" class="col-sm-2 control-label">任务名称</label>
			<div class="col-sm-8">
				<input type="text" class="form-control" id="stakeoutTaskName" name="stakeoutTaskName" isNotNull value="<#if stakeoutTask??>${stakeoutTask.stakeoutTaskName!}<#else></#if>" />
			</div>
		<label id="stakeoutTaskNameTip" class="control-label" style="color:red">*</label>
		</div>
		<div class="form-group">
			<label id="taskTypeLabel" for="taskType" class="col-sm-2 control-label">任务类型</label>
			<div class="col-sm-8">
				<select class="form-control" id="taskType" name="taskType" isNotNull>
					<option></option>
					<option <#if stakeoutTask?? && "point"==stakeoutTask.taskType || !stakeoutTask?? && "point"=="point">selected</#if> value="point">点</option>
					<option <#if stakeoutTask?? && "line"==stakeoutTask.taskType || !stakeoutTask?? && "line"=="point">selected</#if> value="line">线</option>
				</select>
			</div>
			<label id="taskTypeTip" class="control-label" style="color:red">*</label>
		</div>
		<#if !RequestParameters["stakeoutTaskId"]??>
			<div class="form-group" style = "display:none;">
			<label id="taskStatusLabel" for="taskStatus" class="col-sm-2 control-label">任务状态</label>
			<div class="col-sm-8">
				<select class="form-control" id="taskStatus" name="taskStatus" isNotNull>
					<option <#if stakeoutTask?? && "newTask"==stakeoutTask.taskStatus || !stakeoutTask?? && "newTask"=="newTask">selected</#if> value="newTask">新任务</option>
				</select>
			</div>
			<label id="taskStatusTip" class="control-label" style="color:red">*</label>
		    </div>
		</#if>
		<#if RequestParameters["stakeoutTaskId"]??>
		    <div class="form-group">
			<label id="taskStatusLabel" for="taskStatus" class="col-sm-2 control-label">任务状态</label>
			<div class="col-sm-8">
				<select class="form-control" id="taskStatus" name="taskStatus" isNotNull>
					<option></option>
					<option <#if stakeoutTask?? && "newTask"==stakeoutTask.taskStatus || !stakeoutTask?? && "newTask"=="newTask">selected</#if> value="newTask">新任务</option>
					<option <#if stakeoutTask?? && "issued"==stakeoutTask.taskStatus || !stakeoutTask?? && "issued"=="newTask">selected</#if> value="issued">已下发</option>
				</select>
			</div>
			<label id="taskStatusTip" class="control-label" style="color:red">*</label>
		    </div>
		</#if>
		<div class="form-group has-feedback">
			<label id="createDateLabel" for="createDate" class="col-sm-2 control-label">创建时间</label>
			<div class="col-sm-8">
				<input type="text" class="form-control" id="createDate" name="createDate" isNotNull value="<#if stakeoutTask??>${stakeoutTask.createDate!}<#else>${.now?string("yyyy-MM-dd HH:mm:ss")}</#if>" onclick="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm:ss'});" />
				<span class="glyphicon glyphicon-menu-hamburger form-control-feedback"></span>
			</div>
		<label id="createDateTip" class="control-label" style="color:red">*</label>
		</div>
		<#if !RequestParameters["createUserId"]?? || RequestParameters["createUserId"]=="">
		<div class="form-group has-feedback">
			<label id="createUserLabel" for="createUser" class="col-sm-2 control-label">创建人</label>
			<div class="col-sm-8">
				<input type="text" class="form-control" style="cursor:pointer" id="createUser" name="createUser" isNotNull value="<#if stakeoutTask?? && stakeoutTask.createUser??>${stakeoutTask.createUser.userName!}<#else>${Session["CURRENT_USER"].userName!}</#if>" onclick="selectCreateUser();" />
				<span class="glyphicon glyphicon-menu-hamburger form-control-feedback"></span>
			</div>
			<label id="createUserTip" class="control-label" style="color:red">*</label>
		</div>
		</#if>
		<input type="hidden" id="createUserId" name="createUserId" value="<#if stakeoutTask?? && stakeoutTask.createUser??>${stakeoutTask.createUser.userId!}<#elseif RequestParameters["createUserId"]??>${RequestParameters["createUserId"]!}<#else>${Session["CURRENT_USER"].userId}</#if>" />
		<#if common.isSystemUser>
		<div class="form-group has-feedback">
			<label id="affiliationCompanyLabel" for="affiliationCompany" class="col-sm-2 control-label">所属企业</label>
			<div class="col-sm-8">
				<input type="text" class="form-control" style="cursor:pointer" id="affiliationCompany" name="affiliationCompany" isNotNull value="<#if stakeoutTask?? && stakeoutTask.affiliationCompany??>${stakeoutTask.affiliationCompany.companyName!}</#if>" onclick="selectAffiliationCompany();" />
				<span class="glyphicon glyphicon-menu-hamburger form-control-feedback"></span>
		 	</div>
			<label id="affiliationCompanyTip" class="control-label" style="color:red">*</label>
		</div>
		</#if>
		<div class="form-group has-feedback">
			<label id="conversionParamIdLabel" for="conversionParam" class="col-sm-2 control-label">转换地区</label>
			<div class="col-sm-8">
				<input type="text" class="form-control" style="cursor:pointer" id="conversionParam" name="conversionParam" value="<#if stakeoutTask?? && stakeoutTask.conversionParam??>${stakeoutTask.conversionParam.conversionParamName!}</#if>" onclick="selectConversionArea();" />
				<span class="glyphicon glyphicon-menu-hamburger form-control-feedback"></span>
		 	</div>
			<label id="conversionParamTip" class="control-label" style="color:red"></label>
		</div>
		<input type="hidden" id="conversionParamId" name="conversionParamId" value="<#if stakeoutTask?? && stakeoutTask.conversionParam??>${stakeoutTask.conversionParam.conversionParamId!}</#if>" />
		<input type="hidden" id="affiliationCompanyId" name="affiliationCompanyId" value="<#if stakeoutTask?? && stakeoutTask.affiliationCompany??>${stakeoutTask.affiliationCompany.companyId!}<#elseif !common.isSystemUser>${CURRENT_USER.company.companyId!}</#if>" />
		<input type="hidden" id="stakeoutTaskId" name="stakeoutTaskId" value="<#if stakeoutTask??>${stakeoutTask.stakeoutTaskId!}</#if>" />
	</form>
	<#if !RequestParameters["isQuery"]?? || RequestParameters["isQuery"]=="">
	<div class="form-group">
	  <label class="col-sm-2 control-label"></label>
      <div class="col-sm-8" style="text-align:center;">
		<a  class="btn btn-success" onclick="saveStakeoutTask();">
			<i class="glyphicon glyphicon-save"></i>
			<span>保存</span>
		</a>
		</div>
	</div>
	</#if>
	<#if RequestParameters["stakeoutTaskId"]??>
	</div>
	<div role="tabpanel" class="tab-pane" id="stakeoutPointsTab">
   		<iframe code="stakeoutPoints" frameborder=0 width="100%" src="${rc.contextPath}/stakeoutPoint/showStakeoutPoints?${rc.queryString!}" />
	</div>
</div>
</#if>
</body>
</html>