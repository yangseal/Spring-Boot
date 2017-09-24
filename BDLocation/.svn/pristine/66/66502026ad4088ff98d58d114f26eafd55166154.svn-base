<form id="addGroupForm" class="tc_wrap">
	<input type="hidden" id="companyGroupId" name="companyGroupId" value="<#if group??>${group.companyGroupId!}</#if>" />
	<div class="fz_group">
		<label id="groupNameLabel" for="groupName">分组名称</label>
		<input id="groupName" name="groupName" type="text" class="form-control" value="<#if group??>${group.groupName!}</#if>" isNotNull />
		<span id="groupNameTip" style="color:red">*</span>
	</div>
	<div class="fz_group">
		<label id="remarkLabel" for="remark">备注</label>
		<textArea id="remark" name="remark" type="text" class="form-control" ><#if group??>${group.remark!}</#if></textArea>
	</div>
</form>
<div class="bt_ok">
	<a onclick="saveGroup();">
		<span>保存</span>
	</a>
</div>