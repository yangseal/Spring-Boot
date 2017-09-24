<table id="constructsTable" class="table table-striped table-hover">
	<thead>
	<tr>
		<th><input type="checkbox" onclick="checkAll(this);" /></th>
		<th>客户名称</th>
		<th>所属项目及详情</th>
		<th>基站名称</th>
		<th>基站编号</th>
		<th>建设阶段</th>
		<th width="120px;">建设详情</th>
		<th>任务状态</th>
		<th>操作</th>
	</tr>
	</thead>
	
	<tbody>
		<#list page.result as constuct>
			<tr entityId="${constuct.baseConstructId!}" onclick="selectEntity(this);">
				<td><input type="checkbox" onclick="stopPropagation()"/></td>
				<td>${constuct.baseCustomer.customerName!}</td>
				<td><a style="cursor:pointer;text-decoration:none;" onclick="showProjectDetail('${constuct.baseProject.baseProjectId!}')">${constuct.baseProject.projectName!}</a></td>
				<td>${constuct.stationName!}</td>
				<td>${constuct.stationNo!}</td>
				<td>${constuct.constructStageName!}</td>
				<td><a style="cursor:pointer;text-decoration:none;margin-left:10px;" onclick="editConstructBuildInfo('${constuct.baseConstructId!}'<#if constuct?? && constuct.checkState?? && (constuct.checkState=='TJYS'||constuct.checkState=='YYS')>,true</#if>)">资料完善</a></td>
				<td>${constuct.sendDownStateName!}</td>
				<td><a style="cursor:pointer;text-decoration:none;margin-left:10px;" onclick="baseStationDetail('${constuct.baseConstructId!}')">基站详情</a></td>
			</tr>
		</#list>
	</tbody>
</table>
<@common.pager page.pageBean "baseConstructForm" "baseConstructDiv"/>