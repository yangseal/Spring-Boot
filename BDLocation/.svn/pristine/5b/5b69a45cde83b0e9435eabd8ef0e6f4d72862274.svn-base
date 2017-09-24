<table width="100%" border="0" cellspacing="0" cellpadding="0">
    <thead>
      <th width="*">入网账号</th>
      <th width="200">入网精度</th>
      <th width="200">续费时长</th>
      <th width="300">账号类型</th>
    </thead>
    <tbody>
    	<#list page.result as corsBusiRel>
	      <tr>
	        <td><#if corsBusiRel?? && corsBusiRel.corsAccount??>${corsBusiRel.corsAccount.corsAccountCode!}</#if></td>
	        <td><#if corsBusiRel?? && corsBusiRel.corsAccount??>${corsBusiRel.corsAccount.bdDeviceAccuracyName!}</#if></td>
	        <td><#if corsBusiRel?? && corsBusiRel.corsAccount??>${corsBusiRel.corsRepayPeriod!}年</#if></td>
	        <td><#if corsBusiRel?? && corsBusiRel.corsAccount??>${corsBusiRel.corsAccount.corsAccountTypeName!}</#if></td>
	      </tr>
    	</#list>
    </tbody>
  </table>
  <@common.frontPager page.pageBean "repayDetailOrderForm" "repayDetailOrderDiv"/>