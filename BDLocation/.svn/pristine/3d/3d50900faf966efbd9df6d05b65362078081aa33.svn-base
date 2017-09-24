<!doctype html>
<html>
<head>
<#include "/head.ftl"/>
<link rel="stylesheet" href="${rc.contextPath}/public/js/lib/zTree_v3/css/metroStyle/metroStyle.css">
<script type="text/javascript" src="${rc.contextPath}/public/js/lib/zTree_v3/js/jquery.ztree.core.min.js"></script>
<script type="text/javascript" src="${rc.contextPath}/public/js/lib/zTree_v3/js/jquery.ztree.excheck.min.js"></script>
<script type="text/javascript" src="${rc.contextPath}/public/js/lib/zTree_v3/js/jquery.ztree.exhide.min.js"></script>
<script type="text/javascript" src="${rc.contextPath}/public/js/pointTypeAuthorize/pointTypeAuthorize.js"></script>
</head>
<body>
<form id="pointTypeAuthorizeForm" class="form-horizontal">
	<div class="form-group">
        <a  class="btn btn-success" onclick="savePointTypeAuthorize();">
			<i class="glyphicon glyphicon-save"></i>
			<span>保存</span>
		</a>
		<a  class="btn btn-primary" onclick="cancelSelect();">
			<i class="glyphicon glyphicon-ok"></i>
    		<span>取消</span>
		</a>
		<label style="display:none;">
	      	<input type="checkbox" id="showAuthor"  onclick="showAuthorOnly();">仅显示授权结点
	    </label>
	</div>
	

	<div class="container-fluid">
	  <div class="row">
	    <div class="col-md-3 left">
		   <ul id="companyTree" name="companyTree" class="pull-left ztree"></ul>
		</div>
		<div class="col-md-9 right form-inline">
			<div class="form-group has-feedback">
				<label>筛选</label>
				<input type="text" class="form-control" id="pointTypeTreeName" name="pointTypeTreeName" placeholder="点类型名或编码关键字" >
	  			<span class="glyphicon glyphicon glyphicon-search form-control-feedback"></span>
	  		</div> 
		   <ul id="pointTypeTree" name="pointTypeTree" class="pull-left ztree"></ul>
		</div>
	  </div>
	</div>
			
</form>
</body>
</html>