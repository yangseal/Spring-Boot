<!doctype html>
<html>
<head>
<#include "/head.ftl"/>
<script type="text/javascript" src="${rc.contextPath}/public/js/oamDeviceArchives/oamDeviceArchives.js"></script>
</head>
<body>

<form id="oamDeviceArchivesForm" class="form-horizontal">
	<div class="form-group pt15">
		<label id="oamDeviceArchivesCodeLabel" for="oamDeviceArchivesCode" class="col-sm-2 control-label">设备档案标识号</label>
		<div class="col-sm-8">
			<input type="text" class="form-control" id="oamDeviceArchivesCode" name="oamDeviceArchivesCode" value="<#if oamDeviceArchives??>${oamDeviceArchives.oamDeviceArchivesCode!}<#else></#if>" />
		</div>
		<label id="oamDeviceArchivesCodeTip" class="control-label" style="color:red"></label>
	</div>
	<div class="form-group">
		<label id="oamDeviceArchivesNameLabel" for="oamDeviceArchivesName" class="col-sm-2 control-label">设备档案名称</label>
		<div class="col-sm-8">
			<input type="text" class="form-control" id="oamDeviceArchivesName" name="oamDeviceArchivesName" value="<#if oamDeviceArchives??>${oamDeviceArchives.oamDeviceArchivesName!}<#else></#if>" />
		</div>
		<label id="oamDeviceArchivesNameTip" class="control-label" style="color:red"></label>
	</div>
	<div class="form-group">
		<label id="bindCorsAccountLabel" for="bindCorsAccount" class="col-sm-2 control-label">绑定的基站账号</label>
		<div class="col-sm-8">
			<input type="text" class="form-control" id="bindCorsAccount" name="bindCorsAccount" value="<#if oamDeviceArchives??>${oamDeviceArchives.bindCorsAccount!}<#else></#if>" />
		</div>
		<label id="bindCorsAccountTip" class="control-label" style="color:red"></label>
	</div>
	<div class="form-group has-feedback">
		<label id="createDateLabel" for="createDate" class="col-sm-2 control-label">创建日期</label>
		<div class="col-sm-8">
			<input type="text" class="form-control" id="createDate" name="createDate" value="<#if oamDeviceArchives??>${oamDeviceArchives.createDate!}<#else>${.now?string("yyyy-MM-dd HH:mm:ss")}</#if>" onclick="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm:ss'});" />
			<span class="glyphicon glyphicon-menu-hamburger form-control-feedback"></span>
		</div>
		<label id="createDateTip" class="control-label" style="color:red"></label>
	</div>
	<input type="hidden" id="oamDeviceArchivesId" name="oamDeviceArchivesId" value="<#if oamDeviceArchives??>${oamDeviceArchives.oamDeviceArchivesId!}</#if>" />
</form>
<#if !RequestParameters["isQuery"]?? || RequestParameters["isQuery"]=="">
<div class="card-page-command">
<label class="col-sm-2 control-label"></label>
      <div class="col-sm-8" style="text-align:center;">
	<a  class="btn btn-success" onclick="saveOamDeviceArchives();">
		<i class="glyphicon glyphicon-save"></i>
		<span>保存</span>
	</a>
	</div>
</div>
</#if>

</body>
</html>