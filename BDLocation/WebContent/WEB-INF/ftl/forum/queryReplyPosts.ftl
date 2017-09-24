 <ul id="replyPosts" class="det_list">
     <#list page.result as replyPost>
     <#if replyPost.isReplyMainPost == 1>
       <li id="${replyPost.replyPostId}" postUserId="${replyPost.postUser.postUserId}">
       	 <div class="det_info">
       	   <p><img src="${rc.contextPath}/public/img/forum/temp/1.jpg""></p>
       	   <span>${replyPost.postUser.postUserNickname!}</span>
       	   <i>级别：${replyPost.postUser.postUserGradeName!}</i>
       	 </div>
       	 <div class="det_wrap">
       	 	<div class="det_time"><span>${replyPost_index+1+floor}楼</span>发表于：${replyPost.replyPostTime}</div>
       	 	<div class="det_cont">${replyPost.replyPostContent}</div>
            <div class="reply_bt" onclick="ReplyBox(this);">回复<img src="${rc.contextPath}/public/img/forum/icon_comment.png"></div>
       	 </div>
       </li>
     </#if>
     </#list> 
 </ul>
 <@common.postPager page.pageBean "replyPostsForm" "replyPostsDiv"/>
 
 <script type="text/javascript">
 $(function(){
  	$("#replyPosts >li").each(function(index,item){
		initLoadPic($(this).attr("postUserId"),$(this).find("p >img"));
	});
 })

</script>