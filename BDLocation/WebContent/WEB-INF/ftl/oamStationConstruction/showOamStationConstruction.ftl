<!doctype html>
<html>
<head>
<#include "/head.ftl"/>
<script type="text/javascript" src="${rc.contextPath}/public/js/oamStationConstruction/oamStationConstruction.js"></script>
</head>
<body>

<form id="oamStationConstructionForm" class="form-horizontal">
	<#if !RequestParameters["oamProjectConstructionId"]?? || RequestParameters["oamProjectConstructionId"]=="">
	<div class="form-group has-feedback">
		<label id="oamProjectConstructionLabel" for="oamProjectConstruction" class="col-sm-2 control-label">项目建设</label>
		<div class="col-sm-7">
			<input type="text" class="form-control" style="cursor:pointer" id="oamProjectConstruction" name="oamProjectConstruction" value="<#if oamStationConstruction?? && oamStationConstruction.oamProjectConstruction??>${oamStationConstruction.oamProjectConstruction.oamProjectConstructionName!}</#if>" onclick="selectOamProjectConstruction();" />
			<span class="glyphicon glyphicon-menu-hamburger form-control-feedback"></span>
		</div>
		<label id="oamProjectConstructionTip" class="control-label" style="color:red"></label>
	</div>
	</#if>
	<input type="hidden" id="oamProjectConstructionId" name="oamProjectConstruction.oamProjectConstructionId" value="<#if oamStationConstruction?? && oamStationConstruction.oamProjectConstruction??>${oamStationConstruction.oamProjectConstruction.oamProjectConstructionId!}<#else>${RequestParameters["oamProjectConstructionId"]!}</#if>" />
	<#if !RequestParameters["oamBaseStationId"]?? || RequestParameters["oamBaseStationId"]=="">
	<div class="form-group has-feedback">
		<label id="oamBaseStationLabel" for="oamBaseStation" class="col-sm-2 control-label">基站</label>
		<div class="col-sm-7">
			<input type="text" class="form-control" style="cursor:pointer" id="oamBaseStation" name="oamBaseStation" value="<#if oamStationConstruction?? && oamStationConstruction.oamBaseStation??>${oamStationConstruction.oamBaseStation.oamBaseStationName!}</#if>" onclick="selectOamBaseStation();" />
			<span class="glyphicon glyphicon-menu-hamburger form-control-feedback"></span>
		</div>
		<label id="oamBaseStationTip" class="control-label" style="color:red"></label>
	</div>
	</#if>
	<input type="hidden" id="oamBaseStationId" name="oamBaseStation.oamBaseStationId" value="<#if oamStationConstruction?? && oamStationConstruction.oamBaseStation??>${oamStationConstruction.oamBaseStation.oamBaseStationId!}<#else>${RequestParameters["oamBaseStationId"]!}</#if>" />
	<div class="form-group">
		<label id="installAntennaLabel" for="installAntenna" class="col-sm-2 control-label">安装天线</label>
		<div class="col-sm-7">
			<select class="form-control" id="installAntenna" name="installAntenna">
				<option></option>
				<option <#if oamStationConstruction?? && oamStationConstruction.installAntenna?? && "1"==oamStationConstruction.installAntenna || !oamStationConstruction?? && "1"=="1">selected</#if> value="1">是</option>
				<option <#if oamStationConstruction?? && oamStationConstruction.installAntenna?? && "0"==oamStationConstruction.installAntenna || !oamStationConstruction?? && "0"=="1">selected</#if> value="0">否</option>
			</select>
		</div>
		<label id="installAntennaTip" class="control-label" style="color:red"></label>
	</div>
	<div class="form-group">
		<label id="installwiringLabel" for="installwiring" class="col-sm-2 control-label">布设线缆</label>
		<div class="col-sm-7">
			<select class="form-control" id="installwiring" name="installwiring">
				<option></option>
				<option <#if oamStationConstruction?? && oamStationConstruction.installwiring?? && "1"==oamStationConstruction.installwiring || !oamStationConstruction?? && "1"=="1">selected</#if> value="1">是</option>
				<option <#if oamStationConstruction?? && oamStationConstruction.installwiring?? && "0"==oamStationConstruction.installwiring || !oamStationConstruction?? && "0"=="1">selected</#if> value="0">否</option>
			</select>
		</div>
		<label id="installwiringTip" class="control-label" style="color:red"></label>
	</div>
	<div class="form-group">
		<label id="mainframeRoomLabel" for="mainframeRoom" class="col-sm-2 control-label">布置机房</label>
		<div class="col-sm-7">
			<select class="form-control" id="mainframeRoom" name="mainframeRoom">
				<option></option>
				<option <#if oamStationConstruction?? && oamStationConstruction.mainframeRoom?? && "1"==oamStationConstruction.mainframeRoom || !oamStationConstruction?? && "1"=="1">selected</#if> value="1">是</option>
				<option <#if oamStationConstruction?? && oamStationConstruction.mainframeRoom?? && "0"==oamStationConstruction.mainframeRoom || !oamStationConstruction?? && "0"=="1">selected</#if> value="0">否</option>
			</select>
		</div>
		<label id="mainframeRoomTip" class="control-label" style="color:red"></label>
	</div>
	<div class="form-group">
		<label id="installMainframeLabel" for="installMainframe" class="col-sm-2 control-label">安装主机</label>
		<div class="col-sm-7">
			<select class="form-control" id="installMainframe" name="installMainframe">
				<option></option>
				<option <#if oamStationConstruction?? && oamStationConstruction.installMainframe?? && "1"==oamStationConstruction.installMainframe || !oamStationConstruction?? && "1"=="1">selected</#if> value="1">是</option>
				<option <#if oamStationConstruction?? && oamStationConstruction.installMainframe?? && "0"==oamStationConstruction.installMainframe || !oamStationConstruction?? && "0"=="1">selected</#if> value="0">否</option>
			</select>
		</div>
		<label id="installMainframeTip" class="control-label" style="color:red"></label>
	</div>
	<div class="form-group">
		<label id="updateDataLabel" for="updateData" class="col-sm-2 control-label">数据上发</label>
		<div class="col-sm-7">
			<select class="form-control" id="updateData" name="updateData">
				<option></option>
				<option <#if oamStationConstruction?? && oamStationConstruction.updateData?? && "1"==oamStationConstruction.updateData || !oamStationConstruction?? && "1"=="1">selected</#if> value="1">是</option>
				<option <#if oamStationConstruction?? && oamStationConstruction.updateData?? && "0"==oamStationConstruction.updateData || !oamStationConstruction?? && "0"=="1">selected</#if> value="0">否</option>
			</select>
		</div>
		<label id="updateDataTip" class="control-label" style="color:red"></label>
	</div>
	<div class="form-group">
		<label id="updatePositionLabel" for="updatePosition" class="col-sm-2 control-label">位置上发</label>
		<div class="col-sm-7">
			<select class="form-control" id="updatePosition" name="updatePosition">
				<option></option>
				<option <#if oamStationConstruction?? && oamStationConstruction.updatePosition?? && "1"==oamStationConstruction.updatePosition || !oamStationConstruction?? && "1"=="1">selected</#if> value="1">是</option>
				<option <#if oamStationConstruction?? && oamStationConstruction.updatePosition?? && "0"==oamStationConstruction.updatePosition || !oamStationConstruction?? && "0"=="1">selected</#if> value="0">否</option>
			</select>
		</div>
		<label id="updatePositionTip" class="control-label" style="color:red"></label>
	</div>
	<div class="form-group">
		<label id="mainframeRegiterLabel" for="mainframeRegiter" class="col-sm-2 control-label">主机注册</label>
		<div class="col-sm-7">
			<select class="form-control" id="mainframeRegiter" name="mainframeRegiter">
				<option></option>
				<option <#if oamStationConstruction?? && oamStationConstruction.mainframeRegiter?? && "1"==oamStationConstruction.mainframeRegiter || !oamStationConstruction?? && "1"=="1">selected</#if> value="1">是</option>
				<option <#if oamStationConstruction?? && oamStationConstruction.mainframeRegiter?? && "0"==oamStationConstruction.mainframeRegiter || !oamStationConstruction?? && "0"=="1">selected</#if> value="0">否</option>
			</select>
		</div>
		<label id="mainframeRegiterTip" class="control-label" style="color:red"></label>
	</div>
	<div class="form-group has-feedback">
		<label id="observationStartTimeLabel" for="observationStartTime" class="col-sm-2 control-label">观测开始时间</label>
		<div class="col-sm-7">
			<input type="text" class="form-control" id="observationStartTime" name="observationStartTime" value="<#if oamStationConstruction??>${oamStationConstruction.observationStartTime!}<#else>${.now?string("yyyy-MM-dd HH:mm:ss")}</#if>" onclick="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm:ss'});" />
			<span class="glyphicon glyphicon-menu-hamburger form-control-feedback"></span>
		</div>
		<label id="observationStartTimeTip" class="control-label" style="color:red"></label>
	</div>
	<div class="form-group has-feedback">
		<label id="observationEndTimeLabel" for="observationEndTime" class="col-sm-2 control-label">观测结束时间</label>
		<div class="col-sm-7">
			<input type="text" class="form-control" id="observationEndTime" name="observationEndTime" value="<#if oamStationConstruction??>${oamStationConstruction.observationEndTime!}<#else>${.now?string("yyyy-MM-dd HH:mm:ss")}</#if>" onclick="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm:ss'});" />
			<span class="glyphicon glyphicon-menu-hamburger form-control-feedback"></span>
		</div>
		<label id="observationEndTimeTip" class="control-label" style="color:red"></label>
	</div>
	<div class="form-group">
		<label id="attachmentsLabel" for="attachments" class="col-sm-2 control-label">附件列表</label>
		<div class="col-sm-7">
      		<div id="attachments" name="attachments" style="border:1px solid">
      		</div>
      	</div>
      	<label id="attachmentsTip" class="control-label" style="color:red"></label>
	</div>
	<input type="hidden" id="oamStationConstructionId" name="oamStationConstructionId" value="<#if oamStationConstruction??>${oamStationConstruction.oamStationConstructionId!}</#if>" />
</form>
<#if !RequestParameters["isQuery"]?? || RequestParameters["isQuery"]=="">
<div class="card-page-command">
	<a  class="btn btn-success" onclick="saveOamStationConstruction();">
		<i class="glyphicon glyphicon-save"></i>
		<span>保存</span>
	</a>
</div>
</#if>

</body>
</html>