<table id="companyTempsTable" class="table">
	<tr>
		<th><input type="checkbox" onclick="checkAll(this);" /></th>
		<th>企业名称</th>
		<th>企业地址</th>
		<th>企业电话</th>
		<th>联系人名称</th>
		<th>联系人职务</th>
		<th>联系人电话</th>
		<th>联系人邮箱</th>
		<th>审批状态</th>
	</tr>
	<#list page.result as companyTemp>
	<tr entityId="${companyTemp.companyTempId!}" entityStatus='<#if companyTemp.status?? && "1"==companyTemp.status>true<#else>false</#if>' onclick="selectEntity(this);">
		<td><input type="checkbox" /></td>
		<td>${companyTemp.companyTempName!}</td>
		<td>${companyTemp.address!}</td>
		<td>${companyTemp.tel!}</td>
		<td>${companyTemp.contacts!}</td>
		<td>${companyTemp.post!}</td>
		<td>${companyTemp.phone!}</td>
		<td>${companyTemp.email!}</td>
		<td><#if !companyTemp.status?? || companyTemp.status?length = 0>审核中<#elseif "1"==companyTemp.status>已通过<#elseif "0"==companyTemp.status>已拒绝</#if></td>
	</tr>
	</#list>
</table>
<@common.pager page.pageBean "companyTempsForm" "companyTempsDiv"/>