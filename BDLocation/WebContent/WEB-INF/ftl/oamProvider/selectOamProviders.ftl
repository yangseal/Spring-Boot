<table id="oamProvidersTable" class="table">
	<tr>
		<th>供应商名称</th>
	</tr>
	<#list page.result as oamProvider>
	<tr entityId="${oamProvider.oamProviderId!}" onclick="selectEntity(this);">
		<td>${oamProvider.oamProviderName!}</td>
	</tr>
	</#list>
</table>
<@common.pager page.pageBean "oamProvidersForm" "oamProvidersDiv"/>