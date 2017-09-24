<table id="oamAccountsTable" class="table">
	<tr>
		<th>账号名称</th>
	</tr>
	<#list page.result as oamAccount>
	<tr entityId="${oamAccount.oamAccountId!}" onclick="selectEntity(this);">
		<td>${oamAccount.oamAccountName!}</td>
	</tr>
	</#list>
</table>
<@common.pager page.pageBean "oamAccountsForm" "oamAccountsDiv"/>