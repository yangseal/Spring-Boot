<!doctype html>
<html>
<head>
<#include "/head.ftl"/>
<script type="text/javascript" src="${rc.contextPath}/public/js/companyExamine/companyExamines.js"></script>
</head>
<body>

<form id="companyExamineForm" class="form-horizontal">
	<#if !RequestParameters["isQuery"]?? || RequestParameters["isQuery"]=="">
	<#if RequestParameters["busiApproveId"]??>
	<div class="form-group">
		<label id="companyCodeLabel" for="companyCode" class="col-sm-2 control-label" >企业编号</label>
		<div class="col-sm-7">
			<input type="text" class="form-control" id="companyCode" value="<#if companyCode??>${companyCode!}<#else></#if>"  readonly="readonly" />
		</div>
		<label id="companyCodeTip" class="control-label" style="color:red">*</label>
	</div>
	</#if>
	</#if>
	<div class="form-group">
		<label id="companyNameLabel" for="companyName" class="col-sm-2 control-label">企业名称</label>
		<div class="col-sm-7">
			<input type="text" class="form-control" id="companyName" value="<#if companyName??>${companyName!}<#else></#if>"  readonly="readonly" />
		</div>
		<label id="companyTempNameTip" class="control-label" style="color:red">*</label>
	</div>
	<div class="form-group">
		<label id="addressLabel" for="address" class="col-sm-2 control-label">企业地址</label>
		<div class="col-sm-7">
			<input type="text" class="form-control" id="address" value="<#if address??>${address!}<#else></#if>"  readonly="readonly" />
		</div>
		<label id="addressTip" class="control-label" style="color:red">*</label>
	</div>
	<div class="form-group">
		<label id="telLabel" for="tel" class="col-sm-2 control-label">企业电话</label>
		<div class="col-sm-7">
			<input type="text" class="form-control" id="tel" value="<#if tel??>${tel!}<#else></#if>"  readonly="readonly"/>
		</div>
		<label id="telTip" class="control-label" style="color:red">*</label>
	</div>
		<div class="form-group">
		<label id="emailLabel" for="email" class="col-sm-2 control-label">企业邮箱</label>
		<div class="col-sm-7">
			<input type="text" class="form-control" name="email" value="<#if email??>${email!}<#else></#if>"  readonly="readonly"/>
		</div>
		<label id="emailTip" class="control-label" style="color:red">*</label>
	</div>
	<div class="form-group">
		<label id="contactsLabel" for="contacts" class="col-sm-2 control-label">联系人名称</label>
		<div class="col-sm-7">
			<input type="text" class="form-control" id="contacts" value="<#if contacts??>${contacts!}<#else></#if>"  readonly="readonly" />
		</div>
		<label id="contactsTip" class="control-label" style="color:red">*</label>
	</div>
	<div class="form-group">
		<label id="phoneLabel" for="phone" class="col-sm-2 control-label">联系人电话</label>
		<div class="col-sm-7">
			<input type="text" class="form-control" id="phone" value="<#if phone??>${phone!}<#else></#if>"  readonly="readonly" />
		</div>
		<label id="phoneTip" class="control-label" style="color:red">*</label>
	</div>
	<div class="form-group">
		<label id="businessLicenseLabel" for="businessLicense" class="col-sm-2 control-label">营业执照号</label>
		<div class="col-sm-7">
			<input type="text" class="form-control" id="businessLicense" value="<#if businessLicense??>${businessLicense!}<#else></#if>"  readonly="readonly"/>
		</div>
		<label id="emailTip" class="control-label" style="color:red">*</label>
	</div>
	
	<div class="form-group">
		<label id="attachmentsLabel" for="attachments" class="col-sm-2 control-label">营业执照附件</label>
		<div class="col-sm-7">
      		<div id="attachments" name="attachments" style="border:1px solid">
      		</div>
      	</div>
      	<label id="attachmentsTip" class="control-label" style="color:red"></label>
	</div>
	
	<div class="form-group">
		<label id="busiApproveOpinion" for="email" class="col-sm-2 control-label">审核意见</label>
		<div class="col-sm-7">
			<textArea type="text" <#if RequestParameters["isQuery"]?? && RequestParameters["isQuery"]=="true">readonly</#if> class="form-control" id="busiApproveOpinion" name="busiApproveOpinion"><#if busiApproveOpinion??>${busiApproveOpinion!}<#else></#if></textArea>
		</div>
	</div>
	
	<input type="hidden" id="busiApproveId" name="busiApproveId" value="<#if busiApproveId??>${busiApproveId!}</#if>" />
	<input type="hidden" id="orderBussinkey" name="orderBussinkey" value="<#if orderBussinkey??>${orderBussinkey!}</#if>" />
	
</form>

<#if !RequestParameters["isQuery"]?? || RequestParameters["isQuery"]=="">
	<div style="text-align:center">
		<#if RequestParameters["busiApproveId"]??>
			<a  class="btn btn-primary" onclick="approveCompanyExamine();">
				<i class="glyphicon glyphicon-ok"></i>
				<span>通过</span>
			</a>
			<a  class="btn btn-danger" onclick="rejectCompanyExamine();">
				<i class="glyphicon glyphicon-remove"></i>
				<span>拒绝</span>
			</a>
		</#if>
	</div>
</#if>

</body>
</html>