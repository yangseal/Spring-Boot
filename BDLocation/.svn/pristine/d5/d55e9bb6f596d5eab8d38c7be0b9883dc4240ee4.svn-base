<table id="oamContactssTable" class="table">
	<tr>
		<th><input type="checkbox" onclick="checkAll(this);" /></th>
		<th>联系人名称</th>
		<th>所属客户</th>
		<th>职务</th>
		<th>电话</th>
		<th>手机</th>
		<th>邮箱</th>
		<th>其它</th>
	</tr>
	<#list page.result as oamContacts>
	<tr entityId="${oamContacts.oamContactsId!}" onclick="selectEntity(this);">
		<td><input type="checkbox" /></td>
		<td>${oamContacts.oamContactsName!}</td>
		<td><#if oamContacts.oamCustomer??>${oamContacts.oamCustomer.oamCustomerName!}</#if></td>
		<td>${oamContacts.position!}</td>
		<td>${oamContacts.tel!}</td>
		<td>${oamContacts.phone!}</td>
		<td>${oamContacts.mail!}</td>
		<td>${oamContacts.other!}</td>
	</tr>
	</#list>
</table>
<@common.pager page.pageBean "oamContactssForm" "oamContactssDiv"/>