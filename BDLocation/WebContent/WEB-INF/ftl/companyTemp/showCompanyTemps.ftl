<!doctype html>
<html>
<head>
<#include "/head.ftl"/>
<script type="text/javascript" src="${rc.contextPath}/public/js/companyTemp/companyTemps.js"></script>
</head>
<body>
<form id="companyTempsForm" action="${rc.contextPath}/companyTemp/queryCompanyTemps">
	<div class="form-inline grid-page-condition">
		<div class="form-group">
    		<label>企业名称</label>
    		<input type="text" class="form-control" id="companyTempName" name="companyTempName" />
  		</div>
  		<div class="form-group has-feedback">
    		<label>审批状态</label>
    		<select class="form-control" id="status" name="status">
				<option></option>
				<option value="null">审核中</option>
				<option value="1">已通过</option>
				<option value="0">已拒绝</option>
			</select>
  		</div>
	</div>
	<div class="grid-page-command">
		<a  class="btn btn-primary" onclick="refreshPage('companyTempsForm','companyTempsDiv',1);">
			<i class="glyphicon glyphicon-search"></i>
    		<span>查询</span>
		</a>
		<a  class="btn btn-info" onclick="viewCompanyTemp();">
			<i class="glyphicon glyphicon-zoom-in"></i>
    		<span>查看</span>
		</a>
		<a  class="btn btn-warning" onclick="editCompanyTemp();">
			<i class="glyphicon glyphicon-edit"></i>
    		<span>审批</span>
		</a>
		<#if 1==0>
		<a  class="btn btn-primary" onclick="exportCompanyTemps();">
			<i class="glyphicon glyphicon-log-out"></i>
    		<span>导出</span>
		</a>
		<#if !RequestParameters["isQuery"]?? || RequestParameters["isQuery"]=="">
		<a  class="btn btn-success" onclick="showCompanyTemp();">
			<i class="glyphicon glyphicon-plus"></i>
    		<span>新增</span>
		</a>
		<a  class="btn btn-warning" onclick="editCompanyTemp();">
			<i class="glyphicon glyphicon-edit"></i>
    		<span>编辑</span>
		</a>
		<a  class="btn btn-danger" onclick="deleteCompanyTemp();">
			<i class="glyphicon glyphicon-trash"></i>
    		<span>删除</span>
		</a>
		</#if>
		</#if>
	</div>
	<div id="companyTempsDiv"></div>
</form>
</body>
</html>
