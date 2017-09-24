<!doctype html>
<html>
<head>
<#include "/head.ftl"/>
<script type="text/javascript" src="${rc.contextPath}/public/js/oamContacts/oamContacts.js"></script>
</head>
<body>

<form id="oamContactsForm" class="form-horizontal">
	<div class="form-group pt15">
		<label id="oamContactsNameLabel" for="oamContactsName" class="col-sm-1 control-label">联系人名称</label>
		<div class="col-sm-5">
			<input type="text" class="form-control" id="oamContactsName" name="oamContactsName" isNotNull value="<#if oamContacts??>${oamContacts.oamContactsName!}<#else></#if>" />
		</div>
		<label id="oamContactsNameTip" class="control-label" style="color:red">*</label>
	</div>
	<#if !RequestParameters["oamCustomerId"]?? || RequestParameters["oamCustomerId"]=="">
	<div class="form-group has-feedback">
		<label id="oamCustomerLabel" for="oamCustomer" class="col-sm-1 control-label">所属客户</label>
		<div class="col-sm-5">
			<input type="text" class="form-control" style="cursor:pointer" id="oamCustomer" name="oamCustomer" value="<#if oamContacts?? && oamContacts.oamCustomer??>${oamContacts.oamCustomer.oamCustomerName!}</#if>" onclick="selectOamCustomer();" />
			<span class="glyphicon glyphicon-menu-hamburger form-control-feedback"></span>
		</div>
		<label id="oamCustomerTip" class="control-label" style="color:red"></label>
	</div>
	</#if>
	<input type="hidden" id="oamCustomerId" name="oamCustomer.oamCustomerId" value="<#if oamContacts?? && oamContacts.oamCustomer??>${oamContacts.oamCustomer.oamCustomerId!}<#else>${RequestParameters["oamCustomerId"]!}</#if>" />
	<div class="form-group">
		<label id="positionLabel" for="position" class="col-sm-1 control-label">职务</label>
		<div class="col-sm-5">
			<input type="text" class="form-control" id="position" name="position" value="<#if oamContacts??>${oamContacts.position!}<#else></#if>" />
		</div>
		<label id="positionTip" class="control-label" style="color:red"></label>
	</div>
	<div class="form-group">
		<label id="telLabel" for="tel" class="col-sm-1 control-label">电话</label>
		<div class="col-sm-5">
			<input type="text" class="form-control" id="tel" name="tel" value="<#if oamContacts??>${oamContacts.tel!}<#else></#if>" />
		</div>
		<label id="telTip" class="control-label" style="color:red"></label>
	</div>
	<div class="form-group">
		<label id="phoneLabel" for="phone" class="col-sm-1 control-label">手机</label>
		<div class="col-sm-5">
			<input type="text" class="form-control" id="phone" name="phone" value="<#if oamContacts??>${oamContacts.phone!}<#else></#if>" />
		</div>
		<label id="phoneTip" class="control-label" style="color:red"></label>
	</div>
	<div class="form-group">
		<label id="mailLabel" for="mail" class="col-sm-1 control-label">邮箱</label>
		<div class="col-sm-5">
			<input type="text" class="form-control" id="mail" name="mail" value="<#if oamContacts??>${oamContacts.mail!}<#else></#if>" />
		</div>
		<label id="mailTip" class="control-label" style="color:red"></label>
	</div>
	<div class="form-group">
		<label id="otherLabel" for="other" class="col-sm-1 control-label">其它</label>
		<div class="col-sm-5">
			<input type="text" class="form-control" id="other" name="other" value="<#if oamContacts??>${oamContacts.other!}<#else></#if>" />
		</div>
		<label id="otherTip" class="control-label" style="color:red"></label>
	</div>
	<input type="hidden" id="oamContactsId" name="oamContactsId" value="<#if oamContacts??>${oamContacts.oamContactsId!}</#if>" />
</form>
<#if !RequestParameters["isQuery"]?? || RequestParameters["isQuery"]=="">
<div class="card-page-command">
  <label class="col-sm-1 control-label"></label>
      <div class="col-sm-5" style="text-align:center;">
	<a  class="btn btn-success" onclick="saveOamContacts();">
		<i class="glyphicon glyphicon-save"></i>
		<span>保存</span>
	</a>
	</div>
</div>
</#if>

</body>
</html>