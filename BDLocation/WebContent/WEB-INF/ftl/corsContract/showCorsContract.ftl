<!doctype html>
<html>
<head>
<#include "/head.ftl"/>
<script type="text/javascript" src="${rc.contextPath}/public/js/corsContract/addCorsContract.js"></script>
</head>
<body>
<form id="corsContractShowForm" action="${rc.contextPath}/corsContract/queryCorsContract">
	<div class="form-inline grid-page-condition">
		<div class="form-group">
    		<label>客户名称</label>
    		<input type="text" class="form-control" id="corsContractCusName" name="corsContractCusName" />
  		</div>
	</div>
	<div class="grid-page-command">
		<a class="btn btn-primary" onclick="refreshPage('corsContractShowForm','corsContractShowDiv',1);">
			<i class="glyphicon glyphicon-search"></i>
    		<span>查询</span>
		</a>
		<a  class="btn btn-success" onclick="addCorsContract();">
			<i class="glyphicon glyphicon-plus"></i>
    		<span>新增账号</span>
		</a>
		<a  class="btn btn-warning" onclick="editCorsContract();">
			<i class="glyphicon glyphicon-edit"></i>
    		<span>信息修改</span>
		</a>
		<a class="btn btn-danger" onclick="deleteCorsContract();">
			<i class="glyphicon glyphicon-trash"></i>
    		<span>删除</span>
		</a>
	</div>
	<div id="corsContractShowDiv"></div>
</form>
</body>
</html>
