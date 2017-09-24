<form id="departmentForm" class="form-horizontal">
	<div class="form-group">
		<label id="departmentNameLabel" for="departmentName" class="col-sm-2 control-label">部门名称</label>
		<div class="col-sm-7">
			<input type="text" class="form-control" id="departmentName" name="departmentName" value="<#if department??>${department.departmentName!}</#if>" />
		</div>
		<label id="departmentNameTip" class="control-label" style="color:red"></label>
	</div>
	<div class="form-group">
		<label id="departmentCodeLabel" for="departmentCode" class="col-sm-2 control-label">部门编号</label>
		<div class="col-sm-7">
			<input type="text" class="form-control" id="departmentCode" name="departmentCode" value="<#if department??>${department.departmentCode!}</#if>" />
		</div>
		<label id="departmentCodeTip" class="control-label" style="color:red"></label>
	</div>
	<input type="hidden" id="parentId" name="parentId" value="<#if department??>${department.parentId!}<#else>${RequestParameters["parentId"]!}</#if>" />
	<input type="hidden" id="departmentId" name="departmentId" value="<#if department??>${department.departmentId!}</#if>" />
</form>
<div style="text-align:center">
	<a  class="btn btn-success" onclick="saveDepartment();">
		<i class="glyphicon glyphicon-save"></i>
		<span>保存</span>
	</a>
</div>
