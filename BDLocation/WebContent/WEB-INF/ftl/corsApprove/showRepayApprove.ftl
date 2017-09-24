<!doctype html>
<html>
<head>
<#include "/head.ftl"/>
<script type="text/javascript" src="${rc.contextPath}/public/js/corsApprove/corsApprove.js"></script>
</head>
<body>

<form id="accountRepayForm" class="form-horizontal">
	
	<div class="form-group">
		<label id="applyCountLabel" for="applyCount" class="col-sm-2 control-label">企业名称</label>
		<div class="col-sm-7">
			<input type="text" class="form-control" readonly id="applyCount" name="applyCount" value="<#if accountRepay??>${(accountRepay.company_name)!}<#else></#if>" />
		</div>
	</div>
	<div class="form-group">
		<label id="applyCountLabel" for="applyCount" class="col-sm-2 control-label">续费数量</label>
		<div class="col-sm-5">
			<input type="text" class="form-control" readonly id="applyCount" name="applyCount" maxlength="6" value="<#if accountRepay??>${(accountRepay.count)!}<#else></#if>"/>
		</div> 
		<a  class="btn btn-success" onclick="detailAccount('<#if accountRepay??>${accountRepay.id}<#else></#if>');">
			<span>账号详情</span>
		</a>
	</div>
	<div class="form-group">
		<label id="bdDeviceAccuracyLabel" for="bdDeviceAccuracy"  class="col-sm-2 control-label">续费期限</label>
		<div class="col-sm-7">
			<input type="text" class="form-control" readonly id="applyCount" name="applyCount" maxlength="6" isNotNull  value="<#if accountRepay??>${(accountRepay.accuracy)!}<#else></#if>" />
		</div>
	</div>
	<div class="form-group">
		<label id="applyCommentLabel" for="applyComment" class="col-sm-2 control-label">审核意见</label>
		<div class="col-sm-7">
			<textarea class="form-control" rows="3" id="applyComment" name="applyComment" readonly><#if accountRepay??>${accountRepay.opinion!}<#else></#if></textarea>
		</div>
	</div>
	<div class="form-group">
		<label id="applyCountLabel" for="applyCount" class="col-sm-2 control-label">审核状态</label>
		<div class="col-sm-7">
			<input type="text" class="form-control" id="applyCount" name="applyCount" maxlength="6" readonly value="<#if accountRepay??>${accountRepay.status!}<#else></#if>" />
		</div>
	</div>
</form>

</body>
</html>