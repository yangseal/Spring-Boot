<table id="measureProjectsTable" class="table table-striped table-hover">
	<thead>
	<tr>
		<th><input type="checkbox" onclick="checkAll(this);" /></th>
		<th>工程名称</th>
		<th>作业人员</th>
		<th>数据采集模板</th>
		<th>坐标系统</th>
		<th>创建时间</th>
		<th>所属企业</th>
		<th>创建用户</th>
	</tr>
	</thead>
	
	<tbody>
	<#list page.result as measureProject>
	<tr entityId="${measureProject.measureProjectId!}" onclick="selectEntity(this);">
		<td><input type="checkbox" onclick="stopPropagation()"/></td>
		<td>${measureProject.measureProjectName!}</td>
		<td>${measureProject.measureUser!}</td>
		<td><#if "point"==measureProject.collectTpl>默认点.gdd<#elseif "pointOrLineOrPlane"==measureProject.collectTpl>默认点线面.gdd</#if></td>
		<td><#if "WGS84"==measureProject.coordinate>WGS84.sys<#elseif "beijing54"==measureProject.coordinate>beijing54-144.sys</#if></td>
		<td>${measureProject.createDate!}</td>
		<td><#if measureProject.affiliationCompany??>${measureProject.affiliationCompany.companyName!}</#if></td>
		<td><#if measureProject.createUser??>${measureProject.createUser.userName!}</#if></td>
	</tr>
	</#list>
	</tbody>
</table>
<@common.pager page.pageBean "measureProjectsForm" "measureProjectsDiv"/>