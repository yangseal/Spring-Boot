<!doctype html>
<html>
<head>
<#include "/head.ftl"/>
<script type='text/javascript' src='${rc.contextPath}/dwr/engine.js'></script>
<script type='text/javascript' src='${rc.contextPath}/dwr/util.js'></script>
<script type='text/javascript' src='${rc.contextPath}/dwr/interface/MessagePush.js'></script>
<script type="text/javascript" src="${rc.contextPath}/public/js/statistic/realtime/corsAndStationRealtime.js"></script>
</head>
<body style="overflow-y:hidden;"  onload="onPageLoad();dwr.engine.setActiveReverseAjax(true);dwr.engine.setNotifyServerOnPageUnload(true);">
	<form>
	 	<h3 style="margin-top:5px;">基站实时运行日志</h3>
	 	<table class="table" style="width:99%;">
			<tr>
				<th width="15%">所属公司</th>
				<th width="15%">基站名称</th>
				<th width="8%">基站编号</th>
				<th>接入点</th>
				<th width="12%">基站接入时间</th>
				<th width="9%">当前连接用户数</th>
				<th width="6%">状态</th>
				<th width="8%">播发数据(Bit)</th>
			</tr>
		</table>
		<span id="rendCurrTableTime" style="margin-top:5px;color:red;display:none;">2017-03-29 13:46:56</span>
		<table id="corsTableRealtimeLogsTemp" class="table" style="width:85%;margin-left:7%;display:none;">
				<tr id="corsTrRealtimeLogsTemp" style="display:none;">
					<td width="15%" name="compay">1</td>
					<td width="15%" name="stationName">2单号</td>
					<td width="8%" name="stationNo">2单号</td>
					<td name="access">444</td>
					<td width="12%" name="joinTime">66666</td>
					<td width="9%" name="connectNums">5555</td>
					<td width="6%" name="stationState">333</td>
					<td width="8%" name="broadcastData">77777</td>
				</tr>
		</table>
		
		<div id="stationRealtimeContent" style="height:560px;overflow-y:scroll;">
			<table class="table">
				<#if  stationRealList?? && (stationRealList?size gt 0)>
					<span style="margin-top:5px;color:red;">${.now?string("yyyy-MM-dd HH:mm:ss")}</span>	
					<#list stationRealList as result>
					<tr>
						<td width="15%">${result.companyName!}</td>
						<td width="15%">${result.stationName!}</td>
						<td width="8%">${result.stationNo!}</td>
						<td>${result.access!}</td>
						<td width="12%">${result.joinTime!}</td>
						<td width="9%">${result.connectNums!}</td>
						<td width="6%">${result.stationState!}</td>
						<td width="8%">${result.broadcastData!}</td>
					</tr>
				</#list>
				</#if>
			</table>
			
		</div>
		
	</form>
</body>
</html>
