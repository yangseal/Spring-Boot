<form id="feedbacksForm" action="${rc.contextPath}/feedback/selectFeedbacks">
	<div class="form-inline">
		<div class="form-group has-feedback">
			<#if !RequestParameters["companyId"]?? || RequestParameters["companyId"]=="">
			<label>反馈企业</label>
    		<input type="text" class="form-control" style="cursor:pointer" id="company" name="company" onclick="selectCompany();" />
    		<span class="glyphicon glyphicon-menu-hamburger form-control-feedback"></span>
    		</#if>
    		<input type="hidden" id="companyId" name="company.companyId" value="${RequestParameters["companyId"]!}" />
		</div>
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
	<div>
		<a  class="btn btn-primary" onclick="refreshPage('feedbacksForm','feedbacksDiv',1);">
			<i class="glyphicon glyphicon-search"></i>
    		<span>查询</span>
		</a>
		<a  class="btn btn-success" onclick="selectFeedbackOk();">
			<i class="glyphicon glyphicon-ok"></i>
    		<span>确定</span>
		</a>
		<a  class="btn btn-info" onclick="selectFeedbackClear();">
			<i class="glyphicon glyphicon-remove"></i>
    		<span>清空</span>
		</a>
	</div>
	<div id="feedbacksDiv"></div>
</form>
<script type="text/javascript">
	refreshPage("feedbacksForm","feedbacksDiv");
	function selectFeedbackOk(){
		var feedbackId = getSelectedEntityId("feedbacksTable");
		if(!feedbackId){
			myAlert("请选择信息反馈");
			return;
		}
		$("#"+_fkFieldCode+"Id").val(feedbackId);
		$("#"+_fkFieldCode).val($("#feedbacksTable tr.active td:first").text());
		removeDialog();
	}
	function selectFeedbackClear(){
		$("#"+_fkFieldCode+"Id").val("");
		$("#"+_fkFieldCode).val("");
		removeDialog();
	}
	function selectCompany(){
		_fkFieldCode = "company";
		var dom = $("<div/>");
		var url = CONTEXT_PATH + "/company/selectCompany";
		dom.load(url,null,function(){
			dialog({
				title : "选择反馈企业",
				content : dom
			}).showModal();
		});
	}
</script>