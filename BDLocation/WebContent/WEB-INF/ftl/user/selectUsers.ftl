<table id="usersTable" class="table">
	<tr>
		<th>姓名</th>
		<th>用户名</th>
	</tr>
	<#list page.result as user>
	<tr entityId="${user.userId!}" onclick="javascript:selectEntity(this);">
		<td>${user.userName!}</td>
		<td>${user.userCode!}</td>
	</tr>
	</#list>
</table>
<@common.pager page.pageBean "usersForm" "usersDiv"/>

