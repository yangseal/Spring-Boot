<form id="passwordForm" class="form-horizontal">
	<div class="form-group">
		<label id="oldPasswordLabel" for="oldPassword" class="col-sm-2 control-label">旧密码</label>
		<div class="col-sm-7">
			<input type="text" class="form-control" id="oldPassword" name="oldPassword" isNotNull />
		</div>
		<label id="oldPasswordTip" class="control-label" style="color:red">*</label>
	</div>
	<div class="form-group">
		<label id="newPasswordLabel" for="newPassword" class="col-sm-2 control-label">新密码</label>
		<div class="col-sm-7">
			<input type="text" class="form-control" id="newPassword" name="newPassword" isNotNull />
		</div>
		<label id="newPasswordTip" class="control-label" style="color:red">*</label>
	</div>
	<div class="form-group">
		<label id="newPassword2Label" for="newPassword" class="col-sm-2 control-label">确认新密码</label>
		<div class="col-sm-7">
			<input type="text" class="form-control" id="newPassword2" name="newPassword2" isNotNull />
		</div>
		<label id="newPassword2Tip" class="control-label" style="color:red">*</label>
	</div>
</form>
<div style="text-align:center">
	<a  class="btn btn-success" onclick="updatePasswordOk();">
		<i class="glyphicon glyphicon-ok"></i>
		<span>确定</span>
	</a>
</div>
<script type="text/javascript">
	function updatePasswordOk(){
		if(!validateForm("passwordForm")){
			return;
		}
		var oldPassword = $("#oldPassword").val();
		var newPassword = $("#newPassword").val();
		var newPassword2 = $("#newPassword2").val();
		if(newPassword != newPassword2){
			myAlert("新密码两次输入不相同");
			return;
		}
		var url = CONTEXT_PATH + "/home/updatePassword";
		jQuery.post(url,{oldPassword:oldPassword,newPassword:newPassword},function(data){
			if(data.success){
				removeDialog();
				myAlert("密码修改成功");
			}else{
				myAlert(data.message);
			}
		});
	}
</script>