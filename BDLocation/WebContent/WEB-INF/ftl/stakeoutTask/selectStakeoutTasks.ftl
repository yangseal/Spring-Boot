<table id="stakeoutTasksTable" class="table">
	<tr>
		<th>点放样任务名称</th>
	</tr>
	<#list page.result as stakeoutTask>
	<tr entityId="${stakeoutTask.stakeoutTaskId!}" onclick="selectEntity(this);">
		<td>${stakeoutTask.stakeoutTaskName!}</td>
	</tr>
	</#list>
</table>
<@common.pager page.pageBean "stakeoutTasksForm" "stakeoutTasksDiv"/>