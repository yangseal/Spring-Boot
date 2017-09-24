<table id="measurePointsTable" class="table table-striped table-hover">
	<thead>
	<tr>
		<th><input type="checkbox" onclick="checkAll(this);" /></th>
		<th>点名称</th>
		<th>点编码</th>
		<th>所属点类型</th>
		<th>描述</th>
		<th>解状态</th>
		<th>创建时间</th>
		<th>所属工程</th>
	</tr>
	</thead>
	
	<tbody>
	<#list page.result as measurePoint>
	<tr entityId="${measurePoint.measurePointId!}" onclick="selectEntity(this);">
		<td><input type="checkbox" /></td>
		<td>${measurePoint.measurePointName!}</td>
		<td>${measurePoint.measurePointCode!}</td>
		<td><#if measurePoint.affiliationPointType??>${measurePoint.affiliationPointType.pointTypeName!}</#if></td>
		<td>${measurePoint.pointDesc!}</td>
		<td><#if measurePoint.solutionState??> <#if "ST_INVALID_FIX"==measurePoint.solutionState>未定位<#elseif "ST_GPS_FIX"==measurePoint.solutionState>单点解<#elseif "ST_DGPS_FIX"==measurePoint.solutionState>差分解<#elseif "ST_FRTK_FIX"==measurePoint.solutionState>浮点解<#elseif "ST_RTK_FIX"==measurePoint.solutionState>固定解</#if></#if></td>
		<td>${measurePoint.createDate!}</td>
		<td><#if measurePoint.affiliationProject??>${measurePoint.affiliationProject.measureProjectName!}</#if></td>
	</tr>
	</#list>
	</tbody>
</table>
<@common.pager page.pageBean "measurePointsForm" "measurePointsDiv"/>