<table id="feedbacksTable" class="table">
	<tr>
		<th><input type="checkbox" onclick="checkAll(this);" /></th>
		<th>反馈企业</th>
		<th>反馈人员</th>
		<th>信息分类</th>
		<th>处理状态</th>
		<th>反馈信息</th>
		<th>反馈日期</th>
	</tr>
	<#list page.result as feedback>
	<tr entityId="${feedback.feedbackId!}" onclick="selectEntity(this);">
		<td><input type="checkbox" /></td>
		<td><#if feedback.company??>${feedback.company.companyName!}</#if></td>
		<td><#if feedback.user??>${feedback.user.userName!}</#if></td>
		<td><#if !feedback.type??><#elseif "forStation"==feedback.type>CORS基站问题<#elseif "forDevice"==feedback.type>北斗设备问题<#elseif "forAccount"==feedback.type>CORS账户问题<#elseif "forCustom"==feedback.type>其他反馈</#if></td>
		<td><#if !feedback.feedbackStatus??><#elseif "untreated"==feedback.feedbackStatus>未解决<#elseif "treated"==feedback.feedbackStatus>已解决</#if></td>
		<td>${feedback.information!}</td>
		<td>${feedback.createDate!}</td>
	</tr>
	</#list>
</table>
<@common.pager page.pageBean "feedbacksForm" "feedbacksDiv"/>