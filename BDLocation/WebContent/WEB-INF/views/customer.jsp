<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getServerName() + ":"
			+ request.getServerPort() + path;
	String basePath2 = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01//EN"
"http://www.w3.org/TR/html4/strict.dtd">

<html xmlns="http://www.w3.org/1999/xhtml" lang="en">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>讯腾公司欢迎您</title>
<link type="text/css" rel="stylesheet"  href="<%=basePath2%>public/css/websocket.css" />

</head>
<body>
	<%-- 欢迎：${user.name}
	<div id="content"></div>
	<input type="text" placeholder="请输入要发送的信息" id="msg" class="msg" onkeydown="websocket.send(event)">
	<input id="sendTo" type="hidden" value="${user.sendTo}" />
	<input id="selfName" type="hidden" value="${user.name}" />
	<input id="selfId" type="hidden" value="${user.id}" />
	<input type="button" value="发送" class="send" onclick="websocket.sendMsg()" >
	<input type="button" value="清空" class="clear" onclick="websocket.clearAll()"> --%>
	
	<!-- 页面宽度是734px 高度是544px-->
<div class="kf_wraper">
  <div class="kf_wrap">
    <div class="kf_dialog" id="dialogContent">
    
    <div class="kf_con kf_sys" style="display:none;" id="cuservice_message_template">
        <div class="kf_img"><img src="<%=basePath2%>public/img/wsImg/sys_img.png"></div>
        <div class="kf_txt">
          <div class="kf_time">
            <span owename="cuservice_message_name">今天：</span>
            <span owename="cuservice_message_date">09:55:32</span>
          </div>
          <div class="kf_box">
            <i></i>
            <div owename="cuservice_message_text">您好，请问有什么可以帮到您?</div>
          </div>
        </div>
      </div>
    
     <div class="kf_con kf_client" style="display:none;" id="customer_message_template">
        <div class="kf_img"><img src="<%=basePath2%>public/img/wsImg/client_img.png"></div>
        <div class="kf_txt">
          <div class="kf_time">
            <span owename="customer_message_date">09:55:32</span>
            <span owename="customer_message_name">我</span>
          </div>
          <div class="kf_box">
            <i></i>
            <div owename="customer_message_text">您好，请问有什么可以帮到您?</div>
          </div>
        </div>
      </div>
    
     <%--  <!-- 对话开始 -->
      <div class="kf_con kf_sys">
        <div class="kf_img"><img src="<%=basePath2%>public/img/wsImg/sys_img.png"></div>
        <div class="kf_txt">
          <div class="kf_time">
            <span>今天：</span>
            <span>09:55:32</span>
          </div>
          <div class="kf_box">
            <i></i>
            <div>您好，请问有什么可以帮到您？我们的在线咨询服务受理时间：工作日9:00-18:00。非受理时间的咨询，请邮件至xxxxxxxxxxxxxxx，告知您的疑问及需求，我们将给予回复。</div>
          </div>
        </div>
      </div>
      <!-- 对话结束 -->
      <!-- 对话开始 -->
      <div class="kf_con kf_client">
        <div class="kf_img"><img src="<%=basePath2%>public/img/wsImg/client_img.png"></div>
        <div class="kf_txt">
          <div class="kf_time">
            <span>今天：</span>
            <span>09:55:32</span>
          </div>
          <div class="kf_box">
            <i></i>
            <div>您好，请问有什么可以帮到您？我们的在线咨询服务受理时间：工作日9:00-18:00。非受理时间的咨询，请邮件至service@qxwz.com，告知您的疑问及需求，我们将给予回复。</div>
          </div>
        </div>
      </div>
      <!-- 对话结束 --> --%>
    </div>
    <div class="kf_bt">
      <p class="kf_bt_img"><img src="<%=basePath2%>public/img/wsImg/bt_look.png" title="表情"></p>
      <p class="kf_bt_file">
        <!--  <input type="file"></input>-->
	    <input id="uploadFile" type="file" name="files[]" formenctype="multipart/form-data" />
      </p>
      <div class="face">
        <ul>
          <li><img src="<%=basePath2%>public/img/wsImg/zz2_thumb.gif" title="[织]" ></li>
          <li><img src="<%=basePath2%>public/img/wsImg/horse2_thumb.gif" title="神马]"></li>
          <li><img src="<%=basePath2%>public/img/wsImg/fuyun_thumb.gif" title="[浮云]"></li>
          <li><img src="<%=basePath2%>public/img/wsImg/geili_thumb.gif" title="[给力]"></li>
          <li><img src="<%=basePath2%>public/img/wsImg/wg_thumb.gif" title="[围观]"></li>
          <li><img src="<%=basePath2%>public/img/wsImg/vw_thumb.gif" title="[威武]"></li>
          <li><img src="<%=basePath2%>public/img/wsImg/panda_thumb.gif" title="[熊猫]"></li>
          <li><img src="<%=basePath2%>public/img/wsImg/rabbit_thumb.gif" title="兔子]"></li>
          <li><img src="<%=basePath2%>public/img/wsImg/otm_thumb.gif" title="[奥特曼]"></li>
          <li><img src="<%=basePath2%>public/img/wsImg/j_thumb.gif" title="[囧]"></li>
          <li><img src="<%=basePath2%>public/img/wsImg/hufen_thumb.gif" title="[互粉]"></li>
          <li><img src="<%=basePath2%>public/img/wsImg/liwu_thumb.gif" title="[礼物]"></li>
          <li><img src="<%=basePath2%>public/img/wsImg/smilea_thumb.gif" title="呵呵]"></li>
          <li><img src="<%=basePath2%>public/img/wsImg/tootha_thumb.gif" title="嘻嘻]"></li>
          <li><img src="<%=basePath2%>public/img/wsImg/laugh.gif" title="[哈哈]"></li>
          <li><img src="<%=basePath2%>public/img/wsImg/tza_thumb.gif" title="[可爱]"></li>
          <li><img src="<%=basePath2%>public/img/wsImg/kl_thumb.gif" title="[可怜]"></li>
          <li><img src="<%=basePath2%>public/img/wsImg/kbsa_thumb.gif" title="[挖鼻屎]"></li>
          <li><img src="<%=basePath2%>public/img/wsImg/cj_thumb.gif" title="[吃惊]"></li>
          <li><img src="<%=basePath2%>public/img/wsImg/shamea_thumb.gif" title="[害羞]"></li>
          <li><img src="<%=basePath2%>public/img/wsImg/zy_thumb.gif" title="[挤眼]"></li>
          <li><img src="<%=basePath2%>public/img/wsImg/bz_thumb.gif" title="[闭嘴]"></li>
          <li><img src="<%=basePath2%>public/img/wsImg/bs2_thumb.gif" title="[鄙视]"></li>
          <li><img src="<%=basePath2%>public/img/wsImg/lovea_thumb.gif" title="[爱你]"></li>
          <li><img src="<%=basePath2%>public/img/wsImg/sada_thumb.gif" title="[泪]"></li>
          <li><img src="<%=basePath2%>public/img/wsImg/heia_thumb.gif" title="[偷笑]"></li>
          <li><img src="<%=basePath2%>public/img/wsImg/qq_thumb.gif" title="[亲亲]"></li>
          <li><img src="<%=basePath2%>public/img/wsImg/sb_thumb.gif" title="[生病]"></li>
          <li><img src="<%=basePath2%>public/img/wsImg/mb_thumb.gif" title="[太开心]"></li>
          <li><img src="<%=basePath2%>public/img/wsImg/ldln_thumb.gif" title="[懒得理你]"></li>
          <li><img src="<%=basePath2%>public/img/wsImg/yhh_thumb.gif" title="[右哼哼]"></li>
          <li><img src="<%=basePath2%>public/img/wsImg/zhh_thumb.gif" title="[左哼哼]"></li>
          <li><img src="<%=basePath2%>public/img/wsImg/x_thumb.gif" title="[嘘]"></li>
          <li><img src="<%=basePath2%>public/img/wsImg/cry.gif" title="[衰]"></li>
          <li><img src="<%=basePath2%>public/img/wsImg/wq_thumb.gif" title="[委屈]"></li>
          <li><img src="<%=basePath2%>public/img/wsImg/t_thumb.gif" title="[吐]"></li>
          <li><img src="<%=basePath2%>public/img/wsImg/k_thumb.gif" title="[打哈气]"></li>
          <li><img src="<%=basePath2%>public/img/wsImg/bba_thumb.gif" title="[抱抱]"></li>
          <li><img src="<%=basePath2%>public/img/wsImg/angrya_thumb.gif" title="[怒]"></li>
          <li><img src="<%=basePath2%>public/img/wsImg/yw_thumb.gif" title="[疑问]"></li>
          <li><img src="<%=basePath2%>public/img/wsImg/cza_thumb.gif" title="[馋嘴]"></li>
          <li><img src="<%=basePath2%>public/img/wsImg/88_thumb.gif" title="[拜拜]"></li>
          <li><img src="<%=basePath2%>public/img/wsImg/sk_thumb.gif" title="[思考]"></li>
          <li><img src="<%=basePath2%>public/img/wsImg/sweata_thumb.gif" title="[汗]"></li>
          <li><img src="<%=basePath2%>public/img/wsImg/sleepya_thumb.gif" title="[困]"></li>
          <li><img src="<%=basePath2%>public/img/wsImg/sleepa_thumb.gif" title="[睡觉]"></li>
          <li><img src="<%=basePath2%>public/img/wsImg/money_thumb.gif" title="[钱]"></li>
          <li><img src="<%=basePath2%>public/img/wsImg/sw_thumb.gif" title="[失望]"></li>
          <li><img src="<%=basePath2%>public/img/wsImg/cool_thumb.gif" title="[酷]"></li>
          <li><img src="<%=basePath2%>public/img/wsImg/hsa_thumb.gif" title="[花心]"></li>
          <li><img src="<%=basePath2%>public/img/wsImg/hatea_thumb.gif" title="[哼]"></li>
          <li><img src="<%=basePath2%>public/img/wsImg/gza_thumb.gif" title="[鼓掌]"></li>
          <li><img src="<%=basePath2%>public/img/wsImg/dizzya_thumb.gif" title="[晕]"></li>
          <li><img src="<%=basePath2%>public/img/wsImg/bs_thumb.gif" title="[悲伤]"></li>
          <li><img src="<%=basePath2%>public/img/wsImg/crazya_thumb.gif" title="[抓狂]"></li>
          <li><img src="<%=basePath2%>public/img/wsImg/h_thumb.gif" title="[黑线]"></li>
          <li><img src="<%=basePath2%>public/img/wsImg/yx_thumb.gif" title="[阴险]"></li>
          <li><img src="<%=basePath2%>public/img/wsImg/nm_thumb.gif" title="[怒骂]"></li>
          <li><img src="<%=basePath2%>public/img/wsImg/hearta_thumb.gif" title="[心]"></li>
          <li><img src="<%=basePath2%>public/img/wsImg/unheart.gif" title="[伤心]"></li>
          <li><img src="<%=basePath2%>public/img/wsImg/pig.gif" title="[猪头]"></li>
          <li><img src="<%=basePath2%>public/img/wsImg/ok_thumb.gif" title="[ok]"></li>
          <li><img src="<%=basePath2%>public/img/wsImg/ye_thumb.gif" title="[耶]"></li>
          <li><img src="<%=basePath2%>public/img/wsImg/good_thumb.gif" title="[good]"></li>
          <li><img src="<%=basePath2%>public/img/wsImg/no_thumb.gif" title="[不要]"></li>
          <li><img src="<%=basePath2%>public/img/wsImg/z2_thumb.gif" title="[赞]"></li>
          <li><img src="<%=basePath2%>public/img/wsImg/come_thumb.gif" title="[来]"></li>
          <li><img src="<%=basePath2%>public/img/wsImg/sad_thumb.gif" title="[弱]"></li>
          <li><img src="<%=basePath2%>public/img/wsImg/lazu_thumb.gif" title="[蜡烛]"></li>
          <li><img src="<%=basePath2%>public/img/wsImg/clock_thumb.gif" title="[钟]"></li>
          <li><img src="<%=basePath2%>public/img/wsImg/cake.gif" title="[蛋糕]"></li>
          <li><img src="<%=basePath2%>public/img/wsImg/m_thumb.gif" title="[话筒]"></li>
          <li><img src="<%=basePath2%>public/img/wsImg/weijin_thumb.gif" title="[围脖]"></li>
          <li><img src="<%=basePath2%>public/img/wsImg/lxhzhuanfa_thumb.gif" title="[转发]"></li>
          <li><img src="<%=basePath2%>public/img/wsImg/lxhluguo_thumb.gif" title="[路过这儿]"></li>
          <li><img src="<%=basePath2%>public/img/wsImg/bofubianlian_thumb.gif" title="[bofu变脸]"></li>
          <li><img src="<%=basePath2%>public/img/wsImg/gbzkun_thumb.gif" title="[gbz困]"></li>
          <li><img src="<%=basePath2%>public/img/wsImg/boboshengmenqi_thumb.gif" title="[生闷气]"></li>
          <li><img src="<%=basePath2%>public/img/wsImg/chn_buyaoya_thumb.gif" title="[不要啊]"></li>
          <li><img src="<%=basePath2%>public/img/wsImg/daxiongleibenxiong_thumb.gif" title="[dx泪奔]"></li>
          <li><img src="<%=basePath2%>public/img/wsImg/cat_yunqizhong_thumb.gif" title="[运气中]"></li>
          <li><img src="<%=basePath2%>public/img/wsImg/youqian_thumb.gif" title="[有钱]"></li>
          <li><img src="<%=basePath2%>public/img/wsImg/cf_thumb.gif" title="[冲锋]"></li>
          <li><img src="<%=basePath2%>public/img/wsImg/camera_thumb.gif" title="[照相机]"></li>
        </ul>
      </div>
    </div>
    <div class="kf_import" id="sendContent" contenteditable="true"></div>
    <input id="selfId" type="hidden" value="${user.id}" />
    <input id="selfName" type="hidden" value="${user.name}" />
    <input id="sendTo" type="hidden" value="${user.sendTo}" />
     <input id="userType" type="hidden" value="customer" />
    <div class="kf_submit">发 送</div>
  </div>
</div>
	
	
</body>
<script type="text/javascript" src="<%=basePath2%>public/js/lib/jquery-1.11.1.min.js"></script>
<script src="//cdn.bootcss.com/sockjs-client/1.1.1/sockjs.js"></script>
<script type="text/javascript" src="<%=basePath2%>public/js/websocket/websocket.js"></script>
<script type="text/javascript" src="<%=basePath2%>public/js/lib/jquery-file-upload/jquery.ui.widget.js"></script>
<script type="text/javascript" src="<%=basePath2%>public/js/lib/jquery-file-upload/jquery.fileupload.js"></script>
<script type="text/javascript" src="<%=basePath2%>public/js/lib/jquery-file-upload/jquery.iframe-transport.js"></script>
<script type="text/javascript" src="<%=basePath2%>public/js/lib/fileUploader.js"></script>

<script type="text/javascript">
var serverpath = '<%=basePath%>';
var resourcepath = '<%=basePath2%>';
var websocket = new _WebSocket({serverpath:serverpath,resourcepath:resourcepath}); 

$(function(){
	   //点击小图片，显示表情
	  $(".kf_bt_img").click(function(e){
	    $(".face").slideDown(50);//慢慢向下展开
	    e.stopPropagation();   //阻止冒泡事件
	    //点击小图标时，添加功能
	  });
	
	  $(".face ul li").click(function(){
	      var simg=$(this).find("img").clone();
	      var BQ=$(".kf_import");
	      BQ.append(simg);
	  });
	  //在桌面任意地方点击，他是关闭
	  $(document).click(function(){
	    $(".face").slideUp(50);//慢慢向上收
	  });


	  //点击发表按扭，发表内容
	  $(".kf_submit").click(function(){
		  websocket.sendMsg();
	  });
	  
	  $('#sendContent').keydown(function(event){ 
		  websocket.send(event);
	  }).keyup(function(){
		  if(window.event){
				 code = window.event.keyCode; // IE
			 }else{
				 code = e.which; // Firefox
			 }
			if(code==13){ 
				 $('#sendContent').empty();
			}
	  }) ;
	  websocket.uploadChatPicture();
});

/* function uploadChatPicture(){
	  $("#uploadFile").bind('click',function(){
		  var _option = {"entityName":"chatPicture","fieldName":"attachments","entityId":$("#selfId").val()};
		  this.fileupload({
				url : resourcepath + "attachment/upload",
				formData : _option,
				dataType: 'json',
		        done: function (e, data) {
		        	if(data.result.success){
		        		alert("-----上传成功-----");
		        	}
		        	
		            if(data.result.success){
		            	 initLoadAttachment($("#companyId").val());
		            }else{
		            	showAlert(data.result.message);
		            } 
		        }
			});
	  });
}

//初始页面是加载图片
function reloadChatPicture(entityId){
	  $.ajax({ 
		  url:CONTEXT_PATH + "/client/mgtCenter/clientInfo/showPicture",
		  data:{"entityId":entityId},
		  async: false,
		  success:function(data){
			  if(data){
				  $("#imgFile").attr("src",CONTEXT_PATH+"/attachment/showPicture?attachmentId=" + data + "&isThumbnail=true");
				  $("#imgFile").attr("isFile","true");
				  $("#selDoc").text('重新上传');
			  }
	      }
    });
} */


window.onbeforeunload = function(event) { 
	websocket.closeWebSocket();
};
 

</script>
</html>
