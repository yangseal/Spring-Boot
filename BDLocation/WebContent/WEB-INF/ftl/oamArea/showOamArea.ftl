<form id="oamAreaForm" class="form-horizontal">
	<div class="form-group">
		<label id="oamAreaNameLabel" for="oamAreaName" class="col-sm-1 control-label">地区名称</label>
		<div class="col-sm-10">
			<input type="text" class="form-control" id="oamAreaName" name="oamAreaName" isNotNull value="<#if oamArea??>${oamArea.oamAreaName!}<#else></#if>" />
		</div>
		<label id="oamAreaNameTip" class="control-label" style="color:red">*</label>
	</div>
	<div class="form-group">
		<label id="oamAreaCodeLabel" for="oamAreaCode" class="col-sm-1 control-label">地区编码</label>
		<div class="col-sm-10">
			<input type="text" class="form-control" id="oamAreaCode" name="oamAreaCode" isNotNull value="<#if oamArea??>${oamArea.oamAreaCode!}<#else></#if>" />
		</div>
		<label id="oamAreaCodeTip" class="control-label" style="color:red">*</label>
	</div>
	<div class="form-group">
		<label id="longitudeLabel" for="longitude" class="col-sm-1 control-label">经度</label>
		<div class="col-sm-10">
			<input type="text" class="form-control" id="longitude" name="longitude" validateExp="^(\d{1,}\.?\d*)$" validateTip="经度应为数值" value="<#if oamArea?? && oamArea.longitude??>${oamArea.longitude?c}<#else></#if>" />
		</div>
		<label id="longitudeTip" class="control-label" style="color:red"></label>
	</div>
	<div class="form-group">
		<label id="latitudeLabel" for="latitude" class="col-sm-1 control-label">纬度</label>
		<div class="col-sm-10">
			<input type="text" class="form-control" id="latitude" name="latitude" validateExp="^(\d{1,}\.?\d*)$" validateTip="纬度应为数值" value="<#if oamArea?? && oamArea.latitude??>${oamArea.latitude?c}<#else></#if>" />
		</div>
		<label id="latitudeTip" class="control-label" style="color:red"></label>
	</div>
	<div class="form-group has-feedback">
		<label id="createDateLabel" for="createDate" class="col-sm-1 control-label">创建日期</label>
		<div class="col-sm-10">
			<input type="text" class="form-control" id="createDate" name="createDate" value="<#if oamArea??>${oamArea.createDate!}<#else>${.now?string("yyyy-MM-dd HH:mm:ss")}</#if>" disabled />
			<span class="glyphicon glyphicon-menu-hamburger form-control-feedback"></span>
		</div>
		<label id="createDateTip" class="control-label" style="color:red"></label>
	</div>
	<input type="hidden" id="parentId" name="parentId" value="<#if oamArea??>${oamArea.parentId!}<#else>${RequestParameters["parentId"]!}</#if>" />
	<input type="hidden" id="oamAreaId" name="oamAreaId" value="<#if oamArea??>${oamArea.oamAreaId!}</#if>" />
</form>
<div style="text-align:center">
	<a  class="btn btn-success" onclick="saveOamArea();">
		<i class="glyphicon glyphicon-save"></i>
		<span>保存</span>
	</a>
</div>
<script type="text/javascript">
</script>