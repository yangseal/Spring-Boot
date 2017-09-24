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
		<h3 style="margin-top:5px;">cors实时运行日志</h3>
		<span id="rendCurrTableTime" style="margin-top:5px;color:red;display:none;">2017-03-29 13:46:56</span>
	 	<table class="table" style="width:99%;">
			<tr>
				<th width="16%">公司名称</th>
				<th width="12%">CORS账号</th>
				<th width="12%">设备机型</th>
				<th width="12%">接入点</th>
				<th>接入时间</th>
				<th width="9%">在线时长</th>
				<th width="9%">解类型</th>
				<th width="9%">接受数据(Bit)</th>
				<th width="9%">发送数据(Bit)</th>
			</tr>
		</table>
		<table id="corsTableRealtimeLogsTemp" class="table" style="display:none;">
				<tr id="corsTrRealtimeLogsTemp" style="display:none;">
					<td width="16%" name="compay">1</td>
					<td width="12%" name="corsCode">2单号</td>
					<td width="12%" name="deviceSn">444</td>
					<td width="12%" name="access">66666</td>
					<td name="accessTime">5555</td>
					<td width="9%" name="onlineTime">333</td>
					<td width="9%" name="resolveType">77777</td>
					<td width="9%" name="receiveData">9999</td>
					<td width="9%" name="sendData">9999</td>
				</tr>
		</table>
		
		<div id="corsRealtimeContent" style="height:560px;overflow-y:scroll;">
		
			<table class="table">
				<#if  corsRealList?? && (corsRealList?size gt 0)>
					<span style="margin-top:5px;color:red;">${.now?string("yyyy-MM-dd HH:mm:ss")}</span>	
					<#list corsRealList as result>
					<tr>
						<td width="16%">${result.companyName!}</td>
						<td width="12%">${result.accountCode!}</td>
						<td width="12%">${result.deviceSn!}</td>
						<td width="12%">${result.access!}</td>
						<td>${result.accessTime!}</td>
						<td width="9%">${result.onlineTime!}</td>
						<td width="9%">${result.resolveType!}</td>
						<td width="9%">${result.receiveData!}</td>
						<td width="9%">${result.sendData!}</td>
					</tr>
				</#list>
				</#if>
			</table>
		
		</div>
	</form>
</body>
</html>
