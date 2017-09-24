<div class="ads_nav">
  <p class="an_tit">订单管理>订单详情</p>
  <p class="goback"><a onclick="doBack()">返回</a></p>
</div>
<div class="list_tit"><i></i>订单信息</div>
<div class="ads_list">
  <table width="100%" border="0" cellspacing="0" cellpadding="0">
    <thead>
      <th width="*">订单号</th>
      <th width="200">订单状态</th>
      <th width="200">提交时间</th>
      <th width="200">完成时间</th>
    </thead>
    <tbody>
      <tr>
        <td><#if orderNo??>${orderNo!}</#if></td>
        <td><#if applyStatusName??>${applyStatusName!}</#if></td>
        <td><#if busiSubmitTime??>${busiSubmitTime!}</#if></td>
        <td><#if busiApproveTime??>${busiApproveTime!}<#else>---</#if></td>
      </tr>
    </tbody>
  </table>
</div>
<div class="list_tit"><i></i>订单明细</div>
<div class="ads_list">
  <table width="100%" border="0" cellspacing="0" cellpadding="0">
    <thead>
      <th width="*">服务类型</th>
      <th width="200">账号数量</th>
      <th width="200">账号类型</th>
     <#-- <th width="150">服务时长</th>-->
      <th width="200">使用期限</th>
    </thead>
    <tbody>
      <tr>
        <td><#if bdDeviceAccuracyName??>${bdDeviceAccuracyName}</#if></td>
        <td><#if applyCount??>${applyCount}</#if></td>
        <td><#if accountTypeName??>${accountTypeName}</#if></td>
        <#--<td><#if effectiveDate??>${effectiveDate}</#if></td>-->
        <td><#if accountType?? && "test" == accountType && 'open' ==busiApproveType >${accountUsePeriod!}月
        <#else>${accountUsePeriod!}年		
        </#if></td>
      </tr>
    </tbody>
  </table>
</div>
<div class="list_tit"><i></i>订单反馈</div>
<div class="ads_list">
  <table width="100%" border="0" cellspacing="0" cellpadding="0">
    <thead>
      <th width="*">反馈时间</th>
      <th width="600">反馈结果</th>
    </thead>
    <tbody>
      <tr>
         <td><#if busiApprove.busiApproveTime??>${busiApprove.busiApproveTime!}</#if></td>
         <td>${busiApprove.busiApproveRltName!}<#if (busiApprove.busiApproveOpinion??)&&("" != busiApprove.busiApproveOpinion)>,${busiApprove.busiApproveOpinion!}</#if></td>
      </tr>
    </tbody>
  </table>
</div>



