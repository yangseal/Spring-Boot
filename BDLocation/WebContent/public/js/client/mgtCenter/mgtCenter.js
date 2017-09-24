$(function(){
	//默认加载 首页之外的第一个菜单内容
	if(QUERY_STRING) {
		$("#secondMenuUL li a[code='"+ QUERY_STRING.split("=")[1] +"']").trigger('click');
	} else {
		var defaultLoadMenu = $('#secondMenuUL a:nth-child(1)')[0],
		pageCode = $(defaultLoadMenu).attr("code"),
		pageUrl = $(defaultLoadMenu).attr("action");
		loadContent($(defaultLoadMenu),pageCode,pageUrl,'levelOneContent');
	}
});
