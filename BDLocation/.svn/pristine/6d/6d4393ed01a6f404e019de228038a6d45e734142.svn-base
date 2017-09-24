<table id="corsActivesTable" class="table">
	<tr>
		<th><input type="checkbox" onclick="checkAll(this);" /></th>
		<th>企业名称</th>
		<th>账号数量</th>
		<th>账户类型</th>
		<th>申请时间</th>
		<th>状态</th>
		<th>账号查看</th>
	</tr>
	<#list page.result as corsActive>
	<tr entityId="<#if corsActive.accountActiveType?? && corsActive.accountActiveType=='ACTIVE'>${corsActive.accountActiveId!}<#else>${corsActive.orderBussinkey!}</#if>" 
			corsAccountType="${corsActive.accountActiveType!}" onclick="selectEntity(this);">
		<td><input type="checkbox" onclick="stopPropagation()" /></td>
		<td><#if corsActive.company??>${corsActive.company.companyName!}</#if></td>
		<td><#if corsActive.accountActiveNum??>${corsActive.accountActiveNum!}</#if></td>
		<td><#if corsActive.corsAccountTypeName??>${corsActive.corsAccountTypeName!}</#if></td>
		<td><#if corsActive.accountActiveTime??>${corsActive.accountActiveTime!}</#if></td>
		<td><#if corsActive.accountActiveStateName??>${corsActive.accountActiveStateName!}</#if></td>
		<td><a href="javascript:void(0);" onclick="lookAccount(this);">查看</a></td>
	</tr>
	</#list>
</table>
<@common.pager page.pageBean "corsActivesForm" "corsActivesDiv"/>