<!doctype html>
<html>
<head>
<#include "/head.ftl"/>
<script type="text/javascript" src="${rc.contextPath}/public/js/baseStation/provider/providerContract.js"></script>
<script type="text/javascript" src="${rc.contextPath}/public/js/baseStation/baseStation.js"></script>
</head>
<body>
<form id="providerContractForm" class="form-horizontal">
	<input type="hidden" id="baseProContractId" name="baseProContractId" value="<#if proContract??>${proContract.baseProContractId!}</#if>" />
	<input type="hidden" id="baseProviderId" name="baseProvider.baseProviderId" value="<#if baseProvider??>${baseProvider.baseProviderId!}</#if>" />
	<div class="form-group pt15">
		<label id="proContractNoLabel" for="proContractNo" class="col-sm-2 control-label">合同编号</label>
		<div class="col-sm-8">
			<input type="text" class="form-control" id="proContractNo" name="proContractNo" value="<#if proContract??>${proContract.proContractNo!}</#if>" isNotNull />
		</div>
		<label id="proContractNoTip" class="control-label" style="color:red">*</label>
	</div>
	<div class="form-group">
		<label id="proContractNameLabel" for="proContractName" class="col-sm-2 control-label">合同名称</label>
		<div class="col-sm-8">
			<input type="text" class="form-control" id="proContractName" name="proContractName" value="<#if proContract??>${proContract.proContractName!}</#if>" isNotNull />
		</div>
		<label id="proContractNameTip" class="control-label" style="color:red">*</label>
	</div>
	<div class="form-group">
		<label id="proContractTypeLabel" for="proContractType" class="col-sm-2 control-label">合同类型</label>
		<div class="col-sm-8">
			<input type="text" class="form-control" id="proContractType" name="proContractType" value="<#if proContract??>${proContract.proContractType!}</#if>" />
		</div>
	</div>
	<div class="form-group">
		<label id="proContractDateLabel" for="proContractDate" class="col-sm-2 control-label">签订日期</label>
		<div class="col-sm-8">
			<input type="text" class="form-control" id="proContractDate" readOnly name="proContractDate" value="<#if proContract??>${proContract.proContractDate!}</#if>" onclick="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm:ss'});" isNotNull />
			<span class="glyphicon glyphicon-menu-hamburger form-control-feedback"></span>
		</div>
		<label id="proContractDateTip" class="control-label" style="color:red">*</label>
	</div>  
	<div class="form-group">
		<label id="proContractPartyaLabel" for="proContractPartya" class="col-sm-2 control-label">合同甲方</label>
		<div class="col-sm-8">
			<input type="text" class="form-control" id="proContractPartya" name="proContractPartya" value="<#if proContract??>${proContract.proContractPartya!}</#if>" isNotNull/>
		</div>
		<label id="proContractPartyaTip" class="control-label" style="color:red">*</label>
	</div>
	<div class="form-group">
		<label id="proContractPartybLabel" for="proContractPartyb" class="col-sm-2 control-label">合同乙方</label>
		<div class="col-sm-8">
			<input type="text" class="form-control" id="proContractPartyb" name="proContractPartyb" value="<#if proContract??>${proContract.proContractPartyb!}</#if>" isNotNull />
		</div>
		<label id="proContractPartybTip" class="control-label" style="color:red">*</label>
	</div>
	<div class="form-group">
		<label id="proContractAddressLabel" for="proContractAddress" class="col-sm-2 control-label">签订地点</label>
		<div class="col-sm-8">
			<input type="text" class="form-control" id="proContractAddress" name="proContractAddress" value="<#if proContract??>${proContract.proContractAddress!}</#if>" />
		</div>
	</div>
	<div class="form-group has-feedback">
		<label id="baseProjectLabel" for="baseProject" class="col-sm-2 control-label">所属项目</label>
		<div class="col-sm-8">
			<input type="text" class="form-control" style="cursor:pointer" id="baseProject"  value="<#if proContract?? && proContract.baseProject??>${proContract.baseProject.projectName!}</#if>" onclick="selectBaseProject();" readonly isNotNull />
			<span class="glyphicon glyphicon-menu-hamburger form-control-feedback"></span>
			<input type="hidden" id="baseProjectId" name="baseProject.baseProjectId" value="<#if proContract?? && proContract.baseProject??>${proContract.baseProject.baseProjectId!}</#if>" />
		</div>
		<label id="baseProjectTip" class="control-label" style="color:red">*</label>
	</div>
	<div class="form-group">
		<label id="baseProviderLabel" for="baseProvider" class="col-sm-2 control-label">所属供应商</label>
		<div class="col-sm-8">
			<input type="text" class="form-control" id="baseProvider" name="baseProvider.providerName" disabled value="<#if baseProvider??>${baseProvider.providerName!}</#if>" />
		</div>
	</div>
	<div class="form-group">
		<label id="contractRemarkLabel" for="contractRemark" class="col-sm-2 control-label">备注</label>
		<div class="col-sm-8">
			<textarea class="form-control" id="contractRemark" name="contractRemark"><#if proContract??>${proContract.contractRemark!}</#if></textarea>
		</div>
	</div>
	<div class="form-group">
		<label id="attachmentsLabel" for="attachments" class="col-sm-2 control-label">合同附件</label>
		<div class="col-sm-8">
      		<div id="attachments" name="attachments" class="fj_box" style="padding-top:10px;">
      		</div>
      	</div>
      	<label id="attachmentsTip" class="control-label" style="color:red"></label>
	</div>
</form>
<div style="text-align:center;">
	<a class="btn btn-success" onclick="saveProContract();">
		<i class="glyphicon glyphicon-save"></i>
		<span>保存</span>
	</a>
</div>
</body>
</html>