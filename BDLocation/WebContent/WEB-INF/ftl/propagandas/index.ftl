<!doctype html>
<html>
<head>
<meta charset="utf-8">
<meta name="keywords" content="">
<meta name="description" content="">
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
<title>国家北斗精准服务网</title>
<#include "./matascript.ftl"/>
</head>	
<body>
<#assign curDiv="index">
<#include "./header.ftl"/>
<div class="banner">
 <div class="bannerc">
  <div id="slideBox" class="slideBox">
      <div class="hd">
        <ul>
         <li></li>
         <li></li>
         <li></li>
         <li></li>
        </ul>
      </div>
      <div class="bd">
        <ul>
          <li><a href="#" target="_blank"><img src="${rc.contextPath}/public/propaganda/images/banner1.jpg" /></a></li>
          <li><a href="#" target="_blank"><img src="${rc.contextPath}/public/propaganda/images/banner2.jpg" /></a></li>
          <li><a href="#" target="_blank"><img src="${rc.contextPath}/public/propaganda/images/banner3.jpg" /></a></li>
          <li><a href="#" target="_blank"><img src="${rc.contextPath}/public/propaganda/images/banner4.jpg" /></a></li>
        </ul>
      </div>
      <!-- <a class="prev" href="javascript:void(0)"></a>
      <a class="next" href="javascript:void(0)"></a> -->

    </div>
  </div>
</div>
<div class="wraping bac1">
   <div class="wrap ofhd mgat feature">
     <ul>
       <li>
         <a href="javascript:vid(0)" target="_self" onclick="transApply('test','milevel')">
           <p></p>
           <span><b>免费试用</b>企业用户免费体验</span>
         </a>
       </li>
       <li>
         <a href="register" target="_self">
           <p></p>
           <span><b>极速开户</b>最快3小时拿到账户</span>
         </a>
       </li>
       <li>
         <a href="javascript:vid(0)" target="_self">
           <p></p>
           <span><b>全天服务</b>7*24小时技术支持</span>
         </a>
       </li>
       <li>
         <a href="javascript:vid(0)" target="_self">
           <p></p>
           <span><b>安全可靠</b>100%保证数据安全</span>
         </a>
       </li>
     </ul>
   </div>
</div>
<div class="wraping bac2">
  <div class="title color_black">产品与服务</div>
  <div class="wrap mgat product">
    <ul>
      <li>
        <div class="pro_tit">
          <p></p>
          <span><b>差分服务</b>为企业提供高质量精准位置数据</span>
        </div>
        <div class="pro_title">
          “北斗精准服务网”，可以为高精度定位设备提供亚米乃至厘米级精准定位服务。截止2015年底，“百城百联百用”北斗精准服务网已在全国3个直辖市，16个省，超过300个城市完成覆盖工作，并将陆续有新的基准站点建成、整合并网。
        </div>
        <div class="pro_list">
          <p>厘米级</p>
          <p>亚米级</p>
          <p>米级</p>
        </div>
        <div class="pro_detail">
          <p><a href="javascript:vid(0)" target="_blank">差分方案服务</a></p>
          <span>为用户提供高质量精准位置坐标，目前可提供米级、亚米级，
甚至厘米级精准位置服务。。</span>
          <a href="${rc.contextPath}/propagandas/product_serve_DIFF_CM" class="scan" target="_blank">查看详情</a>
        </div>
        <div class="pro_nav">
          <p>
            <a href="javascript:vid(0)" target="_blank">米级位置服务</a>
            <span>为路面巡检、5米线巡检等业务提供基本定位服务</span>
            <!-- <a href="${rc.contextPath}/propagandas/product_serve_DIFF_meter" class="sou" target="_blank">立即搜索</a> -->
            <a href="javascript:void(0);" class="try" onclick="transApply('test','milevel')">免费试用</a>
            <a href="javascript:void(0);" class="buy" onclick="transApply('formal','milevel')">立即购买</a>
          </p>
          <p>
            <a href="javascript:vid(0)" target="_blank">亚米级位置服务</a>
            <span>适用于对精度要求更高或更专业领域的厘米级高精定位服务</span>
            <!-- <a href="${rc.contextPath}/propagandas/product_serve_DIFF_yami" class="sou" target="_blank">立即搜索</a> -->
            <a href="javascript:void(0);" class="try" onclick="transApply('test','meter')">免费试用</a>
            <a href="javascript:void(0);" class="buy" onclick="transApply('formal','meter')">立即购买</a>
          </p>
          <p>
            <a href="javascript:vid(0)" target="_blank">厘米级位置服务</a>
            <span>为泄漏检测、防腐检测等专业检测提供高精度定位服务</span>
            <!-- <a href="${rc.contextPath}/propagandas/product_serve_DIFF_CM" class="sou" target="_blank">立即搜索</a> -->
            <a href="javascript:void(0);" class="try" onclick="transApply('test','centimeter')">免费试用</a>
            <a href="javascript:void(0);" class="buy" onclick="transApply('formal','centimeter')">立即购买</a>
          </p>
        </div>
      </li>
      <li class="on">
        <div class="pro_tit">
          <p></p>
          <span><b>智能设备</b>多种定位设备可供选择</span>
        </div>
        <div class="pro_title">提供RTK、便携式定位盒、差分手机、定位平板等
多种定位设备，满足不同用户的不同业务场景。</div>
        <div class="pro_list">
          <p>RTK</p>
          <p>定位盒</p>
          <p>差分手机</p>
          <p>定位平板</p>
        </div>
        <div class="pro_detail">
          <p><a href="javascript:vid(0)" target="_blank">智能设备方案服务</a></p>
          <span>不同的定位设备可适用于各类业务场景，根据专业需要，
选择适合的设备。</span>
          <a href="${rc.contextPath}/propagandas/product_serve_RTK" class="scan" target="_blank">查看详情</a>
        </div>
        <div class="pro_nav">
          <p>
            <a href="javascript:vid(0)" target="_blank">RTK</a>
            <span>适用于对精度要求更高或更</span>
            <a href="${rc.contextPath}/propagandas/product_serve_RTK" class="sou" target="_blank">立即搜索</a>
          </p>
          <p>
            <a href="javascript:vid(0)" target="_blank">定位盒子</a>
            <span>适用于对精度要求更高或更</span>
            <a href="${rc.contextPath}/propagandas/product_serve_LocationBox" class="sou" target="_blank">立即搜索</a>
          </p>
          <p>
            <a href="javascript:vid(0)" target="_blank">差分手机</a>
            <span>适用于对精度要求更高或更</span>
            <a href="${rc.contextPath}/propagandas/product_serve_differencePhone" class="sou" target="_blank">立即搜索</a>
          </p>
          <p>
            <a href="javascript:vid(0)" target="_blank">定位平板</a>
            <span>适用于对精度要求更高或更</span>
            <a href="${rc.contextPath}/propagandas/product_serve_locationPanel" class="sou" target="_blank">立即搜索</a>
          </p>
        </div>
      </li>
      <li>
        <div class="pro_tit">
          <p></p>
          <span><b>精准应用App</b>集成多种设备的定位App</span>
        </div>
        <div class="pro_title">兼容多种北斗定位设备，提供标准数据接口，即可在普通安卓机上使用，也用在专业的差分手机中使用。</div>
        <div class="pro_list">
          <p>稳定性</p>
          <p>扩展性强</p>
          <p>易于集成</p>
          <p>简单易用</p>
        </div>
        <div class="pro_detail">
          <p><a href="javascript:vid(0)" target="_blank">精准应用App方案服务</a></p>
          <span>精准应用App作为北斗定位设备与专业检测设备的桥梁，可
将位置数据与检测数据相融合。</span>
          <a href="#" class="scan" target="_blank">查看详情</a>
        </div>
        <div class="pro_nav">
          <p>
            <a href="javascript:vid(0)" target="_blank">稳定性</a>
            <span>自动分析回传数据，剔除不良数据信号，
保证网络数据稳定可靠</span>
            <a href="#" class="sou" target="_blank">立即搜索</a>
          </p>
          <p>
            <a href="javascript:vid(0)" target="_blank">扩展性强</a>
            <span>可兼容多种北斗定位设备，支持蓝牙、
串口、WiFi、本身的连接方式</span>
            <a href="#" class="sou" target="_blank">立即搜索</a>
          </p>
          <p>
            <a href="javascript:vid(0)" target="_blank">易于集成</a>
            <span>提供标准数据接口，方便和企业现有平
台等进行集成</span>
            <a href="#" class="sou" target="_blank">立即搜索</a>
          </p>
          <p>
            <a href="javascript:vid(0)" target="_blank">简单易用</a>
            <span>采用互联网产品思维设计，简单易用，
用户经过少量培训即可熟练使用</span>
            <a href="#" class="sou" target="_blank">立即搜索</a>
          </p>
        </div>
      </li>
    </ul>
  </div>
</div>
<div class="apply">
   <div class="title color_while">行业应用</div>
   <div class="apply_ul">
     <li>
       <a href="${rc.contextPath}/propagandas/scheme_cityGas" target="_blank">
         <p class="apply_imgt"><img src="${rc.contextPath}/public/propaganda/images/trade01.png"></p>
         <p class="apply_imgb"><img src="${rc.contextPath}/public/propaganda/images/right_arrow.png"></p>
         <span class="apply_txtt">城市燃气</span>
         <span class="apply_txtb">北斗系统的精准位置服务，可以为燃气业务链的各项数据加载精准的坐标和时间参数，建立可信可用的数据底层基础。</span>
       </a>
     </li>
     <li>
       <a href="${rc.contextPath}/propagandas/scheme_cityDrain" target="_blank">
         <p class="apply_imgt"><img src="${rc.contextPath}/public/propaganda/images/trade04.png"></p>
         <p class="apply_imgb"><img src="${rc.contextPath}/public/propaganda/images/right_arrow.png"></p>
         <span class="apply_txtt">城市给排水</span>
         <span class="apply_txtb">利用北斗卫星、物联网等先进技术，给智慧给排水管网监测系统带来了新的解决思路，可使行业监管工作逐步从传统方式过渡到信息化管理方式。</span>
       </a>
     </li>
     <li>
       <a href="${rc.contextPath}/propagandas/scheme_heatAddition" target="_blank">
         <p class="apply_imgt"><img src="${rc.contextPath}/public/propaganda/images/trade03.png"></p>
         <p class="apply_imgb"><img src="${rc.contextPath}/public/propaganda/images/right_arrow.png"></p>
         <span class="apply_txtt">供热行业</span>
         <span class="apply_txtb">城镇供热管网作为“城市生命线”的重要组成部分，安全问题面临巨大挑战，需要精准的位置服务为管网安全保驾护航，国家北斗精准服务网在供热行业的应用意义重大。</span>
       </a>
     </li>
     <li>
       <a href="${rc.contextPath}/propagandas/scheme_cityPower" target="_blank">
         <p class="apply_imgt"><img src="${rc.contextPath}/public/propaganda/images/trade02.png"></p>
         <p class="apply_imgb"><img src="${rc.contextPath}/public/propaganda/images/right_arrow.png"></p>
         <span class="apply_txtt">城市电力</span>
         <span class="apply_txtb">电力系统随着时代的进步在不断改革与发展，电力系统内也越来越依赖导航定位系统，电网、电力企业的营销和电力建设等方面也将更加广泛使用导航定位系统。</span>
       </a>
     </li>
     
     
     <li>
       <a href="javascript:vid(0)" target="_blank">
         <p class="apply_imgt"><img src="${rc.contextPath}/public/propaganda/images/trade05.png"></p>
         <p class="apply_imgb"><img src="${rc.contextPath}/public/propaganda/images/right_arrow.png"></p>
         <span class="apply_txtt">敬请期待</span>
         <span class="apply_txtb" style="text-align: center;">......</span>
       </a>
     </li>
   </div>
</div>
<div class="wraping bac2">
   <div class="title color_black">成功案例</div>
   <div class="wrap mgat hgat case">
     <ul>
       <li>
         <a href="${rc.contextPath}/propagandas/case1" target="_blank">
           <p><img src="${rc.contextPath}/public/propaganda/temp/case_ul_img1.jpg"></p>
           <span>北京燃气Picarro泄漏检测</span>
         </a>
       </li>
       <li>
         <a href="${rc.contextPath}/propagandas/case_drain" target="_blank">
           <p><img src="${rc.contextPath}/public/propaganda/temp/case_ul_img2.jpg"></p>
           <span>北京排水集团</span>
         </a>
       </li>
       <li>
         <a href="${rc.contextPath}/propagandas/case_antiseptic" target="_blank">
           <p><img src="${rc.contextPath}/public/propaganda/temp/case_ul_img3.jpg"></p>
           <span>北京燃气防腐检测</span>
         </a>
       </li>
       <li>
         <a href="${rc.contextPath}/propagandas/case_inspection" target="_blank">
           <p><img src="${rc.contextPath}/public/propaganda/temp/case_ul_img4.jpg"></p>
           <span>北京燃气燃智能巡检</span>
         </a>
       </li>
       <li>
         <a href="${rc.contextPath}/propagandas/case_trailer" target="_blank">
           <p><img src="${rc.contextPath}/public/propaganda/temp/case_ul_img5.jpg"></p>
           <span>绿源达拖车监控</span>
         </a>
       </li>
       <li>
         <a href="${rc.contextPath}/propagandas/case_jingzhou" target="_blank">
           <p><img src="${rc.contextPath}/public/propaganda/temp/case_ul_img.jpg"></p>
           <span>锦州智能巡检</span>
         </a>
       </li>
     </ul>
   </div>
</div>
<div class="wraper placeholder">
  <div class="title color_black">全国基站覆盖情况</div>
  <div class="placeholder_img"><a href="${rc.contextPath}/oamBaseStationMap/base_main" target="_blank"><img src="${rc.contextPath}/public/propaganda/images/map.jpg"></a></div>
  <div class="placeholder_txt">
    <p>全国可享北斗精准位置服务</p>
    <span>截止2015年底，北斗精准位置服务网已覆盖超过300个城市</span>
    <a href="${rc.contextPath}/oamBaseStationMap/base_main" target="_blank">了解更多</a>
  </div>
  <ul class="placeholder_ul">
    <li>
      <p>1000+</p>
      <span>国内基站</span>
    </li>
    <li>
      <p>300+</p>
      <span>覆盖城市</span>
    </li>
    
  </ul>
</div>
<div class="enroll">
  <p>现在注册,企业用户即可享受超值优惠</p>
  <a href="register">立即注册</a>
</div>

<#--  在线客服	-->
<div class="online">
  <div class="bt_service"></div>
  <div class="bt_try"></div>
  <div class="bt_code">
     <div class="bt_code_img">
       <p><img src="${rc.contextPath}/public/img/bt_code_img.jpg"></p>
       <span>手机访问</span>
     </div>
  </div>
  <div class="go_top"></div>
</div>



<#include "./footer.ftl"/>
<script type="text/javascript" src="${rc.contextPath}/public/js/client/commJs/common.js"></script>
<script type="text/javascript" src="${rc.contextPath}/public/propaganda/js/jquery.SuperSlide.2.1.1.js"></script>
<script type="text/javascript">
 jQuery(".slideBox").slide({mainCell:".bd ul",autoPlay:true});
 
 $('.product li').mouseenter(function () {
      if (!$(this).is(':animated')) {
           $(this).animate({ width: '38%',height:'650px' }, 150).siblings().animate({ width: '30%' ,height:'620px'}, 150);
           $('.product li').removeClass("on");
           $(this).addClass("on");
      }
 });
 
 $(function(){
	 //显示二维码
	 $(".bt_code").mouseover(function () {
	      $(this).find(".bt_code_img").show();
	 }).mouseleave(function(){
	      $(this).find(".bt_code_img").hide();
	 });
	 
	 // 滚动隐藏显示
	 function gotopShow(ediv){
	     h = $(window).height();
	     t = $(document).scrollTop();
	     if(t > h){
	        $(ediv).fadeIn('slow');
	     }else{
	        $(ediv).fadeOut('slow');
	     }
	 }
	 
	 $(window).scroll(function(e){
	     gotopShow('.go_top');   
	 });
	 
	// 回到顶部
	$(".go_top").click(function(){
	     $("html, body").animate({ scrollTop: 0 }, "slow");
	     return false;
	 });
	 
	 
	 /**
	 * window.open with post method
	 */
	function openWindowWithPost(url, name) {
	    var newWindow = window.open(url, name,'width=734px,height=544px');
	    if (!newWindow){
	        return false;
	    }
	    var html = "";
	    html += "<html><head></head><body><form id='formid' method='post' action='"    + url + "'>";
		html += "<input type='hidden' name='userType' value='customer'/>";
		html += "</form><script type='text/javascript'>document.getElementById('formid').submit()<\/script><\/body><\/html>";
		 
	    newWindow.document.write(html);
	    return newWindow;
	   
	}
	 
	 
	$(".bt_service").click(function(){
		var url = CONTEXT_PATH + "/msg/login";
		openWindowWithPost(url,'讯腾客服',{'userType':'customer'});
	});
	
 });
    
</script>
</body>
</html>
