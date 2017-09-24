<form id="oamProjectsForm" action="${rc.contextPath}/oamProject/selectOamProjects">
	<div class="form-inline">
		<div class="form-group">
    		<label>项目名称</label>
    		<input type="text" class="form-control" id="oamProjectName" name="oamProjectName" />
  		</div>
		<div class="form-group">
    		<label>项目编号</label>
    		<input type="text" class="form-control" id="oamProjectCode" name="oamProjectCode" />
  		</div>
		<div class="form-group has-feedback">
			<#if !RequestParameters["oamCustomerId"]?? || RequestParameters["oamCustomerId"]=="">
			<label>所属客户</label>
    		<input type="text" class="form-control" style="cursor:pointer" id="oamCustomer" name="oamCustomer" onclick="selectOamCustomer();" />
    		<span class="glyphicon glyphicon-menu-hamburger form-control-feedback"></span>
    		</#if>
    		<input type="hidden" id="oamCustomerId" name="oamCustomerId" value="${RequestParameters["oamCustomerId"]!}" />
		</div>
	</div>
	<div>
		<a  class="btn btn-primary" onclick="refreshPage('oamProjectsForm','oamProjectsDiv',1);">
			<i class="glyphicon glyphicon-search"></i>
    		<span>查询</span>
		</a>
		<a  class="btn btn-success" onclick="selectOamProjectOk(this);">
			<i class="glyphicon glyphicon-ok"></i>
    		<span>确定</span>
		</a>
		<a  class="btn btn-info" onclick="selectOamProjectClear(this);">
			<i class="glyphicon glyphicon-remove"></i>
    		<span>清空</span>
		</a>
	</div>
	<div id="oamProjectsDiv"></div>
</form>
<script type="text/javascript">
	refreshPage("oamProjectsForm","oamProjectsDiv");
	function selectOamProjectOk(sender){
		var oamProjectId = getSelectedEntityId("oamProjectsTable");
		if(!oamProjectId){
			myAlert("请选择项目");
			return;
		}
		var fk;
		var fkFieldCode = $(sender).closest("div[fkFieldCode]").attr("fkFieldCode");
		if(fkFieldCode){
			fk = fkFieldCode;
		}else{
			fk = _fkFieldCode;
		}
		$("#"+fk+"Id").val(oamProjectId);
		$("#"+fk).val($("#oamProjectsTable tr.active td:first").text());
		if(fkFieldCode){
			dialog.get(fkFieldCode).remove();
		}else{
			removeDialog();
		}
	}
	function selectOamProjectClear(sender){
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
	function selectOamCustomer(){
		var dom = $("<div fkFieldCode='oamCustomer'/>");
		var url = CONTEXT_PATH + "/oamCustomer/selectOamCustomer";
		dom.load(url,null,function(){
			dialog({
				id:'oamCustomer',
				title : "选择所属客户",
				content : dom
			}).showModal();
		});
	}
</script>