<form id="conversionProjectionsForm" action="${rc.contextPath}/conversionProjection/selectConversionProjections">
	<div class="form-inline">
		<div class="form-group">
    		<label>转换投影名称</label>
    		<input type="text" class="form-control" id="conversionProjectionName" name="conversionProjectionName" />
  		</div>
		<div class="form-group">
    		<label>转换投影编码</label>
    		<input type="text" class="form-control" id="conversionProjectionCode" name="conversionProjectionCode" />
  		</div>
	</div>
	<div>
		<a  class="btn btn-primary" onclick="refreshPage('conversionProjectionsForm','conversionProjectionsDiv',1);">
			<i class="glyphicon glyphicon-search"></i>
    		<span>查询</span>
		</a>
		<a  class="btn btn-success" onclick="selectConversionProjectionOk(this);">
			<i class="glyphicon glyphicon-ok"></i>
    		<span>确定</span>
		</a>
		<a  class="btn btn-info" onclick="selectConversionProjectionClear(this);">
			<i class="glyphicon glyphicon-remove"></i>
    		<span>清空</span>
		</a>
	</div>
	<div id="conversionProjectionsDiv"></div>
</form>
<script type="text/javascript">
	refreshPage("conversionProjectionsForm","conversionProjectionsDiv");
	function selectConversionProjectionOk(sender){
		var conversionProjectionId = getSelectedEntityId("conversionProjectionsTable");
		if(!conversionProjectionId){
			myAlert("请选择转换投影");
			return;
		}
		var fkFieldCode = $(sender).closest("div[fkFieldCode]").attr("fkFieldCode");
		$("#"+fkFieldCode+"Id").val(conversionProjectionId);
		$("#"+fkFieldCode).val($("#conversionProjectionsTable tr.active td:first").text());
		dialog.get(fkFieldCode).remove();
	}
	function selectConversionProjectionClear(sender){
		var fkFieldCode = $(sender).closest("div[fkFieldCode]").attr("fkFieldCode");
		$("#"+fkFieldCode+"Id").val("");
		$("#"+fkFieldCode).val("");
		dialog.get(fkFieldCode).remove();
	}
</script>