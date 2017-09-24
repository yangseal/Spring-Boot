<form id="measurePointsForm" action="${rc.contextPath}/measurePoint/selectMeasurePoints">
	<div>
		<span>测量点名称</span>
		<input id="measurePointName" type="text" name="measurePointName" />
	</div>
	<div>
		<a  class="btn btn-primary" onclick="refreshPage('measurePointsForm','measurePointsDiv',1);">
			<i class="glyphicon glyphicon-search"></i>
    		<span>查询</span>
		</a>
		<a  class="btn btn-success" onclick="selectMeasurePointOk(this);">
			<i class="glyphicon glyphicon-ok"></i>
    		<span>确定</span>
		</a>
		<a  class="btn btn-info" onclick="selectMeasurePointClear(this);">
			<i class="glyphicon glyphicon-remove"></i>
    		<span>清空</span>
		</a>
	</div>
	<div id="measurePointsDiv"></div>
</form>
<script type="text/javascript">
	refreshPage("measurePointsForm","measurePointsDiv");
	function selectMeasurePointOk(sender){
		var measurePointId = getSelectedEntityId("measurePointsTable");
		if(!measurePointId){
			myAlert("请选择测量点");
			return;
		}
		var fk;
		var fkFieldCode = $(sender).closest("div[fkFieldCode]").attr("fkFieldCode");
		if(fkFieldCode){
			fk = fkFieldCode;
		}else{
			fk = _fkFieldCode;
		}
		$("#"+fk+"Id").val(measurePointId);
		$("#"+fk).val($("#measurePointsTable tr.active td:first").text());
		if(fkFieldCode){
			dialog.get(fkFieldCode).remove();
		}else{
			removeDialog();
		}
	}
	function selectMeasurePointClear(sender){
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