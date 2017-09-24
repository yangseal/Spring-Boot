<!doctype html>
<html>
<head>
<#include "/head.ftl"/>
<script type="text/javascript" src="${rc.contextPath}/public/js/corsContract/addCorsContract.js"></script>
</head>
<body>
<form id="corsContractForm" class="form-horizontal">
	<input type="hidden" id="corsContractId" name="corsContractId" value="<#if corsContract??>${corsContract.corsContractId!}</#if>" />
	<div class="form-group">
		<label id="corsContractCodeLabel" for="corsContractCode" class="col-sm-2 control-label">合同编号</label>
		<div class="col-sm-8">
			<input type="text" class="form-control" id="corsContractCode" name="corsContractCode" value="<#if corsContract??>${corsContract.corsContractCode!}</#if>" isNotNull />
		</div>
		<label id="corsContractCodeTip" class="control-label" style="color:red">*</label>
	</div>
	
	<div class="form-group">
		<label id="corsContractNameLabel" for="corsContractName" class="col-sm-2 control-label">合同名称</label>
		<div class="col-sm-8">
			<input type="text" class="form-control" id="corsContractName" name="corsContractName" value="<#if corsContract??>${corsContract.corsContractName!}</#if>"/>
		</div>
	</div>
	
	<div class="form-group">
		<label id="corsContractCusNameLabel" for="corsContractCusName" class="col-sm-2 control-label">客户名称</label>
		<div class="col-sm-8">
			<input type="text" class="form-control" id="corsContractCusName" name="corsContractCusName" value="<#if corsContract??>${corsContract.corsContractCusName!}</#if>"/>
		</div>
	</div>
	
	<div class="form-group">
		<label id="corsContractNumLabel" for="corsContractNum" class="col-sm-2 control-label">账号数量</label>
		<div class="col-sm-8">
			<input type="text" class="form-control" id="corsContractNum" name="corsContractNum" value="<#if corsContract??>${corsContract.corsContractNum!}</#if>"/>
		</div>
	</div>
	
	<div class="form-group">
		<label id="corsContractMoneyLabel" for="corsContractMoney" class="col-sm-2 control-label">金额</label>
		<div class="col-sm-8">
			<input type="text" class="form-control" id="corsContractMoney" name="corsContractMoney" value="<#if corsContract??>${corsContract.corsContractMoney!}</#if>"/>
		</div>
	</div>

	<div class="form-group">
		<label id="corsContractBillLabel" for="corsContractBill" class="col-sm-2 control-label">发票</label>
		<div class="col-sm-8">
			<input type="text" class="form-control" id="corsContractBill" name="corsContractBill" value="<#if corsContract??>${corsContract.corsContractBill!}</#if>"/>
		</div>
	 </div>

	<div class="form-group">
		<label id="corsContractDateLabel" for="corsContractDate" class="col-sm-2 control-label">合同生效日期</label>
		<div class="col-sm-8">
			<input type="text" class="form-control" readOnly id="corsContractDate" name="corsContractDate" onclick="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm:ss'});" value="<#if corsContract??>${corsContract.corsContractDate!}</#if>"/>
		    <span class="glyphicon glyphicon-menu-hamburger form-control-feedback"></span>
		</div>
	</div>
	
	<div class="form-group">
		<label id="corsContractCommentLabel" for="corsContractComment" class="col-sm-2 control-label">合同备注</label>
		<div class="col-sm-8">
			<input type="text" class="form-control" id="corsContractComment" name="corsContractComment" value="<#if corsContract??>${corsContract.corsContractComment!}</#if>"/>
		</div>
	 </div>
</form>

<#if (!RequestParameters["isQuery"] ?? || RequestParameters["isQuery"]=="")>
<div class="form-group">
      <label class="col-sm-2 control-label"></label>
      <div class="col-sm-8" style="text-align:center;">
	<a  class="btn btn-success" onclick="saveCorsContract();">
		<i class="glyphicon glyphicon-save"></i>
		<span>保存</span>
	</a>
	</div>
</div>
</#if>
</body>
</html>