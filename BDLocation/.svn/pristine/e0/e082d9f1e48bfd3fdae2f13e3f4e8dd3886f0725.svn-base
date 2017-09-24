<div class="ads_nav">
  <p class="an_tit">服务账号管理>账号详情</p>
  <p class="goback"><a onclick="doBack()">返回</a></p>
</div>
<div class="list_tit"><i></i>账号信息</div>
<div class="ads_list">
  <table width="100%" border="0" cellspacing="0" cellpadding="0">
    <thead>
      <th width="*">入网账号</th>
      <th width="200">账号密码</th>
      <th width="200">账号类型</th>
      <th width="200">账号状态</th>
    
    </thead>
    <tbody>
      <tr>
        <td><#if corsAccount.corsAccountCode??>${corsAccount.corsAccountCode!}</#if></td>
        <td>${(corsAccount.corsAccountType == 'test')?string(corsAccount.corsAccountPwd,"********")}</td>
        <td><#if corsAccount.corsAccountTypeName??>${corsAccount.corsAccountTypeName!}</#if></td>
        <td><#if corsAccount.corsAccountStateName??>${corsAccount.corsAccountStateName!}</#if></td>
      </tr>
    </tbody>
  </table>
</div>
<!--<div class="list_tit"><i></i>订单明细</div>-->
<div class="ads_list">
  <table width="100%" border="0" cellspacing="0" cellpadding="0">
    <thead>
      <th width="*">入网精度</th>
      <th width="200">生效时间</th>
      <th width="200">失效时间</th>
      <th width="200">使用区域</th>
      <th width="200">设备SN</th>
    </thead>
    <tbody>
      <tr>
        <td><#if corsAccount.bdDeviceAccuracyName??>${corsAccount.bdDeviceAccuracyName!}</#if></td>
        <td><#if corsAccount.effectiveDate??>${corsAccount.effectiveDate!}</#if></td>
        <td><#if corsAccount.exprieDate??>${corsAccount.exprieDate!}</#if></td>
        <td><#if corsAccount.oamArea?? && corsAccount.oamArea.oamAreaName??>${corsAccount.oamArea.oamAreaName!}</#if></td>
        <td><#if corsAccount.bdDeviceSn??>${corsAccount.bdDeviceSn!}</#if></td>
      </tr>
    </tbody>
  </table>
</div>



