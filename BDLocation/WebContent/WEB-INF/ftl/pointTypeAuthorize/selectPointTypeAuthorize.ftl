<form id="pointTypeAuthorizesForm" action="${rc.contextPath}/pointTypeAuthorize/selectPointTypeAuthorizes">
	<div>
		<span>点类型授权名称</span>
		<input id="pointTypeAuthorizeName" type="text" name="pointTypeAuthorizeName" />
	</div>
	<div>
		<a  class="btn btn-primary" onclick="refreshPage('pointTypeAuthorizesForm','pointTypeAuthorizesDiv',1);">
			<i class="glyphicon glyphicon-search"></i>
    		<span>查询</span>
		</a>
		<a  class="btn btn-success" onclick="selectPointTypeAuthorizeOk();">
			<i class="glyphicon glyphicon-ok"></i>
    		<span>确定</span>
		</a>
		<a  class="btn btn-info" onclick="selectPointTypeAuthorizeClear();">
			<i class="glyphicon glyphicon-remove"></i>
    		<span>清空</span>
		</a>
	</div>
	<div id="pointTypeAuthorizesDiv"></div>
</form>
<script type="text/javascript">
	refreshPage("pointTypeAuthorizesForm","pointTypeAuthorizesDiv");
	function selectPointTypeAuthorizeOk(){
		var pointTypeAuthorizeId = getSelectedEntityId("pointTypeAuthorizesTable");
		if(!pointTypeAuthorizeId){
			myAlert("请选择点类型授权");
			return;
		}
		$("#"+_fkFieldCode+"Id").val(pointTypeAuthorizeId);
		$("#"+_fkFieldCode).val($("#pointTypeAuthorizesTable tr.active td:first").text());
		removeDialog();
	}
	function selectPointTypeAuthorizeClear(){
		$("#"+_fkFieldCode+"Id").val("");
		$("#"+_fkFieldCode).val("");
		removeDialog();
	}
</script>