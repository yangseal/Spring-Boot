<!doctype html>
<html>
<head>
<#include "/head.ftl"/>
<script type="text/javascript" src="${rc.contextPath}/public/js/oamBaseStation/oamBaseStation.js"></script>
</head>
<body>

<form id="oamBaseStationForm" class="form-horizontal">
	<#if !RequestParameters["oamAreaId"]?? || RequestParameters["oamAreaId"]=="">
	<div class="form-group has-feedback pt15">
		<label id="oamAreaLabel" for="oamArea" class="col-sm-1 control-label">所属地区</label>
		<div class="col-sm-5">
			<input type="text" class="form-control" style="cursor:pointer" id="oamArea" name="oamArea" value="<#if oamBaseStation?? && oamBaseStation.oamArea??>${oamBaseStation.oamArea.oamAreaName!}</#if>" onclick="selectOamArea();" />
			<span class="glyphicon glyphicon-menu-hamburger form-control-feedback"></span>
		</div>
		<label id="oamAreaTip" class="control-label" style="color:red"></label>
	</div>
	</#if>
	<input type="hidden" id="oamAreaId" name="oamArea.oamAreaId" value="<#if oamBaseStation?? && oamBaseStation.oamArea??>${oamBaseStation.oamArea.oamAreaId!}<#else>${RequestParameters["oamAreaId"]!}</#if>" />
	<#if !RequestParameters["oamProjectId"]?? || RequestParameters["oamProjectId"]=="">
	<div class="form-group has-feedback">
		<label id="oamProjectLabel" for="oamProject" class="col-sm-1 control-label">所属项目</label>
		<div class="col-sm-5">
			<input type="text" class="form-control" style="cursor:pointer" id="oamProject" name="oamProject" value="<#if oamBaseStation?? && oamBaseStation.oamProject??>${oamBaseStation.oamProject.oamProjectName!}</#if>" onclick="selectOamProject();" />
			<span class="glyphicon glyphicon-menu-hamburger form-control-feedback"></span>
		</div>
		<label id="oamProjectTip" class="control-label" style="color:red"></label>
	</div>
	</#if>
	<input type="hidden" id="oamProjectId" name="oamProject.oamProjectId" value="<#if oamBaseStation?? && oamBaseStation.oamProject??>${oamBaseStation.oamProject.oamProjectId!}<#else>${RequestParameters["oamProjectId"]!}</#if>" />
	<div class="form-group">
		<label id="oamBaseStationNameLabel" for="oamBaseStationName" class="col-sm-1 control-label">基站名称</label>
		<div class="col-sm-5">
			<input type="text" class="form-control" id="oamBaseStationName" name="oamBaseStationName" value="<#if oamBaseStation??>${oamBaseStation.oamBaseStationName!}<#else></#if>" />
		</div>
		<label id="oamBaseStationNameTip" class="control-label" style="color:red"></label>
	</div>
	<div class="form-group">
		<label id="shortNameLabel" for="shortName" class="col-sm-1 control-label">基站简称</label>
		<div class="col-sm-5">
			<input type="text" class="form-control" id="shortName" name="shortName" value="<#if oamBaseStation??>${oamBaseStation.shortName!}<#else></#if>" />
		</div>
		<label id="shortNameTip" class="control-label" style="color:red"></label>
	</div>
	<div class="form-group">
		<label id="oamBaseStationCodeLabel" for="oamBaseStationCode" class="col-sm-1 control-label">基站编号</label>
		<div class="col-sm-5">
			<input type="text" class="form-control" id="oamBaseStationCode" name="oamBaseStationCode" isNotNull value="<#if oamBaseStation??>${oamBaseStation.oamBaseStationCode!}<#else></#if>" />
		</div>
		<label id="oamBaseStationCodeTip" class="control-label" style="color:red">*</label>
	</div>
	<div class="form-group">
		<label id="nfCodeLabel" for="nfCode" class="col-sm-1 control-label">南方测绘编号</label>
		<div class="col-sm-5">
			<input type="text" class="form-control" id="nfCode" name="nfCode" value="<#if oamBaseStation??>${oamBaseStation.nfCode!}<#else></#if>" />
		</div>
		<label id="nfCodeTip" class="control-label" style="color:red"></label>
	</div>
	<div class="form-group">
		<label id="buildStageLabel" for="buildStage" class="col-sm-1 control-label">建设阶段</label>
		<div class="col-sm-5">
			<select class="form-control" id="buildStage" name="buildStage">
				<option></option>
				<option <#if oamBaseStation?? && oamBaseStation.buildStage?? && "1"==oamBaseStation.buildStage || !oamBaseStation?? && "1"=="0">selected</#if> value="1">已完成</option>
				<option <#if oamBaseStation?? && oamBaseStation.buildStage?? && "0"==oamBaseStation.buildStage || !oamBaseStation?? && "0"=="0">selected</#if> value="0">建设中</option>
			</select>
		</div>
		<label id="buildStageTip" class="control-label" style="color:red"></label>
	</div>
	<div class="form-group">
		<label id="isEffectivityLabel" for="isEffectivity" class="col-sm-1 control-label">是否有效</label>
		<div class="col-sm-5">
			<select class="form-control" id="isEffectivity" name="isEffectivity">
				<option></option>
				<option <#if oamBaseStation?? && oamBaseStation.isEffectivity?? && "1"==oamBaseStation.isEffectivity || !oamBaseStation?? && "1"=="1">selected</#if> value="1">是</option>
				<option <#if oamBaseStation?? && oamBaseStation.isEffectivity?? && "0"==oamBaseStation.isEffectivity || !oamBaseStation?? && "0"=="1">selected</#if> value="0">否</option>
			</select>
		</div>
		<label id="isEffectivityTip" class="control-label" style="color:red"></label>
	</div>
	<div class="form-group">
		<label id="longitudeLabel" for="longitude" class="col-sm-1 control-label">经度</label>
		<div class="col-sm-5">
			<input type="text" class="form-control" id="longitude" name="longitude" validateExp="^(\d{1,}\.?\d*)$" validateTip="经度应为数值" value="<#if oamBaseStation?? && oamBaseStation.longitude??>${oamBaseStation.longitude?c}<#else></#if>" />
		</div>
		<label id="longitudeTip" class="control-label" style="color:red"></label>
	</div>
	<div class="form-group">
		<label id="latitudeLabel" for="latitude" class="col-sm-1 control-label">纬度</label>
		<div class="col-sm-5">
			<input type="text" class="form-control" id="latitude" name="latitude" validateExp="^(\d{1,}\.?\d*)$" validateTip="纬度应为数值" value="<#if oamBaseStation?? && oamBaseStation.latitude??>${oamBaseStation.latitude?c}<#else></#if>" />
		</div>
		<label id="latitudeTip" class="control-label" style="color:red"></label>
	</div>
	<div class="form-group">
		<label id="stateLabel" for="state" class="col-sm-1 control-label">状态</label>
		<div class="col-sm-5">
			<select class="form-control" id="state" name="state">
				<option></option>
				<option <#if oamBaseStation?? && oamBaseStation.state?? && "1"==oamBaseStation.state || !oamBaseStation?? && "1"=="1">selected</#if> value="1">是</option>
				<option <#if oamBaseStation?? && oamBaseStation.state?? && "0"==oamBaseStation.state || !oamBaseStation?? && "0"=="1">selected</#if> value="0">否</option>
			</select>
		</div>
		<label id="stateTip" class="control-label" style="color:red"></label>
	</div>
	<div class="form-group">
		<label id="attachmentsLabel" for="attachments" class="col-sm-1 control-label">附件列表</label>
		<div class="col-sm-5">
      		<div id="attachments" name="attachments" class="fj_box2">
      		</div>
      	</div>
      	<label id="attachmentsTip" class="control-label" style="color:red"></label>
	</div>
	<input type="hidden" id="oamBaseStationId" name="oamBaseStationId" value="<#if oamBaseStation??>${oamBaseStation.oamBaseStationId!}</#if>" />
</form>
<#if !RequestParameters["isQuery"]?? || RequestParameters["isQuery"]=="">
<div class="card-page-command">
   <label class="col-sm-1 control-label"></label>
      <div class="col-sm-5" style="text-align:center;">
	<a  class="btn btn-success" onclick="saveOamBaseStation();">
		<i class="glyphicon glyphicon-save"></i>
		<span>保存</span>
	</a>
	</div>
</div>
</#if>

</body>
</html>