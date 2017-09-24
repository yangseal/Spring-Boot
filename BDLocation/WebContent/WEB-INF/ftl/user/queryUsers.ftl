<table id="usersTable" class="table table-striped table-hover">
	<thead>
	<tr>
		<th><input type="checkbox" onclick="javascript:checkAll(this);" /></th>
		<th>姓名</th>
		<th>用户名</th>
		<th>手机</th>
		<#if common.isSystemUser || common.isCntenUser>
		<th>所属企业</th>
		<#if 1==0>
		<th>审批状态</th>
		</#if>
		</#if>
		<th>是否<#if common.isSystemUser || common.isCntenUser>企业</#if>管理员</th>
	</tr>
	</thead>
	
	<tbody>
	<#list page.result as user>
	<tr entityId="${user.userId!}" onclick="javascript:selectEntity(this);">
		<td><input type="checkbox" /></td>
		<td>${user.userName!}</td>
		<td>${user.userCode!}</td>
		<td>${user.phone!}</td>
		<#if common.isSystemUser || common.isCntenUser>
		<td><#if user.company??>${user.company.companyName!}</#if></td>
		<#if 1==0>
		<td><#if !user.approvalStatus?? || user.approvalStatus?length = 0 || "0"==user.approvalStatus>已提交<#elseif "1"==user.approvalStatus>业务员确认<#elseif "2"==user.approvalStatus>财务确认<#elseif "3"==user.approvalStatus>已通过<#elseif "4"==user.approvalStatus>已通过</#if></td>
		</#if>
		</#if>
		<td><#if user.isCompanyAdmin?? && "Y"==user.isCompanyAdmin>是<#else>否</#if></td>
	</tr>
	</#list>
	</tbody>
</table>
<@common.pager page.pageBean "usersForm" "usersDiv"/>

