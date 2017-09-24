<table id="oamContactssTable" class="table">
	<tr>
		<th>联系人名称</th>
	</tr>
	<#list page.result as oamContacts>
	<tr entityId="${oamContacts.oamContactsId!}" onclick="selectEntity(this);">
		<td>${oamContacts.oamContactsName!}</td>
	</tr>
	</#list>
</table>
<@common.pager page.pageBean "oamContactssForm" "oamContactssDiv"/>