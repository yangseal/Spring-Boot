<!doctype html>
<html>
<head>
<meta charset="utf-8">
<meta name="keywords" content="">
<meta name="description" content="">
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
<title>首页</title>
</head>	
<body>
<div style="width: 60%;margin:0 auto;">
  <div style="height: 60px; border-bottom:1px #999999 solid; margin-bottom: 20px;">
   <div style="width: 100px; height: auto; float: left;"><img src="${ContextPath!}/public/propaganda/images/logo.png"></div>
   <div style="float: right; line-height: 60px; font-size: 16px; color: #333333;">
       <a href="http://www.bpss.com.cn/" target="_blank" style="color: #086dcc; margin: 0 5px; text-decoration: none;">国家北斗精准服务网</a> 
   </div>
  </div>
  <div style="font-size: 14px; color: #333333; line-height: 30px; margin-bottom: 100px;">
 	<b>尊敬的客户：</b><br>
 		您好！<br>
 		
 		<#-- 购买订单 【forder】 模板 -->
 		 <#if orderType=='forder' && approveRlt?? && approveRlt=='YES' >
 		 
 			您于 ${orderApplyTime!} 在国家北斗精准服务网提交的定位服务购买申请（订单号：${orderNo!}）已通过审核。
			您可登陆国家北斗精准服务网个人管理中心，对相应的入网账号进行管理。
 		 
 		 <#elseif orderType=='forder' && approveRlt?? && approveRlt=='NO'>
 		 
 		  		您于   ${orderApplyTime!} 在国家北斗精准服务网提交的定位服务购买申请（订单号：${orderNo!}）
 			 因  ${approveOpinion!} 原因未能通过审核。<br>
			您可登入国家北斗精准服务网重新提交试用申请。给您带来不便，敬请谅解。 
 		 
 		 </#if>
 		 
 		 
 		 <#-- 试用订单 【torder】 模板 -->
 		 <#if orderType=='torder' && approveRlt?? && approveRlt=='YES' >
 		 
 		 	您于 ${orderApplyTime!} 在国家北斗精准服务网提交的定位服务试用申请（订单号：${orderNo!}）已通过审核。
			您可登陆国家北斗精准服务网个人管理中心，对相应的入网账号进行管理。
			
 		 <#elseif orderType=='torder' && approveRlt?? && approveRlt=='NO'>
 		 
 				 您于   ${orderApplyTime!} 在国家北斗精准服务网提交的定位服务试用申请（订单号：${orderNo!}）
 			 因    ${approveOpinion!} 原因未能通过审核。<br>
			您可登入国家北斗精准服务网重新提交试用申请。给您带来不便，敬请谅解。 
 		 
 		 </#if>
 		 
 		 
 		  <#-- 续费订单 【rorder】 模板 -->
 		 <#if orderType=='rorder' && approveRlt?? && approveRlt=='YES' >

 		 	您于 ${orderApplyTime!} 在国家北斗精准服务网提交的定位服务续费申请（订单号：${orderNo!}）已通过审核。
			您可登陆国家北斗精准服务网个人管理中心，对相应的入网账号进行管理。
 		 
 		 <#elseif orderType=='rorder' && approveRlt?? && approveRlt=='NO'>
 		 
 			 	您于   ${orderApplyTime!} 在国家北斗精准服务网提交的定位服务 续费申请（订单号：${orderNo!}）
 			 因  ${approveOpinion!}原因未能通过审核。<br>
			您可登入国家北斗精准服务网重新提交试用申请。给您带来不便，敬请谅解。
 		 
 		 </#if>
  		
  </div>
  <div style="border-top: 1px #999999 solid; padding-top: 15px; font-size: 14px; line-height: 28px;">
  	此邮件为系统自动发出，请不要回复。如您有任何疑问，敬请登入国家北斗位置服务网联系我们的客户服务中心。<br><br>
  		此致<br>
		国家北斗精准服务网敬上<br>
		感谢您的支持！<br>
  </div>
</div>
</body>
</html>
