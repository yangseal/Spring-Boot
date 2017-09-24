<!doctype html>
<html>
<head>
<#include "/head.ftl"/>
<script type="text/javascript" src="${rc.contextPath}/public/js/baseStation/provider/providerUser.js"></script>
</head>
<body>
<form id="providerUserForm" action="${rc.contextPath}/baseStation/provider/queryProviderUsers">
	<input type="hidden" id="baseProviderId" name="baseProvider.baseProviderId" value="${baseProviderId!}"/>
	<div class="form-inline grid-page-condition">
		<div class="form-group">
    		<label>联系人姓名</label>
    		<input type="text" class="form-control" id="proUserName" name="proUserName" />
  		</div>
	</div>

	<div class="command-div">
		<a class="btn btn-primary" onclick="refreshPage('providerUserForm','providerUserDiv',1);">
			<i class="glyphicon glyphicon-search"></i>
    		<span>查询</span>
		</a>

		<a class="btn btn-success" onclick="showProUser();">
			<i class="glyphicon glyphicon-plus"></i>
    		<span>新增</span>
		</a>
		<a class="btn btn-warning" onclick="editProUser();">
			<i class="glyphicon glyphicon-edit"></i>
    		<span>编辑</span>
		</a>
		<a class="btn btn-warning" onclick="delProUser();">
			<i class="glyphicon glyphicon-trash"></i>
    		<span>删除</span>
		</a>
	</div>
	<div id="providerUserDiv"></div>
</form>
</body>
</html>
