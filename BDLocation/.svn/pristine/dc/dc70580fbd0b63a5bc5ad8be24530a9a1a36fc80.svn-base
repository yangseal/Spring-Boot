<table id="measureProjectsTable" class="table">
	<tr>
		<th>测量工程名称</th>
	</tr>
	<#list page.result as measureProject>
	<tr entityId="${measureProject.measureProjectId!}" onclick="selectEntity(this);">
		<td>${measureProject.measureProjectName!}</td>
	</tr>
	</#list>
</table>
<@common.pager page.pageBean "measureProjectsForm" "measureProjectsDiv"/>