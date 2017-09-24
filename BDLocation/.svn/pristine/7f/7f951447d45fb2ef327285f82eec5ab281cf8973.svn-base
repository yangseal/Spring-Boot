<div class="ads_nav">
  <p class="an_tit">订单管理>订单详情</p>
  <p class="goback"><a onclick="doBack()">返回</a></p>
</div>
<div class="list_tit"><i></i>订单信息</div>
<div class="ads_list">
  <table width="100%" border="0" cellspacing="0" cellpadding="0">
    <thead>
      <th width="*">订单号</th>
  	  <th width="200">创建时间 </th>
  	   <th width="200">完成时间</th>
      <th width="150">订单状态</th>
      <th width="150">订单类型</th>
     
    </thead>
    <tbody>
      <tr>
        <td><#if corsRepay.orderNo??>${corsRepay.orderNo!}</#if></td>
        <td>${corsRepay.accountRepayTime!}</td>
        <td>${corsRepay.repayFinshDate!'---'}</td>
        <td><#if corsRepay.accountRepayStateName??>${corsRepay.accountRepayStateName!}</#if></td>
        <td><#if corsRepay.orderTypeName??>${corsRepay.orderTypeName!}</#if></td>
      </tr>
    </tbody>
  </table>
</div>

<div class="list_tit"><i></i>账号明细</div>
<form id="repayDetailOrderForm" action="${rc.contextPath}/client/mgtCenter/corsOrders/repayDetailOrderTable">
	<input type="hidden" name="corsApplyId" value="${corsRepay.accountRepayId!}"/>
</form>
 <div id="repayDetailOrderDiv" class="ads_list">
 
</div>
<script>
	$(function(){
		refreshPage("repayDetailOrderForm","repayDetailOrderDiv");
	});
</script>