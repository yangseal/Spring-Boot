<!DOCTYPE html>
<html>
<head>
<#include "/head.ftl"/>
<script type="text/javascript" src="${rc.contextPath}/public/js/pointType/dynamicField.js"></script>
<link href="${rc.contextPath}/public/js/lib/magicsuggest/magicsuggest-min.css" rel="stylesheet">
<script src="${rc.contextPath}/public/js/lib/magicsuggest/magicsuggest-min.js"></script>
</head>
<body>
<form id="dynamicFieldForm" class="form-horizontal">
	<div class="form-group">
		<label id="dataCodeLabel" for="dataCode" class="col-sm-2 control-label">字段编码</label>
		<div class="col-sm-7">
			<input type="text" class="form-control" id="dataCode" name="dataCode" value="<#if dynamicField??>${dynamicField.dataCode!}</#if>" isNotNull <#if RequestParameters["isEdit"]??>readonly</#if>/>
		</div>
		<label id="dataCodeTip" class="control-label" style="color:red">*</label>
	</div>
	<div class="form-group">
		<label id="dataNameLabel" for="dataName" class="col-sm-2 control-label">字段名称</label>
		<div class="col-sm-7">
			<input type="text" class="form-control" id="dataName" name="dataName" value="<#if dynamicField??>${dynamicField.dataName!}</#if>" isNotNull />
		</div>
		<label id="dataNameTip" class="control-label" style="color:red">*</label>
	</div>
	<div class="form-group">
		<label id="viewTypeLabel" for="viewType" class="col-sm-2 control-label">字段类型</label>
		<div class="col-sm-7">
			<select class="form-control" id="viewType" name="viewType" isNotNull onchange="viewTypeChange()">
				<option value="EditText" <#if dynamicField?? && "EditText"==dynamicField.viewType || !dynamicField?? && "Y"=="Y">selected</#if>>编辑框</option>
				<option value="NumberTextBox" <#if dynamicField?? && "NumberTextBox"==dynamicField.viewType>selected</#if>>数字编辑框</option>
				<option value="RadioGroup" <#if dynamicField?? && "RadioGroup"==dynamicField.viewType>selected</#if>>单选组</option>
				<option value="CheckBoxGroup" <#if dynamicField?? && "CheckBoxGroup"==dynamicField.viewType>selected</#if>>复选组</option>
				<option value="ToggleButton" <#if dynamicField?? && "ToggleButton"==dynamicField.viewType>selected</#if>>滑动开关</option>
				<option value="DropDownList" <#if dynamicField?? && "DropDownList"==dynamicField.viewType>selected</#if>>下拉列表框</option>
				<option value="Date" <#if dynamicField?? && "Date"==dynamicField.viewType>selected</#if>>日期型</option>
				<option value="DateTime" <#if dynamicField?? && "DateTime"==dynamicField.viewType>selected</#if>>日期时间型</option>
				<option value="MultLineTextBox" <#if dynamicField?? && "MultLineTextBox"==dynamicField.viewType>selected</#if>>多行文本输入框</option>
			</select>
		</div>
		<label id="viewTypeTip" class="control-label" style="color:red">*</label>
	</div>
	<div class="form-group">
		<label id="isNotNullLabel" for="isNotNull" class="col-sm-2 control-label">是否可为空</label>
		<div class="col-sm-7">
			<select class="form-control" id="isNotNull" name="isNotNull" isNotNull>
				<option value="false" <#if dynamicField?? && "false"==dynamicField.isNotNull || !dynamicField?? && "false"=="false">selected</#if>>是</option>
				<option value="true" <#if dynamicField?? && "true"==dynamicField.isNotNull>selected</#if>>否</option>
			</select>
		</div>
		<label id="isNotNullTip" class="control-label" style="color:red">*</label>
	</div>
	<div class="form-group">
		<label id="isVisibleLabel" for="isVisible" class="col-sm-2 control-label">是否显示</label>
		<div class="col-sm-7">
			<select class="form-control" id="isVisible" name="isVisible" isNotNull>
				<option value="true" <#if dynamicField?? && "true"==dynamicField.isVisible || !dynamicField?? && "true"=="true">selected</#if>>是</option>
				<option value="false" <#if dynamicField?? && "false"==dynamicField.isVisible>selected</#if>>否</option>
			</select>
		</div>
		<label id="isVisibleTip" class="control-label" style="color:red">*</label>
	</div>
	
	<div class="form-group">
		<label id="defaultValueLabel" for="defaultValue" class="col-sm-2 control-label">默认值</label>
		<div class="col-sm-7">
			<input type="text" class="form-control" id="defaultValue" name="defaultValue" value="<#if dynamicField??>${dynamicField.defaultValue!}</#if>"/>
		</div>
		<label id="defaultValueTip" class="control-label" style="color:red"></label>
	</div>
	<div class="form-group <#if dynamicField?? && !("RadioGroup"==dynamicField.viewType | "CheckBoxGroup"==dynamicField.viewType | "CheckBox"==dynamicField.viewType | "DropDownList"==dynamicField.viewType | "ToggleButton"==dynamicField.viewType) |!dynamicField??>
	hidden</#if>" id="dictionaryDiv">
		<label id="dictionaryLabel" for="dictionary" class="col-sm-2 control-label">字典</label>
		<div class="col-sm-7">
			<input type="text" class="form-control" id="dictionary" name="dictionary" value="<#if dynamicField??>${dynamicField.dictionary!}</#if>"/>
		</div>
		<label id="dictionaryTip" class="control-label" style="color:red">*</label>
	</div>
	<div class="form-group">
		<label id="validStringLabel" for="validString" class="col-sm-2 control-label">正则校验</label>
		<div class="col-sm-7">
			<input type="text" class="form-control" id="validString" name="validString" value="<#if dynamicField??>${dynamicField.validString!}</#if>"/>
		</div>
		<label id="validString" class="control-label" style="color:red"></label>
	</div>
	<input type="hidden" id="pointTypeId" name="pointTypeId" value="${pointTypeId!}" />
</form>

<#if !RequestParameters["isQuery"]?? || RequestParameters["isQuery"]=="">
<div style="text-align:center">
	<a  class="btn btn-success" onclick="saveDynamicField();">
		<i class="glyphicon glyphicon-save"></i>
		<span>保存</span>
	</a>
</div>
</#if>
</body>
</html>