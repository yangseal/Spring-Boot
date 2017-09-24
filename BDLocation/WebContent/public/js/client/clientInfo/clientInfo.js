  $(function(){
	  
	  //根据状态控制页面元素装填
	  controlStateByDataState();
	  
	  //加载已上传的附件
	  initLoadAttachment($("#companyId").val());
	  
	  //上传附件重新实现
	  uploadCompanyLicense();
	  
	  
	  validateRealTime("telInfo");
	  
	  validateRealTime("emailInfo");
  });
  
  //控制公司资料编辑状态
  function controlInputEditState(){
	  $("#company_info").find('input').each(function(){
		  $(this).attr("readOnly","");
	  });
  }
  
  function controlStateByDataState(){
	  
	  $(".base_txt>p .revise").click(function(event){
	      $(this).css('display','none');
	      $(this).parent().find(".save").css('display','block');
	      $(this).parent().find("input").removeAttr('disabled');
	  });

	  $("input").keyup(function(){
		  if($.trim($(this).val()) != "")
			  $(this).removeClass("not_null_style");
		}); 
	  
	  validateRealTime("company_info");
	  
	 var companyState =  $("#companyMaterialState").val();
	 if(companyState && (companyState !='1' && companyState !='2')){
		 $(".enterprise_bt").show();
		 $("#selDoc").show();
	 }else{
		 controlInputEditState();
		 $(".enterprise_bt").hide();
		 $("#selDoc").hide();
	 }
  }
  
  //初始页面是加载图片
  function initLoadAttachment(entityId){
	  $.ajax({ 
		  url:CONTEXT_PATH + "/client/mgtCenter/clientInfo/showPicture",
		  data:{"entityId":entityId},
		  async: false,
		  success:function(data){
			  if(data){
				  $("#imgFile").attr("src",CONTEXT_PATH+"/attachment/showPicture?attachmentId=" + data + "&isThumbnail=true");
				  $("#imgFile").attr("isFile","true");
				  $("#selDoc").text('重新上传');
			  }
	      }
      });
  }
  
  function uploadCompanyLicense(){
	  $("#selDoc").bind('click',function(){
		  //删除之前上传的
		  $.post(CONTEXT_PATH+ "/client/mgtCenter/clientInfo/deletePicture",{"entityId":$("#companyId").val()},function(){});
		  
		  var _option = {"entityName":"companyLicense","fieldName":"attachments","entityId":$("#companyId").val()};
		  $("#uploadFile").fileupload({
				url : CONTEXT_PATH + "/attachment/upload",
				formData : _option,
				dataType: 'json',
		        done: function (e, data) {
		            if(data.result.success){
		            	 initLoadAttachment($("#companyId").val());
		            }else{
		            	showAlert(data.result.message);
		            }
		        }
			});
	  });
  }
  
  
  //快速保存
  function quickSave(obj){
	  debugger;
	var $input = $(obj).parent().children('input'),
		inputVal = $input.val();
	var infoId = $(obj).parent().attr("id");
	//var flag = validateForm(infoId);
//	$("#contactInfo").find('i').each(function(){
//		if($(this).text()=="*"){
//			$(this).text("");
//		}
//	});
	if(!validateForm(infoId)){
		return;
	}
  	var url = CONTEXT_PATH + "/client/mgtCenter/clientInfo/saveQuickInfo";
  	var params = {};
  	params[$input.attr('name')] = inputVal;
  	var a = $.param(params);
  	$.post(url,a,function(data){
  		if(!data.success){
  			$input.val(inputVal);
  		}
  		$(obj).css('display', 'none');
	    $(obj).parent().find(".revise").css('display', 'block');
	    $(obj).parent().find("input").attr("disabled",true);
  		showAlert(data.message);
  	});
  }
  //保存公司信息
  function saveInfo(){
	  if(!validateForm("company_info")) {
		  showAlert("信息输入有误,请检查后再次保存!");
		  return;
	  }
	  var url = CONTEXT_PATH + "/client/mgtCenter/clientInfo/saveInfo";
//	  var obj = $("#disabled_box").find("input");
//	  var parmas = "";
//	  $.each(obj,function(index,item){
//		 if(index == obj.length-1){
//			return;
//		 }else if(index == obj.length-2){
//			 parmas += $(item).attr("name")+"="+$(item).val();
//		 }else{
//		     parmas += $(item).attr("name")+"="+$(item).val()+"&";
//		 }
//	 });
	 $.post(url,$("#company_info").serialize(),function(data){
		 showAlert(data.message);
	 }); 
  }
  
 //修改密码弹出框
  function updatePass(){
	  var url = CONTEXT_PATH + "/client/mgtCenter/clientInfo/showPwd";
	  jQuery.post(url,{},function(data){
			$("#openPwd").createModal({
	            width: "650px",		//设定弹窗的宽度
	            height : "340px",		//设定弹窗的高度
	            title: "密码修改", 		//弹出框的title
	            html: data		//弹出框的内容
	        },function(){
				validateRealTime("pwdForm");
	        });
		});
  }
  //修改密码校验
  function checkPwd(){
	  if(!validateForm("pwdForm")) return;
	  
	  var url = CONTEXT_PATH + "/client/mgtCenter/clientInfo/verifyPwd";
	  $.post(url,{"pwd":$("#oldPwd").val()},function(data){
		  if(!data.success){
		    $("#oldPwdTip").text(data.message);
		    return;
		  }else{
			  var url = CONTEXT_PATH + "/client/mgtCenter/clientInfo/updatePwd";
			  var pwd = $("#newPwd").val();
			  $.post(url,{"pwd":pwd},function(data){
				  if(data.message){
					  $("#secondPwdTip").text(data.message);
				  }else{
					  showAlert("修改成功!",function(){
						  $(".modal-close").trigger('click');  
					  });
				  }
			  });
		  }
	  });
	  
  }
  
  //提交公司信息 
  function submitInfo(){
	  if(!validateForm("company_info")) {
		  showAlert("信息不完整,请检查后再次提交!");
		  return;
	  }
	  
	//上传附件判断
	  if($("#imgFile").attr("isFile") == undefined){
		  showAlert("请上传营业执照!");
		  return;
	  }
	  if(!validateForm("company_info")) return;
	  showConfirm('提交后不可再次提交,您确定继续提交吗?',function(r){
		 if(r){
			 var url = CONTEXT_PATH + "/clientInfo/submitMaterialApply";
			 $.post(url,$("#company_info").serialize(),function(data){
				 if(data.success){
					 showAlert(data.message);
					 $(".enterprise_bt").hide();
					 $("#selDoc").hide();
					 controlInputEditState();
				 }else{
					 showAlert(data.message);
				 }
			 });
			 
		 }
	  });
 }
  
$("#selDoc").on('click',function(){
  $("#uploadFile").trigger('click');
});