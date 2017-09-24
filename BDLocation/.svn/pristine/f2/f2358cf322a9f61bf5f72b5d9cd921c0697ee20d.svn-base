<!doctype html>
<html>
<head>
<#include "/head.ftl"/>
<script type="text/javascript" src="${rc.contextPath}/public/js/conversionProjection/conversionProjection.js"></script>
</head>
<body>

<form id="conversionProjectionForm" class="form-horizontal">
	<div class="form-group">
		<label id="conversionProjectionNameLabel" for="conversionProjectionName" class="col-sm-2 control-label">转换投影名称</label>
		<div class="col-sm-7">
			<input type="text" class="form-control" id="conversionProjectionName" name="conversionProjectionName" isNotNull value="<#if conversionProjection??>${conversionProjection.conversionProjectionName!}<#else></#if>" />
		</div>
		<label id="conversionProjectionNameTip" class="control-label" style="color:red">*</label>
	</div>
	<div class="form-group">
		<label id="conversionProjectionCodeLabel" for="conversionProjectionCode" class="col-sm-2 control-label">转换投影编码</label>
		<div class="col-sm-7">
			<input type="text" class="form-control" id="conversionProjectionCode" name="conversionProjectionCode" isNotNull value="<#if conversionProjection??>${conversionProjection.conversionProjectionCode!}<#else></#if>" />
		</div>
		<label id="conversionProjectionCodeTip" class="control-label" style="color:red">*</label>
	</div>
	<div class="form-group">
		<label id="projectTypeLabel" for="projectType" class="col-sm-2 control-label">投影类型</label>
		<div class="col-sm-7">
			<input type="text" class="form-control" id="projectType" name="projectType" validateExp="^-?[1-9]\d*$" validateTip="投影类型应为整数值" value="<#if conversionProjection??>${conversionProjection.projectType!}<#else></#if>" />
		</div>
		<label id="projectTypeTip" class="control-label" style="color:red"></label>
	</div>
	<div class="form-group">
		<label id="meridianLabel" for="meridian" class="col-sm-2 control-label">中央子午线</label>
		<div class="col-sm-7">
			<input type="text" class="form-control" id="meridian" name="meridian" validateExp="^-?[1-9]\d*$" validateTip="中央子午线应为整数值" value="<#if conversionProjection??>${conversionProjection.meridian!}<#else></#if>" />
		</div>
		<label id="meridianTip" class="control-label" style="color:red"></label>
	</div>
	<div class="form-group">
		<label id="kLabel" for="k" class="col-sm-2 control-label">尺度</label>
		<div class="col-sm-7">
			<input type="text" class="form-control" id="k" name="k" validateExp="^(\d{1,}\.?\d*)$" validateTip="尺度应为数值" value="<#if conversionProjection??>${conversionProjection.k!}<#else></#if>" />
		</div>
		<label id="kTip" class="control-label" style="color:red"></label>
	</div>
	<div class="form-group">
		<label id="xLabel" for="x" class="col-sm-2 control-label">x常数</label>
		<div class="col-sm-7">
			<input type="text" class="form-control" id="x" name="x" validateExp="^(\d{1,}\.?\d*)$" validateTip="x常数应为数值" value="<#if conversionProjection??>${conversionProjection.x!}<#else></#if>" />
		</div>
		<label id="xTip" class="control-label" style="color:red"></label>
	</div>
	<div class="form-group">
		<label id="yLabel" for="y" class="col-sm-2 control-label">y常数</label>
		<div class="col-sm-7">
			<input type="text" class="form-control" id="y" name="y" validateExp="^(\d{1,}\.?\d*)$" validateTip="y常数应为数值" value="<#if conversionProjection??>${conversionProjection.y!}<#else></#if>" />
		</div>
		<label id="yTip" class="control-label" style="color:red"></label>
	</div>
	<div class="form-group">
		<label id="standerdLatLabel" for="standerdLat" class="col-sm-2 control-label">基准纬度</label>
		<div class="col-sm-7">
			<input type="text" class="form-control" id="standerdLat" name="standerdLat" validateExp="^(\d{1,}\.?\d*)$" validateTip="基准纬度应为数值" value="<#if conversionProjection??>${conversionProjection.standerdLat!}<#else></#if>" />
		</div>
		<label id="standerdLatTip" class="control-label" style="color:red"></label>
	</div>
	<div class="form-group">
		<label id="hLabel" for="h" class="col-sm-2 control-label">投影高程</label>
		<div class="col-sm-7">
			<input type="text" class="form-control" id="h" name="h" validateExp="^(\d{1,}\.?\d*)$" validateTip="投影高程应为数值" value="<#if conversionProjection??>${conversionProjection.h!}<#else></#if>" />
		</div>
		<label id="hTip" class="control-label" style="color:red"></label>
	</div>
	<div class="form-group">
		<label id="averageLatLabel" for="averageLat" class="col-sm-2 control-label">投影平均纬</label>
		<div class="col-sm-7">
			<input type="text" class="form-control" id="averageLat" name="averageLat" validateExp="^(\d{1,}\.?\d*)$" validateTip="投影平均纬应为数值" value="<#if conversionProjection??>${conversionProjection.averageLat!}<#else></#if>" />
		</div>
		<label id="averageLatTip" class="control-label" style="color:red"></label>
	</div>
	<input type="hidden" id="conversionProjectionId" name="conversionProjectionId" value="<#if conversionProjection??>${conversionProjection.conversionProjectionId!}</#if>" />
</form>
<#if !RequestParameters["isQuery"]?? || RequestParameters["isQuery"]=="">
<div class="card-page-command">
	<a  class="btn btn-success" onclick="saveConversionProjection();">
		<i class="glyphicon glyphicon-save"></i>
		<span>保存</span>
	</a>
</div>
</#if>

</body>
</html>