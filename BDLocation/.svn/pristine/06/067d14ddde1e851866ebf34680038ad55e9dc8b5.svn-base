<form id="baseCustomersForm" action="${rc.contextPath}/baseStation/selector/selectBaseCustomers">
	<div class="form-inline">
		<div class="form-group">
    		<div><label>客户名称</label></div>
    		<input type="text" class="form-control" placeholder="请输入客户名称" style="height:29px;" id="customerName" name="customerName" />
  		</div>
	<!--	<div class="form-group has-feedback hg_city">
			<label>所属省市</label>
    		<div class="city_select">
		        <div id="store-selector">
		            <div class="text" style="width:200px;"><div></div><b></b></div>                   
		            <div class="close"></div>
		        <div id="store-prompt"><strong></strong></div> 
		        <input type="hidden" location="province" class="province" value="" />
				<input type="hidden" location="city" class="city" value="" />
				<input type="hidden" location="oamAreaId" name="areaId" class="city" value="" />
		    </div>
		</div>
	</div>
	-->
	<div>
		<a  class="btn btn-primary" onclick="refreshPage('baseCustomersForm','baseCustomersDiv',1);">
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
	<div id="baseCustomersDiv"></div>
</form>
<script type="text/javascript">
	refreshPage("baseCustomersForm","baseCustomersDiv");
	Location.init(["","",0,0], $('#baseCustomersForm'));
	function selectOamCustomerOk(sender){
		var oamCustomerId = getSelectedEntityId("baseCustomersTable");
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
		$("#"+fk).val($("#baseCustomersTable tr.active td:first").text())
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