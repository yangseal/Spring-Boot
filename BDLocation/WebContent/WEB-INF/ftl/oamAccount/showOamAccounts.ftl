<!doctype html>
<html>
<head>
<#include "/head.ftl"/>
<script type="text/javascript" src="${rc.contextPath}/public/js/oamAccount/oamAccounts.js"></script>
</head>
<body>
<form id="oamAccountsForm" action="${rc.contextPath}/oamAccount/queryOamAccounts">
	<div class="form-inline grid-page-condition">
		<div class="form-group">
    		<label>账号名称</label>
    		<input type="text" class="form-control" id="oamAccountName" name="oamAccountName" />
  		</div>
		<div class="form-group has-feedback">
			<#if !RequestParameters["oamCustomerId"]?? || RequestParameters["oamCustomerId"]=="">
			<label>所属客户</label>
    		<input type="text" class="form-control" style="cursor:pointer" id="oamCustomer" name="oamCustomer" onclick="selectOamCustomer();" />
    		<span class="glyphicon glyphicon-menu-hamburger form-control-feedback"></span>
    		</#if>
    		<input type="hidden" id="oamCustomerId" name="oamCustomer.oamCustomerId" value="${RequestParameters["oamCustomerId"]!}" />
		</div>
	</div>
	<div class="grid-page-command">
		<a  class="btn btn-primary" onclick="refreshPage('oamAccountsForm','oamAccountsDiv',1);">
			<i class="glyphicon glyphicon-search"></i>
    		<span>查询</span>
		</a>
		<a  class="btn btn-info" onclick="viewOamAccount();">
			<i class="glyphicon glyphicon-zoom-in"></i>
    		<span>查看</span>
		</a>
		<a  class="btn btn-primary" onclick="exportOamAccounts();">
			<i class="glyphicon glyphicon-log-out"></i>
    		<span>导出</span>
		</a>
		<#if !RequestParameters["isQuery"]?? || RequestParameters["isQuery"]=="">
		<a  class="btn btn-success" onclick="showOamAccount();">
			<i class="glyphicon glyphicon-plus"></i>
    		<span>新增</span>
		</a>
		<a  class="btn btn-warning" onclick="editOamAccount();">
			<i class="glyphicon glyphicon-edit"></i>
    		<span>编辑</span>
		</a>
		<a  class="btn btn-danger" onclick="deleteOamAccount();">
			<i class="glyphicon glyphicon-trash"></i>
    		<span>删除</span>
		</a>
		</#if>
	</div>
	<div id="oamAccountsDiv"></div>
</form>
</body>
</html>
