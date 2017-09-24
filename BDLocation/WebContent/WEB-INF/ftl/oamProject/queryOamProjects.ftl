<table id="oamProjectsTable" class="table">
	<tr>
		<th><input type="checkbox" onclick="checkAll(this);" /></th>
		<th>项目名称</th>
		<th>项目编号</th>
		<th>所属客户</th>
		<th>记录人</th>
		<th>建站数量</th>
		<th>规划数量</th>
		<th>不间断供电</th>
		<th>准备服务器</th>
		<th>开通服务器相应端口</th>
		<th>开通远程桌面</th>
		<th>服务器维护方</th>
		<th>当地负责人员及联系方式</th>
		<th>实施人员</th>
		<th>车次或航班号</th>
	</tr>
	<#list page.result as oamProject>
	<tr entityId="${oamProject.oamProjectId!}" onclick="selectEntity(this);">
		<td><input type="checkbox" /></td>
		<td>${oamProject.oamProjectName!}</td>
		<td>${oamProject.oamProjectCode!}</td>
		<td><#if oamProject.oamCustomer??>${oamProject.oamCustomer.oamCustomerName!}</#if></td>
		<td><#if oamProject.user??>${oamProject.user.userName!}</#if></td>
		<td>${oamProject.stationNum!}</td>
		<td>${oamProject.programme!}</td>
		<td><#if !oamProject.electrification??><#elseif "1"==oamProject.electrification>是<#elseif "0"==oamProject.electrification>否</#if></td>
		<td><#if !oamProject.servers??><#elseif "1"==oamProject.servers>是<#elseif "0"==oamProject.servers>否</#if></td>
		<td>${oamProject.serversPort!}</td>
		<td><#if !oamProject.remote??><#elseif "1"==oamProject.remote>是<#elseif "0"==oamProject.remote>否</#if></td>
		<td>${oamProject.accendant!}</td>
		<td>${oamProject.localPrincipalInfo!}</td>
		<td>${oamProject.implementation!}</td>
		<td>${oamProject.trainOrFlight!}</td>
	</tr>
	</#list>
</table>
<@common.pager page.pageBean "oamProjectsForm" "oamProjectsDiv"/>