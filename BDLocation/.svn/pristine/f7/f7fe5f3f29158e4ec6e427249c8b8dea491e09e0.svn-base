<!doctype html>
<html>
<head>
<#include "/head.ftl"/>
<script type="text/javascript" src="${rc.contextPath}/public/js/corsApply/corsApply.js"></script>
</head>
<body>

<form id="corsApplyForm" class="form-horizontal">
	<input type="hidden" id="companyId" name="company.companyId" value="<#if corsApply?? && corsApply.company??>${corsApply.company.companyId!}<#elseif RequestParameters["companyId"]??>${RequestParameters["companyId"]!}<#elseif !corsApply??>${CURRENT_USER.company.companyId}</#if>" />
	<input type="hidden" id="userId" name="user.userId" value="<#if corsApply?? && corsApply.user??>${corsApply.user.userId!}<#elseif RequestParameters["userId"]??>${RequestParameters["userId"]!}<#elseif !corsApply??>${CURRENT_USER.userId}</#if>" />
	<div class="form-group">
		<label id="applyCountLabel" for="applyCount" class="col-sm-2 control-label">申请数量</label>
		<div class="col-sm-4">
			<input type="text" style="width:65%; float:left;" class="form-control" id="applyCount" name="applyCount" maxlength="6" isNotNull validateExp="^[1-9]\d*$" validateTip="请输入整数数字" value="<#if corsApply??>${(corsApply.applyCount?c)!}<#else></#if>" />
		</div>
		<label id="applyCountTip" class="control-label" style="color:red">*</label>
	</div>
	<div class="form-group">
		<label id="bdDeviceAccuracyLabel" for="bdDeviceAccuracy" class="col-sm-2 control-label">入网精度</label>
		<div class="col-sm-4">
			<select class="form-control" id="bdDeviceAccuracy" name="bdDeviceAccuracy">
				<option <#if corsApply?? && corsApply.bdDeviceAccuracy?? && "meter"==corsApply.bdDeviceAccuracy>selected</#if> value="meter">亚米</option>
				<option <#if corsApply?? && corsApply.bdDeviceAccuracy?? && "centimeter"==corsApply.bdDeviceAccuracy>selected</#if> value="centimeter">厘米</option>
			</select>
		</div>
	</div>
	<div class="form-group">
		<label id="accountTypeLabel" for="accountType" class="col-sm-2 control-label">账户类型</label>
		<div class="col-sm-4">
			<select class="form-control" id="accountType" name="accountType">
				<option <#if corsApply?? && corsApply.accountType?? && "test"==corsApply.accountType>selected</#if> value="test">测试</option>
				<option <#if corsApply?? && corsApply.accountType?? && "formal"==corsApply.accountType>selected</#if> value="formal">正式</option>
			</select>
		</div>
	</div>
	<div class="form-group">
		<label id="accountTypeLabel" for="accountUserPeriod" class="col-sm-2 control-label">使用期限</label>
		<div class="col-sm-4">
		
		<label>	<input  type="radio"   name="accountPeriod" value="1" checked>1年</label>
	
			<label><input type="radio"  name="accountPeriod" value="2">2年</label>
			
		<label>	<input type="radio"  name="accountPeriod" value="3">3年		</label>
			其他:<input type="text" style="width:35px;" name="accountPeriod" >年			
		</div>
	</div>
	<div class="form-group has-feedback">
		<label id="applyDateLabel" for="applyDate" class="col-sm-2 control-label">备注</label>
		<div class="col-sm-4">
			<textarea class="form-control" rows="3" id="applyComment" name="applyComment" value=""></textarea>
		</div>
	</div>
	<input type="hidden" class="form-control" id="applyDate" name="applyDate" value="<#if corsApply??>${corsApply.applyDate!}<#else>${.now?string("yyyy-MM-dd HH:mm:ss")}</#if>" />
	<input type="hidden" id="corsApplyId" name="corsApplyId" value="<#if corsApply??>${corsApply.corsApplyId!}</#if>" />
</form>
<#if !RequestParameters["isQuery"]?? || RequestParameters["isQuery"]=="">
<div class="card-page-command">
	<a  class="btn btn-success" onclick="saveCorsApply();">
		<i class="glyphicon glyphicon-save"></i>
		<span>保存</span>
	</a>
</div>
</#if>

</body>
</html>