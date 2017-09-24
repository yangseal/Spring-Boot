<table id="stakeoutPointsTable" class="table table-striped table-hover">
	<thead>
	<tr>
		<th><input type="checkbox" onclick="checkAll(this);" /></th>
		<th>点名称</th>
		<th>所属点类型</th>
		<th>高程</th>
		<th>经度</th>
		<th>纬度</th>
		<th>城建坐标X</th>
		<th>城建坐标Y</th>
		<th>创建日期</th>
		<th>所属放样任务</th>
	</tr>
	</thead>
	
	<tbody>
	<#list page.result as stakeoutPoint>
	<tr entityId="${stakeoutPoint.stakeoutPointId!}" onclick="selectEntity(this);">
		<td><input type="checkbox" /></td>
		<td>${stakeoutPoint.stakeoutPointName!}</td>
		<td><#if stakeoutPoint.affiliationPointType??>${stakeoutPoint.affiliationPointType.pointTypeName!}</#if></td>
		<td><#if stakeoutPoint.altitude??>${stakeoutPoint.altitude?c}</#if></td>
		<td><#if stakeoutPoint.longitude??>${stakeoutPoint.longitude?c}</#if></td>
		<td><#if stakeoutPoint.latitude??>${stakeoutPoint.latitude?c}</#if></td>
		<td><#if stakeoutPoint.coordinateX??>${stakeoutPoint.coordinateX?c}</#if></td>
		<td><#if stakeoutPoint.coordinateY??>${stakeoutPoint.coordinateY?c}</#if></td>
		<td>${stakeoutPoint.createDate!}</td>
		<td><#if stakeoutPoint.affiliationStakeoutTask??>${stakeoutPoint.affiliationStakeoutTask.stakeoutTaskName!}</#if></td>
	</tr>
	</#list>
	</tbody>
</table>
<@common.pager page.pageBean "stakeoutPointsForm" "stakeoutPointsDiv"/>