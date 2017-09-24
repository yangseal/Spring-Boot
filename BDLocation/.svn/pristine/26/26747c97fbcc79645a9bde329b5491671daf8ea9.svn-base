<!doctype html>
<html>
<head>
<#include "/head.ftl"/>
<script type="text/javascript" src="${rc.contextPath}/public/js/corsApplyMaterial/showMaterials.js"></script>
</head>
<body>
<form id="materialsForm" action="${rc.contextPath}/corsApplyMaterial/queryMaterials">
<div class="form-inline grid-page-condition">
		<div class="form-group">
    		<label>企业名称</label>
    		<input type="text" class="form-control" id="companyName" name="companyName" />
  		</div>
  		<div class="form-group has-feedback">
    		<label>资料完善状态</label>
    		<select class="form-control" id="companyMaterialState" name="companyMaterialState">
				<option></option>
				<option value="WWS">未完善</option>
				<option value="YWS">已完善</option>
			</select>
  		</div>
	</div>
	<div class="grid-page-command">
		<a  class="btn btn-primary" onclick="refreshPage('materialsForm','materialsDiv',1);">
			<i class="glyphicon glyphicon-search"></i>
    		<span>查询</span>
		</a>
		<a  class="btn btn-info" onclick="viewCompanyExamine();">
			<i class="glyphicon glyphicon-zoom-in"></i>
    		<span>查看</span>
		</a>
		<a  class="btn btn-warning" onclick="editCompanyExamine();">
			<i class="glyphicon glyphicon-edit"></i>
    		<span>资料完善</span>
		</a>
	</div>
	<div id="materialsDiv"></div>
</form>
</body>
</html>
