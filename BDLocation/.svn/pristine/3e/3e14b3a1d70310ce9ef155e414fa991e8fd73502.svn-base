<table id="corsApprovesTable" class="table">
	<tr>
		<th><input type="checkbox" onclick="checkAll(this);" /></th>
		<th>企业名称</th>
		<th>订单号</th>
		<th>订单类型</th>
		<th>订单状态</th>
		<th>订单生成时间</th>
		<th>订单完成时间</th>
		<th>审核状态</th>
		<th width="180px">操作</th>
	</tr>
	<#list page.result as corsApprove>
	<#if "material"!=corsApprove.busiApproveType>
	<tr entityId="${corsApprove.orderBussinkey!}" applyStatus="${corsApprove.applyStatus!}" onclick="selectEntity(this);">
		<td><input type="checkbox" onclick="stopPropagation()" /></td>
		<td>${corsApprove.companyName!}</td>
		<td>${corsApprove.orderNo!}</td>
		<td>${corsApprove.orderTypeName!}</td>
		<td>${corsApprove.applyStatusName!}</td>
		<td>${corsApprove.applyDate!}</td>
		<td><#if corsApprove.finshDate?? >${corsApprove.finshDate!}<#else>----</#if></td>
		<td>${corsApprove.applyStatusName!}</td>
		<td align="center"><a style="margin:0 10px;" onclick="showOrderDetail('${corsApprove.orderBussinkey!}','${corsApprove.orderType!}')">订单详情</a>|<#if corsApprove.applyStatus?? && "4" == corsApprove.applyStatus><a style="margin:0 10px 0 10px;" onclick="passAccount('${corsApprove.orderBussinkey!}','${corsApprove.busiApproveType!}','${corsApprove.accountType!}','${corsApprove.applyCount!}')"><#else><a style="margin:0 10px;" class="admin_gray"></#if>确认</a>|<#if corsApprove.applyStatus?? && "4" == corsApprove.applyStatus><a style="margin:0 10px" onclick="acncelAccount('${corsApprove.orderBussinkey!}');"><#else><a style="margin:0 10px;" class="admin_gray"></#if>取消</a></td>
	</tr>
	</#if>
	</#list>
</table>
<@common.pager page.pageBean "corsApprovesForm" "corsApprovesDiv"/>