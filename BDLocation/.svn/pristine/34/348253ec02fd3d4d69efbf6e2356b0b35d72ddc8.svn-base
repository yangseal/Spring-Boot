var _WebSocket = function(option){
	var websocket = null,
	serverpath = option.serverpath,
	resourcepath = option.resourcepath;
	if ('WebSocket' in window) {
		websocket = new WebSocket("ws://" + serverpath + "/ws");
	} else if ('MozWebSocket' in window) {
		websocket = new MozWebSocket("ws://" + serverpath + "/ws");
	} else {
		websocket = new SockJS("http://" + serverpath + "/ws/sockjs");
	}
	websocket.onopen = function(event) {
	};
	websocket.onmessage = function(event) {
		var data=JSON.parse(event.data);
		if(data.userType == 'cuservice'){  //发送给客户的
			renderCustomerMessage(data);
		}else{   //客户  发送   客服
			renderCuserviceMessage(data);
		}
	};
	
	function renderCuserviceMessage(data){
		var from = data.from,
			fromName = data.fromName,
			date = data.date,
			message = data.text.split("▓")[0],
			messageType = data.text.split("▓")[1];
		//左边列表处理
		if($("li[oweid='"+from+"']",$("#customer_list_region")).length == 0){
			var	custListItemTemplate = $("#customer_list_item_template").clone().removeAttr("style").attr("oweid",from)	
									.find("p[owename='custItemName']").text(fromName).end()
									.find("span[owename='custLastDate']").text(date).end();
			if($("#customer_list_region").children().length == 0)  //有一个空白模板
				custListItemTemplate.addClass('on');
			
			$("#customer_list_region").append(custListItemTemplate);
			
			custListItemTemplate.unbind().bind("click",function(){  //绑定 隐藏/显示 事件
				var clickId = $(this).removeClass('in').attr('oweid');
				 $(this).find("i[unread='unreadMessageNumber']").text(0);
				//如果是 最后一个  则执行 显示、隐藏 操作
				if($("#cuservie_message_panel_list").children().length == 0)
					return;
				
				var corresponseMessagePanel = $("div[id='"+clickId+"']",$("#cuservie_message_panel_list"));
				if(corresponseMessagePanel && corresponseMessagePanel.is(':hidden')){
					$(this).siblings().removeClass('on').end().addClass('on');
					corresponseMessagePanel.siblings().hide();
					corresponseMessagePanel.show();
				}
			}).bind("mouseover",function(){
			      var liDe=$(this);
			      $(this).find("i").hide();
			      $(this).find("b").show();
			      $(this).find("b").click(function(event) {
			    	  //删除对话
			    	  debugger;
			        var delSelectLi = $(this).parent(),
			        	oweid = delSelectLi.attr("oweid"),
			        	corresponseMessagePanel = $("#"+oweid,$("#cuservie_message_panel_list"));
			        
			        corresponseMessagePanel.remove();
			        if (delSelectLi.next().length>0) {
			            if (delSelectLi.hasClass('on')) {
			            	delSelectLi.next().addClass('on').trigger('click');
			            } 
			            delSelectLi.remove();
			        } else if(delSelectLi.prev().length>0) {
			            if (delSelectLi.hasClass('on')) {
			            	delSelectLi.prev().addClass('on').trigger('click');
			            }
			            delSelectLi.remove();
			        }else if(delSelectLi.siblings().length==0){  //自己是最后一个
			        	if($("#place_position_div").length == 0 && $("#cuservie_message_panel_list").children().length == 0)
			        		$("#cuservie_message_panel_list").append($('<div class="kf_dialog"></div>').attr("id","place_position_div"));
			        	  delSelectLi.remove();
			        }
			      
			      });
			}).bind("mouseleave",function(){
				$(this).find("b").hide();
			      if($(this).hasClass('in')){
			        $(this).find("i").show();
			      }else{
			        $(this).find("i").hide();
			      }
			});
			
		}
		
		//如果消息面板区域的子节点为 0，添加一个展位，否则删除 占位
		if($("#cuservie_message_panel_list").children().length == 1)
			$("#place_position_div").remove();
		
		debugger;	
		
		//右边内容区域处理
		var $blankMessagePanel = $('<div class="kf_dialog"></div>'),
			$oldMessagePanel = $("#"+from,$("#cuservie_message_panel_list"));

		if($oldMessagePanel.length == 0){
			$("#cuservie_message_panel_list").append($blankMessagePanel.attr('id',from));
			$oldMessagePanel = $("#"+from,$("#cuservie_message_panel_list"));
		}
		
		//判断当前消息是否   是 正在通话的消息  否则消息面板隐藏
		var isCurrSelect = $("#customer_list_region").find("li[oweid='" + from + "']").hasClass("on"),
			currSelect = $("#customer_list_region").find("li[oweid='" + from + "']");
		if(!isCurrSelect){
			$oldMessagePanel.hide();
			var iRead = currSelect.addClass('in').find("i[unread='unreadMessageNumber']").removeAttr('style'),
				textVal = iRead.text()-0;
			if(textVal && textVal != 0){
				iRead.text(textVal+1);
			}else{
				iRead.text(1);
			}
		}
		var $customerMessageTemplate = $("#customer_message_template").clone().removeAttr("style").removeAttr("id")
		.find("span[owename='customer_message_name']").text(fromName).end()
		.find("span[owename='customer_message_date']").text(date).end();
		
		if(messageType == 'text'){
			$customerMessageTemplate.find("div[owename='customer_message_text']").html(message).end();
			$oldMessagePanel.append($customerMessageTemplate);
		}else{
			reloadReceiveChatPicture(message,$customerMessageTemplate,$oldMessagePanel,'customer_message_text');
		}
		
////		var $customerMessageTemplate = $("#customer_message_template").clone().removeAttr("style").removeAttr("id")
////									.find("span[owename='customer_message_name']").text(fromName).end()
////									.find("span[owename='customer_message_date']").text(date).end()
////									$customerMessageTemplate.find("div[owename='customer_message_text']").html(message).end();
//		
//		
//		$oldMessagePanel.append($customerMessageTemplate);
	}
	
	
	
	function renderCustomerMessage(data){
		var message = data.text.split("▓")[0],
			messageType = data.text.split("▓")[1],
			targetDialog = $("#dialogContent");
		var $cuserviceMessageTemplate = $("#cuservice_message_template").clone().removeAttr("style").removeAttr("id")
										.find("span[owename='cuservice_message_name']").text(data.fromName).end()
										.find("span[owename='cuservice_message_date']").text(data.date).end();
		
		if(messageType == 'text'){
			$cuserviceMessageTemplate.find("div[owename='cuservice_message_text']").html(message).end();
			targetDialog.append($cuserviceMessageTemplate);
		}else{
			reloadReceiveChatPicture(message,$cuserviceMessageTemplate,targetDialog,'cuservice_message_text');
		}
		$("#sendTo").val(data.from);
		scrollToBottom('dialogContent');
	}
	
	websocket.onerror = function(event) {
	};
	websocket.onclose = function(event) {
	};
	function scrollToBottom(targetContentId){
		var div = document.getElementById(targetContentId);
		if(div)
			div.scrollTop = div.scrollHeight;
	}
	sendMsg = function(){
		var message = $("#sendContent").html();
		if(message == ""){
			return;
		}else{
			var userType = $("#userType").val();
			
			if(userType == 'cuservice'){  //发给客户的
				sendCuserviceMessage(message,'text');
			}else{	// 客户  发给  客服人员
				sendCustomerMessage(message,'text');
			}
		}
	};
	
	//生成6位随机数
	function MathRand(){ 
		var Num=""; 
		for(var i=0;i<6;i++){ 
			Num+=Math.floor(Math.random()*10); 
		} 
		return Num;
	} 
	
	//发送图片
	uploadChatPicture = function (){
//		  $("#uploadFile").bind('click',function(){
			  var chatImageId = new Date().getTime() + MathRand();
			  debugger;
			  var _option = {"entityName":"chatPicture","fieldName":"attachments","entityId":chatImageId};
			  $("#uploadFile").fileupload({
					url : resourcepath + "attachment/upload",
					iframe: true,
					formData : _option,
					dataType: 'json',
					forceIframeTransport: true,
			        done: function (e, data) {
			        	if(data.result.success){
			        		reloadSendChatPicture(data.formData[2].value,$("#userType").val());
			        	}
			        }
				});
//		  });
	};
	
	//初始页面是加载图片
	function reloadReceiveChatPicture(entityId,customerMessageTemplate,targetAppendDom,messageOwename){
		  $.ajax({ 
			  url:resourcepath + "client/mgtCenter/clientInfo/showPicture",
			  data:{"entityId":entityId},
			  async: false,
			  success:function(data){
				  if(data){
					  var imageMessage = '<div style="max-width:690px;max-heigth:400px;"><img src="/BDLocation/attachment/showPicture?attachmentId=' 
						  + data + '" style="max-width:690px;max-heigth:400px;"></div>';
					  customerMessageTemplate.find("div[owename='"+messageOwename+"']").html(imageMessage).end();
					  targetAppendDom.append(customerMessageTemplate);
				  }
		      }
	    });
	}

	function reloadSendChatPicture(entityId,userType){
		  $.ajax({ 
			  url:resourcepath + "client/mgtCenter/clientInfo/showPicture",
			  data:{"entityId":entityId},
			  async: false,
			  success:function(data){
				  if(data){
					  if(userType =='customer'){
						  var imageMessage = '<div style="max-width:490px;max-heigth:400px;"><img src="/BDLocation/attachment/showPicture?attachmentId=' 
							  + data + '" style="max-width:490px;max-heigth:400px;"></div>';
						  sendCustomerMessage(imageMessage,'image',entityId);
					  }else{
						  var imageMessage = '<div style="max-width:690px;max-heigth:400px;"><img src="/BDLocation/attachment/showPicture?attachmentId=' 
							  + data + '" style="max-width:690px;max-heigth:400px;"></div>';
						  sendCuserviceMessage(imageMessage,'image',entityId);
					  }
					 
				  }
		      }
	    });
	}
	
	/**
	 * 发送 客户端  消息
	 * message:文本、图片
	 * type:text、image
	 */
	function sendCustomerMessage(message,type,attachmentId){
		var data={};
		data["from"] = $("#selfId").val();
		data["fromName"]= $("#selfName").val();
		data["to"] = $("#sendTo").val();
		if(type == 'text'){  //文本直接发送文本信息
			data["text"] = message +"▓text";
		}else{  //图片  发送 附件entityId
			data["text"] = attachmentId +"▓image";
		}
		
		websocket.send(JSON.stringify(data));
		
		var $customerMessageTemplate = $("#customer_message_template").clone().removeAttr("style").removeAttr("id")
									   .find("span[owename='customer_message_date']").text(new Date().Format("hh:mm:ss")).end()
									   .find("div[owename='customer_message_text']").html(message).end();
		
		$("#dialogContent").append($customerMessageTemplate);
		scrollToBottom('dialogContent');
		$("#sendContent").empty().focus();
	}
	
	/**
	 * 发送 客服端 消息
	 * message:文本、图片
	 * type:text、image
	 */
	function sendCuserviceMessage(message,type,attachmentId){
		debugger;
		var data={},
			$currSelectCustomerId = $("#customer_list_region").find("li[class='on']").attr('oweid');
		data["from"] = $("#selfId").val();
		data["fromName"]= $("#selfName").val();
		data["to"] = $currSelectCustomerId;
		if(type == 'text'){  //文本直接发送文本信息
			data["text"] = message +"▓text";
		}else{  //图片  发送 附件entityId
			data["text"] = attachmentId +"▓image";
		}
		
		websocket.send(JSON.stringify(data));
		
		var $cuserviceMessageTemplate = $("#cuservice_message_template").clone().removeAttr("style").removeAttr("id")
									   .find("span[owename='cuservice_message_date']").text(new Date().Format("hh:mm:ss")).end()
									   .find("div[owename='cuservice_message_text']").html(message).end();
		
		
		$("#"+$currSelectCustomerId,$("#cuservie_message_panel_list")).append($cuserviceMessageTemplate);
		scrollToBottom($currSelectCustomerId);
		$("#sendContent").empty().focus();
	}
	
	
	Date.prototype.Format = function (fmt) { //author: meizz 
	    var o = {
	        "M+": this.getMonth() + 1, //月份 
	        "d+": this.getDate(), //日 
	        "h+": this.getHours(), //小时 
	        "m+": this.getMinutes(), //分 
	        "s+": this.getSeconds(), //秒 
	        "q+": Math.floor((this.getMonth() + 3) / 3), //季度 
	        "S": this.getMilliseconds() //毫秒 
	    };
	    if (/(y+)/.test(fmt)) fmt = fmt.replace(RegExp.$1, (this.getFullYear() + "").substr(4 - RegExp.$1.length));
	    for (var k in o)
	    if (new RegExp("(" + k + ")").test(fmt)) fmt = fmt.replace(RegExp.$1, (RegExp.$1.length == 1) ? (o[k]) : (("00" + o[k]).substr(("" + o[k]).length)));
	    return fmt;
	};
	
	function clearAll(){
		$("#sendContent").empty();
	}
	send = function(event){
		debugger;
		var code;
		 if(window.event){
			 code = window.event.keyCode; // IE
		 }else{
			 code = e.which; // Firefox
		 }
		if(code==13){ 
			sendMsg();
		}
	};
	
	function disconnect() {  
        if (websocket != null) {  
        	websocket.close();  
        	websocket = null;  
        }  
    }  
	
	
	return {
		close:close,
		sendMsg:sendMsg,
		send:send,
		closeWebSocket:disconnect,
		uploadChatPicture:uploadChatPicture
	};
};