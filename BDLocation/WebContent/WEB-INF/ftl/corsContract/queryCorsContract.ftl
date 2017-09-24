<table  class="table" width="100%" border="0" cellspacing="0" cellpadding="0" id="corsContractTable">
	<tr>
		<th><input type="checkbox" onclick="checkAll(this);"></th>
		<th>合同编号</th>
		<th>编号名称</th>
		<th>客户名称</th>
		<th>账号数量</th>
		<th>账号金额</th>
		<th>账号发票</th>
		<th>合同生效日期</th>
		<th>合同备注</th>
	</tr>
	
	<#list page.result as corsContract>
	<tr entityId="<#if corsContract.corsContractId??>${corsContract.corsContractId}</#if>" onclick="selectEntity(this);">
       	<td><input type="checkbox" onclick="stopPropagation()"></td>
		<td><#if corsContract.corsContractCode??>${corsContract.corsContractCode}</#if></td>
		<td><#if corsContract.corsContractName??>${corsContract.corsContractName}</#if></td>
		<td><#if corsContract.corsContractCusName??>${corsContract.corsContractCusName}</#if></td>
		<td><#if corsContract.corsContractNum??>${corsContract.corsContractNum}</#if></td>
		<td><#if corsContract.corsContractMoney??>${corsContract.corsContractMoney}</#if></td>
		<td><#if corsContract.corsContractBill??>${corsContract.corsContractBill}</#if></td>
		<td><#if corsContract.corsContractDate??>${corsContract.corsContractDate}</#if></td>
		<td><#if corsContract.corsContractComment??>${corsContract.corsContractComment}</#if></td>
	</tr>
	</#list>
</table>
<@common.pager page.pageBean "corsContractShowForm" "corsContractShowDiv"/>