<!doctype html>
<html>
<head>
<#include "/head.ftl"/>
<link rel="stylesheet" href="${rc.contextPath}/public/js/lib/zTree_v3/css/metroStyle/metroStyle.css">
<script type="text/javascript" src="${rc.contextPath}/public/js/lib/zTree_v3/js/jquery.ztree.core.min.js"></script>
<script type="text/javascript" src="${rc.contextPath}/public/js/lib/zTree_v3/js/jquery.ztree.excheck.min.js"></script>
<script type="text/javascript" src="${rc.contextPath}/public/js/lib/zTree_v3/js/jquery.ztree.exhide.min.js"></script>
<script type="text/javascript" src="${rc.contextPath}/public/js/system/roleUser.js"></script>
</head>
<body>
<form id="roleUserForm" class="form-horizontal">
	<div class="form-group">
        <a  class="btn btn-success" onclick="saveRoleUser();">
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
		<div class="col-md-4 left form-inline">
	  		<div class="form-group has-feedback">
	    		<label>筛选</label>
				<input type="text" class="form-control" id="roleTreeName" name="roleTreeName" placeholder="角色名关键字" >
	    		<span class="glyphicon glyphicon glyphicon-search form-control-feedback"></span>
  			</div>
		   <ul id="roleTree" name="roleTree" class="pull-left ztree"></ul>
		</div>
		<div class="col-md-4 right form-inline">
	    	<div class="form-group has-feedback">
				<label>筛选</label>
				<input type="text" class="form-control" id="userTreeName" name="userTreeName" placeholder="用户名关键字" >
	  			<span class="glyphicon glyphicon glyphicon-search form-control-feedback"></span>
	  		</div>
		   <ul id="userTree" name="userTree" class="pull-left ztree"></ul>
		</div>
	  </div>
	</div>
			
</form>
</body>
</html>