<!doctype html>
<html>
<head>
<#include "/head.ftl"/>
<script type="text/javascript" src="${rc.contextPath}/public/js/baseStation/construction/constructs.js"></script>
<script type="text/javascript" src="${rc.contextPath}/public/js/baseStation/construction/editConstructs.js"></script>
<script type="text/javascript" src="${rc.contextPath}/public/js/baseStation/construction/buidlMaterialInfo.js"></script>
</head>
<body>
<form id="baseConstructForm" action="${rc.contextPath}/baseStation/construction/queryEditConstructs">
	<div class="form-inline grid-page-condition">
		<div class="form-group">
    		<label>客户名称</label>
    		<input type="text" class="form-control" id="customerName" name="baseCustomer.customerName" />
  		</div>
  		<div class="form-group">
    		<label>基站名称</label>
    		<input type="text" class="form-control" id="stationName" name="stationName" />
  		</div>
  		<div class="form-group">
    		<label>基站编号</label>
    		<input type="text" class="form-control" id="stationNo" name="stationNo" />
  		</div>
  		<div class="form-group">
    		<label>建设阶段</label>
    		<select class="form-control" id="constructStage" name="constructStage">
				<option></option>
				<option value="JSZ">建设中</option>
				<option value="TJYS">已提交验收</option>
				<option value="YYS">已验收</option>
				<option value="YBA">已备案</option>
				<option value="YBH">已驳回</option>
			</select>
  		</div>
	</div>
	<div class="command-div">
		<a  class="btn btn-info" onclick="refreshPage('baseConstructForm','baseConstructDiv',1);">
			<i class="glyphicon glyphicon-search"></i>
    		<span>查询</span>
		</a>
	</div>
	<div id="baseConstructDiv"></div>
</form>
</body>
</html>
