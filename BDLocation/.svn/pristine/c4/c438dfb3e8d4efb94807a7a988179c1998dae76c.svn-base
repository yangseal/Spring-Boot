<!doctype html>
<html>
<head>
<#include "/head.ftl"/>
<script type="text/javascript" src="${rc.contextPath}/public/js/dict/dict.js"></script>
</head>
<body>
<#if RequestParameters["dictId"]??>
<ul class="nav nav-tabs" role="tablist">
    <li role="presentation" class="active"><a href="#basicTab" aria-controls="basicTab" role="tab" data-toggle="tab">基础信息</a></li>
    <li role="presentation"><a href="#dictItemsTab" aria-controls="dictItemsTab" role="tab" data-toggle="tab">字典项列表</a></li>
</ul>
<div class="tab-content">
    <div role="tabpanel" class="tab-pane active" id="basicTab">
</#if>
    
<form id="dictForm" class="form-horizontal">
	<div class="form-group">
		<label id="dictNameLabel" for="dictName" class="col-sm-2 control-label">字典名称</label>
		<div class="col-sm-7">
      		<input type="text" class="form-control" id="dictName" name="dictName" value="<#if dict??>${dict.dictName!}</#if>" isNotNull />
      	</div>
      	<label id="dictNameTip" class="control-label" style="color:red">*</label>
	</div>
	<div class="form-group">
		<label id="dictCodeLabel" for="dictCode" class="col-sm-2 control-label">字典编号</label>
		<div class="col-sm-7">
      		<input type="text" class="form-control" id="dictCode" name="dictCode" value="<#if dict??>${dict.dictCode!}</#if>" />
      	</div>
      	<label id="dictCodeTip" class="control-label" style="color:red"></label>
	</div>
	<input type="hidden" id="dictId" name="dictId" value="<#if dict??>${dict.dictId!}</#if>" />
</form>
<#if !RequestParameters["isQuery"]??>
<div style="text-align:center">
	<a  class="btn btn-success" onclick="saveDict();">
		<i class="glyphicon glyphicon-save"></i>
    	<span>保存</span>
	</a>
	<a  class="btn btn-primary" onclick="javascript:;">
		<i class="glyphicon glyphicon-ok"></i>
    	<span>其它</span>
	</a>
</div>
</#if>
    
<#if RequestParameters["dictId"]??>
	</div>
<div role="tabpanel" class="tab-pane" id="dictItemsTab">
   	<iframe code="dictDictItems" frameborder=0 width="100%" src="${rc.contextPath}/dictItem/showDictItems?${rc.queryString!}" />
</div>
</div>
</#if>
</body>
</html>
