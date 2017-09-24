<table id="pointTypesTable" class="table">
	<tr>
		<th>点类型名称</th>
	</tr>
	<#list page.result as pointType>
	<tr entityId="${pointType.pointTypeId!}" onclick="selectEntity(this);">
		<td>${pointType.pointTypeName!}</td>
	</tr>
	</#list>
</table>
<@common.pager page.pageBean "pointTypesForm" "pointTypesDiv"/>