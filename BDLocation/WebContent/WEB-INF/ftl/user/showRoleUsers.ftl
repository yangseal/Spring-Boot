<!doctype html>
<html>
<head>
<#include "/head.ftl"/>
<script type="text/javascript" src="${rc.contextPath}/public/js/system/roleUsers.js"></script>
</head>
<body>
<form id="roleUsersForm" action="${rc.contextPath}/user/queryRoleUsers" >
	<div class="form-inline">
		<div class="form-group">
    		<label>姓名</label>
    		<input type="text" class="form-control" id="userName" name="userName">
  		</div>
  		<#if common.isSystemUser || common.isCntenUser>
		<div class="form-group has-feedback">
    		<label>所属企业</label>
    		<input id="company" type="text" name="company" class="form-control" style="cursor:pointer" onclick="selectCompany();" />
    		<span class="glyphicon glyphicon-menu-hamburger form-control-feedback"></span>
    		<input type="hidden" id="companyId" name="company.companyId" />
    		<input type="hidden" id="roleId" name="role.roleId" />
  		</div>
		</#if>
	</div>
	
	<div class="command-div">
		
		<a  class="btn btn-primary" onclick="refreshPage('roleUsersForm','roleUsersDiv',1);">
			<i class="glyphicon glyphicon-search"></i>
    		<span>查询</span>
		</a>
		<a  class="btn btn-info" onclick="viewUser();">
			<i class="glyphicon glyphicon-zoom-in"></i>
    		<span>查看</span>
		</a>
	</div>
	<div id="roleUsersDiv"></div>
</form>
</body>
</html>
