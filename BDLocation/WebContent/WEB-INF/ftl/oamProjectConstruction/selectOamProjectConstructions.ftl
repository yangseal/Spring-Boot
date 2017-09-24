<table id="oamProjectConstructionsTable" class="table">
	<tr>
		<th>项目建设名称</th>
	</tr>
	<#list page.result as oamProjectConstruction>
	<tr entityId="${oamProjectConstruction.oamProjectConstructionId!}" onclick="selectEntity(this);">
		<td>${oamProjectConstruction.oamProjectConstructionName!}</td>
	</tr>
	</#list>
</table>
<@common.pager page.pageBean "oamProjectConstructionsForm" "oamProjectConstructionsDiv"/>