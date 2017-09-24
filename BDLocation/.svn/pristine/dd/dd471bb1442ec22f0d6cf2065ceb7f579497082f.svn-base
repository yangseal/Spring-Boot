<table id="baseProjectsTable" class="table">
	<tr>
		<th>项目名称</th>
	</tr>
	<#list page.result as baseProject>
	<tr entityId="${baseProject.baseProjectId!}" onclick="selectEntity(this);">
		<td>${baseProject.projectName!}</td>
	</tr>
	</#list>
</table>
<@common.pager page.pageBean "baseProjectsForm" "baseProjectsDiv"/>