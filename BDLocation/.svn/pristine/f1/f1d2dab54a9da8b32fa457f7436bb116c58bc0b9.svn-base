<!doctype html>
<html>
<head>
<#include "/head.ftl"/>
<script type="text/javascript" src="${rc.contextPath}/public/js/corsInit/corsInits.js"></script>
</head>
<body>
<form id="corsInitsForm" action="${rc.contextPath}/corsInit/queryCorsInits">
	<div class="form-inline grid-page-condition">
		<div class="form-group">
    		<label>企业名称</label>
    		<input type="text" class="form-control" id="company.companyName" name="company.companyName" />
  		</div>
  		<div class="form-group has-feedback">
    		<label>生成状态</label>
    		<select class="form-control" id="accountCreateState" name="accountCreateState">
				<option></option>
				<option value="YES">已生成</option>
				<option value="NO">未生成</option>
			</select>
  		</div>
	</div>
	<div class="grid-page-command">
		<a  class="btn btn-primary" onclick="refreshPage('corsInitsForm','corsInitsDiv',1);">
			<i class="glyphicon glyphicon-search"></i>
    		<span>查询</span>
		</a>
		<a  class="btn btn-info" onclick="showCorsInit()">
			<i class="glyphicon glyphicon-zoom-in"></i>
    		<span>查看</span>
		</a>
		<a  class="btn btn-danger" onclick="doInit()">
			<i class="glyphicon glyphicon-edit"></i>
    		<span>账号生成</span>
		</a>
		<a  class="btn btn-success" onclick="printOrders()">
			<i class="glyphicon glyphicon-print"></i>
    		<span>打印订单</span>
		</a>
	</div>
	<div id="corsInitsDiv"></div>
</form>
</body>
</html>
