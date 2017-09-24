<!doctype html>
<html>
<head>
<#include "/head.ftl"/>
<script type="text/javascript" src="${rc.contextPath}/public/js/corsAccount/corsAccount.js"></script>
</head>
<body>

<form id="corsAccountForm" class="form-horizontal">
	<#if !RequestParameters["companyId"]?? || RequestParameters["companyId"]=="">
	<div class="form-group has-feedback">
		<label id="companyLabel" for="company" class="col-sm-2 control-label">所属企业</label>
		<div class="col-sm-7">
			<input type="text" class="form-control" style="cursor:pointer" id="company" name="company" isNotNull value="<#if corsAccount?? && corsAccount.company??>${corsAccount.company.companyName!}</#if>" onclick="selectCompany();" />
			<span class="glyphicon glyphicon-menu-hamburger form-control-feedback"></span>
		</div>
		<label id="companyTip" class="control-label" style="color:red">*</label>
	</div>
	</#if>
	<input type="hidden" id="companyId" name="company.companyId" value="<#if corsAccount?? && corsAccount.company??>${corsAccount.company.companyId!}<#elseif RequestParameters["companyId"]??>${RequestParameters["companyId"]!}<#elseif !corsAccount??>${CURRENT_USER.company.companyId}</#if>" />
	<#if !RequestParameters["corsApplyId"]?? || RequestParameters["corsApplyId"]=="">
	<div class="form-group has-feedback">
		<label id="corsApplyLabel" for="corsApply" class="col-sm-2 control-label">申请批次</label>
		<div class="col-sm-7">
			<input type="text" class="form-control" style="cursor:pointer" id="corsApply" name="corsApply" value="<#if corsAccount?? && corsAccount.corsApply??>${corsAccount.corsApply.corsApplyName!}</#if>" onclick="selectCorsApply();" />
			<span class="glyphicon glyphicon-menu-hamburger form-control-feedback"></span>
		</div>
		<label id="corsApplyTip" class="control-label" style="color:red"></label>
	</div>
	</#if>
	<input type="hidden" id="corsApplyId" name="corsApply.corsApplyId" value="<#if corsAccount?? && corsAccount.corsApply??>${corsAccount.corsApply.corsApplyId!}<#else>${RequestParameters["corsApplyId"]!}</#if>" />
	<div class="form-group">
		<label id="corsAccountCodeLabel" for="corsAccountCode" class="col-sm-2 control-label">账号编码</label>
		<div class="col-sm-7">
			<input type="text" class="form-control" id="corsAccountCode" name="corsAccountCode" isNotNull value="<#if corsAccount??>${corsAccount.corsAccountCode!}<#else></#if>" />
		</div>
		<label id="corsAccountCodeTip" class="control-label" style="color:red">*</label>
	</div>
	<div class="form-group">
		<label id="corsAccountPwdLabel" for="corsAccountPwd" class="col-sm-2 control-label">CORS密码</label>
		<div class="col-sm-7">
			<input type="text" class="form-control" id="corsAccountPwd" name="corsAccountPwd" isNotNull value="<#if corsAccount??>${corsAccount.corsAccountPwd!}<#else></#if>" />
		</div>
		<label id="corsAccountPwdTip" class="control-label" style="color:red">*</label>
	</div>
	<div class="form-group">
		<label id="corsAccountTypeLabel" for="corsAccountType" class="col-sm-2 control-label">账号类型</label>
		<div class="col-sm-7">
			<select class="form-control" id="corsAccountType" name="corsAccountType" isNotNull>
				<option <#if corsAccount?? && corsAccount.corsAccountType?? && "test"==corsAccount.corsAccountType || !corsAccount?? && "test"=="formal">selected</#if> value="test">测试</option>
				<option <#if corsAccount?? && corsAccount.corsAccountType?? && "formal"==corsAccount.corsAccountType || !corsAccount?? && "formal"=="formal">selected</#if> value="formal">正式</option>
			</select>
		</div>
		<label id="corsAccountTypeTip" class="control-label" style="color:red">*</label>
	</div>
	<#if !RequestParameters["oamAreaId"]?? || RequestParameters["oamAreaId"]=="">
	<div class="form-group has-feedback">
		<label id="oamAreaLabel" for="oamArea" class="col-sm-2 control-label">应用区域</label>
		<div class="col-sm-7">
			<input type="text" class="form-control" style="cursor:pointer" id="oamArea" name="oamArea" isNotNull value="<#if corsAccount?? && corsAccount.oamArea??>${corsAccount.oamArea.oamAreaName!}</#if>" onclick="selectOamArea();" />
			<span class="glyphicon glyphicon-menu-hamburger form-control-feedback"></span>
		</div>
		<label id="oamAreaTip" class="control-label" style="color:red">*</label>
	</div>
	</#if>
	<input type="hidden" id="oamAreaId" name="oamArea.oamAreaId" value="<#if corsAccount?? && corsAccount.oamArea??>${corsAccount.oamArea.oamAreaId!}<#else>${RequestParameters["oamAreaId"]!}</#if>" />
	<div class="form-group">
		<label id="bdDeviceLabel" for="bdDevice" class="col-sm-2 control-label">定位设备型号</label>
		<div class="col-sm-7">
			<input type="text" class="form-control" id="bdDevice" name="bdDevice" value="<#if corsAccount??>${corsAccount.bdDevice!}<#else></#if>" />
		</div>
		<label id="bdDeviceTip" class="control-label" style="color:red"></label>
	</div>
	<div class="form-group">
		<label id="bdDeviceSnLabel" for="bdDeviceSn" class="col-sm-2 control-label">定位设备SN号</label>
		<div class="col-sm-7">
			<input type="text" class="form-control" id="bdDeviceSn" name="bdDeviceSn" value="<#if corsAccount??>${corsAccount.bdDeviceSn!}<#else></#if>" />
		</div>
		<label id="bdDeviceSnTip" class="control-label" style="color:red"></label>
	</div>
	<div class="form-group">
		<label id="bdDeviceAccuracyLabel" for="bdDeviceAccuracy" class="col-sm-2 control-label">定位设备入网精度</label>
		<div class="col-sm-7">
			<select class="form-control" id="bdDeviceAccuracy" name="bdDeviceAccuracy" isNotNull>
				<option <#if corsAccount?? && corsAccount.bdDeviceAccuracy?? && "meter"==corsAccount.bdDeviceAccuracy || !corsAccount?? && "meter"=="meter">selected</#if> value="meter">亚米</option>
				<option <#if corsAccount?? && corsAccount.bdDeviceAccuracy?? && "centimeter"==corsAccount.bdDeviceAccuracy || !corsAccount?? && "centimeter"=="meter">selected</#if> value="centimeter">厘米</option>
			</select>
		</div>
		<label id="bdDeviceAccuracyTip" class="control-label" style="color:red">*</label>
	</div>
	<div class="form-group has-feedback">
		<label id="effectiveDateLabel" for="effectiveDate" class="col-sm-2 control-label">起始有效期</label>
		<div class="col-sm-7">
			<input type="text" class="form-control" id="effectiveDate" name="effectiveDate" value="<#if corsAccount??>${corsAccount.effectiveDate!}<#else></#if>" onclick="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm:ss'});" />
			<span class="glyphicon glyphicon-menu-hamburger form-control-feedback"></span>
		</div>
		<label id="effectiveDateTip" class="control-label" style="color:red"></label>
	</div>
	<div class="form-group has-feedback">
		<label id="exprieDateLabel" for="exprieDate" class="col-sm-2 control-label">结束有效期</label>
		<div class="col-sm-7">
			<input type="text" class="form-control" id="exprieDate" name="exprieDate" value="<#if corsAccount??>${corsAccount.exprieDate!}<#else></#if>" onclick="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm:ss'});" />
			<span class="glyphicon glyphicon-menu-hamburger form-control-feedback"></span>
		</div>
		<label id="exprieDateTip" class="control-label" style="color:red"></label>
	</div>
	<div class="form-group">
		<label id="remarkLabel" for="remark" class="col-sm-2 control-label">备注</label>
		<div class="col-sm-7">
			<input type="text" class="form-control" id="remark" name="remark" value="<#if corsAccount??>${corsAccount.remark!}<#else></#if>" />
		</div>
		<label id="remarkTip" class="control-label" style="color:red"></label>
	</div>
	<input type="hidden" id="corsAccountId" name="corsAccountId" value="<#if corsAccount??>${corsAccount.corsAccountId!}</#if>" />
</form>
<#if !RequestParameters["isQuery"]?? || RequestParameters["isQuery"]=="">
<div class="card-page-command">
	<a  class="btn btn-success" onclick="saveCorsAccount();">
		<i class="glyphicon glyphicon-save"></i>
		<span>保存</span>
	</a>
</div>
</#if>

</body>
</html>