<table id="conversionProjectionsTable" class="table">
	<tr>
		<th><input type="checkbox" onclick="checkAll(this);" /></th>
		<th>转换投影名称</th>
		<th>转换投影编码</th>
		<th>投影类型</th>
		<th>中央子午线</th>
		<th>尺度</th>
		<th>x常数</th>
		<th>y常数</th>
		<th>基准纬度</th>
		<th>投影高程</th>
		<th>投影平均纬</th>
	</tr>
	<#list page.result as conversionProjection>
	<tr entityId="${conversionProjection.conversionProjectionId!}" onclick="selectEntity(this);">
		<td><input type="checkbox" /></td>
		<td>${conversionProjection.conversionProjectionName!}</td>
		<td>${conversionProjection.conversionProjectionCode!}</td>
		<td>${conversionProjection.projectType!}</td>
		<td>${conversionProjection.meridian!}</td>
		<td>${conversionProjection.k!}</td>
		<td>${conversionProjection.x!}</td>
		<td>${conversionProjection.y!}</td>
		<td>${conversionProjection.standerdLat!}</td>
		<td>${conversionProjection.h!}</td>
		<td>${conversionProjection.averageLat!}</td>
	</tr>
	</#list>
</table>
<@common.pager page.pageBean "conversionProjectionsForm" "conversionProjectionsDiv"/>