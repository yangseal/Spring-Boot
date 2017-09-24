<table id="oamProjectConstructionsTable" class="table">
	<tr>
		<th><input type="checkbox" onclick="checkAll(this);" /></th>
		<th>所属项目</th>
		<th>项目建设名称</th>
		<th>服务器1.2</th>
		<th>安装NRS</th>
		<th>安装软件狗</th>
		<th>注册NET</th>
		<th>注册SERVER</th>
		<th>配置NRS</th>
		<th>可行性验证测试</th>
		<th>精度测试</th>
		<th>WGS84</th>
		<th>地方坐标</th>
		<th>是否有已知点</th>
		<th>其它位置系统</th>
		<th>拟定测试计划</th>
		<th>测试描述</th>
		<th>解算数据</th>
		<th>出具报告</th>
		<th>是否需要召开验收会</th>
	</tr>
	<#list page.result as oamProjectConstruction>
	<tr entityId="${oamProjectConstruction.oamProjectConstructionId!}" onclick="selectEntity(this);">
		<td><input type="checkbox" /></td>
		<td><#if oamProjectConstruction.oamProject??>${oamProjectConstruction.oamProject.oamProjectName!}</#if></td>
		<td>${oamProjectConstruction.oamProjectConstructionName!}</td>
		<td><#if !oamProjectConstruction.services??><#elseif "1"==oamProjectConstruction.services>是<#elseif "0"==oamProjectConstruction.services>否</#if></td>
		<td><#if !oamProjectConstruction.nrs??><#elseif "1"==oamProjectConstruction.nrs>是<#elseif "0"==oamProjectConstruction.nrs>否</#if></td>
		<td><#if !oamProjectConstruction.software??><#elseif "1"==oamProjectConstruction.software>是<#elseif "0"==oamProjectConstruction.software>否</#if></td>
		<td><#if !oamProjectConstruction.net??><#elseif "1"==oamProjectConstruction.net>是<#elseif "0"==oamProjectConstruction.net>否</#if></td>
		<td><#if !oamProjectConstruction.server??><#elseif "1"==oamProjectConstruction.server>是<#elseif "0"==oamProjectConstruction.server>否</#if></td>
		<td><#if !oamProjectConstruction.nrsConfig??><#elseif "1"==oamProjectConstruction.nrsConfig>是<#elseif "0"==oamProjectConstruction.nrsConfig>否</#if></td>
		<td><#if !oamProjectConstruction.validTesting??><#elseif "1"==oamProjectConstruction.validTesting>是<#elseif "0"==oamProjectConstruction.validTesting>否</#if></td>
		<td><#if !oamProjectConstruction.precisionTesting??><#elseif "1"==oamProjectConstruction.precisionTesting>是<#elseif "0"==oamProjectConstruction.precisionTesting>否</#if></td>
		<td><#if !oamProjectConstruction.wgs84??><#elseif "1"==oamProjectConstruction.wgs84>是<#elseif "0"==oamProjectConstruction.wgs84>否</#if></td>
		<td><#if !oamProjectConstruction.localCoordinate??><#elseif "1"==oamProjectConstruction.localCoordinate>是<#elseif "0"==oamProjectConstruction.localCoordinate>否</#if></td>
		<td><#if !oamProjectConstruction.isUsedPoint??><#elseif "1"==oamProjectConstruction.isUsedPoint>是<#elseif "0"==oamProjectConstruction.isUsedPoint>否</#if></td>
		<td><#if !oamProjectConstruction.otherSystem??><#elseif "1"==oamProjectConstruction.otherSystem>是<#elseif "0"==oamProjectConstruction.otherSystem>否</#if></td>
		<td><#if !oamProjectConstruction.planOfTesting??><#elseif "1"==oamProjectConstruction.planOfTesting>是<#elseif "0"==oamProjectConstruction.planOfTesting>否</#if></td>
		<td>${oamProjectConstruction.testingInfo!}</td>
		<td><#if !oamProjectConstruction.resultData??><#elseif "1"==oamProjectConstruction.resultData>是<#elseif "0"==oamProjectConstruction.resultData>否</#if></td>
		<td><#if !oamProjectConstruction.resultReport??><#elseif "1"==oamProjectConstruction.resultReport>是<#elseif "0"==oamProjectConstruction.resultReport>否</#if></td>
		<td><#if !oamProjectConstruction.isMeeting??><#elseif "1"==oamProjectConstruction.isMeeting>是<#elseif "0"==oamProjectConstruction.isMeeting>否</#if></td>
	</tr>
	</#list>
</table>
<@common.pager page.pageBean "oamProjectConstructionsForm" "oamProjectConstructionsDiv"/>