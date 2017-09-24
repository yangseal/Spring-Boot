<form id="orgForm" class="form-horizontal">
	<div class="form-group">
		<label id="orgNameLabel" for="orgName" class="col-sm-3 control-label">子机构名称</label>
		<div class="col-sm-6">
			<input id="orgName" name="orgName" type="text" class="form-control" maxslength="25:输入最大长度不能超过25个字符" value="<#if companyOrg??>${companyOrg.orgName!}</#if>" isNotNull />
		</div>
		<label id="orgNameTip" class="control-label" style="color:red">*</label>
	</div>
	<input id="parentOrgId" name="parentOrgId" type="hidden" value="<#if companyOrg??>${companyOrg.parentOrgId!}<#else>${RequestParameters["parentOrgId"]!}</#if>" />
	<input id="companyOrgId" name="companyOrgId" type="hidden" value="<#if companyOrg??>${companyOrg.companyOrgId!}</#if>" />
	<input id="orgLevel" name="orgLevel" type="hidden" value="<#if companyOrg??>${companyOrg.orgLevel!}</#if>" />
</form>
<div style="text-align:center">
	<a  class="btn btn-success" onclick="saveOrg();">
		<i class="glyphicon glyphicon-save"></i>
		<span>保存</span>
	</a>
</div>
