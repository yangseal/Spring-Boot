<!doctype html>
<html>
<head>
<#include "/head.ftl"/>
<script type="text/javascript" src="${rc.contextPath}/public/js/baseStation/provider/providerUser.js"></script>
<script type="text/javascript" src="${rc.contextPath}/public/js/baseStation/baseStation.js"></script>
</head>
<body>
<form id="proUserForm" class="form-horizontal">
	<input type="hidden" id="baseProviderUserId" name="baseProviderUserId" value="<#if providerUser??>${providerUser.baseProviderUserId}</#if>">
	<input type="hidden" id="baseProviderId" name="baseProvider.baseProviderId" value="<#if baseProvider??>${baseProvider.baseProviderId!}</#if>" />
	<div class="form-group pt15">
		<label id="proUserNameLabel" for="proUserName" class="col-sm-2 control-label">姓名</label>
		<div class="col-sm-8">
			<input type="text" class="form-control" id="proUserName" name="proUserName" value="<#if providerUser??>${providerUser.proUserName!}</#if>" isNotNull />
		</div>
		<label id="proUserNameTip" class="control-label" style="color:red">*</label>
	</div>
	<div class="form-group">
		<label id="proUserPostLabel" for="proUserPost" class="col-sm-2 control-label">职务</label>
		<div class="col-sm-8">
			<input type="text" class="form-control" id="proUserPost" name="proUserPost" value="<#if providerUser??>${providerUser.proUserPost!}</#if>" />
		</div>
	</div>
	<div class="form-group">
		<label id="proUserDeptLabel" for="proUserDept" class="col-sm-2 control-label">部门</label>
		<div class="col-sm-8">
			<input type="text" class="form-control" id="proUserDept" name="proUserDept" value="<#if providerUser??>${providerUser.proUserDept!}</#if>" />
		</div>
	</div>
	<div class="form-group">
		<label id="proUserTelLabel" for="proUserTel" class="col-sm-2 control-label">联系电话</label>
		<div class="col-sm-8">
			<input type="text" class="form-control" id="proUserTel" name="proUserTel" value="<#if providerUser??>${providerUser.proUserTel!}</#if>" isNotNull />
		</div>
		<label id="proUserTelTip" class="control-label" style="color:red">*</label>
	</div>
	<div class="form-group">
		<label id="proUserPhoneLabel" for="proUserPhone" class="col-sm-2 control-label">手机</label>
		<div class="col-sm-8">
			<input type="text" class="form-control" id="proUserPhone" name="proUserPhone" value="<#if providerUser??>${providerUser.proUserPhone!}</#if>" />
		</div>
	</div>
	<div class="form-group">
		<label id="proUserEmailLabel" for="proUserEmail" class="col-sm-2 control-label">邮箱</label>
		<div class="col-sm-8">
			<input type="text" class="form-control" id="proUserEmail" name="proUserEmail" value="<#if providerUser??>${providerUser.proUserEmail!}</#if>" />
		</div>
	</div>
	<div class="form-group">
		<label id="proUserFaxLabel" for="proUserFax" class="col-sm-2 control-label">传真</label>
		<div class="col-sm-8">
			<input type="text" class="form-control" id="proUserFax" name="proUserFax" value="<#if providerUser??>${providerUser.proUserFax!}</#if>" />
		</div>
	</div>
	<div class="form-group">
		<label id="baseProviderLabel" for="baseProvider" class="col-sm-2 control-label">所属供应商</label>
		<div class="col-sm-8">
			<input type="text" class="form-control" id="baseProvider" name="baseProvider.providerName" disabled value="<#if baseProvider??>${baseProvider.providerName!}</#if>" />
		</div>
	</div>
	<div class="form-group">
		<label id="proUserRemarkLabel" for="proUserRemark" class="col-sm-2 control-label">备注</label>
		<div class="col-sm-8">
			<textarea class="form-control" id="proUserRemark" name="proUserRemark"><#if providerUser??>${providerUser.proUserRemark!}</#if></textarea>
		</div>
	</div>
</form>
<div class="form-group">
      <label class="col-sm-2 control-label"></label>
      <div class="col-sm-8" style="text-align:center;">
	<a class="btn btn-success" onclick="saveProUser();">
		<i class="glyphicon glyphicon-save"></i>
		<span>保存</span>
	</a>
	</div>
</div>
</body>
</html>