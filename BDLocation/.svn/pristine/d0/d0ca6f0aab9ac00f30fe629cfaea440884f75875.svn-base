<!doctype html>
<html>
<head>
<#include "/head.ftl"/>
<script type="text/javascript" src="${rc.contextPath}/public/js/corsRepay/repays.js"></script>
</head>
<body>
<form id="corsRepaysForm" action="${rc.contextPath}/corsRepay/queryRepays">
	<div class="form-inline grid-page-condition">
		<div class="form-group">
    		<label>企业名称</label>
    		<input type="text" class="form-control" id="company.companyName" name="company.companyName" />
    		<input type="hidden" id="company.companyId" name="company.companyId" value="<#if CURRENT_USER?? && CURRENT_USER.company?? >${CURRENT_USER.company.companyId!}</#if>"/>
  		</div>
  		<div class="form-group has-feedback">
    		<label>操作状态</label>
    		<select class="form-control" id="repayActiveState" name="repayActiveState">
				<option></option>
				<option value="0">未处理</option>
				<option value="1">已处理</option>
			</select>
  		</div>
	</div>
	<div class="grid-page-command">
		<a  class="btn btn-primary" onclick="refreshPage('corsRepaysForm','corsRepaysDiv',1);">
			<i class="glyphicon glyphicon-search"></i>
    		<span>查询</span>
		</a>
	</div>
	<div id="corsRepaysDiv"></div>
</form>
</body>
</html>
