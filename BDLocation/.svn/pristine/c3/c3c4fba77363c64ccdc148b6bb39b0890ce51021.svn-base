<table id="oamStationAddresssTable" class="table">
	<tr>
		<th><input type="checkbox" onclick="checkAll(this);" /></th>
		<th>所属项目</th>
		<th>基站</th>
		<th>地址</th>
		<th>联系人</th>
		<th>联系方式</th>
		<th>遮挡物及程度</th>
		<th>干扰源及程度</th>
		<th>不间断供电220V</th>
		<th>不间断网络</th>
		<th>外网</th>
		<th>独占带宽大于2M</th>
		<th>固定IP情况及说明</th>
		<th>ADSL</th>
		<th>光纤</th>
		<th>交换机</th>
		<th>路由器</th>
		<th>其它网络类别</th>
		<th>公共避雷</th>
		<th>避雷针</th>
		<th>避雷网</th>
		<th>其它避雷设施</th>
		<th>平整天台</th>
		<th>斜面钢板屋顶</th>
		<th>是否有防水层</th>
	</tr>
	<#list page.result as oamStationAddress>
	<tr entityId="${oamStationAddress.oamStationAddressId!}" onclick="selectEntity(this);">
		<td><input type="checkbox" /></td>
		<td><#if oamStationAddress.oamProject??>${oamStationAddress.oamProject.oamProjectName!}</#if></td>
		<td><#if oamStationAddress.oamBaseStation??>${oamStationAddress.oamBaseStation.oamBaseStationName!}</#if></td>
		<td>${oamStationAddress.address!}</td>
		<td>${oamStationAddress.contacts!}</td>
		<td>${oamStationAddress.contact!}</td>
		<td>${oamStationAddress.shelterInfo!}</td>
		<td>${oamStationAddress.interferenceInfo!}</td>
		<td><#if !oamStationAddress.electrification220??><#elseif "1"==oamStationAddress.electrification220>是<#elseif "0"==oamStationAddress.electrification220>否</#if></td>
		<td><#if !oamStationAddress.electrification??><#elseif "1"==oamStationAddress.electrification>是<#elseif "0"==oamStationAddress.electrification>否</#if></td>
		<td><#if !oamStationAddress.wAN??><#elseif "1"==oamStationAddress.wAN>是<#elseif "0"==oamStationAddress.wAN>否</#if></td>
		<td><#if !oamStationAddress.out2M??><#elseif "1"==oamStationAddress.out2M>是<#elseif "0"==oamStationAddress.out2M>否</#if></td>
		<td>${oamStationAddress.ipInfo!}</td>
		<td><#if !oamStationAddress.aDSL??><#elseif "1"==oamStationAddress.aDSL>是<#elseif "0"==oamStationAddress.aDSL>否</#if></td>
		<td><#if !oamStationAddress.opticalFiber??><#elseif "1"==oamStationAddress.opticalFiber>是<#elseif "0"==oamStationAddress.opticalFiber>否</#if></td>
		<td><#if !oamStationAddress.interchanger??><#elseif "1"==oamStationAddress.interchanger>是<#elseif "0"==oamStationAddress.interchanger>否</#if></td>
		<td><#if !oamStationAddress.router??><#elseif "1"==oamStationAddress.router>是<#elseif "0"==oamStationAddress.router>否</#if></td>
		<td>${oamStationAddress.otherNetwork!}</td>
		<td><#if !oamStationAddress.lightningShielding??><#elseif "1"==oamStationAddress.lightningShielding>是<#elseif "0"==oamStationAddress.lightningShielding>否</#if></td>
		<td><#if !oamStationAddress.lightningArrester??><#elseif "1"==oamStationAddress.lightningArrester>是<#elseif "0"==oamStationAddress.lightningArrester>否</#if></td>
		<td><#if !oamStationAddress.lightningNetWork??><#elseif "1"==oamStationAddress.lightningNetWork>是<#elseif "0"==oamStationAddress.lightningNetWork>否</#if></td>
		<td>${oamStationAddress.otherArrester!}</td>
		<td><#if !oamStationAddress.smoothRoof??><#elseif "1"==oamStationAddress.smoothRoof>是<#elseif "0"==oamStationAddress.smoothRoof>否</#if></td>
		<td><#if !oamStationAddress.nickelcladRoof??><#elseif "1"==oamStationAddress.nickelcladRoof>是<#elseif "0"==oamStationAddress.nickelcladRoof>否</#if></td>
		<td><#if !oamStationAddress.usedWaterproofer??><#elseif "1"==oamStationAddress.usedWaterproofer>是<#elseif "0"==oamStationAddress.usedWaterproofer>否</#if></td>	</tr>
	</#list>
</table>
<@common.pager page.pageBean "oamStationAddresssForm" "oamStationAddresssDiv"/>