<table id="baseCustomersTable" class="table">
	<tr>
		<th>客户名称</th>
	</tr>
	<#list page.result as baseCustomer>
	<tr entityId="${baseCustomer.baseCustomerId!}" onclick="selectEntity(this);">
		<td>${baseCustomer.customerName!}</td>
	</tr>
	</#list>
</table>
<@common.pager page.pageBean "baseCustomersForm" "baseCustomersDiv"/>