<script type="text/javascript" src="${rc.contextPath}/public/js/client/corsAccounts/showAccounts.js"></script>

  <div class="ads_con">
  <form id="showAccountsForm" action="${rc.contextPath}/accountView/queryAccountViews">
	    <div class="ads_nav">
	      <p class="an_tit">服务账号管理</p>
	      <p>服务类型：
	         <select id="bdDeviceAccuracy" name="bdDeviceAccuracy">
	           <option value="">全部</option>
	           <option value="centimeter">厘米级</option>
	           <option value="meter">亚米级</option>
	           <option value="milevel">米级</option>
	         </select>
	      </p>
	      <p>账号状态：
	         <select id="corsAccountState" name="corsAccountState">
	           <option value="">全部</option>
	           <option value="unactive">未激活</option>
	           <option value="normal">启用中</option>
	           <option value="soon">即将过期</option>
	           <option value="expired">已过期</option>
	         </select>
	      </p>
	      <p style="float:right; margin-right:10px;"><a onclick="doRepayList()" class="ct_btxf">账号续费清单</a></p>
	    </div>
	 <div class="ads_list">
	       <div id="showAccountsDiv"> </div>
     </div>
     </form>
     <div id="levelTwoContent" style="display:none;">
   	</div>
      <div class="hint_box">
		        <p>温馨提示</p>
		        <span>
					1.为保证入网账号的安全使用，在入网账号激活使用前，建议将入网账号的使用区域及设备绑定信息完善，激活申请提交后，区域及设备信息将无法<br>修改。<br>
					2.试用账号如需续费时，需在基本信息管理页面中完善企业资质资料。（若企业资质已认证，此提示可忽略。）<br>
					3.账号激活申请提交后，工作人员将在1-2个工作日内完成相关业务。<br>
					4.试用账号在申请成功后，2个月内未进行激活操作，将自动过期。
		        </span>
	  </div>
  </div>
