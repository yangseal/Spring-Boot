$(function(){
	refreshPage("replyPostsForm","replyPostsDiv");
	 //初始化xhEditor编辑器插件
    $("#postContentBox").xheditor(
    	{
		tools:'Img,Emot,Link',
		upImgUrl:'upload.jsp',
		upImgExt:'jpg,jpeg,gif,png',
		upLinkUrl:'upload.jsp',
		upLinkExt:'zip,rar,txt',
		emots:{msn:{name:'MSN',count:40,width:22,height:22,line:8},pidgin:{name:'Pidgin',width:22,height:25,line:8,list:{smile:'微笑',cute:'可爱',wink:'眨眼',laugh:'大笑',victory:'胜利',sad:'伤心',cry:'哭泣',angry:'生气',shout:'大骂',curse:'诅咒',devil:'魔鬼',blush:'害羞',tongue:'吐舌头',envy:'羡慕',cool:'耍酷',kiss:'吻',shocked:'惊讶',sweat:'汗',sick:'生病',bye:'再见',tired:'累',sleepy:'睡了',question:'疑问',rose:'玫瑰',gift:'礼物',coffee:'咖啡',music:'音乐',soccer:'足球',good:'赞同',bad:'反对',love:'心',brokenheart:'伤心'}},ipb:{name:'IPB',width:20,height:25,line:8,list:{smile:'微笑',joyful:'开心',laugh:'笑',biglaugh:'大笑',w00t:'欢呼',wub:'欢喜',depres:'沮丧',sad:'悲伤',cry:'哭泣',angry:'生气',devil:'魔鬼',blush:'脸红',kiss:'吻',surprised:'惊讶',wondering:'疑惑',unsure:'不确定',tongue:'吐舌头',cool:'耍酷',blink:'眨眼',whistling:'吹口哨',glare:'轻视',pinch:'捏',sideways:'侧身',sleep:'睡了',sick:'生病',ninja:'忍者',bandit:'强盗',police:'警察',angel:'天使',magician:'魔法师',alien:'外星人',heart:'心动'}}}
		}
    );
    
    $("#childReply").xheditor(
    	{
		tools:'Emot',
		upLinkUrl:'upload.jsp',
		upLinkExt:'zip,rar,txt',
		emots:{msn:{name:'MSN',count:40,width:22,height:22,line:8},pidgin:{name:'Pidgin',width:22,height:25,line:8,list:{smile:'微笑',cute:'可爱',wink:'眨眼',laugh:'大笑',victory:'胜利',sad:'伤心',cry:'哭泣',angry:'生气',shout:'大骂',curse:'诅咒',devil:'魔鬼',blush:'害羞',tongue:'吐舌头',envy:'羡慕',cool:'耍酷',kiss:'吻',shocked:'惊讶',sweat:'汗',sick:'生病',bye:'再见',tired:'累',sleepy:'睡了',question:'疑问',rose:'玫瑰',gift:'礼物',coffee:'咖啡',music:'音乐',soccer:'足球',good:'赞同',bad:'反对',love:'心',brokenheart:'伤心'}},ipb:{name:'IPB',width:20,height:25,line:8,list:{smile:'微笑',joyful:'开心',laugh:'笑',biglaugh:'大笑',w00t:'欢呼',wub:'欢喜',depres:'沮丧',sad:'悲伤',cry:'哭泣',angry:'生气',devil:'魔鬼',blush:'脸红',kiss:'吻',surprised:'惊讶',wondering:'疑惑',unsure:'不确定',tongue:'吐舌头',cool:'耍酷',blink:'眨眼',whistling:'吹口哨',glare:'轻视',pinch:'捏',sideways:'侧身',sleep:'睡了',sick:'生病',ninja:'忍者',bandit:'强盗',police:'警察',angel:'天使',magician:'魔法师',alien:'外星人',heart:'心动'}}}
		}
    );
	showReplyedPost();
	//异步请求帖子用户头像
	initLoadPic($("#postUserId").val(),$("#postUserPic"));
	initLoadPic($("#curPostUserId").val(),$("#curPostUserPic"));
	$("#collectPost").toggle(
		function(){
			$("#collectPost").addClass("on");
			layer.msg("收藏成功！");
		},
		function(){
			$("#collectPost").removeClass("on");
			layer.msg("取消收藏！");
		});
});
//展示贴中贴回复
function showReplyedPost(){
	var postId = $("#mainPost").attr("postId");
	var url= CONTEXT_PATH+"/forum/showReplyedPost?postId="+postId;
	$.post(url,null,function(data){
		$("#replyPosts >li").each(function(){
			for(var i=0;i<data.length;i++){
				if($(this).find("#"+data[i].replyedPostId+"").length == 0 && data[i].replyedPostId == $(this).attr("id")){
					$(this).find(".reply_bt").after($("#replyedDiv").clone().attr("id",data[i].replyedPostId).show());
				}
				if(data[i].replyedPostId == $(this).attr("id")){
					$(this).find("ul").append($("#replyedLi").clone().attr("id",data[i].replyPostId).show());
					$("#"+data[i].replyPostId+" >span").text(data[i].postUser.postUserNickname);
					$("#"+data[i].replyPostId+" >span").after(": "+data[i].replyPostContent);
					$("#"+data[i].replyPostId+" >p").prepend(data[i].replyPostTime);
					initLoadPic(data[i].postUser.postUserId,$("#"+data[i].replyPostId+" >img:first"));
				}else{
					$(this).find("ul >li").each(function(){
						if(data[i].replyedPostId == $(this).attr("id")){
							$(this).parent().append($("#replyedLi").clone().attr("id",data[i].replyPostId).show());
							$("#"+data[i].replyPostId+" >span").text(data[i].postUser.postUserNickname);
							$("#"+data[i].replyPostId+" >span").after(": "+data[i].replyPostContent);
							$("#"+data[i].replyPostId+" >p").prepend(data[i].replyPostTime);
							initLoadPic(data[i].postUser.postUserId,$("#"+data[i].replyPostId+" >img:first"));
						}
					});
				}
			}
		});
	});
}

//弹出回复框
function ReplyBox(obj,type){
	debugger;
	$(".cover").show();
	$(".box_wrap").show();
	$("#childReply").val("");
	if(type == 'li'){
		$(".cover span:first").html($(obj).closest("li").children("span").text());
//		$("#childReply").val("回复 "+$(".cover span:first").text()+" :");
	}else{
		$(".cover span:first").html($(obj).parent().prev().find("span").text());
	}
	$(".cover").attr("id",$(obj).parent().parent().attr("id"));
		disableScroll();
	$(".box_title p").click(function(event) {
		$(".cover").hide();
	    $(".box_wrap").hide();
	    enableScroll();
	});
}

//回复贴中贴
function doReply(){
	var url = CONTEXT_PATH+"/forum/doReplyPost",
	postId = $("#mainPost").attr("postId"),
	replyedPostId = $(".cover").attr("id"),
	replyPostContent = "回复 "+$(".box_title >span").text()+" :"+$("#childReply").val(),
	params = {"post.postId":postId,"replyedPostId":replyedPostId,"replyPostContent":encodeURI(replyPostContent)};
	var childReply = $("#childReply").val().trim().length;
	if(childReply == 0){
		layer.alert('回复内容不能为空！',{icon: 5});
		return;
	}
	$.ajax({
		type: "POST",
		url: url,
		data: params,
		success: function(data) {
			if(data == 'unlogin'){
				window.location.href = CONTEXT_PATH+"/login";
			}else{
				layer.msg('回复成功,经验值+1!', {icon: 1});
				var url = CONTEXT_PATH +"/forum/showPost?postId="+postId;
				$("#mainContent").load(url,null,function(){
					enableScroll();
				});
		   }
    	}
	});
}

//回复主题帖
function doMineReply(){
	var url = CONTEXT_PATH+"/forum/doReplyPost",
	postId = $("#mainPost").attr("postId"),
	replyPostContent = $("#postContentBox").val().trim(),
	params = {"post.postId":postId,"replyPostContent":encodeURI(replyPostContent)};
	if(replyPostContent.length == 0){
		layer.alert('发帖内容不能为空！',{icon: 5});
		return;
	}
	$.post(url,params,function(data){
		if(data == 'unlogin'){
			window.location.href = CONTEXT_PATH+"/login";
		}else{
			layer.msg('回复成功,经验值+1!', {icon: 1});
			var url = CONTEXT_PATH +"/forum/showPost?postId="+postId;
			$("#mainContent").load(url,null,function(){
				enableScroll();
			});
		}
	});
}


//自定义myRefreshPage
function myRefreshPage(formId, divId, pageIndex) {
	if (pageIndex) {
		$("#" + formId + "_pageIndex").val(pageIndex);
	}
	var url = $("#" + formId).attr("action");
	var params = $("#" + formId).serialize();
	jQuery.post(url, params, function(data) {
		if(pageIndex == 1){
			$("#onePost").show();
		}else{
			$("#onePost").hide();
		}
		showReplyedPost();
		$("#" + divId).html(data);
	});
}



function preventDefault(e) {
    e = e || window.event;
    if (e.preventDefault)
        e.preventDefault();
    e.returnValue = false;
}

function preventDefaultForScrollKeys(e) {
    if (keys[e.keyCode]) {
        preventDefault(e);
        return false;
    }
}
var oldonwheel, oldonmousewheel1, oldonmousewheel2, oldontouchmove, oldonkeydown
, isDisabled;
function disableScroll() {
    if (window.addEventListener) // older FF
        window.addEventListener('DOMMouseScroll', preventDefault, false);
    oldonwheel = window.onwheel;
    window.onwheel = preventDefault; // modern standard

    oldonmousewheel1 = window.onmousewheel;
    window.onmousewheel = preventDefault; // older browsers, IE
    oldonmousewheel2 = document.onmousewheel;
    document.onmousewheel = preventDefault; // older browsers, IE

    oldontouchmove = window.ontouchmove;
    window.ontouchmove = preventDefault; // mobile

    oldonkeydown = document.onkeydown;
    document.onkeydown = preventDefaultForScrollKeys;
    isDisabled = true;
}

function enableScroll() {
    if (!isDisabled) return;
    if (window.removeEventListener)
        window.removeEventListener('DOMMouseScroll', preventDefault, false);

    window.onwheel = oldonwheel; // modern standard

    window.onmousewheel = oldonmousewheel1; // older browsers, IE
    document.onmousewheel = oldonmousewheel2; // older browsers, IE

    window.ontouchmove = oldontouchmove; // mobile

    document.onkeydown = oldonkeydown;
    isDisabled = false;
}
window.scrollHanlder = {
    disableScroll: disableScroll,
    enableScroll: enableScroll
};

