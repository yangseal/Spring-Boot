<table id="dictItemsTable" class="table">
	<tr>
		<th>字典项名称</th>
	</tr>
	<#list page.result as dictItem>
	<tr entityId="${dictItem.dictItemId!}" onclick="javascript:selectEntity(this);">
		<td>${dictItem.dictItemName!}</td>
	</tr>
	</#list>
</table>
<@common.pager page.pageBean "dictItemsForm" "dictItemsDiv"/>

