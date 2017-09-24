<form id="baseProvidersForm" action="${rc.contextPath}/baseStation/selector/selectBaseProviders">
	<div class="form-inline">
		<div class="form-group">
    		<label>供应商名称</label>
    		<input type="text" class="form-control" id="providerName" name="providerName" />
  		</div>
	</div>
	<div>
		<a  class="btn btn-primary" onclick="refreshPage('baseProvidersForm','baseProvidersDiv',1);">
			<i class="glyphicon glyphicon-search"></i>
    		<span>查询</span>
		</a>
		<a  class="btn btn-success" onclick="selectOamProviderOk(this);">
			<i class="glyphicon glyphicon-ok"></i>
    		<span>确定</span>
		</a>
		<a  class="btn btn-info" onclick="selectOamProviderClear(this);">
			<i class="glyphicon glyphicon-remove"></i>
    		<span>清空</span>
		</a>
	</div>
	<div id="baseProvidersDiv"></div>
</form>
<script type="text/javascript">
	refreshPage("baseProvidersForm","baseProvidersDiv");
	function selectOamProviderOk(sender){
		var oamProviderId = getSelectedEntityId("BaseProvidersTable");
		if(!oamProviderId){
			myAlert("请选择供应商");
			return;
		}
		var _fkFieldCode;
		var fkFieldCode = $(sender).closest("div[fkFieldCode]").attr("fkFieldCode");
		if(fkFieldCode){
			_fkFieldCode = fkFieldCode;
		}
		$("#"+_fkFieldCode+"Id").val(oamProviderId);
		$("#"+_fkFieldCode).val($("#BaseProvidersTable tr.active td:first").text())
						   .removeClass('isNotNull');
		if(_fkFieldCode){
			dialog.get(_fkFieldCode).remove();
		}else{
			removeDialog();
		}
	}
	function selectOamProviderClear(sender){
		var _fkFieldCode;
		var fkFieldCode = $(sender).closest("div[fkFieldCode]").attr("fkFieldCode");
		if(fkFieldCode){
			_fkFieldCode = fkFieldCode;
		}
		$("#"+_fkFieldCode+"Id").val("");
		$("#"+_fkFieldCode).val("");
		if(_fkFieldCode){
			dialog.get(_fkFieldCode).remove();
		}else{
			removeDialog();
		}
	}
</script>