<!doctype html>
<html>
<head>
<#include "/head.ftl"/>
<script type="text/javascript" src="${rc.contextPath}/public/js/pointType/dynamicFields.js"></script>
</head>
<body>
<form id="dynamicFieldsForm" action="${rc.contextPath}/pointType/queryDynamicFields">

	<div class="command-div">
		<a  class="btn btn-info" onclick="viewDynamicField();">
			<i class="glyphicon glyphicon-zoom-in"></i>
    		<span>查看</span>
		</a>
		<#if !RequestParameters["isQuery"]?? || RequestParameters["isQuery"]=="">
		<a  class="btn btn-success" onclick="showDynamicField();">
			<i class="glyphicon glyphicon-plus"></i>
    		<span>新增</span>
		</a>
		<a  class="btn btn-warning" onclick="editDynamicField();">
			<i class="glyphicon glyphicon-edit"></i>
    		<span>编辑</span>
		</a>
		<a  class="btn btn-danger" onclick="deleteDynamicField();">
			<i class="glyphicon glyphicon-trash"></i>
    		<span>删除</span>
		</a>
		</#if>
	</div>
	<div id="dynamicFieldsDiv"></div>
	<input type="hidden" id="pointTypeId" name="pointTypeId" value="${rc.queryString}" />
</form>
</body>
</html>
