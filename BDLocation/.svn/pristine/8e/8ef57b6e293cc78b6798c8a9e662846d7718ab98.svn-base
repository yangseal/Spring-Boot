$(function(){
	redioBoxSetting();
});

function redioBoxSetting(){
	var $textInput = $("input[name='accountPeriod']");
	$("input:radio").click(function(){
		$("input[name='accountPeriod']").val("");
	});
	
	$textInput.focus(function(){
		$("input:radio[name='accountPeriod']").attr("checked",false);
	});
}

function saveCorsAccount(sender){
	  var flag = true;
	  var array = $("#"+sender).find("input:text");
	  $.each(array,function(index,item){
		  if(index < array.length - 1){
			  if($.trim($(item).val()) == ""){
				$(item).attr("style","border:1px solid red");
			    flag = false;
				return;
			  }
		  }
	  });
	  if(!flag){
		  return;
	  }
	
	$("#"+sender).find('span').each(function(){
		if($(this).text()=="*"){
			$(this).text("");
		}
	});
	var url = CONTEXT_PATH + "/accountView/saveRegion";
//	if($(".text").text()=="北京" || $(".text").text()=="上海" || $(".text").text()=="天津" || $(".text").text()=="重庆"){
//		$("input[name='oamArea.oamAreaId']").val($(".province").val());
//	}
	var params = $("#"+sender).serialize();
	commonPost(url,params,function(data){
		if(data.success){
			showAlert(data.message,function(){
				  $(".modal-close").trigger('click');  
			});
			refreshPage('showAccountsForm','showAccountsDiv',$('#showAccountsForm_pageIndex').val());
		}else{
			showAlert(data.message);
		}	
	});
//	jQuery.post(url, params, function(data) {
//		if(data.success){
//			showAlert(data.message,function(){
//				  $(".modal-close").trigger('click');  
//			});
//			refreshPage('showAccountsForm','showAccountsDiv',$('#showAccountsForm_pageIndex').val());
//		}else{
//			showAlert(data.message);
//		}
//	});
}
/**
 * 添加续费申请
 */
function addRepayApply(sender){
	
	var url = CONTEXT_PATH + "/accountView/addRepayApply";
	var rediobox = $("input:radio[name='accountPeriod']:checked",$("#"+sender+"repay")).val();
	var	textVal = $("#accountPeriod",$("#"+sender+"repay")).val();
	var	params = "corsAccount.corsAccountId="+$("#corsAccountId",$("#"+sender+"repay")).val();
	if(rediobox && textVal){
		showAlert("请选择或输入您需要续费的期限");
		return;
	}
	
	if(rediobox) {
		 params += "&accountRepayPeriod="+rediobox;
	}else {
		if(textVal<=0){
			showAlert("请输入有效的数字");
			return;
		}
		 params += "&accountRepayPeriod="+textVal;
	}
	
	commonPost(url,params,function(data){
		if(data.message)
			showAlert(data.message,function(){
				  $(".modal-close").trigger('click');  
		});
		refreshPage('showAccountsForm','showAccountsDiv',$('#showAccountsForm_pageIndex').val());
	});
	
//	jQuery.post(url,params,function(data){
//		if(data.message)
//			showAlert(data.message,function(){
//				  $(".modal-close").trigger('click');  
//		});
//		refreshPage('showAccountsForm','showAccountsDiv',$('#showAccountsForm_pageIndex').val());
//	});
}



/**
 * 提交续费申请
 */
function submitRepayApply(){
	var url = CONTEXT_PATH + "/accountView/submitRepayApply";
	var rediobox = $("input:radio[name='accountPeriod']:checked").val(),
		textVal = $("input:text[name='accountPeriod']").val(),
		params = "corsAccountId="+$("#corsAccountId").val();
	if(rediobox && textVal){
		showAlert("请选择或输入您需要续费的期限");
		return;
	}
	if(textVal<=0){
		showAlert("请输入有效的数字");
		return;
	}
	if(rediobox) 
		 params += "&corsAccountPeriod="+rediobox;
	else 
		 params += "&corsAccountPeriod="+textVal;
	commonPost(url,params,function(data){
		if(data.message)
			showAlert(data.message,function(){
				  $(".modal-close").trigger('click');  
		});
		refreshPage('showAccountsForm','showAccountsDiv',$('#showAccountsForm_pageIndex').val());
	});
	
//	jQuery.post(url,params,function(data){
//		if(data.message)
//			showAlert(data.message,function(){
//				  $(".modal-close").trigger('click');  
//		});
//		refreshPage('showAccountsForm','showAccountsDiv',$('#showAccountsForm_pageIndex').val());
//	});
}

function radioChanged(name){
	  $("input[name='"+name+"']").change(function(){
	    $(this).parent().parent().find("input[class='period']").val("");
	  });
	  $("input[class='period']").focus(function(){
	    $(this).parent().parent().find("input[name='"+name+"']").removeAttr("checked");
	  });
}