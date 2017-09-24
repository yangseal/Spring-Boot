<!doctype html>
<html>
<head>
<#include "/head.ftl"/>
<script type="text/javascript" src="${rc.contextPath}/public/js/oamCustomer/oamCustomer.js"></script>
</head>
<body>
<#if RequestParameters["oamCustomerId"]??>
<ul class="nav nav-tabs" role="tablist">
    <li role="presentation" class="active"><a href="#basicTab" aria-controls="basicTab" role="tab" data-toggle="tab">基础信息</a></li>
    <li role="presentation"><a href="#oamContactssTab" aria-controls="oamContactssTab" role="tab" data-toggle="tab">联系人列表</a></li>
    <li role="presentation"><a href="#oamAccountsTab" aria-controls="oamAccountsTab" role="tab" data-toggle="tab">账号列表</a></li>
</ul>
<div class="tab-content">
    <div role="tabpanel" class="tab-pane active" id="basicTab">
</#if>

<form id="oamCustomerForm" class="form-horizontal">
	<div class="form-group pt15">
		<label id="oamCustomerNameLabel" for="oamCustomerName" class="col-sm-1 control-label">客户名称</label>
		<div class="col-sm-5">
			<input type="text" class="form-control" id="oamCustomerName" name="oamCustomerName" isNotNull value="<#if oamCustomer??>${oamCustomer.oamCustomerName!}<#else></#if>" />
		</div>
		<label id="oamCustomerNameTip" class="control-label" style="color:red">*</label>
	</div>
	<#if !RequestParameters["oamAreaId"]?? || RequestParameters["oamAreaId"]=="">
	<div class="form-group has-feedback">
		<label id="oamAreaLabel" for="oamArea" class="col-sm-1 control-label">所属省市</label>
		<div class="col-sm-5">
			<input type="text" class="form-control" style="cursor:pointer" id="oamArea" name="oamArea" value="<#if oamCustomer?? && oamCustomer.oamArea??>${oamCustomer.oamArea.oamAreaName!}</#if>" onclick="selectOamArea();" />
			<span class="glyphicon glyphicon-menu-hamburger form-control-feedback"></span>
		</div>
		<label id="oamAreaTip" class="control-label" style="color:red"></label>
	</div>
	</#if>
	<input type="hidden" id="oamAreaId" name="oamArea.oamAreaId" value="<#if oamCustomer?? && oamCustomer.oamArea??>${oamCustomer.oamArea.oamAreaId!}<#else>${RequestParameters["oamAreaId"]!}</#if>" />
	<div class="form-group">
		<label id="postcodeLabel" for="postcode" class="col-sm-1 control-label">邮编</label>
		<div class="col-sm-5">
			<input type="text" class="form-control" id="postcode" name="postcode" value="<#if oamCustomer??>${oamCustomer.postcode!}<#else></#if>" />
		</div>
		<label id="postcodeTip" class="control-label" style="color:red"></label>
	</div>
	<div class="form-group">
		<label id="addressLabel" for="address" class="col-sm-1 control-label">地址</label>
		<div class="col-sm-5">
			<input type="text" class="form-control" id="address" name="address" value="<#if oamCustomer??>${oamCustomer.address!}<#else></#if>" />
		</div>
		<label id="addressTip" class="control-label" style="color:red"></label>
	</div>
	<div class="form-group">
		<label id="productsLabel" for="products" class="col-sm-1 control-label">主营业务</label>
		<div class="col-sm-5">
			<input type="text" class="form-control" id="products" name="products" value="<#if oamCustomer??>${oamCustomer.products!}<#else></#if>" />
		</div>
		<label id="productsTip" class="control-label" style="color:red"></label>
	</div>
	<div class="form-group">
		<label id="longitudeLabel" for="longitude" class="col-sm-1 control-label">经度</label>
		<div class="col-sm-5">
			<input type="text" class="form-control" id="longitude" name="longitude" isNotNull validateExp="^(\d{1,}\.?\d*)$" validateTip="经度应为数值" value="<#if oamCustomer?? && oamCustomer.longitude??>${oamCustomer.longitude?c}<#else></#if>" />
		</div>
		<label id="longitudeTip" class="control-label" style="color:red">*</label>
	</div>
	<div class="form-group">
		<label id="latitudeLabel" for="latitude" class="col-sm-1 control-label">纬度</label>
		<div class="col-sm-5">
			<input type="text" class="form-control" id="latitude" name="latitude" isNotNull validateExp="^(\d{1,}\.?\d*)$" validateTip="纬度应为数值" value="<#if oamCustomer?? && oamCustomer.latitude??>${oamCustomer.latitude?c}<#else></#if>" />
		</div>
		<label id="latitudeTip" class="control-label" style="color:red">*</label>
	</div>
	<input type="hidden" id="oamCustomerId" name="oamCustomerId" value="<#if oamCustomer??>${oamCustomer.oamCustomerId!}</#if>" />
</form>
<#if !RequestParameters["isQuery"]?? || RequestParameters["isQuery"]=="">
<div class="card-page-command">
   <label class="col-sm-1 control-label"></label>
      <div class="col-sm-5" style="text-align:center;">
	<a  class="btn btn-success" onclick="saveOamCustomer();">
		<i class="glyphicon glyphicon-save"></i>
		<span>保存</span>
	</a>
	</div>
</div>
</#if>

<#if RequestParameters["oamCustomerId"]??>
	</div>
	<div role="tabpanel" class="tab-pane" id="oamContactssTab">
	   	<iframe code="oamContactss" frameborder=0 width="100%" src="${rc.contextPath}/oamContacts/showOamContactss?${rc.queryString!}" />
	</div>
	
</div>
</#if>
</body>
</html>