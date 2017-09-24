<form id="oamStationTestingsForm" action="${rc.contextPath}/oamStationTesting/selectOamStationTestings">
	<div class="form-inline">
		<div class="form-group has-feedback">
			<#if !RequestParameters["oamProjectTestingId"]?? || RequestParameters["oamProjectTestingId"]=="">
			<label>所属项目测试</label>
    		<input type="text" class="form-control" style="cursor:pointer" id="oamProjectTesting" name="oamProjectTesting" onclick="selectOamProjectTesting();" />
    		<span class="glyphicon glyphicon-menu-hamburger form-control-feedback"></span>
    		</#if>
    		<input type="hidden" id="oamProjectTestingId" name="oamProjectTestingId" value="${RequestParameters["oamProjectTestingId"]!}" />
		</div>
		<div class="form-group has-feedback">
			<#if !RequestParameters["oamBaseStationId"]?? || RequestParameters["oamBaseStationId"]=="">
			<label>基站</label>
    		<input type="text" class="form-control" style="cursor:pointer" id="oamBaseStation" name="oamBaseStation" onclick="selectOamBaseStation();" />
    		<span class="glyphicon glyphicon-menu-hamburger form-control-feedback"></span>
    		</#if>
    		<input type="hidden" id="oamBaseStationId" name="oamBaseStationId" value="${RequestParameters["oamBaseStationId"]!}" />
		</div>
	</div>
	<div>
		<a  class="btn btn-primary" onclick="refreshPage('oamStationTestingsForm','oamStationTestingsDiv',1);">
			<i class="glyphicon glyphicon-search"></i>
    		<span>查询</span>
		</a>
		<a  class="btn btn-success" onclick="selectOamStationTestingOk();">
			<i class="glyphicon glyphicon-ok"></i>
    		<span>确定</span>
		</a>
		<a  class="btn btn-info" onclick="selectOamStationTestingClear();">
			<i class="glyphicon glyphicon-remove"></i>
    		<span>清空</span>
		</a>
	</div>
	<div id="oamStationTestingsDiv"></div>
</form>
<script type="text/javascript">
	refreshPage("oamStationTestingsForm","oamStationTestingsDiv");
	function selectOamStationTestingOk(){
		var oamStationTestingId = getSelectedEntityId("oamStationTestingsTable");
		if(!oamStationTestingId){
			myAlert("请选择基站测试");
			return;
		}
		$("#"+_fkFieldCode+"Id").val(oamStationTestingId);
		$("#"+_fkFieldCode).val($("#oamStationTestingsTable tr.active td:first").text());
		removeDialog();
	}
	function selectOamStationTestingClear(){
		$("#"+_fkFieldCode+"Id").val("");
		$("#"+_fkFieldCode).val("");
		removeDialog();
	}
	function selectOamProjectTesting(){
		_fkFieldCode = "oamProjectTesting";
		var dom = $("<div/>");
		var url = CONTEXT_PATH + "/oamProjectTesting/selectOamProjectTesting";
		dom.load(url,null,function(){
			dialog({
				title : "选择所属项目测试",
				content : dom
			}).showModal();
		});
	}
	function selectOamBaseStation(){
		_fkFieldCode = "oamBaseStation";
		var dom = $("<div/>");
		var url = CONTEXT_PATH + "/oamBaseStation/selectOamBaseStation";
		dom.load(url,null,function(){
			dialog({
				title : "选择基站",
				content : dom
			}).showModal();
		});
	}
</script>