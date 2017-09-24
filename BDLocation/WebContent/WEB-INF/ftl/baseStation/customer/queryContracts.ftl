<table  class="table" width="100%" border="0" cellspacing="0" cellpadding="0" id="contractsTable">
	<tr>
		<th><input type="checkbox" onclick="checkAll(this);"></th>
		<th>合同编号</th>
		<th>合同名称</th>
		<th>合同类型</th>
		<th>签订日期</th>
		<th>合同甲方</th>
		<th>合同乙方</th>
		<th>签订地点</th>
	</tr>
	<#list page.result as contract>
	<tr entityId="<#if contract.baseCustomerContractId??>${contract.baseCustomerContractId}</#if>" onclick="selectEntity(this);">
       	<td><input type="checkbox" onclick="stopPropagation()"/></td>
		<td><#if contract.custContractNo??> ${contract.custContractNo} </#if> </td>
		<td><#if contract.custContractName??> ${contract.custContractName} </#if> </td>
		<td><#if contract.custContractType??> ${contract.custContractType} </#if> </td>
		<td><#if contract.custContractDate??> ${contract.custContractDate} </#if> </td>
		<td><#if contract.custContractPartya??> ${contract.custContractPartya} </#if> </td>
		<td><#if contract.custContractPartyb??> ${contract.custContractPartyb} </#if> </td>
		<td><#if contract.custContractAddress??> ${contract.custContractAddress} </#if> </td>
		
	<tr>
	</#list>
</table>
<@common.pager page.pageBean "contractsForm" "contractsDiv"/>