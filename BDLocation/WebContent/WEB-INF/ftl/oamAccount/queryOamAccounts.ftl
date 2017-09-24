<table id="oamAccountsTable" class="table">
	<tr>
		<th><input type="checkbox" onclick="checkAll(this);" /></th>
		<th>账号名称</th>
		<th>账号密码</th>
		<th>所属客户</th>
		<th>登录次数</th>
		<th>是否在线</th>
	</tr>
	<#list page.result as oamAccount>
	<tr entityId="${oamAccount.oamAccountId!}" onclick="selectEntity(this);">
		<td><input type="checkbox" /></td>
		<td>${oamAccount.oamAccountName!}</td>
		<td>${oamAccount.pwd!}</td>
		<td><#if oamAccount.oamCustomer??>${oamAccount.oamCustomer.oamCustomerName!}</#if></td>
		<td>${oamAccount.loginNum!}</td>
		<td><#if !oamAccount.accountStatus??><#elseif "1"==oamAccount.accountStatus>是<#elseif "0"==oamAccount.accountStatus>否</#if></td>
	</tr>
	</#list>
</table>
<@common.pager page.pageBean "oamAccountsForm" "oamAccountsDiv"/>