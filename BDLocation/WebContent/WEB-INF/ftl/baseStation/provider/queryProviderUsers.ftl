<table id="providerUserTable" class="table">
	<tr>
		<th><input type="checkbox" onclick="checkAll(this);" /></th>
		<th>姓名</th>
		<th>职务</th>
		<th>供应商</th>
		<th>联系电话</th>
		<th>手机</th>
		<th>邮箱</th>
		<th>传真</th>
	</tr>
	<#list page.result as providerUser>
	<tr entityId="${providerUser.baseProviderUserId!}" onclick="selectEntity(this);">
		<td><input type="checkbox" onclick="stopPropagation()"/></td>
		<td><#if providerUser.proUserName??>${providerUser.proUserName!}</#if></td>
		<td><#if providerUser.proUserPost??>${providerUser.proUserPost!}</#if></td>
		<td><#if providerUser.baseProvider??>${providerUser.baseProvider.providerName!}</#if></td>		
		<td><#if providerUser.proUserTel??>${providerUser.proUserTel!}</#if></td>
		<td><#if providerUser.proUserPhone??>${providerUser.proUserPhone!}</#if></td>
		<td><#if providerUser.proUserEmail??>${providerUser.proUserEmail!}</#if></td>
		<td><#if providerUser.proUserFax??>${providerUser.proUserFax!}</#if></td>	
	</tr>
	</#list>
</table>
<@common.pager page.pageBean "providerUserForm" "providerUserDiv"/>