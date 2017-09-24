<!doctype html>
<html>
<head>
<#include "/head.ftl"/>
<script type="text/javascript" src="${rc.contextPath}/public/js/company/company.js"></script>
</head>
<body>
<form id="companyForm" class="form-horizontal">
	<input type="hidden" id="busiCompanyId" name="busiCompanyId" value="<#if company??>${CURRENT_USER.company.companyId}</#if>" />
	<input type="hidden" id="userId" name="userId" value="${CURRENT_USER.userId}" />
	
	<div class="form-group">
		<label id="companyNameLabel" for="companyName" class="col-sm-2 control-label">企业名称</label>
		<div class="col-sm-7">
			<input type="text" class="form-control" id="companyName" name="companyName" value="<#if company??>${company.companyName!}</#if>" isNotNull <#if common.isYeWuUser>readonly="true"</#if> />
		</div>
		<label id="companyNameTip" class="control-label" style="color:red">*</label>
	</div>
	<div class="form-group">
		<label id="companyCodeLabel" for="companyCode" class="col-sm-2 control-label">企业编号</label>
		<div class="col-sm-7">
			<input type="text" class="form-control" id="companyCode" name="companyCode" value="<#if company??>${company.companyCode!}</#if>" isNotNull <#if common.isYeWuUser>readonly="true"</#if> />
		</div>
		<label id="companyCodeTip" class="control-label" style="color:red">*</label>
	</div>
	<div class="form-group">
		<label id="passwordLabel" for="password" class="col-sm-2 control-label">企业密码</label>
		<div class="col-sm-7">
			<input type="password" class="form-control" id="password" name="password" value="<#if company??>${company.password!}</#if>" isNotNull />
		</div>
		<label id="passwordTip" class="control-label" style="color:red">*</label>
	</div>
	<div class="form-group">
		<label id="addressLabel" for="address" class="col-sm-2 control-label">企业地址</label>
		<div class="col-sm-7">
			<input type="text" class="form-control" id="address" name="address" value="<#if company??>${company.address!}</#if>" />
		</div>
		<label id="addressTip" class="control-label" style="color:red"></label>
	</div>
	<div class="form-group">
		<label id="telLabel" for="tel" class="col-sm-2 control-label">企业电话</label>
		<div class="col-sm-7">
			<input type="text" class="form-control" id="tel" name="tel" value="<#if company??>${company.tel!}</#if>" />
		</div>
		<label id="telTip" class="control-label" style="color:red"></label>
	</div>
	<div class="form-group">
		<label id="contactsLabel" for="contacts" class="col-sm-2 control-label">联系人名称</label>
		<div class="col-sm-7">
			<input type="text" class="form-control" id="contacts" name="contacts" value="<#if company??>${company.contacts!}</#if>" />
		</div>
		<label id="contactsTip" class="control-label" style="color:red"></label>
	</div>
	<div class="form-group">
		<label id="postLabel" for="post" class="col-sm-2 control-label">联系人职务</label>
		<div class="col-sm-7">
			<input type="text" class="form-control" id="post" name="post" value="<#if company??>${company.post!}</#if>" />
		</div>
		<label id="postTip" class="control-label" style="color:red"></label>
	</div>
	<div class="form-group">
		<label id="phoneLabel" for="phone" class="col-sm-2 control-label">联系人电话</label>
		<div class="col-sm-7">
			<input type="text" class="form-control" id="phone" name="phone" value="<#if company??>${company.phone!}</#if>" />
		</div>
		<label id="phoneTip" class="control-label" style="color:red"></label>
	</div>
	

	
	<div class="form-group">
		<label id="corporateLabel" for="corporate" class="col-sm-2 control-label">法定代表人</label>
		<div class="col-sm-7">
			<input type="text" class="form-control" id="corporate" name="corporate" value="<#if company??>${company.corporate!}</#if>" />
		</div>
		<label id="corporateTip" class="control-label" style="color:red"></label>
	</div>
	<div class="form-group">
		<label id="businessLicenseLabel" for="businessLicense" class="col-sm-2 control-label">营业执照注册号</label>
		<div class="col-sm-7">
			<input type="text" class="form-control" id="businessLicense" name="businessLicense" value="<#if company??>${company.businessLicense!}</#if>" />
		</div>
		<label id="businessLicenseTip" class="control-label" style="color:red"></label>
	</div>
	
	<div class="form-group">
		<label id="attachmentsLabel" for="attachments" class="col-sm-2 control-label">附件列表</label>
		<div class="col-sm-7">
      		<div id="attachments" name="attachments" style="border:1px solid">
      		</div>
      	</div>
      	<label id="attachmentsTip" class="control-label" style="color:red"></label>
	</div>
	<input type="hidden" id="busiApproveId" name="busiApproveId" value="<#if corsBusiApprove??>${corsBusiApprove.busiApproveId!}</#if>" />
	<input type="hidden" id="companyId" name="companyId" value="<#if company??>${company.companyId!}</#if>" />
	<input type="hidden" id="companyMaterialState" name="companyMaterialState" value="<#if company??>${company.companyMaterialState!}</#if>" />
</form>
<#if !RequestParameters["isQuery"]?? || RequestParameters["isQuery"]=="">
<div style="text-align:center">
	<a  class="btn btn-success" onclick="saveCompany();">
		<i class="glyphicon glyphicon-save"></i>
		<span>保存</span>
	</a>
	<a  class="btn btn-success" onclick="ComData();">
		<i class="glyphicon glyphicon-save"></i>
		<span>资料提交</span>
	</a>
</div>
</#if>
</body>
</html>