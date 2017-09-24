<ul id="postList" class="list">
	 <#list page.result as post>
	       <li>
	       	<h2><a postId="${post.postId}" id="post_title" target="_self" style="cursor:pointer">${post.postSubject}</a><img src="${rc.contextPath}/public/img/forum/img.gif"/></h2>
	       	<p><a id="userName"><#if post.postUser??>${post.postUser.postUserNickname!}</#if></a>|&nbsp; 发布于 ${post.postTime}
	       	  <span>
	       	  	<i><img src="${rc.contextPath}/public/img/forum/icon_scan.png"/>${post.postVisitCount!0}</i>
	       	  	<i><a href="#"><img src="${rc.contextPath}/public/img/forum/icon_comment.png"/>${post.postReplyCount!0}</a></i>
	       	  </span>
	       	</p>
	       	<div id="post_content">
	       		<#if post.postContent?length gt 75>
					${(post.postContent?string)?substring(0,75)}...
				<#else>
					${post.postContent!}
				</#if> 
			    <a style="cursor:pointer" postId="${post.postId}" target="_self">查看全文》</a>
			</div>
	       </li>
	</#list>
</ul>
<@common.forumPager page.pageBean "leftContentForm" "leftContentDiv"/>