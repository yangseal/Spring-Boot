<div>
	<a  class="btn btn-success" onclick="selectDepartmentOk();">
		<i class="glyphicon glyphicon-ok"></i>
    	<span>确定</span>
	</a>
	<a  class="btn btn-info" onclick="selectDepartmentClear();">
		<i class="glyphicon glyphicon-remove"></i>
    	<span>清空</span>
	</a>
</div>
<table id="departmentsTable" class="table">
	<thead>
		<tr>
			<th>部门名称</th>
			<th>部门编号</th>
		</tr>
	</thead>
	<tbody>
		<#list departments as department>
		<tr id="${department.departmentId!}" entityId="${department.departmentId!}" <#if department.parentId??>pid="${department.parentId}"</#if> onclick="selectEntity(this);">
			<td style="text-align:left"><span>${department.departmentName!}</span></td>
			<td><span>${department.departmentCode!}</span></td>
		</tr>
		</#list>
	</tbody>
</table>
<script type="text/javascript">
	$("#departmentsTable").treeTable({theme:'vsStyle',expandLevel:1});
	function selectDepartmentOk(){
		var departmentId = getSelectedEntityId("departmentsTable");
		if(!departmentId){
			myAlert("请选择部门");
			return;
		}
		$("#"+_fkFieldCode+"Id").val(departmentId);
		$("#"+_fkFieldCode).val($("#departmentsTable tr.active td:last").text());
		removeDialog();
	}
	function selectDepartmentClear(){
		$("#"+_fkFieldCode+"Id").val("");
		$("#"+_fkFieldCode).val("");
		removeDialog();
	}
</script>
