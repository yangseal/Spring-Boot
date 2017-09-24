<script type="text/javascript">  
$(function(){  
 	var totalRow = 0 
  	$('#orderDetailsTable tr').each(function() {  
 		$(this).find('td:eq(1)').each(function(){  
  			totalRow += parseFloat($(this).text()); 
   		});  
   	});   
    $('#totalRow').append('共计账号'+totalRow+'个'); 
}); 
</script> 
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
        <td><#if corsApply.orderNo??>${corsApply.orderNo!}</#if></td>
        <td>${corsApply.applyDate!}</td>
        <td><#if corsApply.finshDate??>${corsApply.finshDate!}<#else>----</#if></td>
        <td><#if corsApply.applyStatusName??>${corsApply.applyStatusName!}</#if></td>
        <td><#if corsApply.orderTypeName??>${corsApply.orderTypeName!}</#if></td>
      </tr>
    </tbody>
  </table>
</div>

<div class="list_tit"><i></i>订单明细</div>
<div class="ads_list">
 <table id="orderDetailsTable" width="100%" border="0" cellspacing="0" cellpadding="0">
    <thead>
      <th width="*">服务类型</th>
      <th width="200">账号数量</th>
      <th width="200">购买时长</th>
      <th width="300">账号类型</th>
    </thead>
    <tbody>
    	<#list corsApply.applyDetailList as applyDetail>
    	  <tr>
	        <td><#if applyDetail??>${applyDetail.bdDeviceAccuracyName!}</#if></td>
	        <td><#if applyDetail??>${applyDetail.applyCount!}</#if></td>
	        <td><#if applyDetail??>${applyDetail.accountUsePeriod!}</#if><#if corsApply.orderType =='torder'>月<#else>年</#if></td>
	        <td><#if applyDetail??>${applyDetail.accountTypeName!}</#if></td>
	      </tr>
    	</#list>
    	<tr>
	        <td colspan="4" id="totalRow"></td>
	    </tr>
    </tbody>
  </table>
</div>


