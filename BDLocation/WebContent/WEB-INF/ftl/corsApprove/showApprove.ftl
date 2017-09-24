<!doctype html>
<html>
<head>
<#include "/head.ftl"/>
<script type="text/javascript" src="${rc.contextPath}/public/js/corsApprove/account.js"></script>
</head>
<body>
<form id="accountForm" class="form-horizontal">
	<input type="hidden" name="busiApproveType" value="${busiApproveType!}"/>
	<input type="hidden" name="orderBussinkey" value="${orderBussinkey!}"
	<input type="hidden" id="companyId" name="companyId" value="${companyId!}"/>
	<input type="hidden" id="accountType" name="accountType" value="${accountType!}"/>
	<#if busiApproveType?? && "open"==busiApproveType>
	<div class="form-group pt15">
		<label id="applyCountLabel" for="applyCount" class="col-sm-2 control-label">企业名称</label>
		<div class="col-sm-8">
			<input type="text" class="form-control" readonly id="applyCount" value="<#if companyName??>${(companyName)!}<#else></#if>" />
		</div>
	</div>
	<div class="form-group">
		<label id="applyCountLabel" for="applyCount" class="col-sm-2 control-label">申请数量</label>
		<div class="col-sm-8">
			<input type="text" class="form-control" readonly id="applyCount" name="applyCount"  value="<#if applyCount??>${(applyCount)!}<#else></#if>" />
		</div>
	</div>	
	
	<div class="form-group">
		<label id="bdDeviceAccuracyLabel" for="bdDeviceAccuracy"  class="col-sm-2 control-label">入网精度</label>
		<div class="col-sm-8">
			<input type="text" class="form-control" readonly id="applyCount"  maxlength="6" isNotNull  value="<#if bdDeviceAccuracyName??>${bdDeviceAccuracyName!}<#else></#if>" />
		</div>
	</div>
	<div class="form-group">
		<label id="accountTypeLabel" for="accountType"  class="col-sm-2 control-label">账号类型</label>
		<div class="col-sm-8">
			<input type="text" class="form-control" readonly id="applyCount" maxlength="6" isNotNull validateExp="^[1-9]\d*$" value="<#if accountTypeName??>${accountTypeName!}<#else></#if>" />
		</div>
	</div>
	<div class="form-group">
		<label id="purposeDescLabel" for="purposeDesc"  class="col-sm-2 control-label">使用期限</label>
		<div class="col-sm-8">
			<input type="text" class="form-control" readonly id="purposeDesc" maxlength="6" isNotNull value="<#if accountType?? && accountType =="test">${accountUsePeriod!}个月<#else>${accountUsePeriod!}年</#if>" />
		</div>
	</div>
	<#--<div class="form-group">
		<label id="applyCommentLabel" for="applyComment" class="col-sm-2 control-label">备注</label>
		<div class="col-sm-8">
			<textarea class="form-control" rows="3" id="applyComment" name="applyComment" readonly><#if applyComment??>${applyComment!}<#else></#if></textarea>
		</div>
	</div>-->
	<div class="form-group">
		<label id="applyCountLabel" for="applyCount" class="col-sm-2 control-label">审核状态</label>
		<div class="col-sm-8">
			<input type="text" class="form-control" id="applyStatus" maxlength="6" readonly value="<#if applyStatusName??>${applyStatusName!}<#else></#if>" />
		</div>
	</div>
	<div class="form-group">
		<label id="busiApproveOpinionLabel" for="busiApproveOpinion" class="col-sm-2 control-label">审核意见</label>
		<div class="col-sm-8">
			<textarea class="form-control" <#if RequestParameters['isQuery']?? && RequestParameters['isQuery'] != ''>readOnly</#if> rows="3" id="busiApproveOpinion" name="busiApproveOpinion"><#if busiApproveOpinion??>${busiApproveOpinion!}<#else></#if></textarea>
		</div>
	</div>
<#elseif  busiApproveType?? && "repay"==busiApproveType>
	<div class="form-group pt15">
		<label id="applyCountLabel" for="applyCount" class="col-sm-2 control-label">企业名称</label>
		<div class="col-sm-8">
			<input type="text" class="form-control" readonly id="applyCount" value="<#if companyName??>${(companyName)!}<#else></#if>" />
		</div>
	</div>
	<div class="form-group">
		<label id="applyCountLabel" for="applyCount" class="col-sm-2 control-label">续费数量</label>
		<div class="col-sm-8">
			<input type="text" class="form-control" readonly id="applyCount" name="applyCount"  value="<#if applyCount??>${(applyCount)!}<#else></#if>" />
		</div>
	</div>
	<div class="form-group">
		<label id="accountTypeLabel" for="accountType"  class="col-sm-2 control-label">账号类型</label>
		<div class="col-sm-8">
			<input type="text" class="form-control" readonly id="applyCount" maxlength="6" isNotNull validateExp="^[1-9]\d*$" value="<#if accountTypeName??>${accountTypeName!}<#else></#if>" />
		</div>
	</div>
	<div class="form-group">
		<label id="accountTypeLabel" for="accountType"  class="col-sm-2 control-label">账号查看</label>
		<div class="col-sm-8">
		<a  class="btn btn-success" onclick="detailAccount('<#if orderBussinkey??>${orderBussinkey!}<#else></#if>');">
			<span>账号详情</span>
		</a>
		</div>
	</div>
	<div class="form-group">
		<label id="purposeDescLabel" for="purposeDesc"  class="col-sm-2 control-label">续费期限</label>
		<div class="col-sm-8">
			<input type="text" class="form-control" readonly id="purposeDesc" maxlength="6" isNotNull value="<#if accountUsePeriod??>${accountUsePeriod!}年<#else></#if>" />
		</div>
	</div>
	<div class="form-group">
		<label id="applyCountLabel" for="applyCount" class="col-sm-2 control-label">审核状态</label>
		<div class="col-sm-8">
			<input type="text" class="form-control" id="applyStatus" maxlength="6" readonly value="<#if applyStatusName??>${applyStatusName!}<#else></#if>" />
		</div>
	</div>
	<div class="form-group">
		<label id="busiApproveOpinionLabel" for="busiApproveOpinion" class="col-sm-2 control-label">审核意见</label>
		<div class="col-sm-8">
			<textarea class="form-control" <#if RequestParameters['isQuery']?? && RequestParameters['isQuery'] != ''>readOnly</#if> rows="3" id="busiApproveOpinion" name="busiApproveOpinion"><#if busiApproveOpinion??>${busiApproveOpinion!}<#else></#if></textarea>
		</div>
	</div>
</#if>

<#if !RequestParameters['isQuery']?? || RequestParameters['isQuery'] != 'true'>
	<div id="footer" style="text-align:center">
		<a  class="btn btn-success" onclick="passAccount();">
			<i class="glyphicon glyphicon-ok"></i>
			<span>通过</span>
		</a>
		<a  class="btn btn-danger " onclick="rejectAccount();">
			<i class="glyphicon glyphicon-remove"></i>
			<span>拒绝</span>
		</a>
	</div>
</#if>
</body>
</html>