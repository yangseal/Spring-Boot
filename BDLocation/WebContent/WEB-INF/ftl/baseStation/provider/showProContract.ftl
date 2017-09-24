<!doctype html>
<html>
<head>
<#include "/head.ftl"/>
<script type="text/javascript" src="${rc.contextPath}/public/js/baseStation/provider/providerContract.js"></script>
</head>
<body>
<form id="proContractForm" action="${rc.contextPath}/baseStation/provider/queryProContract">
	<input type="hidden" id="baseProviderId" name="baseProvider.baseProviderId" value="${baseProviderId!}"/>
	<div class="form-inline grid-page-condition">
		<div class="form-group">
    		<label>合同编号</label>
    		<input type="text" class="form-control" id="proContractNo" name="proContractNo" />
  		</div>
		<div class="form-group">
    		<label>所属项目</label>
    		<input type="text" class="form-control" id="baseProject" name="baseProject.projectName" />
  		</div>  
	</div>

	<div class="command-div">
		<a class="btn btn-primary" onclick="refreshPage('proContractForm','proContractDiv',1);">
			<i class="glyphicon glyphicon-search"></i>
    		<span>查询</span>
		</a>

		<a class="btn btn-success" onclick="showProContract();">
			<i class="glyphicon glyphicon-plus"></i>
    		<span>新增</span>
		</a>
		<a class="btn btn-warning" onclick="editProContract();">
			<i class="glyphicon glyphicon-edit"></i>
    		<span>编辑</span>
		</a>
	</div>
	<div id="proContractDiv"></div>
</form>
</body>
</html>
