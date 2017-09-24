<!doctype html>
<html>
<head>
	<style type="text/css">
		.tip_box{
		  position: absolute;
		  width: 400px;
		  height: 36px;
		  /*overflow: hidden;*/
		  border: 1px #0427ab solid;
		  background-color: #fff;
		  top: 20px;
		  right: 20px;
		  z-index: 999;
		}
		.tip_box span{
		  font-size: 14px;
		  color: #333333;
		  line-height: 36px;
		  vertical-align: middle;
		  padding-left: 15px;
		  font-weight: bold;
		}
		.tip_box i{
		  font-style: normal;
		}
		.tip_box span.turn_on{
		  color: #028833;
		}
		.tip_box span.turn_off{
		  color: #999999;
		}
		.tip_box p{
		  width: 60px;
		  height: 34px;
		  font-size: 14px;
		  color: #ffffff;
		  line-height: 34px;
		  vertical-align: middle;
		  font-weight: bold;
		  text-align: center;
		  background-color: #075dbc;
		  letter-spacing: 1px;
		  cursor: pointer;
		  float: right;
		}
		.select_con{
		  position: absolute;
		  width: 400px;
		  height: auto;
		  overflow: hidden;
		  border: 1px #cccccc solid;
		  background-color: #fff;
		  top: 55px;
		  right: 20px;
		  z-index: 998;
		  display: none;
		}
		.sel_box{
		  padding: 15px 15px;
		  padding-right: 0;
		  font-size: 14px;
		  line-height: 30px;
		  color: #333333;
		  border-bottom: 1px #cccccc solid;
		  overflow: hidden;
		  padding-bottom: 3px;
		  margin-bottom: -1px;
		  position: relative;
		}
		.sel_box p{
		  display: inline-block;
		  float: left;
		  overflow: hidden;
		  margin-bottom: 8px;
		  margin-right: 20px;
		}
		.sel_box p label{
		  padding-right: 5px;
		  cursor: pointer;
		  display: inline-block;
		}
		.sel_box select{
		  border: 1px #cccccc solid;
		  height: 30px;
		  padding: 0 5px;
		  outline: none;
		  font-family:"Microsoft Yahei","SimHei","SimSun", Geneva, sans-serif;
		}
		.sel_box input[type="text"]{
		  width: 163px;
		  border: 1px #cccccc solid;
		  height: 30px;
		  padding: 0 5px;
		  outline: none;
		  line-height: 30px;
		  vertical-align: middle;
		  font-size: 14px;
		  color: #333333;
		}
		.sel_box input[type="radio"]{
		  cursor: pointer;
		  margin-left: 10px;
		  float: right;
		  margin-top: 10px;
		}
		.sel_box span{
		  display: inline-block;
		  cursor: pointer;
		  width: 60px;
		  height: 30px;
		  overflow: hidden;
		  background-color: #028833;
		  color: #ffffff;
		  text-align: center;
		  line-height: 30px;
		  vertical-align: middle;
		  font-size: 14px;
		  border-radius: 1px;
		  margin-left: 42px;
		}
		.sel_box i{
		  position: absolute;
		  width: 60px;
		  height: 60px;
		  border-radius: 50%;
		  border: 1px #333333 solid;
		  background-color: rgba(0,0,0,0.5);
		  bottom: -30px;
		  right: -30px;
		  cursor: pointer;
		  font-size: 26px;
		  color: #ffffff;
		  line-height: 30px;
		  vertical-align: middle;
		  text-indent: 8px;
		  font-weight: normal;
		  font-style: normal;
		}
		.sel_ul{
		  height: 269px;
		  overflow-y:auto;
		  padding: 10px 0;
		  /*display: none;*/
		}
		.sel_ul li{
		  height: 30px;
		  padding: 0 15px;
		  overflow: hidden;
		  line-height: 30px;
		  vertical-align: middle;
		  font-size: 14px;
		  cursor: pointer;
		}
		.sel_ul li:hover{
		  background-color: #eeeeee;
		}
		.sel_ul li i{
		  display: inline-block;
		  height: 10px;
		  width: 10px;
		  overflow: hidden;
		  border-radius: 50%;
		  margin-right: 15px;
		  float: left;
		  margin-top: 10px;
		  font-style: normal;
		}
		.sel_ul li i.site_on{
		  font-style: normal;
		  background-color: #028833;
		}
		.sel_ul li i.site_off{
		  background-color: #999999;
		  font-style: normal;
		}
		
		.site_info{
		  height: auto;
		  overflow: hidden;
		  padding: 0px;
		  background-color: #ffffff;
		}
		.site_info p{
		  margin: 0;
		  padding: 0;
		  line-height: 26px;
		  vertical-align: middle;
		  font-size: 14px;
		  color: #333333;
		}
	</style>
<#include "/head.ftl"/>
<#include "../../incl/Include_AutoNavi.ftl" />
<script src="${rc.contextPath}/public/js/statistic/realtime/stationRunStateMap.js"></script>

</head>
<body>
	 <div id="map-wrap" style="position:absolute;width:99%; height:99%"></div>
	 
<div class="tip_box">
	  <span>基站运行总数：<i id="stationCountNumber">180</i></span>
	  <span class="turn_on">在线：<i id="onStationNumber">180</i></span>
	  <span class="turn_off">离线：<i id="offStationNumber">180</i></span>
	  <p>查询</p>
</div>
<div class="select_con">
  <div class="sel_box">
    <p>
      <label>省份</label>
      <select id="provinceSelect" style="width: 100px;">
         <option value="">--选择省份</option>
         <option value="北京">北京</option>
		 <option value="上海">上海</option>
		 <option value="天津">天津</option>
		 <option value="重庆">重庆</option>
		 <option value="河北">河北</option>
		 <option value="山西">山西</option>
		 <option value="河南">河南</option>
		 <option value="辽宁">辽宁</option>
		 <option value="吉林">吉林</option>
		 <option value="黑龙江">黑龙江</option>
		 <option value="内蒙古">内蒙古</option>
		 <option value="江苏">江苏</option>
		 <option value="山东">山东</option>
		 <option value="安徽">安徽</option>
		 <option value="浙江">浙江</option>
		 <option value="福建">福建</option>
		 <option value="湖北">湖北</option>
		 <option value="湖南">湖南</option>
		 <option value="广东">广东</option>
		 <option value="广西">广西</option>
		 <option value="江西">江西</option>
		 <option value="四川">四川</option>
		 <option value="贵州">贵州</option>
		 <option value="云南">云南</option>
		 <option value="西藏">西藏</option>
		 <option value="陕西">陕西</option>
		 <option value="甘肃">甘肃</option>
		 <option value="宁夏">宁夏</option>
		 <option value="新疆">新疆</option>
		 <option value="台湾">台湾</option>
		 <option value="香港">香港</option>
		 <option value="澳门">澳门</option>
      </select>
    </p>
    <p style="margin-right: 0;">
      <label>公司</label>
      <input id="oweCompanyName" type="text" placeholder="请输入公司名称" />
    </p>
    <p>
      <label>在线
      <input type="radio" value="1" name="onOrOffline" checked/></label>
    </p>
    <p>
      <label>离线
      <input type="radio" value="0" name="onOrOffline"/></label>
    </p>
    <p>
      <span onclick = "queryWithCondition()">查询</span>
    </p>
    <i>×</i>
  </div>
  <ul class="sel_ul" id="searchRltContent">

  </ul>
</div>

</body>

</html>
