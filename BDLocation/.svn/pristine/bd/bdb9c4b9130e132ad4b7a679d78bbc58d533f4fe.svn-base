<table id="companyTempsTable" class="table">
	<tr>
		<th>企业注册临时表名称</th>
	</tr>
	<#list page.result as companyTemp>
	<tr entityId="${companyTemp.companyTempId!}" onclick="selectEntity(this);">
		<td>${companyTemp.companyTempName!}</td>
	</tr>
	</#list>
</table>
<@common.pager page.pageBean "companyTempsForm" "companyTempsDiv"/>