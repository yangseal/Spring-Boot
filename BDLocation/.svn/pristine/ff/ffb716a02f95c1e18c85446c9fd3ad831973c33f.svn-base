<table id="companysTable" class="table">
	<tr>
		<th>企业名称</th>
		<th>企业编号</th>
	</tr>
	<#list page.result as company>
	<tr entityId="${company.companyId!}" onclick="selectEntity(this);">
		<td>${company.companyName!}</td>
		<td>${company.companyCode!}</td>
	</tr>
	</#list>
</table>
<@common.pager page.pageBean "companysForm" "companysDiv"/>