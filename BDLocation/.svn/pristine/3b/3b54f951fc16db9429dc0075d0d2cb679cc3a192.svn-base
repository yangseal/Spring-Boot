<table  class="table" width="100%" border="0" cellspacing="0" cellpadding="0" id="baseCustomersTable">
	<tr>
		<th><input type="checkbox" onclick="checkAll(this);"></th>
		<th>客户名称</th>
		<th>所在区域</th>
		<th>客户地址</th>
		<th>创建时间</th>
		<th width="360px">操作</th>
	</tr>
	<#list page.result as baseCustomer>
	<tr entityId="<#if baseCustomer.baseCustomerId??>${baseCustomer.baseCustomerId}</#if>" onclick="selectEntity(this);">
       	<td><input type="checkbox" onclick="stopPropagation()"></td>
		<td><#if baseCustomer.customerName??>${baseCustomer.customerName}</#if></td>
		<td><#if baseCustomer.oamArea?? && baseCustomer.oamArea.oamAreaName??>${baseCustomer.oamArea.oamAreaName}</#if></td>
		<td><#if baseCustomer.customerAddress??>${baseCustomer.customerAddress}</#if></td>
		<td><#if baseCustomer.createTime??>${baseCustomer.createTime}</#if></td>
		<td><a style="cursor:pointer;margin:0 10px 0 25px;" onclick="cusShowContracts('${baseCustomer.baseCustomerId}')">服务合同管理</a>|<a style="cursor:pointer;margin:0 10px 0 10px;" onclick="cusShowProjects('${baseCustomer.baseCustomerId}')">基站项目管理</a>|<a style="cursor:pointer;margin-left:10px;" onclick="cusShowCustomers('${baseCustomer.baseCustomerId}')">联系人管理</a></td>
	</tr>
	</#list>
</table>
<@common.pager page.pageBean "baseCustomersForm" "baseCustomersDiv"/>