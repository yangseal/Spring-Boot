//打开页面即执行查询
$(function(){
	refreshPage("corsGroupsForm","corsGroupsDiv");
});

//账号查看
function corsListDetail(sender){
	var dom = $('<div class="tc_detail"><div class="tc_fixed">'+'<table border="0" cellspacing="0" cellpadding="0">'+
			'<thead>'+
			'<th width="*">入网账号</th>'+
			'<th width="85">入网精度</th>'+
			'<th width="85">账户类型</th>'+
			'<th width="175">到期时间</th>'+
			'<th width="85">账号状态</th>'+
			'<th width="85">操作</th>'+'</thead>'+'</div>');
	var url = CONTEXT_PATH + "/corsgroup/queryCorsAccount";
	var groupId = $(sender).parent().parent().find("input:hidden").val();
	var params = {corsGroupId:groupId};
	var table = "";
	jQuery.post(url, params, function(data) {
		table = '<table id="corsGroupsTable_ck" name="corsGroupsTable_ck" border="0" cellspacing="0" cellpadding="0">';
		if(data.result){
			var rltList = data.result;
			for(var i=0,l=rltList.length; i<l; i++) {
				if(rltList[i].corsAccountType != null && rltList[i].corsAccountType == "test"){
					corsAccountPeriodUnit = "个月";
				}else{
					corsAccountPeriodUnit = "年";
				}
				table += '<tr onclick="selectEntity(this);" entityId="' + (null != rltList[i].corsAccountId ? rltList[i].corsAccountId : '')  + '">'+
					'<td width="*">'+ (null != rltList[i].corsAccountCode ? rltList[i].corsAccountCode : '') +'</td>'+
					'<td width="85">'+ (null != rltList[i].bdDeviceAccuracyName ? rltList[i].bdDeviceAccuracyName : '') +'</td>'+
					'<td width="85">'+ (null != rltList[i].corsAccountTypeName ? rltList[i].corsAccountTypeName : '') +'</td>'+
					'<td width="175">'+ (null != rltList[i].exprieDate ? formatDate(rltList[i].exprieDate) : '') +'</td>'+
					'<td width="85">'+ (null != rltList[i].corsAccountStateName ? rltList[i].corsAccountStateName : '') +'</td>'+
					'<td width="85"><a style="color:red;" onclick="removeCorsAccount(this)"><span>移除</span></a></td>'+
					'</tr>';
			}
		}
		table += "</table>";
		dom.append(table);
		$("#corsGroupsForm").createModal({
            width: "800px",		//设定弹窗的宽度
            height : "325px",		//设定弹窗的高度
            title: "账号详情", 		//弹出框的title
            html: dom		//弹出框的内容
        });
	});
}

//移除该分组下的某个账号
function removeCorsAccount(sender){
	showConfirm("您确定将该账号从当前分组移除吗?",function(r){
		if(r){
			var url = CONTEXT_PATH + "/corsgroup/removeCorsAccount";
			var corsAccountId = $(sender).closest("tr").attr('entityId');
			var params = {corsAccountId:corsAccountId};
			$.post(url,params,function(data){
				$(sender).closest("tr").hide();
				refreshPage("corsGroupsForm","corsGroupsDiv");
			});
		}
	});
}

//给分组下面划分账号
function corsDivide(sender){
	//获取选择的分组
	var boxs = $("#corsGroupsTable input[type='checkbox']:checked");
	if(boxs.length > 1 || boxs.length < 1){
		showAlert("请选择一个分组进行【账号划分】!");
	} else {
		var corsGroupId = $(boxs[0]).parent().parent().find("input:hidden").first().val();
	    var dom = $('<div class="tc_detail"><div class="tc_fixed">'+'<table border="0" cellspacing="0" cellpadding="0">'+
				'<thead>'+
				'<th width="30"><input type="hidden" id="corsGroupId" value="'+corsGroupId+'" /><input type="checkbox" onclick="checkAllIn(this);" /></th>'+
				'<th width="*">入网账号</th>'+
				'<th width="95">入网精度</th>'+
				'<th width="95">账户类型</th>'+
				'<th width="175">到期时间</th>'+
				'<th width="95">账号状态</th>'+
				'</thead>'+'</div>');
	    var url = CONTEXT_PATH + "/corsgroup/queryCorsAccountNotGroup";
	    var params = {corsGroupId:corsGroupId};
	    var table = "";
	    jQuery.post(url, params, function(data) {
			table = '<table id="corsGroupsTable_cd" name="corsGroupsTable_cd" class="table">';
			if(data.result){
				var rltList = data.result;
				for(var i=0,l=rltList.length; i<l; i++) {
					table += '<tr id="'+rltList[i].corsAccountId+'" onclick="selectEntity(this);" >';
					table +='<td width="30"><input type="checkbox" isSelect="no" onclick="selectChange()" /></td>';
					table += '<td width="*">' + (rltList[i].corsAccountCode==null? "":rltList[i].corsAccountCode) + '</td>'+
							'<td width="95">' + (rltList[i].bdDeviceAccuracyName==null ? "":rltList[i].bdDeviceAccuracyName) + '</td>'+
							'<td width="95">' + (rltList[i].corsAccountTypeName==null? "":rltList[i].corsAccountTypeName) + '</td>'+
							'<td width="175">' + (rltList[i].exprieDate==null ? "":formatDate(rltList[i].exprieDate)) + '</td>'+
							'<td width="95">' + (rltList[i].corsAccountStateName==null ? "":rltList[i].corsAccountStateName) + '</td>'+
							'</tr>';
				};
			}
			table += "</table>";
			bt_ok ="<div class='bt_ok'><a onclick='confirmDivide();'><span>确定划分</span></a></div>";
			dom.append(table);
			dom.after(bt_ok);
			$("#corsGroupsForm").createModal({
	            width: "800px",		//设定弹窗的宽度
	            height : "380px",		//设定弹窗的高度
	            title: "账号划分", 		//弹出框的title
	            html: dom		//弹出框的内容
	        });
	    });
	};
}

//确定划分
function confirmDivide(){
	var url = CONTEXT_PATH + "/corsgroup/confirmDivide",
	groupId = $("#corsGroupId").val();
	corsAccountIds = "";
	$("#corsGroupsTable_cd input[type='checkbox']:checked").each(function(){
		corsAccountIds += $(this).parent().parent().attr("id")+",";
	});
	if(corsAccountIds.length<=0){
		showAlert("请选择需要划分的账号");
		return;
	}
	corsAccountIds = corsAccountIds.substring(0, corsAccountIds.length-1);
	var params = {corsAccountIds:corsAccountIds,companyGroupId:groupId};
	jQuery.post(url,params,function(data){
		refreshPage("corsGroupsForm","corsGroupsDiv");
		$(".modal-close").trigger('click');
		showAlert("划分成功！");
	});
}

//创建分组
function addGroup(sender){
	var dom = $("<div/>");
	var url = CONTEXT_PATH + "/client/mgtCenter/corsGroups/showAddGroup";
	window.curRow = $(sender).closest("tr");
	var params = {};
	dom.load(url,params,function(){
		 $("#corsGroupsForm").createModal({
	            width: "640px",		//设定弹窗的宽度
	            height : "240px",		//设定弹窗的高度
	            title: "分组创建", 		//弹出框的title
	            html: dom		//弹出框的内容
	        },function(){
	        	validateRealTime('addGroupForm');
	        });
	});
}

//编辑分组信息
function editGroup(sender){
	var dom = $("<div/>");
	var url = CONTEXT_PATH + "/client/mgtCenter/corsGroups/showAddGroup";
	window.curRow = $(sender).closest("tr");
	var id = curRow.attr("entityId");
	var params = {companyGroupId:id};
	dom.load(url,params,function(){
		$("#corsGroupsForm").createModal({
            width: "640px",		//设定弹窗的宽度
            height : "240px",		//设定弹窗的高度
            title: "分组编辑", 		//弹出框的title
            html: dom		//弹出框的内容
        },function(){
        	validateRealTime('addGroupForm');
        });
	});
}

//保存
function saveGroup(){
//	var flag = true;
//	if($.trim($("#groupName").val()) == ""){
//		$("#groupName").attr("style","border:1px solid red");
//		flag = false;
//		return;
//	}if(flag == false){
//		  return;
//	}
	if(!validateForm("addGroupForm")){
		return;
	}
//	$("#addGroupForm").find('span').each(function(){
//		if($(this).text()=="*"){
//			$(this).text("");
//		}
//	});
	var url = CONTEXT_PATH + "/client/mgtCenter/corsGroups/saveGroup";
	
	var params = $("#addGroupForm").serialize();
	jQuery.post(url, params, function(data) {
		refreshPage("corsGroupsForm","corsGroupsDiv");
		$(".modal-close").trigger('click');
		showAlert("保存成功！");
	});
};

//全选
function checkAllIn(sender){
	if($(sender).is(':checked')){
		$(sender).closest("table").parent().parent().find(":checkbox").prop("checked",true);
	}else{
		$(sender).closest("table").parent().parent().find(":checkbox").removeAttr("checked");
	}
}

function formatDate(millions){
	var d = new Date();
		d.setTime(millions);
	return d.getFullYear() + "-" + (d.getMonth() + 1) + "-" + d.getDate() + "  " + d.getHours() + ":" + d.getMinutes() + ":" + d.getSeconds();
}