<form id="stakeoutPointsForm" action="${rc.contextPath}/stakeoutPoint/selectStakeoutPoints">
	<div>
		<span>放样点名称</span>
		<input id="stakeoutPointName" type="text" name="stakeoutPointName" />
	</div>
	<div>
		<a  class="btn btn-primary" onclick="refreshPage('stakeoutPointsForm','stakeoutPointsDiv',1);">
			<i class="glyphicon glyphicon-search"></i>
    		<span>查询</span>
		</a>
		<a  class="btn btn-success" onclick="selectStakeoutPointOk();">
			<i class="glyphicon glyphicon-ok"></i>
    		<span>确定</span>
		</a>
		<a  class="btn btn-info" onclick="selectStakeoutPointClear();">
			<i class="glyphicon glyphicon-remove"></i>
    		<span>清空</span>
		</a>
	</div>
	<div id="stakeoutPointsDiv"></div>
</form>
<script type="text/javascript">
	refreshPage("stakeoutPointsForm","stakeoutPointsDiv");
	function selectStakeoutPointOk(){
		var stakeoutPointId = getSelectedEntityId("stakeoutPointsTable");
		if(!stakeoutPointId){
			myAlert("请选择放样点");
			return;
		}
		$("#"+_fkFieldCode+"Id").val(stakeoutPointId);
		$("#"+_fkFieldCode).val($("#stakeoutPointsTable tr.active td:first").text());
		removeDialog();
	}
	function selectStakeoutPointClear(){
		$("#"+_fkFieldCode+"Id").val("");
		$("#"+_fkFieldCode).val("");
		removeDialog();
	}
</script>