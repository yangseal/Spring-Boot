<!doctype html>
<html>
<head>
<#include "/head.ftl"/>
<script type="text/javascript" src="${rc.contextPath}/public/js/baseStation/customer/showBaseCustomers.js"></script>
</head>
<body>
<form id="baseCustomersForm" action="${rc.contextPath}/baseStation/customer/queryBaseCustomers">
	<div class="form-inline grid-page-condition">
		<div class="form-group">
    		<label>客户名称</label>
    		<input type="text" class="form-control" id="customerName" name="customerName" />
  		</div>
	</div>
	
	<div class="grid-page-command">
		<a class="btn btn-primary" onclick="refreshPage('baseCustomersForm','baseCustomersDiv',1);">
			<i class="glyphicon glyphicon-search"></i>
    		<span>查询</span>
		</a>
		<a  class="btn btn-primary" onclick="addBaseCustomer();">
			<i class="glyphicon glyphicon-plus"></i>
    		<span>新增客户</span>
		</a>
		<a  class="btn btn-warning" onclick="editBaseCustomer();">
			<i class="glyphicon glyphicon-edit"></i>
    		<span>信息修改</span>
		</a>
	</div>
	<div id="baseCustomersDiv"></div>
</form>
</body>
</html>
