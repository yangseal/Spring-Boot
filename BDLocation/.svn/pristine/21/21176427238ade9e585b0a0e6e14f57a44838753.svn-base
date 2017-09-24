<!doctype html>
<html>
<head>
<#include "/head.ftl"/>
<script type="text/javascript" src="${rc.contextPath}/public/js/pointTypeAuthorize/pointTypeAuthorizes.js"></script>
</head>
<body>
<form id="pointTypeAuthorizesForm" action="${rc.contextPath}/pointTypeAuthorize/queryPointTypeAuthorizes">
	<div>
	</div>
	<div>
		<a  class="btn btn-primary" onclick="refreshPage('pointTypeAuthorizesForm','pointTypeAuthorizesDiv',1);">
			<i class="glyphicon glyphicon-search"></i>
    		<span>查询</span>
		</a>
		<a  class="btn btn-info" onclick="viewPointTypeAuthorize();">
			<i class="glyphicon glyphicon-zoom-in"></i>
    		<span>查看</span>
		</a>
		<a  class="btn btn-primary" onclick="exportPointTypeAuthorizes();">
			<i class="glyphicon glyphicon-log-out"></i>
    		<span>导出</span>
		</a>
		<#if !RequestParameters["isQuery"]?? || RequestParameters["isQuery"]=="">
		<a  class="btn btn-success" onclick="showPointTypeAuthorize();">
			<i class="glyphicon glyphicon-plus"></i>
    		<span>新增</span>
		</a>
		<a  class="btn btn-warning" onclick="editPointTypeAuthorize();">
			<i class="glyphicon glyphicon-edit"></i>
    		<span>编辑</span>
		</a>
		<a  class="btn btn-danger" onclick="deletePointTypeAuthorize();">
			<i class="glyphicon glyphicon-trash"></i>
    		<span>删除</span>
		</a>
		</#if>
	</div>
	<div id="pointTypeAuthorizesDiv"></div>
</form>
</body>
</html>
