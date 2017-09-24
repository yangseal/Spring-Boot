<!doctype html>
<html>
<head>
<#include "/head.ftl"/>
<script type="text/javascript" src="${rc.contextPath}/public/js/conversionProjection/conversionProjections.js"></script>
</head>
<body>
<form id="conversionProjectionsForm" action="${rc.contextPath}/conversionProjection/queryConversionProjections">
	<div class="form-inline grid-page-condition">
		<div class="form-group">
    		<label>转换投影名称</label>
    		<input type="text" class="form-control" id="conversionProjectionName" name="conversionProjectionName" />
  		</div>
		<div class="form-group">
    		<label>转换投影编码</label>
    		<input type="text" class="form-control" id="conversionProjectionCode" name="conversionProjectionCode" />
  		</div>
	</div>
	<div class="grid-page-command">
		<a  class="btn btn-primary" onclick="refreshPage('conversionProjectionsForm','conversionProjectionsDiv',1);">
			<i class="glyphicon glyphicon-search"></i>
    		<span>查询</span>
		</a>
		<a  class="btn btn-info" onclick="viewConversionProjection();">
			<i class="glyphicon glyphicon-zoom-in"></i>
    		<span>查看</span>
		</a>
		<a  class="btn btn-primary" onclick="exportConversionProjections();">
			<i class="glyphicon glyphicon-log-out"></i>
    		<span>导出</span>
		</a>
		<#if !RequestParameters["isQuery"]?? || RequestParameters["isQuery"]=="">
		<a  class="btn btn-success" onclick="showConversionProjection();">
			<i class="glyphicon glyphicon-plus"></i>
    		<span>新增</span>
		</a>
		<a  class="btn btn-warning" onclick="editConversionProjection();">
			<i class="glyphicon glyphicon-edit"></i>
    		<span>编辑</span>
		</a>
		<a  class="btn btn-danger" onclick="deleteConversionProjection();">
			<i class="glyphicon glyphicon-trash"></i>
    		<span>删除</span>
		</a>
		</#if>
	</div>
	<div id="conversionProjectionsDiv"></div>
</form>
</body>
</html>
