<!doctype html>
<html>
<head>
<#include "/head.ftl"/>
<script type="text/javascript" src="${rc.contextPath}/public/js/system/user.js"></script>
</head>
<body>

<form id="userForm" class="form-horizontal bh_dom_box">
	<div class="form-group">
		<label id="userNameLabel" for="userName" class="col-sm-3 control-label">姓名</label>
		<div class="col-sm-6">
      		<input type="text" class="form-control" id="userName" name="userName" value="<#if user??>${user.userName!}</#if>" isNotNull />
      	</div>
      	<label id="userNameTip" class="control-label" style="color:red">*</label>
	</div>
	<div class="form-group">
		<label id="userCodeLabel" for="userCode" class="col-sm-3 control-label">用户名</label>
		<div class="col-sm-6">
      		<input type="text" class="form-control" id="userCode" name="userCode" value="<#if user??>${user.userCode!}</#if>" isNotNull />
      	</div>
      	<label id="userCodeTip" class="control-label" style="color:red">*</label>
	</div>
    <#if !user??>
	<div class="form-group">
		<label id="passwordLabel" for="userName" class="col-sm-3 control-label">用户密码</label>
		<div class="col-sm-6">
      		<input type="text" class="form-control" id="password" name="password" value="123456" isNotNull readonly="true"/>
      	</div>
      	<label id="passwordTip" class="control-label" style="color:red">*</label>
	</div>
    </#if>
	<div class="form-group">
		<label id="phoneLabel" for="phone" class="col-sm-3 control-label" >手机</label>
		<div class="col-sm-6">
      		<input type="text" class="form-control" id="phone" name="phone" value="<#if user??>${user.phone!}</#if>" validateExp="\d" validateTip="手机格式有误" />
      	</div>
      	<label id="phoneTip" class="control-label" style="color:red"></label>
	</div>
	<#if common.isSystemUser || common.isCntenAdministrator>
		<div class="form-group">
		<label id="isCompanyAdminLabel" for="isCompanyAdmin" class="col-sm-3 control-label">是否企业管理员</label>
		<div class="col-sm-6">
			<select class="form-control" id="isCompanyAdmin" name="isCompanyAdmin" >
				<option></option>
				<option <#if user?? && "Y"==user.isCompanyAdmin! || !user?? && "N"=="Y">selected</#if> value="Y">是</option>
				<option <#if user?? && "N"==user.isCompanyAdmin! || !user?? && "Y"=="Y" || "Y"!=user.isCompanyAdmin!>selected</#if> value="N">否</option>
			</select>
		</div>
		<label id="typeStateTip" class="control-label" style="color:red">*</label>
	</div>
	</#if>
	<#if common.isSystemUser || common.isCntenAdministrator>
	<div class="form-group has-feedback">
		<label id="companyLabel" for="company" class="col-sm-3 control-label">所属企业</label>
		<div class="col-sm-6">
      		<input type="text" class="form-control" style="cursor:pointer" id="company" name="company" value="北京讯腾智慧科技" isNotNull />
      		<span class="glyphicon glyphicon-menu-hamburger form-control-feedback"></span>
      	</div>
      	<label id="companyTip" class="control-label" style="color:red">*</label>
	</div>
	</#if>
	<input type="hidden" id="companyId" name="companyId" value="4028811c58b9ea9b0158b9eb7d510000" />
	<input type="hidden" id="userId" name="userId" value="<#if user??>${user.userId!}</#if>" />
</form>
<#if !RequestParameters["isQuery"]?? || RequestParameters["isQuery"]=="">
<div style="text-align:center">
	<a  class="btn btn-success" onclick="saveUser();">
		<i class="glyphicon glyphicon-save"></i>
    	<span>保存</span>
	</a>
</div>
</#if>
</body>
</html>
