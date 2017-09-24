<div class="new_list">
     <div class="location">
       <img src="${rc.contextPath}/public/img/forum/icon_home.png"/><a href="">首页</a>><span>论坛</span>><span>发帖</span>
     </div>
     <div class="reply_edit" style="border: none;">
	     <ul class="det_list">
	       <li>
	       	 <div class="det_info">
	       	   <p><img id="sendUserPic" src="${rc.contextPath}/public/img/forum/temp/1.jpg"></p>
	       	   <span>${postUser.postUserNickname}</span>
	       	   <input type="hidden" id="sendPostUserId" value="${postUser.postUserId}"/>
	       	   <i>级别：武林盟主</i>
	       	 </div>
	       	 <div class="det_wrap">
	       	    <div  class="publish_title">
	       	     <label>帖子标题：</label><input id="sendSubject" type="text"/><b>*</b>
	       	    </div>
	       	 	<textarea id="sendPostContent" rows="30" cols="80" style="width: 100%"></textarea>
	       	 </div>
	       </li>
	     </ul>
         <div onclick="sendPost()" class="reply_submit"><img src="${rc.contextPath}/public/img/forum/icon_post.png"/>发布帖子</div>
         <div class="reply_submit"><img src="${rc.contextPath}/public/img/forum/icon_rough.png"/>存为草稿</div>
     </div>
</div>

<script>
initLoadPic($("#sendPostUserId").val(),$("#sendUserPic"));
</script>