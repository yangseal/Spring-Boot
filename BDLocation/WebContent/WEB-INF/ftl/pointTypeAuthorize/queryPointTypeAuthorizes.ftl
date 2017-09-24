<table id="pointTypeAuthorizesTable" class="table">
	<tr>
		<th><input type="checkbox" onclick="checkAll(this);" /></th>
		<th>所属点类型</th>
		<th>所属企业</th>
		<th>授权日期</th>
	</tr>
	<#list page.result as pointTypeAuthorize>
	<tr entityId="${pointTypeAuthorize.pointTypeAuthorizeId!}" onclick="selectEntity(this);">
		<td><input type="checkbox" /></td>
		<td><#if pointTypeAuthorize.affiliationPointType??>${pointTypeAuthorize.affiliationPointType.pointTypeName!}</#if></td>
		<td><#if pointTypeAuthorize.affiliationCompany??>${pointTypeAuthorize.affiliationCompany.companyName!}</#if></td>
		<td>${pointTypeAuthorize.authorizeDate!}</td>
	</tr>
	</#list>
</table>
<@common.pager page.pageBean "pointTypeAuthorizesForm" "pointTypeAuthorizesDiv"/>