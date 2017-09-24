//打开页面即执行查询
$(function(){
	refreshPage("showAccountsForm","showAccountsDiv");
	//查询绑定
	$('#bdDeviceAccuracy').change(function(){ 
		searchByCondition();
	});
	$("#corsAccountState").change(function(){
		searchByCondition();
	});
	countCorsInfo();
});

/**
 * 根据条件进行过滤
 */
function searchByCondition() {
	refreshPage("showAccountsForm","showAccountsDiv");
}

/**
 * 绑定应用区域
 */
function bindRegion(sender) {
	var url = CONTEXT_PATH + "/accountView/showRegion";
	var corsId = $(sender).parent().parent().find('input').first().val();
	var params = {corsAccountId:corsId};
	commonPost(url,params,function(data){
		$(sender).createModal({
            width: "440px",		//设定弹窗的宽度
            height: "240px",		//设定弹窗的高度
            title:"绑定应用区域", 		//弹出框的title
            html: data,		//弹出框的内容
            uniqueSequence:corsId+"region"
        },function(){
        	$.getJSON(CONTEXT_PATH+'/oamArea/client/definedOamArea',function(result){
        		Location.init([$('#CorsAccountForm input.province').val(), $('#CorsAccountForm input.city').val(),0,0,$("#address").val()], $('div#' + corsId + "region"));
        	});
        });
	});
	
//	var url = CONTEXT_PATH + "/accountView/showRegion";
//	var corsId = $(sender).parent().parent().find('input').first().val();
//	var params = {corsAccountId:corsId};
//	jQuery.post(url,params,function(data){
//		$(sender).createModal({
//            width: "440px",		//设定弹窗的宽度
//            height: "240px",		//设定弹窗的高度
//            title:"绑定应用区域", 		//弹出框的title
//            html: data,		//弹出框的内容
//            uniqueSequence:corsId+"region"
//        },function(){
//        	$.getJSON(CONTEXT_PATH+'/oamArea/client/definedOamArea',function(result){
//        		Location.init([$('#CorsAccountForm input.province').val(), $('#CorsAccountForm input.city').val(),0,0,$("#address").val()], $('div#' + corsId + "region"));
//        	});
//        });
//	});
}

/**
 * 绑定使用设备
 */
function bindDevice(sender) {
	var url = CONTEXT_PATH + "/accountView/showDevice";
	var corsId = $(sender).parent().parent().find('input').first().val();
	var params = {corsAccountId:corsId};
	commonPost(url,params,function(data){
		$(sender).createModal({
            width: "440px",		//设定弹窗的宽度
            height: "240px",		//设定弹窗的高度
            title:" 绑定设备", 		//弹出框的title
            html: data,		//弹出框的内容
            uniqueSequence:corsId+"device"
        },function(){
        });
	});
	
//	var url = CONTEXT_PATH + "/accountView/showDevice";
//	var corsId = $(sender).parent().parent().find('input').first().val();
//	var params = {corsAccountId:corsId};
//	jQuery.post(url,params,function(data){
//		$(sender).createModal({
//            width: "440px",		//设定弹窗的宽度
//            height: "240px",		//设定弹窗的高度
//            title:" 绑定设备", 		//弹出框的title
//            html: data,		//弹出框的内容
//            uniqueSequence:corsId+"device"
//        },function(){
//        });
//	});
}

/**
 * 激活当前账号（提交激活申请）
 */
function onActive(sender) {
	var url = CONTEXT_PATH + "/accountView/insertActiveApply";
	var corsId = $(sender).parent().parent().find('input').first().val();
	var params = {corsAccountId:corsId};
	commonPost(url,params,function(data){
		showAlert(data.message);
		refreshPage("showAccountsForm","showAccountsDiv",$("showAccountsForm_pageIndex").val());
	});
	
//	var url = CONTEXT_PATH + "/accountView/insertActiveApply";
//	var corsId = $(sender).parent().parent().find('input').first().val();
//	var params = {corsAccountId:corsId};
//	jQuery.post(url,params,function(data){
//		showAlert(data.message);
//		refreshPage("showAccountsForm","showAccountsDiv",$("showAccountsForm_pageIndex").val());
//	});
}

/**
 * 续费当前账号（提交续费申请）
 */
function onRepay(sender) {
	//如果资料不完整，跳转资料完善页面
	var isMaterialWS = $(sender).closest("tr").attr('isMaterialWS'),
		accountStatus = $(sender).closest("tr").attr('accountStatus');
	if(isMaterialWS != '2'){  // 【2】为认证通过
		$("#secondMenuUL li a[code='clientInfoMgt']").trigger('click');
		return;
	}
	if(accountStatus == 'unactive'){
		showAlert("账号未激活，无法进行续费操作！");
		return;
	}
	var url = CONTEXT_PATH + "/accountView/showRepay";
	var corsId = $(sender).parent().parent().find('input').first().val();
	var params = {corsAccountId:corsId};
	
	commonPost(url,params,function(data){
		$(sender).createModal({
	        width: "440px",		//设定弹窗的宽度
	        height: "180px",		//设定弹窗的高度
	        title:" 续费信息", 		//弹出框的title
	        html: data,		//弹出框的内容
	        uniqueSequence:corsId+"repay"
	    },function(){
	    	radioChanged("accountPeriod");
	    });
	});
	
	
//	//如果资料不完整，跳转资料完善页面
//	var isMaterialWS = $(sender).closest("tr").attr('isMaterialWS'),
//		accountStatus = $(sender).closest("tr").attr('accountStatus');
//	if(isMaterialWS != '2'){  // 【2】为认证通过
//		$("#secondMenuUL li a[code='clientInfoMgt']").trigger('click');
//		return;
//	}
//	if(accountStatus == 'unactive'){
//		showAlert("账号未激活，无法进行续费操作！");
//		return;
//	}
//	var url = CONTEXT_PATH + "/accountView/showRepay";
//	var corsId = $(sender).parent().parent().find('input').first().val();
//	var params = {corsAccountId:corsId};
//	jQuery.post(url,params,function(data){
//		$(sender).createModal({
//            width: "440px",		//设定弹窗的宽度
//            height: "180px",		//设定弹窗的高度
//            title:" 续费信息", 		//弹出框的title
//            html: data,		//弹出框的内容
//            uniqueSequence:corsId+"repay"
//        },function(){
//        	radioChanged("accountPeriod");
//        });
//	});
}

function corsAccountDetail(corsAccountId){
	var url = CONTEXT_PATH + "/client/mgtCenter/corsAccounts/detailAccount";
	commonPost(url,{"corsAccountId":corsAccountId},function(data){
		$("#levelTwoContent").html(data);
		$("#levelTwoContent").show();
		$("#showAccountsForm").hide();
	});
	
//	var url = CONTEXT_PATH + "/client/mgtCenter/corsAccounts/detailAccount";
//	$.post(url,{"corsAccountId":corsAccountId},function(data){
//		$("#levelTwoContent").html(data);
//		$("#levelTwoContent").show();
//		$("#showAccountsForm").hide();
//	});
}

//返回主页面
function doBack(){
	$("#levelTwoContent").hide();
	$("#showAccountsForm").show();
}

//账号续费清单
function doRepayList(){
	var url = CONTEXT_PATH + "/accountView/showRepayList";
	location.href = url;
}

//取消当前续费
function deleteRepayApply(obj,corsRepayTempId){
	  showConfirm("您确定要删除吗?",function(r){
		 if(r){
			 var url = CONTEXT_PATH +"/accountView/deleteRepayApply";
			    var params ={"corsRepayTempId":corsRepayTempId};
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

function continueAdd(){
	var url = CONTEXT_PATH + "/client/index?menuItemCode=corsAccountMgt";
	var params = {menuItemCode:"corsAccountMgt"};
	commonPost(url,params,function(data){
	});
}

/**
 * 统计所选账号信息
 */
function countCorsInfo(){
	debugger;
	  var serviceTypeNums = "",
		  centimeterType = 0, centimeterTypeName = "", centimeterTypeNum = 0,
		  meterType = 0, meterTypeName = "", meterTypeNum = 0,
		  milevelType = 0, milevelTypeName = ""; milevelTypeNum = 0;
		  
	  $("tr",$("#corsRepaysData")).each(function(i,obj){
		  var applyType = $(this).attr('applyType');
		  if( applyType == 'centimeter'){
			  centimeterType = 1;
			  centimeterTypeName = $(this).find("td[name='corsTypeName']").text();
			  centimeterTypeNum++;
		  }
		  if( applyType == 'meter'){
			  meterType = 1;
			  meterTypeName = $(this).find("td[name='corsTypeName']").text();
			  meterTypeNum++;
		  }
		  if( applyType == 'milevel'){
			  milevelType = 1;
			  milevelTypeName = $(this).find("td[name='corsTypeName']").text();
			  milevelTypeNum++;
		  }
	  });
	 
	  if(centimeterType) {
		  serviceTypeNums += centimeterTypeName + " <i type='centimeter'>" + centimeterTypeNum +"</i> 个、";
	  }
	  if(meterType) {
		  serviceTypeNums += meterTypeName + " <i type='meter'>" + meterTypeNum +"</i> 个、";
	  }
	  if(milevelType) {
		  serviceTypeNums += milevelTypeName + " <i type='milevel'>" + milevelTypeNum +"</i> 个";
	  }
	  if(serviceTypeNums.substring(serviceTypeNums.length,serviceTypeNums.length-1)=="、"){
		  serviceTypeNums = serviceTypeNums.substring(0,serviceTypeNums.length-1);
	  }
	  $("#corsRepayType").html(serviceTypeNums);
	  $("#corsRepaySumNum").text((centimeterTypeNum-0) + (meterTypeNum-0) + (milevelTypeNum-0));
}



/**
 * 提交当前服务 
 * 
 */
function submitRepayServe(){
	  var obj = $("#corsRepaysData").find("tr");
	  if(obj.length == 0){
		  showAlert("请选择后提交！");
		  return;
	  }
	  showConfirm("您确定要提交吗?",function(r){
		  if(r){
			  var url = CONTEXT_PATH+"/client/service/confirmCorsRepay";
			  var corsRepayTempParams = "";
		    
			  $.each(obj,function(index,item){
			      if(index == obj.length-1){
			    	  corsRepayTempParams += $(item).attr("corsAccountId")+"&"+$(item).find(".spinnerExample").val()+"&"+$(item).attr("entity");
			      }else{
			    	  corsRepayTempParams += $(item).attr("corsAccountId")+"&"+$(item).find(".spinnerExample").val()+"&"+$(item).attr("entity")+",";
			      }
			  });
			  
			  var params ={"corsRepayTempParams":corsRepayTempParams};
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