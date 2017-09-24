<form id="oamDeviceArchivessForm" action="${rc.contextPath}/oamDeviceArchives/selectOamDeviceArchivess">
	<div class="form-inline">
		<div class="form-group">
    		<label>设备档案标识号</label>
    		<input type="text" class="form-control" id="oamDeviceArchivesCode" name="oamDeviceArchivesCode" />
  		</div>
		<div class="form-group">
    		<label>设备档案名称</label>
    		<input type="text" class="form-control" id="oamDeviceArchivesName" name="oamDeviceArchivesName" />
  		</div>
	</div>
	<div>
		<a  class="btn btn-primary" onclick="refreshPage('oamDeviceArchivessForm','oamDeviceArchivessDiv',1);">
			<i class="glyphicon glyphicon-search"></i>
    		<span>查询</span>
		</a>
		<a  class="btn btn-success" onclick="selectOamDeviceArchivesOk();">
			<i class="glyphicon glyphicon-ok"></i>
    		<span>确定</span>
		</a>
		<a  class="btn btn-info" onclick="selectOamDeviceArchivesClear();">
			<i class="glyphicon glyphicon-remove"></i>
    		<span>清空</span>
		</a>
	</div>
	<div id="oamDeviceArchivessDiv"></div>
</form>
<script type="text/javascript">
	refreshPage("oamDeviceArchivessForm","oamDeviceArchivessDiv");
	function selectOamDeviceArchivesOk(){
		var oamDeviceArchivesId = getSelectedEntityId("oamDeviceArchivessTable");
		if(!oamDeviceArchivesId){
			myAlert("请选择北斗设备档案");
			return;
		}
		$("#"+_fkFieldCode+"Id").val(oamDeviceArchivesId);
		$("#"+_fkFieldCode).val($("#oamDeviceArchivessTable tr.active td:first").text());
		removeDialog();
	}
	function selectOamDeviceArchivesClear(){
		$("#"+_fkFieldCode+"Id").val("");
		$("#"+_fkFieldCode).val("");
		removeDialog();
	}
</script>