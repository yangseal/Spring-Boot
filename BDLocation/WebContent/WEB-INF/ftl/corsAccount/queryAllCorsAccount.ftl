<table id="corsAllCountTable" class="table">
	<tr>
		<th><input type="checkbox" onclick="checkAll(this);" /></th>
		<th>公司名称</th>
		<th>账号名称</th>
		<th>账号精度</th>
		<th>账号类型</th>
		<th>使用周期</th>
		<th>生效日期</th>
		<th>失效日期</th>
		<th>用途</th>
	</tr>
	<#list page.result as corsAllCount>
	<tr entityId="${corsAllCount.corsAccountId!}" onclick="selectEntity(this);">
		<td><input type="checkbox" onclick="stopPropagation()" /></td>
		<td>${corsAllCount.company.companyName!}</td>
		<td>${corsAllCount.corsAccountCode!}</td>
		<td>${corsAllCount.bdDeviceAccuracyName!}</td>
		<td>${corsAllCount.corsAccountTypeName!}</td>
		<td>${corsAllCount.corsAccountPeriod!}</td>
		<td><#if corsAllCount.effectiveDate?? >${corsAllCount.effectiveDate!}</#if></td>
		<td><#if corsAllCount.exprieDate?? >${corsAllCount.exprieDate!}</#if></td>
		<td>${corsAllCount.corsAccountUseName!}</td>
	</tr>
	</#list>
</table>
<@common.pager page.pageBean "corsQueryForm" "corsQueryDiv"/>