<!doctype html>
<html>
<head>
<#include "/head.ftl"/>
<script type="text/javascript" src="${rc.contextPath}/public/js/pointType/pointTypes.js"></script>
</head>
<body>
<form id="pointTypesForm" action="${rc.contextPath}/pointType/queryPointTypes">
	<div class="form-inline">
		<div class="form-group">
    		<label>编码</label>
    		<input type="text" class="form-control" id="pointTypeCode" name="pointTypeCode">
  		</div>
		<div class="form-group">
    		<label>名称</label>
    		<input type="text" class="form-control" id="pointTypeName" name="pointTypeName">
  		</div>
	</div>
	<div class="command-div">
		<a  class="btn btn-primary" onclick="refreshPage('pointTypesForm','pointTypesDiv',1);">
			<i class="glyphicon glyphicon-search"></i>
    		<span>查询</span>
		</a>
		<a  class="btn btn-info" onclick="viewPointType();">
			<i class="glyphicon glyphicon-zoom-in"></i>
    		<span>查看</span>
		</a>
		<a  class="btn btn-primary" onclick="exportPointTypes();">
			<i class="glyphicon glyphicon-log-out"></i>
    		<span>导出</span>
		</a>
		<#if !RequestParameters["isQuery"]?? || RequestParameters["isQuery"]=="">
		<a  class="btn btn-success" onclick="showPointType();">
			<i class="glyphicon glyphicon-plus"></i>
    		<span>新增</span>
		</a>
		<a  class="btn btn-warning" onclick="editPointType();">
			<i class="glyphicon glyphicon-edit"></i>
    		<span>编辑</span>
		</a>
		<a  class="btn btn-danger" onclick="deletePointType();">
			<i class="glyphicon glyphicon-trash"></i>
    		<span>删除</span>
		</a>
		</#if>
	</div>
	<div id="pointTypesDiv"></div>
</form>
</body>
</html>
