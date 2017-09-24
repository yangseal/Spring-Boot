(function($){
    $.fn.createModal = function(options,callback) {
        var opts = $.extend({}, $.fn.createModal.defaults, options);
        var uniqueSequence = options.uniqueSequence;
        return this.each(function() {
            $this = $(this);
        	var modalContainer = "",
            	modalBg = "",
            	modalContent = "";
            if(!uniqueSequence){
            	 modalContainer = document.createElement("div"),
                 modalBg = document.createElement("div"),
                 modalContent = document.createElement("div");
            }else{
            	if($("div#"+uniqueSequence).length){
            		$("#"+uniqueSequence).show();
            		return;
            	}else {
            		modalContainer = document.createElement("div"),
                	modalContainer.setAttribute("id", uniqueSequence);
                    modalBg = document.createElement("div"),
                    modalBg.setAttribute("id", uniqueSequence+"modalBg");
                    modalContent = document.createElement("div");
                    modalContent.setAttribute("id", uniqueSequence+"modalContent");
            	}
            }
            
            $(modalBg).css({
                "position": "absolute",
                "top": 0,
                "left": 0,
                "width": "100%",
                "height": "100%",
                "background-color": opts.background,
                "opacity": 0.5
            });

            $(modalContent).css({
                "position": "fixed",
                "background-color": "#fff",
                "width": opts.width,
                "height": opts.height,
                "left": ($(document).width() - parseInt(opts.width))/2,
                "top": ($(window).height() - parseInt(opts.height))/2,
                "border": "0px #fff solid",
                "border-radius": "3px"
            });

            $(modalContainer).css({
                position: "fixed",
                width: "100%",
                height: $(document).height(),
				zIndex: 1000,
				left: 0,
				top: 0
            }).append(modalBg).append(modalContent);//确定modalContainer的位置

            var writeModal = function(_$this){
                $(window).resize(function(){
                    $(modalContent).css({
                        "left": ($(window).width() - parseInt(opts.width))/2,
                        "top": ($(window).height() - parseInt(opts.height))/2
                    });
                    $(modalBg).css({
                        "height": $(document).height()
                    });
                });//窗口大小变化时,将弹窗移动到屏幕中间位置

                var getTitle = _$this.attr("data-title")||opts.title;
                if(getTitle){
                    $(modalContent).append(
                            "<h1 class='modal-title' control-move>" + getTitle + "</h1>"
                    );
                }//获取data-title的值

                $(modalContent).append(
                    "<div class='modal-close close-pos-r-t'>X</div>"
                );

                if(_$this.attr("data-url")){
                    htmlobj = $.ajax({
                        url: _$this.attr("data-url"),
                        async:false
                    });
                    $(modalContent).append("<p>" + htmlobj.responseText + "</p>");//写入ajax请求得到的值
                }else {
                    if(opts.html == ""){
                        var getContent = _$this.html();
                        $(modalContent).append("<p>" + getContent + "</p>").append("<p>这种情况就是直接读取触发当前事件的元素的html代码</p>");
                    }else{
                        $(modalContent).append(opts.html);
                    }
                };

                $(modalContainer).prependTo("body");

                if(opts.bgClose){
                    $(modalBg).click(function(){
                    	if(!uniqueSequence){
                    		$(modalContent).empty();
                            $(modalContainer).remove();
                    	}else{
                    	    //$(modalContent).empty();
                            $(modalContainer).hide();
                    	}
                    });
                };
                $(".modal-close").click(function(){
                	if(!uniqueSequence){
                		$(modalContent).empty();
                        $(modalContainer).remove();
                	}else{
                	    //$(modalContent).empty();
                        $(modalContainer).hide();
                	}
                });

                if(opts.move){
                    $(modalContent).find("[control-move]").css("cursor","move").on("mousedown",function(e){
                        /*$(this)[0].onselectstart = function(e) { return false; }*///防止拖动窗口时，会有文字被选中的现象(事实证明不加上这段效果会更好)
                        $(this)[0].oncontextmenu = function(e) { return false; }//防止右击弹出菜单
                        var getStartX = e.pageX,
                            getStartY =  e.pageY;
                        var getPositionX = $(modalContent).offset().left,
                            getPositionY = $(modalContent).offset().top;
                        $(document).on("mousemove",function(e){
                            var getEndX = e.pageX,
                                getEndY =  e.pageY;
                            $(modalContent).css({
                                left: getEndX-getStartX+getPositionX,
                                top: getEndY-getStartY+getPositionY
                            });
                        });
                        $(document).on("mouseup",function(){
                            $(document).unbind("mousemove");
                        })
                    });
                };
                if(opts.resizable){//设定弹窗是否可以拖动改变大小
                    

    
                };
                if(callback){
                    callback();
                };
                if(opts.addFunction){
                    opts.addFunction();
                };

            }


            //注意这个if...else中的内容基本上是一样的，只是为了防止出现奇葩在元素上写的onclick的方法时 出现无限循环
            writeModal($this);
        });
    };
    $.fn.createModal.defaults = {
        background: '#000000',    //设定弹窗之后的覆盖层的颜色
        width: '600px',	     	  //设定弹窗的宽度	
        height: '500px',          //设定弹窗的高度
        html: "",
        move: true,				  //规定弹窗是否可以拖动
        resizable: true,		  //设定弹窗是否可以拖动改变大小
		bgClose: false,			  //点击覆盖层是否关闭
		title:"弹出框",			  //设置弹出title
		addFunction: function(){},
		uniqueSequence:""		  //弹出框唯一序列值
    };
})(jQuery);
