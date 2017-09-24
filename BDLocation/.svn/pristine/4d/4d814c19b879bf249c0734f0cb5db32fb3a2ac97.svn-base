<link rel="stylesheet" href="${rc.contextPath}/public/css/location.css"/>
<script type="text/javascript" src="${rc.contextPath}/public/js/accountView/common.js"></script>
<form id="CorsRegionForm">
	<div class="sel_city">
		<p>区域选择：</p>
		<div class="city_select">
	        <div id="store-selector">
	            <div class="text" style="width:200px;"><div></div><b></b></div>                   
	            <div class="close"></div>
	        </div><i>*</i><!--store-selector end-->
	        <div id="store-prompt"><strong></strong></div><!--store-prompt end--->
	       <input type="hidden" location="oamAreaId" name="oamArea.oamAreaId" class="city" value="<#if corsAccount?? && corsAccount.oamArea??>${corsAccount.oamArea.oamAreaId!}</#if>" /><!-- get city id-->
	  		<input type="hidden" id="address" value="<#if corsAccount?? && corsAccount.oamArea??>${corsAccount.oamArea.oamAreaName!}</#if>" />
	    </div>
		<span id="oamAreaTip"></span>
	</div>
	
	<div class="sel_remark">
		<label id="remarkLabel" for="remark" >备注：&emsp;&emsp;</label>
		<textArea id="remark" name="remark" type="text"><#if corsAccount?? && corsAccount.remark??>${corsAccount.remark!}</#if></textArea>
	</div>
	<input type="hidden" id="corsAccountId" name="corsAccountId" value="<#if corsAccount?? && corsAccount.corsAccountId??>${corsAccount.corsAccountId}</#if>"/>
</form>
<div class="bt_ok bt_ok_pa">
	<a onclick="saveCorsAccount('CorsRegionForm');">
	    <span>保存</span>
	</a>
</div>
<script type="text/javascript" src="${rc.contextPath}/public/js/location/location.js"></script>
