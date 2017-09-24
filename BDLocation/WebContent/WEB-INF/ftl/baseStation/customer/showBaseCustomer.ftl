<!doctype html>
<html>
<head>
<#include "/head.ftl"/>
<link rel="stylesheet" href="${rc.contextPath}/public/css/location.css"/>
<script type="text/javascript" src="${rc.contextPath}/public/js/location/location.js"></script>
<script type="text/javascript" src="${rc.contextPath}/public/js/baseStation/customer/showBaseCustomers.js"></script>
</head>
<body>
<form id="baseCustomerForm" class="form-horizontal">
	<input type="hidden" id="createUser" name = "createUser" value="<#if baseCustomer?? && baseCustomer.createUser??>${baseCustomer.createUser!}</#if>"/>
	<input type="hidden" id="createTime" name = "createTime" value="<#if baseCustomer?? && baseCustomer.createTime??>${baseCustomer.createTime!}</#if>"/>
	
	<div class="form-group pt15">
		<label id="customerNameLabel" for="customerName" class="col-sm-2 control-label">客户名称</label>
		<div class="col-sm-8">
			<input type="text" class="form-control" id="customerName" name="customerName" value="<#if baseCustomer??>${baseCustomer.customerName!}</#if>" isNotNull />
		</div>
		<label id="customerNameTip" class="control-label" style="color:red">*</label>
	</div>
	<div class="form-group">
			<div class="sel_city">
			<label id="oamAreaIdLabel" for="oamAreaId" class="col-sm-2 control-label">所在区域</label>
			<div class="col-sm-8 city_select">
		        <div id="store-selector">
		            <div class="text" style="width:200px;"><div></div><b></b></div>                   
		            <div class="close"></div>
		        <div id="store-prompt"><strong></strong></div><!--store-prompt end--->
				<input type="hidden" id="addressName" value="<#if baseCustomer?? && baseCustomer.oamArea??>${baseCustomer.oamArea.oamAreaName!}</#if>"/>
		  		<input type="hidden" location="oamAreaId" name="oamArea.oamAreaId" class="city" value="<#if baseCustomer?? && baseCustomer.oamArea??>${baseCustomer.oamArea.oamAreaId!}</#if>" /><!-- get city id-->
		    </div>
	   		</div>
		</div>
		<label id="oamAreaTip" class="control-label" style="color:red">*</label>
	</div>
	<div class="form-group">
		<label id="customerAddressLabel" for="customerAddress" class="col-sm-2 control-label">客户地址</label>
		<div class="col-sm-8">
			<input type="text" class="form-control" id="customerAddress" name="customerAddress" value="<#if baseCustomer??>${baseCustomer.customerAddress!}</#if>" isNotNull />
		</div>
		<label id="customerAddressTip" class="control-label" style="color:red">*</label>
	</div>
	<div class="form-group">
		<label id="customerRemarkLabel" for="customerRemark" class="col-sm-2 control-label">备注</label>
		<div class="col-sm-8">
			<input type="text" class="form-control" id="customerRemark" name="customerRemark" value="<#if baseCustomer??>${baseCustomer.customerRemark!}</#if>"/>
		</div>
		<label id="customerRemarkTip" class="control-label" style="color:red"></label>
	</div>
	<input type="hidden" name="baseCustomerId" id="baseCustomerId" value="<#if baseCustomer??>${baseCustomer.baseCustomerId!}</#if>">
</form>

<#if !RequestParameters["isQuery"]?? || RequestParameters["isQuery"]=="">
<div class="form-group">
      <label class="col-sm-2 control-label"></label>
      <div class="col-sm-8" style="text-align:center;">
	<a  class="btn btn-success" onclick="saveBaseCustomer();">
		<i class="glyphicon glyphicon-save"></i>
		<span>保存</span>
	</a>
	</div>
</div>
</#if>
</body>
</html>