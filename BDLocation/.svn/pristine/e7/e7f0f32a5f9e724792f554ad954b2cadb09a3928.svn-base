<!doctype html>
<html>
<head>
<meta charset="utf-8">
<meta name="keywords" content="">
<meta name="description" content="">
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
<title>试用申请提交</title>
<#include "../common/clientMatascript.ftl"/>
<script type="text/javascript" src="${rc.contextPath}/public/js/client/commJs/common.js"></script>
</head>	
<body>
<#assign curDiv="index">
<#include "../../propagandas/header.ftl"/>
	<div class="wraping bac2">
  <div class="title color_black">试用申请</div>
  <div class="wraper step">
    <ul>
      <li>
        <p><img src="${rc.contextPath}/public/propaganda/css_img/lc_img01.png" /></p>
        <span>企业注册</span>
      </li>
      <li>
        <i><img src="${rc.contextPath}/public/propaganda/css_img/lc_jt.png" /></i>
      </li>
      <li>
        <p><img src="${rc.contextPath}/public/propaganda/css_img/lc_img03.png" /></p>
        <span>试用申请</span>
      </li>
      <li>
        <i><img src="${rc.contextPath}/public/propaganda/css_img/lc_jt.png" /></i>
      </li>
      <li>
        <p><img src="${rc.contextPath}/public/propaganda/css_img/lc_img04.png" /></p>
        <span>审&nbsp;核</span>
      </li>
      <li>
        <i><img src="${rc.contextPath}/public/propaganda/css_img/lc_jt.png" /></i>
      </li>
      <li>
        <p><img src="${rc.contextPath}/public/propaganda/css_img/lc_img05.png" /></p>
        <span>完&nbsp;成</span>
      </li>
    </ul>
  </div>
  <div class="wraper buy">
<#--
    <div class="to_tit">企业信息</div>
    <div class="to_box">
      <div class="ep_left">
        <div><img src="${rc.contextPath}/public/propaganda/css_img/user.png"></div>
        <p>
          <#if user.company?? && user.company.companyMaterialState?? && (user.company.companyMaterialState == '0' || user.company.companyMaterialState =='1')>未认证</#if>
          <#if user.company?? && user.company.companyMaterialState?? && user.company.companyMaterialState == '2' >已认证</#if>
          <#if user.company?? && user.company.companyMaterialState?? && user.company.companyMaterialState == '3' >认证未通过</#if>
        </p>
        <span><#if user.company?? && user.company.companyName??>${user.company.companyName}</#if></span>
      </div>
      <div class="ep_right">
        <p>企业名称：<span><#if user.company?? && user.company.companyName??>${user.company.companyName}<#else>------</#if></span></p>
        <p>联系人员：<span><#if user.company?? && user.company.contacts??>${user.company.contacts}<#else>------</#if></span></p>
        <p>联系电话：<span><#if user.company?? && user.company.phone??>${user.company.phone}<#else>------</#if></span></p>
        <p>企业地址：<span><#if user.company?? && user.company.address??>${user.company.address}<#else>------</#if></span></p>
      </div>
    </div>
 -->
    
    <div class="to_tit">服务配置</div>
    <div class="to_box">
      <div class="to_setL">
        <p>${serviceTypeName!}级精准定位服务</p>
        <span>基于RTK的差分定位原理，依托于遍布全国的卫星定位地基增强站，融合各类定位技术，及后处理的高精定位差分算法，面向特定需求的行业和应用系统，以互联网的方式提供厘米级精度的位置纠偏数据服务。</span>
      </div>
      <div class="to_setR">
      <input id="serverType" type="hidden" value="${serviceType!}"/>
        <h2>试用配置</h2>
        <p>覆盖范围：<span>部分省市</span></p>
        <p>账号数量：<span>3个</span></p>
        <p>试用期限：<span>1个月</span></p>
        <p>服务类型：<span>${serviceTypeName!}级服务</span></p>
      </div>
    </div>
    
    <div class="hint_box hb_mar">
		<p>温馨提示</p>
		<span>
			1.试用账号试用期限为一个月，账号数量为3个，各类服务均可试用一次<br>
			2.试用账号申请提交后，工作人员将在1-2个工作日内完成相关业务办理<br>
			3.试用账号在申请成功后，2个月内未进行激活操作，将自动过期
		</span>
	</div>
    <div class="buy_sub" onclick="submitServiceApply();">提交</div>
  </div>
</div>
																	
<#include "../../propagandas/footer.ftl"/>
<script type="text/javascript">
	$('.spinnerExample').spinner({});
</script>
</body>
</html>
