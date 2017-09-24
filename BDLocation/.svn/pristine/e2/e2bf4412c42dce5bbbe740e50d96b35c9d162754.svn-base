<!doctype html>
<html>
<head>
<#include "/head.ftl"/>
<script type="text/javascript" src="${rc.contextPath}/public/js/pointType/pointType.js"></script>
</head>
<body>
<form id="pointTypeForm" class="form-horizontal">
	<div class="form-group">
		<label id="pointTypeCodeLabel" for="pointTypeCode" class="col-sm-2 control-label">编码</label>
		<div class="col-sm-7">
			<input type="text" class="form-control" id="pointTypeCode" name="pointTypeCode" isNotNull value="<#if pointType??>${pointType.pointTypeCode!}<#else></#if>" />
		</div>
		<label id="pointTypeCodeTip" class="control-label" style="color:red">*</label>
	</div>
	<div class="form-group">
		<label id="pointTypeNameLabel" for="pointTypeName" class="col-sm-2 control-label">名称</label>
		<div class="col-sm-7">
			<input type="text" class="form-control" id="pointTypeName" name="pointTypeName" isNotNull value="<#if pointType??>${pointType.pointTypeName!}<#else></#if>" />
		</div>
		<label id="pointTypeNameTip" class="control-label" style="color:red">*</label>
	</div>
	<div class="form-group has-feedback">
		<label id="createDateLabel" for="createDate" class="col-sm-2 control-label">创建日期</label>
		<div class="col-sm-7">
			<input type="text" class="form-control" id="createDate" name="createDate" isNotNull value="<#if pointType??>${pointType.createDate!}<#else>${.now?string("yyyy-MM-dd HH:mm:ss")}</#if>" onclick="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm:ss'});" />
			<span class="glyphicon glyphicon-menu-hamburger form-control-feedback"></span>
		</div>
		<label id="createDateTip" class="control-label" style="color:red">*</label>
	</div>
	<div class="form-group">
		<label id="typeStateLabel" for="typeState" class="col-sm-2 control-label">是否可用</label>
		<div class="col-sm-7">
			<select class="form-control" id="typeState" name="typeState" isNotNull>
				<option></option>
				<option <#if pointType?? && "Y"==pointType.typeState || !pointType?? && "Y"=="Y">selected</#if> value="Y">是</option>
				<option <#if pointType?? && "N"==pointType.typeState || !pointType?? && "N"=="Y">selected</#if> value="N">否</option>
			</select>
		</div>
		<label id="typeStateTip" class="control-label" style="color:red">*</label>
	</div>
	<div class="form-group">
		<label id="typeDescLabel" for="typeDesc" class="col-sm-2 control-label">描述</label>
		<div class="col-sm-7">
			<input type="text" class="form-control" id="typeDesc" name="typeDesc" value="<#if pointType??>${pointType.typeDesc!}<#else></#if>" />
		</div>
		<label id="typeDescTip" class="control-label" style="color:red"></label>
	</div>
	<div class="form-group">
		<label id="dynamicFieldLabel" for="dynamicField" class="col-sm-2 control-label">动态字段</label>
		<div class="col-sm-7">
			<input type="text" class="form-control" id="dynamicField" name="dynamicField" value='<#if pointType??>${pointType.dynamicField!}<#else></#if>' readonly/>
		</div>
		<label id="dynamicFieldTip" class="control-label" style="color:red"></label>
		<#if !RequestParameters["isQuery"]?? || RequestParameters["isQuery"]=="">
		<a  class="btn btn-success" onclick="editDynamicFields();">
			<i class="glyphicon glyphicon-plus"></i>
    		<span>编辑</span>
		</a>
		<#else>
		<a  class="btn btn-info" onclick="showDynamicFields();">
			<i class="glyphicon glyphicon-zoom-in"></i>
    		<span>查看</span>
		</a>
		</#if>
	</div>
	<div class="form-group">
		<label id="attachmentsLabel" for="attachments" class="col-sm-2 control-label">点类型附件</label>
		<div class="col-sm-7">
      		<div id="attachments" name="attachments" style="border:1px solid">
      		</div>
      	</div>
      	<label id="attachmentsTip" class="control-label" style="color:red"></label>
	</div>
	<input type="hidden" id="pointTypeId" name="pointTypeId" value="<#if pointType??>${pointType.pointTypeId!}</#if>" />
</form>
<#if !RequestParameters["isQuery"]?? || RequestParameters["isQuery"]=="">
<div style="text-align:center">
	<a  class="btn btn-success" onclick="savePointType();">
		<i class="glyphicon glyphicon-save"></i>
		<span>保存</span>
	</a>
</div>
</#if>
</body>
</html>