<form id="menuForm" class="form-horizontal">
	<div class="form-group">
		<label id="menuNameLabel" for="menuName" class="col-sm-2 control-label">菜单名称</label>
		<div class="col-sm-9">
			<input id="menuName" name="menuName" type="text" class="form-control" value="<#if menu??>${menu.menuName!}</#if>" isNotNull />
		</div>
		<label id="menuNameTip" class="control-label" style="color:red">*</label>
	</div>
	<div class="form-group">
		<label id="menuCodeLabel" for="menuCode" class="col-sm-2 control-label">菜单编码</label>
		<div class="col-sm-9">
			<input id="menuCode" name="menuCode" type="text" class="form-control" value="<#if menu??>${menu.menuCode!}</#if>" isNotNull />
		</div>
		<label id="menuCodeTip" class="control-label" style="color:red">*</label>
	</div>
	<div class="form-group">
		<label id="actionLabel" for="action" class="col-sm-2 control-label">菜单地址</label>
		<div class="col-sm-9">
			<input id="action" name="action" type="text" class="form-control" value="<#if menu??>${menu.action!}</#if>" />
		</div>
		<label id="actionTip" class="control-label" style="color:red"></label>
	</div>
	<div class="form-group">
		<label id="menuOrderLabel" for="action" class="col-sm-2 control-label">菜单排序</label>
		<div class="col-sm-9">
			<input id="menuOrder" name="menuOrder" type="text" class="form-control" value="<#if menu??>${menu.menuOrder!}</#if>" />
		</div>
		<label id="actionTip" class="control-label" style="color:red"></label>
	</div>
	<input id="parentId" name="parentId" type="hidden" value="<#if menu??>${menu.parentId!}<#else>${RequestParameters["parentId"]!}</#if>" />
	<input id="menuId" name="menuId" type="hidden" value="<#if menu??>${menu.menuId!}</#if>" />
</form>
<div style="text-align:center">
	<a  class="btn btn-success" onclick="saveMenu();">
		<i class="glyphicon glyphicon-save"></i>
		<span>保存</span>
	</a>
</div>
