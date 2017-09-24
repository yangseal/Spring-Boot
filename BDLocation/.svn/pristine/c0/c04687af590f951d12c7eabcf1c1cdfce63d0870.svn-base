<!doctype html>
<html>
<head>
<meta charset="utf-8">
<meta name="keywords" content="">
<meta name="description" content="">
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
<title>续费订单确认</title>
<#include "../client/common/clientMatascript.ftl"/>
</head>	
<body>
<#assign curDiv="index">
<#include "../propagandas/header.ftl"/>

<div class="wraping bac2">
  <div class="title color_black">续费订单确认</div>
	 <div class="wraper step">
    <ul>
      <li>
        <p><img src="${rc.contextPath}/public/propaganda/css_img/lc_img02.png" /></p>
        <span>填选配置</span>
      </li>
      <li>
        <i><img src="${rc.contextPath}/public/propaganda/css_img/lc_jt.png" /></i>
      </li>
      <li>
        <p><img src="${rc.contextPath}/public/propaganda/css_img/lc_img03.png" /></p>
        <span>订单确认</span>
      </li>
      <li>
        <i><img src="${rc.contextPath}/public/propaganda/css_img/lc_jt.png" /></i>
      </li>
      <li>
        <p><img src="${rc.contextPath}/public/propaganda/css_img/lc_img04.png" /></p>
        <span>订单审核</span>
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
          <th width="200">入网账号</th>
          <th width="*">入网精度</th>
          <th width="220">到期时间</th>
          <th width="260">续费时长</th>
          <th width="120">操作</th>
        </thead>
        <tbody id="corsRepaysData">
        <#list corsRepayTemps as corsRepayTemp> 
          <tr   entity="<#if corsRepayTemp??>${corsRepayTemp.corsRepayTempId!}</#if>"     corsAccountId="<#if corsRepayTemp??&&corsRepayTemp.corsAccount??>${corsRepayTemp.corsAccount.corsAccountId!}</#if>" applyType="<#if corsRepayTemp??&&corsRepayTemp.corsAccount??>${corsRepayTemp.corsAccount.bdDeviceAccuracy}</#if>">
            <td><#if corsRepayTemp??&&corsRepayTemp.corsAccount??>${corsRepayTemp.corsAccount.corsAccountCode!}</#if></td>
            <td name="corsTypeName"><#if corsRepayTemp??&&corsRepayTemp.corsAccount??>${corsRepayTemp.corsAccount.bdDeviceAccuracyName!}</#if></td>
            <td><#if corsRepayTemp??&&corsRepayTemp.corsAccount??>${corsRepayTemp.corsAccount.exprieDate!}</#if></td>
            <td><input type="text" class="spinnerExample" value="<#if corsRepayTemp??>${corsRepayTemp.accountRepayPeriod!}</#if>"> </td>
            <td><span onclick="deleteRepayApply(this,'<#if corsRepayTemp??>${corsRepayTemp.corsRepayTempId!}</#if>')">删除</span></td>
          </tr>
        </#list>
        </tbody>
      </table>
    </div>
	<div class="affirm_order">
      <div class="ao_tit">结算信息</div>
      <table width="100%" border="0" cellspacing="0" cellpadding="0">
        <tbody>
          <tr>
            <td width="200">已选择续费账号：</td>
            <td width="470"><i id="corsRepayType"></i></td>
            <td width="160">共&nbsp;<i id="corsRepaySumNum"></i>&nbsp;个账号</td>
            <td width="*" ><p class="buy_sub" style="margin: 20px auto;" onclick="submitRepayServe()" >提交</p></td>
          </tr>
        </tbody>
      </table>
	</div>
  </div>
</div>
<input type="hidden" id="userId" name="busiApproveUser" value="${CURRENT_USER.userId}"/>
<input type="hidden" id="companyId" name="busiApproveUser" value="${CURRENT_USER.company.companyId}"/>
<#include "../propagandas/footer.ftl"/>
<script type="text/javascript">
	$('.spinnerExample').spinner({});
</script>
<script type="text/javascript" src="${rc.contextPath}/public/js/client/corsAccounts/showAccounts.js"></script>
</body>
</html>
