<table id="oamStationTestingsTable" class="table">
	<tr>
		<th><input type="checkbox" onclick="checkAll(this);" /></th>
		<th>所属项目测试</th>
		<th>基站</th>
		<th>进场</th>
		<th>登顶</th>
		<th>布线</th>
		<th>电源</th>
		<th>网络</th>
		<th>设备保存</th>
		<th>其他沟通项目</th>
		<th>遮挡环境是否达标</th>
		<th>电磁环境是否达标</th>
		<th>连续观测开始时间</th>
		<th>连接北京服务器是否成功</th>
		<th>主机安放位置是否考察</th>
		<th>连续观测结束时间</th>
		<th>建站尺寸测量是否完成</th>
		<th>收取仪器托管人</th>
		<th>托管人联系方式</th>
		<th>数据报告是否合格</th>
		<th>网络情况是否合格</th>
		<th>电力情况是否合格</th>
	</tr>
	<#list page.result as oamStationTesting>
	<tr entityId="${oamStationTesting.oamStationTestingId!}" onclick="selectEntity(this);">
		<td><input type="checkbox" /></td>
		<td><#if oamStationTesting.oamProjectTesting??>${oamStationTesting.oamProjectTesting.oamProjectTestingName!}</#if></td>
		<td><#if oamStationTesting.oamBaseStation??>${oamStationTesting.oamBaseStation.oamBaseStationName!}</#if></td>
		<td><#if !oamStationTesting.entrance??><#elseif "1"==oamStationTesting.entrance>是<#elseif "0"==oamStationTesting.entrance>否</#if></td>
		<td><#if !oamStationTesting.summit??><#elseif "1"==oamStationTesting.summit>是<#elseif "0"==oamStationTesting.summit>否</#if></td>
		<td><#if !oamStationTesting.wiring??><#elseif "1"==oamStationTesting.wiring>是<#elseif "0"==oamStationTesting.wiring>否</#if></td>
		<td><#if !oamStationTesting.power??><#elseif "1"==oamStationTesting.power>是<#elseif "0"==oamStationTesting.power>否</#if></td>
		<td><#if !oamStationTesting.netWork??><#elseif "1"==oamStationTesting.netWork>是<#elseif "0"==oamStationTesting.netWork>否</#if></td>
		<td><#if !oamStationTesting.devSave??><#elseif "1"==oamStationTesting.devSave>是<#elseif "0"==oamStationTesting.devSave>否</#if></td>
		<td>${oamStationTesting.otherGT!}</td>
		<td><#if !oamStationTesting.shelterEffectivity??><#elseif "1"==oamStationTesting.shelterEffectivity>是<#elseif "0"==oamStationTesting.shelterEffectivity>否</#if></td>
		<td><#if !oamStationTesting.electromagneticEffectivity??><#elseif "1"==oamStationTesting.electromagneticEffectivity>是<#elseif "0"==oamStationTesting.electromagneticEffectivity>否</#if></td>
		<td>${oamStationTesting.observationStartTime!}</td>
		<td><#if !oamStationTesting.connectBJ??><#elseif "1"==oamStationTesting.connectBJ>是<#elseif "0"==oamStationTesting.connectBJ>否</#if></td>
		<td><#if !oamStationTesting.observationServices??><#elseif "1"==oamStationTesting.observationServices>是<#elseif "0"==oamStationTesting.observationServices>否</#if></td>
		<td>${oamStationTesting.observationEndTime!}</td>
		<td><#if !oamStationTesting.observationSize??><#elseif "1"==oamStationTesting.observationSize>是<#elseif "0"==oamStationTesting.observationSize>否</#if></td>
		<td>${oamStationTesting.devTrustee!}</td>
		<td>${oamStationTesting.contactsTrustee!}</td>
		<td><#if !oamStationTesting.dataReportValid??><#elseif "1"==oamStationTesting.dataReportValid>是<#elseif "0"==oamStationTesting.dataReportValid>否</#if></td>
		<td><#if !oamStationTesting.networkValid??><#elseif "1"==oamStationTesting.networkValid>是<#elseif "0"==oamStationTesting.networkValid>否</#if></td>
		<td><#if !oamStationTesting.powerValid??><#elseif "1"==oamStationTesting.powerValid>是<#elseif "0"==oamStationTesting.powerValid>否</#if></td>
	</tr>
	</#list>
</table>
<@common.pager page.pageBean "oamStationTestingsForm" "oamStationTestingsDiv"/>