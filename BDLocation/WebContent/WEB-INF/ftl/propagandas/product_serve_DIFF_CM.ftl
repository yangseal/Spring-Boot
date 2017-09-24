<!doctype html>
<html>
<head>
<meta charset="utf-8">
<meta name="keywords" content="">
<meta name="description" content="">
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
<title>厘米级定位服务-差分服务-产品与服务</title>
<#include "./matascript.ftl"/>
</head>	
<body>
<#assign curDiv="productAndService">
<#include "./header.ftl"/>
<div class="wraper bac3">
  <div class="wraper_side">
    <ul class="side_nav">
      <li><p>差分服务</p></li>
      <li><a href="${rc.contextPath}/propagandas/product_serve_DIFF_CM" class="on">厘米级</a></li>
      <li><a href="${rc.contextPath}/propagandas/product_serve_DIFF_yami">亚米级</a></li>
      <li><a href="${rc.contextPath}/propagandas/product_serve_DIFF_meter">米级</a></li>
    </ul>
    <ul class="side_nav">
      <li><p>智能设备</p></li>
      <li><a href="${rc.contextPath}/propagandas/product_serve_RTK">RTK</a></li>
      <li><a href="${rc.contextPath}/propagandas/product_serve_LocationBox">定位盒子</a></li>
      <li><a href="${rc.contextPath}/propagandas/product_serve_differencePhone">差分手机</a></li>
      <li><a href="${rc.contextPath}/propagandas/product_serve_locationPanel">定位平板</a></li>
    </ul>
    <!-- <ul class="side_nav">
      <li><p><a href="javascript:vid(0)">精准应用App</a></p></li>
    </ul> -->
  </div>
  <div class="wraper_con">
    <!-- <div class="bar"><img src="${rc.contextPath}/public/propaganda/images/bar.jpg"></div>
    <div class="pro_colum bac3">联系我们：bdcloud@gassaas.com</div> -->
    <div class="diff_con">
      <div class="diff_tit">厘米级精准定位服务</div>
      <div class="diff_text">
        <p>基于RTK的差分定位原理，依托于遍布全国的卫星定位地基增强站，融合各类定位技术，及后处理的高精定位差分算法，面向特定需求的行业和应用系统，以互联网的方式提供厘米级精度的位置纠偏数据服务。</p>
        <span>
           <a href="javascript:void(0);" class="sy" onclick="transApply('test','milevel')">免费试用</a>
           <a href="javascript:void(0);" class="gm" onclick="transApply('formal','milevel')">购买服务</a>
        </span>
      </div>
      <div class="diff_tit">使用场景</div>
      <div class="diff_text">
        <p class="diff_title">—— 泄漏检测</p>
        <p>结合北斗高精度定位设备，与泄漏检测设备相集成，实现泄漏检测数据和精准位置数据的结构化融合，并自动上传到后台系统中为后续的分析和利用打下基础。不但能够及时掌握现场泄漏检测工作进展情况，发现泄漏检测盲区。还可以逐步积累历史数据，预测泄漏情况发展的趋势，计算区域内管网风险状况，指导各类工作计划的生成和优化。</p>
        <p class="diff_img"><img src="${rc.contextPath}/public/propaganda/temp/diff_img01.jpg"></p>
        <p class="diff_title">—— 防腐检测</p>
        <p>通过使用工业级移动终端设备，结合北斗精准服务，集成管道防腐层专业检测仪（如SL—2088型、PCM+等），实现防腐层检测过程的精细化、精准化、智能化管理，全面提高防腐层检测效率。</p>
        <p class="diff_img"><img src="${rc.contextPath}/public/propaganda/temp/diff_img01.jpg"></p>
      </div>
      <!-- <div class="diff_tit">推荐设备</div>
      <ul class="diff_device">
        <li>
          <p></p>
          <span>设备临时名称</span>
        </li>
        <li>
          <p></p>
          <span>设备临时名称</span>
        </li>
        <li>
          <p></p>
          <span>设备临时名称</span>
        </li>
      </ul> -->
      <div class="diff_tit">覆盖城市</div>
      <div class="diff_city">
        <table width="935" border="0" cellspacing="0" cellpadding="0">
          <tr>
            <td width="200"><b>省份</b></td>
            <td width="*"><b>城市</b></td>
            <td width="120"><b>基站数量</b></td>
          </tr>
          <tr>
            <td>湖南</td>
            <td>长沙、株洲、湘潭、永州、怀化</td>
            <td>9</td>
          </tr>
          <tr>
            <td>江苏</td>
            <td>常州、海安、淮安、盐城、泰兴、连云港、兴化</td>
            <td>7</td>
          </tr>
          <tr>
            <td>安徽</td>
            <td>滁州、蚌埠、巢湖、亳州、六安</td>
            <td>5</td>
          </tr>
          <tr>
            <td>广东</td>
            <td>东莞、肇庆、湛江、广州、河源、汕头、江门、惠州</td>
            <td>14</td>
          </tr>
          <tr>
            <td>浙江</td>
            <td>湖州、海宁、萧山、龙游、永康、衢州、海盐、兰溪、金华、台州、杭州、宁波</td>
            <td>15</td>
          </tr>
          <tr>
            <td>河北</td>
            <td>廊坊、石家庄</td>
            <td>7</td>
          </tr>
          <tr>
            <td>山东</td>
            <td>聊城、青岛、胶州、莱阳、日照、邹平、烟台、胶南、诸城</td>
            <td>10</td>
          </tr>
          <tr>
            <td>福建</td>
            <td>泉州</td>
            <td>3</td>
          </tr>
          <tr>
            <td>河南</td>
            <td>新乡、洛阳、开封、濮阳、商丘</td>
            <td>7</td>
          </tr>
          <tr>
            <td>广西</td>
            <td>桂林、贵港</td>
            <td>2</td>
          </tr>
          <tr>
            <td>内蒙古</td>
            <td>通辽</td>
            <td>1</td>
          </tr>
          <tr>
            <td>辽宁</td>
            <td>葫芦岛、盘锦、锦州</td>
            <td>3</td>
          </tr>
          <tr>
            <td>云南</td>
            <td>昆明</td>
            <td>1</td>
          </tr>
          <tr>
            <td>海南</td>
            <td>海口</td>
            <td>1</td>
          </tr>
          <tr>
            <td>陕西</td>
            <td>西安</td>
            <td>4</td>
          </tr>
          <tr>
            <td>四川</td>
            <td>成都</td>
            <td>4</td>
          </tr>
          <tr>
            <td>北京</td>
            <td>直辖市郊区</td>
            <td>12</td>
          </tr>
          <tr>
            <td>深圳</td>
            <td>特区郊区</td>
            <td>4</td>
          </tr>
          <tr>
            <td>重庆</td>
            <td>直辖市郊区</td>
            <td>4</td>
          </tr>
        </table>
      </div>
    </div>
  </div>
</div>
<#include "./footer.ftl"/>
<script type="text/javascript" src="${rc.contextPath}/public/js/client/commJs/common.js"></script>
</body>
</html>
