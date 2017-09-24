<table id="dictItemsTable" class="table">
	<tr>
		<th><input type="checkbox" onclick="javascript:checkAll(this);" /></th>
		<th>字典项名称</th>
		<th>字典项编号</th>
	</tr>
	<#list page.result as dictItem>
	<tr entityId="${dictItem.dictItemId!}" onclick="javascript:selectEntity(this);">
		<td><input type="checkbox" /></td>
		<td>${dictItem.dictItemName!}</td>
		<td>${dictItem.dictItemCode!}</td>
	</tr>
	</#list>
</table>
<@common.pager page.pageBean "dictItemsForm" "dictItemsDiv"/>

