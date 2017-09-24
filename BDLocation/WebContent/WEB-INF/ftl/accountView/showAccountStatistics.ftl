<!doctype html>
<html>
<head>
	<#include "/head.ftl"/>
	<title>map</title>
	<style type="text/css">
		html,body{
			padding: 0;
			margin: 0;
		}
		.count_con{
		    height: auto;
		    overflow: hidden;
		    padding: 10px;
		}
		.count_co{
		    width: 33%;
		    height: 260px;
		    float: left;
		}
		.cont_a{
		    width: 100%;
		    height: 260px;
		}
		.count_d{
		    overflow: hidden;
		    width: 100%;
		    height: 500px;
		    padding-top: 20px;
		    padding-bottom: 15px;
		}
	</style>
	<script type="text/javascript" src="${rc.contextPath}/public/js/client/commJs/echarts.min.js"></script>
	<script type="text/javascript" src="${rc.contextPath}/public/js/client/commJs/china.js"></script>
	<script type="text/javascript" src="${rc.contextPath}/public/js/accountView/accountStatistics.js"></script>
</head>
<body>
	<div class="count_con">
	  <div class="count_d" id="count_d"></div>
	  
	  <div class="count_co">
	    <div class="cont_a" id="cont_a"></div>
	  </div>
	  
	   <div class="count_co">
	    <div class="cont_a" id="cont_b"></div>
	  </div>
	  
	   <div class="count_co">
	    <div class="cont_a" id="cont_c"></div>
	  </div>
	</div>
</body>
</html>
