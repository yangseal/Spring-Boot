<table id="corsApprovesTable" class="table">
	<tr>
		<th><input type="checkbox" onclick="checkAll(this);" /></th>
		<th>入网账号</th>
		<th>入网精度</th>
		<th>账户类型</th>
		<th>使用期限</th>
		<th>设备型号</th>
		<th>设备SN</th>
	</tr>
	<#list account as account>
	
	<tr>
		<td><input type="checkbox" /></td>
		<td>${account.corsAccount.corsAccountCode!}</td>
		<td>${account.corsAccount.bdDeviceAccuracyName!}</td>
		<td>${account.corsAccount.corsAccountTypeName!}</td>
		<td>${account.corsAccount.corsAccountPeriod!}<#if account.corsAccount?? && account.corsAccount.corsAccountType == "test">个月<#else>年</#if></td>
		<td>${account.corsAccount.bdDevice!}</td>
		<td>${account.corsAccount.bdDeviceSn!}</td>
	</tr>
	</#list>
</table>