<!doctype html>
<html>
<head>
<#include "/head.ftl"/>
<script type="text/javascript" src="${rc.contextPath}/public/js/baseStation/construction/editConstructs.js"></script>
</head>
<body>
<form id="constructForm" class="form-horizontal">
	<input type="hidden" id="baseConstructId" name="baseConstruct.baseConstructId" value="<#if baseConstruct??>${baseConstruct.baseConstructId!}</#if>" />
	<input type="hidden" id="isQuery" />
	<div class="form-group has-feedback pt15">
		<label id="oamProjectLabel" for="oamProject" class="col-sm-2 control-label">所属项目</label>
		<div class="col-sm-2">
			<input type="text" readOnly  class="form-control" id="baseProject"  value="<#if baseConstruct?? && baseConstruct.baseProject??>${baseConstruct.baseProject.projectName!}</#if>" />
		</div>
		
		<label id="stationNameLabel" for="stationName" class="col-sm-1 control-label">基站名称</label>
		<div class="col-sm-2">
			<input type="text" readOnly class="form-control" id="stationName"  value="<#if baseConstruct??>${baseConstruct.stationName!}</#if>" isNotNull />
		</div>
		
		<label id="stationNameLabel" for="stationName" class="col-sm-1 control-label">基站编号</label>
		<div class="col-sm-2">
			<input type="text" readOnly class="form-control" id="stationNo"  value="<#if baseConstruct??>${baseConstruct.stationNo!}</#if>" isNotNull />
		</div>
	</div>
	<div class="form-group has-feedback">
		<label id="oamProjectLabel" for="oamProject" class="col-sm-2 control-label">所属客户</label>
		<div class="col-sm-2">
			<input type="text" readOnly class="form-control" id="baseProject"  value="<#if baseConstruct?? && baseConstruct.baseProject??>${baseConstruct.baseCustomer.customerName!}</#if>"  />
		</div>
		
		<label id="stationNameLabel" for="stationName" class="col-sm-1 control-label">所属区域</label>
		<div class="col-sm-2">
			<input type="text" readOnly class="form-control" id="stationName"  value="<#if baseConstruct??>${baseConstruct.oamArea.oamAreaName!}</#if>"  />
		</div>
		
		<label id="stationNameLabel" for="stationName" class="col-sm-1 control-label">所属单位</label>
		<div class="col-sm-2">
			<input type="text" readOnly class="form-control" id="stationName"  value="<#if baseConstruct??>${baseConstruct.oweCompany!}</#if>" />
		</div>
	</div>
	<div class="form-group has-feedback">
		<label id="oamProjectLabel" for="oamProject" class="col-sm-2 control-label">主选站地址</label>
		<div class="col-sm-2">
			<input type="text" readOnly class="form-control" id="baseProject"  value="<#if baseConstruct?? && baseConstruct.baseProject??>${baseConstruct.mainStationAddress!}</#if>"/>
		</div>
		
		<label id="stationNameLabel" for="stationName" class="col-sm-1 control-label">主选站联系人</label>
		<div class="col-sm-2">
			<input type="text" readOnly class="form-control" id="stationName"  value="<#if baseConstruct??>${baseConstruct.mainLinkUser!}</#if>"  />
		</div>
		
		<label id="stationNameLabel" for="stationName" class="col-sm-1 control-label">主选站电话</label>
		<div class="col-sm-2">
			<input type="text" readOnly class="form-control" id="stationName"  value="<#if baseConstruct??>${baseConstruct.mainUserPhone!}</#if>" />
		</div>
	</div>
	<div class="form-group has-feedback">
		<label id="oamProjectLabel" for="oamProject" class="col-sm-2 control-label">备选站地址</label>
		<div class="col-sm-2">
			<input type="text" readOnly class="form-control" id="baseProject"  value="<#if baseConstruct?? && baseConstruct.baseProject??>${baseConstruct.otherStationAddress!}</#if>"/>
		</div>
		
		<label id="stationNameLabel" for="stationName" class="col-sm-1 control-label">备选站联系人</label>
		<div class="col-sm-2">
			<input type="text" readOnly class="form-control" id="stationName"  value="<#if baseConstruct??>${baseConstruct.otherLinkUser!}</#if>" />
		</div>
		
		<label id="stationNameLabel" for="stationName" class="col-sm-1 control-label">备选站电话</label>
		<div class="col-sm-2">
			<input type="text" readOnly  class="form-control" id="stationName" value="<#if baseConstruct??>${baseConstruct.otherUserPhone!}</#if>"/>
		</div>
	</div>
		<#-- 切换界面  -->
	<div class="form-group has-feedback ct_btc">
	<hr style="width:auto;height:1px;border:none;border-top:1px dashed grey;" />
		<label id="oamProjectLabel" for="oamProject" class="col-sm-2 control-label"></label>
		<div class="col-sm-2 ct_bta" style="text-align:center;">
			<input type="button" class="btn ct_btbg" value="选址资料填写" onclick="selectAddressInput()" />
		</div>
		
		
		<div class="col-sm-2 ct_bta" style="text-align:center;">
			<input type="button" class="btn " value="基建资料填写" onclick="baseBuildInfoInput()" />
		</div>
		
	
		<div class="col-sm-2 ct_bta" style="text-align:center;">
			<input type="button" class="btn" value="测试资料填写" onclick="baseTestInfoInput()" />
		</div>
		

		<div class="col-sm-2 ct_bta" style="text-align:center;">
			<input type="button" class="btn " value="基站验收资料填写" onclick="baseValidateInfoInput()" />
		</div>
		<div class="col-sm-2">
			
		</div>
	</div>
	<div id="changeContentRegion"></div>
</form>
<script>
$(function(){
	function switchBg(divDe,elentDe,classDe){
	  divDe.each(function(i){
		var divDeThis = $(this);
		divDeThis.bind(elentDe,function(){
			divDe.removeClass();
			$(this).addClass(classDe);
		});
	  });
    }
	switchBg($(".ct_btc").find(".ct_bta input"),"click","ct_btbg");
});
</script>
</body>
</html>