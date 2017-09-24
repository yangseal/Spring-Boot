 <div class="location">
   <img src="${rc.contextPath}/public/img/forum/icon_home.png"/><a href="">首页</a>><span>新手指导</span>
 </div>
 <div class="guide">
    <img src="${rc.contextPath}/public/img/forum/icon_guide.png">
 	<p>哎！</p>
 	<span>今日：${todayPost!}</span>
 	<span>帖数：${totalGuidePost!}</span>
 <!--	<span>版主：admin</span>  -->
 </div>
 <div class="prerequisite">
   	排序：<a href="">最新发帖</a>|<a href="">最后回复</a>
 </div>

<ul class="list">
	 <#list page.result as guidePost>
	       <li>
	       	<h2><a postId="${guidePost.postId}" id="post_title" target="_self" style="cursor:pointer">${guidePost.postSubject}</a><img src="${rc.contextPath}/public/img/forum/img.gif"/></h2>
	       	<p><a href="#" id="userName"><#if guidePost.postUser??>${guidePost.postUser.postUserNickname}</#if></a>|&nbsp; 发布于 ${guidePost.postTime}
	       	  <span>
	       	  	<i><img src="${rc.contextPath}/public/img/forum/icon_scan.png"/>${guidePost.postVisitCount}</i>
	       	  	<i><a href="#"><img src="${rc.contextPath}/public/img/forum/icon_comment.png"/>${guidePost.postReplyCount}</a></i>
	       	  </span>
	       	</p>
	       	<div id="post_content"><#if guidePost.postContent?length gt 75>
							${(guidePost.postContent?string)?substring(0,75)}...
						<#else>
							${guidePost.postContent}
						</#if>  <a href="#" target="_blank">查看全文》</a>
			</div>
	       </li>
	</#list>
</ul>
<input type="hidden" id="todayPost" value="${todayPost!}">
<input type="hidden" id="totalGuidePost" value="${totalGuidePost!}">
<@common.forumPager page.pageBean "postGuideForm" "postGuideDiv"/>