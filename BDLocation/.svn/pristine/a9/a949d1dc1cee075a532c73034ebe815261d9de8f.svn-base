<form id="companysForm" action="${rc.contextPath}/company/selectCompanys">
	<div class="form-inline">
		<div class="form-group">
    		<label>企业名称</label>
    		<input type="text" class="form-control" id="companyName" name="companyName">
  		</div>
	</div>
	<div class="command-div">
		<a  class="btn btn-primary" onclick="refreshPage('companysForm','companysDiv',1);">
			<i class="glyphicon glyphicon-search"></i>
    		<span>查询</span>
		</a>
		<a  class="btn btn-success" onclick="selectCompanyOk(this);">
			<i class="glyphicon glyphicon-ok"></i>
    		<span>确定</span>
		</a>
		<a  class="btn btn-info" onclick="selectCompanyClear(this);">
			<i class="glyphicon glyphicon-remove"></i>
    		<span>清空</span>
		</a>
	</div>
	<div id="companysDiv"></div>
</form>
<script type="text/javascript">
	refreshPage("companysForm","companysDiv");
	function selectCompanyOk(sender){
		var companyId = getSelectedEntityId("companysTable");
		if(!companyId){
			myAlert("请选择企业");
			return;
		}
		var fk;
		var fkFieldCode = $(sender).closest("div[fkFieldCode]").attr("fkFieldCode");
		if(fkFieldCode){
			fk = fkFieldCode;
		}else{
			fk = _fkFieldCode;
		}
		$("#"+fk+"Id").val(companyId);
		$("#"+fk).val($("#companysTable tr.active td:first").text());
		if(fkFieldCode){
			dialog.get(fkFieldCode).remove();
		}else{
			removeDialog();
		}
	}
	function selectCompanyClear(sender){
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
</script>