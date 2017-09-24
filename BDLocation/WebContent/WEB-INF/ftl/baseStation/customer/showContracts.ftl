<!doctype html>
<html>
<head>
<#include "/head.ftl"/>
<script type="text/javascript" src="${rc.contextPath}/public/js/baseStation/customer/showContracts.js"></script>
</head>
<body>
<form id="contractsForm" action="${rc.contextPath}/baseStation/customer/queryContracts">
	<input type="hidden" name="baseCustomer.baseCustomerId" id="baseCustomerId" value="${baseCustomerId!}" />
	<div class="form-inline grid-page-condition">
		<div class="form-group">
    		<label>合同编号</label>
    		<input type="text" class="form-control" id="custContractNo" name="custContractNo" />
  		</div>
  		<div class="form-group">
    		<label>合同名称</label>
    		<input type="text" class="form-control" id="custContractName" name="custContractName" />
  		</div>
	</div>
	<div class="grid-page-command">
		<a class="btn btn-primary" onclick="refreshPage('contractsForm','contractsDiv',1);">
			<i class="glyphicon glyphicon-search"></i>
    		<span>查询</span>
		</a>
		<a  class="btn btn-success" onclick="addContract();">
			<i class="glyphicon glyphicon-plus"></i>
    		<span>新增合同</span>
		</a>
		<a  class="btn btn-warning" onclick="editContract();">
			<i class="glyphicon glyphicon-edit"></i>
    		<span>信息修改</span>
		</a>
	</div>
	<div id="contractsDiv"></div>
</form>
</body>
</html>
