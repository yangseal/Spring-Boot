<form id="orgUserForm" class="form-horizontal">
	<div class="form-group">
		<label id="userNameLabel" for="userName" class="col-sm-3 control-label">管理员名称</label>
		<div class="col-sm-8">
			<input id="userName" name="userName" type="text" class="form-control"  maxslength="25:输入最大长度不能超过25个字符" value="<#if companyOrg??>${companyOrg.adminCode!}</#if>" isNotNull />
		</div>
		<label id="userNameTip" class="control-label" style="color:red">*</label>
	</div>
	<div class="form-group">
		<label id="userCodeLabel" for="userCode" class="col-sm-3 control-label">管理员账号</label>
		<div class="col-sm-8">
			<input id="userCode" name="userCode" type="text" class="form-control" unique="/companyTemp/verifyUserCode" maxslength="25:输入最大长度不能超过25个字符" value="<#if companyOrg??>${companyOrg.adminCode!}</#if>" isNotNull />
		</div>
		<label id="userCodeTip" class="control-label" style="color:red">*</label>
	</div>
	<div class="form-group">
		<label id="passwordLabel" for="password" class="col-sm-3 control-label">管理员密码</label>
		<div class="col-sm-8">
			<input id="password" name="password" type="text" class="form-control" maxslength="25:输入最大长度不能超过25个字符" value="<#if companyOrg??>${companyOrg.adminPwd!}<#else>123456</#if>" isNotNull/>
		</div>
		<label id="passwordTip" class="control-label" style="color:red">*</label>
	</div>
	<input type="hidden" id="companyOrgId" name="companyOrg.companyOrgId" value="${companyOrgId!}"/>
</form>
<div style="text-align:center">
	<a  class="btn btn-success" onclick="saveCompanyAdmin();">
		<i class="glyphicon glyphicon-save"></i>
		<span>保存</span>
	</a>
</div>
