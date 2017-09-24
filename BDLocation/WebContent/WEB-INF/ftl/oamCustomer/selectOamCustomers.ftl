<table id="oamCustomersTable" class="table">
	<tr>
		<th>客户名称</th>
	</tr>
	<#list page.result as oamCustomer>
	<tr entityId="${oamCustomer.oamCustomerId!}" onclick="selectEntity(this);">
		<td>${oamCustomer.oamCustomerName!}</td>
	</tr>
	</#list>
</table>
<@common.pager page.pageBean "oamCustomersForm" "oamCustomersDiv"/>