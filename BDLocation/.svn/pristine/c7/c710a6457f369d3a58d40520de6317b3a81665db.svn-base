<form id="companyTempsForm" action="${rc.contextPath}/companyTemp/selectCompanyTemps">
	<div class="form-inline">
		<div class="form-group">
    		<label>企业名称</label>
    		<input type="text" class="form-control" id="companyTempName" name="companyTempName" />
  		</div>
	</div>
	<div>
		<a  class="btn btn-primary" onclick="refreshPage('companyTempsForm','companyTempsDiv',1);">
			<i class="glyphicon glyphicon-search"></i>
    		<span>查询</span>
		</a>
		<a  class="btn btn-success" onclick="selectCompanyTempOk();">
			<i class="glyphicon glyphicon-ok"></i>
    		<span>确定</span>
		</a>
		<a  class="btn btn-info" onclick="selectCompanyTempClear();">
			<i class="glyphicon glyphicon-remove"></i>
    		<span>清空</span>
		</a>
	</div>
	<div id="companyTempsDiv"></div>
</form>
<script type="text/javascript">
	refreshPage("companyTempsForm","companyTempsDiv");
	function selectCompanyTempOk(){
		var companyTempId = getSelectedEntityId("companyTempsTable");
		if(!companyTempId){
			myAlert("请选择企业注册临时表");
			return;
		}
		$("#"+_fkFieldCode+"Id").val(companyTempId);
		$("#"+_fkFieldCode).val($("#companyTempsTable tr.active td:first").text());
		removeDialog();
	}
	function selectCompanyTempClear(){
		$("#"+_fkFieldCode+"Id").val("");
		$("#"+_fkFieldCode).val("");
		removeDialog();
	}
</script>