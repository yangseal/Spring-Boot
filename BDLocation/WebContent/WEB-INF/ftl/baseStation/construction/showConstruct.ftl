<!doctype html>
<html>
<head>
<#include "/head.ftl"/>
<script type="text/javascript" src="${rc.contextPath}/public/js/baseStation/construction/constructs.js"></script>
<script type="text/javascript" src="${rc.contextPath}/public/js/baseStation/baseStation.js"></script>
</head>
<body>
<form id="constructForm" class="form-horizontal">
	<input type="hidden" id="baseConstructId" name="baseConstructId" value="<#if baseConstruct??>${baseConstruct.baseConstructId!}</#if>" />
	<input type="hidden" id="baseConstructSendDownState" value="<#if baseConstruct??>${baseConstruct.sendDownState!}</#if>" />
	<div class="form-group has-feedback pt15">
		<label id="baseProjectLabel" for="baseProject" class="col-sm-2 control-label">所属项目</label>
		<div class="col-sm-8">
			<input type="text" class="form-control" style="cursor:pointer" id="baseProject"  value="<#if baseConstruct?? && baseConstruct.baseProject??>${baseConstruct.baseProject.projectName!}</#if>"  <#if baseConstruct?? && baseConstruct.sendDownState != 'senddowned'>onclick="selectBaseProject();"<#else>onclick="selectBaseProject();"</#if>  readOnly isNotNull />
			<span class="glyphicon glyphicon-menu-hamburger form-control-feedback"></span>
			<input type="hidden" id="baseProjectId" name="baseProject.baseProjectId" value="<#if baseConstruct?? && baseConstruct.baseProject??>${baseConstruct.baseProject.baseProjectId!}</#if>" isNotNull />
		</div>
		<label id="baseProjectTip" class="control-label" style="color:red">*</label>
	</div>
	
	<div class="form-group">
		<label id="stationNameLabel" for="stationName" class="col-sm-2 control-label">基站名称</label>
		<div class="col-sm-8">
			<input type="text" class="form-control" id="stationName" name="stationName" value="<#if baseConstruct??>${baseConstruct.stationName!}</#if>" isNotNull />
		</div>
		<label id="stationNameTip" class="control-label" style="color:red">*</label>
	</div>
	<div class="form-group">
		<label id="stationShortNameLabel" for="stationShortName" class="col-sm-2 control-label">基站简称</label>
		<div class="col-sm-8">
			<input type="text" class="form-control" id="stationShortName" name="stationShortName" value="<#if baseConstruct??>${baseConstruct.stationShortName!}</#if>" isNotNull />
		</div>
		<label id="stationShortNameTip" class="control-label" style="color:red">*</label>
	</div>
	<div class="form-group">
		<label id="stationNoLabel" for="stationNo" class="col-sm-2 control-label">基站编号</label>
		<div class="col-sm-8">
			<input type="text" class="form-control" id="stationNo" name="stationNo" value="<#if baseConstruct??>${baseConstruct.stationNo!}</#if>" isNotNull />
		</div>
		<label id="stationNoTip" class="control-label" style="color:red">*</label>
	</div>
	<div class="form-group">
		<label id="stationMapNoLabel" for="stationMapNo" class="col-sm-2 control-label">南方测绘编号</label>
		<div class="col-sm-8">
			<input type="text" class="form-control" id="stationMapNo" name="stationMapNo" value="<#if baseConstruct??>${baseConstruct.stationMapNo!}</#if>" isNotNull />
		</div>
		<label id="stationMapNoTip" class="control-label" style="color:red">*</label>
	</div>
	<div class="form-group">
		<label id="baseCustomerLabel" for="baseCustomer" class="col-sm-2 control-label">所属客户</label>
		<div class="col-sm-8">
			<input type="text" class="form-control" style="cursor:pointer" id="baseCustomer" readOnly value="<#if baseConstruct?? && baseConstruct.baseCustomer??>${baseConstruct.baseCustomer.customerName!}</#if>" isNotNull <#if baseConstruct?? && baseConstruct.sendDownState != 'senddowned'>onclick="selectBaseCustomer()"<#else>onclick="selectBaseCustomer()"</#if> />
			<span class="glyphicon glyphicon-menu-hamburger form-control-feedback"></span>
			<input type="hidden" id="baseCustomerId" name="baseCustomer.baseCustomerId" value="<#if baseConstruct?? && baseConstruct.baseCustomer??>${baseConstruct.baseCustomer.baseCustomerId!}</#if>" />
		</div>
		<label id="baseCustomerTip" class="control-label" style="color:red">*</label>
	</div>
	<div class="form-group">
	   <label id="oamAreaIdLabel" for="oamAreaId" class="col-sm-2 control-label">所属行政区域</label>
	   <div class="col-sm-8">
			<div class="sel_city">
			<div class="city_select">
		        <div id="store-selector">
		            <div class="text" style="width:200px;"><div></div><b></b></div>                   
		            <div class="close"></div>
		        <div id="store-prompt"><strong></strong></div><!--store-prompt end--->
		        <input type="hidden" location="province" class="province" value="" />
				<input type="hidden" location="oamAreaId" name="oamArea.oamAreaId" class="city" value="<#if baseConstruct?? && baseConstruct.oamArea??>${baseConstruct.oamArea.oamAreaId!}</#if>" /><!-- get city id-->
		  		<input type="hidden" id="address" name="address" value="<#if baseConstruct?? && baseConstruct.oamArea??>${baseConstruct.oamArea.oamAreaName!}</#if>"/>
		    </div>
	   		</div>
		</div>
	  </div>
	  <label id="oamAreaTip" class="control-label" style="padding-left:10px;color:red">*</label>
	</div>

	<div class="form-group">
		<label id="oweCompanyLabel" for="oweCompany" class="col-sm-2 control-label">所属单位</label>
		<div class="col-sm-8">
			<input type="text" class="form-control" id="oweCompany" name="oweCompany" value="<#if baseConstruct??>${baseConstruct.oweCompany!}</#if>"  />
		</div>
		<label id="oweCompanyTip" class="control-label" style="color:red"></label>
	</div>
	<div class="form-group">
		<label id="ownIndustryLabel" for="ownIndustry" class="col-sm-2 control-label">所属行业</label>
		<div class="col-sm-8">
			<input type="text" class="form-control" id="ownIndustry" name="ownIndustry" value="<#if baseConstruct??>${baseConstruct.ownIndustry!}</#if>"  />
		</div>
	</div>
	<div class="form-group">
		<label id="mainStationAddressLabel" for="mainStationAddress" class="col-sm-2 control-label">主选站地址</label>
		<div class="col-sm-8">
			<input type="text" class="form-control" id="mainStationAddress" name="mainStationAddress" value="<#if baseConstruct??>${baseConstruct.mainStationAddress!}</#if>" isNotNull />
		</div>
		<label id="mainStationAddressTip" class="control-label" style="color:red">*</label>
	</div>
	<div class="form-group">
		<label id="mainLinkUserLabel" for="mainLinkUser" class="col-sm-2 control-label">主选站联系人</label>
		<div class="col-sm-8">
			<input type="text" class="form-control" id="mainLinkUser" name="mainLinkUser" value="<#if baseConstruct??>${baseConstruct.mainLinkUser!}</#if>" isNotNull />
		</div>
		<label id="mainLinkUserTip" class="control-label" style="color:red">*</label>
	</div>
	<div class="form-group">
		<label id="mainUserPhoneLabel" for="mainUserPhone" class="col-sm-2 control-label">主选站联系人电话</label>
		<div class="col-sm-8">
			<input type="text" class="form-control" id="mainUserPhone" name="mainUserPhone" value="<#if baseConstruct??>${baseConstruct.mainUserPhone!}</#if>" isNotNull />
		</div>
		<label id="mainUserPhoneTip" class="control-label" style="color:red">*</label>
	</div>
	<div class="form-group">
		<label id="otherStationAddressLabel" for="otherStationAddress" class="col-sm-2 control-label">备选站地址</label>
		<div class="col-sm-8">
			<input type="text" class="form-control" id="otherStationAddress" name="otherStationAddress" value="<#if baseConstruct??>${baseConstruct.otherStationAddress!}</#if>"  />
		</div>
		<label id="otherStationAddressTip" class="control-label" style="color:red"></label>
	</div>
	<div class="form-group">
		<label id="otherLinkUserLabel" for="otherLinkUser" class="col-sm-2 control-label">备选站联系人</label>
		<div class="col-sm-8">
			<input type="text" class="form-control" id="otherLinkUser" name="otherLinkUser" value="<#if baseConstruct??>${baseConstruct.otherLinkUser!}</#if>"  />
		</div>
		<label id="otherLinkUserTip" class="control-label" style="color:red"></label>
	</div>
	<div class="form-group">
		<label id="otherUserPhoneLabel" for="otherUserPhone" class="col-sm-2 control-label">备选站联系人电话</label>
		<div class="col-sm-8">
			<input type="text" class="form-control" id="otherUserPhone" name="otherUserPhone" value="<#if baseConstruct??>${baseConstruct.otherUserPhone!}</#if>"  />
		</div>
		<label id="otherUserPhoneTip" class="control-label" style="color:red"></label>
	</div>
	<div class="form-group">
		<label id="serverPositoinLabel" for="serverPositoin" class="col-sm-2 control-label">服务器所在位置</label>
		<div class="col-sm-8">
			<input type="text" class="form-control" id="serverPositoin" name="serverPositoin" value="<#if baseConstruct??>${baseConstruct.serverPositoin!}</#if>"  />
		</div>
		<label id="serverPositoinTip" class="control-label" style="color:red"></label>
	</div>
	<div class="form-group">
		<label id="serverFixIpLabel" for="serverFixIp" class="col-sm-2 control-label">服务器独立固定IP</label>
		<div class="col-sm-8">
			<input type="text" class="form-control" id="serverFixIp" maxlength=15 name="serverFixIp" value="<#if baseConstruct??>${baseConstruct.serverFixIp!}</#if>"  />
		</div>
		<label id="serverFixIpTip" class="control-label" style="color:red"></label>
	</div>
	<div class="form-group">
		<label id="netServerPortLabel" for="netServerPort" class="col-sm-2 control-label">网络服务端口</label>
		<div class="col-sm-8">
			<input type="text" class="form-control" id="netServerPort" name="netServerPort" maxlength=8 value="<#if baseConstruct??>${baseConstruct.netServerPort!}</#if>"  />
		</div>
		<label id="netServerPortTip" class="control-label" style="color:red"></label>
	</div>
	<div class="form-group">
		<label id="constructRemarkLabel" for="constructRemark" class="col-sm-2 control-label">备注</label>
		<div class="col-sm-8">
			<textArea type="text" class="form-control" id="constructRemark" name="constructRemark"><#if baseConstruct??>${baseConstruct.constructRemark!}</#if></textArea>
		</div>
	</div>
</form>
<#if (!RequestParameters["isQuery"]?? || RequestParameters["isQuery"]=="")>
<div class="form-group">
      <label class="col-sm-2 control-label"></label>
      <div class="col-sm-8" style="text-align:center;">
	<a  class="btn btn-success" onclick="saveConstruct();">
		<i class="glyphicon glyphicon-save"></i>
		<span>保存</span>
	</a>
	</div>
</div>
</#if>
</body>
</html>