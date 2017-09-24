<!doctype html>
<html>
<head>
<#include "/head.ftl"/>
<link href="${rc.contextPath}/public/css/login.css" type="text/css" rel="stylesheet" />
<link href="${rc.contextPath}/public/css/supersized.css" type="text/css" rel="stylesheet" />
<#include "../propagandas/matascript.ftl"/>
</head>
<body>
<#assign curDiv="0">
<div class="login_wraper">

  <#include "../propagandas/header.ftl"/>
  <div class="login_box">
    <div class="login_div">
	<form id="loginForm">
	  <!--<label>
		<span>企业编号</span>
		<input id="companyCode" type="text" name="companyCode" value="sys" style="display=none;" />
	  </label>-->
	  <label>
		<span>用&ensp;户&ensp;名</span>
		<input id="userCode" type="text" name="userCode" placeholder="用户名"/>
	  </label>
	  <label>
		<span>密&emsp;&emsp;码</span>
		<input id="password" type="password" name="password" placeholder="密码" />
	  </label>
	  <label>
		<span>验&ensp;证&ensp;码</span>
		<input type="text" class="login_text1"  placeholder="验证码"  id='checkmardstr' />
        <i><img src="${rc.contextPath}/checkMard/getChekMard"    alt="看不清楚？点击换一个" id="imgVerifyCode" /></i>
	  </label>
	  <a class="login_bt" onclick="login();">登&emsp;录</a>
	  
	</form>
	</div>
  </div>
</div>
</body>
<script type="text/javascript">
   window.onload = function(){
   debugger;
   		$(".login span").css("background-color","transparent");	
   };


</script>
<script type="text/javascript" src="${rc.contextPath}/public/propaganda/js/supersized.3.2.7.min.js"></script>
<script type="text/javascript" src="${rc.contextPath}/public/propaganda/js/supersized-init.js"></script>
</html>