<table id="corsApplysTable" class="table">
	<tr>
		<th>CORS账号申请名称</th>
	</tr>
	<#list page.result as corsApply>
	<tr entityId="${corsApply.corsApplyId!}" onclick="selectEntity(this);">
		<td>${corsApply.corsApplyName!}</td>
	</tr>
	</#list>
</table>
<@common.pager page.pageBean "corsApplysForm" "corsApplysDiv"/>