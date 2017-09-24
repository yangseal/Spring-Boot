<!doctype html>
<html>
<head>
<#include "/head.ftl"/>
<script type="text/javascript" src="${rc.contextPath}/public/js/baseStation/construction/buidlMaterialInfo.js"></script>
</head>
<body>
	<input type="hidden" id="baseMaterialId" name="baseMaterialId" value="<#if baseMaterial??>${baseMaterial.baseMaterialId!}</#if>" />
	
	<#--基本信息-->
	<div class="form-group has-feedback">
		<label id="oamProjectLabel" for="oamProject" class="col-sm-2 control-label ct_tit"><span>基本信息</span></label>
		<div class="col-sm-8">
			<input type="hidden" class="form-control"/>
		</div>
	</div>
	
	<div class="form-group">
		<label id="buildStartTimeLabel" for="buildStartTime" class="col-sm-2 control-label">基建开始时间</label>
		<div class="col-sm-4 tips_icon">
			<input type="text" class="form-control"style="width:65%; float:left;" id="buildStartTime" name="buildStartTime" readOnly value="<#if baseMaterial??>${baseMaterial.buildStartTime!}<#else>${.now?string("yyyy-MM-dd HH:mm:ss")}</#if>" onclick="buildInitSelectTime();" isNotNull />
			<span class="glyphicon glyphicon-menu-hamburger form-control-feedback"></span>
			<span id="buildStartTimeTip" class="ct_tips">*</span>
		</div>
		<label id="buildEndTimeLabel" for="buildEndTime" class="col-sm-1 control-label">基建结束时间</label>
		<div class="col-sm-4 tips_icon">
			<input type="text" class="form-control" id="buildEndTime" name="buildEndTime" style="width:65%; float:left;" readOnly value="<#if baseMaterial??>${baseMaterial.buildEndTime!}</#if>" onclick="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm:ss',minDate:'#F{$dp.$D(\'buildStartTime\')}'})" isNotNull />
			<span class="glyphicon glyphicon-menu-hamburger form-control-feedback"></span>
			<span id="buildEndTimeTip" class="ct_tips">*</span>
		</div>
	</div> 
	
	<div class="form-group">
		<label id="senceCooperLabel" for="senceCooper" class="col-sm-2 control-label">客户现场配合人</label>
		<div class="col-sm-4">
			<input type="text" class="form-control" id="senceCooper" name="senceCooper" style="width:65%; float:left;" value="<#if baseMaterial??>${baseMaterial.senceCooper!}</#if>" isNotNull />
			<span id="senceCooperTip" class="ct_tips">*</span>
		</div>
		
		<label id="senceCooperPhoneLabel" for="senceCooperPhone" class="col-sm-1 control-label">客户配合人电话</label>
		<div class="col-sm-4">
			<input type="text" class="form-control" id="senceCooperPhone" name="senceCooperPhone" style="width:65%; float:left;" value="<#if baseMaterial??>${baseMaterial.senceCooperPhone!}</#if>" isNotNull /> <#--validateExp="(^(1\d{10})$|^((\d{7,8})|(\d{4}|\d{3})-(\d{7,8})|(\d{4}|\d{3})-(\d{7,8})-(\d{4}|\d{3}|\d{2}|\d{1})|(\d{7,8})-(\d{4}|\d{3}|\d{2}|\d{1}))$)"-->
			<span id="senceCooperPhoneTip" class="ct_tips">*</span>
		</div>
	</div>
	
	<div class="form-group">
		<label id="senceBuildChargerLabel" for="senceBuildCharger" class="col-sm-2 control-label">现场基建负责人</label>
		<div class="col-sm-4">
			<input type="text" class="form-control" id="senceBuildCharger" name="senceBuildCharger" style="width:65%; float:left;" value="<#if baseMaterial??>${baseMaterial.senceBuildCharger!}</#if>" isNotNull />
			<span id="senceBuildChargerTip" class="ct_tips">*</span>
		</div>
		
		<label id="buildChargerPhoneLabel" for="buildChargerPhone" class="col-sm-1 control-label">基建负责人电话</label>
		<div class="col-sm-4">
			<input type="text" class="form-control" id="buildChargerPhone" name="buildChargerPhone" style="width:65%; float:left;" value="<#if baseMaterial??>${baseMaterial.buildChargerPhone!}</#if>" isNotNull /> <#--validateExp="(^(1\d{10})$|^((\d{7,8})|(\d{4}|\d{3})-(\d{7,8})|(\d{4}|\d{3})-(\d{7,8})-(\d{4}|\d{3}|\d{2}|\d{1})|(\d{7,8})-(\d{4}|\d{3}|\d{2}|\d{1}))$)"-->
			<span id="buildChargerPhoneTip" class="ct_tips">*</span>
		</div>
	</div>
	
	<div class="form-group">
		<label id="senceConstPersonLabel" for="senceConstPerson" class="col-sm-2 control-label">现场施工负责人</label>
		<div class="col-sm-4">
			<input type="text" class="form-control" id="senceConstPerson" name="senceConstPerson" style="width:65%; float:left;" value="<#if baseMaterial??>${baseMaterial.senceConstPerson!}</#if>" isNotNull />
			<span id="senceConstPersonTip" class="ct_tips">*</span>
		</div>
		
		<label id="constPersonPhoneLabel" for="constPersonPhone" class="col-sm-1 control-label">施工负责人电话</label>
		<div class="col-sm-4">
			<input type="text" class="form-control" id="constPersonPhone" name="constPersonPhone" style="width:65%; float:left;" value="<#if baseMaterial??>${baseMaterial.constPersonPhone!}</#if>" isNotNull /><#--validateExp="(^(1\d{10})$|^((\d{7,8})|(\d{4}|\d{3})-(\d{7,8})|(\d{4}|\d{3})-(\d{7,8})-(\d{4}|\d{3}|\d{2}|\d{1})|(\d{7,8})-(\d{4}|\d{3}|\d{2}|\d{1}))$)"-->
			<span id="constPersonPhoneTip" class="ct_tips">*</span>
		</div>
	</div>
	<hr style="width:auto;height:1px;border:none;border-top:1px dashed grey;" />
	
	<#--附件信息-->
	<div class="form-group has-feedback">
		<label class="col-sm-2 control-label ct_tit"><span>附件信息</span></label>
		<div class="col-sm-8">
			<input type="hidden" class="form-control"/>
		</div>
	</div>
	
	<div class="form-group">
		<label id="guancePhoLabel" for="guancePho" class="col-sm-2 control-label">观测墩照片</label>
		<div class="col-sm-8">
      		<div id="guancePho" name="guancePho" class="fj_box">
      		</div>
      	</div>
      	<label id="guancePhoTip" class="control-label" style="color:red"></label>
	</div>
	
	<div class="form-group">
		<label id="videoPhoLabel" for="videoPho" class="col-sm-2 control-label">接收机照片</label>
		<div class="col-sm-8">
      		<div id="videoPho" name="videoPho" class="fj_box">
      		</div>
      	</div>
      	<label id="videoPhoTip" class="control-label" style="color:red"></label>
	</div>

	<div class="form-group">
		<label id="fangleiPhoLabel" for="fangleiPho" class="col-sm-2 control-label">防雷设备照片</label>
		<div class="col-sm-8">
      		<div id="fangleiPho" name="fangleiPho" class="fj_box">
      		</div>
      	</div>
      	<label id="fangleiPhoTip" class="control-label" style="color:red"></label>
	</div>
	
	<div class="form-group">
		<label id="jizhunConfigLabel" for="jizhunConfig" class="col-sm-2 control-label">基准站设备配置</label>
		<div class="col-sm-8">
      		<div id="jizhunConfig" name="jizhunConfig" class="fj_box">
      		</div>
      	</div>
      	<label id="jizhunConfigTip" class="control-label" style="color:red"></label>
	</div>
	
	<div class="form-group">
		<label id="jizhunNetConfigLabel" for="jizhunNetConfig" class="col-sm-2 control-label">基准站网络配置</label>
		<div class="col-sm-8">
      		<div id="jizhunNetConfig" name="jizhunNetConfig" class="fj_box">
      		</div>
      	</div>
      	<label id="jizhunNetConfigTip" class="control-label" style="color:red"></label>
	</div>
	
	<div class="form-group">
		<label id="jizhunPlanLabel" for="jizhunPlan" class="col-sm-2 control-label">基准站设计方案</label>
		<div class="col-sm-8">
      		<div id="jizhunPlan" name="jizhunPlan" class="fj_box">
      		</div>
      	</div>
      	<label id="jizhunPlanTip" class="control-label" style="color:red"></label>
	</div>
	
	<div class="form-group">
		<label id="jizhunReportLabel" for="jizhunReport" class="col-sm-2 control-label">基准站基建工程报告</label>
		<div class="col-sm-8">
      		<div id="jizhunReport" name="jizhunReport" class="fj_box"">
      		</div>
      	</div>
      	<label id="jizhunReportTip" class="control-label" style="color:red"></label>
	</div>
	
	<div class="form-group">
		<label id="deviceReportLabel" for="deviceReport" class="col-sm-2 control-label">设备安装调试报告</label>
		<div class="col-sm-8">
      		<div id="deviceReport" name="deviceReport" class="fj_box">
      		</div>
      	</div>
      	<label id="deviceReportTip" class="control-label" style="color:red"></label>
	</div>
	
	<div class="form-group has-feedback">
		<label id="materialRemarkLabel" for="materialRemark" class="col-sm-2 control-label">备注</label>
		<div class="col-sm-6">
			<textarea id="materialRemark" name="materialRemark" class="form-control" rows="3"><#if baseMaterial??>${baseMaterial.materialRemark!}</#if></textarea>
		</div>
	</div>
<#if !RequestParameters["isQuery"]?? || RequestParameters["isQuery"]!="true">
<div class="form-group">
   <label class="col-sm-2 control-label"></label>
    <div class="col-sm-8" style="text-align:center;">
	<a  class="btn btn-success" onclick="saveBuildInfo();">
		<i class="glyphicon glyphicon-save"></i>
		<span>保存</span>
	</a>
	</div>
</div>
</#if>
</body>
</html>