<table id="oamProvidersTable" class="table">
	<tr>
		<th><input type="checkbox" onclick="checkAll(this);" /></th>
		<th>供应商名称</th>
		<th>主营业务</th>
		<th>联系方式</th>
	</tr>
	<#list page.result as oamProvider>
	<tr entityId="${oamProvider.oamProviderId!}" onclick="selectEntity(this);">
		<td><input type="checkbox" /></td>
		<td>${oamProvider.oamProviderName!}</td>
		<td>${oamProvider.products!}</td>
		<td>${oamProvider.contact!}</td>
	</tr>
	</#list>
</table>
<@common.pager page.pageBean "oamProvidersForm" "oamProvidersDiv"/>