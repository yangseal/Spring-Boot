<table id="companysTable" class="table table-striped table-hover">
	<thead>
	<tr>
		<th><input type="checkbox" onclick="checkAll(this);" /></th>
		<th>企业名称</th>
		<th>企业编号</th>
		<th>企业地址</th>
		<th>企业电话</th>
		<th>联系人名称</th>
		<th>联系人职务</th>
		<th>联系人电话</th>
		<th>资料审核状态</th>
	</tr>
	</thead>
	
	<tbody>
	<#list page.result as company>
	<tr entityId="${company.companyId!}" onclick="selectEntity(this);">
		<td><input type="checkbox" /></td>
		<td>${company.companyName!}</td>
		<td>${company.companyCode!}</td>
		<td>${company.address!}</td>
		<td>${company.tel!}</td>
		<td>${company.contacts!}</td>
		<td>${company.post!}</td>
		<td>${company.phone!}</td>
		<td><#if !company.companyMaterialState?? || company.companyMaterialState?length = 0>未审核<#elseif "1"==company.companyMaterialState>审核中<#elseif "2"==company.companyMaterialState>已通过<#elseif "3"==company.companyMaterialState>已拒绝</#if></td>
	</tr>
	</#list>
	</tbody>
</table>
<@common.pager page.pageBean "companysForm" "companysDiv"/>