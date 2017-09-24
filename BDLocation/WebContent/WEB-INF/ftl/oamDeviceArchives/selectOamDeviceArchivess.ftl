<table id="oamDeviceArchivessTable" class="table">
	<tr>
		<th>北斗设备档案名称</th>
	</tr>
	<#list page.result as oamDeviceArchives>
	<tr entityId="${oamDeviceArchives.oamDeviceArchivesId!}" onclick="selectEntity(this);">
		<td>${oamDeviceArchives.oamDeviceArchivesName!}</td>
	</tr>
	</#list>
</table>
<@common.pager page.pageBean "oamDeviceArchivessForm" "oamDeviceArchivessDiv"/>