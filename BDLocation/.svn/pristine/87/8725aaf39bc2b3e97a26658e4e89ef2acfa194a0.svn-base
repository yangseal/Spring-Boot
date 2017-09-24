<form id="measureProjectsForm" action="${rc.contextPath}/measureProject/selectMeasureProjects">
	<div>
		<span>测量工程名称</span>
		<input id="measureProjectName" type="text" name="measureProjectName" />
	</div>
	<div>
		<a  class="btn btn-primary" onclick="refreshPage('measureProjectsForm','measureProjectsDiv',1);">
			<i class="glyphicon glyphicon-search"></i>
    		<span>查询</span>
		</a>
		<a  class="btn btn-success" onclick="selectMeasureProjectOk(this);">
			<i class="glyphicon glyphicon-ok"></i>
    		<span>确定</span>
		</a>
		<a  class="btn btn-info" onclick="selectMeasureProjectClear(this);">
			<i class="glyphicon glyphicon-remove"></i>
    		<span>清空</span>
		</a>
	</div>
	<div id="measureProjectsDiv"></div>
</form>
<script type="text/javascript">
	refreshPage("measureProjectsForm","measureProjectsDiv");
	function selectMeasureProjectOk(sender){
		var measureProjectId = getSelectedEntityId("measureProjectsTable");
		if(!measureProjectId){
			myAlert("请选择测量工程");
			return;
		}
		var fk;
		var fkFieldCode = $(sender).closest("div[fkFieldCode]").attr("fkFieldCode");
		if(fkFieldCode){
			fk = fkFieldCode;
		}else{
			fk = _fkFieldCode;
		}
		$("#"+fk+"Id").val(measureProjectId);
		$("#"+fk).val($("#measureProjectsTable tr.active td:first").text());
		if(fkFieldCode){
			dialog.get(fkFieldCode).remove();
		}else{
			removeDialog();
		}
	}
	function selectMeasureProjectClear(sender){
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