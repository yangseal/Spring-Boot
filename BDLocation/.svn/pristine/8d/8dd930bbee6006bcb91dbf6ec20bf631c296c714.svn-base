<!doctype html>
<html>
<head>
<#include "/head.ftl"/>
<script type="text/javascript" src="${rc.contextPath}/public/js/oamStationTesting/oamStationTestings.js"></script>
</head>
<body>
<form id="oamStationTestingsForm" action="${rc.contextPath}/oamStationTesting/queryOamStationTestings">
	<div class="form-inline grid-page-condition">
		<div class="form-group has-feedback">
			<#if !RequestParameters["oamProjectTestingId"]?? || RequestParameters["oamProjectTestingId"]=="">
			<label>所属项目测试</label>
    		<input type="text" class="form-control" style="cursor:pointer" id="oamProjectTesting" name="oamProjectTesting" onclick="selectOamProjectTesting();" />
    		<span class="glyphicon glyphicon-menu-hamburger form-control-feedback"></span>
    		</#if>
    		<input type="hidden" id="oamProjectTestingId" name="oamProjectTesting.oamProjectTestingId" value="${RequestParameters["oamProjectTestingId"]!}" />
		</div>
		<div class="form-group has-feedback">
			<#if !RequestParameters["oamBaseStationId"]?? || RequestParameters["oamBaseStationId"]=="">
			<label>基站</label>
    		<input type="text" class="form-control" style="cursor:pointer" id="oamBaseStation" name="oamBaseStation" onclick="selectOamBaseStation();" />
    		<span class="glyphicon glyphicon-menu-hamburger form-control-feedback"></span>
    		</#if>
    		<input type="hidden" id="oamBaseStationId" name="oamBaseStation.oamBaseStationId" value="${RequestParameters["oamBaseStationId"]!}" />
		</div>
	</div>
	<div class="grid-page-command">
		<a  class="btn btn-primary" onclick="refreshPage('oamStationTestingsForm','oamStationTestingsDiv',1);">
			<i class="glyphicon glyphicon-search"></i>
    		<span>查询</span>
		</a>
		<a  class="btn btn-info" onclick="viewOamStationTesting();">
			<i class="glyphicon glyphicon-zoom-in"></i>
    		<span>查看</span>
		</a>
		<a  class="btn btn-primary" onclick="exportOamStationTestings();">
			<i class="glyphicon glyphicon-log-out"></i>
    		<span>导出</span>
		</a>
		<#if !RequestParameters["isQuery"]?? || RequestParameters["isQuery"]=="">
		<a  class="btn btn-success" onclick="showOamStationTesting();">
			<i class="glyphicon glyphicon-plus"></i>
    		<span>新增</span>
		</a>
		<a  class="btn btn-warning" onclick="editOamStationTesting();">
			<i class="glyphicon glyphicon-edit"></i>
    		<span>编辑</span>
		</a>
		<a  class="btn btn-danger" onclick="deleteOamStationTesting();">
			<i class="glyphicon glyphicon-trash"></i>
    		<span>删除</span>
		</a>
		</#if>
	</div>
	<div id="oamStationTestingsDiv"></div>
</form>
</body>
</html>
