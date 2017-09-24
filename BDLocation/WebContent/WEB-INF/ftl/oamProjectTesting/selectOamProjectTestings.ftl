<table id="oamProjectTestingsTable" class="table">
	<tr>
		<th>项目测试名称</th>
	</tr>
	<#list page.result as oamProjectTesting>
	<tr entityId="${oamProjectTesting.oamProjectTestingId!}" onclick="selectEntity(this);">
		<td>${oamProjectTesting.oamProjectTestingName!}</td>
	</tr>
	</#list>
</table>
<@common.pager page.pageBean "oamProjectTestingsForm" "oamProjectTestingsDiv"/>