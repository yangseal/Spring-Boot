说明：
	clientInfo      ：基本信息管理     对应controller为：ClientBaseInfoController
	corsAccounts    ：服务账号管理     对应controller为：CorsAccountController
	corsGroups      ：应用分组管理     对应controller为：CorsGroupController
	corsOrders      ：订单管理               对应controller为：CorsApplyController
	mgtCenter       ：总览     		         对应controller为：MgtCenterController
	
	js文件位置对应的文件名：在public/js/client/对应文件名 /
	
	
提示框、确认框、弹出框的用法：
	1.提示框
	showAlert('您好，请先注册或登录!')
	
	2.确认框:确定-->返回true,取消 -- 返回false
	showConfirm('您确定删除这条记录吗？',function(r){
    		alert("------确认回调------:"+r);
    	})

	3.弹出框用法：
	$("#add-key4").click(function(){
        $("#add-key4").createModal({
            width: "1000px",		//设定弹窗的宽度
            height : "500px",		//设定弹窗的高度
            title: "续费申请", 		//弹出框的title
            html: "<p>你可以在这个属性里面写入任何的html代码！</p>"		//弹出框的内容
        });
    });
    
    4.showAlert提示成功后，关闭底层弹出框
    showAlert("修改成功!",function(){
							  $(".modal-close").trigger('click');  
						  });
						  
	5.select 样式：
	<div class="form-group has-feedback">
    		<label>资料审批状态</label>
    		<select class="form-control" id="companyMaterialState" name="companyMaterialState">
				<option></option>
				<option value="null">未审核</option>
				<option value="1">审核中</option>
				<option value="2">已审核</option>
				<option value="3">已拒绝</option>
			</select>
  		</div>
  		
  	6.页面加载
  	$(function(){
		refreshPage("corsActivesForm","corsActivesDiv");
	});
	
	7.阻止事件冒泡
	function stopPropagation(){
		e = event || window.event;
		e.stopPropagation();
	}
	8.单选统一验证
	if(getSelectedEntityIdForOne(tableId){
		var entityId =	getSelectedEntityIdForOne(tableId);
	}
	9.编辑|查看跳转,例：
		function showPointType(pointTypeId,isQuery){
		var url = CONTEXT_PATH + "/pointType/showPointType";
		var title = "新增点类型";
		if(pointTypeId){
			url += "?pointTypeId=" + pointTypeId;
			title = "编辑点类型";
		}
		if(isQuery){
			url += "&isQuery=true";
			title = "查看点类型";
		}
		if($.QueryString()){
			if(url.indexOf("?")>0){
				url += "&";
			}else{
				url += "?";
			}
			url += $.QueryString()._queryString_;
		}
		openTab("pointType",title,url);
	}
	10.区域dom以及初始化
	css:<link rel="stylesheet" href="${rc.contextPath}/public/css/location.css"/>
	js:<script type="text/javascript" src="${rc.contextPath}/public/js/location/location.js"></script>
	<div class="form-group">
			<div class="sel_city">
			<p>所在区域：</p>
			<div class="city_select">
		        <div id="store-selector">
		            <div class="text" style="width:200px;"><div></div><b></b></div>                   
		            <div class="close"></div>
		        <div id="store-prompt"><strong></strong></div><!--store-prompt end--->
		        <input type="hidden" location="province" class="province" value="" />
				<input type="hidden" location="city" class="city" value="" />
		  		<input type="hidden" location="oamAreaId" name="oamArea.oamAreaId" class="city" value="" /><!-- get city id-->
		    </div>
	   		</div>
		</div>
	</div>
	
	Location.init(["","",0,0], $('#companyTempForm'));
	
	11.弹出选择基站客户：
	js:<script type="text/javascript" src="${rc.contextPath}/public/js/baseStation/baseStation.js"></script>
	<div class="form-group">
		<label id="stationMapNoLabel" for="" class="col-sm-2 control-label">所属客户</label>
		<div class="col-sm-7">
			<!--展示名称的input id='baseCustomer'-->
			<input type="text" class="form-control" id="baseCustomer" value="<#if baseConstruct?? && baseConstruct.baseCustomer??>${baseConstruct.baseCustomer.customerName!}</#if>" isNotNull onclick="selectBaseCustomer()" />
			<span class="glyphicon glyphicon-menu-hamburger form-control-feedback"></span>
			<!--真实存值的input id='baseCustomerId'-->
			<input type="hidden" id="baseCustomerId" name="baseCustomer.baseCustomerId" value="<#if baseConstruct?? && baseConstruct.baseCustomer??>${baseConstruct.baseCustomer.baseCustomerId!}</#if>" />
		</div>
		<label id="stationMapNoTip" class="control-label" style="color:red">*</label>
	</div>
	
	12.弹出选择基站项目：
	js:<script type="text/javascript" src="${rc.contextPath}/public/js/baseStation/baseStation.js"></script>
	<div class="form-group has-feedback">
		<label id="oamProjectLabel" for="oamProject" class="col-sm-2 control-label">所属项目</label>
		<div class="col-sm-7">
			<input type="text" class="form-control" style="cursor:pointer" id="baseProject"  value="<#if baseConstruct?? && baseConstruct.baseProject??>${baseConstruct.baseProject.projectName!}</#if>" onclick="selectBaseProject();" />
			<span class="glyphicon glyphicon-menu-hamburger form-control-feedback"></span>
			<input type="hidden" id="baseProjectId" name="baseProject.baseProjectId" value="<#if baseConstruct?? && baseConstruct.baseProject??>${baseConstruct.baseProject.baseProjectId!}</#if>" />
		</div>
		<label id="oamProjectTip" class="control-label" style="color:red"></label>
	</div>
	
	13.弹出选择供应商
	js:<script type="text/javascript" src="${rc.contextPath}/public/js/baseStation/baseStation.js"></script>
	<div class="form-group has-feedback">
		<label id="oamProjectLabel" for="oamProject" class="col-sm-2 control-label">所属供应商</label>
		<div class="col-sm-7">
			<input type="text" class="form-control" style="cursor:pointer" id="baseProvider"  value="<#if baseProvider?? && baseProvider.baseProject??>${baseConstruct.baseProject.projectName!}</#if>" onclick="selectBaseProvider();" />
			<span class="glyphicon glyphicon-menu-hamburger form-control-feedback"></span>
			<input type="hidden" id="baseProviderId" name="baseProject.baseProviderId" value="<#if baseProvider?? && baseProvider.baseProject??>${baseConstruct.baseProject.baseProjectId!}</#if>" />
		</div>
		<label id="oamProjectTip" class="control-label" style="color:red"></label>
	</div>
	
	14.弹出选择服务合同
	js:<script type="text/javascript" src="${rc.contextPath}/public/js/baseStation/baseStation.js"></script>
	<div class="form-group has-feedback">
		<label id="oamProjectLabel" for="oamProject" class="col-sm-2 control-label">所属合同</label>
		<div class="col-sm-7">
			<input type="text" class="form-control" style="cursor:pointer" id="baseCustomerConstract"  value="<#if baseProvider?? && baseProvider.baseProject??>${baseConstruct.baseProject.projectName!}</#if>" onclick="selectCustomerConstract();" />
			<span class="glyphicon glyphicon-menu-hamburger form-control-feedback"></span>
			<input type="hidden" id="baseCustomerConstractId" name="baseProject.baseProviderId" value="<#if baseProvider?? && baseProvider.baseProject??>${baseConstruct.baseProject.baseProjectId!}</#if>" />
		</div>
		<label id="oamProjectTip" class="control-label" style="color:red"></label>
	</div>
	
	15.保存js
	function savePointType(){
		if(!validateForm("pointTypeForm")){
			return;
		}
		var url = CONTEXT_PATH + "/pointType/savePointType";
		var params = $("#pointTypeForm").serialize();
		jQuery.post(url, params, function(data) {
			if(data.success){
				var opener = window.top.getOpener();
				opener.refreshPage("pointTypesForm","pointTypesDiv");
				if($("#pointTypeId").val()){
					myAlert(globalSaveSuccessTip);
					return;
				}
				alert(globalSaveSuccessTip);
				opener.showPointType(data.message);
			}else{
				myAlert(data.message);
			}
		});
	}
	
	16.附件上传
	//	$("#checkReports").myFileUpload({
	//		isQuery : $.QueryString("isQuery"),
	//		entityName : "checkInfo",
	//		fieldName : "checkReports",
	//		entityId : $("#baseCheckMatetialId").val()
	//	});
	//	
	//	$("#testAttachments").myFileUpload({
	//		isQuery : $.QueryString("isQuery"),
	//		entityName : "checkInfo",
	//		fieldName : "testAttachments",
	//		entityId : $("#baseCheckMatetialId").val()
	//	});
	<div class="form-group">
		<label id="checkReportsLabel" for="checkReports" class="col-sm-2 control-label">验收报告</label>
		<div class="col-sm-7">
      		<div id="checkReports" name="checkReports" style="border:1px solid">
      		</div>
      	</div>
      	<label id="checkReportsTip" class="control-label" style="color:red"></label>
	</div>
	var entityId = $("#baseCheckMatetialId").val(),
		entityName = 'checkInfo',
		isQuery = $.QueryString("isQuery");
	
	var params = [{divId:'testAttachments',isQuery:isQuery,entityName:entityName,fieldName:'testAttachments',entityId:entityId},
	              {divId:'checkReports',isQuery:isQuery,entityName:entityName,fieldName:'checkReports',entityId:entityId},
	              ];
	uploadFile(params);
	
	