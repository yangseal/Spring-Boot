<!doctype html>
<html>
<head>
<#include "/head.ftl"/>
<script type="text/javascript" src="${rc.contextPath}/public/js/baseStation/customer/showContracts.js"></script>
<script type="text/javascript" src="${rc.contextPath}/public/js/baseStation/baseStation.js"></script>
</head>
<body>
<form id="contractForm" class="form-horizontal">
	<div class="form-group pt15">
		<label id="custContractNoLabel" for="custContractNo" class="col-sm-2 control-label">合同编号</label>
		<div class="col-sm-8">
			<input type="text" class="form-control" id="custContractNo" name="custContractNo" value="<#if contract??>${contract.custContractNo!}</#if>" isNotNull />
		</div>
		<label id="custContractNoTip" class="control-label" style="color:red">*</label>
	</div>
	<div class="form-group">
		<label id="custContractNameLabel" for="custContractName" class="col-sm-2 control-label">合同名称</label>
		<div class="col-sm-8">
			<input type="text" class="form-control" id="custContractName" name="custContractName" value="<#if contract??>${contract.custContractName!}</#if>" isNotNull />
		</div>
		<label id="custContractNameTip" class="control-label" style="color:red">*</label>
	</div>
	<div class="form-group">
		<label id="custContractTypeLabel" for="custContractType" class="col-sm-2 control-label">合同类型</label>
		<div class="col-sm-8">
			<input type="text" class="form-control" id="custContractType" name="custContractType" value="<#if contract??>${contract.custContractType!}</#if>"  />
		</div>
		<label id="custContractTypeTip" class="control-label" style="color:red"></label>
	</div>
	<div class="form-group has-feedback">
		<label id="custContractDateLabel" for="custContractDate" class="col-sm-2 control-label">签订日期</label>
		<div class="col-sm-8">
			<input type="text" class="form-control" readOnly id="custContractDate" name="custContractDate" isNotNull value="<#if contract??>${contract.custContractDate!}<#else>${.now?string("yyyy-MM-dd HH:mm:ss")}</#if>" onclick="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm:ss'});" />
			<span class="glyphicon glyphicon-menu-hamburger form-control-feedback"></span>
		</div>
		<label id="custContractDateTip" class="control-label" style="color:red">*</label>
	</div> 
	<div class="form-group">
		<label id="custContractPartyaLabel" for="custContractPartya" class="col-sm-2 control-label">合同甲方</label>
		<div class="col-sm-8">
			<input type="text" class="form-control" id="custContractPartya" name="custContractPartya" value="<#if contract??>${contract.custContractPartya!}</#if>" isNotNull/>
		</div>
		<label id="custContractPartyaTip" class="control-label" style="color:red">*</label>
	</div>
	<div class="form-group">
		<label id="custContractPartybLabel" for="custContractPartyb" class="col-sm-2 control-label">合同乙方</label>
		<div class="col-sm-8">
			<input type="text" class="form-control" id="custContractPartyb" name="custContractPartyb" value="<#if contract??>${contract.custContractPartyb!}</#if>" isNotNull/>
		</div>
		<label id="custContractPartybTip" class="control-label" style="color:red">*</label>
	</div>
	<div class="form-group">
		<label id="custContractAddressLabel" for="custContractAddress" class="col-sm-2 control-label">签订地点</label>
		<div class="col-sm-8">
			<input type="text" class="form-control" id="custContractAddress" name="custContractAddress" value="<#if contract??>${contract.custContractAddress!}</#if>" />
		</div>
		<label id="custContractAddressTip" class="control-label" style="color:red"></label>
	</div>
	<div class="form-group">
		<label id="stationMapNoLabel" for="" class="col-sm-2 control-label">所属客户</label>
		<div class="col-sm-8">
			<input type="text" class="form-control"  id="baseCustomer" disabled value="<#if baseCustomer??>${baseCustomer.customerName!}</#if>" />
		</div>
		<label id="stationMapNoTip" class="control-label" style="color:red">*</label>
	</div>
	<div class="form-group">
		<label id="custContractRemarkLabel" for="custContractRemark" class="col-sm-2 control-label">备注</label>
		<div class="col-sm-8">
			<input type="text" class="form-control" id="custContractRemark" name="custContractRemark" value="<#if contract??>${contract.custContractRemark!}</#if>" />
		</div>
		<label id="custContractRemarkTip" class="control-label" style="color:red"></label>
	</div>
	<div class="form-group">
		<label id="attachmentsLabel" for="attachments" class="col-sm-2 control-label">合同附件</label>
		<div class="col-sm-8">
      		<div id="attachments" name="attachments" class="fj_box" style="padding-top:10px;">
      		</div>
      	</div>
      	<label id="attachmentsTip" class="control-label" style="color:red"></label>
	</div>
	<input type="hidden" id="baseCustomerId" name="baseCustomer.baseCustomerId" value="<#if baseCustomer.baseCustomerId??>${baseCustomer.baseCustomerId!}</#if>" />
	<input type="hidden" name="baseCustomerContractId" id="baseCustomerContractId" value="<#if contract??>${contract.baseCustomerContractId!}</#if>">
	<input type="hidden" name="createUser" id="createUser" value="<#if contract??>${contract.createUser!}</#if>">
	<input type="hidden" name="createTime" id="createTime" value="<#if contract??>${contract.createTime!}</#if>">
</form>
<#if !RequestParameters["isQuery"]?? || RequestParameters["isQuery"]=="">
<div class="form-group">
      <label class="col-sm-2 control-label"></label>
      <div class="col-sm-8" style="text-align:center;">
	<a  class="btn btn-success" onclick="saveContract();">
		<i class="glyphicon glyphicon-save"></i>
		<span>保存</span>
	</a>
	</div>
</div>
</#if>
</body>
</html>