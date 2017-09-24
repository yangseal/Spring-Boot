<table id="BaseProvidersTable" class="table">
	<tr>
		<th>供应商名称</th>
	</tr>
	<#list page.result as baseProvider>
	<tr entityId="${baseProvider.baseProviderId!}" onclick="selectEntity(this);">
		<td>${baseProvider.providerName!}</td>
	</tr>
	</#list>
</table>
<@common.pager page.pageBean "baseProvidersForm" "baseProvidersDiv"/>