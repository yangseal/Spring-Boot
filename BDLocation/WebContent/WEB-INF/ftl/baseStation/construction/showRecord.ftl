 <script type="text/javascript" src="${rc.contextPath}/public/js/baseStation/baseStation.js"></script>
<div style="max-height:300px;overflow:auto;">
 <form id="constructRecordForm" class="form-horizontal">
  <input type="hidden" id="baseConstructId" name="baseConstructId" value="${baseConstruct.baseConstructId!}" />
 	<div class="form-group">
		<label id="recordNoLabel" for="recordNo"  class="col-sm-2 control-label">备案编号</label>
		<div class="col-sm-7">
			<input type="text" class="form-control" id="recordNo" name="recordNo" maxlength="6" isNotNull value="${baseConstruct.recordNo!}" />
		</div>
		<label id="recordNoTip" class="control-label" style="color:red">*</label>
	</div>
	<div class="form-group">
		<div class="form-group">
			<label id="recordAttachesLabel" for="recordAttaches" class="col-sm-2 control-label">备案附件</label>
			<div class="col-sm-9">
	      		<div id="recordAttaches" name="recordAttaches" style="border:1px solid">
	      		</div>
	      	</div>
      		<label id="recordAttachesTip" class="control-label" style="color:red"></label>
		</div>
	</div>
</form>	
</div>	
<#if !RequestParameters["isQuery"]?? || RequestParameters["isQuery"]=="">
	<div style="text-align:center">
		<a  class="btn btn-success" onclick="saveRecordInfo();">
			<i class="glyphicon glyphicon-save"></i>
			<span>保存</span>
		</a>
	</div>
</#if>