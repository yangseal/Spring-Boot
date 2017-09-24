<!doctype html>
<html>
<head>
<#include "/head.ftl"/>
<script type="text/javascript" src="${rc.contextPath}/public/js/oamProvider/oamProvider.js"></script>
</head>
<body>

<form id="oamProviderForm" class="form-horizontal">
	<div class="form-group pt15">
		<label id="oamProviderNameLabel" for="oamProviderName" class="col-sm-1 control-label">供应商名称</label>
		<div class="col-sm-5">
			<input type="text" class="form-control" id="oamProviderName" name="oamProviderName" isNotNull value="<#if oamProvider??>${oamProvider.oamProviderName!}<#else></#if>" />
		</div>
		<label id="oamProviderNameTip" class="control-label" style="color:red">*</label>
	</div>
	<div class="form-group">
		<label id="productsLabel" for="products" class="col-sm-1 control-label">主营业务</label>
		<div class="col-sm-5">
			<input type="text" class="form-control" id="products" name="products" value="<#if oamProvider??>${oamProvider.products!}<#else></#if>" />
		</div>
		<label id="productsTip" class="control-label" style="color:red"></label>
	</div>
	<div class="form-group">
		<label id="contactLabel" for="contact" class="col-sm-1 control-label">联系方式</label>
		<div class="col-sm-5">
			<input type="text" class="form-control" id="contact" name="contact" value="<#if oamProvider??>${oamProvider.contact!}<#else></#if>" />
		</div>
		<label id="contactTip" class="control-label" style="color:red"></label>
	</div>
	<input type="hidden" id="oamProviderId" name="oamProviderId" value="<#if oamProvider??>${oamProvider.oamProviderId!}</#if>" />
</form>
<#if !RequestParameters["isQuery"]?? || RequestParameters["isQuery"]=="">
<div class="card-page-command">
   <label class="col-sm-1 control-label"></label>
      <div class="col-sm-5" style="text-align:center;">
	<a  class="btn btn-success" onclick="saveOamProvider();">
		<i class="glyphicon glyphicon-save"></i>
		<span>保存</span>
	</a>
	</div>
</div>
</#if>

</body>
</html>