<!doctype html>
<html>
<head>
<meta charset="utf-8">
<meta name="keywords" content="">
<meta name="description" content="">
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
<title>国家北斗精准服务网</title>
<#include "/head.ftl"/>
<link rel="stylesheet" href="${rc.contextPath}/public/css/print.css" type="text/css" media="print">
<link rel="stylesheet" href="${rc.contextPath}/public/css/printView.css" type="text/css">
</head>	
<body>
<div class="print">
    <div class="print_bt">
      <a class="btn btn-success print-preview" onclick="printOrderss()">
			<i class="glyphicon glyphicon-print"></i>
    		<span>打印</span>
	  </a>
	</div>
	<script type="text/javascript">
		function printOrderss(){
			window.print();
		}
	</script>
	<div class="print_tit">CROS账号汇总</div>
	<#list corsApply as corsApply>
		<div class="print_table">
		  <table width="100%" border="0" cellspacing="0" cellpadding="0">
		    <caption>${corsApply.company.companyName!}</caption> 
		  	<thead>
		  		<th width="*">入网账号</th>
		  		<th width="180">入网密码</th>
		  		<th width="100">设备精度</th>
		  		<th width="100">设备SN</th>
		  		<th width="100">绑定设备</th>
		  	</thead>
		  	<tbody>
		  		<#if corsApply.corsList ??>
		  		<#list corsApply.corsList as corsAccount>
		  		<tr>
		  			<td>${corsAccount.corsAccountCode!}</td>
		  			<td>${corsAccount.corsAccountPwd!}</td>
		  			<td>${corsAccount.bdDeviceAccuracyName!}</td>
		  			<td>${corsAccount.bdDeviceSn!}</td>
		  			<td>${corsAccount.bdDevice!}</td>
		  		</tr>
		  		</#list>
		  		</#if>
		  	</tbody>
		  </table>
		</div>
	</#list>
</div>
</body>
</html>
