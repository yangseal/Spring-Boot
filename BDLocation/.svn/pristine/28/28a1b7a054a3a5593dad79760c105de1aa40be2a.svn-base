//放置 模块 通用js 代码
$(function(){	
	$("li a[postid]").live("click",function(){
		var url = CONTEXT_PATH +"/forum/showPost?postId="+$(this).attr("postId") ;
		$("#mainContent").load(url,null,function(){
			
		});
		
	});
	
	$("#sendPost").click(function(){
			var url = CONTEXT_PATH +"/forum/showSendPost";
			$("#mainContent").load(url,null,function(data){
				if(data == 'unlogin'){
					window.location.href = CONTEXT_PATH+"/login";
				}else{
					$("#sendPostContent").xheditor(
					    	{
							tools:'Img,Emot,Link',
							upImgUrl:'upload.jsp',
							upImgExt:'jpg,jpeg,gif,png',
							upLinkUrl:'upload.jsp',
							upLinkExt:'zip,rar,txt',
							emots:{msn:{name:'MSN',count:40,width:22,height:22,line:8},pidgin:{name:'Pidgin',width:22,height:25,line:8,list:{smile:'微笑',cute:'可爱',wink:'眨眼',laugh:'大笑',victory:'胜利',sad:'伤心',cry:'哭泣',angry:'生气',shout:'大骂',curse:'诅咒',devil:'魔鬼',blush:'害羞',tongue:'吐舌头',envy:'羡慕',cool:'耍酷',kiss:'吻',shocked:'惊讶',sweat:'汗',sick:'生病',bye:'再见',tired:'累',sleepy:'睡了',question:'疑问',rose:'玫瑰',gift:'礼物',coffee:'咖啡',music:'音乐',soccer:'足球',good:'赞同',bad:'反对',love:'心',brokenheart:'伤心'}},ipb:{name:'IPB',width:20,height:25,line:8,list:{smile:'微笑',joyful:'开心',laugh:'笑',biglaugh:'大笑',w00t:'欢呼',wub:'欢喜',depres:'沮丧',sad:'悲伤',cry:'哭泣',angry:'生气',devil:'魔鬼',blush:'脸红',kiss:'吻',surprised:'惊讶',wondering:'疑惑',unsure:'不确定',tongue:'吐舌头',cool:'耍酷',blink:'眨眼',whistling:'吹口哨',glare:'轻视',pinch:'捏',sideways:'侧身',sleep:'睡了',sick:'生病',ninja:'忍者',bandit:'强盗',police:'警察',angel:'天使',magician:'魔法师',alien:'外星人',heart:'心动'}}}
							}
					 );
				}
			});
	});
	
});

function sendPost(){
	debugger;
	var url = CONTEXT_PATH+"/forum/doMinePost",
    reg=/&nbsp;/g;
	postSubject = $("#sendSubject").val().replace(reg,"").trim(),
	postContent = $("#sendPostContent").val().replace(reg,"").trim(),
	params = {"postSubject":postSubject,"postContent":encodeURI(postContent)};
	
//	$.post(url,params,function(data){
//		if(data.success){
//			var url = CONTEXT_PATH +"/forum/showPost?postId="+postId;
//			$("#mainContent").load(url,null,function(){
//				enableScroll();
//			});
//		}
//	});
	if(postSubject.length == 0){
		layer.alert('帖子主题不能为空！',{icon: 5});
		return;
	}else if(postSubject.length > 30){
		layer.alert('帖子主题应不超过30个汉字！',{icon: 5});
		return;
	}else if(postContent.length == 0){
		layer.alert('帖子内容不能为空！',{icon: 5});
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
				layer.msg('发帖成功，经验值+5',{icon:1});
				setTimeout(function(){
					window.location.href = CONTEXT_PATH+"/forum/forumIndex";
				},2000);
			}
		}
	});
}

//初始页面是加载图片
function initLoadPic(entityId,dom){
	  $.ajax({ 
		  url:CONTEXT_PATH + "/client/mgtCenter/clientInfo/showPicture",
		  data:{"entityId":entityId},
		  async: false,
		  success:function(data){
			  if(data){
				  dom.attr("src",CONTEXT_PATH+"/attachment/showPicture?attachmentId=" + data + "&isThumbnail=true");
			  }
	      }
     });
}