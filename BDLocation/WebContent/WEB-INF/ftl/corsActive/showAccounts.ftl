<script type="text/javascript" src="${rc.contextPath}/public/js/corsActive/actives.js"></script>
<div style="height:400px;overflow:auto;">
 <#if RequestParameters["doAction"]?? && RequestParameters["doAction"]=="ACTIVE"> <span class="btn btn-info" onclick="activeOrRepay()">账号激活</span> </#if>
	<input type="hidden" value="${corsActiveId!}" id="corsActiveId" />
	<input type="hidden" value="${corsActiveType!}" id="corsActiveType" />
<table id="corsAccountsTable" class="table">
	<tr>
		<th><input type="checkbox" onclick="checkAll(this);" /></th>
		<th>入网账号</th>
		<th>应用区域</th>
		<th>入网精度</th>
		<th>账号类型</th>
		<th>使用期限</th>
		<th>设备型号</th>
		<th>设备SN号</th>
		<th>状态</th>
	</tr>
	<#list page.result as corsActiveRel>
	<tr entityId="${corsActiveRel.corsAccountId!}" onclick="selectEntity(this);">
		<td><input name="data" type="checkbox" onclick="stopPropagation();" /></td>
		<td>${corsActiveRel.corsAccountCode!}</td>
		<td><#if corsActiveRel.oamArea?? >${corsActiveRel.oamArea!}</#if></td>
		<td>${corsActiveRel.bdDeviceAccuracyName!}</td>
		<td>${corsActiveRel.corsAccountTypeName!}</td>
		<td>${corsActiveRel.corsAccountPeriod!}<#if corsActiveRel.corsAccountType?? && corsActiveRel.corsAccountType == "test">个月<#else>年</#if></td>
		<td>${corsActiveRel.bdDevice!}</td>
		<td>${corsActiveRel.bdDeviceSn!}</td>
		<td id="corsActiveState">${(corsActiveRel.corsAccountState != "unactive")?string("已完成","未完成")}</td>
	</tr>
	</#list>
</table>
<div>