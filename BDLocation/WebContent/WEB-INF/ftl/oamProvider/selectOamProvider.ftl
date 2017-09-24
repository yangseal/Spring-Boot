<form id="oamProvidersForm" action="${rc.contextPath}/oamProvider/selectOamProviders">
	<div class="form-inline">
		<div class="form-group">
    		<label>供应商名称</label>
    		<input type="text" class="form-control" id="oamProviderName" name="oamProviderName" />
  		</div>
	</div>
	<div>
		<a  class="btn btn-primary" onclick="refreshPage('oamProvidersForm','oamProvidersDiv',1);">
			<i class="glyphicon glyphicon-search"></i>
    		<span>查询</span>
		</a>
		<a  class="btn btn-success" onclick="selectOamProviderOk();">
			<i class="glyphicon glyphicon-ok"></i>
    		<span>确定</span>
		</a>
		<a  class="btn btn-info" onclick="selectOamProviderClear();">
			<i class="glyphicon glyphicon-remove"></i>
    		<span>清空</span>
		</a>
	</div>
	<div id="oamProvidersDiv"></div>
</form>
<script type="text/javascript">
	refreshPage("oamProvidersForm","oamProvidersDiv");
	function selectOamProviderOk(){
		var oamProviderId = getSelectedEntityId("oamProvidersTable");
		if(!oamProviderId){
			myAlert("请选择供应商");
			return;
		}
		$("#"+_fkFieldCode+"Id").val(oamProviderId);
		$("#"+_fkFieldCode).val($("#oamProvidersTable tr.active td:first").text());
		removeDialog();
	}
	function selectOamProviderClear(){
		$("#"+_fkFieldCode+"Id").val("");
		$("#"+_fkFieldCode).val("");
		removeDialog();
	}
</script>