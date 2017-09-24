<!doctype html>
<html>
<head>
<#include "/head.ftl"/>
<script type="text/javascript" src="${rc.contextPath}/public/js/measureProject/measureProject.js"></script>
</head>
<body>
<#if RequestParameters["measureProjectId"]??>
<ul class="nav nav-tabs" role="tablist">
    <li role="presentation" class="active"><a href="#measureProjectTab" aria-controls="measureProjectTab" role="tab" data-toggle="tab">工程详情</a></li>
    <li role="presentation"><a href="#measurePointTab" aria-controls="measurePointTab" role="tab" data-toggle="tab">测量点</a></li>
</ul>
<div class="tab-content">
    <div role="tabpanel" class="tab-pane active" id="measureProjectTab">
</#if>

<form id="measureProjectForm" class="form-horizontal">
	<div class="form-group">
		<label id="measureProjectNameLabel" for="measureProjectName" class="col-sm-2 control-label">工程名称</label>
		<div class="col-sm-7">
			<input type="text" class="form-control" id="measureProjectName" name="measureProjectName" isNotNull value="<#if measureProject??>${measureProject.measureProjectName!}<#else></#if>" />
		</div>
		<label id="measureProjectNameTip" class="control-label" style="color:red">*</label>
	</div>
	<div class="form-group">
		<label id="measureUserLabel" for="measureUser" class="col-sm-2 control-label">作业人员</label>
		<div class="col-sm-7">
			<input type="text" class="form-control" id="measureUser" name="measureUser" isNotNull value="<#if measureProject??>${measureProject.measureUser!}<#else></#if>" />
		</div>
		<label id="measureUserTip" class="control-label" style="color:red">*</label>
	</div>
	<div class="form-group">
		<label id="collectTplLabel" for="collectTpl" class="col-sm-2 control-label">数据采集模板</label>
		<div class="col-sm-7">
			<select class="form-control" id="collectTpl" name="collectTpl" isNotNull>
				<option></option>
				<option <#if measureProject?? && "point"==measureProject.collectTpl || !measureProject?? && "point"=="point">selected</#if> value="point">默认点.gdd</option>
				<option <#if measureProject?? && "pointOrLineOrPlane"==measureProject.collectTpl || !measureProject?? && "pointOrLineOrPlane"=="point">selected</#if> value="pointOrLineOrPlane">默认点线面.gdd</option>
			</select>
		</div>
		<label id="collectTplTip" class="control-label" style="color:red">*</label>
	</div>
	<div class="form-group">
		<label id="coordinateLabel" for="coordinate" class="col-sm-2 control-label">坐标系统</label>
		<div class="col-sm-7">
			<select class="form-control" id="coordinate" name="coordinate" isNotNull>
				<option></option>
				<option <#if measureProject?? && "WGS84"==measureProject.coordinate || !measureProject?? && "WGS84"=="WGS84">selected</#if> value="WGS84">WGS84.sys</option>
				<option <#if measureProject?? && "beijing54"==measureProject.coordinate || !measureProject?? && "beijing54"=="WGS84">selected</#if> value="beijing54">beijing54-144.sys</option>
			</select>
		</div>
		<label id="coordinateTip" class="control-label" style="color:red">*</label>
	</div>
	<div class="form-group has-feedback">
		<label id="createDateLabel" for="createDate" class="col-sm-2 control-label">创建时间</label>
		<div class="col-sm-7">
			<input type="text" class="form-control" id="createDate" name="createDate" isNotNull value="<#if measureProject??>${measureProject.createDate!}<#else>${.now?string("yyyy-MM-dd HH:mm:ss")}</#if>" onclick="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm:ss'});" />
			<span class="glyphicon glyphicon-menu-hamburger form-control-feedback"></span>
		</div>
		<label id="createDateTip" class="control-label" style="color:red">*</label>
	</div>
	<#if common.isSystemUser>
	<div class="form-group has-feedback">
		<label id="affiliationCompanyLabel" for="affiliationCompany" class="col-sm-2 control-label">所属企业</label>
		<div class="col-sm-7">
			<input type="text" class="form-control" style="cursor:pointer" id="affiliationCompany" name="affiliationCompany" isNotNull value="<#if measureProject?? && measureProject.affiliationCompany??>${measureProject.affiliationCompany.companyName!}</#if>" onclick="selectAffiliationCompany();" />
			<span class="glyphicon glyphicon-menu-hamburger form-control-feedback"></span>
		</div>
		<label id="affiliationCompanyTip" class="control-label" style="color:red">*</label>
	</div>
	</#if>
	<input type="hidden" id="affiliationCompanyId" name="affiliationCompanyId" value="<#if measureProject?? && measureProject.affiliationCompany??>${measureProject.affiliationCompany.companyId!}<#elseif !common.isSystemUser>${CURRENT_USER.company.companyId!}</#if>" />
	<#if !RequestParameters["createUserId"]?? || RequestParameters["createUserId"]=="">
	<div class="form-group has-feedback">
		<label id="createUserLabel" for="createUser" class="col-sm-2 control-label">创建用户</label>
		<div class="col-sm-7">
			<input type="text" class="form-control" style="cursor:pointer" id="createUser" name="createUser" isNotNull value="<#if measureProject?? && measureProject.createUser??>${measureProject.createUser.userName!}</#if>" onclick="selectCreateUser();" />
			<span class="glyphicon glyphicon-menu-hamburger form-control-feedback"></span>
		</div>
		<label id="createUserTip" class="control-label" style="color:red">*</label>
	</div>
	</#if>
	<input type="hidden" id="createUserId" name="createUserId" value="<#if measureProject?? && measureProject.createUser??>${measureProject.createUser.userId!}<#else>${RequestParameters["createUserId"]!}</#if>" />
	<input type="hidden" id="measureProjectId" name="measureProjectId" value="<#if measureProject??>${measureProject.measureProjectId!}</#if>" />
</form>

<div style="text-align:center">
	<a class="btn btn-primary" onclick="exportMeasureProject();">
		<i class="glyphicon glyphicon-log-out"></i>
		<span>导出</span>
	</a>
	
	<#if !RequestParameters["isQuery"]?? || RequestParameters["isQuery"]=="">
	<a  class="btn btn-success" onclick="saveMeasureProject();">
		<i class="glyphicon glyphicon-save"></i>
		<span>保存</span>
	</a>
	</#if>
</div>

<#if RequestParameters["measureProjectId"]??>
	</div>
<div role="tabpanel" class="tab-pane" id="measurePointTab">
   	<iframe code="measurePointsTab" frameborder=0 width="100%" src="${rc.contextPath}/measurePoint/showMeasurePoints?${rc.queryString!}" />
</div>
</div>
</#if>
</body>
</html>