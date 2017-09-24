<!doctype html>
<html>
<head>
<#include "/head.ftl"/>
<script type="text/javascript" src="${rc.contextPath}/public/js/oamProjectTesting/oamProjectTesting.js"></script>
</head>
<body>
<#if RequestParameters["oamProjectTestingId"]??>
<ul class="nav nav-tabs" role="tablist">
    <li role="presentation" class="active"><a href="#basicTab" aria-controls="basicTab" role="tab" data-toggle="tab">基础信息</a></li>
    <li role="presentation"><a href="#oamStationTestingsTab" aria-controls="oamStationTestingsTab" role="tab" data-toggle="tab">基站测试</a></li>
</ul>
<div class="tab-content">
    <div role="tabpanel" class="tab-pane active" id="basicTab">
</#if>

<form id="oamProjectTestingForm" class="form-horizontal">
	<#if !RequestParameters["oamProjectId"]?? || RequestParameters["oamProjectId"]=="">
	<div class="form-group has-feedback pt15">
		<label id="oamProjectLabel" for="oamProject" class="col-sm-1 control-label">所属项目</label>
		<div class="col-sm-7">
			<input type="text" class="form-control" style="cursor:pointer" id="oamProject" name="oamProject" value="<#if oamProjectTesting?? && oamProjectTesting.oamProject??>${oamProjectTesting.oamProject.oamProjectName!}</#if>" onclick="selectOamProject();" />
			<span class="glyphicon glyphicon-menu-hamburger form-control-feedback"></span>
		</div>
		<label id="oamProjectTip" class="control-label" style="color:red"></label>
	</div>
	</#if>
	<input type="hidden" id="oamProjectId" name="oamProject.oamProjectId" value="<#if oamProjectTesting?? && oamProjectTesting.oamProject??>${oamProjectTesting.oamProject.oamProjectId!}<#else>${RequestParameters["oamProjectId"]!}</#if>" />
	<div class="form-group">
		<label id="oamProjectTestingNameLabel" for="oamProjectTestingName" class="col-sm-1 control-label">项目测试名称</label>
		<div class="col-sm-7">
			<input type="text" class="form-control" id="oamProjectTestingName" name="oamProjectTestingName" value="<#if oamProjectTesting??>${oamProjectTesting.oamProjectTestingName!}<#else></#if>" />
		</div>
		<label id="oamProjectTestingNameTip" class="control-label" style="color:red"></label>
	</div>
	<div class="form-group">
		<label id="testingScheduleLabel" for="testingSchedule" class="col-sm-1 control-label">测试日程描述</label>
		<div class="col-sm-7">
			<input type="text" class="form-control" id="testingSchedule" name="testingSchedule" value="<#if oamProjectTesting??>${oamProjectTesting.testingSchedule!}<#else></#if>" />
		</div>
		<label id="testingScheduleTip" class="control-label" style="color:red"></label>
	</div>
	<div class="form-group">
		<label id="planScheduleLabel" for="planSchedule" class="col-sm-1 control-label">初拟基建日程描述</label>
		<div class="col-sm-7">
			<input type="text" class="form-control" id="planSchedule" name="planSchedule" value="<#if oamProjectTesting??>${oamProjectTesting.planSchedule!}<#else></#if>" />
		</div>
		<label id="planScheduleTip" class="control-label" style="color:red"></label>
	</div>
	<div class="form-group">
		<label id="scheduleLabel" for="schedule" class="col-sm-1 control-label">确定基建日程描述</label>
		<div class="col-sm-7">
			<input type="text" class="form-control" id="schedule" name="schedule" value="<#if oamProjectTesting??>${oamProjectTesting.schedule!}<#else></#if>" />
		</div>
		<label id="scheduleTip" class="control-label" style="color:red"></label>
	</div>
	<input type="hidden" id="oamProjectTestingId" name="oamProjectTestingId" value="<#if oamProjectTesting??>${oamProjectTesting.oamProjectTestingId!}</#if>" />
</form>
<#if !RequestParameters["isQuery"]?? || RequestParameters["isQuery"]=="">
<div class="card-page-command">
  <label class="col-sm-1 control-label"></label>
      <div class="col-sm-7" style="text-align:center;">
	<a  class="btn btn-success" onclick="saveOamProjectTesting();">
		<i class="glyphicon glyphicon-save"></i>
		<span>保存</span>
	</a>
	</div>
</div>
</#if>

<#if RequestParameters["oamProjectTestingId"]??>
	</div>
<div role="tabpanel" class="tab-pane" id="oamStationTestingsTab">
   	<iframe code="oamStationTestings" frameborder=0 width="100%" src="${rc.contextPath}/oamStationTesting/showOamStationTestings?${rc.queryString!}" />
</div>
</div>
</#if>
</body>
</html>