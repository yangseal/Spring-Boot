<!doctype html>
<html>
<head>
<#include "/head.ftl"/>
<script type="text/javascript" src="${rc.contextPath}/public/js/oamCustomer/oamCustomers.js"></script>
</head>
<body>
<form id="oamCustomersForm" action="${rc.contextPath}/oamCustomer/queryOamCustomers">
	<div class="form-inline grid-page-condition">
		<div class="form-group">
    		<label>客户名称</label>
    		<input type="text" class="form-control" id="oamCustomerName" name="oamCustomerName" />
  		</div>
		<div class="form-group has-feedback">
			<#if !RequestParameters["oamAreaId"]?? || RequestParameters["oamAreaId"]=="">
			<label>所属省市</label>
    		<input type="text" class="form-control" style="cursor:pointer" id="oamArea" name="oamArea" onclick="selectOamArea();" />
    		<span class="glyphicon glyphicon-menu-hamburger form-control-feedback"></span>
    		</#if>
    		<input type="hidden" id="oamAreaId" name="oamArea.oamAreaId" value="${RequestParameters["oamAreaId"]!}" />
		</div>
	</div>
	<div class="grid-page-command">
		<a  class="btn btn-primary" onclick="refreshPage('oamCustomersForm','oamCustomersDiv',1);">
			<i class="glyphicon glyphicon-search"></i>
    		<span>查询</span>
		</a>
		<a  class="btn btn-info" onclick="viewOamCustomer();">
			<i class="glyphicon glyphicon-zoom-in"></i>
    		<span>查看</span>
		</a>
		<a  class="btn btn-primary" onclick="exportOamCustomers();">
			<i class="glyphicon glyphicon-log-out"></i>
    		<span>导出</span>
		</a>
		<#if !RequestParameters["isQuery"]?? || RequestParameters["isQuery"]=="">
		<a  class="btn btn-success" onclick="showOamCustomer();">
			<i class="glyphicon glyphicon-plus"></i>
    		<span>新增</span>
		</a>
		<a  class="btn btn-warning" onclick="editOamCustomer();">
			<i class="glyphicon glyphicon-edit"></i>
    		<span>编辑</span>
		</a>
		<a  class="btn btn-danger" onclick="deleteOamCustomer();">
			<i class="glyphicon glyphicon-trash"></i>
    		<span>删除</span>
		</a>
		</#if>
	</div>
	<div id="oamCustomersDiv"></div>
</form>
</body>
</html>
