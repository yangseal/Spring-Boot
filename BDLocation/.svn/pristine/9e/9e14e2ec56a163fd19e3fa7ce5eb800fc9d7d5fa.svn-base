<!doctype html>
<html>
<head>
<#include "/head.ftl"/>
<script type="text/javascript" src="${rc.contextPath}/public/js/customerCare/customerCares.js"></script>
</head>
<body>
<form id="customerCaresForm" action="${rc.contextPath}/customerCare/queryCustomerCares">
	<div class="form-inline grid-page-condition">
		<div class="form-group">
    		<label>客服名称</label>
    		<input type="text" class="form-control" id="customerCareName" name="customerCareName" />
  		</div>
	</div>
	<div class="grid-page-command">
		<a  class="btn btn-primary" onclick="refreshPage('customerCaresForm','customerCaresDiv',1);">
			<i class="glyphicon glyphicon-search"></i>
    		<span>查询</span>
		</a>
		<a  class="btn btn-success" onclick="addCustomerCare()">
			<i class="glyphicon glyphicon-plus"></i>
    		<span>新增</span>
		</a>
		<a  class="btn btn-warning" onclick="editCustomerCare()">
			<i class="glyphicon glyphicon-edit"></i>
    		<span>修改</span>
		</a>
		<a  class="btn btn-danger" onclick="deleteCustomerCare()">
			<i class="glyphicon glyphicon-remove"></i>
    		<span>删除</span>
		</a>
	</div>
	<div id="customerCaresDiv"></div>
</form>
</body>
</html>
