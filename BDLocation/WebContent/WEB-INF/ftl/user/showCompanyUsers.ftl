<!doctype html>
<html>
<head>
<#include "/head.ftl"/>
<script type="text/javascript" src="${rc.contextPath}/public/js/system/users.js"></script>
</head>
<body>
<form id="usersForm" action="${rc.contextPath}/user/queryUsers" >
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
		<a  class="btn btn-info" onclick="viewUser();">
			<i class="glyphicon glyphicon-zoom-in"></i>
    		<span>查看</span>
		</a>
		<a class="btn btn-success" onclick="showUser();">
			<i class="glyphicon glyphicon-plus"></i>
    		<span>注册</span>
		</a>
	</div>
	<div id="usersDiv"></div>
</form>
</body>
</html>
