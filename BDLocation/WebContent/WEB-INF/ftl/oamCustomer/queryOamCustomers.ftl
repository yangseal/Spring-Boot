<table id="oamCustomersTable" class="table">
	<tr>
		<th><input type="checkbox" onclick="checkAll(this);" /></th>
		<th>客户名称</th>
		<th>所属省市</th>
		<th>邮编</th>
		<th>地址</th>
		<th>经度</th>
		<th>纬度</th>
	</tr>
	<#list page.result as oamCustomer>
	<tr entityId="${oamCustomer.oamCustomerId!}" onclick="selectEntity(this);">
		<td><input type="checkbox" /></td>
		<td>${oamCustomer.oamCustomerName!}</td>
		<td><#if oamCustomer.oamArea??>${oamCustomer.oamArea.oamAreaName!}</#if></td>
		<td>${oamCustomer.postcode!}</td>
		<td>${oamCustomer.address!}</td>
		<td><#if oamCustomer.longitude??>${oamCustomer.longitude?c}</#if></td>
		<td><#if oamCustomer.latitude??>${oamCustomer.latitude?c}</#if></td>
	</tr>
	</#list>
</table>
<@common.pager page.pageBean "oamCustomersForm" "oamCustomersDiv"/>