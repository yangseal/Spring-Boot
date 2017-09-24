<table id="corsAccountsTable" class="table">
	<tr>
		<th><input type="checkbox" onclick="checkAll(this);" /></th>
		<th>所属企业</th>
		<th>申请批次</th>
		<th>账号编码</th>
		<th>CORS密码</th>
		<th>账号类型</th>
		<th>应用区域</th>
		<th>定位设备型号</th>
		<th>定位设备SN号</th>
		<th>定位设备入网精度</th>
		<th>起始有效期</th>
		<th>结束有效期</th>
		<th>备注</th>
	</tr>
	<#list page.result as corsAccount>
	<tr entityId="${corsAccount.corsAccountId!}" onclick="selectEntity(this);">
		<td><input type="checkbox" /></td>
		<td><#if corsAccount.company??>${corsAccount.company.companyName!}</#if></td>
		<td><#if corsAccount.corsApply??>${corsAccount.corsApply.corsApplyName!}</#if></td>
		<td>${corsAccount.corsAccountCode!}</td>
		<td>${corsAccount.corsAccountPwd!}</td>
		<td><#if !corsAccount.corsAccountType??><#elseif "test"==corsAccount.corsAccountType>测试<#elseif "formal"==corsAccount.corsAccountType>正式</#if></td>
		<td><#if corsAccount.oamArea??>${corsAccount.oamArea.oamAreaName!}</#if></td>
		<td>${corsAccount.bdDevice!}</td>
		<td>${corsAccount.bdDeviceSn!}</td>
		<td><#if !corsAccount.bdDeviceAccuracy??><#elseif "meter"==corsAccount.bdDeviceAccuracy>亚米<#elseif "centimeter"==corsAccount.bdDeviceAccuracy>厘米</#if></td>
		<td>${corsAccount.effectiveDate!}</td>
		<td>${corsAccount.exprieDate!}</td>
		<td>${corsAccount.remark!}</td>
	</tr>
	</#list>
</table>
<@common.pager page.pageBean "corsAccountsForm" "corsAccountsDiv"/>