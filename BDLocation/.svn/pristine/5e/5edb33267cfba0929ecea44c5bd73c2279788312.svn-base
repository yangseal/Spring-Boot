<!doctype html>
<html>
<head>
<#include "/head.ftl"/>
<script type="text/javascript" src="${rc.contextPath}/public/js/corsActive/actives.js"></script>
</head>
<body>
<form id="corsActivesForm" action="${rc.contextPath}/corsActive/queryActives">
	<div class="form-inline grid-page-condition">
		<div class="form-group">
    		<label>企业名称</label>
    		<input type="text" class="form-control" id="company.companyName" name="company.companyName" />
    		<input type="hidden" id="company.companyId" name="company.companyId" value="<#if CURRENT_USER?? && CURRENT_USER.company?? >${CURRENT_USER.company.companyId!}</#if>"/>
  		</div>
  		<div class="form-group has-feedback">
    		<label>状态</label>
    		<select class="form-control" id="accountActiveState" name="accountActiveState">
				<option></option>
				<option value="0">未完成</option>
				<option value="1">已完成</option>
			</select>
  		</div>
	</div>
	<div class="grid-page-command">
		<a  class="btn btn-primary" onclick="refreshPage('corsActivesForm','corsActivesDiv',1);">
			<i class="glyphicon glyphicon-search"></i>
    		<span>查询</span>
		</a>
		<a  class="btn btn-warning" onclick="doActive('ACTIVE');">
			<i class="glyphicon glyphicon-edit"></i>
    		<span>激活</span>
		</a>
<#--		<a  class="btn btn-warning" onclick="doActive('REPAY');">
			<i class="glyphicon glyphicon-edit"></i>
    		<span>账号续费</span>
		</a>   -->
	</div>
	<div id="corsActivesDiv"></div>
</form>
</body>
</html>
