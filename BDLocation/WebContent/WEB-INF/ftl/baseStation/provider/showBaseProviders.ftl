<!doctype html>
<html>
<head>
<#include "/head.ftl"/>
<script type="text/javascript" src="${rc.contextPath}/public/js/baseStation/provider/baseProvider.js"></script>
</head>
<body>
<form id="baseProviderForm" action="${rc.contextPath}/baseStation/provider/queryBaseProvider">
	<div class="form-inline grid-page-condition">
		<div class="form-group">
    		<label>供应商名称</label>
    		<input type="text" class="form-control" id="providerName" name="providerName" />
  		</div>
	</div>

	<div class="command-div">
		<a class="btn btn-primary" onclick="refreshPage('baseProviderForm','baseProviderDiv',1);">
			<i class="glyphicon glyphicon-search"></i>
    		<span>查询</span>
		</a>

		<a class="btn btn-success" onclick="showProvider();">
			<i class="glyphicon glyphicon-plus"></i>
    		<span>新增</span>
		</a>
		<a class="btn btn-warning" onclick="editProvider();">
			<i class="glyphicon glyphicon-edit"></i>
    		<span>编辑</span>
		</a>
	</div>
	<div id="baseProviderDiv"></div>
</form>
</body>
</html>
