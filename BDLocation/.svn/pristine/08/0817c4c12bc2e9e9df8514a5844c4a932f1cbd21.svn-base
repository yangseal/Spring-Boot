<table id="oamStationConstructionsTable" class="table">
	<tr>
		<th><input type="checkbox" onclick="checkAll(this);" /></th>
		<th>项目建设</th>
		<th>基站</th>
		<th>安装天线</th>
		<th>布设线缆</th>
		<th>布置机房</th>
		<th>安装主机</th>
		<th>数据上发</th>
		<th>位置上发</th>
		<th>主机注册</th>
		<th>观测开始时间</th>
		<th>观测结束时间</th>
	</tr>
	<#list page.result as oamStationConstruction>
	<tr entityId="${oamStationConstruction.oamStationConstructionId!}" onclick="selectEntity(this);">
		<td><input type="checkbox" /></td>
		<td><#if oamStationConstruction.oamProjectConstruction??>${oamStationConstruction.oamProjectConstruction.oamProjectConstructionName!}</#if></td>
		<td><#if oamStationConstruction.oamBaseStation??>${oamStationConstruction.oamBaseStation.oamBaseStationName!}</#if></td>
		<td><#if !oamStationConstruction.installAntenna??><#elseif "1"==oamStationConstruction.installAntenna>是<#elseif "0"==oamStationConstruction.installAntenna>否</#if></td>
		<td><#if !oamStationConstruction.installwiring??><#elseif "1"==oamStationConstruction.installwiring>是<#elseif "0"==oamStationConstruction.installwiring>否</#if></td>
		<td><#if !oamStationConstruction.mainframeRoom??><#elseif "1"==oamStationConstruction.mainframeRoom>是<#elseif "0"==oamStationConstruction.mainframeRoom>否</#if></td>
		<td><#if !oamStationConstruction.installMainframe??><#elseif "1"==oamStationConstruction.installMainframe>是<#elseif "0"==oamStationConstruction.installMainframe>否</#if></td>
		<td><#if !oamStationConstruction.updateData??><#elseif "1"==oamStationConstruction.updateData>是<#elseif "0"==oamStationConstruction.updateData>否</#if></td>
		<td><#if !oamStationConstruction.updatePosition??><#elseif "1"==oamStationConstruction.updatePosition>是<#elseif "0"==oamStationConstruction.updatePosition>否</#if></td>
		<td><#if !oamStationConstruction.mainframeRegiter??><#elseif "1"==oamStationConstruction.mainframeRegiter>是<#elseif "0"==oamStationConstruction.mainframeRegiter>否</#if></td>
		<td>${oamStationConstruction.observationStartTime!}</td>
		<td>${oamStationConstruction.observationEndTime!}</td>
	</tr>
	</#list>
</table>
<@common.pager page.pageBean "oamStationConstructionsForm" "oamStationConstructionsDiv"/>