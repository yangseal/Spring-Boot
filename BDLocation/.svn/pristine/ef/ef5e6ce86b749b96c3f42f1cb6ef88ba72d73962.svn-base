$(function(){
	refreshPage("myForumForm","contentDiv");
	initLoadPic($("#postUserId").val(),$("#myPic"));
	//我发表的
	$("#myPublished").click(function(){
		$("#rightContent").load(CONTEXT_PATH + "/forum/myForum/myPublished",null,function(){
			$(".my_nav >li").removeClass();
			$("#myPublished").addClass("on");
		});
	});
	
	//我收藏的
	$("#myStored").click(function(){
		$("#rightContent").load(CONTEXT_PATH + "/forum/myForum/myCollections",null,function(){
			$(".my_nav >li").removeClass();
			$("#myStored").addClass("on");
		});
	});
	
	//基本资料
	$("#basicInfo").click(function(){
		$("#rightContent").load(CONTEXT_PATH + "/forum/myForum/myBasicInfo",null,function(){
			$(".my_nav >li").removeClass();
			$("#basicInfo").addClass("on");
		    $("#sjld").sjld("#shenfen","#chengshi","#quyu");
		    initLoadPic($("#postUserId").val(),$("#imgFile"));
		    uploadUserPic();
		    $("#selDoc").on('click',function(){
		    	$("#uploadFile").trigger('click');
		    });
		    $("p[title]").each(function(index,item){
		    	$(item).text($("#domicile").val().split("-")[index]);
		    });
		   
		});
	});
	
	//我的积分
	$("#myPoints").click(function(){
		$("#rightContent").load(CONTEXT_PATH + "/forum/myForum/myPoints",null,function(){
			$(".my_nav >li").removeClass();
			$("#myPoints").addClass("on");
		});
	});
	
});
function infoConfirm(obj){
	var userInfo = $("#userInfoForm").serialize();
	var postUserDomicile="postUserDomicile=";
	$("p[title]").each(function(index,item){
		if(index == $("p[title]").length-1)
			postUserDomicile+=$(item).text();
		else
			postUserDomicile+=$(item).text()+"-";
	});
	var postUserBirth ="&postUserBirth="+$("#postUserBirthYear").val()+"年"+$("#postUserBirthMonth").val()+"月&";
	userInfo += postUserBirth;
	userInfo += postUserDomicile;
	var url =CONTEXT_PATH+"/forum/myForum/updateUserInfo";
	
	$.post(url,userInfo,function(data){
		if(data.success){
			layer.msg('保存成功!');
		}
		
	});
}
//上传用户头像
function uploadUserPic(){
	  $("#selDoc").bind('click',function(){
		  debugger;
		  //删除之前上传的
		  $.post(CONTEXT_PATH+ "/client/mgtCenter/clientInfo/deletePicture",{"entityId":$("#postUserId").val()},function(){});
		  
		  var _option = {"entityName":"postUserPic","fieldName":"attachments","entityId":$("#postUserId").val()};
		  $("#uploadFile").fileupload({
				url : CONTEXT_PATH + "/attachment/upload",
				formData : _option,
				dataType: 'json',
		        done: function (e, data) {
		            if(data.result.success){
		            	initLoadPic($("#postUserId").val(),$("#myPic"));
		            	initLoadPic($("#postUserId").val(),$("#imgFile"));
		            }else{
		            	showAlert(data.result.message);
		            }
		        }
			});
	  });
}

