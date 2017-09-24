<!doctype html>
<html>
<head>
<#include "/head.ftl"/>
<script type="text/javascript" src="${rc.contextPath}/public/js/measurePoint/measurePoint.js"></script>
</head>
<body>
<form id="measurePointForm" class="form-horizontal">
	<div class="form-group">
		<label id="measurePointNameLabel" for="measurePointName" class="col-sm-2 control-label">点名称</label>
		<div class="col-sm-7">
			<input type="text" class="form-control" id="measurePointName" name="measurePointName" isNotNull value="<#if measurePoint??>${measurePoint.measurePointName!}<#else></#if>" />
		</div>
		<label id="measurePointNameTip" class="control-label" style="color:red">*</label>
	</div>
	<div class="form-group">
		<label id="measurePointCodeLabel" for="measurePointCode" class="col-sm-2 control-label">点编码</label>
		<div class="col-sm-7">
			<input type="text" class="form-control" id="measurePointCode" name="measurePointCode" isNotNull value="<#if measurePoint??>${measurePoint.measurePointCode!}<#else></#if>" />
		</div>
		<label id="measurePointCodeTip" class="control-label" style="color:red">*</label>
	</div>
	<#if !RequestParameters["affiliationPointTypeId"]?? || RequestParameters["affiliationPointTypeId"]=="">
	<div class="form-group has-feedback">
		<label id="affiliationPointTypeLabel" for="affiliationPointType" class="col-sm-2 control-label">所属点类型</label>
		<div class="col-sm-7">
			<input type="text" class="form-control" style="cursor:pointer" id="affiliationPointType" name="affiliationPointType" isNotNull value="<#if measurePoint?? && measurePoint.affiliationPointType??>${measurePoint.affiliationPointType.pointTypeName!}</#if>" <#if !measurePoint??>onclick="selectAffiliationPointType();" </#if> readonly="readonly" />
			<span class="glyphicon glyphicon-menu-hamburger form-control-feedback"></span>
		</div>
		<label id="affiliationPointTypeTip" class="control-label" style="color:red">*</label>
	</div>
	</#if>
	<input type="hidden" id="affiliationPointTypeId" name="affiliationPointTypeId" value="<#if measurePoint?? && measurePoint.affiliationPointType??>${measurePoint.affiliationPointType.pointTypeId!}<#else>${RequestParameters["affiliationPointTypeId"]!}</#if>" />
	<div class="form-group">
		<label id="pointDescLabel" for="pointDesc" class="col-sm-2 control-label">描述</label>
		<div class="col-sm-7">
			<input type="text" class="form-control" id="pointDesc" name="pointDesc" value="<#if measurePoint??>${measurePoint.pointDesc!}<#else></#if>" />
		</div>
		<label id="pointDescTip" class="control-label" style="color:red"></label>
	</div>
	<#if measurePoint?? && measurePoint.dynamicList??>
		 <#list measurePoint.dynamicList as key>
			<#if key??>
				<div class="form-group">
					 <label id="pointDescLabel" for="pointDesc" class="col-sm-2 control-label"><#if key.fieldName??>${key.fieldName}</#if></label>
					 <div class="col-sm-7">
						<input type="text" class="form-control" value="<#if key.fieldValue??>${key.fieldValue}</#if>" readonly="readonly"/>
					 </div>
				</div>
			</#if>
		 </#list>
	</#if>
	<div class="form-group">
		<label id="solutionStateLabel" for="solutionState" class="col-sm-2 control-label">解状态</label>
		<div class="col-sm-7">
			<select class="form-control" id="solutionState" name="solutionState" isNotNull>
				<option></option>
				<option <#if measurePoint?? && "ST_INVALID_FIX"==measurePoint.solutionState || !measurePoint?? && "ST_INVALID_FIX"=="ST_INVALID_FIX">selected</#if> value="ST_INVALID_FIX">未定位</option>
				<option <#if measurePoint?? && "ST_GPS_FIX"==measurePoint.solutionState || !measurePoint?? && "ST_GPS_FIX"=="ST_INVALID_FIX">selected</#if> value="ST_GPS_FIX">单点解</option>
				<option <#if measurePoint?? && "ST_DGPS_FIX"==measurePoint.solutionState || !measurePoint?? && "ST_DGPS_FIX"=="ST_INVALID_FIX">selected</#if> value="ST_DGPS_FIX">差分解</option>
				<option <#if measurePoint?? && "ST_FRTK_FIX"==measurePoint.solutionState || !measurePoint?? && "ST_FRTK_FIX"=="ST_INVALID_FIX">selected</#if> value="ST_FRTK_FIX">浮点解</option>
				<option <#if measurePoint?? && "ST_RTK_FIX"==measurePoint.solutionState || !measurePoint?? && "ST_RTK_FIX"=="ST_INVALID_FIX">selected</#if> value="ST_RTK_FIX">固定解</option>
			</select>
		</div>
		<label id="solutionStateTip" class="control-label" style="color:red">*</label>
	</div>
	<div class="form-group">
		<label id="hrmsLabel" for="hrms" class="col-sm-2 control-label">hrms</label>
		<div class="col-sm-7">
			<input type="text" class="form-control" id="hrms" name="hrms" isNotNull validateExp="^\d+(\.\d+)?$" validateTip="请输入数字" value="<#if measurePoint?? && measurePoint.hrms??>${measurePoint.hrms!}<#else></#if>" />
		</div>
		<label id="hrmsTip" class="control-label" style="color:red">*</label>
	</div>
	<div class="form-group">
		<label id="vrmsLabel" for="vrms" class="col-sm-2 control-label">vrms</label>
		<div class="col-sm-7">
			<input type="text" class="form-control" id="vrms" name="vrms" isNotNull validateExp="^\d+(\.\d+)?$" validateTip="请输入数字" value="<#if measurePoint?? && measurePoint.vrms??>${measurePoint.vrms!}<#else></#if>" />
		</div>
		<label id="vrmsTip" class="control-label" style="color:red">*</label>
	</div>
	<div class="form-group">
		<label id="longitudeLabel" for="longitude" class="col-sm-2 control-label">经度</label>
		<div class="col-sm-7">
			<input type="text" class="form-control" id="longitude" name="longitude" isNotNull validateExp="^\d+(\.\d+)?$" validateTip="请输入数字" value="<#if measurePoint?? && measurePoint.longitude??>${measurePoint.longitude?c}<#else></#if>" />
		</div>
		<label id="longitudeTip" class="control-label" style="color:red">*</label>
	</div>
	<div class="form-group">
		<label id="latitudeLabel" for="latitude" class="col-sm-2 control-label">纬度</label>
		<div class="col-sm-7">
			<input type="text" class="form-control" id="latitude" name="latitude" isNotNull validateExp="^\d+(\.\d+)?$" validateTip="请输入数字" value="<#if measurePoint?? && measurePoint.latitude??>${measurePoint.latitude?c}<#else></#if>" />
		</div>
		<label id="latitudeTip" class="control-label" style="color:red">*</label>
	</div>
	<div class="form-group">
		<label id="northLabel" for="north" class="col-sm-2 control-label">北坐标</label>
		<div class="col-sm-7">
			<input type="text" class="form-control" id="north" name="north" validateExp="^\d+(\.\d+)?$" validateTip="请输入数字" value="<#if measurePoint?? && measurePoint.north??>${measurePoint.north?c}<#else></#if>" />
		</div>
		<label id="northTip" class="control-label" style="color:red"></label>
	</div>
	<div class="form-group">
		<label id="eastLabel" for="east" class="col-sm-2 control-label">东坐标</label>
		<div class="col-sm-7">
			<input type="text" class="form-control" id="east" name="east" validateExp="^\d+(\.\d+)?$" validateTip="请输入数字" value="<#if measurePoint?? && measurePoint.east??>${measurePoint.east?c}<#else></#if>" />
		</div>
		<label id="eastTip" class="control-label" style="color:red"></label>
	</div>
	<div class="form-group">
		<label id="coordinateXLabel" for="coordinateX" class="col-sm-2 control-label">城建坐标X</label>
		<div class="col-sm-7">
			<input type="text" class="form-control" id="coordinateX" name="coordinateX" validateExp="^\d+(\.\d+)?$" validateTip="请输入数字" value="<#if measurePoint?? && measurePoint.coordinateX??>${measurePoint.coordinateX?c}<#else></#if>" />
		</div>
		<label id="coordinateXTip" class="control-label" style="color:red"></label>
	</div>
	<div class="form-group">
		<label id="coordinateYLabel" for="coordinateY" class="col-sm-2 control-label">城建坐标Y</label>
		<div class="col-sm-7">
			<input type="text" class="form-control" id="coordinateY" name="coordinateY" validateExp="^\d+(\.\d+)?$" validateTip="请输入数字" value="<#if measurePoint?? && measurePoint.coordinateY??>${measurePoint.coordinateY?c}<#else></#if>" />
		</div>
		<label id="coordinateYTip" class="control-label" style="color:red"></label>
	</div>
	<div class="form-group">
		<label id="ellHeightLabel" for="ellHeight" class="col-sm-2 control-label">椭球高</label>
		<div class="col-sm-7">
			<input type="text" class="form-control" id="ellHeight" name="ellHeight" isNotNull validateExp="^-{0,1}\d+(\.\d+)?$" validateTip="请输入数字" value="<#if measurePoint?? && measurePoint.ellHeight??>${measurePoint.ellHeight?c}<#else></#if>" />
		</div>
		<label id="ellHeightTip" class="control-label" style="color:red">*</label>
	</div>
	<div class="form-group">
		<label id="altitudeLabel" for="altitude" class="col-sm-2 control-label">高程</label>
		<div class="col-sm-7">
			<input type="text" class="form-control" id="altitude" name="altitude" isNotNull validateExp="^\d+(\.\d+)?$" validateTip="请输入数字" value="<#if measurePoint?? && measurePoint.altitude??>${measurePoint.altitude?c}<#else></#if>" />
		</div>
		<label id="altitudeTip" class="control-label" style="color:red">*</label>
	</div>
	<div class="form-group has-feedback">
		<label id="createDateLabel" for="createDate" class="col-sm-2 control-label">创建时间</label>
		<div class="col-sm-7">
			<input type="text" class="form-control" id="createDate" name="createDate" isNotNull value="<#if measurePoint??>${measurePoint.createDate!}<#else>${.now?string("yyyy-MM-dd HH:mm:ss")}</#if>" <#if !measurePoint??>onclick="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm:ss'});"</#if> readonly="readonly"/>
			<span class="glyphicon glyphicon-menu-hamburger form-control-feedback"></span>
		</div>
		<label id="createDateTip" class="control-label" style="color:red">*</label>
	</div>
	<#if !RequestParameters["affiliationProjectId"]?? || RequestParameters["affiliationProjectId"]=="">
	<div class="form-group has-feedback">
		<label id="affiliationProjectLabel" for="affiliationProject" class="col-sm-2 control-label">所属工程</label>
		<div class="col-sm-7">
			<input type="text" class="form-control" style="cursor:pointer" id="affiliationProject" name="affiliationProject" isNotNull value="<#if measurePoint?? && measurePoint.affiliationProject??>${measurePoint.affiliationProject.measureProjectName!}</#if>" <#if !measurePoint??>onclick="selectAffiliationProject();"</#if> readonly="readonly"/>
			<span class="glyphicon glyphicon-menu-hamburger form-control-feedback"></span>
		</div>
		<label id="affiliationProjectTip" class="control-label" style="color:red">*</label>
	</div>
	</#if>
	<div class="form-group">
		<label id="attachmentsLabel" for="attachments" class="col-sm-2 control-label">附件</label>
		<div class="col-sm-7">
      		<div id="attachments" name="attachments" style="border:1px solid">
      		</div>
      	</div>
      	<label id="attachmentsTip" class="control-label" style="color:red"></label>
	</div>
	<input type="hidden" id="affiliationProjectId" name="affiliationProjectId" value="<#if measurePoint?? && measurePoint.affiliationProject??>${measurePoint.affiliationProject.measureProjectId!}<#else>${RequestParameters["affiliationProjectId"]!}</#if>" />
	<input type="hidden" id="measurePointId" name="measurePointId" value="<#if measurePoint??>${measurePoint.measurePointId!}</#if>" />
</form>
<#if !RequestParameters["isQuery"]?? || RequestParameters["isQuery"]=="">
<div style="text-align:center">
	<a  class="btn btn-success" onclick="saveMeasurePoint();">
		<i class="glyphicon glyphicon-save"></i>
		<span>保存</span>
	</a>
</div>
</#if>
</body>
</html>