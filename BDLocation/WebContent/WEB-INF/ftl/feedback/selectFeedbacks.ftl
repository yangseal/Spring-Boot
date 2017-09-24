<table id="feedbacksTable" class="table">
	<tr>
		<th>信息反馈名称</th>
	</tr>
	<#list page.result as feedback>
	<tr entityId="${feedback.feedbackId!}" onclick="selectEntity(this);">
		<td>${feedback.feedbackName!}</td>
	</tr>
	</#list>
</table>
<@common.pager page.pageBean "feedbacksForm" "feedbacksDiv"/>