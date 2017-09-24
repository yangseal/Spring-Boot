<!doctype html>
<html>
<head>
<meta charset="utf-8">
<meta name="keywords" content="">
<meta name="description" content="">
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
<title>管理中心</title>
<#include "common/clientMatascript.ftl"/>
<script type="text/javascript" src="${rc.contextPath}/public/js/client/clients.js"></script>

</head>	
<body>
	<#-- header 区域 start-->
	<div id="indexHeader" class="header sub_header client">
	  
	</div><#-- header 区域 end-->
	
	<div class="wraper ads">
	
	 	<div class="ads_side" id="indexSide"> <#-- indexSide 区域 start-->
	     	
	  	</div><#-- indexSide 区域 end-->
	  
	  	<div id="mainContent"> <#-- mainContent 区域 start-->
	  		<div id="levelOneContent"></div>
	   		<div id="levelTwoContent"></div>
	  	</div><#-- mainContent 区域 end-->
	  	
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

	<script type="text/javascript">
		CONTEXT_PATH = "${rc.contextPath}";
		QUERY_STRING = "${rc.queryString!}";
		$(function(){
			  function clientSide(){
			   	 	$hh=$(window).height();
			     	$(".ads_side").css("height",$hh-90);
			  }
		  	  clientSide();
			  $(window).resize(function() {
			    	clientSide();
			  });
			  <#-- 在线客服	--->
			  	//显示二维码
			    $(".bt_code").mouseover(function () {
			      	$(this).find(".bt_code_img").show();
			    }).mouseleave(function(){
			     	 $(this).find(".bt_code_img").hide();
			    })
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
			    })
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
					openWindowWithPost(url,'讯腾客服');
				});
		});
	</script>
</body>
</html>
