<table  class="table" width="100%" border="0" cellspacing="0" cellpadding="0" id="projectsTable">
	<tr>
		<th><input type="checkbox" onclick="checkAll(this);" /></th>
		<th>项目编号</th>
		<th>项目名称</th>
		<th>建站规模数量</th>
		<th>已完成数量</th>
		<th>立项时间</th>
		<th>结项时间</th>
		<th>所属服务合同</th>
		<th>基站信息</th>
		
	</tr>
	<#list page.result as project>
	<tr entityId="${project.baseProjectId!}" onclick="selectEntity(this);">
		<td><input type="checkbox" onclick="stopPropagation()"/></td>
		<td> <#if project.projectNo??>${project.projectNo}</#if></td>
		<td> <#if project.projectName??>${project.projectName}</#if></td>
		<td> <#if project.planNumber??>${project.planNumber}</#if></td>
		<td> <#if project.completeNumber??>${project.completeNumber}</#if></td>
		<td> <#if project.startDate??>${project.startDate}</#if></td>
		<td> <#if project.endDate??>${project.endDate}</#if></td>
		<td> <#if project.baseCustomerContract?? && project.baseCustomerContract.custContractName??>${project.baseCustomerContract.custContractName}</#if></td>
		<td><a style="cursor:pointer;text-decoration:none;margin-left:10px;" onclick="toStationByProjectId('${project.baseProjectId}')">基站信息</a></td>
	</tr>
	</#list>
</table>
<@common.pager page.pageBean "projectsForm" "projectsDiv"/>