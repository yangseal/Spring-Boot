<table id="corsAccountsTable" class="table">
	<tr>
		<th><input type="checkbox" onclick="checkAll(this);" /></th>
		<th>序号</th>
		<th>入网账号</th>
		<th>入网精度</th>
		<th>账户类型</th>
		<th>使用期限</th>
		<th>到期时间</th>
		<th>账号状态</th>
		<th>备注</th>
	</tr>
	<#list corsAccount as corsAccount>
	<tr entityId="${corsAccount.companyGroupId!}" onclick="selectEntity(this);">
		<td>${corsAccount.corsAccountId!}</td>
		<td>${corsAccount.corsAccountCode!}</td>
		<td>${corsAccount.bdDeviceAccuracy!}</td>
		<td>${corsAccount.corsAccountType!}</td>
		<td>${corsAccount.corsAccountPeriod!}</td>
		<td>${corsAccount.exprieDate!}</td>
		<td>${corsAccount.corsAccountState!}</td>
		<td>${corsGroup.remark!}</td>
	</tr>
	</#list>
</table>