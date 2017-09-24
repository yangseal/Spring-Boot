<table id="baseProviderTable" class="table">
	<tr>
		<th><input type="checkbox" onclick="checkAll(this);" /></th>
		<th>供应商名称</th>
		<th>所在区域</th>
		<th>供应商地址</th>
		<th>创建时间</th>
		<th width="180px">操作</th>
	</tr>
	<#list page.result as baseProvider>
	<tr entityId="${baseProvider.baseProviderId!}" onclick="selectEntity(this);">
		<td><input type="checkbox" onclick="stopPropagation()"/></td>
		<td><#if baseProvider.providerName??>${baseProvider.providerName!}</#if></td>
		<td><#if baseProvider.oamArea??>${baseProvider.oamArea.oamAreaName!}</#if></td>
		<td><#if baseProvider.providerAddress??>${baseProvider.providerAddress!}</#if></td>
		<td><#if baseProvider.providerCreateDate??>${baseProvider.providerCreateDate!}</#if></td>
		<td><a style="cursor:pointer;margin:0 10px 0 25px;" onclick="toProContract('${baseProvider.baseProviderId!}')">基建合同</a>|<a style="margin-left:10px;cursor:pointer" onclick="toProviderUsers('${baseProvider.baseProviderId!}')">联系人</a></td>
	</tr>
	</#list>
</table>
<@common.pager page.pageBean "baseProviderForm" "baseProviderDiv"/>