<!doctype html>
<html>
<head>
<meta charset="utf-8">
<meta name="keywords" content="">
<meta name="description" content="">
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
<title>购买配置</title>
<#include "../common/clientMatascript.ftl"/>
</head>	
<body>
<#assign curDiv="index">
<#include "../../propagandas/header.ftl"/>
	<div class="wraping bac2">
  <div class="title color_black">服务选择</div>
  <div class="wraper step">
    <ul>
      <li>
        <p><img src="${rc.contextPath}/public/propaganda/css_img/lc_img01.png" /></p>
        <span>企业注册</span>
      </li>
      <li>
        <i><img src="${rc.contextPath}/public/propaganda/css_img/lc_jt.png" /></i>
      </li>
      <li>
        <p><img src="${rc.contextPath}/public/propaganda/css_img/lc_img02.png" /></p>
        <span>填选配置</span>
      </li>
      <li>
        <i><img src="${rc.contextPath}/public/propaganda/css_img/lc_jt.png" /></i>
      </li>
      <li>
        <p><img src="${rc.contextPath}/public/propaganda/css_img/lc_img03.png" /></p>
        <span>提交申请</span>
      </li>
      <li>
        <i><img src="${rc.contextPath}/public/propaganda/css_img/lc_jt.png" /></i>
      </li>
      <li>
        <p><img src="${rc.contextPath}/public/propaganda/css_img/lc_img04.png" /></p>
        <span>审&nbsp;核</span>
      </li>
      <li>
        <i><img src="${rc.contextPath}/public/propaganda/css_img/lc_jt.png" /></i>
      </li>
      <li>
        <p><img src="${rc.contextPath}/public/propaganda/css_img/lc_img05.png" /></p>
        <span>完&nbsp;成</span>
      </li>
    </ul>
  </div>
  <div class="wraper buy">
    <!-- list start -->
    <div class="buy_list">
      <div class="bl_txt">
        <p>厘米级服务</p>
        <span>基于RTK的差分定位原理，依托于遍布全国的卫星定位地基增强站，融合各类定位技术，及后处理的高精定位差分算法，面向特定需求的行业和应用系统，以互联网的方式提供厘米级精度的位置纠偏数据服务。</span>
      </div>
      <div class="bl_inp">
         <div class="buy_num_wrap">
           <div class="buy_font">账号数量：</div>
           <div class="buy_num">
             <input type="text" class="spinnerExample">
           </div>
         </div>
         <div class="buy_scope">覆盖范围：<span>部分省市</span></div>
         <div class="buy_time">服务时长：
            <label><input type="radio" value="1" name="cm_buy_time" checked="checked"/> 1年</label>
            <label><input type="radio" value="2" name="cm_buy_time"/> 2年</label>
            <label><input type="radio" value="3" name="cm_buy_time"/> 3年</label>
            <label>其他：<input type="number" class="time_num" /></label>
         </div>
         <div class="buy_join" onclick="addToCard(this,'centimeter');">加入清单</div>
      </div>
    </div>
    <!-- list end -->
    <!-- list start -->
    <div class="buy_list">
      <div class="bl_txt">
        <p>亚米级服务</p>
        <span>基于RTD的差分定位原理，依托于遍布全国的卫星定位地基增强站，融合各类定位技术，以互联网的方式提供7x24小时高可用差分播发服务，面向全国范围内的各类终端和应用系统，提供全国范围内无缝漫游的亚米级精度的位置纠偏数据服务。</span>
      </div>
      <div class="bl_inp">
         <div class="buy_num_wrap">
           <div class="buy_font">账号数量：</div>
           <div class="buy_num">
             <input type="text" class="spinnerExample">
           </div>
         </div>
         <div class="buy_scope">覆盖范围：<span>部分省市</span></div>
         <div class="buy_time">服务时长：
            <label><input type="radio" value="1" name="m_buy_time" checked="checked"/> 1年</label>
            <label><input type="radio" value="2" name="m_buy_time"/> 2年</label>
            <label><input type="radio" value="3" name="m_buy_time"/> 3年</label>
            <label>其他：<input type="number" class="time_num" /></label>
         </div>
         <div class="buy_join" onclick="addToCard(this,'meter');">加入清单</div>
      </div>
    </div>
    <!-- list end -->
    <!-- list start -->
    <div class="buy_list">
      <div class="bl_txt">
        <p>米级服务</p>
        <span>基于RTD的差分定位原理，依托于遍布全国的卫星定位地基增强站，融合各类定位技术，以互联网的方式提供7x24小时高可用差分播发服务，面向全国范围内的各类终端和应用系统，提供全国范围内无缝漫游的米级精度的位置纠偏数据服务。</span>
      </div>
      <div class="bl_inp">
         <div class="buy_num_wrap">
           <div class="buy_font">账号数量：</div>
           <div class="buy_num">
             <input type="text" class="spinnerExample">
             <!-- <p>
               <span><img src="images/buy_num_up.png"></span>
               <span><img src="images/buy_num_down.png"></span>
             </p> -->
           </div>
         </div>
         <div class="buy_scope">覆盖范围：<span>部分省市</span></div>
         <div class="buy_time">服务时长：
            <label><input type="radio" value="1" name="mi_buy_time" checked="checked"/> 1年</label>
            <label><input type="radio" value="2" name="mi_buy_time"/> 2年</label>
            <label><input type="radio" value="3" name="mi_buy_time"/> 3年</label>
            <label>其他：<input type="number" class="time_num" /></label>
         </div>
         <div class="buy_join" onclick="addToCard(this,'milevel');">加入清单</div>
      </div>
    </div>
    <!-- list end -->
    <div class="buy_sub" onclick="transToOrderSubmit()">确认清单</div>
  </div>
</div>
<input type="hidden" id="userId" name="busiApproveUser" value="${CURRENT_USER.userId}"/>
<input type="hidden" id="companyId" name="busiApproveUser" value="${CURRENT_USER.company.companyId}"/>
<#include "../../propagandas/footer.ftl"/>
<script type="text/javascript">
	$('.spinnerExample').spinner({});
(function ($){
	$.extend({
		tipsBox: function (options) {
			options = $.extend({
				obj: null,  //jq对象，要在那个html标签上显示
				str: "+1",  //字符串，要显示的内容;也可以传一段html，如: "<b style='font-family:Microsoft YaHei;'>+1</b>"
				startSize: "12px",  //动画开始的文字大小
				endSize: "30px",    //动画结束的文字大小
				interval: 600,  //动画时间间隔
				color: "red",    //文字颜色
				callback: function () { }    //回调函数
			}, options);
			$("body").append("<span class='num'>" + options.str + "</span>");
			var box = $(".num");
			var left = options.obj.offset().left + options.obj.width() / 2;
			var top = options.obj.offset().top - options.obj.height();
			box.css({
				"position": "absolute",
				"left": left + "px",
				"top": top + "px",
				"z-index": 9999,
				"font-size": options.startSize,
				"line-height": options.endSize,
				"color": options.color
			});
			box.animate({
				"font-size": options.endSize,
				"opacity": "0",
				"top": top - parseInt(options.endSize) + "px"
			}, options.interval, function () {
				box.remove();
				options.callback();
			});
		}
	});
})(jQuery);
</script>

</body>
</html>
