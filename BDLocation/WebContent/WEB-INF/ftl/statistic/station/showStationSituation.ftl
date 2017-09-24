<!doctype html>
<html>
<head>
<#include "/head.ftl"/>
<script type="text/javascript" src="${rc.contextPath}/public/js/statistic/station/stationUseSituation.js"></script>
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
		
		<a  class="btn btn-primary" onclick="resetCondition()">
			<i class="glyphicon glyphicon-search"></i>
    		<span>重置</span>
		</a>
  		
  	</div>
  	
  	<table style="display:none;">
		<tr id="stationUseSituationTrTemp" >
			<td width="100" name="jointime">月份</th>
			<td name="stationname">基站名称</th>
			<td width="90" name="stationno">基站编号</th>
			<td width="90" name="connectnums">连接数</th>
			<td width="90" name="offlinenums">掉线次数</th>
			<td width="120" name="broaddata">播发流量(GB)</th>
		</tr>
	</table>

	<div class="container-fluid">
		  <div class="row">	
			<div class="col-md-6 left">
				<label>天使用情况计</label>
				
				<table class="table" style="width:98%">
					<tr>
						<th width="100">日期</th>
						<th>基站名称</th>
						<th width="90">基站编号</th>
						<th width="90">连接数</th>
						<th width="90">掉线次数</th>
						<th width="120">播发流量(GB)</th>
					</tr>
				</table>
				
				<div id="stationDailyUse" style="height:590px;overflow-y:scroll;">
					<table id="stationDailyUseTable" class="table">
						
					</table>
				</div>
			</div>
			
			<div class="col-md-6 right">
			 	<label>月使用情况统计</label>
			 	
			 	<table class="table" style="width:98%">
					<tr>
						<th width="100">月份</th>
						<th>基站名称</th>
						<th width="90">基站编号</th>
						<th width="90">连接数</th>
						<th width="90">掉线次数</th>
						<th width="120">播发流量(kb)</th>
					</tr>
				</table>
				
				<div id="stationMonUse" style="height:590px;overflow-y:scroll;">
						<table id="stationMonUseTable" class="table">
							
						</table>
				</div>
			</div>
			
		  </div>
	</div>
</form>
</body>
</html>
