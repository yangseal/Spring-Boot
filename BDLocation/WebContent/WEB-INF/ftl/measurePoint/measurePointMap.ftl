<!doctype html>
<html>
<head>
<title>测量点地图查看</title>

<link href="${rc.contextPath}/public/css/main.css" type="text/css" rel="stylesheet" />
<script src="${rc.contextPath}/public/js/lib/jquery-1.11.1.min.js"></script> 
<script src="${rc.contextPath}/public/js/lib/QueryString.js"></script> 
<script src="http://api.tianditu.com/js/maps.js"></script> 

<#include "../incl/Include_AutoNavi.ftl" />

<script>
var rootDirectoryURL="${rc.contextPath}"; 
var selectPoints = '${RequestParameters["selectPoints"]}';
</script>

<script src="${rc.contextPath}/public/js/map/MeasurePoint.js"></script>

</head>

<body class="bg">

	 <div id="map-wrap" style="position:absolute;width:99%; height:99%"></div>
	 <div class="mapChange"  onclick="piChange()"></div>			
   
</body>
</html>