<table width="100%" border="0" cellspacing="0" cellpadding="0" id="corsGroupsTable" class="table">
	<thead>
		<th width="30"><input type="checkbox" onclick="checkAll(this);" /></th>
		<th width="200">分组名称</th>
		<th width="100">账号配额</th>
		<th width="160">创建时间</th>
		<th width="*">备注</th>
		<th width="150">操作</th>
	</thead>
	<tbody>
		<#list page.result as corsGroup>
		<tr entityId="${corsGroup.companyGroupId!}" onclick="selectEntity(this);">
			<input type="hidden" value="${corsGroup.companyGroupId!}" id="company_group_id"/>
			<td><input type="checkbox" onclick="stopPropagation()" /></td>
			<td>${corsGroup.groupName!}</td>
			<td>${corsGroup.corsCount!}</td>
			<td>${corsGroup.groupCreateTime!}</td>
			<td>${corsGroup.remark!}</td>
			<td><a class="btn btn-primary" onclick="editGroup(this)">分组编辑</a><a class="btn btn-primary" onclick="corsListDetail(this)">配额编辑</a></td>
		</tr>
		</#list>
	</tbody>
</table>
<@common.frontPager page.pageBean "corsGroupsForm" "corsGroupsDiv"/>