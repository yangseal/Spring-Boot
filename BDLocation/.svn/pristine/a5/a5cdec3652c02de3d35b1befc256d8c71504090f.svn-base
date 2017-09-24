function loadContent(target,tabCode,url,domId){
	if(tabCode && tabCode == 'homeIndex'){  //首页进行跳转
		window.location.href = CONTEXT_PATH +"/";
		return;
	}
	commonLoad($("#" + domId),url,{'pageCode':tabCode},function(self){
	});
	
	//$("#" + domId).load(url,{'pageCode':tabCode},function(data){});
	if(target && tabCode)
		target.parent().addClass('on').siblings().removeClass('on');
}
/**
 * 1.试用服务 跳转 服务申请介绍页
 * 2.正式服务 跳转 购买服务页面
 * @param serviceType (试用:test、购买:formal)
 * @param productType (米级:milevel 、亚米级:meter、厘米级:centimeter)
 */
function transApply(serviceType,productType) {
  var url = CONTEXT_PATH;
  if(serviceType == 'test'){  //测试 申请 跳转
	  url += "/propagandas/testServiceApply?serviceType= " + serviceType + " &productType=" + productType;
  } else {  //正式 申请 跳转
	  url += "/client/service/formalApplyConfig?serviceType= " + serviceType + " &productType=" + productType;
  }
  window.location.href = url;
}

/**
 * 根据 用户是否登录  决定跳转页面
 * 1. 如果登录   直接跳转申请提交页面
 * 2. 如果没有登录  跳转 注册登录界面
 */
function transApplySubmit(sender){
  var url = CONTEXT_PATH + "/client/service/testServiceSubmit?serviceType=" + sender;
  location.href = url;
}
/**
 * 提交试用服务申请
 */
function submitServiceApply(){
	var serverType = $('#serverType').val();
	var url = CONTEXT_PATH + "/client/service/submitServiceApply";
	commonPost(url,{serviceType:serverType},function(data){
		if(data.success){
			showAlert(data.message);
			setTimeout(function(){
				window.location.href = CONTEXT_PATH + "/client/index?menuItemCode=ordersMgt";
			},2000);
		}else{
			showAlert("试用服务申请提交失败,请联系管理人员!");
		}
	});
//	var serverType = $('#serverType').val();
//	var url = CONTEXT_PATH + "/client/service/submitServiceApply?serviceType=" + serverType;
//	jQuery.post(url, serverType, function(data){
//		if(data.success){
//			showAlert(data.message);
//			setTimeout(function(){
//				window.location.href = CONTEXT_PATH + "/client/index?menuItemCode=ordersMgt";
//			},3000);
//		}else{
//			showAlert("试用服务申请提交失败,请联系管理人员!");
//		}
//	});
}
/**
 * 返回首页
 */
function backToIndex(){
	location.href = CONTEXT_PATH + "/";
}

/**
*  跳转 到 正式服务清单确认界面
*/
function transToOrderSubmit() {
  var url = CONTEXT_PATH + "/client/service/formalApplyConfirm";
  	  url+="?companyId="+$("#companyId").val();
  location.href = url;
}

/**
 * 服务时长中（按钮选择）和（输入框输入）切换控制
 */
function radioChange(name){
  $("input[name='"+name+"']").change(function(){
    $(this).parent().parent().find("input[class='time_num']").val("");
  });
  $("input[class='time_num']").focus(function(){
    $(this).parent().parent().find("input[name='"+name+"']").removeAttr("checked");
  });
}
/**
 * 加入清单(入网精度,账号数量,服务时长)
 */
function addToCard(obj,accuracy){
    var userId = $("#userId").val();
    var companyId = $("#companyId").val();
    var accountNum = $(obj).parent().find(".spinnerExample").val();
    var serveTime = null;
    if($(obj).parent().find(".time_num").val()){
      serveTime = $(obj).parent().find("input[class='time_num']").val();
    }else{
      serveTime = $(obj).parent().find('input[type="radio"]:checked ').val();
    }
    if(serveTime<=0 || !serveTime){
      showAlert("存在非法数字！");
      return;
    }
  // showAlert("您选择的规格为:入网精度:"+accuracy+",账号数量:"+accountNum+",服务时长:"+serveTime+"  "+userId+"  "+companyId);
  var url = CONTEXT_PATH +"/client/service/saveCorsApply";
  //var params = "applyCount="+accountNum+"&company.companyId="+companyId+"&user.userId="+userId+"&bdDeviceAccuracy="+accuracy+"&accountUsePeriod="+serveTime;
  var params = {'applyCount':accountNum,
		  'company.companyId':companyId,
		  'user.userId':userId,
		  'bdDeviceAccuracy':accuracy,
		  'accountUsePeriod':serveTime};
  commonPost(url,params,function(data){
	  if(data.success){
	    	$.tipsBox({
				obj: $(obj),
				str: "+"+accountNum,
				callback: function () {
				}
			});
	    }
  });
//  $.post(url,params,function(data){
//    if(data.success){
//    	$.tipsBox({
//			obj: $(obj),
//			str: "+"+accountNum,
//			callback: function () {
//			}
//		});
//    }
//  });
}
  /**
   * 删除当前服务
   * 
   */
  function deleteServe(obj,corsApplyId){
	  showConfirm("您确定要删除吗?",function(r){
		 if(r){
			 var url = CONTEXT_PATH +"/client/service/deleteCorsApply";
			    var params ={"corsApplyId":corsApplyId};
			    commonPost(url,params,function(data){
			    	$(obj).parent().parent().remove();
				    countCorsInfo();
				});
//			    $.post(url,params,function(){
//			      $(obj).parent().parent().remove();
//			      countCorsInfo();
//			    });
		 } 
	  });
  }
  /**
   * 提交当前服务 
   * 
   */
  function submitServe(){
	  
	  var obj = $("#corsAccountsData").find("tr");
	  if(obj.length == 0){
		  showAlert("请选择后提交！");
		  return;
	  }
	  showConfirm("您确定要提交吗?",function(r){
		  if(r){
			  var url = CONTEXT_PATH+"/client/service/confirmCorsApply";
			  var corsApplyTempParams = "";
		    
			  $.each(obj,function(index,item){
			      if(index == obj.length-1){
			        corsApplyTempParams += $(item).attr("entity")+"&"+$(item).find(".spinnerExample").val()+"&"+$(item).attr("applyType");
			      }else{
			        corsApplyTempParams += $(item).attr("entity")+"&"+$(item).find(".spinnerExample").val()+"&"+$(item).attr("applyType")+",";
			      }
			  });
			  
			  var params ={"corsApplyTempParams":corsApplyTempParams};
			  commonPost(url,params,function(data){
				  showAlert("提交成功！正在跳转页面中。。。");
			    	setTimeout(function(){
			    	    location.href = CONTEXT_PATH + "/client/index?menuItemCode=ordersMgt";
			    	},2000);
			  });
//			  $.post(url,params,function(){
//				  showAlert("提交成功！正在跳转页面中。。。");
//			    	setTimeout(function(){
//			    	    location.href = CONTEXT_PATH + "/client/index?menuItemCode=ordersMgt";
//			    	},3000);
//			  });
		  }
	  });
  }
  /**
   * 继续添加
   */
  function continueAdd(){
	  window.location.href = CONTEXT_PATH + "/client/service/formalApplyConfig";
  }
  
  /**
   * 统计所选账号信息
   */
  function countCorsInfo(){
	  var serverTypeNames = "",serviceTypeNums = "";
		  centimeterType = 0, centimeterTypeName = "", centimeterTypeNum = 0,
		  meterType = 0, meterTypeName = "", meterTypeNum = 0,
		  milevelType = 0, milevelTypeName = ""; milevelTypeNum = 0,
	  $("tr",$("#corsAccountsData")).each(function(i,obj){
		  var applyType = $(this).attr('applyType');
		  if(applyType == 'centimeter'){
			  centimeterType = 1;
			  centimeterTypeName = $(this).find("td[name='corsTypeName']").text();
			  centimeterTypeNum += $(this).find("input[type]").val()-0;
		  }
		  if(applyType == 'meter'){
			  meterType = 1;
			  meterTypeName = $(this).find("td[name='corsTypeName']").text();
			  meterTypeNum += $(this).find("input[type]").val()-0;
		  }
		  if(applyType == 'milevel'){
			  milevelType = 1;
			  milevelTypeName = $(this).find("td[name='corsTypeName']").text();
			  milevelTypeNum += $(this).find("input[type]").val()-0;
		  }
	  });
	 
	  if(centimeterType) {
		  serverTypeNames += centimeterTypeName + "、";
		  serviceTypeNums += centimeterTypeName + " <i type='centimeter'>" + centimeterTypeNum +"</i> 个、";
	  }
	  if(meterType) {
		  serverTypeNames += meterTypeName + "、";
		  serviceTypeNums += meterTypeName + " <i type='meter'>" + meterTypeNum +"</i> 个、";
	  }
	  if(milevelType) {
		  serverTypeNames += milevelTypeName;
		  serviceTypeNums += milevelTypeName + " <i type='milevel'>" + milevelTypeNum +"</i> 个";
	  }
	  if(serverTypeNames.substring(serverTypeNames.length,serverTypeNames.length-1)=="、"){
		  serverTypeNames = serverTypeNames.substring(0,serverTypeNames.length-1);
	  }
	  if(serviceTypeNums.substring(serviceTypeNums.length,serviceTypeNums.length-1)=="、"){
		  serviceTypeNums = serviceTypeNums.substring(0,serviceTypeNums.length-1);
	  }
	  $("#corsTypes").text(serverTypeNames);
	  $("#corsTypeNum").text(centimeterType + meterType + milevelType);
	  $("#corsCateNum").html(serviceTypeNums);
	  $("#corsSumNum").text((centimeterTypeNum-0) + (meterTypeNum-0) + (milevelTypeNum-0));
  }
  
  function listenButtonClick(){
	  $("button[class='decrease']",$("#corsAccountsData")).bind('click',function(){
		  _dealListenData(this,'decrease');
	  });
	  
	  $("button[class='increase']",$("#corsAccountsData")).bind('click',function(){
		  _dealListenData(this,'increase');
	  });
  }
  
  
  
  function _dealListenData(self,type){
	 var corsSumNum = 0;
	 var applyType = $(self).parent().parent().parent().attr("applyType");
	 $.each($("tr[applyType='"+applyType+"']",$("#corsAccountsData")),function(index,item){
		 corsSumNum += $(item).find(".spinnerExample").val()-0;
	 });	 
	  var applytype = $(self).closest('tr').attr("applytype"),
	  	  corsSumNumDom = $("i[id='corsSumNum']");
	  $("i[type='" + applytype + "']").text(corsSumNum);
	  if(type == 'decrease')
		  corsSumNumDom.text(corsSumNumDom.text()-1);
	  else
		  corsSumNumDom.text((corsSumNumDom.text()-0)+1);
  }
  

$(function(){
  radioChange("cm_buy_time");
  radioChange("m_buy_time");
  radioChange("mi_buy_time");
  countCorsInfo();
  listenButtonClick();
});

