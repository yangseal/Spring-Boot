<form id="dictItemsForm" action="${rc.contextPath}/dictItem/selectDictItems">
	<div>
		<input type="hidden" id="dictName" name="dictName" value="${RequestParameters["dictName"]!}" />
	</div>
	<div>
		<a  class="btn btn-primary" onclick="refreshPage('dictItemsForm','dictItemsDiv',1);">
			<i class="glyphicon glyphicon-search"></i>
    		<span>查询</span>
		</a>
		<a  class="btn btn-success" onclick="selectDictItemOk();">
			<i class="glyphicon glyphicon-ok"></i>
    		<span>确定</span>
		</a>
		<a  class="btn btn-info" onclick="selectDictItemClear();">
			<i class="glyphicon glyphicon-remove"></i>
    		<span>清空</span>
		</a>
	</div>
	<div id="dictItemsDiv"></div>
</form>
<script type="text/javascript">
	function selectDictItemOk(){
		var dictItemId = getSelectedEntityId("dictItemsTable");
		if(!dictItemId){
			myAlert("请选择字典项");
			return;
		}
		$("#"+_fkFieldCode+"Id").val(dictItemId);
		$("#"+_fkFieldCode).val($("#dictItemsTable tr.active td:last").text());
		removeDialog();
	}
	function selectDictItemClear(){
		$("#"+_fkFieldCode+"Id").val("");
		$("#"+_fkFieldCode).val("");
		removeDialog();
	}
</script>

