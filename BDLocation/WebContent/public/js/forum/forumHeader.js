$(function(){
	//论坛首页
	$("#mainForum").click(function(){
		$("#mainContent").load(CONTEXT_PATH +"/forum/showForum",null,function(){
			$(".nav >a").removeClass();
			$("#mainForum").addClass("current");
		});
		
	});
	//新手指导
	$("#boardSpan").live('click',function(){
		debugger;
		$("#mainContent").load(CONTEXT_PATH +"/forum/showBoard?boardId="+$("#boardSpan").attr("boardId"),null,function(){
			$(".nav >a").removeClass();
			$("#forumGuide").addClass("current");
		});
	});
	//我的论坛
	$("#myForum").click(function(){
		$("#mainContent").load(CONTEXT_PATH +"/forum/myForum/myForumNav",null,function(data){
			if(data == "unlogin"){
				window.location.href =CONTEXT_PATH+ "/login";
				return;
			}
			$(".nav >a").removeClass();
			$("#myForum").addClass("current");
			$("#rightContent").load(CONTEXT_PATH + "/forum/myForum/myPublished",null,function(){
				$(".my_nav >li").removeClass();
				$("#myPublished").addClass("on");
			});
		});
	});
	//搜索查询
	$("#querySearchBtn").click(function(){
		$("#mainContent").load(CONTEXT_PATH +"/forum/querySubject",{'postSubject':$("#postSubject").val()},function(){
			$("#postGuideDiv").css("width",null);
		});
	});
	
	doHeader();
	
});

function doHeader(){
	var url = CONTEXT_PATH+"/forum/header";
	var params = {};
	$.post(url,params,function(data){
		if(data.message != null){
			$("#headLogin").hide();
			$("#headRegister").hide();
			$("#headSpan").hide();
			var userNickName = data.message.postUserNickname;
			if(userNickName != null){
				$("#userNickName").append(data.message.postUserNickname);
			}else{
				$("#userNickName").append(data.message.user.userCode);
			}
			$("#userGrade").append(data.message.postUserGradeName);
			$("#userExperice").append(data.message.postUserExperience);
			$("#userPoints").append(data.message.postUserPoints);
			$("#userPosts").append(data.message.postCount);
		}else{
			$("#headLogout").hide();
			$("#userMenuDiv").hide();
		}
	});
	
}