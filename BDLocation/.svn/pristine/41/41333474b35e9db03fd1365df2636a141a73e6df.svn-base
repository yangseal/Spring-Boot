<form id="usersForm" action="${rc.contextPath}/user/selectUsers">
	<div class="form-inline">
		<div class="form-group">
    		<label>姓名</label>
    		<input type="text" class="form-control" id="userName" name="userName">
  		</div>
	</div>
	<div class="command-div">
		<a  class="btn btn-primary" onclick="refreshPage('usersForm','usersDiv',1);">
			<i class="glyphicon glyphicon-search"></i>
    		<span>查询</span>
		</a>
		<a  class="btn btn-success" onclick="selectUserOk(this);">
			<i class="glyphicon glyphicon-ok"></i>
    		<span>确定</span>
		</a>
		<a  class="btn btn-info" onclick="selectUserClear(this);">
			<i class="glyphicon glyphicon-remove"></i>
    		<span>清空</span>
		</a>
	</div>
	<div id="usersDiv"></div>
</form>
<script type="text/javascript">
	refreshPage("usersForm","usersDiv");
	function selectUserOk(sender){
		var userId = getSelectedEntityId("usersTable");
		if(!userId){
			myAlert("请选择用户");
			return;
		}
		var fk;
		var fkFieldCode = $(sender).closest("div[fkFieldCode]").attr("fkFieldCode");
		if(fkFieldCode){
			fk = fkFieldCode;
		}else{
			fk = _fkFieldCode;
		}
		$("#"+fk+"Id").val(userId);
		$("#"+fk).val($("#usersTable tr.active td:first").text());
		if(fkFieldCode){
			dialog.get(fkFieldCode).remove();
		}else{
			removeDialog();
		}
	}
	function selectUserClear(sender){
		var fk;
		var fkFieldCode = $(sender).closest("div[fkFieldCode]").attr("fkFieldCode");
		if(fkFieldCode){
			fk = fkFieldCode;
		}else{
			fk = _fkFieldCode;
		}
		$("#"+fk+"Id").val("");
		$("#"+fk).val("");
		if(fkFieldCode){
			dialog.get(fkFieldCode).remove();
		}else{
			removeDialog();
		}
	}
</script>
