<!doctype html>
<html>
<head>
<#include "/head.ftl"/>
<script type="text/javascript" src="${rc.contextPath}/public/js/oamAccount/oamAccount.js"></script>
</head>
<body>

<form id="oamAccountForm" class="form-horizontal">
	<div class="form-group">
		<label id="oamAccountNameLabel" for="oamAccountName" class="col-sm-2 control-label">账号名称</label>
		<div class="col-sm-7">
			<input type="text" class="form-control" id="oamAccountName" name="oamAccountName" isNotNull value="<#if oamAccount??>${oamAccount.oamAccountName!}<#else></#if>" />
		</div>
		<label id="oamAccountNameTip" class="control-label" style="color:red">*</label>
	</div>
	<div class="form-group">
		<label id="pwdLabel" for="pwd" class="col-sm-2 control-label">账号密码</label>
		<div class="col-sm-7">
			<input type="text" class="form-control" id="pwd" name="pwd" isNotNull value="<#if oamAccount??>${oamAccount.pwd!}<#else></#if>" />
		</div>
		<label id="pwdTip" class="control-label" style="color:red">*</label>
	</div>
	<#if !RequestParameters["oamCustomerId"]?? || RequestParameters["oamCustomerId"]=="">
	<div class="form-group has-feedback">
		<label id="oamCustomerLabel" for="oamCustomer" class="col-sm-2 control-label">所属客户</label>
		<div class="col-sm-7">
			<input type="text" class="form-control" style="cursor:pointer" id="oamCustomer" name="oamCustomer" value="<#if oamAccount?? && oamAccount.oamCustomer??>${oamAccount.oamCustomer.oamCustomerName!}</#if>" onclick="selectOamCustomer();" />
			<span class="glyphicon glyphicon-menu-hamburger form-control-feedback"></span>
		</div>
		<label id="oamCustomerTip" class="control-label" style="color:red"></label>
	</div>
	</#if>
	<input type="hidden" id="oamCustomerId" name="oamCustomer.oamCustomerId" value="<#if oamAccount?? && oamAccount.oamCustomer??>${oamAccount.oamCustomer.oamCustomerId!}<#else>${RequestParameters["oamCustomerId"]!}</#if>" />
	<div class="form-group">
		<label id="loginNumLabel" for="loginNum" class="col-sm-2 control-label">登录次数</label>
		<div class="col-sm-7">
			<input type="text" class="form-control" id="loginNum" name="loginNum" value="<#if oamAccount??>${oamAccount.loginNum!}<#else>0</#if>" />
		</div>
		<label id="loginNumTip" class="control-label" style="color:red"></label>
	</div>
	<div class="form-group">
		<label id="accountStatusLabel" for="accountStatus" class="col-sm-2 control-label">是否在线</label>
		<div class="col-sm-7">
			<select class="form-control" id="accountStatus" name="accountStatus">
				<option></option>
				<option <#if oamAccount?? && oamAccount.accountStatus?? && "1"==oamAccount.accountStatus || !oamAccount?? && "1"=="1">selected</#if> value="1">是</option>
				<option <#if oamAccount?? && oamAccount.accountStatus?? && "0"==oamAccount.accountStatus || !oamAccount?? && "0"=="1">selected</#if> value="0">否</option>
			</select>
		</div>
		<label id="accountStatusTip" class="control-label" style="color:red"></label>
	</div>
	<input type="hidden" id="oamAccountId" name="oamAccountId" value="<#if oamAccount??>${oamAccount.oamAccountId!}</#if>" />
</form>
<#if !RequestParameters["isQuery"]?? || RequestParameters["isQuery"]=="">
<div class="card-page-command">
	<a  class="btn btn-success" onclick="saveOamAccount();">
		<i class="glyphicon glyphicon-save"></i>
		<span>保存</span>
	</a>
</div>
</#if>

</body>
</html>