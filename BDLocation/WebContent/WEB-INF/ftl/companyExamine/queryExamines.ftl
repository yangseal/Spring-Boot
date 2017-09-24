<table id="vbusicompayExamineTable" class="table">
	<tr>
		<th><input type="checkbox" onclick="checkAll(this);" /></th>
		<th>企业名称</th>
		<th>联系人</th>
		<th>联系电话</th>
		<th>联系地址</th>
		<th>营业执照号</th>
		<th>提交时间</th>
		<th>审批状态</th>
	</tr>
	<#list page.result as companyMaterial>
	<tr entityId="${companyMaterial.busiApproveId!}" entityStatus="${companyMaterial.companyMaterialState!}"  onclick="selectEntity(this);">
		<td><input type="checkbox"  onclick="stopPropagation()" /></td>
		<td>${companyMaterial.companyName!}</td>
		<td>${companyMaterial.contacts!}</td>
	    <td>${companyMaterial.phone!}</td>
	    <td>${companyMaterial.address!}</td>
		<td>${companyMaterial.businessLicense!}</td>
		<td>${companyMaterial.busiSubmitTime!}</td>
		<td><#if !companyMaterial.busiApproveRlt?? || companyMaterial.busiApproveRlt?length = 0>审核中<#elseif "NO"==companyMaterial.busiApproveRlt>已拒绝<#elseif "YES"==companyMaterial.busiApproveRlt>已通过</#if></td>
		<#--<td>${companyMaterial.companyMaterialStateName!}</td>-->
	</tr>
	</#list>
</table>
<@common.pager page.pageBean "companyExamineForm" "companyExamineDiv"/>