<!doctype html>
<html>
<head>
<#include "/head.ftl"/>                                                              
<script type="text/javascript" src="${rc.contextPath}/public/js/baseStation/customer/showCustomers.js"></script>
</head>
<body>
<form id="customersForm" action="${rc.contextPath}/baseStation/customer/queryCustomers">
	<input type="hidden" name="baseCustomer.baseCustomerId" id="baseCustomerId" value="${baseCustomerId!}" />
	<div class="form-inline grid-page-condition">
		<div class="form-group">
    		<label>姓名</label>
    		<input type="text" class="form-control" id="custUserName" name="custUserName" />
  		</div>
	</div>
	<div class="grid-page-command">
		<a class="btn btn-primary" onclick="refreshPage('customersForm','customersDiv',1);">
			<i class="glyphicon glyphicon-search"></i>
    		<span>查询</span>
		</a>
		<a  class="btn btn-success" onclick="addCustomer()">
			<i class="glyphicon glyphicon-plus"></i>
    		<span>新增联系人</span>
		</a>
		<a  class="btn btn-warning" onclick="editCustomer();">
			<i class="glyphicon glyphicon-edit"></i>
    		<span>信息修改</span>
		</a>
		<a  class="btn btn-danger" onclick="deleteCustomer();">
			<i class="glyphicon glyphicon-remove"></i>
    		<span>删除</span>
		</a>
	</div>
	<div id="customersDiv"></div>
</form>
</body>
</html>
