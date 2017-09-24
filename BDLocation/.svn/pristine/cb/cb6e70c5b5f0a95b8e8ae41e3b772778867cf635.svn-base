<form id="myForumForm" action="${rc.contextPath}/forum/myForum/myPublished">
	<div id="contentDiv" class="det_wrap">
	<#if (page.result?size>0)>
		<ul class="me_list">
		  <#list page.result as myPublishPost>            
		  	<li><a postId="${myPublishPost.postId}" id="post_title" target="_blank" style="cursor:pointer"><#if myPublishPost?? && myPublishPost.postSubject?length gt 40>${(myPublishPost.postSubject?string)?substring(0,40)!}...<#else>${myPublishPost.postSubject}</#if></a><#if myPublishPost??>${myPublishPost.postTime!}</#if>
		      <span>
		        <i><img src="${rc.contextPath}/public/img/forum/icon_scan.png"/><#if myPublishPost??>${myPublishPost.postVisitCount!}</#if></i>
		        <i><img src="${rc.contextPath}/public/img/forum/icon_comment.png"/><#if myPublishPost??>${myPublishPost.postReplyCount!}</#if></i>
		      </span>
		  	</li>
		  </#list>            
		</ul>
		<@common.forumPager page.pageBean "myForumForm" "rightContent"/>
	<#else>
		<div class="bg">
			您还没有发帖哦！
		</div>
	</#if>
   	</div>
</form>       