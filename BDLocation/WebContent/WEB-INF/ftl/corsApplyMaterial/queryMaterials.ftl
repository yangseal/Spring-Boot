<table id="corsApplyMaterialsTable" class="table">
	<tr>
		<th><input type="checkbox" onclick="checkAll(this);" /></th>
		<th>企业名称</th>
		<th>订单号</th>
		<th>订单类型</th>
		<th>订单状态</th>
		<th>订单生成时间</th>
		<th>订单完成时间</th>
		<th>资料状态</th>
		<th>订单详情</th>
	</tr>
	<#list page.result as financialMaterial>
	<tr entityId="${financialMaterial.orderBussinkey!}" applyMaterialState="${financialMaterial.applyMaterialState!}" onclick="selectEntity(this);">
		<td><input name="trdata" type="checkbox" onclick="stopPropagation();" /></td>
		<td>${financialMaterial.companyName!}</td>
		<td>${financialMaterial.orderNo!}</td>
	    <td>${financialMaterial.orderTypeName!}</td>
	    <td>${financialMaterial.applyStatusName!}</td>
		<td>${financialMaterial.applyDate!}</td>
		<td>${financialMaterial.finshDate!}</td>
		<td>${financialMaterial.applyMaterialState!}</td>
		<td align="center"><a style="margin:0 10px;" onclick="showOrderDetail('${financialMaterial.orderBussinkey!}','${financialMaterial.orderType!}')">订单详情</a></td>
	</tr>
	</#list>
</table>
<@common.pager page.pageBean "materialsForm" "materialsDiv"/>