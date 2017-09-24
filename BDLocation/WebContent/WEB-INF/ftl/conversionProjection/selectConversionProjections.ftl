<table id="conversionProjectionsTable" class="table">
	<tr>
		<th>转换投影名称</th>
	</tr>
	<#list page.result as conversionProjection>
	<tr entityId="${conversionProjection.conversionProjectionId!}" onclick="selectEntity(this);">
		<td>${conversionProjection.conversionProjectionName!}</td>
	</tr>
	</#list>
</table>
<@common.pager page.pageBean "conversionProjectionsForm" "conversionProjectionsDiv"/>