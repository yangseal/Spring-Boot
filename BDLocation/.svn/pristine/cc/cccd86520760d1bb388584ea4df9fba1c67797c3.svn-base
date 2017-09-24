<form id="corsApplysForm" action="${rc.contextPath}/corsApply/selectCorsApplys">
	<div class="form-inline">
		<div class="form-group has-feedback">
			<#if !RequestParameters["companyId"]?? || RequestParameters["companyId"]=="">
			<label>申请企业</label>
    		<input type="text" class="form-control" style="cursor:pointer" id="company" name="company" onclick="selectCompany();" />
    		<span class="glyphicon glyphicon-menu-hamburger form-control-feedback"></span>
    		</#if>
    		<input type="hidden" id="companyId" name="companyId" value="${RequestParameters["companyId"]!}" />
		</div>
		<div class="form-group has-feedback">
    		<label>申请日期</label>
    		<input type="text" class="form-control" style="cursor:pointer" id="minApplyDate" name="minApplyDate" onclick="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm:ss'});" />
    		<span class="glyphicon glyphicon-menu-hamburger form-control-feedback"></span>
  		</div>
  		<div class="form-group has-feedback">
    		<span>--></span>
    		<input type="text" class="form-control" style="cursor:pointer" id="maxApplyDate" name="maxApplyDate" onclick="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm:ss'});" />
    		<span class="glyphicon glyphicon-menu-hamburger form-control-feedback"></span>
  		</div>
	</div>
	<div>
		<a  class="btn btn-primary" onclick="refreshPage('corsApplysForm','corsApplysDiv',1);">
			<i class="glyphicon glyphicon-search"></i>
    		<span>查询</span>
		</a>
		<a  class="btn btn-success" onclick="selectCorsApplyOk();">
			<i class="glyphicon glyphicon-ok"></i>
    		<span>确定</span>
		</a>
		<a  class="btn btn-info" onclick="selectCorsApplyClear();">
			<i class="glyphicon glyphicon-remove"></i>
    		<span>清空</span>
		</a>
	</div>
	<div id="corsApplysDiv"></div>
</form>
<script type="text/javascript">
	refreshPage("corsApplysForm","corsApplysDiv");
	function selectCorsApplyOk(){
		var corsApplyId = getSelectedEntityId("corsApplysTable");
		if(!corsApplyId){
			myAlert("请选择CORS账号申请");
			return;
		}
		$("#"+_fkFieldCode+"Id").val(corsApplyId);
		$("#"+_fkFieldCode).val($("#corsApplysTable tr.active td:first").text());
		removeDialog();
	}
	function selectCorsApplyClear(){
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
				title : "选择申请企业",
				content : dom
			}).showModal();
		});
	}
</script>