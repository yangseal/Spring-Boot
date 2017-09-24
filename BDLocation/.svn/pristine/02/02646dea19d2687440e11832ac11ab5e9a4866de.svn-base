<!doctype html>
<html>
<head>
<#include "/head.ftl"/>
<script type="text/javascript" src="${rc.contextPath}/public/js/customerCare/customerCares.js"></script>
</head>
<body>
<form id="customerCareForm" class="form-horizontal">
	<input type="hidden" id="customerCareId" name="customerCareId" value="<#if customerCare??>${customerCare.bdCustomerCareId!}<#else></#if>"/>

	<div class="form-group pt15">
		<label id="applyCountLabel" for="applyCount" class="col-sm-2 control-label">客服编号</label>
		<div class="col-sm-8">
			<input type="text" class="form-control"  name="customerCareNo" value="<#if customerCare??>${customerCare.customerCareNo!}<#else></#if>" />
		</div>
	</div>
	<div class="form-group pt15">
		<label id="applyCountLabel" for="applyCount" class="col-sm-2 control-label">客服名称</label>
		<div class="col-sm-8">
			<input type="text" class="form-control"  name="customerCareName" value="<#if customerCare??>${customerCare.customerCareName!}<#else></#if>" />
		</div>
	</div>
	<div class="form-group pt15">
		<label id="applyCountLabel" for="applyCount" class="col-sm-2 control-label">是否在线</label>
		<div class="col-sm-8">
			<input type="text" class="form-control" readOnly name="isOnline" value="<#if customerCare??>${customerCare.isOnline!}<#else></#if>" />
		</div>
	</div>

	<div id="footer" style="text-align:center">
		<a  class="btn btn-success" onclick="saveCustomerCare();">
			<i class="glyphicon glyphicon-ok"></i>
			<span>保存</span>
		</a>
	</div>
</form>
</body>
</html>