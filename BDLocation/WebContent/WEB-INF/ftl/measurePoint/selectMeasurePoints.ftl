<table id="measurePointsTable" class="table">
	<tr>
		<th>测量点名称</th>
	</tr>
	<#list page.result as measurePoint>
	<tr entityId="${measurePoint.measurePointId!}" onclick="selectEntity(this);">
		<td>${measurePoint.measurePointName!}</td>
	</tr>
	</#list>
</table>
<@common.pager page.pageBean "measurePointsForm" "measurePointsDiv"/>