<!doctype html>
<html>
<head>
<meta charset="utf-8">
<meta name="keywords" content="">
<meta name="description" content="">
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
<title>购买清单确认</title>
<#include "../common/clientMatascript.ftl"/>
</head>	
<body>
<#assign curDiv="index">
<#include "../../propagandas/header.ftl"/>

<div class="wraping bac2">
  <div class="title color_black">确认清单</div>
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
        <p><img src="${rc.contextPath}/public/propaganda/css_img/lc_img02.png" /></p>
        <span>填选配置</span>
      </li>
      <li>
        <i><img src="${rc.contextPath}/public/propaganda/css_img/lc_jt.png" /></i>
      </li>
      <li>
        <p><img src="${rc.contextPath}/public/propaganda/css_img/lc_img03.png" /></p>
        <span>提交申请</span>
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
    <div class="affirm_order">
      <div class="ao_tit">已选服务及配置<a onclick="continueAdd()">继续添加</a></div>
      <table width="100%" border="0" cellspacing="0" cellpadding="0">
        <thead>
          <th width="200">服务类型</th>
          <th width="*">服务时长</th>
          <th width="200">账号精度</th>
          <th width="260">账号数量</th>
          <th width="120">操作</th>
        </thead>
        <tbody id="corsAccountsData">
        <#list corsApply as corsApply> 
          <tr entity="${corsApply.corsApplyTempId}" applyType="${corsApply.bdDeviceAccuracy}">
            <td>${corsApply.bdDeviceAccuracyName!}服务</td>
            <td>${corsApply.accountUsePeriod!}年</td>
            <td name="corsTypeName">${corsApply.bdDeviceAccuracyName!}</td>
            <td><input type="text" class="spinnerExample" value="${corsApply.applyCount}"> </td>
            <td><span onclick="deleteServe(this,'${corsApply.corsApplyTempId}')">删除</span></td>
          </tr>
        </#list>
        </tbody>
      </table>
    </div>
    
    <div class="affirm_order">
      <div class="ao_tit">结算信息</div>
      <table width="100%" id="js_tb" border="0" cellspacing="0" cellpadding="0">
        <tbody>
          <tr>
            <td width="320">已选择服务：</td>
            <td width="240"><i id="corsTypes">厘米级服务、亚米级服务</i></td>
            <td width="220">共&nbsp;<i id="corsTypeNum">2</i>&nbsp;类服务</td>
            <td width="*" rowspan='2'><p class="buy_sub" style="margin: 20px auto;" onclick="submitServe()" >提交</p></td>
          </tr>
          <tr>
            <td width="320">账号数量：</td>
            <td width="240"><i id="corsCateNum">厘米级2个、亚米级2个</i></td>
            <td width="220">共&nbsp;<i id="corsSumNum">4</i>&nbsp;个账号</td>
          </tr>
        </tbody>
      </table>
	</div>
    
    
    <!-- list end -->
    <#--<div class="buy_sub" onclick="submitServe()">提交</div>-->
  </div>
</div>
	<input type="hidden" id="userId" name="busiApproveUser" value="${CURRENT_USER.userId}"/>
<input type="hidden" id="companyId" name="busiApproveUser" value="${CURRENT_USER.company.companyId}"/>
<#include "../../propagandas/footer.ftl"/>
<script type="text/javascript">
	$('.spinnerExample').spinner({});
</script>
</body>
</html>
