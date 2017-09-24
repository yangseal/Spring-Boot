<!doctype html>
<html>
<head>
<#include "/head.ftl"/>
<script type="text/javascript" src="${rc.contextPath}/public/js/corsApprove/corsApproves.js"></script>
</head>
<body>
<form id="corsApprovesForm" action="${rc.contextPath}/corsApprove/queryApproves">
	<div class="form-inline grid-page-condition">
		<div class="form-group">
    		<label>企业名称</label>
    		<input type="text" class="form-control" id="companyName" name="companyName" />
  		</div>
  		<div class="form-group has-feedback">
    		<label>审核状态</label>
    		<select class="form-control" id="applyStatus" name="applyStatus">
				<option></option>
				<option value="4">已提交</option>
				<option value="5">已完成</option>
				<option value="6">已取消</option>
			</select>
  		</div>
  		<div class="form-group">
    		<label>订单号</label>
    		<input type="text" class="form-control" id="orderNo" name="orderNo" />
  		</div>
  		<div class="form-group">
    		<label>订单类型</label>
    		<select class="form-control" id="orderType" name="orderType">
				<option></option>
				<option value="torder">试用订单</option>
				<option value="forder">购买订单</option>
				<option value="rorder">续费订单</option>
			</select>
  		</div>
	</div>
	<div class="grid-page-command">
		<a  class="btn btn-primary" onclick="refreshPage('corsApprovesForm','corsApprovesDiv',1);">
			<i class="glyphicon glyphicon-search"></i>
    		<span>查询</span>
		</a>
	</div>
	<div id="corsApprovesDiv"></div>
</form>
</body>
</html>
