<!doctype html>
<html>
<head>
<#include "/head.ftl"/>
<script type="text/javascript" src="${rc.contextPath}/public/js/oamProject/oamProjects.js"></script>
</head>
<body>
<form id="oamProjectsForm" action="${rc.contextPath}/oamProject/queryOamProjects">
	<div class="form-inline grid-page-condition">
		<div class="form-group">
    		<label>项目名称</label>
    		<input type="text" class="form-control" id="oamProjectName" name="oamProjectName" />
  		</div>
		<div class="form-group">
    		<label>项目编号</label>
    		<input type="text" class="form-control" id="oamProjectCode" name="oamProjectCode" />
  		</div>
		<div class="form-group has-feedback">
			<#if !RequestParameters["oamCustomerId"]?? || RequestParameters["oamCustomerId"]=="">
			<label>所属客户</label>
    		<input type="text" class="form-control" style="cursor:pointer" id="oamCustomer" name="oamCustomer" onclick="selectOamCustomer();" />
    		<span class="glyphicon glyphicon-menu-hamburger form-control-feedback"></span>
    		</#if>
    		<input type="hidden" id="oamCustomerId" name="oamCustomerId" value="${RequestParameters["oamCustomerId"]!}" />
		</div>
	</div>
	<div class="grid-page-command">
		<a  class="btn btn-primary" onclick="refreshPage('oamProjectsForm','oamProjectsDiv',1);">
			<i class="glyphicon glyphicon-search"></i>
    		<span>查询</span>
		</a>
		<a  class="btn btn-info" onclick="viewOamProject();">
			<i class="glyphicon glyphicon-zoom-in"></i>
    		<span>查看</span>
		</a>
		<a  class="btn btn-primary" onclick="exportOamProjects();">
			<i class="glyphicon glyphicon-log-out"></i>
    		<span>导出</span>
		</a>
		<#if !RequestParameters["isQuery"]?? || RequestParameters["isQuery"]=="">
		<a  class="btn btn-success" onclick="showOamProject();">
			<i class="glyphicon glyphicon-plus"></i>
    		<span>新增</span>
		</a>
		<a  class="btn btn-warning" onclick="editOamProject();">
			<i class="glyphicon glyphicon-edit"></i>
    		<span>编辑</span>
		</a>
		<a  class="btn btn-danger" onclick="deleteOamProject();">
			<i class="glyphicon glyphicon-trash"></i>
    		<span>删除</span>
		</a>
		</#if>
	</div>
	<div id="oamProjectsDiv"></div>
</form>
</body>
</html>
