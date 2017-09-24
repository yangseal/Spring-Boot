<!doctype html>
<html>
<head>
<#include "/head.ftl"/>
<script type="text/javascript" src="${rc.contextPath}/public/js/corsApprove/corsApproves.js"></script>
</head>
<body>
<form id="showRepayDetailOrderForm" class="form-horizontal" action="${rc.contextPath}/corsApprove/repayDetailOrderTable">
	<#--订单信息-->
	<div class="form-group has-feedback">
		<label id="oamProjectLabel" for="oamProject" class="col-sm-2 control-label ct_tit"><span>订单信息</span></label>
		<div class="col-sm-8">
			<input type="hidden" class="form-control"/>
		</div>
	</div>
	<div class="form-group has-feedback pt15">
		<label id="oamProjectLabel" for="oamProject" class="col-sm-2 control-label">订单号</label>
		<div class="col-sm-2">
			<input type="text" readOnly  class="form-control" id="baseProject"  value="${corsRepay.orderNo!}"/>
		</div>
		
		<label id="accountRepayTimeLabel" for="accountRepayTime" class="col-sm-1 control-label">创建时间</label>
		<div class="col-sm-2">
			<input type="text" readOnly class="form-control" id="accountRepayTime"   value="${corsRepay.accountRepayTime!}"/>
		</div>
		
		<label id="repayFinshDateLabel" for="repayFinshDate" class="col-sm-1 control-label">完成时间</label>
		<div class="col-sm-2">
			<input type="text" readOnly class="form-control" id="repayFinshDate"   value="${corsRepay.repayFinshDate!}"/>
		</div>
	</div>
	<div class="form-group has-feedback">
		<label id="applyStatusLabel" for="applyStatus" class="col-sm-2 control-label">订单状态</label>
		<div class="col-sm-2">
			<input type="text" readOnly class="form-control" id="applyStatus"   value="${corsRepay.accountRepayStateName!}"/>
		</div>
		
		<label id="stationNameLabel" for="stationName" class="col-sm-1 control-label">订单类型</label>
		<div class="col-sm-2">
			<input type="text" readOnly class="form-control" id="stationName"  value="${corsRepay.orderTypeName!}" />
		</div>
	</div>
	<#--订单明细-->
	<div class="form-group has-feedback">
		<label id="oamProjectLabel" for="oamProject" class="col-sm-2 control-label ct_tit"><span>订单明细</span></label>
		<div class="col-sm-8">
			<input type="hidden" class="form-control"/>&nbsp;
		</div>
		<label class="col-sm-2 control-label">&nbsp;</label>
		<div class="col-sm-8" style="padding-top:20px;">
			<input type="hidden" name="corsApplyId" value="${corsRepay.accountRepayId!}"/>
		 	<div id="showRepayDetailOrderDiv" class="ads_list">
		 	</div>
		</div>
	</div>
	
 
</form>
</body>
</html>