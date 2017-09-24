<!doctype html>
<html>
<head>
<#include "/head.ftl"/>
<script type="text/javascript" src="${rc.contextPath}/public/js/baseStation/customer/showCustomers.js"></script>
<script type="text/javascript" src="${rc.contextPath}/public/js/baseStation/baseStation.js"></script>
</head>
<body>
<form id="customerForm" class="form-horizontal">
	<div class="form-group pt15">
		<label id="custUserNameLabel" for="custUserName" class="col-sm-2 control-label">姓名</label>
		<div class="col-sm-8">
			<input type="text" class="form-control" id="custUserName" name="custUserName" value="<#if customer??>${customer.custUserName!}</#if>" isNotNull />
		</div>
		<label id="custUserNameTip" class="control-label" style="color:red">*</label>
	</div>
	<div class="form-group">
		<label id="custUserPostLabel" for="custUserPost" class="col-sm-2 control-label">职务</label>
		<div class="col-sm-8">
			<input type="text" class="form-control" id="custUserPost" name="custUserPost" value="<#if customer??>${customer.custUserPost!}</#if>" />
		</div>
		<label id="custUserPostTip" class="control-label" style="color:red"></label>
	</div>
	<div class="form-group">
		<label id="custUserDepLabel" for="custUserPost" class="col-sm-2 control-label">部门</label>
		<div class="col-sm-8">
			<input type="text" class="form-control" id="custUserDep" name="custUserDep" value="<#if customer??>${customer.custUserDep!}</#if>"  />
		</div>
		<label id="custUserDepTip" class="control-label" style="color:red"></label>
	</div>
	<div class="form-group">
		<label id="custUserPhoneLabel" for="custUserPhoneType" class="col-sm-2 control-label">联系电话</label>
		<div class="col-sm-8">
			<input type="text" class="form-control" id="custUserPhone" name="custUserPhone" value="<#if customer??>${customer.custUserPhone!}</#if>"  isNotNull /> <#--validateExp="(^(1\d{10})$|^((\d{7,8})|(\d{4}|\d{3})-(\d{7,8})|(\d{4}|\d{3})-(\d{7,8})-(\d{4}|\d{3}|\d{2}|\d{1})|(\d{7,8})-(\d{4}|\d{3}|\d{2}|\d{1}))$)"-->
		</div>
		<label id="custUserPhoneTip" class="control-label" style="color:red">*</label>
	</div>
	<div class="form-group">
		<label id="custUserTelLabel" for="custUserTel" class="col-sm-2 control-label">手机</label>
		<div class="col-sm-8">
			<input type="text" class="form-control" id="custUserTel" name="custUserTel" value="<#if customer??>${customer.custUserTel!}</#if>" /> <#--validateExp="(^(1\d{10})$|^((\d{7,8})|(\d{4}|\d{3})-(\d{7,8})|(\d{4}|\d{3})-(\d{7,8})-(\d{4}|\d{3}|\d{2}|\d{1})|(\d{7,8})-(\d{4}|\d{3}|\d{2}|\d{1}))$)" -->
		</div>
		<label id="custUserTelTip" class="control-label" style="color:red"></label>
	</div>
	<div class="form-group">
		<label id="custUserEmailLabel" for="custUserEmail" class="col-sm-2 control-label">邮箱</label>
		<div class="col-sm-8">
			<input type="text" class="form-control" id="custUserEmail" name="custUserEmail" value="<#if customer??>${customer.custUserEmail!}</#if>"  /> <#--validateExp="^([a-zA-Z0-9_-])+@([a-zA-Z0-9_-])+((\.[a-zA-Z0-9_-]{2,3}){1,2})$"-->
		</div>
		<label id="custUserEmailTip" class="control-label" style="color:red"></label>
	</div>
	<div class="form-group">
		<label id="custUserFaxLabel" for="custCustomerPartyb" class="col-sm-2 control-label">传真</label>
		<div class="col-sm-8">
			<input type="text" class="form-control" id="custUserFax" name="custUserFax"  value="<#if customer??>${customer.custUserFax!}</#if>" /> <#--validateExp="(^(\d{3,4}-)?\d{7,8})$|^((1[0-9][0-9]\d{8}$))"-->
		</div>
		<label id="custUserFaxTip" class="control-label" style="color:red"></label>
	</div>
	<div class="form-group">
		<label id="custUserRemarkLabel" for="custUserRemark" class="col-sm-2 control-label">备注</label>
		<div class="col-sm-8">
			<input type="text" class="form-control" id="custUserRemark" name="custUserRemark" value="<#if customer??>${customer.custUserRemark!}</#if>" />
		</div>
		<label id="custUserRemarkTip" class="control-label" style="color:red"></label>
	</div>
	<input type="hidden" name="baseCustomerUserId" id="baseCustomerUserId" value="<#if customer??>${customer.baseCustomerUserId!}</#if>">
	<input type="hidden" id="baseCustomerId" name="baseCustomer.baseCustomerId" value="<#if baseCustomerId??>${baseCustomerId!}</#if>" />
	<input type="hidden" id="createUser" name="createUser" value="<#if customer??>${customer.createUser!}</#if>">
	<input type="hidden" id="createTime" name="createTime" value="<#if customer??>${customer.createTime!}</#if>">
	
	
</form>
<#if !RequestParameters["isQuery"]?? || RequestParameters["isQuery"]=="">
<div class="form-group">
      <label class="col-sm-2 control-label"></label>
      <div class="col-sm-8" style="text-align:center;">
	<a  class="btn btn-success" onclick="saveCustomer();">
		<i class="glyphicon glyphicon-save"></i>
		<span>保存</span>
	</a>
	</div>
</div>
</#if>
</body>
</html>