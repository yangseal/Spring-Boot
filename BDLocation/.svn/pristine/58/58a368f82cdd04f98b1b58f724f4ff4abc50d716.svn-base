<!doctype html>
<html>
<head>
<#include "/head.ftl"/>
<script type="text/javascript" src="${rc.contextPath}/public/js/system/role.js"></script>
</head>
<body>
<#if RequestParameters["isQuery"]??>
<ul class="nav nav-tabs" role="tablist">
    <li role="presentation" class="active"><a href="#basicTab" aria-controls="basicTab" role="tab" data-toggle="tab">基础信息</a></li>
    <li role="presentation"><a href="#usersTab" aria-controls="usersTab" role="tab" data-toggle="tab">用户列表</a></li>
</ul>
<div class="tab-content">
    <div role="tabpanel" class="tab-pane active" id="basicTab">
</#if>
    
<form id="roleForm" class="form-horizontal">
	<div class="form-group bh_user_add">
		<label id="roleNameLabel" for="roleName" class="col-sm-2 control-label">角色名称</label>
		<div class="col-sm-7">
      		<input type="text" class="form-control" id="roleName" name="roleName" value="<#if role??>${role.roleName!}</#if>" isNotNull />
      	</div>
      	<label id="roleNameTip" class="control-label" style="color:red">*</label>
	</div>
	<input type="hidden" id="roleId" name="roleId" value="<#if role??>${role.roleId!}</#if>" />
</form>
<#if !RequestParameters["isQuery"]??>
<div style="text-align:center" class="bh_user_bt">
	<a  class="btn btn-success" onclick="saveRole();">
		<i class="glyphicon glyphicon-save"></i>
    	<span>保存</span>
	</a>
	<a  class="btn btn-primary" onclick="javascript:;">
		<i class="glyphicon glyphicon-ok"></i>
    	<span>其它</span>
	</a>
</div>
</#if>
    
<#if RequestParameters["isQuery"]??>
	</div>
<div role="tabpanel" class="tab-pane" id="usersTab">
   	<iframe code="roleUsers" frameborder=0 width="100%" src="${rc.contextPath}/user/showRoleUsers?${rc.queryString!}" />
</div>
</div>
</#if>
</body>
</html>
