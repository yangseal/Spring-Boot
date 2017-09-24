<table id="customerCaresTable" class="table">
	<tr>
		<th><input type="checkbox" onclick="checkAll(this);" /></th> 
		<th>客服编号</th>
		<th>客服名称</th>
		<th>是否在线</th>
		<th>操作</th>
	</tr>
	<#list page.result as customerCare>
	<tr entityId="<#if customerCare??>${customerCare.bdCustomerCareId!}</#if>" onclick="selectEntity(this);">
		<td><input type="checkbox" onclick="stopPropagation()" /></td>  
		<td><#if customerCare??>${customerCare.customerCareNo!}</#if></td>
		<td><#if customerCare??>${customerCare.customerCareName!}</#if></td>
		<td><#if customerCare??>${customerCare.isOnline!}</#if></td>
		<td><a onclick="clientLogin()">登陆</a></td>
	</tr>
	</#list>  
</table>
<@common.pager page.pageBean "customerCaresForm" "customerCaresDiv"/>