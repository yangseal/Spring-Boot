<!doctype html>
<html>
<head>
<#include "/head.ftl"/>
<script type="text/javascript" src="${rc.contextPath}/public/js/measureProject/measureProjects.js"></script>
<style>
	.has-feedback .form-control {
    	padding-right: 0px;
	}
</style>
</head>
<body>
<form id="measureProjectsForm" action="${rc.contextPath}/measureProject/queryMeasureProjects">
	<div class="form-inline">
	
		<div class="form-group">
			<label>工程名称</label>
			<input type="text" class="form-control" id="measureProjectName" name="measureProjectName" />
		</div>
		
		<#if common.isSystemUser>
		<div class="form-group has-feedback">
		<label>所属企业</label>
			<input type="text" class="form-control" id="affiliationCompany" name="affiliationCompany" style="cursor:pointer" onclick="selectAffiliationCompany();" />
			<input type="hidden" id="affiliationCompanyId" name="affiliationCompanyId" />
    		<span class="glyphicon glyphicon-menu-hamburger form-control-feedback"></span>
		</div>
		</#if>
		
		<div class="form-group has-feedback">
    		<label>创建日期</label>
    		<input type="text" class="form-control" style="cursor:pointer" id="minCreateDate" name="minCreateDate" onclick="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm:ss'});" />
    		<span class="glyphicon glyphicon-menu-hamburger form-control-feedback"></span>
  		</div>
  		<div class="form-group has-feedback">
    		<span>--></span>
    		<input type="text" class="form-control" style="cursor:pointer" id="maxCreateDate" name="maxCreateDate" onclick="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm:ss'});" />
    		<span class="glyphicon glyphicon-menu-hamburger form-control-feedback"></span>
  		</div>
  		
  		<div class="form-group">
			<label>作业人员</label>
			<input type="text" class="form-control" id="measureUser" name="measureUser" />
		</div>
  		
  	</div>
	<div class="command-div">
		<a  class="btn btn-primary" onclick="refreshPage('measureProjectsForm','measureProjectsDiv',1);">
			<i class="glyphicon glyphicon-search"></i>
    		<span>查询</span>
		</a>
		<a  class="btn btn-info" onclick="viewMeasureProject();">
			<i class="glyphicon glyphicon-zoom-in"></i>
    		<span>查看</span>
		</a>
		<#-- 
		<a  class="btn btn-primary" onclick="exportMeasureProjects();">
			<i class="glyphicon glyphicon-log-out"></i>
    		<span>导出</span>
		</a>
		-->
		<#if !RequestParameters["isQuery"]?? || RequestParameters["isQuery"]=="">
		<#-- 
		<a  class="btn btn-success" onclick="showMeasureProject();">
			<i class="glyphicon glyphicon-plus"></i>
    		<span>新增</span>
		</a>
		<a  class="btn btn-warning" onclick="editMeasureProject();">
			<i class="glyphicon glyphicon-edit"></i>
    		<span>编辑</span>
		</a>
		-->
		<a  class="btn btn-danger" onclick="deleteMeasureProject();">
			<i class="glyphicon glyphicon-trash"></i>
    		<span>删除</span>
		</a>
		</#if>
		<a  class="btn btn-success" onclick="saveloft();">
			<i class="glyphicon glyphicon-share-alt"></i>
    		<span>放样</span>
		</a>
		<a  class="btn btn-primary" onclick="editProjectInfo();">
			<i class="glyphicon glyphicon-share-alt"></i>
    		<span>导出</span>
		</a>
	</div>
	<div id="measureProjectsDiv"></div>
</form>
</body>
</html>
