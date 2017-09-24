<table id="proContractTable" class="table">
	<tr>
		<th><input type="checkbox" onclick="checkAll(this);" /></th>
		<th>合同编号</th>
		<th>合同名称</th>
		<th>签订日期</th>
		<th>合同甲方</th>
		<th>合同乙方</th>
		<th>签订地点</th>
		<th>所属供应商</th>
		<th>所属项目</th>
	</tr>
	<#list page.result as proContract>
	<tr entityId="${proContract.baseProContractId!}" onclick="selectEntity(this);">
		<td><input type="checkbox" onclick="stopPropagation()"/></td>
		<td><#if proContract.proContractNo??>${proContract.proContractNo!}</#if></td>
		<td><#if proContract.proContractName??>${proContract.proContractName!}</#if></td>
		<td><#if proContract.proContractDate??>${proContract.proContractDate!}</#if></td>
		<td><#if proContract.proContractPartya??>${proContract.proContractPartya!}</#if></td>
		<td><#if proContract.proContractPartyb??>${proContract.proContractPartyb!}</#if></td>
		<td><#if proContract.proContractAddress??>${proContract.proContractAddress!}</#if></td>
		<td><#if proContract.baseProvider??>${proContract.baseProvider.providerName!}</#if></td>
		<td><#if proContract.baseProject??>${proContract.baseProject.projectName!}</#if></td>
	</tr>
	</#list>
</table>
<@common.pager page.pageBean "proContractForm" "proContractDiv"/>