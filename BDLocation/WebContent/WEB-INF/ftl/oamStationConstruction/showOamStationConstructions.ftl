<!doctype html>
<html>
<head>
<#include "/head.ftl"/>
<script type="text/javascript" src="${rc.contextPath}/public/js/oamStationConstruction/oamStationConstructions.js"></script>
</head>
<body>
<form id="oamStationConstructionsForm" action="${rc.contextPath}/oamStationConstruction/queryOamStationConstructions">
	<div class="form-inline grid-page-condition">
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
		<a  class="btn btn-primary" onclick="refreshPage('oamStationConstructionsForm','oamStationConstructionsDiv',1);">
			<i class="glyphicon glyphicon-search"></i>
    		<span>查询</span>
		</a>
		<a  class="btn btn-info" onclick="viewOamStationConstruction();">
			<i class="glyphicon glyphicon-zoom-in"></i>
    		<span>查看</span>
		</a>
		<a  class="btn btn-primary" onclick="exportOamStationConstructions();">
			<i class="glyphicon glyphicon-log-out"></i>
    		<span>导出</span>
		</a>
		<#if !RequestParameters["isQuery"]?? || RequestParameters["isQuery"]=="">
		<a  class="btn btn-success" onclick="showOamStationConstruction();">
			<i class="glyphicon glyphicon-plus"></i>
    		<span>新增</span>
		</a>
		<a  class="btn btn-warning" onclick="editOamStationConstruction();">
			<i class="glyphicon glyphicon-edit"></i>
    		<span>编辑</span>
		</a>
		<a  class="btn btn-danger" onclick="deleteOamStationConstruction();">
			<i class="glyphicon glyphicon-trash"></i>
    		<span>删除</span>
		</a>
		</#if>
	</div>
	<div id="oamStationConstructionsDiv"></div>
</form>
</body>
</html>
