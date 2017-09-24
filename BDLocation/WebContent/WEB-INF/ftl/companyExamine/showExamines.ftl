<!doctype html>
<html>
<head>
<#include "/head.ftl"/>
<script type="text/javascript" src="${rc.contextPath}/public/js/companyExamine/companyExamine.js"></script>
</head>
<body>
<form id="companyExamineForm" action="${rc.contextPath}/companyExamine/queryExamines">
<div class="form-inline grid-page-condition">
		<div class="form-group">
    		<label>企业名称</label>
    		<input type="text" class="form-control" id="companyName" name="companyName" />
  		</div>
  		<div class="form-group has-feedback">
    		<label>审批状态</label>
    		<select class="form-control" id="approveState" name="approveState">
				<option value=""></option>
				<option value="1">审核中</option>
				<option value="2">已通过</option>
				<option value="3">已拒绝</option>
			</select>
  		</div>
	</div>
	<div class="grid-page-command">
		<a  class="btn btn-primary" onclick="refreshPage('companyExamineForm','companyExamineDiv',1);">
			<i class="glyphicon glyphicon-search"></i>
    		<span>查询</span>
		</a>
		<a  class="btn btn-info" onclick="viewCompanyExamine();">
			<i class="glyphicon glyphicon-zoom-in"></i>
    		<span>查看</span>
		</a>
		<a  class="btn btn-warning" onclick="editCompanyExamine();">
			<i class="glyphicon glyphicon-edit"></i>
    		<span>审批</span>
		</a>
	</div>
	<div id="companyExamineDiv"></div>
</form>
</body>
</html>
