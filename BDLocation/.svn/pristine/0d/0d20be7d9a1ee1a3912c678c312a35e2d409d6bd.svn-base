<!doctype html>
<html>
<head>
<#include "/head.ftl"/>
<script type="text/javascript" src="${rc.contextPath}/public/js/corsApprove/account.js"></script>
</head>
<body>

<form id="corsApplyForm" class="form-horizontal">
	
	<div class="form-group">
		<label id="applyCountLabel" for="applyCount" class="col-sm-2 control-label">企业名称</label>
		<div class="col-sm-7">
			<input type="text" readonly  class="form-control" id="applyCount" name="applyCount" value="<#if account??>${(account.company_name)!}<#else></#if>" />
		</div>
	</div>
	<div class="form-group">
		<label id="applyCountLabel" for="applyCount" class="col-sm-2 control-label">申请数量</label>
		<div class="col-sm-7">
			<input type="text" readonly  class="form-control" id="applyCount" name="applyCount" value="<#if account??>${(account.count)!}<#else></#if>" />
		</div>
	</div>
	<div class="form-group">
		<label id="bdDeviceAccuracyLabel" for="bdDeviceAccuracy" class="col-sm-2 control-label">入网精度</label>
		<div class="col-sm-7">
			<input type="text" readonly  class="form-control" id="applyCount" name="applyCount" value="${(account.accuracy)!}" />
		</div>
	</div>
	<div class="form-group">
		<label id="accountTypeLabel" for="accountType" class="col-sm-2 control-label">账号类型</label>
		<div class="col-sm-7">
			<input type="text" readonly  class="form-control" id="applyCount" name="applyCount" value="${(account.account_type)!}" />
		</div>
	</div>
	<div class="form-group">
		<label id="purposeDescLabel" for="purposeDesc" class="col-sm-2 control-label">使用期限</label>
		<div class="col-sm-7">
			<input type="text" readonly  class="form-control" id="applyCount" name="applyCount" value="${(account.period)!}" />
		</div>
	</div>
	<div class="form-group">
		<label id="applyCommentLabel" for="applyComment" class="col-sm-2 control-label">备注</label>
		<div class="col-sm-7">
			<textarea class="form-control" rows="3" readonly id="applyComment" name="applyComment"><#if account??>${account.comment!}<#else></#if></textarea>
		</div>
		<label id="applyCommentTip" class="control-label" style="color:red"></label>
	</div>
	<div class="form-group">
		<label id="applyCommentLabel" for="applyComment" class="col-sm-2 control-label">审核意见</label>
		<div class="col-sm-7">
			<textarea class="form-control" rows="3" isNotNull id="applyOpinion" name="applyOpinion"><#if account??>${account.opinion!}<#else></#if></textarea>
		</div>
		<label id="applyCommentTip" class="control-label" style="color:red"></label>
	</div>

</form>
	<div style="text-align:center">
		<a  class="btn btn-success" onclick="passAccount('<#if account??>${account.id!}<#else></#if>');">
			<i class="glyphicon glyphicon-ok"></i>
			<span>通过</span>
		</a>
		<a  class="btn btn-danger " onclick="rejectAccount('<#if account??>${account.id!}<#else></#if>');">
			<i class="glyphicon glyphicon-remove"></i>
			<span>拒绝</span>
		</a>
	</div>


</body>
</html>