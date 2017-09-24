<!doctype html>
<html>
<head>
<#include "/head.ftl"/>
<script type="text/javascript" src="${rc.contextPath}/public/js/dict/dictItem.js"></script>
</head>
<body>
<form id="dictItemForm" class="form-horizontal">
	<div class="form-group">
		<label id="dictItemNameLabel" for="dictItemName" class="col-sm-2 control-label">字典项名称</label>
		<div class="col-sm-7">
      		<input type="text" class="form-control" id="dictItemName" name="dictItemName" value="<#if dictItem??>${dictItem.dictItemName!}</#if>" isNotNull />
      	</div>
      	<label id="dictItemNameTip" class="control-label" style="color:red">*</label>
	</div>
	<div class="form-group">
		<label id="dictItemCodeLabel" for="dictItemCode" class="col-sm-2 control-label">字典项编号</label>
		<div class="col-sm-7">
      		<input type="text" class="form-control" id="dictItemCode" name="dictItemCode" value="<#if dictItem??>${dictItem.dictItemCode!}</#if>" />
      	</div>
      	<label id="dictItemCodeTip" class="control-label" style="color:red"></label>
	</div>
	<input type="hidden" id="dictId" name="dictId" value="<#if dictItem??&&dictItem.dict??>${dictItem.dict.dictId!}<#else>${RequestParameters["dictId"]!}</#if>" />
	<input type="hidden" id="dictItemId" name="dictItemId" value="<#if dictItem??>${dictItem.dictItemId!}</#if>" />
</form>
<#if !RequestParameters["isQuery"]??>
<div style="text-align:center">
	<a  class="btn btn-success" onclick="saveDictItem();">
		<i class="glyphicon glyphicon-save"></i>
    	<span>保存</span>
	</a>
	<a  class="btn btn-primary" onclick="javascript:;">
		<i class="glyphicon glyphicon-ok"></i>
    	<span>其它</span>
	</a>
</div>
</#if>
</body>
</html>
