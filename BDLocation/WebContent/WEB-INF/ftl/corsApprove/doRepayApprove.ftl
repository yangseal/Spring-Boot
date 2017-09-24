<!doctype html>
<html>
<head>
<#include "/head.ftl"/>
<script type="text/javascript" src="${rc.contextPath}/public/js/corsApprove/account.js"></script>
</head>
<body>

<form id="accountRepayForm" class="form-horizontal">
	
	<div class="form-group">
		<label  class="col-sm-2 control-label">企业名称</label>
		<div class="col-sm-7">
			<input type="text" class="form-control" readonly id="company_name" name="company_name" value="<#if repayAccount??>${(repayAccount.company_name)!}<#else></#if>" />
		</div>
		<label id="applyCountTip" class="control-label" style="color:red">*</label>
	</div>
	<div class="form-group">
		<label  class="col-sm-2 control-label">续费数量</label>
		<div class="col-sm-5">
			<input type="text" class="form-control" readonly id="count" name="count" maxlength="6" value="<#if repayAccount??>${(repayAccount.count)!}<#else></#if>"/>
		</div>
		<a  class="btn btn-success" onclick="detailAccount('<#if repayAccount??>${repayAccount.id}</#if>');">
				<span>账号详情</span>
			</a>
	</div>
	
	<div class="form-group">
		<label   class="col-sm-2 control-label">续费期限</label>
		<div class="col-sm-7">
			<input type="text" class="form-control" readonly id="applyCount" name="applyCount" maxlength="6" isNotNull  value="<#if repayAccount??>${(repayAccount.period)!}<#else></#if>" />
		</div>
	</div>
	
	<div class="form-group">
		<label class="col-sm-2 control-label">审核意见</label>
		<div class="col-sm-7">
			<textarea class="form-control" rows="3" id="opinion" name="opinion" isNotNull ><#if repayAccount??>${repayAccount.opinion!}<#else></#if></textarea>
		</div>
		<label id="applyCommentTip" class="control-label" style="color:red"></label>
	</div>
</form>
	<div style="text-align:center">
		<a  class="btn btn-success" onclick="passRepayAccount('<#if repayAccount??>${repayAccount.id}</#if>');">
			<i class="glyphicon glyphicon-ok"></i>
			<span>通过</span>
		</a>
		<a  class="btn btn-danger " onclick="rejectRepayAccount('<#if repayAccount??>${repayAccount.id}</#if>');">
			<i class="glyphicon glyphicon-remove"></i>
			<span>拒绝</span>
		</a>
	</div>
	<input id="companyId" type="hidden" value="<#if repayAccount??>${repayAccount.company_id}" </#if> />
	<input id="account_type" type="hidden" value="<#if repayAccount??>${repayAccount.account_type}" </#if> />
	
</body>
</html>