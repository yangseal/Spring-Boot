<table id="corsApplysTable" class="table">
	<tr>
		<th><input type="checkbox" onclick="checkAll(this);" /></th>
		<#if common.isSystemUser || common.isCntenUser>
		<th>申请企业</th>
		</#if>
		<th>申请人员</th>
		<th>申请数量</th>
		<th>申请日期</th>
		<th>申请目的</th>
		<th>审批状态</th>
		<th>审批意见</th>
	</tr>
	<#list page.result as corsApply>
	<tr entityId="${corsApply.corsApplyId!}" entityStatus="${corsApply.applyStatus!}" onclick="selectEntity(this);">
		<td><input type="checkbox" /></td>
		<#if common.isSystemUser || common.isCntenUser>
		<td><#if corsApply.company??>${corsApply.company.companyName!}</#if></td>
		</#if>
		<td><#if corsApply.user??>${corsApply.user.userName!}</#if></td>
		<td>${corsApply.applyCount!}</td>
		<td>${corsApply.applyDate!}</td>
		<#if corsApply.purposeDesc?? && corsApply.purposeDesc?length gt 10>
		<td>${corsApply.purposeDesc?substring(0,10)}...</td>
		<#else>
		<td>${corsApply.purposeDesc!}</td>
		</#if>
		<td><#if !corsApply.applyStatus??><#elseif "-1"==corsApply.applyStatus>已拒绝<#elseif "0"==corsApply.applyStatus>已提交<#elseif "1"==corsApply.applyStatus>业务员已确认<#elseif "2"==corsApply.applyStatus>财务已确认<#elseif "3"==corsApply.applyStatus>已通过</#if></td>
		<#if corsApply.applyComment?? && corsApply.applyComment?length gt 10>
		<td>${corsApply.applyComment?substring(0,10)}...</td>
		<#else>
		<td>${corsApply.applyComment!}</td>
		</#if>
	</tr>
	</#list>
</table>
<@common.pager page.pageBean "corsApplysForm" "corsApplysDiv"/>