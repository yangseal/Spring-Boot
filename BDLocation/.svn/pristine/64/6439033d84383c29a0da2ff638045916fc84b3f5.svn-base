<table id="pointTypeAuthorizesTable" class="table">
	<tr>
		<th>点类型授权名称</th>
	</tr>
	<#list page.result as pointTypeAuthorize>
	<tr entityId="${pointTypeAuthorize.pointTypeAuthorizeId!}" onclick="selectEntity(this);">
		<td>${pointTypeAuthorize.pointTypeAuthorizeName!}</td>
	</tr>
	</#list>
</table>
<@common.pager page.pageBean "pointTypeAuthorizesForm" "pointTypeAuthorizesDiv"/>