<table id="stakeoutPointsTable" class="table">
	<tr>
		<th>放样点名称</th>
	</tr>
	<#list page.result as stakeoutPoint>
	<tr entityId="${stakeoutPoint.stakeoutPointId!}" onclick="selectEntity(this);">
		<td>${stakeoutPoint.stakeoutPointName!}</td>
	</tr>
	</#list>
</table>
<@common.pager page.pageBean "stakeoutPointsForm" "stakeoutPointsDiv"/>