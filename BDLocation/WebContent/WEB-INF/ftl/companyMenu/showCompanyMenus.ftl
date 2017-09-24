<!doctype html>
<html>
<head>
<#include "/head.ftl"/>
<link rel="stylesheet" href="${rc.contextPath}/public/js/lib/zTree_v3/css/metroStyle/metroStyle.css">
<script type="text/javascript" src="${rc.contextPath}/public/js/lib/zTree_v3/js/jquery.ztree.core.min.js"></script>
<script type="text/javascript" src="${rc.contextPath}/public/js/lib/zTree_v3/js/jquery.ztree.excheck.min.js"></script>
<script type="text/javascript" src="${rc.contextPath}/public/js/lib/zTree_v3/js/jquery.ztree.exhide.min.js"></script>
<script type="text/javascript" src="${rc.contextPath}/public/js/companyMenu/companyMenu.js"></script>
</head>
<body>
<form id="companyMenuForm" class="form-horizontal">
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
	    <div class="col-md-5 left">
		   <ul id="companyTree" name="companyTree" class="pull-left ztree"></ul>
		</div>
		<div class="col-md-5 right form-inline">
			<div class="form-group has-feedback">
				<label>筛选</label>
				<input type="text" class="form-control" id="menuTreeName" name="MenuTreeName" placeholder="菜单关键字" >
	  			<span class="glyphicon glyphicon glyphicon-search form-control-feedback"></span>
	  			<div style="display:block;">
		  			<p>父子关联关系：<br/>
					勾选：<input type="checkbox" id="py" class="checkbox first" checked /><span>关联父</span>
					<input type="checkbox" id="sy" class="checkbox first" checked /><span>关联子</span><br/>
					取消勾选：<input type="checkbox" id="pn" class="checkbox first" /><span>关联父</span>
					<input type="checkbox" id="sn" class="checkbox first" checked /><span>关联子</span><br/>
				</div>
	  		</div>
		   <ul id="menuTree" name="menuTree" class="pull-left ztree"></ul>
		</div>
		
	  </div>
	</div>
			
</form>
</body>
</html>