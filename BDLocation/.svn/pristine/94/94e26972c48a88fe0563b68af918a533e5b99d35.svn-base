<#--
<table  width="100%" border="0" cellspacing="0" cellpadding="0" id="corsApplysTable">
	<tr>
		<th>订单号</th>
		<th>服务类型</th>
		<th>账号类型</th>
		<th>服务时长</th>
		<th>订单状态</th>
		<th>创建时间</th>
		<th>订单详情</th>
	</tr>
	<#list page.result as corsApply>
	<tr entityId="${corsApply.corsApplyId!}" entityStatus='<#if corsApply.applyStatus?? && "3"==corsApply.applyStatus>true<#else>false</#if>'>
		<td>${corsApply.corsApplyId!}</td>
		<td>${corsApply.bdDeviceAccuracy!}</td>
		<td>${corsApply.accountType!}</td>
		<td>${corsApply.accountUsePeriod!}</td>
		<td>${corsApply.applyStatus}</td>
		<td>${corsApply.applyDate}</td>
		<td><a onclick="">区域</a>|<a onclick="">绑定</a>|<a onclick="">激活</a></td>
	</tr>
	</#list>
</table>
<@common.pager page.pageBean "corsApplysForm" "corsApplysDiv"/>-->