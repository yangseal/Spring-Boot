<!doctype html>
<html>
<head>
<#include "/head.ftl"/>
<script type="text/javascript" src="${rc.contextPath}/public/js/feedback/feedbacks.js"></script>
</head>
<body>
<form id="feedbacksForm" action="${rc.contextPath}/feedback/queryFeedbacks">
	<div class="form-inline grid-page-condition">
		<#if common.isSystemUser || common.isCntenUser>
		<div class="form-group has-feedback">
			<label>反馈企业</label>
    		<input type="text" class="form-control" style="cursor:pointer" id="company" name="company" onclick="selectCompany();" />
    		<span class="glyphicon glyphicon-menu-hamburger form-control-feedback"></span>
    		<input type="hidden" id="companyId" name="company.companyId" value="${RequestParameters["companyId"]!}" />
		</div>
		</#if>
		<div class="form-group">
    		<label>信息分类</label>
    		<select class="form-control" id="type" name="type">
    			<option></option>
				<option value="forStation">CORS基站问题</option>
				<option value="forDevice">北斗设备问题</option>
				<option value="forAccount">CORS账户问题</option>
				<option value="forCustom">其他反馈</option>
    		</select>
  		</div>
		<div class="form-group">
    		<label>处理状态</label>
    		<select class="form-control" id="feedbackStatus" name="feedbackStatus">
    			<option></option>
				<option value="untreated">未解决</option>
				<option value="treated">已解决</option>
    		</select>
  		</div>
	</div>
	<div class="grid-page-command">
		<a  class="btn btn-primary" onclick="refreshPage('feedbacksForm','feedbacksDiv',1);">
			<i class="glyphicon glyphicon-search"></i>
    		<span>查询</span>
		</a>
		<a  class="btn btn-info" onclick="viewFeedback();">
			<i class="glyphicon glyphicon-zoom-in"></i>
    		<span>查看</span>
		</a>
		<a  class="btn btn-primary" onclick="exportFeedbacks();">
			<i class="glyphicon glyphicon-log-out"></i>
    		<span>导出</span>
		</a>
		<#if !RequestParameters["isQuery"]?? || RequestParameters["isQuery"]=="">
		<a  class="btn btn-success" onclick="showFeedback();">
			<i class="glyphicon glyphicon-plus"></i>
    		<span>新增</span>
		</a>
		<a  class="btn btn-warning" onclick="editFeedback();">
			<i class="glyphicon glyphicon-edit"></i>
    		<span>编辑</span>
		</a>
		<a  class="btn btn-danger" onclick="deleteFeedback();">
			<i class="glyphicon glyphicon-trash"></i>
    		<span>删除</span>
		</a>
		</#if>
	</div>
	<div id="feedbacksDiv"></div>
</form>
</body>
</html>
