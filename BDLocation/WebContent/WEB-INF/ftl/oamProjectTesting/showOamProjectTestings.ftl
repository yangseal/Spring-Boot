<!doctype html>
<html>
<head>
<#include "/head.ftl"/>
<script type="text/javascript" src="${rc.contextPath}/public/js/oamProjectTesting/oamProjectTestings.js"></script>
</head>
<body>
<form id="oamProjectTestingsForm" action="${rc.contextPath}/oamProjectTesting/queryOamProjectTestings">
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
    		<label>项目测试名称</label>
    		<input type="text" class="form-control" id="oamProjectTestingName" name="oamProjectTestingName" />
  		</div>
	</div>
	<div class="grid-page-command">
		<a  class="btn btn-primary" onclick="refreshPage('oamProjectTestingsForm','oamProjectTestingsDiv',1);">
			<i class="glyphicon glyphicon-search"></i>
    		<span>查询</span>
		</a>
		<a  class="btn btn-info" onclick="viewOamProjectTesting();">
			<i class="glyphicon glyphicon-zoom-in"></i>
    		<span>查看</span>
		</a>
		<a  class="btn btn-primary" onclick="exportOamProjectTestings();">
			<i class="glyphicon glyphicon-log-out"></i>
    		<span>导出</span>
		</a>
		<#if !RequestParameters["isQuery"]?? || RequestParameters["isQuery"]=="">
		<a  class="btn btn-success" onclick="showOamProjectTesting();">
			<i class="glyphicon glyphicon-plus"></i>
    		<span>新增</span>
		</a>
		<a  class="btn btn-warning" onclick="editOamProjectTesting();">
			<i class="glyphicon glyphicon-edit"></i>
    		<span>编辑</span>
		</a>
		<a  class="btn btn-danger" onclick="deleteOamProjectTesting();">
			<i class="glyphicon glyphicon-trash"></i>
    		<span>删除</span>
		</a>
		</#if>
	</div>
	<div id="oamProjectTestingsDiv"></div>
</form>
</body>
</html>
