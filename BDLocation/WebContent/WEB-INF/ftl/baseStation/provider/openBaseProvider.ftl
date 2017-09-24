<!doctype html>
<html>
<head>
<#include "/head.ftl"/>
<link rel="stylesheet" href="${rc.contextPath}/public/css/location.css"/>
<script type="text/javascript" src="${rc.contextPath}/public/js/baseStation/provider/baseProvider.js"></script>
<script type="text/javascript" src="${rc.contextPath}/public/js/location/location.js"></script>
</head>
<body>
<form id="openBaseProviderForm" class="form-horizontal">
	<input type="hidden" id="baseProviderId" name="baseProviderId" value="<#if baseProvider??>${baseProvider.baseProviderId}</#if>">
	<div class="form-group pt15">
		<label id="providerNameLabel" for="providerName" class="col-sm-2 control-label">供应商名称</label>
		<div class="col-sm-8">
			<input type="text" class="form-control" id="providerName" name="providerName" isNotNull value="<#if baseProvider??>${baseProvider.providerName!}</#if>"/>
		</div>
		<label id="providerNameTip" class="control-label" style="color:red">*</label>
	</div>
	<div class="form-group">
		<div class="sel_city">
		<label id="oamAreaIdLabel" for="oamAreaId" class="col-sm-2 control-label">所在区域</label>
		<div class="col-sm-8 city_select">
	        <div id="store-selector">
	            <div class="text" style="width:200px;"><div></div><b></b></div>                   
	            <div class="close"></div>
	        </div><!--store-selector end-->
	        <div id="store-prompt"><strong></strong></div><!--store-prompt end--->
	        <input type="hidden" location="oamAreaId" name="oamArea.oamAreaId" class="city" value="<#if baseProvider?? && baseProvider.oamArea??>${baseProvider.oamArea.oamAreaId!}</#if>" /><!-- get city id-->
	  		<input type="hidden" id="address" value="<#if baseProvider?? && baseProvider.oamArea??>${baseProvider.oamArea.oamAreaName!}</#if>" />
	    </div>
		<label id="oamAreaTip" class="control-label" style="color:red">*</label>
	</div>
	</div>
	<div class="form-group">
		<label id="providerAddressLabel" for="providerAddress" class="col-sm-2 control-label">详细地址</label>
		<div class="col-sm-8">
			<input type="text" class="form-control" id="providerAddress" name="providerAddress" isNotNull value="<#if baseProvider??>${baseProvider.providerAddress!}</#if>"/>
		</div>
		<label id="providerAddressTip" class="control-label" style="color:red">*</label>
	</div>
	<div class="form-group">
		<label id="provideRemarkLabel" for="provideRemark" class="col-sm-2 control-label">备注</label>
		<div class="col-sm-8">
			<textarea class="form-control" id="provideRemark" name="provideRemark" ><#if baseProvider??>${baseProvider.provideRemark!}</#if></textarea>
		</div>
	</div>
	<div class="form-group">
      <label class="col-sm-2 control-label"></label>
      <div class="col-sm-8" style="text-align:center;">
		<a  class="btn btn-success" onclick="saveBaseProvider();">
			<i class="glyphicon glyphicon-save"></i>
			<span>保存</span>
		</a>
		</div>
	</div>
</form>
</body>
</html>