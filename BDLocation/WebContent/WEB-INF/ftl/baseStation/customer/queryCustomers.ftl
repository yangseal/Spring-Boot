<table  class="table" width="100%" border="0" cellspacing="0" cellpadding="0" id="customersTable">
	<tr>
		<th><input type="checkbox" onclick="checkAll(this);" /></th>
		<th>姓名</th>
		<th>职务</th>
		<th>部门</th>
		<th>联系电话</th>
		<th>手机</th>
		<th>邮箱</th>
		<th>传真</th>
	</tr>
	<#list page.result as customer>
	<tr entityId="${customer.baseCustomerUserId!}" onclick="selectEntity(this);">
		<td><input type="checkbox"  onclick="stopPropagation()" /></td>
		<td><#if customer.custUserName??>${customer.custUserName}</#if></td>
		<td><#if customer.custUserPost??>${customer.custUserPost}</#if></td>
		<td><#if customer.custUserDep??>${customer.custUserDep}</#if></td>
		<td><#if customer.custUserPhone??>${customer.custUserPhone}</#if></td>
		<td><#if customer.custUserTel??>${customer.custUserTel}</#if></td>
		<td><#if customer.custUserEmail??>${customer.custUserEmail}</#if></td>
		<td><#if customer.custUserFax??>${customer.custUserFax}</#if></td>
	</tr>
	</#list>
</table>
<@common.pager page.pageBean "customersForm" "customersDiv"/>