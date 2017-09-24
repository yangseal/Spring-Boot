<table id="corsInitsTable" class="table">
	<tr>
		<th><input type="checkbox" onclick="checkAll(this);" /></th>
		<th>企业名称</th>
		<th>订单号</th>
		<th>订单类型</th>
		<th>订单状态</th>
		<th>订单生成时间</th>
		<th>订单完成时间</th>
		<th align="center">操作</th>
		<th>生成状态</th>
	</tr>
	
	<#list  page.result as result>
	<tr entityId="${result.corsApplyId!}"  onclick="selectEntity(this);" state="${result.accountCreateState!}"  > 
	<td><input name="data" type="checkbox" onclick="stopPropagation()" /></td>
	<td>${result.company.companyName}</td>
	<td>${result.orderNo}</td>
	<td>${result.orderTypeName}</td>
	<td>${result.applyStatusName}</td>
	<td>${result.applyDate}</td>
	<td>${result.finshDate}</td>
	<td align="center"><#if result.accountCreateState?? && "YES" == result.accountCreateState><a style="margin:0 10px;" onclick="showAccounts('${result.corsApplyId}')"><#else><a style="margin:0 10px;" class="admin_gray"></#if>账号详情</a>|<a style="margin:0 10px;" onclick="showOrderDetail('${result.corsApplyId!}','${result.orderType!}')">订单详情</a></td>
	<td>${result.accountCreateStateName!}</td>
	</tr>
	</#list>
</table>
<@common.pager page.pageBean "corsInitsForm" "corsInitsDiv"/>