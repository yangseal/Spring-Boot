<table id="baseStationConstructsTable" class="table table-striped table-hover">
	<thead>
	<tr>
		<th><input type="checkbox" onclick="checkAll(this);" /></th>
<#--		<th>客户名称</th>
		<th>所属项目</th>  -->
		<th>基站名称</th>
		<th>基站编号</th>
		<th>建设阶段</th>
		<th>任务状态</th>
		<th width="140px;">操作</th>
	</tr>
	</thead>
	
	<tbody>
		<#list page.result as constuct>
			<tr entityId="${constuct.baseConstructId!}" sendDownState="${constuct.sendDownState!}" onclick="selectEntity(this);">
				<td><input datatr type="checkbox" onclick="stopPropagation()"/></td>
<#--				<td>${constuct.baseCustomer.customerName!}</td>
				<td>${constuct.baseProject.projectName!}</td>  -->
				<td>${constuct.stationName!}</td>
				<td>${constuct.stationNo!}</td>
				<td>${constuct.constructStageName!}</td>
				<td>${constuct.sendDownStateName!}</td>
				<td><a style="margin:0 10px;" onclick="baseStationDetail('${constuct.baseConstructId!}')">基站详情</a></td>
			</tr>
		</#list>
	</tbody>
</table>
<@common.pager page.pageBean "baseStationConstructForm" "baseStationConstructDiv"/>