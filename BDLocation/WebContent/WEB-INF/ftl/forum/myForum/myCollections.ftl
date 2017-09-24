<form id="myForumForm" action="${rc.contextPath}/forum/myForum/myCollections">
	<div id="contentDiv" class="det_wrap">
		<#if (page.result?size>0)>
			<ul class="me_list">
			  <#list page.result as myCollectionPost>            
			  	<li><a postId="${myCollectionPost.postId}" id="post_title" target="_self" style="cursor:pointer"><#if myCollectionPost?? && myCollectionPost.postSubject??>${myCollectionPost.postSubject!}</#if></a><#if myCollectionPost??>${myCollectionPost.postTime!}</#if>
			      <span>
			        <i><img src="${rc.contextPath}/public/img/forum/icon_scan.png"/><#if myCollectionPost??>${myCollectionPost.postVisitCount!}</#if></i>
			        <i><img src="${rc.contextPath}/public/img/forum/icon_comment.png"/><#if myCollectionPost??>${myCollectionPost.postReplyCount!}</#if></i>
			      </span>
			  	</li>
			  </#list>            
			</ul>
				<@common.forumPager page.pageBean "myForumForm" "rightContent"/>
		<#else>
			<div class="bg">
				暂无收藏！
			</div>
		</#if>	
   	</div>
</form>