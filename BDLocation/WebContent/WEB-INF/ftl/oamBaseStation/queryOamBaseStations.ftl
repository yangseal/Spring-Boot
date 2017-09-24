<table id="oamBaseStationsTable" class="table">
	<tr>
		<th><input type="checkbox" onclick="checkAll(this);" /></th>
		<th>所属地区</th>
		<th>所属项目</th>
		<th>基站名称</th>
		<th>基站简称</th>
		<th>基站编号</th>
		<th>南方测绘编号</th>
		<th>建设阶段</th>
		<th>是否有效</th>
		<th>经度</th>
		<th>纬度</th>
		<th>状态</th>
	</tr>
	<#list page.result as oamBaseStation>
	<tr entityId="${oamBaseStation.oamBaseStationId!}" onclick="selectEntity(this);">
		<td><input type="checkbox" /></td>
		<td><#if oamBaseStation.oamArea??>${oamBaseStation.oamArea.oamAreaName!}</#if></td>
		<td><#if oamBaseStation.oamProject??>${oamBaseStation.oamProject.oamProjectName!}</#if></td>
		<td>${oamBaseStation.oamBaseStationName!}</td>
		<td>${oamBaseStation.shortName!}</td>
		<td>${oamBaseStation.oamBaseStationCode!}</td>
		<td>${oamBaseStation.nfCode!}</td>
		<td><#if !oamBaseStation.buildStage??><#elseif "1"==oamBaseStation.buildStage>已完成<#elseif "0"==oamBaseStation.buildStage>建设中</#if></td>
		<td><#if !oamBaseStation.isEffectivity??><#elseif "1"==oamBaseStation.isEffectivity>是<#elseif "0"==oamBaseStation.isEffectivity>否</#if></td>
		<td><#if oamBaseStation.longitude??>${oamBaseStation.longitude?c}</#if></td>
		<td><#if oamBaseStation.latitude??>${oamBaseStation.latitude?c}</#if></td>
		<td><#if !oamBaseStation.state??><#elseif "1"==oamBaseStation.state>是<#elseif "0"==oamBaseStation.state>否</#if></td>
	</tr>
	</#list>
</table>
<@common.pager page.pageBean "oamBaseStationsForm" "oamBaseStationsDiv"/>