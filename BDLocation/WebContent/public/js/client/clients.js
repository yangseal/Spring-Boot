//首页跳转方式
$(function(){
	commonLoad($("#indexHeader"),CONTEXT_PATH + "/client/header",null,function(self){
		//一级菜单绑定事件
		$("#menuUL a").click(function(){
			var url = $(this).attr("action");
			var tabCode = $(this).attr("code");
			loadContent('',tabCode,url,'clientWrapContent');
		});
		detecteIsLogin();
	});
//	$("#indexHeader").load(CONTEXT_PATH + "/client/header",null,function(){
//		//一级菜单绑定事件
//		$("#menuUL a").click(function(){
//			var url = $(this).attr("action");
//			var tabCode = $(this).attr("code");
//			loadContent('',tabCode,url,'clientWrapContent');
//		});
//		detecteIsLogin();
//	});
	
	var params = {pageCode:'clentCenter'};
	commonLoad($("#indexSide"),CONTEXT_PATH + "/client/indexSide",params,function(self){
		//二级菜单绑定事件
		$("#secondMenuUL a").click(function(){
			var url = $(this).attr("action");
			var tabCode = $(this).attr("code");
			loadContent($(this),tabCode,url,'levelOneContent');
		});
		
		if(QUERY_STRING) {
			$("#secondMenuUL li a[code='"+ QUERY_STRING.split("=")[1] +"']").trigger('click');
		} else {
			$("#levelOneContent").load(CONTEXT_PATH + "/client/mgtCenter/clientOverView/overView",null,function(){});
		}
	});
	
//	$("#indexSide").load(CONTEXT_PATH + "/client/indexSide",{data:params},function(){
//		//二级菜单绑定事件
//		$("#secondMenuUL a").click(function(){
//			var url = $(this).attr("action");
//			var tabCode = $(this).attr("code");
//			loadContent($(this),tabCode,url,'levelOneContent');
//		});
//		
//		if(QUERY_STRING) {
//			$("#secondMenuUL li a[code='"+ QUERY_STRING.split("=")[1] +"']").trigger('click');
//		} else {
//			$("#levelOneContent").load(CONTEXT_PATH + "/client/mgtCenter/clientOverView/overView",null,function(){});
//		}
//	});
});

