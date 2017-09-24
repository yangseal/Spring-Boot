<!doctype html>
<html>
<head>
<#include "/head.ftl"/>
<script type="text/javascript" src="${rc.contextPath}/public/js/corsApplyMaterial/materialsDetail.js"></script>
</head>
<body>

<form id="materialsForm" class="form-horizontal">
		<div class="form-group pt15">
			<label id="companyNameLabel" for="companyName" class="col-sm-2 control-label" >企业名称</label>
			<div class="col-sm-8">
				<input type="text" class="form-control" readOnly id="companyName" value="<#if companyName??>${companyName!}<#else></#if>" />
			</div>
		</div>
	<#if !RequestParameters["isQuery"]?? || RequestParameters["isQuery"]=="">
		<div class="form-group">
			<label id="applyCountLabel" for="applyCount" class="col-sm-2 control-label" >申请数量</label>
			<div class="col-sm-8">
				<input type="text" class="form-control" readOnly id="applyCount" value="<#if applyCount??>${applyCount!}个</#if>" />
			</div>
		</div>
	</#if>
	<div class="form-group">
		<label id="applyContractNoLabel" for="applyContractNo" class="col-sm-2 control-label" >合同编号</label>
		<div class="col-sm-8">
			<input type="text" class="form-control" id="applyContractNo" isNotNull <#if RequestParameters["isQuery"]?? && RequestParameters["isQuery"]!="">readOnly</#if> id="applyContractNo" name="applyContractNo" value="<#if applyContractNo??>${applyContractNo!}<#else></#if>" />
		</div>
	</div>
	<div class="form-group">
		<label id="applyInvoiceNoLabel" for="applyInvoiceNo" class="col-sm-2 control-label">发票编号</label>
		<div class="col-sm-8">
			<input type="text" class="form-control" id="applyInvoiceNo" <#if RequestParameters["isQuery"]?? && RequestParameters["isQuery"]!="">readOnly</#if> id="applyInvoiceNo"  name="applyInvoiceNo" value="<#if applyInvoiceNo??>${applyInvoiceNo!}<#else></#if>" />
		</div>
	</div>
	
	<div class="form-group">
		<label id="isIntoAccountLabel" for="isIntoAccount" class="col-sm-2 control-label">是否到账</label>
		<div class="col-sm-8">
			<select <#if RequestParameters["isQuery"]?? && RequestParameters["isQuery"]!="">disabled</#if>  class="form-control" id="isIntoAccount" readOnly name="isIntoAccount" isNotNull>
				<option <#if RequestParameters["isQuery"]?? && RequestParameters["isQuery"]!="">disabled</#if> <#if isIntoAccount?? && "YES"==isIntoAccount>selected</#if> value="YES">已到账</option>
				<option <#if RequestParameters["isQuery"]?? && RequestParameters["isQuery"]!="">disabled</#if> <#if isIntoAccount?? && "NO"==isIntoAccount>selected</#if> value="NO">未到账</option>
			</select>
		</div>
	</div>
	<div class="form-group">
		<label id="applyMaterialRemarkLabel" for="applyMaterialRemark" class="col-sm-2 control-label">备注</label>
		<div class="col-sm-8">
			<textArea type="text" class="form-control" <#if RequestParameters["isQuery"]?? && RequestParameters["isQuery"]!="">readOnly</#if> id="applyMaterialRemark" name="applyMaterialRemark"><#if applyMaterialRemark??>${applyMaterialRemark!}<#else></#if></textArea>
		</div>
	</div>
	
	<div class="form-group">
		<label id="attachmentsLabel" for="attachments" class="col-sm-2 control-label">附件列表</label>
		<div class="col-sm-8">
      		<div id="attachments" name="attachments" class="fj_box" style="padding-top:10px;">
      		</div>
      	</div>
	</div>
	<input type="hidden" id="busiApproveType" name="busiApproveType" value="<#if busiApproveType??>${busiApproveType!}<#else></#if>" />
	<input type="hidden" id="orderBussinkey" name="orderBussinkey" value="<#if orderBussinkey??>${orderBussinkey!}<#else></#if>" />
	<input type="hidden" id="applyMaterialId" name = "applyMaterialId" value="<#if applyMaterialId??>${applyMaterialId!}<#else></#if>"/>
	
</form>

<#if !RequestParameters["isQuery"]?? || RequestParameters["isQuery"]=="">
	<div class="form-group">
      <label class="col-sm-2 control-label"></label>
      <div class="col-sm-8" style="text-align:center;">
		
			<a  class="btn btn-primary" onclick="saveMaterialByPage();">
				<i class="glyphicon glyphicon-ok"></i>
				<span>保存</span>
			</a>
          </div>
	</div>
</#if>

</body>
</html>