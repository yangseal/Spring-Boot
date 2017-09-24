<script type="text/javascript">
	CONTEXT_PATH = "${rc.contextPath}";
	QUERY_STRING = "${rc.queryString!}";
</script>
<div class="header sub_header">
  <div class="wrap mgat">
    <div class="logo"><a href="${rc.contextPath}"><img src="${rc.contextPath}/public/propaganda/images/logo.png"></a></div>
    <ul class="nav">
      <li class="this"><a href="${rc.contextPath}/" class="current">首页</a></li>
    </ul>
    <div id="loginEntrance" class="login">
      <p><a href="${rc.contextPath}/home" >云服务入口</a></p>
      <span><a href="${rc.contextPath}/register" >企业注册</a></span>
    </div>
     <div id="userCenter" style="display:none;" class="login">
      <p><a href="${rc.contextPath}/client/mgtCenter/index" >客户中心</a></p>
       <span><a href="${rc.contextPath}/register" >退出</a></span>
    </div>
  </div>
</div>
