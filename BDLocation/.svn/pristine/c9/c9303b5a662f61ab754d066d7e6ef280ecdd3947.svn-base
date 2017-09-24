<form id="oamContactssForm" action="${rc.contextPath}/oamContacts/selectOamContactss">
	<div class="form-inline">
		<div class="form-group">
    		<label>联系人名称</label>
    		<input type="text" class="form-control" id="oamContactsName" name="oamContactsName" />
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
		<a  class="btn btn-primary" onclick="refreshPage('oamContactssForm','oamContactssDiv',1);">
			<i class="glyphicon glyphicon-search"></i>
    		<span>查询</span>
		</a>
		<a  class="btn btn-success" onclick="selectOamContactsOk();">
			<i class="glyphicon glyphicon-ok"></i>
    		<span>确定</span>
		</a>
		<a  class="btn btn-info" onclick="selectOamContactsClear();">
			<i class="glyphicon glyphicon-remove"></i>
    		<span>清空</span>
		</a>
	</div>
	<div id="oamContactssDiv"></div>
</form>
<script type="text/javascript">
	refreshPage("oamContactssForm","oamContactssDiv");
	function selectOamContactsOk(){
		var oamContactsId = getSelectedEntityId("oamContactssTable");
		if(!oamContactsId){
			myAlert("请选择联系人");
			return;
		}
		$("#"+_fkFieldCode+"Id").val(oamContactsId);
		$("#"+_fkFieldCode).val($("#oamContactssTable tr.active td:first").text());
		removeDialog();
	}
	function selectOamContactsClear(){
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