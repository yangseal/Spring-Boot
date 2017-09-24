<form id="oamAccountsForm" action="${rc.contextPath}/oamAccount/selectOamAccounts">
	<div class="form-inline">
		<div class="form-group">
    		<label>账号名称</label>
    		<input type="text" class="form-control" id="oamAccountName" name="oamAccountName" />
  		</div>
		<div class="form-group has-feedback">
			<#if !RequestParameters["oamCustomerId"]?? || RequestParameters["oamCustomerId"]=="">
			<label>所属客户</label>
    		<input type="text" class="form-control" style="cursor:pointer" id="oamCustomer" name="oamCustomer" onclick="selectOamCustomer();" />
    		<span class="glyphicon glyphicon-menu-hamburger form-control-feedback"></span>
    		</#if>
    		<input type="hidden" id="oamCustomerId" name="oamCustomerId" value="${RequestParameters["oamCustomerId"]!}" />
		</div>
	</div>
	<div>
		<a  class="btn btn-primary" onclick="refreshPage('oamAccountsForm','oamAccountsDiv',1);">
			<i class="glyphicon glyphicon-search"></i>
    		<span>查询</span>
		</a>
		<a  class="btn btn-success" onclick="selectOamAccountOk();">
			<i class="glyphicon glyphicon-ok"></i>
    		<span>确定</span>
		</a>
		<a  class="btn btn-info" onclick="selectOamAccountClear();">
			<i class="glyphicon glyphicon-remove"></i>
    		<span>清空</span>
		</a>
	</div>
	<div id="oamAccountsDiv"></div>
</form>
<script type="text/javascript">
	refreshPage("oamAccountsForm","oamAccountsDiv");
	function selectOamAccountOk(){
		var oamAccountId = getSelectedEntityId("oamAccountsTable");
		if(!oamAccountId){
			myAlert("请选择账号");
			return;
		}
		$("#"+_fkFieldCode+"Id").val(oamAccountId);
		$("#"+_fkFieldCode).val($("#oamAccountsTable tr.active td:first").text());
		removeDialog();
	}
	function selectOamAccountClear(){
		$("#"+_fkFieldCode+"Id").val("");
		$("#"+_fkFieldCode).val("");
		removeDialog();
	}
	function selectOamCustomer(){
		_fkFieldCode = "oamCustomer";
		var dom = $("<div/>");
		var url = CONTEXT_PATH + "/oamCustomer/selectOamCustomer";
		dom.load(url,null,function(){
			dialog({
				title : "选择所属客户",
				content : dom
			}).showModal();
		});
	}
</script>