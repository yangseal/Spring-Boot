<!doctype html>
<html>
<head>
<#include "/head.ftl"/>
<link rel="stylesheet" href="${rc.contextPath}/public/css/home.css">
<script type="text/javascript" src="${rc.contextPath}/public/js/system/home.js"></script>
</head>
<body> 
  <div class="header">
   <p><span>国家北斗精准服务网</span></p>
   <div class="login_info">
   <span class="welcome">欢迎您，<b><#if CURRENT_USER.userName?? && CURRENT_USER.userName?length gt 2>${CURRENT_USER.userName!}<#else>${CURRENT_USER.userCode!}</#if></b></span>
   <a href="javascript:;" onclick="updatePassword();" class="edit"><i class="glyphicon glyphicon-edit"></i>更改密码</a>
   <a href="${rc.contextPath}/logout" class="off"><i class="glyphicon glyphicon-off"></i>注销</a> 
   </div>
  </div> 
  <ul id="menuUL" class="first-menu">
	<#list menus as menu>
	<li>
		<a href="javascript:;" <#if menu.action?? && menu.action?length gt 0>action="${rc.contextPath}/${menu.action}"</#if> code="${menu.menuCode}">${menu.menuName}</a>
		<#if menu.children?? && menu.children?size gt 0>
		<ul class="second-menu">
		<#list menu.children as secondNode>
			<li>
				<a href="javascript:;" <#if secondNode.children?? && secondNode.children?size gt 0>class="arrow"<#else>action="${rc.contextPath}/${secondNode.action}"</#if> code="${secondNode.menuCode}">${secondNode.menuName}</a>
				<#if secondNode.children?? && secondNode.children?size gt 0>
				<ul class="third-menu">
				<#list secondNode.children as thirdNode>
					<li><a href="javascript:;" <#if thirdNode.action?? && thirdNode.action?length gt 0>action="${rc.contextPath}/${thirdNode.action}"</#if> code="${thirdNode.menuCode}">${thirdNode.menuName}</a></li>
				</#list>
				</ul>
				</#if>
			</li>
		</#list>
		</ul>
		</#if>
	</li>
	</#list>
  </ul>
  <div class="sys_nav">
    <ul id="tabUL"></ul>
    <p>
    <a href="javascript:" onclick="move1(0)">《</a>
	<a href="javascript:" onclick="move1(1)">》</a>
	</p>
  </div> 
  <div id="mainContentDiv"></div> 
 </body>
</html>