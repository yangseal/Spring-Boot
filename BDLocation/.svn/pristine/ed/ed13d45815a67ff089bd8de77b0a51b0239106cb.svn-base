<div>
	<a  class="btn btn-success" onclick="selectConversionParamOk(this);">
		<i class="glyphicon glyphicon-ok"></i>
    	<span>确定</span>
	</a>
	<a  class="btn btn-info" onclick="selectConversionParamClear(this);">
		<i class="glyphicon glyphicon-remove"></i>
    	<span>清空</span>
	</a>
</div>
<table id="conversionParamsTable" class="table">
	<thead>
		<tr>
			<th>地区名称</th>
		</tr>
	</thead>
	<tbody>
		<#list conversionParams as conversionParam>
		<tr id="${conversionParam.conversionParamId!}" entityId="${conversionParam.conversionParamId!}" <#if conversionParam.parentId??>pid="${conversionParam.parentId}"</#if> onclick="selectEntity(this);">
			<td style="text-align:left"><span>${conversionParam.conversionParamName!}</span></td>
		</tr>
		</#list>
	</tbody>
</table>
<script type="text/javascript">
	$("#conversionParamsTable").treeTable({theme:'vsStyle',expandLevel:1});
	function selectConversionParamOk(sender){
		var conversionParamId = getSelectedEntityId("conversionParamsTable");
		if(!conversionParamId){
			myAlert("请选择转换参数");
			return;
		}
		var fkFieldCode = $(sender).closest("div[fkFieldCode]").attr("fkFieldCode");
		$("#"+fkFieldCode+"Id").val(conversionParamId);
		$("#"+fkFieldCode).val($("#conversionParamsTable tr.active td:last").text());
		dialog.get(fkFieldCode).remove();
	}
	function selectConversionParamClear(sender){
		var fkFieldCode = $(sender).closest("div[fkFieldCode]").attr("fkFieldCode");
		$("#"+fkFieldCode+"Id").val("");
		$("#"+fkFieldCode).val("");
		dialog.get(fkFieldCode).remove();
	}
</script>
