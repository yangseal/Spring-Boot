<form id="oamBaseStationsForm" action="${rc.contextPath}/oamBaseStation/selectOamBaseStations">
	<div class="form-inline">
		<div class="form-group has-feedback">
			<#if !RequestParameters["oamAreaId"]?? || RequestParameters["oamAreaId"]=="">
			<label>所属省市</label>
    		<input type="text" class="form-control" style="cursor:pointer" id="oamArea" name="oamArea" onclick="selectOamArea();" />
    		<span class="glyphicon glyphicon-menu-hamburger form-control-feedback"></span>
    		</#if>
    		<input type="hidden" id="oamAreaId" name="oamAreaId" value="${RequestParameters["oamAreaId"]!}" />
		</div>
	</div>
	<div>
		<a  class="btn btn-primary" onclick="refreshPage('oamBaseStationsForm','oamBaseStationsDiv',1);">
			<i class="glyphicon glyphicon-search"></i>
    		<span>查询</span>
		</a>
		<a  class="btn btn-success" onclick="selectOamBaseStationOk(this);">
			<i class="glyphicon glyphicon-ok"></i>
    		<span>确定</span>
		</a>
		<a  class="btn btn-info" onclick="selectOamBaseStationClear(this);">
			<i class="glyphicon glyphicon-remove"></i>
    		<span>清空</span>
		</a>
	</div>
	<div id="oamBaseStationsDiv"></div>
</form>
<script type="text/javascript">
	refreshPage("oamBaseStationsForm","oamBaseStationsDiv");
	function selectOamBaseStationOk(sender){
		var oamBaseStationId = getSelectedEntityId("oamBaseStationsTable");
		if(!oamBaseStationId){
			myAlert("请选择基站");
			return;
		}
		var fk;
		var fkFieldCode = $(sender).closest("div[fkFieldCode]").attr("fkFieldCode");
		if(fkFieldCode){
			fk = fkFieldCode;
		}else{
			fk = _fkFieldCode;
		}
		$("#"+fk+"Id").val(oamBaseStationId);
		$("#"+fk).val($("#oamBaseStationsTable tr.active td:first").text());
		if(fkFieldCode){
			dialog.get(fkFieldCode).remove();
		}else{
			removeDialog();
		}
	}
	function selectOamBaseStationClear(sender){
		var fk;
		var fkFieldCode = $(sender).closest("div[fkFieldCode]").attr("fkFieldCode");
		if(fkFieldCode){
			fk = fkFieldCode;
		}else{
			fk = _fkFieldCode;
		}
		$("#"+fk+"Id").val("");
		$("#"+fk).val("");
		if(fkFieldCode){
			dialog.get(fkFieldCode).remove();
		}else{
			removeDialog();
		}
	}
	function selectOamArea(){
		var dom = $("<div fkFieldCode='oamArea'/>");
		var url = CONTEXT_PATH + "/oamArea/selectOamArea";
		dom.load(url,null,function(){
			dialog({
				id:'oamArea',
				title : "选择所属地区",
				content : dom
			}).showModal();
		});
	}
</script>