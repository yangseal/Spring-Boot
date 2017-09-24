<table id="oamStationTestingsTable" class="table">
	<tr>
		<th>基站测试名称</th>
	</tr>
	<#list page.result as oamStationTesting>
	<tr entityId="${oamStationTesting.oamStationTestingId!}" onclick="selectEntity(this);">
		<td>${oamStationTesting.oamStationTestingName!}</td>
	</tr>
	</#list>
</table>
<@common.pager page.pageBean "oamStationTestingsForm" "oamStationTestingsDiv"/>