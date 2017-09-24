<script type="text/javascript" src="${rc.contextPath}/public/js/client/corsOrders/corsOrders.js"></script>
<div class="ads_con">
	<form id="corsApplysForm" action="${rc.contextPath}/client/mgtCenter/corsOrders/queryApplys">
		<div class="ads_nav">
	      <p class="an_tit">订单管理</p>
	       <p>订单状态：
	         <select name="applyStatus">
	           <option value="">全部</option>
	           <option value="4">已提交</option>
	           <option value="5">已完成</option>
	           <option value="6">已取消</option>
	         </select>
	      </p>
	      
	      <p>订单类型：
	         <select  name="orderType">
	           <option value="">全部</option>
	           <option value="rorder">续费订单</option>
	           <option value="forder">购买订单</option>
	           <option value="torder">试用订单</option>
	         </select>
	      </p>
	     
	    </div>
		<div class="ads_list">
			<div id="corsApplysDiv"></div>
		</div>
	</form>
	<div id="levelTwoContent" style="display:none;">
 		
   	</div>
   	 <div class="hint_box">
        <p>温馨提示</p>
        <span>
			1.订单提交后，工作人员将在1-2个工作日内完成相关业务。<br>
			2.若订单未通过，订单状态将变为“已取消”，需再次进行购买申请。给您带来的不便，敬请谅解。
        </span>
      </div>
</div>


