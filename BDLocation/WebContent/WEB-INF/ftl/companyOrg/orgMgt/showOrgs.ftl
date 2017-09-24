<!doctype html>
<html>
<head>
<#include "/head.ftl"/>
<link rel="stylesheet" href="${rc.contextPath}/public/js/lib/zTree_v3/css/metroStyle/metroStyle.css">
<script type="text/javascript" src="${rc.contextPath}/public/js/lib/zTree_v3/js/jquery.ztree.core.min.js"></script>
<script type="text/javascript" src="${rc.contextPath}/public/js/lib/zTree_v3/js/jquery.ztree.excheck.min.js"></script>
<script type="text/javascript" src="${rc.contextPath}/public/js/lib/zTree_v3/js/jquery.ztree.exhide.min.js"></script>
<script type="text/javascript" src="${rc.contextPath}/public/js/lib/zTree_v3/js/jquery.ztree.exedit.min.js"></script>
<script type="text/javascript" src="${rc.contextPath}/public/js/companyOrg/orgMgt/companyOrg.js"></script>
</head>
<body>
<form id="companyOrgForm" class="form-horizontal">
	<div class="form-group">
        <a  class="btn btn-success" onclick="saveCompanyMenu();">
			<i class="glyphicon glyphicon-save"></i>
			<span>保存</span>
		</a>
		<a  class="btn btn-primary" onclick="cancelSelect();">
			<i class="glyphicon glyphicon-ok"></i>
    		<span>取消</span>
		</a>
	</div>

	<div class="container-fluid">
	  <div class="row">	
		<div class="col-md-5 left form-inline">
		   <ul id="companyOrgTree" name="companyOrgTree" class="pull-left ztree"></ul>
		</div>
		
		<div class="col-md-5 right">
		   <!--<ul id="companyTree" name="companyTree" class="pull-left ztree"></ul> -->
		   <table id="rolesTable" class="table">
	<tr>
		<th>管理员名称</th>
		<th>管理员账号</th>
		<th>管理员密码</th>
		<th>操作</th>
		<a  class="btn btn-success" onclick="addCompanyAdmin();">
			<i class="glyphicon glyphicon-plus"></i>
		    <span>添加管理员</span>
		</a>
	</tr>
	
	<tr entityId="" id="companyAdminTemplate" style="display:none">
		<td owe="userName">密云分公司</td>
		<td owe="userCode">12121212</td>
		<td owe="userPwd">123456</td>
		<td><a style="text-decoration:none;cursor:pointer;" onclick="delAdmin(this)">删除</a></td>
	</tr>
	<tbody id="companyAdminTbody">
	
	</tbody>
	
</table>
		</div>
		
	  </div>
	</div>
			
</form>
</body>
</html>