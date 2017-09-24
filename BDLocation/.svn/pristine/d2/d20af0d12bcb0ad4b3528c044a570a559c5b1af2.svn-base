<!doctype html>
<html>
<head>
<#include "/head.ftl"/>
<script type="text/javascript" src="${rc.contextPath}/public/js/corsApply/corsApplys.js"></script>
</head>
<body>
<form id="corsApplysForm" action="${rc.contextPath}/corsApply/queryCorsApplys">
	<div class="form-inline grid-page-condition">
		<div class="form-group has-feedback">
			<div class="col-sm-4">
			<select class="form-control" id="bdDeviceAccuracy" name="bdDeviceAccuracy">
				<option <#if corsApply?? && corsApply.bdDeviceAccuracy?? && "meter"==corsApply.bdDeviceAccuracy>selected</#if> value="meter">亚米</option>
				<option <#if corsApply?? && corsApply.bdDeviceAccuracy?? && "centimeter"==corsApply.bdDeviceAccuracy>selected</#if> value="centimeter">厘米</option>
			</select>
			</div>
    		<input type="hidden" id="companyId" name="company.companyId" value="${RequestParameters["companyId"]!}" />
		</div>
		<div class="form-group has-feedback">
    		<label>申请日期</label>
    		<input type="text" class="form-control" style="cursor:pointer" id="minApplyDate" name="minApplyDate" onclick="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm:ss'});" />
    		<span class="glyphicon glyphicon-menu-hamburger form-control-feedback"></span>
  		</div>
  		<div class="form-group has-feedback">
    		<span>--></span>
    		<input type="text" class="form-control" style="cursor:pointer" id="maxApplyDate" name="maxApplyDate" onclick="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm:ss'});" />
    		<span class="glyphicon glyphicon-menu-hamburger form-control-feedback"></span>
  		</div>
	</div>
	<div class="grid-page-command">
		<a  class="btn btn-primary" onclick="refreshPage('corsApplysForm','corsApplysDiv',1);">
			<i class="glyphicon glyphicon-search"></i>
    		<span>查询</span>
		</a>
		<a  class="btn btn-info" onclick="viewCorsApply();">
			<i class="glyphicon glyphicon-zoom-in"></i>
    		<span>查看</span>
		</a>
		<a  class="btn btn-success" onclick="submitApply();">
			<i class="glyphicon glyphicon-plus"></i>
    		<span>提交</span>
		</a>
		<a  class="btn btn-success" onclick="showCorsApply();">
			<i class="glyphicon glyphicon-plus"></i>
    		<span>新增</span>
		</a>
		<a  class="btn btn-warning" onclick="editCorsApply();">
			<i class="glyphicon glyphicon-edit"></i>
    		<span>编辑</span>
		</a>
		<a  class="btn btn-danger" onclick="deleteCorsApply();">
			<i class="glyphicon glyphicon-trash"></i>
    		<span>删除</span>
		</a>
	</div>
	<div id="corsApplysDiv"></div>
</form>
</body>
</html>
