<!doctype html>
<html>
<head>
<#include "/head.ftl"/>
<script type="text/javascript" src="${rc.contextPath}/public/js/company/companys.js"></script>
</head>
<body>
<form id="companysForm" action="${rc.contextPath}/company/queryCompanys">
	<div class="form-inline grid-page-condition">
		<div class="form-group">
    		<label>企业名称</label>
    		<input type="text" class="form-control" id="companyName" name="companyName" />
  		</div>
  		<div class="form-group has-feedback">
    		<label>资料审批状态</label>
    		<select class="form-control" id="companyMaterialState" name="companyMaterialState">
				<option></option>
				<option value="null">未审核</option>
				<option value="1">审核中</option>
				<option value="2">已审核</option>
				<option value="3">已拒绝</option>
			</select>
  		</div>
	</div>
	<div class="command-div">
		<a  class="btn btn-primary" onclick="refreshPage('companysForm','companysDiv',1);">
			<i class="glyphicon glyphicon-search"></i>
    		<span>查询</span>
		</a>
		<a  class="btn btn-info" onclick="viewCompany();">
			<i class="glyphicon glyphicon-zoom-in"></i>
    		<span>查看</span>
		</a>
		<a  class="btn btn-primary" onclick="exportCompanys();">
			<i class="glyphicon glyphicon-log-out"></i>
    		<span>导出</span>
		</a>
		<#if !RequestParameters["isQuery"]?? || RequestParameters["isQuery"]=="">
		<#if common.isSystemUser || common.isCntenAdministrator>
		<a  class="btn btn-success" onclick="showCompany();">
			<i class="glyphicon glyphicon-plus"></i>
    		<span>新增</span>
		</a>
		</#if>
		<#if common.isSystemUser || common.isCntenAdministrator || common.isYeWuUser>
		<a  class="btn btn-warning" onclick="editCompany();">
			<i class="glyphicon glyphicon-edit"></i>
    		<span>编辑</span>
		</a>
		</#if>
		<#if common.isSystemUser || common.isCntenAdministrator>
		<a  class="btn btn-danger" onclick="deleteCompany();">
			<i class="glyphicon glyphicon-trash"></i>
    		<span>删除</span>
		</a>
		</#if>
		</#if>
	</div>
	<div id="companysDiv"></div>
</form>
</body>
</html>
