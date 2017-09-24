<form id="oamProjectTestingsForm" action="${rc.contextPath}/oamProjectTesting/selectOamProjectTestings">
	<div class="form-inline">
		<div class="form-group has-feedback">
			<#if !RequestParameters["oamProjectId"]?? || RequestParameters["oamProjectId"]=="">
			<label>所属项目</label>
    		<input type="text" class="form-control" style="cursor:pointer" id="oamProject" name="oamProject" onclick="selectOamProject();" />
    		<span class="glyphicon glyphicon-menu-hamburger form-control-feedback"></span>
    		</#if>
    		<input type="hidden" id="oamProjectId" name="oamProjectId" value="${RequestParameters["oamProjectId"]!}" />
		</div>
		<div class="form-group">
    		<label>项目测试名称</label>
    		<input type="text" class="form-control" id="oamProjectTestingName" name="oamProjectTestingName" />
  		</div>
	</div>
	<div>
		<a  class="btn btn-primary" onclick="refreshPage('oamProjectTestingsForm','oamProjectTestingsDiv',1);">
			<i class="glyphicon glyphicon-search"></i>
    		<span>查询</span>
		</a>
		<a  class="btn btn-success" onclick="selectOamProjectTestingOk();">
			<i class="glyphicon glyphicon-ok"></i>
    		<span>确定</span>
		</a>
		<a  class="btn btn-info" onclick="selectOamProjectTestingClear();">
			<i class="glyphicon glyphicon-remove"></i>
    		<span>清空</span>
		</a>
	</div>
	<div id="oamProjectTestingsDiv"></div>
</form>
<script type="text/javascript">
	refreshPage("oamProjectTestingsForm","oamProjectTestingsDiv");
	function selectOamProjectTestingOk(){
		var oamProjectTestingId = getSelectedEntityId("oamProjectTestingsTable");
		if(!oamProjectTestingId){
			myAlert("请选择项目测试");
			return;
		}
		$("#"+_fkFieldCode+"Id").val(oamProjectTestingId);
		$("#"+_fkFieldCode).val($("#oamProjectTestingsTable tr.active td:first").text());
		removeDialog();
	}
	function selectOamProjectTestingClear(){
		$("#"+_fkFieldCode+"Id").val("");
		$("#"+_fkFieldCode).val("");
		removeDialog();
	}
	function selectOamProject(){
		_fkFieldCode = "oamProject";
		var dom = $("<div/>");
		var url = CONTEXT_PATH + "/oamProject/selectOamProject";
		dom.load(url,null,function(){
			dialog({
				title : "选择所属项目",
				content : dom
			}).showModal();
		});
	}
</script>