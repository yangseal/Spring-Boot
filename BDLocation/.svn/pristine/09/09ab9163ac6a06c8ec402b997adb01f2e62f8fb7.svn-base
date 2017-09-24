<table id="corsAccountsTable" class="table">
	<tr>
		<th>CORS账号名称</th>
	</tr>
	<#list page.result as corsAccount>
	<tr entityId="${corsAccount.corsAccountId!}" onclick="selectEntity(this);">
		<td>${corsAccount.corsAccountName!}</td>
	</tr>
	</#list>
</table>
<@common.pager page.pageBean "corsAccountsForm" "corsAccountsDiv"/>