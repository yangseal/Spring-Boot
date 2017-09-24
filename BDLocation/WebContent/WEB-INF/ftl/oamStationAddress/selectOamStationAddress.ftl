<form id="oamStationAddresssForm" action="${rc.contextPath}/oamStationAddress/selectOamStationAddresss">
	<div class="form-inline">
		<div class="form-group has-feedback">
			<#if !RequestParameters["oamProjectId"]?? || RequestParameters["oamProjectId"]=="">
			<label>所属项目</label>
    		<input type="text" class="form-control" style="cursor:pointer" id="oamProject" name="oamProject" onclick="selectOamProject();" />
    		<span class="glyphicon glyphicon-menu-hamburger form-control-feedback"></span>
    		</#if>
    		<input type="hidden" id="oamProjectId" name="oamProjectId" value="${RequestParameters["oamProjectId"]!}" />
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
		<a  class="btn btn-primary" onclick="refreshPage('oamStationAddresssForm','oamStationAddresssDiv',1);">
			<i class="glyphicon glyphicon-search"></i>
    		<span>查询</span>
		</a>
		<a  class="btn btn-success" onclick="selectOamStationAddressOk();">
			<i class="glyphicon glyphicon-ok"></i>
    		<span>确定</span>
		</a>
		<a  class="btn btn-info" onclick="selectOamStationAddressClear();">
			<i class="glyphicon glyphicon-remove"></i>
    		<span>清空</span>
		</a>
	</div>
	<div id="oamStationAddresssDiv"></div>
</form>
<script type="text/javascript">
	refreshPage("oamStationAddresssForm","oamStationAddresssDiv");
	function selectOamStationAddressOk(){
		var oamStationAddressId = getSelectedEntityId("oamStationAddresssTable");
		if(!oamStationAddressId){
			myAlert("请选择基站选址");
			return;
		}
		$("#"+_fkFieldCode+"Id").val(oamStationAddressId);
		$("#"+_fkFieldCode).val($("#oamStationAddresssTable tr.active td:first").text());
		removeDialog();
	}
	function selectOamStationAddressClear(){
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