<table id="oamProjectsTable" class="table">
	<tr>
		<th>项目名称</th>
	</tr>
	<#list page.result as oamProject>
	<tr entityId="${oamProject.oamProjectId!}" onclick="selectEntity(this);">
		<td>${oamProject.oamProjectName!}</td>
	</tr>
	</#list>
</table>
<@common.pager page.pageBean "oamProjectsForm" "oamProjectsDiv"/>