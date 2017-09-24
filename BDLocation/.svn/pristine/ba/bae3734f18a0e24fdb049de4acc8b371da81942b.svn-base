<!doctype html>
<html>
<head>
<#include "/head.ftl"/>
<script type="text/javascript" src="${rc.contextPath}/public/js/corsgroup/corsGroup.js"></script>
</head>
<body>
<form id="corsGroupsForm" action="${rc.contextPath}/corsgroup/queryGroups">
	<div class="form-inline grid-page-condition">
		<#if common.isSystemUser || common.isCntenUser>
		<div class="form-group has-feedback">
			<#if !RequestParameters["groupName"]?? || RequestParameters["groupName"]=="">
			<label>分组名称：</label>
    		<input type="text" class="form-control" style="width:200px" id="groupName" name="groupName"/>
    		<input type="hidden" id="company_id" name="company.companyId" value="<#if CURRENT_USER?? && CURRENT_USER.company??>${CURRENT_USER.company.companyId!}</#if>"/>
			</#if>
		</div>
		</#if>
	</div>
	<div class="grid-page-command">
		<a  class="btn btn-primary" onclick="refreshPage('corsGroupsForm','corsGroupsDiv',1);">
			<i class="glyphicon glyphicon-search"></i>
    		<span>查询</span>
		</a>
		<a  class="btn btn-primary" onclick="addGroup(this)">
			<i class="glyphicon glyphicon-edit"></i>
    		<span>创建分组</span>
		</a>
		<a  class="btn btn-primary" onclick="corsDivide(this)">
			<i class="glyphicon glyphicon-edit"></i>
    		<span>划分账号</span>
		</a>
	</div>
	<div id="corsGroupsDiv"></div>
</form>
</body>
</html>
