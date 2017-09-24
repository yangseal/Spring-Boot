<!doctype html>
<html>
<head>
<#include "/head.ftl"/>
<script type="text/javascript" src="${rc.contextPath}/public/js/statistic/cors/corsUseSituation.js"></script>
<style>
	.has-feedback .form-control {
    	padding-right: 0px;
	}
</style>
</head>
<body style="overflow-y:hidden;">
<form>
	<div class="form-inline">
	
		<div class="form-group has-feedback">
			<div class="col-sm-4">
				<label>统计时间</label>
			</div>
			<div class="col-sm-7">
				<input type="text" class="form-control" readOnly id="statisticTime" name="statisticTime" onclick="WdatePicker({dateFmt:'yyyy-MM-dd'});" />
				<span class="glyphicon glyphicon-menu-hamburger form-control-feedback"></span>
			</div>
		</div>

  		<a  class="btn btn-primary" onclick="searchStatisticByDay()">
			<i class="glyphicon glyphicon-search"></i>
    		<span>查询</span>
		</a>
		
		<a  class="btn btn-success" onclick="resetCondition()">
			<i class="glyphicon glyphicon-search"></i>
    		<span>重置</span>
		</a>
  		
  	</div>
  	
	<table style="display:none;">
		<tr id="corsUseSituationTrTemp" >
			<td width="120" name="accesstime">2017-3-29</td>
			<td width="215" name="companyname">北京排水集团</td>
			<td width="90" name="totalaccount">256</td>
			<td width="90" name="activeaccount">126</td>
			<td width="90" name="activefate">75</td>
			<td width="125" name="broaddata">525M</td>
		</tr>
	</table>
		

		<div class="container-fluid">
			  <div class="row">	
				<div class="col-md-6 left">
					<label>天活跃统计</label>
					
					<table class="table" style="width:98%">
						<tr>
							<th width="120">日期</th>
							<th width="215">公司名称</th>
							<th width="90">账号总数</th>
							<th width="90">活跃数</th>
							<th width="90">活跃率(%)</th>
							<th width="125">消耗流量(kb)</th>
						</tr>
					</table>
						
					<div id="corsDailyUseSituation" style="height:590px;overflow-y:scroll;">
						<table id="corsDailyUseSituationTable" class="table">
							
						</table>
					</div>
				</div>
				
				<div class="col-md-6 right">
				 	<label>月活跃统计</label>
				 	
				 	<table class="table" style="width:98%">
						<tr>
							<th width="120">月份</th>
							<th width="215">公司名称</th>
							<th width="90">账号总数</th>
							<th width="90">活跃数</th>
							<th width="90">活跃率(%)</th>
							<th width="125">消耗流量(kb)</th>
						</tr>
					</table>
					
					<div id="corsMonthUseSituation" style="height:590px;overflow-y:scroll;">
						
						<table id="corsMonthUseSituationTable" class="table">
							
						</table>
					</div>
				</div>
				
			  </div>
		</div>
</form>
</body>
</html>
