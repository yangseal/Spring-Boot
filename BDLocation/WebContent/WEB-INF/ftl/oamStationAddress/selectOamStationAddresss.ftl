<table id="oamStationAddresssTable" class="table">
	<tr>
		<th>基站选址名称</th>
	</tr>
	<#list page.result as oamStationAddress>
	<tr entityId="${oamStationAddress.oamStationAddressId!}" onclick="selectEntity(this);">
		<td>${oamStationAddress.oamStationAddressName!}</td>
	</tr>
	</#list>
</table>
<@common.pager page.pageBean "oamStationAddresssForm" "oamStationAddresssDiv"/>