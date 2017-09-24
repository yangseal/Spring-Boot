<form id="pointTypesForm" action="${rc.contextPath}/pointType/selectPointTypes">
	<div class="form-inline">
		<div class="form-group">
    		<label>点类型名称</label>
    		<input type="text" class="form-control" id="pointTypeName" name="pointTypeName">
  		</div>
  		<div class="form-group has-feedback">
			<#if common.isSystemUser>
			<label>所属企业</label>
			<input id="company" type="text" name="company" style="cursor:pointer" onclick="selectCompany();" class="form-control" />
			<span class="glyphicon glyphicon-menu-hamburger form-control-feedback"></span>
			<input type="hidden" id="companyId" name="companyId" />				
			</#if>
		</div>
	</div>
	<div class="command-div">
		<a  class="btn btn-primary" onclick="refreshPage('pointTypesForm','pointTypesDiv',1);">
			<i class="glyphicon glyphicon-search"></i>
    		<span>查询</span>
		</a>
		<a  class="btn btn-success" onclick="selectPointTypeOk(this);">
			<i class="glyphicon glyphicon-ok"></i>
    		<span>确定</span>
		</a>
		<a  class="btn btn-info" onclick="selectPointTypeClear(this);">
			<i class="glyphicon glyphicon-remove"></i>
    		<span>清空</span>
		</a>
	</div>
	<div id="pointTypesDiv"></div>
</form>
<script type="text/javascript">
	refreshPage("pointTypesForm","pointTypesDiv");
	function selectPointTypeOk(sender){
		var pointTypeId = getSelectedEntityId("pointTypesTable");
		if(!pointTypeId){
			myAlert("请选择点类型");
			return;
		}
		var fk;
		var fkFieldCode = $(sender).closest("div[fkFieldCode]").attr("fkFieldCode");
		if(fkFieldCode){
			fk = fkFieldCode;
		}else{
			fk = _fkFieldCode;
		}
		$("#"+fk+"Id").val(pointTypeId);
		$("#"+fk).val($("#pointTypesTable tr.active td:first").text());
		if(fkFieldCode){
			dialog.get(fkFieldCode).remove();
		}else{
			removeDialog();
		}
	}
	function selectPointTypeClear(sender){
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
	function selectCompany(){
		var dom = $("<div fkFieldCode='company'/>");
		var url = CONTEXT_PATH + "/company/selectCompany";
		dom.load(url,null,function(){
			dialog({
				id:'company',
				title : "选择企业",
				content : dom
			}).showModal();
		});
	}
</script>