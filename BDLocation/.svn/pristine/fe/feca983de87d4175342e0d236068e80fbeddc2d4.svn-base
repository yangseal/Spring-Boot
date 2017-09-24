<!doctype html>
<html>
<head>
<script type="text/javascript" src="${rc.contextPath}/public/js/corsApprove/account.js"></script>
</head>
<body>
<form id="accountForm" class="form-horizontal">
	<input type="hidden" name="busiApproveType" value="${busiApproveType!}"/>
	<input type="hidden" name="orderBussinkey" value="${orderBussinkey!}"
	<input type="hidden" id="companyId" name="companyId" value="${companyId!}"/>
	<input type="hidden" id="accountType" name="accountType" value="${accountType!}"/>
	<div class="form-group">
		<label id="busiApproveOpinionLabel" for="busiApproveOpinion" class="col-sm-2 control-label">意见审核</label>
		<div class="col-sm-8">
			<textarea class="form-control"  rows="3" id="busiApproveOpinion" name="busiApproveOpinion" isNotNull />
		</div>
		<label id="busiApproveOpinionLabel" class="control-label" style="color:red">*</label>
	</div>
<#if !RequestParameters['isQuery']?? || RequestParameters['isQuery'] != 'true'>
	<div id="footer" style="text-align:center">
		<a  class="btn btn-danger " onclick="rejectAccount();">
			<i class="glyphicon glyphicon-remove"></i>
			<span>确定</span>
		</a>
	</div>
</#if>
</body>
</html>