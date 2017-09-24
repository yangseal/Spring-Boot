<table id="oamProjectTestingsTable" class="table">
	<tr>
		<th><input type="checkbox" onclick="checkAll(this);" /></th>
		<th>所属项目</th>
		<th>项目测试名称</th>
		<th>测试日程描述</th>
		<th>初拟基建日程描述</th>
		<th>确定基建日程描述</th>
	</tr>
	<#list page.result as oamProjectTesting>
	<tr entityId="${oamProjectTesting.oamProjectTestingId!}" onclick="selectEntity(this);">
		<td><input type="checkbox" /></td>
		<td><#if oamProjectTesting.oamProject??>${oamProjectTesting.oamProject.oamProjectName!}</#if></td>
		<td>${oamProjectTesting.oamProjectTestingName!}</td>
		<td>${oamProjectTesting.testingSchedule!}</td>
		<td>${oamProjectTesting.planSchedule!}</td>
		<td>${oamProjectTesting.schedule!}</td>
	</tr>
	</#list>
</table>
<@common.pager page.pageBean "oamProjectTestingsForm" "oamProjectTestingsDiv"/>