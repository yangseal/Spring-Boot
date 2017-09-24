<script type="text/javascript">
	CONTEXT_PATH = "${rc.contextPath}";
	QUERY_STRING = "${rc.queryString!}";
	ENCYPT_PUBLIC_KEY_Exponent = "";
	ENCYPT_PUBLIC_KEY_Modulus = "";
	<#if publicKeyExponent?? && publicKeyModulus??>
	ENCYPT_PUBLIC_KEY_Exponent = "${publicKeyExponent}";
	ENCYPT_PUBLIC_KEY_Modulus = "${publicKeyModulus}"
	</#if>
</script>
<div class="header sub_header">
  <div class="wrap mgat">
    <div class="logo"><a href="${rc.contextPath}"><img src="${rc.contextPath}/public/propaganda/images/logo.png"></a></div>
    <div id="loginEntrance" style="display:none;" class="login">
      <p><a href="${rc.contextPath}/home" >云平台登录</a></p>
      <span><a href="${rc.contextPath}/register" >企业注册</a></span>
    </div>
     <div id="userCenter" style="display:none;" class="center">
     <!-- <div class="ct_info"><a href="">新消息<i>10</i></a></div>-->
      <div class="ct_user">
        <p><span id="user_code" style="font-color:white"></span></p>
        <div class="ct_link">
          <a href="${rc.contextPath}/client/index">管理中心</a>
          <a href="${rc.contextPath}/logout">退出</a>
        </div>
      </div>
     </div>
  </div>
</div>
<script type="text/javascript" src="${rc.contextPath}/public/propaganda/js/jquery-1.8.3.min.js"></script>
<script type="text/javascript" src="${rc.contextPath}/public/js/lib/security.js"></script>
<script type="text/javascript" src="${rc.contextPath}/public/js/lib/common.js"></script>
<script type="text/javascript" src="${rc.contextPath}/public/js/system/login.js"></script>
