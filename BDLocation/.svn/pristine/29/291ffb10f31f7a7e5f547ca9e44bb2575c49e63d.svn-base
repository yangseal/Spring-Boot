<form id="baseContractsForm" action="${rc.contextPath}/baseStation/selector/selectCustomerContracts">
<input type="hidden" name="baseCustomer.baseCustomerId" value="<#if baseCustomerId??>${baseCustomerId!}</#if>" />
	<div class="form-inline">
		<div class="form-group">
    		<label>合同名称</label>
    		<input type="text" class="form-control" id="custContractName" name="custContractName" />
  		</div>
  		<div class="form-group">
    		<label>合同编号</label>
    		<input type="text" class="form-control" id="custContractNo" name="custContractNo" />
  		</div>
	</div>
	<div>
		<a  class="btn btn-primary" onclick="refreshPage('baseContractsForm','baseContractsDiv',1);">
			<i class="glyphicon glyphicon-search"></i>
    		<span>查询</span>
		</a>
		<a  class="btn btn-success" onclick="selectOamCustomerOk(this);">
			<i class="glyphicon glyphicon-ok"></i>
    		<span>确定</span>
		</a>
		<a  class="btn btn-info" onclick="selectOamCustomerClear(this);">
			<i class="glyphicon glyphicon-remove"></i>
    		<span>清空</span>
		</a>
	</div>
	<div id="baseContractsDiv"></div>
</form>
<script type="text/javascript">
	refreshPage("baseContractsForm","baseContractsDiv");
	Location.init(["","",0,0], $('#baseContractsForm'));
	function selectOamCustomerOk(sender){
	debugger;
		var oamCustomerId = getSelectedEntityId("baseContractsTable");
		if(!oamCustomerId){
			myAlert("请选择合同！");
			return;
		}
		var fk;
		var fkFieldCode = $(sender).closest("div[fkFieldCode]").attr("fkFieldCode");
		if(fkFieldCode){
			fk = fkFieldCode;
		}else{
			fk = _fkFieldCode;
		}
		
		$("#"+fk+"Id").val(oamCustomerId);
		$("#"+fk).val($("#baseContractsTable tr.active td:first").text())
				 .removeClass('isNotNull');
		if(fkFieldCode){
			dialog.get(fkFieldCode).remove();
		}else{
			removeDialog();
		}
	}
	function selectOamCustomerClear(sender){
		var fk;
		var fkFieldCode = $(sender).closest("div[fkFieldCode]").attr("fkFieldCode");
		if(fkFieldCode){
			fk = fkFieldCode;
		}else{
			fk = _fkFieldCode;
		}
		$("#"+fk+"Id").val("");
		$("#"+fk).val("");
		if(fkFieldCode){
			dialog.get(fkFieldCode).remove();
		}else{
			removeDialog();
		}
	}
	function selectOamArea(){
		var dom = $("<div fkFieldCode='area'/>");
		var url = CONTEXT_PATH + "/oamArea/selectOamArea";
		dom.load(url,null,function(){
			dialog({
				id:'area',
				title : "选择所属省市",
				content : dom
			}).showModal();
		});
	}
</script>