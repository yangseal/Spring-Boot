$(function(){
	$('#menuUL li').hover(function(){
		$(this).children('ul').stop(true,true).show('slow');
	},function(){
		$(this).children('ul').stop(true,true).hide('slow');
	});
	
	$("#menuUL a").click(function(){
		var url = $(this).attr("action");
		var tabName = $(this).text();
		var tabCode = $(this).attr("code");
		openMenu(tabCode,tabName,url);
	});
	
	$("#mainContentDiv").height($("body").height() - 142);
});

function openMenu(tabCode, tabName, url, parentCode) {
	if (!url || !tabName || !tabCode) {
		return;
	}
	//临时写法，有待后边系统改造
	if(tabCode == 'stationRunState'){
		window.open(url);
		return;
	}
	if(!parentCode){
		parentCode = $("#tabUL li.active").attr("code");
	}
	$("#tabUL li.active").removeClass("active");
	$("#mainContentDiv iframe.active").removeClass("active");
	$("#tabUL li[code='" + tabCode + "']").remove();
	$("#mainContentDiv iframe[code='" + tabCode + "']").remove();
	var tabHtml = "<li class='active' code='" + tabCode;
	if(parentCode){
		tabHtml = tabHtml + "' parentCode='" + parentCode;
	}
	tabHtml = tabHtml + "'><a href='javascript:;' onclick='activeTab(\""
			+ tabCode + "\");'>" + tabName
			+ "</a><a href='javascript:;' onclick='closeTab(\""
			+ tabCode + "\");' class='glyphicon glyphicon-remove tab-close-btn'></a></li>";
	$(tabHtml).appendTo("#tabUL");
	var contentHtml = "<iframe class='active' code='" + tabCode 
		+ "' src='" + url + "' frameBorder='0'>";
	$(contentHtml).appendTo("#mainContentDiv");
}

function activeTab(tabCode){
	if(!tabCode){
		return;
	}
	$("#tabUL li.active").removeClass("active");
	$("#mainContentDiv iframe.active").removeClass("active");
	$("#tabUL li[code='"+tabCode+"']").addClass("active");
	$("#mainContentDiv iframe[code='"+tabCode+"']").addClass("active");
}

function closeTab(tabCode){
	if(!tabCode){
		return;
	}
	var tabLI = $("#tabUL li[code='"+tabCode+"']");
	$("#mainContentDiv iframe[code='"+tabCode+"']").remove();
	if(tabLI.hasClass("active")){
		var parentCode = tabLI.attr("parentCode");
		tabLI.remove();
		if($("#tabUL li[code='"+parentCode+"']").length > 0){
			activeTab(parentCode);
			return;
		}
		var lastCode = $("#tabUL li:last").attr("code");
		activeTab(lastCode);
	}else{
		tabLI.remove();
	}
}

function getOpener(){
	var tabLI = $("#tabUL li.active");
	if(tabLI.length != 1){
		return null;
	}
	var parentCode = tabLI.attr("parentCode");
	if(!parentCode){
		return null;
	}
	var parentCodeArray = parentCode.split("|");
	var result = window;
	for(var i = parentCodeArray.length - 1; i > -1; i--){
		result = getIframeByCode(parentCodeArray[i],result);
	}
	return result;
}

function getIframeByCode(iframeCode,curWindow){
	if(!curWindow || !curWindow.frames){
		return null;
	}
	for(var i = 0; i < curWindow.frames.length; i++){
		if(iframeCode == curWindow.frames[i].frameElement.getAttribute("code")){
			return curWindow.frames[i];
		}
	}
	return null;
}

function updatePassword(){
	var dom = $("<div/>");
	var url = CONTEXT_PATH + "/home/updatePassword";
	dom.load(url,null,function(){
		dialog({
			title : "更新密码",
			content : dom,
			width:800
		}).showModal();
	});
}

function move1(direction){
    if(direction == 0){
      for (var i = $("#tabUL li").length - 1; i > -1; i--) {
        if ($("#tabUL li:eq("+i+")").css("display") == "none") {
        $("#tabUL li:eq("+i+")").css("display","block");
        break;
       }
      }
    }
    else{
      if($("#tabUL")[0].scrollHeight > 32 ){
        for (var i = 0; i < $("#tabUL li").length; i++) {
          if ($("#tabUL li:eq("+i+")").css("display") != "none") {
          $("#tabUL li:eq("+i+")").css("display","none");
          break;
          }
        }
      }
    }
}
