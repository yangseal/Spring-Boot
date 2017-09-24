<!doctype html>
<html>
<head>
<#include "/head.ftl"/>
<script type="text/javascript" src="${rc.contextPath}/public/js/dict/dictItems.js"></script>
</head>
<body>
<form id="dictItemsForm" action="${rc.contextPath}/dictItem/queryDictItems">
	<div>
		<input type="hidden" id="dictId" name="dictId" value="${RequestParameters["dictId"]!}" />
	</div>
	<div class="command-div">
		<a  class="btn btn-primary" onclick="refreshPage('dictItemsForm','dictItemsDiv',1);">
			<i class="glyphicon glyphicon-search"></i>
    		<span>查询</span>
		</a>
		<a  class="btn btn-info" onclick="viewDictItem();">
			<i class="glyphicon glyphicon-zoom-in"></i>
    		<span>查看</span>
		</a>
		<#if !RequestParameters["isQuery"]?? || RequestParameters["isQuery"]=="">
		<a  class="btn btn-success" onclick="showDictItem();">
			<i class="glyphicon glyphicon-plus"></i>
    		<span>新增</span>
		</a>
		<a  class="btn btn-warning" onclick="editDictItem();">
			<i class="glyphicon glyphicon-edit"></i>
    		<span>编辑</span>
		</a>
		<a  class="btn btn-danger" onclick="deleteDictItem();">
			<i class="glyphicon glyphicon-trash"></i>
    		<span>删除</span>
		</a>
		</#if>
	</div>
	<div id="dictItemsDiv"></div>
</form>
</body>
</html>
