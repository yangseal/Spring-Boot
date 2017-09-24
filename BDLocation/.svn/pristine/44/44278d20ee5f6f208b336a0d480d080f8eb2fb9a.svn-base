<ul id="secondMenuUL">   
	<#list menus as menu>
		<li <#if menu_index == 0>class="on"</#if> >
			<a href="javascript:;" <#if menu.action?? && menu.action?length gt 0>action="${rc.contextPath}/${menu.action!}"</#if> 
    			code="${menu.menuCode}">${menu.menuName}</a>
		</li>
	</#list>		     
</ul>