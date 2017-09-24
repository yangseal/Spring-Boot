<!doctype html>
<html>
<head>
<#include "/head.ftl"/>
<script type="text/javascript" src="${rc.contextPath}/public/js/corsApprove/corsApproves.js"></script>
<script type="text/javascript">  
$(document).ready(function() {   
 var totalRow = 0 
  $('#orderDetailTable tr').each(function() {  
  $(this).find('td:eq(1)').each(function(){  
  totalRow += parseFloat($(this).text()); 
   });  
   });   
    $('#totalRow').append('<td>账号数量合计：&nbsp</td><td></td><td>'+totalRow+' &nbsp 个</td><td></td>');  }); 
 </script>  


</head>
<body>
<form id="constructForm" class="form-horizontal">
	<input type="hidden" id="baseConstructId" name="baseConstruct.baseConstructId" value="<#if baseConstruct??>${baseConstruct.baseConstructId!}</#if>" />
	<input type="hidden" id="isQuery" />
	<#--订单信息-->
	<div class="form-group has-feedback">
		<label id="oamProjectLabel" for="oamProject" class="col-sm-2 control-label ct_tit"><span>订单信息</span></label>
		<div class="col-sm-8">
			<input type="hidden" class="form-control"/>
		</div>
	</div>
	<div class="form-group has-feedback pt15">
		<label id="oamProjectLabel" for="oamProject" class="col-sm-2 control-label">订单号</label>
		<div class="col-sm-2">
			<input type="text" readOnly  class="form-control" id="baseProject"  value="<#if corsApply?? >${corsApply.orderNo!}</#if>"/>
		</div>
		
		<label id="stationNameLabel" for="stationName" class="col-sm-1 control-label">创建时间</label>
		<div class="col-sm-2">
			<input type="text" readOnly class="form-control" id="stationName"   value="<#if corsApply?? >${corsApply.applyDate!}</#if>"/>
		</div>
		
		<label id="stationNameLabel" for="stationName" class="col-sm-1 control-label">完成时间</label>
		<div class="col-sm-2">
			<input type="text" readOnly class="form-control" id="stationNo"   value="<#if corsApply??>${corsApply.finshDate!}</#if>"/>
		</div>
	</div>
	<div class="form-group has-feedback">
		<label id="oamProjectLabel" for="oamProject" class="col-sm-2 control-label">订单状态</label>
		<div class="col-sm-2">
			<input type="text" readOnly class="form-control" id="baseProject"   value="<#if corsApply??>${corsApply.applyStatusName!}</#if>"/>
		</div>
		
		<label id="stationNameLabel" for="stationName" class="col-sm-1 control-label">订单类型</label>
		<div class="col-sm-2">
			<input type="text" readOnly class="form-control" id="stationName"  value="<#if corsApply??>${corsApply.orderTypeName!}</#if>" />
		</div>
	</div>
	<#--订单明细-->
	<div class="form-group has-feedback">
		<label id="oamProjectLabel" for="oamProject" class="col-sm-2 control-label ct_tit"><span>订单明细</span></label>
		<div class="col-sm-8">
			<input type="hidden" class="form-control"/>
		</div>
		<label class="col-sm-2 control-label">&nbsp;</label>
		<div class="col-sm-8">
			<div id="orderDetailContentRegion">
	<table id="orderDetailTable" width="80%" class="table table-striped table-hover">
		<thead>
		      <th width="*">服务类型</th>
		      <th width="200">账号数量</th>
		      <th width="150">购买时长</th>
		      <th width="200">账号类型</th>
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
		</div>
	</div>
	
	
</form>
</body>
</html>