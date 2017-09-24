<!doctype html>
<html>
<head>
<#include "/head.ftl"/>
<script type="text/javascript" src="${rc.contextPath}/public/js/oamBaseStation/oamBaseStations.js"></script>
</head>
<body>
<form id="oamBaseStationsForm" action="${rc.contextPath}/oamBaseStation/queryOamBaseStations">
	<div class="form-inline grid-page-condition">
		<div class="form-group has-feedback">
			<#if !RequestParameters["oamAreaId"]?? || RequestParameters["oamAreaId"]=="">
			<label>所属地区</label>
    		<input type="text" class="form-control" style="cursor:pointer" id="oamArea" name="oamArea" onclick="selectOamArea();" />
    		<span class="glyphicon glyphicon-menu-hamburger form-control-feedback"></span>
    		</#if>
    		<input type="hidden" id="oamAreaId" name="oamArea.oamAreaId" value="${RequestParameters["oamAreaId"]!}" />
		</div>
	</div>
	<div class="grid-page-command">
		<a  class="btn btn-primary" onclick="refreshPage('oamBaseStationsForm','oamBaseStationsDiv',1);">
			<i class="glyphicon glyphicon-search"></i>
    		<span>查询</span>
		</a>
		<a  class="btn btn-info" onclick="viewOamBaseStation();">
			<i class="glyphicon glyphicon-zoom-in"></i>
    		<span>查看</span>
		</a>
		<a  class="btn btn-primary" onclick="exportOamBaseStations();">
			<i class="glyphicon glyphicon-log-out"></i>
    		<span>导出</span>
		</a>
		<#if !RequestParameters["isQuery"]?? || RequestParameters["isQuery"]=="">
		<a  class="btn btn-success" onclick="showOamBaseStation();">
			<i class="glyphicon glyphicon-plus"></i>
    		<span>新增</span>
		</a>
		<a  class="btn btn-warning" onclick="editOamBaseStation();">
			<i class="glyphicon glyphicon-edit"></i>
    		<span>编辑</span>
		</a>
		<a  class="btn btn-danger" onclick="deleteOamBaseStation();">
			<i class="glyphicon glyphicon-trash"></i>
    		<span>删除</span>
		</a>
		</#if>
	</div>
	<div id="oamBaseStationsDiv"></div>
</form>
</body>
</html>
