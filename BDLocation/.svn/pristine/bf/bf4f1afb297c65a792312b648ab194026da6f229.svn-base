<script type="text/javascript" src="${rc.contextPath}/public/js/accountView/common.js"></script>
<form id="CorsDeviceForm" class="tc_wrap">
	<div class="binding">
		<label id="bdDeviceLabel" for="bdDevice">设备型号</label>
		<input type="text" class="form-control" id="bdDevice" name="bdDevice" value="<#if corsAccount?? && corsAccount.bdDevice??>${corsAccount.bdDevice!}</#if>" isNotNull />		
		<i>*</i>
		<span id="bdDeviceTip"></span>
	</div>
	<div class="binding">
		<label id="bdDeviceSnLabel" for="menuCode">设备SN</label>
		<input type="text" class="form-control" id="bdDeviceSn" name="bdDeviceSn" value="<#if corsAccount?? && corsAccount.bdDeviceSn??>${corsAccount.bdDeviceSn!}</#if>" isNotNull />
		<i>*</i>
		<span id="bdDeviceSnTip"></span>
	</div>
	<input type="hidden" id="corsAccountId" name="corsAccountId" value="<#if corsAccount?? && corsAccount.corsAccountId??>${corsAccount.corsAccountId}</#if>"/>
</form>
<div class="bt_ok">
	<a onclick="saveCorsAccount('CorsDeviceForm');">
		<span>保存</span>
	</a>
</div>
