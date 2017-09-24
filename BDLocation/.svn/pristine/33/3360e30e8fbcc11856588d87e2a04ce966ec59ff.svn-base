<table id="oamStationConstructionsTable" class="table">
	<tr>
		<th>基站建设名称</th>
	</tr>
	<#list page.result as oamStationConstruction>
	<tr entityId="${oamStationConstruction.oamStationConstructionId!}" onclick="selectEntity(this);">
		<td>${oamStationConstruction.oamStationConstructionName!}</td>
	</tr>
	</#list>
</table>
<@common.pager page.pageBean "oamStationConstructionsForm" "oamStationConstructionsDiv"/>