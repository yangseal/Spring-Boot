<form id="rolesForm" action="${rc.contextPath}/role/selectRoles">
	<div>
		<span>角色名称</span>
		<input id="roleName" type="text" name="roleName" />
	</div>
	<div>
		<a  class="btn btn-primary" onclick="refreshPage('rolesForm','rolesDiv',1);">
			<i class="glyphicon glyphicon-search"></i>
    		<span>查询</span>
		</a>
		<a  class="btn btn-success" onclick="selectRoleOk();">
			<i class="glyphicon glyphicon-ok"></i>
    		<span>确定</span>
		</a>
		<a  class="btn btn-info" onclick="selectRoleClear();">
			<i class="glyphicon glyphicon-remove"></i>
    		<span>清空</span>
		</a>
	</div>
	<div id="rolesDiv"></div>
</form>
<script type="text/javascript">
	refreshPage("rolesForm","rolesDiv");
	function selectRoleOk(){
		var roleId = getSelectedEntityId("rolesTable");
		if(!roleId){
			myAlert("请选择角色");
			return;
		}
		$("#"+_fkFieldCode+"Id").val(roleId);
		$("#"+_fkFieldCode).val($("#rolesTable tr.active td:last").text());
		removeDialog();
	}
	function selectRoleClear(){
		$("#"+_fkFieldCode+"Id").val("");
		$("#"+_fkFieldCode).val("");
		removeDialog();
	}
</script>