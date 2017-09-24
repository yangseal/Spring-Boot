<!doctype html>
<html>
<head>
<#include "/head.ftl"/>
<script type="text/javascript" src="${rc.contextPath}/public/js/corsInit/corsInit.js"></script>
</head>
<body>

<form id="corsApplyForm" class="form-horizontal">
	
	<div class="form-group pt15">
		<label id="applyCountLabel" for="applyCount" class="col-sm-2 control-label">企业名称</label>
		<div class="col-sm-8">
			<input type="text" class="form-control" readonly id="applyCount" name="applyCount" value="<#if corsApply??>${(corsApply.company.companyName)!}<#else></#if>" />
		</div>
	</div>
	<div class="form-group">
		<label id="applyCountLabel" for="applyCount" class="col-sm-2 control-label">申请数量</label>
		<div class="col-sm-8">
			<input type="text" class="form-control" readonly id="applyCount" name="applyCount" maxlength="6" isNotNull  value="<#if corsApply??>${(corsApply.applyCount)!}<#else></#if>" />
		</div>
	</div>
	
	<div class="form-group">
		<label id="bdDeviceAccuracyLabel" for="bdDeviceAccuracy"  class="col-sm-2 control-label">入网精度</label>
		<div class="col-sm-8">
			<input type="text" class="form-control" readonly id="applyCount" name="applyCount" maxlength="6" isNotNull  value="<#if corsApply??>${(corsApply.bdDeviceAccuracyName)!}<#else></#if>" />
		</div>
	</div>
	<div class="form-group">
		<label id="accountTypeLabel" for="accountType"  class="col-sm-2 control-label">账号类型</label>
		<div class="col-sm-8">
			<input type="text" class="form-control" readonly id="applyCount" name="applyCount" maxlength="6" isNotNull validateExp="^[1-9]\d*$" value="<#if corsApply??>${(corsApply.accountTypeName)!}<#else></#if>" />
		</div>
	</div>
	<div class="form-group">
		<label id="purposeDescLabel" for="purposeDesc"  class="col-sm-2 control-label">使用期限</label>
		<div class="col-sm-8">
			<input type="text" class="form-control" readonly id="applyCount" name="applyCount" maxlength="6" isNotNull value="<#if corsApply?? && corsApply.accountType == "test">${corsApply.accountUsePeriod}个月<#else>${corsApply.accountUsePeriod}年</#if>" />
		</div>
	</div>
	<div class="form-group">
		<label id="applyCommentLabel" for="applyComment" class="col-sm-2 control-label">备注</label>
		<div class="col-sm-8">
			<textarea class="form-control" rows="3" id="applyComment" name="applyComment" readonly><#if corsApply??>${corsApply.applyComment!}<#else></#if></textarea>
		</div>
	</div>
	<div class="form-group">
		<label id="applyCommentLabel" for="applyComment" class="col-sm-2 control-label">生成状态</label>
		<div class="col-sm-8">
			<input type="text" class="form-control" readonly id="applyCount" name="applyCount" value="<#if corsApply??>${(corsApply.accountCreateStateName)!}<#else></#if>" />
		</div>
	</div>
	<div class="form-group">
		<label id="applyCountLabel" for="applyCount" class="col-sm-2 control-label">账号查看</label>
		<div class="col-sm-8">
			<a  class="btn btn-success" onclick="detailAccount('<#if corsApply??>${(corsApply.corsApplyId)!}<#else></#if>')">
			<span>查看</span>
		</a>
		</div>
	</div>
</form>

</body>
</html>