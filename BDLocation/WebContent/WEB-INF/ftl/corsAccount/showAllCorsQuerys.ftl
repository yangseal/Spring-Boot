<!doctype html>
<html>
<head>
<#include "/head.ftl"/>
<script type="text/javascript" src="${rc.contextPath}/public/js/corsAccount/corsQuery.js"></script>
</head>
<body>
<form id="corsQueryForm" action="${rc.contextPath}/corsAccount/queryAllCorsAccount">
	<div class="form-inline grid-page-condition">
		<div class="form-group has-feedback">
			<#if !RequestParameters["companyId"]?? || RequestParameters["companyId"]=="">
			<label>所属企业</label>
    		<input type="text" class="form-control" style="cursor:pointer" id="company" name="company" onclick="selectCompany();" />
    		<span class="glyphicon glyphicon-menu-hamburger form-control-feedback"></span>
    		</#if>
    		<input type="hidden" id="companyId" name="company.companyId" value="${RequestParameters["companyId"]!}" />
		</div>
  		<div class="form-group has-feedback">
			<label>日期</label>
			<input id="effectiveDate" style="cursor:pointer"  type="text" name="effectiveDate" onclick="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm:ss'});"class="form-control" />
   		    <span class="glyphicon glyphicon-menu-hamburger form-control-feedback"></span>
		 </div>
		 <div class="form-group has-feedback">
    		<span>--></span>
		    <input id="exprieDate" style="cursor:pointer"  type="text" name="exprieDate" onclick="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm:ss'});" class="form-control" />
            <span class="glyphicon glyphicon-menu-hamburger form-control-feedback"></span>
	     </div>
	</div>
	<div class="grid-page-command">
		<a  class="btn btn-primary" onclick="refreshPage('corsQueryForm','corsQueryDiv',1);">
			<i class="glyphicon glyphicon-search"></i>
    		<span>查询</span>
		</a>
		<a  class="btn btn-primary" onclick="selectCorsAccountUse();">
			<i class="glyphicon glyphicon-wrench"></i>
    		<span>划分用途</span>
		</a>
	</div>
	<div id="corsQueryDiv"></div>
</form>
</body>
</html>
