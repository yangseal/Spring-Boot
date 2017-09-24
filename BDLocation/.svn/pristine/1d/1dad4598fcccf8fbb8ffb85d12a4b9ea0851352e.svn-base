<!doctype html>
<html>
<head>
	<#include "/head.ftl"/>
	<script type="text/javascript" src="${rc.contextPath}/public/js/stakeoutPoint/stakeoutPoint.js"></script>
</head>
<body>
<form id="stakeoutPointForm" class="form-horizontal">
	<div class="form-group">
		<label id="stakeoutPointNameLabel" for="stakeoutPointName" class="col-sm-2 control-label">点名称</label>
		<div class="col-sm-7">
			<input type="text" class="form-control" id="stakeoutPointName" name="stakeoutPointName" isNotNull value="<#if stakeoutPoint??>${stakeoutPoint.stakeoutPointName!}<#else></#if>" />
		</div>
		<label id="stakeoutPointNameTip" class="control-label" style="color:red">*</label>
	</div>
	<#if !RequestParameters["affiliationPointTypeId"]?? || RequestParameters["affiliationPointTypeId"]=="">
	<div class="form-group has-feedback">
		<label id="affiliationPointTypeLabel" for="affiliationPointType" class="col-sm-2 control-label">所属点类型</label>
		<div class="col-sm-7">
			<input type="text" class="form-control" style="cursor:pointer" id="affiliationPointType" name="affiliationPointType" isNotNull value="<#if stakeoutPoint?? && stakeoutPoint.affiliationPointType??>${stakeoutPoint.affiliationPointType.pointTypeName!}</#if>" onclick="selectAffiliationPointType();" />
			<span class="glyphicon glyphicon-menu-hamburger form-control-feedback"></span>
		</div>
		<label id="affiliationPointTypeTip" class="control-label" style="color:red">*</label>
	</div>
	</#if>
	<input type="hidden" id="affiliationPointTypeId" name="affiliationPointTypeId" value="<#if stakeoutPoint?? && stakeoutPoint.affiliationPointType??>${stakeoutPoint.affiliationPointType.pointTypeId!}<#else>${RequestParameters["affiliationPointTypeId"]!}</#if>" />
	<div class="form-group">
		<label id="altitudeLabel" for="altitude" class="col-sm-2 control-label">高程</label>
		<div class="col-sm-7">
			<input type="text" class="form-control" id="altitude" name="altitude" validateExp="^\d+(\.\d+)?$" validateTip="请输入数字" value="<#if stakeoutPoint?? && stakeoutPoint.altitude??>${stakeoutPoint.altitude?c}<#else></#if>" />
		</div>
		<label id="altitudeTip" class="control-label" style="color:red"></label>
	</div>
	<div class="form-group">
		<label id="longitudeLabel" for="longitude" class="col-sm-2 control-label">经度</label>
		<div class="col-sm-7">
			<input type="text" class="form-control" id="longitude" name="longitude" validateExp="^\d+(\.\d+)?$" validateTip="请输入数字" value="<#if stakeoutPoint?? && stakeoutPoint.longitude??>${stakeoutPoint.longitude?c}<#else></#if>" />
		</div>
		<label id="longitudeTip" class="control-label" style="color:red"></label>
	</div>
	<div class="form-group">
		<label id="latitudeLabel" for="latitude" class="col-sm-2 control-label">纬度</label>
		<div class="col-sm-7">
			<input type="text" class="form-control" id="latitude" name="latitude" validateExp="^\d+(\.\d+)?$" validateTip="请输入数字" value="<#if stakeoutPoint?? && stakeoutPoint.latitude??>${stakeoutPoint.latitude?c}<#else></#if>" />
		</div>
		<label id="latitudeTip" class="control-label" style="color:red"></label>
	</div>
	<div class="form-group">
		<label id="coordinateXLabel" for="coordinateX" class="col-sm-2 control-label">城建坐标X</label>
		<div class="col-sm-7">
			<input type="text" class="form-control" id="coordinateX" name="coordinateX" validateExp="^\d+(\.\d+)?$" validateTip="请输入数字" value="<#if stakeoutPoint?? && stakeoutPoint.coordinateX??>${stakeoutPoint.coordinateX?c}<#else></#if>" />
		</div>
		<label id="coordinateXTip" class="control-label" style="color:red"></label>
	</div>
	<div class="form-group">
		<label id="coordinateYLabel" for="coordinateY" class="col-sm-2 control-label">城建坐标Y</label>
		<div class="col-sm-7">
			<input type="text" class="form-control" id="coordinateY" name="coordinateY" validateExp="^\d+(\.\d+)?$" validateTip="请输入数字" value="<#if stakeoutPoint?? && stakeoutPoint.coordinateY??>${stakeoutPoint.coordinateY?c}<#else></#if>" />
		</div>
		<label id="coordinateYTip" class="control-label" style="color:red"></label>
	</div>
	<div class="form-group has-feedback">
		<label id="createDateLabel" for="createDate" class="col-sm-2 control-label">创建日期</label>
		<div class="col-sm-7">
			<input type="text" class="form-control" id="createDate" name="createDate" isNotNull value="<#if stakeoutPoint??>${stakeoutPoint.createDate!}<#else>${.now?string("yyyy-MM-dd HH:mm:ss")}</#if>" onclick="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm:ss'});" />
			<span class="glyphicon glyphicon-menu-hamburger form-control-feedback"></span>
		</div>
		<label id="createDateTip" class="control-label" style="color:red">*</label>
	</div>
	<#if !RequestParameters["stakeoutTaskId"]?? || RequestParameters["stakeoutTaskId"]=="">
	<div class="form-group has-feedback">
		<label id="affiliationStakeoutTaskLabel" for="affiliationStakeoutTask" class="col-sm-2 control-label">所属放样任务</label>
		<div class="col-sm-7">
			<input type="text" class="form-control" style="cursor:pointer" id="affiliationStakeoutTask" name="affiliationStakeoutTask" isNotNull value="<#if stakeoutPoint?? && stakeoutPoint.affiliationStakeoutTask??>${stakeoutPoint.affiliationStakeoutTask.stakeoutTaskName!}</#if>" onclick="selectAffiliationStakeoutTask();" />
			<span class="glyphicon glyphicon-menu-hamburger form-control-feedback"></span>
		</div>
		<label id="affiliationStakeoutTaskTip" class="control-label" style="color:red">*</label>
	</div>
	</#if>
	<input type="hidden" id="affiliationStakeoutTaskId" name="affiliationStakeoutTaskId" value="<#if stakeoutPoint?? && stakeoutPoint.affiliationStakeoutTask??>${stakeoutPoint.affiliationStakeoutTask.stakeoutTaskId!}<#else>${RequestParameters["stakeoutTaskId"]!}</#if>" />
	<input type="hidden" id="stakeoutPointId" name="stakeoutPointId" value="<#if stakeoutPoint??>${stakeoutPoint.stakeoutPointId!}</#if>" />
</form>
<#if !RequestParameters["isQuery"]?? || RequestParameters["isQuery"]=="">
<div style="text-align:center">
	<a  class="btn btn-success" onclick="saveStakeoutPoint();">
		<i class="glyphicon glyphicon-save"></i>
		<span>保存</span>
	</a>
</div>
</#if>
</body>
</html>