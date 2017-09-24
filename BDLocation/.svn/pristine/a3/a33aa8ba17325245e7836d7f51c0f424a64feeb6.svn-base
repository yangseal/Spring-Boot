<table id="dictsTable" class="table">
	<tr>
		<th><input type="checkbox" onclick="javascript:checkAll(this);" /></th>
		<th>字典名称</th>
		<th>字典编号</th>
	</tr>
	<#list page.result as dict>
	<tr entityId="${dict.dictId!}" onclick="javascript:selectEntity(this);">
		<td><input type="checkbox" /></td>
		<td>${dict.dictName!}</td>
		<td>${dict.dictCode!}</td>
	</tr>
	</#list>
</table>
<@common.pager page.pageBean "dictsForm" "dictsDiv"/>

