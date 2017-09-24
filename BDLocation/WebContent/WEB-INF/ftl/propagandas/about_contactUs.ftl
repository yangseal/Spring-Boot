<!doctype html>
<html>
<head>
<meta charset="utf-8">
<meta name="keywords" content="">
<meta name="description" content="">
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
<title>关于我们-国家北斗精准服务网</title>
<#include "./matascript.ftl"/>
</head>	
<body>
<#assign curDiv="aboutOurs">
<#include "./header.ftl"/>
<div class="wraper bac3">
  <div class="wraper_side">
    <ul class="side_menu">
      <li><p><a href="${rc.contextPath}/propagandas/about">国家北斗精准服务网</a></p></li>
      <li><p><a href="${rc.contextPath}/propagandas/about_positionAlliance">中国位置网服务联盟</a></p></li>
      <li><p><a href="${rc.contextPath}/propagandas/about_maintenanceUnit">运维单位-讯腾智科</a></p></li>
      <li><p><a href="${rc.contextPath}/propagandas/about_contactUs" class="on">联系方式</a></p></li>
    </ul>

  </div>
  <div class="wraper_con">
    <div class="about_colum">联系方式</div>
    <div class="about_con">
      <p style="font-size: 18px; margin-bottom: 30px;">地址：北京市朝阳区惠新东街23号克劳沃大厦4层<br>
邮 编：100029<br>
电 话：010-64972766<br>
<!-- 商务洽谈：18518314942<br>
技术咨询： 18518314942<br> -->
Email：bdcloud@gasshow.com</p>
    
      <div class="map"><div style="width:864px;height:230px;border:#ccc solid 1px;" id="dituContent"></div></div>
    </div>
    
  </div>
</div>
<#include "./footer.ftl"/>
<script type="text/javascript" src="http://api.map.baidu.com/api?key=&v=1.1&services=true"></script>
<script type="text/javascript">
    //创建和初始化地图函数：
    function initMap(){
        createMap();//创建地图
        setMapEvent();//设置地图事件
        addMapControl();//向地图添加控件
        addMarker();//向地图中添加marker
    }
    
    //创建地图函数：
    function createMap(){
        var map = new BMap.Map("dituContent");//在百度地图容器中创建一个地图
        var point = new BMap.Point(116.429435,39.985291);//定义一个中心点坐标
        map.centerAndZoom(point,17);//设定地图的中心点和坐标并将地图显示在地图容器中
        window.map = map;//将map变量存储在全局
    }
    
    //地图事件设置函数：
    function setMapEvent(){
        map.enableDragging();//启用地图拖拽事件，默认启用(可不写)
        map.enableScrollWheelZoom();//启用地图滚轮放大缩小
        map.enableDoubleClickZoom();//启用鼠标双击放大，默认启用(可不写)
        map.enableKeyboard();//启用键盘上下左右键移动地图
    }
    
    //地图控件添加函数：
    function addMapControl(){
        //向地图中添加缩放控件
  var ctrl_nav = new BMap.NavigationControl({anchor:BMAP_ANCHOR_TOP_LEFT,type:BMAP_NAVIGATION_CONTROL_LARGE});
  map.addControl(ctrl_nav);
        //向地图中添加缩略图控件
  var ctrl_ove = new BMap.OverviewMapControl({anchor:BMAP_ANCHOR_BOTTOM_RIGHT,isOpen:1});
  map.addControl(ctrl_ove);
        //向地图中添加比例尺控件
  var ctrl_sca = new BMap.ScaleControl({anchor:BMAP_ANCHOR_BOTTOM_LEFT});
  map.addControl(ctrl_sca);
    }
    
    //标注点数组
    var markerArr = [{title:"北京讯腾智慧科技股份有限公司",content:"电&nbsp;话：010-64972766<br/>商务洽谈：18518314942",point:"116.429013|39.984476",isOpen:0,icon:{w:23,h:25,l:46,t:21,x:9,lb:12}}
     ];
    //创建marker
    function addMarker(){
        for(var i=0;i<markerArr.length;i++){
            var json = markerArr[i];
            var p0 = json.point.split("|")[0];
            var p1 = json.point.split("|")[1];
            var point = new BMap.Point(p0,p1);
      var iconImg = createIcon(json.icon);
            var marker = new BMap.Marker(point,{icon:iconImg});
      var iw = createInfoWindow(i);
      var label = new BMap.Label(json.title,{"offset":new BMap.Size(json.icon.lb-json.icon.x+10,-20)});
      marker.setLabel(label);
            map.addOverlay(marker);
            label.setStyle({
                        borderColor:"#808080",
                        color:"#333",
                        cursor:"pointer"
            });
      
      (function(){
        var index = i;
        var _iw = createInfoWindow(i);
        var _marker = marker;
        _marker.addEventListener("click",function(){
            this.openInfoWindow(_iw);
          });
          _iw.addEventListener("open",function(){
            _marker.getLabel().hide();
          })
          _iw.addEventListener("close",function(){
            _marker.getLabel().show();
          })
        label.addEventListener("click",function(){
            _marker.openInfoWindow(_iw);
          })
        if(!!json.isOpen){
          label.hide();
          _marker.openInfoWindow(_iw);
        }
      })()
        }
    }
    //创建InfoWindow
    function createInfoWindow(i){
        var json = markerArr[i];
        var iw = new BMap.InfoWindow("<b class='iw_poi_title' title='" + json.title + "'>" + json.title + "</b><div class='iw_poi_content'>"+json.content+"</div>");
        return iw;
    }
    //创建一个Icon
    function createIcon(json){
        var icon = new BMap.Icon("http://app.baidu.com/map/images/us_mk_icon.png", new BMap.Size(json.w,json.h),{imageOffset: new BMap.Size(-json.l,-json.t),infoWindowOffset:new BMap.Size(json.lb+5,1),offset:new BMap.Size(json.x,json.h)})
        return icon;
    }
    
    initMap();//创建和初始化地图
</script>
</body>
</html>
