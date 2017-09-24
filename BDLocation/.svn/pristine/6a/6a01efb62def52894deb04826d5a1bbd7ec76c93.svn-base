  <div class="wrap mgat">
    <div class="logo"><a href="${rc.contextPath}"><img src="${rc.contextPath}/public/propaganda/images/logo.png"></a></div>
    <!-- 顶部导航区域   -->
    <ul id="menuUL" class="nav">
	    <#list menus as menu>
			<li <#if menu.menuCode == 'clentCenter'>class="this"</#if>>
				<a href="javascript:;" <#if menu.action?? && menu.action?length gt 0>action="${rc.contextPath}/${menu.action!}"</#if> 
	    					code="${menu.menuCode}">${menu.menuName}</a>
	       </li>
	    </#list>
    </ul>
    
    <div class="buy_bt">
      <a href="${rc.contextPath}/propagandas/testServiceApply?serviceType=test&productType=centimeter">免费试用</a>
      <a href="${rc.contextPath}/client/service/formalApplyConfig?serviceType=formal&productType=centimeter">购买服务</a>
    </div>
    <div id="loginEntrance" style="display:none;"  class="login">
      <p><a href="${rc.contextPath}/home" >云服务登录</a></p>
      <span><a href="${rc.contextPath}/register" >企业注册</a></span>
    </div>
     <div id="userCenter" style="display:none;" class="center">
      <!--<div class="ct_info"><a href="">新消息<i>10</i></a></div>-->
      <div class="ct_user">
        <p><span id="user_code" style="font-color:white"></span></p>
        <div class="ct_link">
          <a href="${rc.contextPath}/client/index">管理中心</a>
          <a href="${rc.contextPath}/home" target="_blank">业务中心</a>
          <a href="${rc.contextPath}/logout">退出</a>
        </div>
      </div>
    </div>
  </div>