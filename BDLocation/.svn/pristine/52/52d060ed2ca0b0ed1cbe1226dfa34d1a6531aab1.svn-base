<!doctype html>
<html>
<head>
<#include "/head.ftl"/>
<script type="text/javascript" src="${rc.contextPath}/public/js/stakeoutTask/stakeoutTasks.js"></script>
<style>
	.has-feedback .form-control {
    	padding-right: 5px;
	}
</style>
</head>
<body>
<form id="stakeoutTasksForm" action="${rc.contextPath}/stakeoutTask/queryStakeoutTasks">
	<div class="form-inline">
		<div class="form-group">
			<label>任务名称</label>
			<input id="stakeoutTaskName" type="text" name="stakeoutTaskName" class="form-control" style="width:150px"/>
			<label>创建人</label>
			<input id="userName" type="text" name="userName" class="form-control" style="width:100px" />
		</div>
		<div class="form-group has-feedback">
			<#if common.isSystemUser>
			<label>所属企业</label>
			<input id="affiliationCompany" type="text" name="affiliationCompany" style="cursor:pointer" onclick="selectAffiliationCompany();" class="form-control" />
			<span class="glyphicon glyphicon-menu-hamburger form-control-feedback"></span>
			<input type="hidden" id="affiliationCompanyId" name="affiliationCompanyId" />				
			</#if>
		</div>
		<div class="form-group has-feedback">
			<label>创建时间</label>
			<input id="createDateBegin" style="cursor:pointer"  type="text" name="createDateBegin" onclick="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm:ss'});"class="form-control" />
   		    <span class="glyphicon glyphicon-menu-hamburger form-control-feedback"></span>
		 </div>
		 <div class="form-group has-feedback">
    		<span>--></span>
		    <input id="createDateEnd" style="cursor:pointer"  type="text" name="createDateEnd" onclick="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm:ss'});" class="form-control" />
            <span class="glyphicon glyphicon-menu-hamburger form-control-feedback"></span>
	     </div>
	     <div class="form-group has-feedback">
    		<label>任务状态</label>
    		<select class="form-control" id="taskStatus" name="taskStatus">
				<option></option>
				<option value="newTask">新任务</option>
				<option value="issued">已下发</option>
			</select>
  		</div>
	</div>
	<div class="command-div">
		<a  class="btn btn-primary" onclick="refreshPage('stakeoutTasksForm','stakeoutTasksDiv',1);">
			<i class="glyphicon glyphicon-search"></i>
    		<span>查询</span>
		</a>
		<a  class="btn btn-info" onclick="viewStakeoutTask();">
			<i class="glyphicon glyphicon-zoom-in"></i>
    		<span>查看</span>
		</a>
		<div style="display:none">
			<a  class="btn btn-primary" onclick="exportStakeoutTasks();" >
				<i class="glyphicon glyphicon-log-out" ></i>
    			<span >导出</span>
			</a>
		</div>
		<#if !RequestParameters["isQuery"]?? || RequestParameters["isQuery"]=="">
		<a  class="btn btn-success" onclick="showStakeoutTask();">
			<i class="glyphicon glyphicon-plus"></i>
    		<span>新增</span>
		</a>
		<a  class="btn btn-warning" onclick="editStakeoutTask();">
			<i class="glyphicon glyphicon-edit"></i>
    		<span>编辑</span>
		</a>
		<a  class="btn btn-danger" onclick="deleteStakeoutTask();">
			<i class="glyphicon glyphicon-trash"></i>
    		<span>删除</span>
		</a>
		<a  class="btn btn-primary"  onclick="updateStakeoutTaskState();">
			<i class="glyphicon glyphicon-bullhorn"></i>
    		<span>下发</span>
		</a>
		</#if>
	</div>
	<div id="stakeoutTasksDiv"></div>
</form>
</body>
</html>
