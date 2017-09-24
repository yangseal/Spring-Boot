<!doctype html>
<html>
<head>
<#include "/head.ftl"/>
<script type="text/javascript" src="${rc.contextPath}/public/js/department/departments.js"></script>
</head>
<body>
<a  class="btn btn-success" onclick="addDepartment();">
	<i class="glyphicon glyphicon-plus"></i>
	<span>新增一级部门</span>
</a>
<table id="departmentsTable" class="table">
	<thead>
		<tr>
			<th>部门名称</th>
			<th>部门编号</th>
			<th>操作</th>
		</tr>
	</thead>
	<tbody>
		<#list departments as department>
		<tr id="${department.departmentId!}" entityId="${department.departmentId!}" <#if department.parentId??>pid="${department.parentId}"</#if> onclick="selectEntity(this);">
			<td style="text-align:left"><span>${department.departmentName!}</span></td>
			<td><span>${department.departmentCode!}</span></td>
			<td>
				<div>
					<a onclick='addDepartment(this)' href='javascript:;' class="btn btn-success"><i class="glyphicon glyphicon-plus"></i></a>
					<a onclick='editDepartment(this)' href='javascript:;' class="btn btn-warning"><i class="glyphicon glyphicon-edit"></i></a>
					<a onclick='deleteDepartment(this)' href='javascript:;' class="btn btn-danger"><i class="glyphicon glyphicon-trash"></i></a>
				</div>
			</td>
		</tr>
		</#list>
	</tbody>
</table>
</body>
</html>
