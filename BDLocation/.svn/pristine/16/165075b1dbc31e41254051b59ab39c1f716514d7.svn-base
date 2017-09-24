$(function(){
	if (window != top) {
		top.location.href = location.href;
	}
	
	$("#companyCode").keydown(function(e){
        if (e.keyCode == "13") {
        	e.stopPropagation();
            jQuery("#userCode").focus();
        }
    });
	$("#userCode").keydown(function(e){
        if (e.keyCode == "13") {
        	e.stopPropagation();
            jQuery("#password").focus();
        }
    });
	$("#password").keydown(function(e){
        if (e.keyCode == "13") {
        	e.stopPropagation();
        	jQuery("#checkmardstr").focus();
        }
    });
	$("#checkmardstr").keydown(function(e){
        if (e.keyCode == "13") {
        	e.stopPropagation();
            login();
        }
    });
	
	$("#imgVerifyCode").bind("click", function() {
		    $(this).attr("src", $(this).attr("src") + "?j=" + Math.random());
	 });
});

function register() {
	var url = CONTEXT_PATH + "/register";
	location.href = url;
}
function login() {
	var url = CONTEXT_PATH + "/login";
//	var companyCode = $("#companyCode").val();
//	if(!companyCode){
//		myAlert("企业编号不能为空");	
//		return;
//	}
	var userCode = $("#userCode").val();
	if(!userCode){
		myAlert("用户编号不能为空");
		return;
	}
	var password = $("#password").val();
	if(!password){
		myAlert("用户密码不能为空");
		return;
	}
	//暂时注掉，方便开发测试
	var checkMard = $("#checkmardstr").val();
	if(!checkMard){
		myAlert("验证码不能为空");
		return;
	}
	
	commonPost(url,{
		//companyCode : companyCode,
		userCode : userCode,
		password : password,
		checkMard: checkMard
	},function(data){
		if (data.success) {
			debugger;
			if (data.message && data.message.role && data.message.role.roleId && data.message.role.roleId == '402881ea5856f039015856f630fc0006'){  //跳转客户界面
				if (data.message.requestPath){
					window.location.href =  data.message.requestPath;
				} else {
					window.location.href = CONTEXT_PATH + "/client/index";
				}
			} else{
				window.location.href = CONTEXT_PATH + "/home";
			}
			
		} else {
			$("#imgVerifyCode").trigger('click');
			myAlert(data.message);
		}
	},true);
	
	
/*	jQuery.post(url, {
		//companyCode : companyCode,
		userCode : userCode,
		password : password,
		checkMard: checkMard
	}, function(data) {
		if (data.success) {
			debugger;
			if (data.message &&data.message.role && data.message.role.roleId && data.message.role.roleId == '402881ea5856f039015856f630fc0006'){  //跳转客户界面
				if (data.message.requestPath){
					window.location.href =  data.message.requestPath;
				} else {
					window.location.href = CONTEXT_PATH + "/client/index";
				}
			} else{
				window.location.href = CONTEXT_PATH + "/home";
			}
			
		} else {
			$("#imgVerifyCode").trigger('click');
			myAlert(data.message);
		}
	});*/
}
