<table  width="100%" border="0" cellspacing="0" cellpadding="0" id="corsApplysTable">
	<tr>
		<th>订单号</th>
		<th>订单类型</th>
		<th>订单状态</th>
		<th>生成时间</th>
		<th>完成时间</th>
		<th>操作</th>
	</tr>
	<#list page.result as corsApply>
	<tr entityId="${corsApply.orderBussinkey!}" entityStatus='<#if corsApply.applyStatus?? && "3"==corsApply.applyStatus>true<#else>false</#if>'>
		<td>${corsApply.orderNo!}</td>
		<td><#if corsApply.orderTypeName??>${corsApply.orderTypeName}</#if></td>
		<td>${corsApply.applyStatusName!}</td>
		<td>${corsApply.busiSubmitTime!}</td>
		<td><#if corsApply.finshDate??>${corsApply.finshDate!}<#else>----</#if></td>
		<td><a onclick="orderDetail('${corsApply.orderBussinkey!}','${corsApply.orderType!}')">订单详情</td>
	</tr>
	</#list>
</table>
<@common.frontPager page.pageBean "corsApplysForm" "corsApplysDiv"/>