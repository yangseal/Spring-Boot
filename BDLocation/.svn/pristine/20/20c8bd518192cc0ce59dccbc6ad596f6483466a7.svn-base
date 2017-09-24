<form id="oamCustomersForm" action="${rc.contextPath}/oamCustomer/selectOamCustomers">
	<div class="form-inline">
		<div class="form-group">
    		<label>客户名称</label>
    		<input type="text" class="form-control" id="oamCustomerName" name="oamCustomerName" />
  		</div>
		<div class="form-group has-feedback">
			<#if !RequestParameters["oamAreaId"]?? || RequestParameters["oamAreaId"]=="">
			<label>所属省市</label>
    		<input type="text" class="form-control" style="cursor:pointer" id="area" name="area" onclick="selectOamArea();" />
    		<span class="glyphicon glyphicon-menu-hamburger form-control-feedback"></span>
    		</#if>
    		<input type="hidden" id="areaId" name="areaId" value="${RequestParameters["oamAreaId"]!}" />
		</div>
	</div>
	<div>
		<a  class="btn btn-primary" onclick="refreshPage('oamCustomersForm','oamCustomersDiv',1);">
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
	<div id="oamCustomersDiv"></div>
</form>
<script type="text/javascript">
	refreshPage("oamCustomersForm","oamCustomersDiv");
	function selectOamCustomerOk(sender){
		var oamCustomerId = getSelectedEntityId("oamCustomersTable");
		if(!oamCustomerId){
			myAlert("请选择客户");
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
		$("#"+fk).val($("#oamCustomersTable tr.active td:first").text());
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