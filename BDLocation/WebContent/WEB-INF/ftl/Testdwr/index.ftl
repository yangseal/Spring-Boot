<html>
<head>
<#include "/head.ftl"/>
<script type="text/javascript" src="${rc.contextPath}/public/js/dwr/index.js"></script>
<script type="text/javascript" src="${rc.contextPath}/public/js/lib/jquery-1.5.1.js"></script>
<script type='text/javascript' src='/dwr/engine.js'></script>
<script type='text/javascript' src='/dwr/util.js'></script>
<script type='text/javascript' src='/dwr/interface/MessagePush.js'></script>
<style>
	.has-feedback .form-control {
    	padding-right: 5px;
	}
</style>
</head>
<body onload="onPageLoad();dwr.engine.setActiveReverseAjax(true);dwr.engine.setNotifyServerOnPageUnload(true);"> 
    This is my DWR DEOM page. <hr>
    <br>
    <div id="DemoDiv" style="font-size:15;color:red;"></div>
  </body>
  
</html>
