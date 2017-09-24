<!doctype html>
<html>
<head>
<#include "/head.ftl"/>
<script type="text/javascript" src="${rc.contextPath}/public/js/oamProjectConstruction/oamProjectConstructions.js"></script>
</head>
<body>
<form id="oamProjectConstructionsForm" action="${rc.contextPath}/oamProjectConstruction/queryOamProjectConstructions">
	<div class="form-inline grid-page-condition">
		<div class="form-group has-feedback">
			<#if !RequestParameters["oamProjectId"]?? || RequestParameters["oamProjectId"]=="">
			<label>所属项目</label>
    		<input type="text" class="form-control" style="cursor:pointer" id="oamProject" name="oamProject" onclick="selectOamProject();" />
    		<span class="glyphicon glyphicon-menu-hamburger form-control-feedback"></span>
    		</#if>
    		<input type="hidden" id="oamProjectId" name="oamProject.oamProjectId" value="${RequestParameters["oamProjectId"]!}" />
		</div>
		<div class="form-group">
    		<label>项目建设名称</label>
    		<input type="text" class="form-control" id="oamProjectConstructionName" name="oamProjectConstructionName" />
  		</div>
	</div>
	<div class="grid-page-command">
		<a  class="btn btn-primary" onclick="refreshPage('oamProjectConstructionsForm','oamProjectConstructionsDiv',1);">
			<i class="glyphicon glyphicon-search"></i>
    		<span>查询</span>
		</a>
		<a  class="btn btn-info" onclick="viewOamProjectConstruction();">
			<i class="glyphicon glyphicon-zoom-in"></i>
    		<span>查看</span>
		</a>
		<a  class="btn btn-primary" onclick="exportOamProjectConstructions();">
			<i class="glyphicon glyphicon-log-out"></i>
    		<span>导出</span>
		</a>
		<#if !RequestParameters["isQuery"]?? || RequestParameters["isQuery"]=="">
		<a  class="btn btn-success" onclick="showOamProjectConstruction();">
			<i class="glyphicon glyphicon-plus"></i>
    		<span>新增</span>
		</a>
		<a  class="btn btn-warning" onclick="editOamProjectConstruction();">
			<i class="glyphicon glyphicon-edit"></i>
    		<span>编辑</span>
		</a>
		<a  class="btn btn-danger" onclick="deleteOamProjectConstruction();">
			<i class="glyphicon glyphicon-trash"></i>
    		<span>删除</span>
		</a>
		</#if>
	</div>
	<div id="oamProjectConstructionsDiv"></div>
</form>
</body>
</html>
