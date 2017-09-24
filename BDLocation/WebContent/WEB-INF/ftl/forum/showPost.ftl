 <div id="mainPost" postId="${map.post.postId}" class="new_list">
     <div class="location">
       <img src="${rc.contextPath}/public/img/forum/icon_home.png"/><a href="">首页</a>><a id="boardSpan" boardId="${map.post.board.boardId}" style="cursor:pointer">${map.post.board.boardName}</a>><span><#if map.post.postSubject?length gt 15>
							${(map.post.postSubject?string)?substring(0,15)}...
						<#else>
							${map.post.postSubject}
						</#if> </span>
     </div>
     <div class="det_top">
     	<a href="#">返回列表</a>
     	<a href="#">上一帖</a>
     	<a href="#">下一帖</a>
     	<a href="#reply_main">回复帖子</a>
     </div>
     <div class="det_tit">
     	<div class="det_scan">
     	   <p>
     	   	  <b>${map.post.postVisitCount!}</b><br>
     	   	  阅读
     	   </p>
     	   <p>
     	   	  <b>${map.post.postReplyCount!}</b><br>
     	   	  回复
     	   </p>
     	</div>
     	<div class="det_title">
     	  <p>${map.post.postSubject}</p>
     	  <span id="collectPost">收藏</span>
     	</div>
     </div>
     <ul id="onePost" class="det_list">
       <li>
       	 <div class="det_info">
       	   <p><img id="postUserPic" src="${rc.contextPath}/public/img/forum/temp/1.jpg"></p>
       	   <span><#if map.post?? && map.post.postUser??>${map.post.postUser.postUserNickname!}</#if></span>
       	    <input type="hidden" id="postUserId" value="${map.post.postUser.postUserId}">
       	   <i>级别：${map.post.postUser.postUserGradeName!}</i>
       	 </div>
       	 <div class="det_wrap">
       	 	<div class="det_time"><span>楼主</span>发表于：${map.post.postTime}</div>
       	 	<div class="det_cont">${map.post.postContent}</div>
            <a class="reply_bt" href="#reply_main">回复<img src="${rc.contextPath}/public/img/forum/icon_comment.png"></a>
       	 </div>
       </li>
     </ul>
     <form id="replyPostsForm" action="${rc.contextPath}/forum/queryReplyPosts">
     <input type="hidden" name="post.postId" value="${map.post.postId}">
	     <div id="replyPostsDiv">
	     
	     </div>
     </form>
 <#--<div class="page mtb">
     	<a href="#">首页</a>
     	<a href="#">上一页</a>
     	<a href="#">1</a>
     	<a href="#">2</a>
     	<a href="#" class="this">3</a>
     	<a href="#">4</a>
     	<a href="#">下一页</a>
     	<a href="#">末页</a>
     	<span>第3页/共4页</span>
     </div>  -->
     <div class="det_top">
     	<a href="#">返回列表</a>
     	<a href="#">上一帖</a>
     	<a href="#">下一帖</a>
     	<a href="#">新发帖子</a>
     </div>
     <a name="reply_main">
     <div  class="reply_edit">
	     <ul class="det_list">
	       <li>
	       	 <div class="det_info">
	       	   <p><img id="curPostUserPic" src="${rc.contextPath}/public/img/forum/temp/1.jpg"></p>
	       	   <input type="hidden" id="curPostUserId" value="<#if map?? && map.postUser??>${map.postUser.postUserId!}</#if>" />
	       	   <span><#if map.postUser?? && map.postUser.postUserNickname??>${map.postUser.postUserNickname!}<#else>未登录</#if></span>
	       	   <i>级别:<#if map.postUser?? && map.postUser.postUserGradeName??>${map.postUser.postUserGradeName!}<#else></#if></i>
	       	 </div>
	       	 <div class="det_wrap">
	       	 	<textarea id="postContentBox"  rows="10" cols="80" style="width: 100%"> </textarea>
	       	 </div>
	       </li>
	     </ul>
         <div class="reply_submit" onclick="doMineReply(this)"><img src="${rc.contextPath}/public/img/forum/icon_post.png"/>发表回复</div>
     </div>
     </a>
   </div>
</div>

<#--模板界面开始-->

<div class="cover">
   <div class="box_wrap">
   	  <div class="box_title">回复<span></span><p><img src="${rc.contextPath}/public/img/forum/icon_close.png"></p></div>
   	  <div  class="box_text"><textarea id="childReply" rows="8" cols="80" style="width: 100%"></textarea></div>
   	  <div class="box_submit" onclick="doReply()">回复</div>
   </div>
</div>

<div id="replyedDiv" class="reply_con" style="display:none">
	<ul>
	</ul>
</div>

<li id="replyedLi" style="display:none">
   	<img  src="${rc.contextPath}/public/img/forum/temp/1.jpg" style="width:30px;height:30px"/> <span name="replyName">李四</span>
  	<p> <a href="#" onclick="ReplyBox(this,'li')">回复</a></p>
</li>

<#--模板界面结束-->
<script type="text/javascript" src="${rc.contextPath}/public/js/forum/post.js"></script>
<script type="text/javascript">

</script>