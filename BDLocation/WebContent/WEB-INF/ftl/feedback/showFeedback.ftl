<!doctype html>
<html>
<head>
<#include "/head.ftl"/>
<script type="text/javascript" src="${rc.contextPath}/public/js/feedback/feedback.js"></script>
</head>
<body>

<form id="feedbackForm" class="form-horizontal">
	<input type="hidden" id="companyId" name="company.companyId" value="<#if feedback?? && feedback.company??>${feedback.company.companyId!}<#elseif RequestParameters["companyId"]??>${RequestParameters["companyId"]!}<#elseif !feedback??>${CURRENT_USER.company.companyId}</#if>" />
	<input type="hidden" id="userId" name="user.userId" value="<#if feedback?? && feedback.user??>${feedback.user.userId!}<#elseif RequestParameters["userId"]??>${RequestParameters["userId"]!}<#elseif !feedback??>${CURRENT_USER.userId}</#if>" />
	<div class="form-group">
		<label id="typeLabel" for="type" class="col-sm-2 control-label">信息分类</label>
		<div class="col-sm-7">
			<select class="form-control" id="type" name="type" isNotNull>
				<option <#if feedback?? && feedback.type?? && "forStation"==feedback.type || !feedback?? && "forStation"=="forCustom">selected</#if> value="forStation">CORS基站问题</option>
				<option <#if feedback?? && feedback.type?? && "forDevice"==feedback.type || !feedback?? && "forDevice"=="forCustom">selected</#if> value="forDevice">北斗设备问题</option>
				<option <#if feedback?? && feedback.type?? && "forAccount"==feedback.type || !feedback?? && "forAccount"=="forCustom">selected</#if> value="forAccount">CORS账户问题</option>
				<option <#if feedback?? && feedback.type?? && "forCustom"==feedback.type || !feedback?? && "forCustom"=="forCustom">selected</#if> value="forCustom">其他反馈</option>
			</select>
		</div>
		<label id="typeTip" class="control-label" style="color:red">*</label>
	</div>
	<#if common.isSystemUser || common.isCntenUser || RequestParameters["isQuery"]??>
	<div class="form-group">
		<label id="feedbackStatusLabel" for="feedbackStatus" class="col-sm-2 control-label">处理状态</label>
		<div class="col-sm-7">
			<select class="form-control" id="feedbackStatus" name="feedbackStatus" isNotNull >
				<option <#if feedback?? && feedback.feedbackStatus?? && "untreated"==feedback.feedbackStatus || !feedback?? && "untreated"=="untreated">selected</#if> value="untreated">未解决</option>
				<option <#if feedback?? && feedback.feedbackStatus?? && "treated"==feedback.feedbackStatus || !feedback?? && "treated"=="untreated">selected</#if> value="treated">已解决</option>
			</select>
		</div>
		<label id="feedbackStatusTip" class="control-label" style="color:red">*</label>
	</div>
	</#if>
	<div class="form-group">
		<label id="informationLabel" for="information" class="col-sm-2 control-label">反馈信息</label>
		<div class="col-sm-7">
			<textarea class="form-control" rows="3" id="information" name="information" ><#if feedback??>${feedback.information!}</#if></textarea>
		</div>
		<label id="informationTip" class="control-label" style="color:red">*</label>
	</div>
	<div class="form-group has-feedback">
		<label id="createDateLabel" for="createDate" class="col-sm-2 control-label">反馈日期</label>
		<div class="col-sm-7">
			<input type="text" class="form-control" id="createDate" name="createDate" value="<#if feedback??>${feedback.createDate!}<#else>${.now?string("yyyy-MM-dd HH:mm:ss")}</#if>" readonly />
			<span class="glyphicon glyphicon-menu-hamburger form-control-feedback"></span>
		</div>
		<label id="createDateTip" class="control-label" style="color:red"></label>
	</div>
	<input type="hidden" id="feedbackId" name="feedbackId" value="<#if feedback??>${feedback.feedbackId!}</#if>" />
</form>
<#if !RequestParameters["isQuery"]?? || RequestParameters["isQuery"]=="">
<div class="card-page-command">
	<a  class="btn btn-success" onclick="saveFeedback();">
		<i class="glyphicon glyphicon-save"></i>
		<span>保存</span>
	</a>
</div>
</#if>

</body>
</html>