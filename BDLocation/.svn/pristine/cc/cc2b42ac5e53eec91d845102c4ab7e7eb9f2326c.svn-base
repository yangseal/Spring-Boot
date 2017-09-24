<#macro pager pageBean formId divId>
	<#if pageBean.pages gt 0>
	<div class="pager">
		<div style="float:left">
			<a href="javascript:;" onclick="refreshPage('${formId}','${divId}',1);"><i class="glyphicon glyphicon-step-backward" title="首页">首页</i></a>
			<a href="javascript:;" onclick="refreshPage('${formId}','${divId}',${pageBean.prePageNo});"><i class="glyphicon glyphicon-triangle-left" title="上一页">上一页</i></a>
			<span>第</span>
			<input style="width:30px;text-align:center" type="text" id="${formId}_pageIndex" name="pageIndex" value="${pageBean.pageIndex?c}" onblur="javascript:refreshPage('${formId}','${divId}');"/>
			<span>页&nbsp;/&nbsp;共</span>
			<span style="color:blue">${pageBean.pages}</span>
			<span style="margin-right:10px">页</span>
			<a href="javascript:;" onclick="refreshPage('${formId}','${divId}',${pageBean.nextPageNo?c});"><i class="glyphicon glyphicon-triangle-right" title="下一页">下一页</i></a>
			<a href="javascript:;" onclick="refreshPage('${formId}','${divId}',${pageBean.pages?c});"><i class="glyphicon glyphicon-step-forward" title="末页">末页</i></a>
		</div>
		<div style="float:right">
			<span>每页</span>
			<select id="pageSize" name="pageSize" onchange="refreshPage('${formId}','${divId}');">
				<option <#if pageBean.pageSize == 5>selected</#if>>5</option>
				<option <#if pageBean.pageSize == 10>selected</#if>>10</option>
				<option <#if pageBean.pageSize == 20>selected</#if>>20</option>
				<option <#if pageBean.pageSize == 50>selected</#if>>50</option>
				<option <#if pageBean.pageSize == 100>selected</#if>>100</option>
			</select>
			<span>条,共</span>
			<span style="color:blue">${pageBean.count}</span>
			<span>条</span>
		</div>
	</div>
	</#if>
</#macro>

<#--专用于前台客户端展示 -->
<#macro frontPager pageBean formId divId>
	<#if pageBean.pages gt 0>
	<div class="pager">
		<div style="float:left">
			<a href="javascript:;" onclick="refreshPage('${formId}','${divId}',1);"><i class="glyphicon glyphicon-step-backward" title="首页">首页</i></a>
			<a href="javascript:;" onclick="refreshPage('${formId}','${divId}',${pageBean.prePageNo});"><i class="glyphicon glyphicon-triangle-left" title="上一页">上一页</i></a>
			<span>第</span>
			<input style="width:30px;text-align:center" type="text" id="${formId}_pageIndex" name="pageIndex" value="${pageBean.pageIndex?c}" onblur="javascript:refreshPage('${formId}','${divId}');"/>
			<span>页&nbsp;/&nbsp;共</span>
			<span style="color:blue">${pageBean.pages}</span>
			<span style="margin-right:10px">页</span>
			<a href="javascript:;" onclick="refreshPage('${formId}','${divId}',${pageBean.nextPageNo?c});"><i class="glyphicon glyphicon-triangle-right" title="下一页">下一页</i></a>
			<a href="javascript:;" onclick="refreshPage('${formId}','${divId}',${pageBean.pages?c});"><i class="glyphicon glyphicon-step-forward" title="末页">末页</i></a>
		</div>
		<div style="float:right">
			<span>每页</span>
				<select id="pageSize" disabled name="pageSize" onchange="refreshPage('${formId}','${divId}');">
					<option selected disabled>10</option>
				</select>
			<span>条,共</span>
			<span style="color:blue">${pageBean.count}</span>
			<span>条</span>
		</div>
	</div>
	</#if>
</#macro>

<#--专用于前台论坛展示 -->
<#macro forumPager pageBean formId divId>
	<#if pageBean.pages gt 0>
	<div class="page">
			<a href="javascript:;" onclick="refreshPage('${formId}','${divId}',1);"><i class="glyphicon glyphicon-step-backward" title="首页">首页</i></a>
			<a href="javascript:;" onclick="refreshPage('${formId}','${divId}',${pageBean.prePageNo});"><i class="glyphicon glyphicon-triangle-left" title="上一页">上一页</i></a>
			<span>第</span>
			<input style="width:30px;text-align:center" type="text" id="${formId}_pageIndex" name="pageIndex" value="${pageBean.pageIndex?c}" onblur="javascript:refreshPage('${formId}','${divId}');"/>
			<span>页&nbsp;/&nbsp;共</span>
			<span style="color:blue">${pageBean.pages}</span>
			<span style="margin-right:10px">页</span>
			<a href="javascript:;" onclick="refreshPage('${formId}','${divId}',${pageBean.nextPageNo?c});"><i class="glyphicon glyphicon-triangle-right" title="下一页">下一页</i></a>
			<a href="javascript:;" onclick="refreshPage('${formId}','${divId}',${pageBean.pages?c});"><i class="glyphicon glyphicon-step-forward" title="末页">末页</i></a>
			
	</div>
	</#if>
</#macro>

<#macro postPager pageBean formId divId>
	<#if pageBean.pages gt 0>
	<div class="page">
			<a href="javascript:;" onclick="myRefreshPage('${formId}','${divId}',1);"><i class="glyphicon glyphicon-step-backward" title="首页">首页</i></a>
			<a href="javascript:;" onclick="myRefreshPage('${formId}','${divId}',${pageBean.prePageNo});"><i class="glyphicon glyphicon-triangle-left" title="上一页">上一页</i></a>
			<span>第</span>
			<input style="width:30px;text-align:center" type="text" id="${formId}_pageIndex" name="pageIndex" value="${pageBean.pageIndex?c}" onblur="javascript:myRefreshPage('${formId}','${divId}');"/>
			<span>页&nbsp;/&nbsp;共</span>
			<span style="color:blue">${pageBean.pages}</span>
			<span style="margin-right:10px">页</span>
			<a href="javascript:;" onclick="myRefreshPage('${formId}','${divId}',${pageBean.nextPageNo?c});"><i class="glyphicon glyphicon-triangle-right" title="下一页">下一页</i></a>
			<a href="javascript:;" onclick="myRefreshPage('${formId}','${divId}',${pageBean.pages?c});"><i class="glyphicon glyphicon-step-forward" title="末页">末页</i></a>
			
	</div>
	</#if>
</#macro>

<#assign isSystemUser=(CURRENT_USER?? && CURRENT_USER.company?? && CURRENT_USER.company.companyCode?? && "SYS"==CURRENT_USER.company.companyCode)>
<#assign isCompanyAdministrator=(CURRENT_USER?? && CURRENT_USER.isCompanyAdmin?? && "Y"==CURRENT_USER.isCompanyAdmin)>
<#assign isCntenUser=(CURRENT_USER?? && CURRENT_USER.company?? && CURRENT_USER.company.companyCode?? && "CNTEN"==CURRENT_USER.company.companyCode)>
<#assign isCntenAdministrator=(CURRENT_USER?? && CURRENT_USER.role?? && "讯腾管理员"==CURRENT_USER.role.roleName)>
<#assign isYeWuUser=(CURRENT_USER?? && CURRENT_USER.role?? && "业务管理员"==CURRENT_USER.role.roleName)>
<#assign isCaiWuUser=(CURRENT_USER?? && CURRENT_USER.role?? && "财务管理员"==CURRENT_USER.role.roleName)>
<#assign isZhangHaoUser=(CURRENT_USER?? && CURRENT_USER.role?? && "账号管理员"==CURRENT_USER.role.roleName)>
<#assign isCompanyMaterialWS=(CURRENT_USER?? && CURRENT_USER.company?? && CURRENT_USER.company.companyMaterialState??  && "2"==CURRENT_USER.company.companyMaterialState)>
