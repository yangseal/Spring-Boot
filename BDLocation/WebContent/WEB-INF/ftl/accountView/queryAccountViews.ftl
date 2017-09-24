<table  width="100%" border="0" cellspacing="0" cellpadding="0" id="showAccountsForm">
	<tr>
		<th width="85">服务类型</th>
        <th width="85">入网账号</th>
        <th width="85">账号类型</th>
        <th width="85">账号状态</th>
        <th width="*">到期时间</th>
        <th width="250">操作</th>
        <th width="120">操作阶段</th>
        <th width="90">详情</th>
	</tr>
	<#list page.result as corsAccount>
	<tr name="corsAccountTr" isMaterialWS="<#if corsAccount.company?? && corsAccount.company.companyMaterialState??>${corsAccount.company.companyMaterialState!}</#if>"
		isBindDevice="<#if corsAccount.bdDevice?? && corsAccount.bdDevice!="" && corsAccount.bdDeviceSn?? && corsAccount.bdDeviceSn!="">1<#else>0</#if>"
		isBindRegion="<#if corsAccount.oamArea?? && corsAccount.oamArea.oamAreaId?? && corsAccount.oamArea.oamAreaId!="">1<#else>0</#if>"
		accountStatus="<#if corsAccount.corsAccountState??>${corsAccount.corsAccountState!}</#if>"
		>
		<input type="hidden" id="corsAccountId" value="<#if corsAccount.corsAccountId??>${corsAccount.corsAccountId!}</#if>"/>
		<td><#if corsAccount.bdDeviceAccuracyName??>${corsAccount.bdDeviceAccuracyName!}</#if></td>
		<td><#if corsAccount.corsAccountCode??>${corsAccount.corsAccountCode!}</#if></td>
		<td><#if corsAccount.corsAccountTypeName??>${corsAccount.corsAccountTypeName!}</#if></td>
		<td><#if corsAccount.corsAccountStateName??>${corsAccount.corsAccountStateName!}</#if></td>
		<td><#if corsAccount.exprieDate??>${corsAccount.exprieDate!}<#else>---</#if></td>
		<#if corsAccount.corsAccountState?? && corsAccount.corsAccountState == "unactive">
			<#if corsAccount.corsAccountStage?? && corsAccount.corsAccountStage == "AQ">
			<td><a class="bt_gray">区域划分</a><a class="bt_gray">设备绑定</a><a class="bt_gray">激活</a><a class="bt_gray">续费</a></td>
			<#else>
			<td><a onclick="bindRegion(this)">区域划分</a><a onclick="bindDevice(this)">设备绑定</a><a onclick="onActive(this)">激活</a><a class="bt_gray">续费</a></td>
			</#if>
		<#elseif corsAccount.corsAccountState?? && (corsAccount.corsAccountState == "normal" || corsAccount.corsAccountState == "soon" || corsAccount.corsAccountState == "expired")>
			<#if corsAccount.corsAccountStage?? && (corsAccount.corsAccountStage == "RR" || corsAccount.corsAccountStage == "RU")>
			<td><a class="bt_gray">区域划分</a><a class="bt_gray">设备绑定</a><a class="bt_gray">激活</a><a class="bt_gray">续费</a></td> 
			<#else>
			<td><a class="bt_gray">区域划分</a><a class="bt_gray">设备绑定</a><a class="bt_gray">激活</a><a onclick="onRepay(this)">续费</a></td>
			</#if>
		<#else>
			<td><a onclick="bindRegion(this)">区域划分</a><a onclick="bindDevice(this)">设备绑定</a><a onclick="onActive(this)">激活</a><a onclick="onRepay(this)">续费</a></td>	
		</#if>
		<td><#if corsAccount.corsAccountStageName??>${corsAccount.corsAccountStageName!}</#if></td>
		<td><a onclick="corsAccountDetail('<#if corsAccount.corsAccountId??>${corsAccount.corsAccountId!}</#if>')">账号详情</a></td>
	</tr>
	</#list>
</table>
<@common.frontPager page.pageBean "showAccountsForm" "showAccountsDiv"/>