<!doctype html>
<html>
<head>
<#include "/head.ftl"/>
<script type="text/javascript" src="${rc.contextPath}/public/js/measurePoint/measurePoints.js"></script>
</head>
<body>
<form id="measurePointsForm" action="${rc.contextPath}/measurePoint/queryMeasurePoints">
	<div>
		<input type="hidden" id="affiliationProjectId" name="affiliationProjectId" value="${RequestParameters["measureProjectId"]!}" />
		<input type="hidden" id="pointTypeCode" name="affiliationPointType.pointTypeCode" value="${RequestParameters["pointTypeCode"]!}" />
	</div>
	<div class="command-div">
		<#--
		<a  class="btn btn-primary" onclick="refreshPage('measurePointsForm','measurePointsDiv',1);">
			<i class="glyphicon glyphicon-search"></i>
    		<span>查询</span>
		</a>
		-->
		<a  class="btn btn-info" onclick="viewMeasurePoint();">
			<i class="glyphicon glyphicon-zoom-in"></i>
    		<span>查看</span>
		</a>
		<a  class="btn btn-primary" onclick="viewMeasurePointMap();">
			<i class="glyphicon glyphicon-map-marker"></i>
    		<span>查看地图</span>
		</a>
		<#--
		<a  class="btn btn-primary" onclick="exportMeasurePoints();">
			<i class="glyphicon glyphicon-log-out"></i>
    		<span>导出</span>
		</a>
		-->
		<#if !RequestParameters["isQuery"]?? || RequestParameters["isQuery"]=="">
		<a style="display:none;" class="btn btn-success" onclick="showMeasurePoint();">
			<i class="glyphicon glyphicon-plus"></i>
    		<span>新增</span>
		</a>
		<a style="display:none;" class="btn btn-warning" onclick="editMeasurePoint();">
			<i class="glyphicon glyphicon-edit"></i>
    		<span>编辑</span>
		</a>
		<a  class="btn btn-danger" onclick="deleteMeasurePoint();">
			<i class="glyphicon glyphicon-trash"></i>
    		<span>删除</span>
		</a>
		</#if>
	</div>
	<div id="measurePointsDiv"></div>
</form>
</body>
</html>
