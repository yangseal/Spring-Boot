<table id="stakeoutTasksTable" class="table table-striped table-hover">
	<thead>
	<tr>
		<th><input type="checkbox" onclick="checkAll(this);" /></th>
		<th>任务名称</th>
		<th>任务类型</th>
		<th>任务状态</th>
		<th>创建时间</th>
		<th>创建人</th>
		<th>所属企业</th>
	</tr>
	</thead>
	
	<tbody>
	<#list page.result as stakeoutTask>
	<tr entityId="${stakeoutTask.stakeoutTaskId!}" onclick="selectEntity(this);">
		<td><input type="checkbox" /></td>
		<td>${stakeoutTask.stakeoutTaskName!}</td>
		<td><#if "point"==stakeoutTask.taskType>点<#elseif "line"==stakeoutTask.taskType>线</#if></td>
		<td><#if stakeoutTask.taskStatus??><#if "newTask"==stakeoutTask.taskStatus>新任务<#elseif "issued"==stakeoutTask.taskStatus>已下发</#if></#if></td>
		<td>${stakeoutTask.createDate!}</td>
		<td><#if stakeoutTask.createUser??>${stakeoutTask.createUser.userName!}</#if></td>
		<td><#if stakeoutTask.affiliationCompany??>${stakeoutTask.affiliationCompany.companyName!}</#if></td>
	</tr>
	</#list>
	</tbody>
</table>
<@common.pager page.pageBean "stakeoutTasksForm" "stakeoutTasksDiv"/>