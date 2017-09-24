<table id="oamBaseStationsTable" class="table">
	<tr>
		<th>基站名称</th>
	</tr>
	<#list page.result as oamBaseStation>
	<tr entityId="${oamBaseStation.oamBaseStationId!}" onclick="selectEntity(this);">
		<td>${oamBaseStation.oamBaseStationName!}</td>
	</tr>
	</#list>
</table>
<@common.pager page.pageBean "oamBaseStationsForm" "oamBaseStationsDiv"/>