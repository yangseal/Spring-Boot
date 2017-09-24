<!doctype html>
<html>
<head>
<#include "/head.ftl"/>
<script type="text/javascript" src="${rc.contextPath}/public/js/oamDeviceArchives/oamDeviceArchivess.js"></script>
</head>
<body>
<form id="oamDeviceArchivessForm" action="${rc.contextPath}/oamDeviceArchives/queryOamDeviceArchivess">
	<div class="form-inline grid-page-condition">
		<div class="form-group">
    		<label>设备档案标识号</label>
    		<input type="text" class="form-control" id="oamDeviceArchivesCode" name="oamDeviceArchivesCode" />
  		</div>
		<div class="form-group">
    		<label>设备档案名称</label>
    		<input type="text" class="form-control" id="oamDeviceArchivesName" name="oamDeviceArchivesName" />
  		</div>
	</div>
	<div class="grid-page-command">
		<a  class="btn btn-primary" onclick="refreshPage('oamDeviceArchivessForm','oamDeviceArchivessDiv',1);">
			<i class="glyphicon glyphicon-search"></i>
    		<span>查询</span>
		</a>
		<a  class="btn btn-info" onclick="viewOamDeviceArchives();">
			<i class="glyphicon glyphicon-zoom-in"></i>
    		<span>查看</span>
		</a>
		<a  class="btn btn-primary" onclick="exportOamDeviceArchivess();">
			<i class="glyphicon glyphicon-log-out"></i>
    		<span>导出</span>
		</a>
		<#if !RequestParameters["isQuery"]?? || RequestParameters["isQuery"]=="">
		<a  class="btn btn-success" onclick="showOamDeviceArchives();">
			<i class="glyphicon glyphicon-plus"></i>
    		<span>新增</span>
		</a>
		<a  class="btn btn-warning" onclick="editOamDeviceArchives();">
			<i class="glyphicon glyphicon-edit"></i>
    		<span>编辑</span>
		</a>
		<a  class="btn btn-danger" onclick="deleteOamDeviceArchives();">
			<i class="glyphicon glyphicon-trash"></i>
    		<span>删除</span>
		</a>
		</#if>
	</div>
	<div id="oamDeviceArchivessDiv"></div>
</form>
</body>
</html>
