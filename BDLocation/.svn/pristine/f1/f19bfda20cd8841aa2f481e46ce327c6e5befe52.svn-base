<form id="corsAccountsForm" action="${rc.contextPath}/corsAccount/selectCorsAccounts">
	<div class="form-inline">
		<div class="form-group has-feedback">
			<#if !RequestParameters["companyId"]?? || RequestParameters["companyId"]=="">
			<label>所属企业</label>
    		<input type="text" class="form-control" style="cursor:pointer" id="company" name="company" onclick="selectCompany();" />
    		<span class="glyphicon glyphicon-menu-hamburger form-control-feedback"></span>
    		</#if>
    		<input type="hidden" id="companyId" name="company.companyId" value="${RequestParameters["companyId"]!}" />
		</div>
		<div class="form-group">
    		<label>账号编码</label>
    		<input type="text" class="form-control" id="corsAccountCode" name="corsAccountCode" />
  		</div>
		<div class="form-group has-feedback">
			<#if !RequestParameters["oamAreaId"]?? || RequestParameters["oamAreaId"]=="">
			<label>应用区域</label>
    		<input type="text" class="form-control" style="cursor:pointer" id="oamArea" name="oamArea" onclick="selectOamArea();" />
    		<span class="glyphicon glyphicon-menu-hamburger form-control-feedback"></span>
    		</#if>
    		<input type="hidden" id="oamAreaId" name="oamArea.oamAreaId" value="${RequestParameters["oamAreaId"]!}" />
		</div>
	</div>
	<div>
		<a  class="btn btn-primary" onclick="refreshPage('corsAccountsForm','corsAccountsDiv',1);">
			<i class="glyphicon glyphicon-search"></i>
    		<span>查询</span>
		</a>
		<a  class="btn btn-success" onclick="selectCorsAccountOk();">
			<i class="glyphicon glyphicon-ok"></i>
    		<span>确定</span>
		</a>
		<a  class="btn btn-info" onclick="selectCorsAccountClear();">
			<i class="glyphicon glyphicon-remove"></i>
    		<span>清空</span>
		</a>
	</div>
	<div id="corsAccountsDiv"></div>
</form>
<script type="text/javascript">
	refreshPage("corsAccountsForm","corsAccountsDiv");
	function selectCorsAccountOk(){
		var corsAccountId = getSelectedEntityId("corsAccountsTable");
		if(!corsAccountId){
			myAlert("请选择CORS账号");
			return;
		}
		$("#"+_fkFieldCode+"Id").val(corsAccountId);
		$("#"+_fkFieldCode).val($("#corsAccountsTable tr.active td:first").text());
		removeDialog();
	}
	function selectCorsAccountClear(){
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
				title : "选择所属企业",
				content : dom
			}).showModal();
		});
	}
	function selectOamArea(){
		_fkFieldCode = "oamArea";
		var dom = $("<div/>");
		var url = CONTEXT_PATH + "/oamArea/selectOamArea";
		dom.load(url,null,function(){
			dialog({
				title : "选择应用区域",
				content : dom
			}).showModal();
		});
	}
</script>