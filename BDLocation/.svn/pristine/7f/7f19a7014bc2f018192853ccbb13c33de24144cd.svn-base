<!doctype html>
<html>
<head>
<#include "/head.ftl"/>
<script type="text/javascript" src="${rc.contextPath}/public/js/companyTemp/companyTemp.js"></script>
</head>
<body>

<form id="companyTempForm" class="form-horizontal">
	<#if !RequestParameters["isQuery"]?? || RequestParameters["isQuery"]=="">
	<#if RequestParameters["companyTempId"]??>
	<div class="form-group">
		<label id="companyCodeLabel" for="companyCode" class="col-sm-2 control-label">企业编号</label>
		<div class="col-sm-7">
			<input type="text" class="form-control" id="companyCode" name="companyCode" value="" isNotNull />
		</div>
		<label id="companyCodeTip" class="control-label" style="color:red">*</label>
	</div>
	</#if>
	</#if>
	<div class="form-group">
		<label id="companyTempNameLabel" for="companyTempName" class="col-sm-2 control-label">企业名称</label>
		<div class="col-sm-7">
			<input type="text" class="form-control" id="companyTempName" name="companyTempName" value="<#if companyTemp??>${companyTemp.companyTempName!}<#else></#if>" isNotNull />
		</div>
		<label id="companyTempNameTip" class="control-label" style="color:red">*</label>
	</div>
	<div class="form-group">
		<label id="addressLabel" for="address" class="col-sm-2 control-label">企业地址</label>
		<div class="col-sm-7">
			<input type="text" class="form-control" id="address" name="address" value="<#if companyTemp??>${companyTemp.province.oamAreaName!} ${companyTemp.city.oamAreaName!} ${companyTemp.address!}<#else></#if>" isNotNull />
		</div>
		<label id="addressTip" class="control-label" style="color:red">*</label>
	</div>
	<div class="form-group">
		<label id="telLabel" for="tel" class="col-sm-2 control-label">企业电话</label>
		<div class="col-sm-7">
			<input type="text" class="form-control" id="tel" name="tel" value="<#if companyTemp??>${companyTemp.tel!}<#else></#if>" isNotNull validateExp="(^(1\d{10})$|^((\d{7,8})|(\d{4}|\d{3})-(\d{7,8})|(\d{4}|\d{3})-(\d{7,8})-(\d{4}|\d{3}|\d{2}|\d{1})|(\d{7,8})-(\d{4}|\d{3}|\d{2}|\d{1}))$)" validateTip="电话格式有误"/>
		</div>
		<label id="telTip" class="control-label" style="color:red">*</label>
	</div>
	<div class="form-group">
		<label id="contactsLabel" for="contacts" class="col-sm-2 control-label">联系人名称</label>
		<div class="col-sm-7">
			<input type="text" class="form-control" id="contacts" name="contacts" value="<#if companyTemp??>${companyTemp.contacts!}<#else></#if>" isNotNull />
		</div>
		<label id="contactsTip" class="control-label" style="color:red">*</label>
	</div>
	<div class="form-group">
		<label id="postLabel" for="post" class="col-sm-2 control-label">联系人职务</label>
		<div class="col-sm-7">
			<input type="text" class="form-control" id="post" name="post" value="<#if companyTemp??>${companyTemp.post!}<#else></#if>" isNotNull />
		</div>
		<label id="postTip" class="control-label" style="color:red">*</label>
	</div>
	<div class="form-group">
		<label id="phoneLabel" for="phone" class="col-sm-2 control-label">联系人电话</label>
		<div class="col-sm-7">
			<input type="text" class="form-control" id="phone" name="phone" value="<#if companyTemp??>${companyTemp.phone!}<#else></#if>" isNotNull validateExp="(^(1\d{10})$|^((\d{7,8})|(\d{4}|\d{3})-(\d{7,8})|(\d{4}|\d{3})-(\d{7,8})-(\d{4}|\d{3}|\d{2}|\d{1})|(\d{7,8})-(\d{4}|\d{3}|\d{2}|\d{1}))$)" validateTip="手机格式有误" />
		</div>
		<label id="phoneTip" class="control-label" style="color:red">*</label>
	</div>
	<div class="form-group">
		<label id="emailLabel" for="email" class="col-sm-2 control-label">联系人邮箱</label>
		<div class="col-sm-7">
			<input type="text" class="form-control" id="email" name="email" value="<#if companyTemp??>${companyTemp.email!}<#else></#if>" isNotNull validateExp="^[a-z0-9]+([._\\-]*[a-z0-9])*@([a-z0-9]+[-a-z0-9]*[a-z0-9]+.){1,63}[a-z0-9]+$" validateTip="邮箱格式有误" />
		</div>
		<label id="emailTip" class="control-label" style="color:red">*</label>
	</div>
	<#if !RequestParameters["isQuery"]?? || RequestParameters["isQuery"]=="">
	<#if RequestParameters["companyTempId"]??>
	<div class="form-group">
		<label id="userCodeLabel" for="userCode" class="col-sm-2 control-label">企业管理员账号</label>
		<div class="col-sm-7">
			<input type="text" class="form-control" id="userCode" name="userCode" value="admin" readonly="true" />
		</div>
		<label id="userCodeTip" class="control-label" style="color:red">*</label>
	</div>
	<div class="form-group">
		<label id="passwordLabel" for="password" class="col-sm-2 control-label">企业管理员密码</label>
		<div class="col-sm-7">
			<input type="text" class="form-control" id="password" name="password" value="123456" />
		</div>
		<label id="passwordTip" class="control-label" style="color:red">*</label>
	</div>
	<input type="hidden" id="isCompanyAdmin" name="isCompanyAdmin" value="Y" />
	</#if>
	</#if>
	<input type="hidden" id="companyTempId" name="companyTempId" value="<#if companyTemp??>${companyTemp.companyTempId!}</#if>" />
	
</form>

<#if !RequestParameters["isQuery"]?? || RequestParameters["isQuery"]=="">
	<div style="text-align:center">
		<#if !RequestParameters["companyTempId"]??>
			<a  class="btn btn-success" onclick="saveCompanyTempByPage();">
				<i class="glyphicon glyphicon-save"></i>
				<span>注册</span>
			</a>
		</#if>
		<#if RequestParameters["companyTempId"]??>
			<a  class="btn btn-primary" onclick="approveCompanyTemps();">
				<i class="glyphicon glyphicon-ok"></i>
				<span>通过</span>
			</a>
			<a  class="btn btn-danger" onclick="rejectCompanyTemp();">
				<i class="glyphicon glyphicon-remove"></i>
				<span>拒绝</span>
			</a>
		</#if>
	</div>
</#if>

</body>
</html>