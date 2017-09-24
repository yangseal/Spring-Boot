<table id="rolesTable" class="table">
	<tr>
		<th><input type="checkbox" onclick="javascript:checkAll(this);" /></th>
		<th>角色名称</th>
	</tr>
	<#list page.result as role>
	<tr entityId="${role.roleId!}" onclick="javascript:selectEntity(this);">
		<td><input type="checkbox" /></td>
		<td>${role.roleName!}</td>
	</tr>
	</#list>
</table>
<@common.pager page.pageBean "rolesForm" "rolesDiv"/>

