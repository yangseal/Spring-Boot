<div style="height:450px;overflow:auto;">
<table id="corsApprovesTable" class="table">
	<tr>
		<th>入网账号</th>
		<th>账号密码</th>
		<th>入网精度</th>
		<th>账户类型</th>
		<th>使用期限</th>
		<th>账号状态</th>
		
	</tr>
	<#list account as account>
	
	<tr>
		<td>${account.corsAccountCode!}</td>
		<td>${account.corsAccountPwd!}</td>
		<td>${account.bdDeviceAccuracyName!}</td>
		<td>${account.corsAccountTypeName!}</td>
		<td>${account.corsAccountPeriod!}<#if account.corsAccountType?? && account.corsAccountType == "test">个月<#else>年</#if></td>
		<td>${account.corsAccountStateName!}</td>
	</tr>
	</#list>
</table>
</div>