<table id="corsRepaysTable" class="table">
	<tr>
		<th><input type="checkbox" onclick="checkAll(this);" /></th> 
		<th>企业名称</th>
		<th>订单号</th>
		<th>订单类型</th>
		<th>订单状态</th>
		<th>订单生成时间</th>
		<th>完成时间</th>
		<th>操作状态</th>
		<th>操作</th>
	</tr>
	<#list page.result as corsRepay>
	<tr entityId="<#if corsRepay??>${corsRepay.accountRepayId!}</#if>" onclick="selectEntity(this);">
		<td><input type="checkbox" onclick="stopPropagation()" /></td>  
		<td><#if corsRepay?? && corsRepay.company??>${corsRepay.company.companyName!}</#if></td>
		<td><#if corsRepay??>${corsRepay.orderNo!}</#if></td>
		<td><#if corsRepay??>${corsRepay.orderTypeName!}</#if></td>
		<td><#if corsRepay??>${corsRepay.accountRepayStateName!}</#if></td>
		<td><#if corsRepay??>${corsRepay.accountRepayTime!}</#if></td>
		<td><#if corsRepay??>${corsRepay.repayFinshDate!}</#if></td>
		<td><#if corsRepay??>${corsRepay.repayActiveStateName!}</#if></td>
		<td><#if corsRepay.repayActiveState?? && "0" = corsRepay.repayActiveState><a style="margin:0 10px;" href="javascript:void(0);" onclick="corsRepay('${corsRepay.accountRepayId!}');"><#else><a style="margin:0 10px;" class="admin_gray"></#if>续费</a>|<a href="javascript:void(0);" onclick="showOrderDetail('${corsRepay.accountRepayId!}');">详情查看</a></td>
	</tr>
	</#list>  
</table>
<@common.pager page.pageBean "corsRepaysForm" "corsRepaysDiv"/>