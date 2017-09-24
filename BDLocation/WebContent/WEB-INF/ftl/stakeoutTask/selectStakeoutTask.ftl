<form id="stakeoutTasksForm" action="${rc.contextPath}/stakeoutTask/selectStakeoutTasks">
	<div>
		<span>点放样任务名称</span>
		<input id="stakeoutTaskName" type="text" name="stakeoutTaskName" />
	</div>
	<div>
		<a  class="btn btn-primary" onclick="refreshPage('stakeoutTasksForm','stakeoutTasksDiv',1);">
			<i class="glyphicon glyphicon-search"></i>
    		<span>查询</span>
		</a>
		<a  class="btn btn-success" onclick="selectStakeoutTaskOk();">
			<i class="glyphicon glyphicon-ok"></i>
    		<span>确定</span>
		</a>
		<a  class="btn btn-info" onclick="selectStakeoutTaskClear();">
			<i class="glyphicon glyphicon-remove"></i>
    		<span>清空</span>
		</a>
	</div>
	<div id="stakeoutTasksDiv"></div>
</form>
<script type="text/javascript">
	refreshPage("stakeoutTasksForm","stakeoutTasksDiv");
	function selectStakeoutTaskOk(){
		var stakeoutTaskId = getSelectedEntityId("stakeoutTasksTable");
		if(!stakeoutTaskId){
			myAlert("请选择点放样任务");
			return;
		}
		$("#"+_fkFieldCode+"Id").val(stakeoutTaskId);
		$("#"+_fkFieldCode).val($("#stakeoutTasksTable tr.active td:first").text());
		removeDialog();
	}
	function selectStakeoutTaskClear(){
		$("#"+_fkFieldCode+"Id").val("");
		$("#"+_fkFieldCode).val("");
		removeDialog();
	}
</script>