<script type="text/javascript" src="${rc.contextPath}/public/js/accountView/common.js"></script>
<form id="CorsAccountForm">
	<div class="renewals">
		<p id="accountTypeLabel" for="accountUserPeriod">使用期限：</p>
		<label><input  type="radio"   name="accountPeriod" value="1" checked>1年</label>
		<label><input type="radio"  name="accountPeriod" value="2">2年</label>	
		<label><input type="radio"  name="accountPeriod" value="3">3年</label>	
		<p>其他：<input type="number" class="period" id="accountPeriod" >年</p>		
	</div>
	<input type="hidden" id="corsAccountId" name="corsAccountId" value="<#if corsAccount?? && corsAccount.corsAccountId??>${corsAccount.corsAccountId}</#if>"/>
	<input type="hidden" id="corsAccountType" name="corsAccountType" value="<#if corsAccount?? && corsAccount.corsAccountType??>${corsAccount.corsAccountType}</#if>"/>
</form>
<div class="bt_ok bt_ok_pa">
	<a onclick="addRepayApply('${corsAccount.corsAccountId!}');">
		<span>加入清单</span>
	</a>
</div>
