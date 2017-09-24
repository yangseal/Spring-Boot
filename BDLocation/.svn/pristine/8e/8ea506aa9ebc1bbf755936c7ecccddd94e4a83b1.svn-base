<form id="baseProjectsForm" action="${rc.contextPath}/baseStation/selector/selectBaseProjects">
	<div class="form-inline">
		<div class="form-group">
    		<label>项目名称</label>
    		<input type="text" class="form-control" id="oamProjectName" name="baseProjectName" />
  		</div>
		<div class="form-group">
    		<label>项目编号</label>
    		<input type="text" class="form-control" id="oamProjectCode" name="projectNo" />
  		</div>
		<div class="form-group has-feedback">
			<#if !RequestParameters["baseCustomerId"]?? || RequestParameters["baseCustomerId"]=="">
			<label>所属客户</label>
    		<input type="text" class="form-control" style="cursor:pointer" id="baseCustomer" name="baseCustomer" onclick="selectBaseCustomer();" />
    		<span class="glyphicon glyphicon-menu-hamburger form-control-feedback"></span>
    		</#if>
    		<input type="hidden" id="baseCustomerId" name="baseCustomerId" value="${RequestParameters["baseCustomerId"]!}" />
		</div>
	</div>
	<div>
		<a  class="btn btn-primary" onclick="refreshPage('baseProjectsForm','baseProjectsDiv',1);">
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
	<div id="baseProjectsDiv"></div>
</form>
<script type="text/javascript">
	refreshPage("baseProjectsForm","baseProjectsDiv");
	function selectOamProjectOk(sender){
	debugger;
		var oamProjectId = getSelectedEntityId("baseProjectsTable");
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
		$("#"+fk).val($("#baseProjectsTable tr.active td:first").text())
				 .removeClass('isNotNull');
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