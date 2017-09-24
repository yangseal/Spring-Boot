<!doctype html>
<html>
<head>
<#include "/head.ftl"/>
<script type="text/javascript" src="${rc.contextPath}/public/js/oamProjectConstruction/oamProjectConstruction.js"></script>
</head>
<body>
<#if RequestParameters["oamProjectConstructionId"]??>
<ul class="nav nav-tabs" role="tablist">
    <li role="presentation" class="active"><a href="#basicTab" aria-controls="basicTab" role="tab" data-toggle="tab">基础信息</a></li>
    <li role="presentation"><a href="#oamStationConstructionsTab" aria-controls="oamStationConstructionsTab" role="tab" data-toggle="tab">基站建设信息</a></li>
</ul>
<div class="tab-content">
    <div role="tabpanel" class="tab-pane active" id="basicTab">
</#if>

<form id="oamProjectConstructionForm" class="form-horizontal">
	<#if !RequestParameters["oamProjectId"]?? || RequestParameters["oamProjectId"]=="">
	<div class="form-group has-feedback pt15">
		<label id="oamProjectLabel" for="oamProject" class="col-sm-1 control-label">所属项目</label>
		<div class="col-sm-7">
			<input type="text" class="form-control" style="cursor:pointer" id="oamProject" name="oamProject" value="<#if oamProjectConstruction?? && oamProjectConstruction.oamProject??>${oamProjectConstruction.oamProject.oamProjectName!}</#if>" onclick="selectOamProject();" />
			<span class="glyphicon glyphicon-menu-hamburger form-control-feedback"></span>
		</div>
		<label id="oamProjectTip" class="control-label" style="color:red"></label>
	</div>
	</#if>
	<input type="hidden" id="oamProjectId" name="oamProject.oamProjectId" value="<#if oamProjectConstruction?? && oamProjectConstruction.oamProject??>${oamProjectConstruction.oamProject.oamProjectId!}<#else>${RequestParameters["oamProjectId"]!}</#if>" />
	<div class="form-group">
		<label id="oamProjectConstructionNameLabel" for="oamProjectConstructionName" class="col-sm-1 control-label">项目建设名称</label>
		<div class="col-sm-7">
			<input type="text" class="form-control" id="oamProjectConstructionName" name="oamProjectConstructionName" value="<#if oamProjectConstruction??>${oamProjectConstruction.oamProjectConstructionName!}<#else></#if>" />
		</div>
		<label id="oamProjectConstructionNameTip" class="control-label" style="color:red"></label>
	</div>
	<div class="form-group">
		<label id="servicesLabel" for="services" class="col-sm-1 control-label">服务器1.2</label>
		<div class="col-sm-7">
			<select class="form-control" id="services" name="services">
				<option></option>
				<option <#if oamProjectConstruction?? && oamProjectConstruction.services?? && "1"==oamProjectConstruction.services || !oamProjectConstruction?? && "1"=="1">selected</#if> value="1">是</option>
				<option <#if oamProjectConstruction?? && oamProjectConstruction.services?? && "0"==oamProjectConstruction.services || !oamProjectConstruction?? && "0"=="1">selected</#if> value="0">否</option>
			</select>
		</div>
		<label id="servicesTip" class="control-label" style="color:red"></label>
	</div>
	<div class="form-group">
		<label id="nrsLabel" for="nrs" class="col-sm-1 control-label">安装NRS</label>
		<div class="col-sm-7">
			<select class="form-control" id="nrs" name="nrs">
				<option></option>
				<option <#if oamProjectConstruction?? && oamProjectConstruction.nrs?? && "1"==oamProjectConstruction.nrs || !oamProjectConstruction?? && "1"=="1">selected</#if> value="1">是</option>
				<option <#if oamProjectConstruction?? && oamProjectConstruction.nrs?? && "0"==oamProjectConstruction.nrs || !oamProjectConstruction?? && "0"=="1">selected</#if> value="0">否</option>
			</select>
		</div>
		<label id="nrsTip" class="control-label" style="color:red"></label>
	</div>
	<div class="form-group">
		<label id="softwareLabel" for="software" class="col-sm-1 control-label">安装软件狗</label>
		<div class="col-sm-7">
			<select class="form-control" id="software" name="software">
				<option></option>
				<option <#if oamProjectConstruction?? && oamProjectConstruction.software?? && "1"==oamProjectConstruction.software || !oamProjectConstruction?? && "1"=="1">selected</#if> value="1">是</option>
				<option <#if oamProjectConstruction?? && oamProjectConstruction.software?? && "0"==oamProjectConstruction.software || !oamProjectConstruction?? && "0"=="1">selected</#if> value="0">否</option>
			</select>
		</div>
		<label id="softwareTip" class="control-label" style="color:red"></label>
	</div>
	<div class="form-group">
		<label id="netLabel" for="net" class="col-sm-1 control-label">注册NET</label>
		<div class="col-sm-7">
			<select class="form-control" id="net" name="net">
				<option></option>
				<option <#if oamProjectConstruction?? && oamProjectConstruction.net?? && "1"==oamProjectConstruction.net || !oamProjectConstruction?? && "1"=="1">selected</#if> value="1">是</option>
				<option <#if oamProjectConstruction?? && oamProjectConstruction.net?? && "0"==oamProjectConstruction.net || !oamProjectConstruction?? && "0"=="1">selected</#if> value="0">否</option>
			</select>
		</div>
		<label id="netTip" class="control-label" style="color:red"></label>
	</div>
	<div class="form-group">
		<label id="serverLabel" for="server" class="col-sm-1 control-label">注册SERVER</label>
		<div class="col-sm-7">
			<select class="form-control" id="server" name="server">
				<option></option>
				<option <#if oamProjectConstruction?? && oamProjectConstruction.server?? && "1"==oamProjectConstruction.server || !oamProjectConstruction?? && "1"=="1">selected</#if> value="1">是</option>
				<option <#if oamProjectConstruction?? && oamProjectConstruction.server?? && "0"==oamProjectConstruction.server || !oamProjectConstruction?? && "0"=="1">selected</#if> value="0">否</option>
			</select>
		</div>
		<label id="serverTip" class="control-label" style="color:red"></label>
	</div>
	<div class="form-group">
		<label id="nrsConfigLabel" for="nrsConfig" class="col-sm-1 control-label">配置NRS</label>
		<div class="col-sm-7">
			<select class="form-control" id="nrsConfig" name="nrsConfig">
				<option></option>
				<option <#if oamProjectConstruction?? && oamProjectConstruction.nrsConfig?? && "1"==oamProjectConstruction.nrsConfig || !oamProjectConstruction?? && "1"=="1">selected</#if> value="1">是</option>
				<option <#if oamProjectConstruction?? && oamProjectConstruction.nrsConfig?? && "0"==oamProjectConstruction.nrsConfig || !oamProjectConstruction?? && "0"=="1">selected</#if> value="0">否</option>
			</select>
		</div>
		<label id="nrsConfigTip" class="control-label" style="color:red"></label>
	</div>
	<div class="form-group">
		<label id="validTestingLabel" for="validTesting" class="col-sm-1 control-label">可行性验证测试</label>
		<div class="col-sm-7">
			<select class="form-control" id="validTesting" name="validTesting">
				<option></option>
				<option <#if oamProjectConstruction?? && oamProjectConstruction.validTesting?? && "1"==oamProjectConstruction.validTesting || !oamProjectConstruction?? && "1"=="1">selected</#if> value="1">是</option>
				<option <#if oamProjectConstruction?? && oamProjectConstruction.validTesting?? && "0"==oamProjectConstruction.validTesting || !oamProjectConstruction?? && "0"=="1">selected</#if> value="0">否</option>
			</select>
		</div>
		<label id="validTestingTip" class="control-label" style="color:red"></label>
	</div>
	<div class="form-group">
		<label id="precisionTestingLabel" for="precisionTesting" class="col-sm-1 control-label">精度测试</label>
		<div class="col-sm-7">
			<select class="form-control" id="precisionTesting" name="precisionTesting">
				<option></option>
				<option <#if oamProjectConstruction?? && oamProjectConstruction.precisionTesting?? && "1"==oamProjectConstruction.precisionTesting || !oamProjectConstruction?? && "1"=="1">selected</#if> value="1">是</option>
				<option <#if oamProjectConstruction?? && oamProjectConstruction.precisionTesting?? && "0"==oamProjectConstruction.precisionTesting || !oamProjectConstruction?? && "0"=="1">selected</#if> value="0">否</option>
			</select>
		</div>
		<label id="precisionTestingTip" class="control-label" style="color:red"></label>
	</div>
	<div class="form-group">
		<label id="wgs84Label" for="wgs84" class="col-sm-1 control-label">WGS84</label>
		<div class="col-sm-7">
			<select class="form-control" id="wgs84" name="wgs84">
				<option></option>
				<option <#if oamProjectConstruction?? && oamProjectConstruction.wgs84?? && "1"==oamProjectConstruction.wgs84 || !oamProjectConstruction?? && "1"=="1">selected</#if> value="1">是</option>
				<option <#if oamProjectConstruction?? && oamProjectConstruction.wgs84?? && "0"==oamProjectConstruction.wgs84 || !oamProjectConstruction?? && "0"=="1">selected</#if> value="0">否</option>
			</select>
		</div>
		<label id="wgs84Tip" class="control-label" style="color:red"></label>
	</div>
	<div class="form-group">
		<label id="localCoordinateLabel" for="localCoordinate" class="col-sm-1 control-label">地方坐标</label>
		<div class="col-sm-7">
			<select class="form-control" id="localCoordinate" name="localCoordinate">
				<option></option>
				<option <#if oamProjectConstruction?? && oamProjectConstruction.localCoordinate?? && "1"==oamProjectConstruction.localCoordinate || !oamProjectConstruction?? && "1"=="1">selected</#if> value="1">是</option>
				<option <#if oamProjectConstruction?? && oamProjectConstruction.localCoordinate?? && "0"==oamProjectConstruction.localCoordinate || !oamProjectConstruction?? && "0"=="1">selected</#if> value="0">否</option>
			</select>
		</div>
		<label id="localCoordinateTip" class="control-label" style="color:red"></label>
	</div>
	<div class="form-group">
		<label id="isUsedPointLabel" for="isUsedPoint" class="col-sm-1 control-label">是否有已知点</label>
		<div class="col-sm-7">
			<select class="form-control" id="isUsedPoint" name="isUsedPoint">
				<option></option>
				<option <#if oamProjectConstruction?? && oamProjectConstruction.isUsedPoint?? && "1"==oamProjectConstruction.isUsedPoint || !oamProjectConstruction?? && "1"=="1">selected</#if> value="1">是</option>
				<option <#if oamProjectConstruction?? && oamProjectConstruction.isUsedPoint?? && "0"==oamProjectConstruction.isUsedPoint || !oamProjectConstruction?? && "0"=="1">selected</#if> value="0">否</option>
			</select>
		</div>
		<label id="isUsedPointTip" class="control-label" style="color:red"></label>
	</div>
	<div class="form-group">
		<label id="otherSystemLabel" for="otherSystem" class="col-sm-1 control-label">其它位置系统</label>
		<div class="col-sm-7">
			<select class="form-control" id="otherSystem" name="otherSystem">
				<option></option>
				<option <#if oamProjectConstruction?? && oamProjectConstruction.otherSystem?? && "1"==oamProjectConstruction.otherSystem || !oamProjectConstruction?? && "1"=="1">selected</#if> value="1">是</option>
				<option <#if oamProjectConstruction?? && oamProjectConstruction.otherSystem?? && "0"==oamProjectConstruction.otherSystem || !oamProjectConstruction?? && "0"=="1">selected</#if> value="0">否</option>
			</select>
		</div>
		<label id="otherSystemTip" class="control-label" style="color:red"></label>
	</div>
	<div class="form-group">
		<label id="planOfTestingLabel" for="planOfTesting" class="col-sm-1 control-label">拟定测试计划</label>
		<div class="col-sm-7">
			<select class="form-control" id="planOfTesting" name="planOfTesting">
				<option></option>
				<option <#if oamProjectConstruction?? && oamProjectConstruction.planOfTesting?? && "1"==oamProjectConstruction.planOfTesting || !oamProjectConstruction?? && "1"=="1">selected</#if> value="1">是</option>
				<option <#if oamProjectConstruction?? && oamProjectConstruction.planOfTesting?? && "0"==oamProjectConstruction.planOfTesting || !oamProjectConstruction?? && "0"=="1">selected</#if> value="0">否</option>
			</select>
		</div>
		<label id="planOfTestingTip" class="control-label" style="color:red"></label>
	</div>
	<div class="form-group">
		<label id="testingInfoLabel" for="testingInfo" class="col-sm-1 control-label">测试描述</label>
		<div class="col-sm-7">
			<input type="text" class="form-control" id="testingInfo" name="testingInfo" value="<#if oamProjectConstruction??>${oamProjectConstruction.testingInfo!}<#else></#if>" />
		</div>
		<label id="testingInfoTip" class="control-label" style="color:red"></label>
	</div>
	<div class="form-group">
		<label id="resultDataLabel" for="resultData" class="col-sm-1 control-label">解算数据</label>
		<div class="col-sm-7">
			<select class="form-control" id="resultData" name="resultData">
				<option></option>
				<option <#if oamProjectConstruction?? && oamProjectConstruction.resultData?? && "1"==oamProjectConstruction.resultData || !oamProjectConstruction?? && "1"=="1">selected</#if> value="1">是</option>
				<option <#if oamProjectConstruction?? && oamProjectConstruction.resultData?? && "0"==oamProjectConstruction.resultData || !oamProjectConstruction?? && "0"=="1">selected</#if> value="0">否</option>
			</select>
		</div>
		<label id="resultDataTip" class="control-label" style="color:red"></label>
	</div>
	<div class="form-group">
		<label id="resultReportLabel" for="resultReport" class="col-sm-1 control-label">出具报告</label>
		<div class="col-sm-7">
			<select class="form-control" id="resultReport" name="resultReport">
				<option></option>
				<option <#if oamProjectConstruction?? && oamProjectConstruction.resultReport?? && "1"==oamProjectConstruction.resultReport || !oamProjectConstruction?? && "1"=="1">selected</#if> value="1">是</option>
				<option <#if oamProjectConstruction?? && oamProjectConstruction.resultReport?? && "0"==oamProjectConstruction.resultReport || !oamProjectConstruction?? && "0"=="1">selected</#if> value="0">否</option>
			</select>
		</div>
		<label id="resultReportTip" class="control-label" style="color:red"></label>
	</div>
	<div class="form-group">
		<label id="isMeetingLabel" for="isMeeting" class="col-sm-1 control-label">是否需要召开验收会</label>
		<div class="col-sm-7">
			<select class="form-control" id="isMeeting" name="isMeeting">
				<option></option>
				<option <#if oamProjectConstruction?? && oamProjectConstruction.isMeeting?? && "1"==oamProjectConstruction.isMeeting || !oamProjectConstruction?? && "1"=="1">selected</#if> value="1">是</option>
				<option <#if oamProjectConstruction?? && oamProjectConstruction.isMeeting?? && "0"==oamProjectConstruction.isMeeting || !oamProjectConstruction?? && "0"=="1">selected</#if> value="0">否</option>
			</select>
		</div>
		<label id="isMeetingTip" class="control-label" style="color:red"></label>
	</div>
	<input type="hidden" id="oamProjectConstructionId" name="oamProjectConstructionId" value="<#if oamProjectConstruction??>${oamProjectConstruction.oamProjectConstructionId!}</#if>" />
</form>
<#if !RequestParameters["isQuery"]?? || RequestParameters["isQuery"]=="">
<div class="card-page-command">
<label class="col-sm-1 control-label"></label>
      <div class="col-sm-7" style="text-align:center;">
	<a  class="btn btn-success" onclick="saveOamProjectConstruction();">
		<i class="glyphicon glyphicon-save"></i>
		<span>保存</span>
	</a>
	</div>
</div>
</#if>

<#if RequestParameters["oamProjectConstructionId"]??>
	</div>
<div role="tabpanel" class="tab-pane" id="oamStationConstructionsTab">
   	<iframe code="oamStationConstructions" frameborder=0 width="100%" src="${rc.contextPath}/oamStationConstruction/showOamStationConstructions?${rc.queryString!}" />
</div>
</div>
</#if>
</body>
</html>