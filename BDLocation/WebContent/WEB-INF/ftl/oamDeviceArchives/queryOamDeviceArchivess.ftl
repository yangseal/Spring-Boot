<table id="oamDeviceArchivessTable" class="table">
	<tr>
		<th><input type="checkbox" onclick="checkAll(this);" /></th>
		<th>设备档案标识号</th>
		<th>设备档案名称</th>
		<th>绑定的基站账号</th>
		<th>创建日期</th>
	</tr>
	<#list page.result as oamDeviceArchives>
	<tr entityId="${oamDeviceArchives.oamDeviceArchivesId!}" onclick="selectEntity(this);">
		<td><input type="checkbox" /></td>
		<td>${oamDeviceArchives.oamDeviceArchivesCode!}</td>
		<td>${oamDeviceArchives.oamDeviceArchivesName!}</td>
		<td>${oamDeviceArchives.bindCorsAccount!}</td>
		<td>${oamDeviceArchives.createDate!}</td>
	</tr>
	</#list>
</table>
<@common.pager page.pageBean "oamDeviceArchivessForm" "oamDeviceArchivessDiv"/>