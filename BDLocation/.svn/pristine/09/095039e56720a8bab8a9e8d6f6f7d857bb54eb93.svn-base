<form id="oamStationConstructionsForm" action="${rc.contextPath}/oamStationConstruction/selectOamStationConstructions">
	<div class="form-inline">
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
		<a  class="btn btn-primary" onclick="refreshPage('oamStationConstructionsForm','oamStationConstructionsDiv',1);">
			<i class="glyphicon glyphicon-search"></i>
    		<span>查询</span>
		</a>
		<a  class="btn btn-success" onclick="selectOamStationConstructionOk();">
			<i class="glyphicon glyphicon-ok"></i>
    		<span>确定</span>
		</a>
		<a  class="btn btn-info" onclick="selectOamStationConstructionClear();">
			<i class="glyphicon glyphicon-remove"></i>
    		<span>清空</span>
		</a>
	</div>
	<div id="oamStationConstructionsDiv"></div>
</form>
<script type="text/javascript">
	refreshPage("oamStationConstructionsForm","oamStationConstructionsDiv");
	function selectOamStationConstructionOk(){
		var oamStationConstructionId = getSelectedEntityId("oamStationConstructionsTable");
		if(!oamStationConstructionId){
			myAlert("请选择基站建设");
			return;
		}
		$("#"+_fkFieldCode+"Id").val(oamStationConstructionId);
		$("#"+_fkFieldCode).val($("#oamStationConstructionsTable tr.active td:first").text());
		removeDialog();
	}
	function selectOamStationConstructionClear(){
		$("#"+_fkFieldCode+"Id").val("");
		$("#"+_fkFieldCode).val("");
		removeDialog();
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