<table id="baseContractsTable" class="table">
	<tr>
		<th>合同名称</th>
		<th>合同编号</th>
	</tr>
	<#list page.result as baseContract>
	<tr entityId="${baseContract.baseCustomerContractId!}" onclick="selectEntity(this);">
		<td>${baseContract.custContractName!}</td>
		<td>${baseContract.custContractNo!}</td>
	</tr>
	</#list>
</table>
<@common.pager page.pageBean "baseContractsForm" "baseContractsDiv"/>