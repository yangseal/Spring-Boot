<!doctype html>
<html>
<head>
<#include "/head.ftl"/>
<script type="text/javascript" src="${rc.contextPath}/public/js/accountView/accountView.js"></script>
</head>
<body>
<form id="accountViewsForm" action="${rc.contextPath}/accountView/queryAccountViews">
	<input type="hidden" id="companyId" name="company.companyId" value="<#if corsAccount?? && corsAccount.company??>${corsAccount.company.companyId!}<#elseif RequestParameters["companyId"]??>${RequestParameters["companyId"]!}<#elseif !corsApply??>${CURRENT_USER.company.companyId}</#if>" />
	<input type="hidden" id="userId" name="user.userId" value="<#if corsApply?? && corsAccount.user??>${corsAccount.user.userId!}<#elseif RequestParameters["userId"]??>${RequestParameters["userId"]!}<#elseif !corsAccount??>${CURRENT_USER.userId}</#if>" />

	<div class="form-inline grid-page-condition">
		<div class="form-group has-feedback">
    		<label>账号状态：</label>
    		<select class="form-control" id="corsAccountState" name="corsAccountState" >
				<option></option>
				<option value="normal">正常</option>
				<option value="expired">过期</option>
				<option value="unactive">未激活</option>
				<option value="soon">即将过期</option>
			</select>
  		</div>
	</div>
	<div class="grid-page-command">
		<a  class="btn btn-primary" onclick="refreshPage('accountViewsForm','accountViewsDiv',1);">
			<i class="glyphicon glyphicon-search"></i>
    		<span>查询</span>
		</a>

	</div>
	<div id="accountViewsDiv"></div>
</form>
</body>
</html>
