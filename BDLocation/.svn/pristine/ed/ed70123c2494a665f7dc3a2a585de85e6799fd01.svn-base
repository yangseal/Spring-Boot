<!doctype html>
<html>
<head>
<#include "/head.ftl"/>
<script type="text/javascript" src="${rc.contextPath}/public/js/baseStation/construction/editConstructs.js"></script>
</head>
<body>
<form id="baseStationDetailForm" class="form-horizontal">
	<input type="hidden" id="baseConstructId" name="baseConstruct.baseConstructId" value="<#if baseConstruct??>${baseConstruct.baseConstructId!}</#if>" />
	<#--基本信息-->
	<div class="form-group has-feedback">
		<label id="oamProjectLabel" for="oamProject" class="col-sm-2 control-label ct_tit"><span>基本信息</span></label>
		<div class="col-sm-9">
			<input type="hidden" class="form-control"/>
		</div>
	</div>
	<div class="form-group has-feedback">
		<label id="stationNameLabel" for="stationName" class="col-sm-2 control-label">基站名称</label>
		<div class="col-sm-2">
			<input type="text" readOnly  class="form-control" id="stationName"  value="<#if baseConstruct??>${baseConstruct.stationName!}</#if>" />
		</div>
		
		<label id="stationShortNameLabel" for="stationShortName" class="col-sm-1 control-label">基站简称</label>
		<div class="col-sm-2">
			<input type="text" readOnly class="form-control" id="stationShortName"  value="<#if baseConstruct??>${baseConstruct.stationShortName!}</#if>" isNotNull />
		</div>
		
		<label id="stationNoLabel" for="stationNo" class="col-sm-1 control-label">基站编号</label>
		<div class="col-sm-2">
			<input type="text" readOnly class="form-control" id="stationNo"  value="<#if baseConstruct??>${baseConstruct.stationNo!}</#if>" isNotNull />
		</div>
	</div>
	<div class="form-group has-feedback">
		<label id="oamAreaNameLabel" for="oamAreaName" class="col-sm-2 control-label">所属区域</label>
		<div class="col-sm-2">
			<input type="text" readOnly class="form-control" id="oamAreaName"  value="<#if baseConstruct??>${baseConstruct.oamAreaName!}</#if>"  />
		</div>
		
		<label id="mainStationAddressLabel" for="mainStationAddress" class="col-sm-1 control-label">基站地址</label>
		<div class="col-sm-2">
			<input type="text" readOnly class="form-control" id="mainStationAddress"  value="<#if baseConstruct??>${baseConstruct.mainStationAddress!}</#if>" isNotNull />
		</div>
		
		<label id="customerNameLabel" for="customerName" class="col-sm-1 control-label">所属客户</label>
		<div class="col-sm-2">
			<input type="text" readOnly class="form-control" id="customerName"  value="<#if baseConstruct??>${baseConstruct.customerName!}</#if>" isNotNull />
		</div>
	</div>
	<div class="form-group has-feedback">
		<label id="projectNameLabel" for="projectName" class="col-sm-2 control-label">所属项目</label>
		<div class="col-sm-2">
			<input type="text" readOnly class="form-control" id="projectName"  value="<#if baseConstruct??>${baseConstruct.projectName!}</#if>"/>
		</div>
		
		<label id="projectNoLabel" for="projectNo" class="col-sm-1 control-label">项目编号</label>
		<div class="col-sm-2">
			<input type="text" readOnly class="form-control" id="projectNo"  value="<#if baseConstruct??>${baseConstruct.projectNo!}</#if>" isNotNull />
		</div>
		
		<label id="mainLinkUserLabel" for="mainLinkUser" class="col-sm-1 control-label">基站联系人</label>
		<div class="col-sm-2">
			<input type="text" readOnly class="form-control" id="mainLinkUser"  value="<#if baseConstruct??>${baseConstruct.mainLinkUser!}</#if>" isNotNull />
		</div>
	</div>
	<div class="form-group has-feedback">
		<label id="mainUserPhoneLabel" for="mainUserPhone" class="col-sm-2 control-label">联系人电话</label>
		<div class="col-sm-2">
			<input type="text" readOnly class="form-control" id="mainUserPhone"  value="<#if baseConstruct??>${baseConstruct.mainUserPhone!}</#if>"/>
		</div>
		
		<label id="checkStateLabel" for="checkState" class="col-sm-1 control-label">验收状态</label>
		<div class="col-sm-2">
			<input type="text" readOnly class="form-control" id="checkState"  value="<#if baseConstruct??>${baseConstruct.checkStateName!}</#if>" isNotNull />
		</div>
		
		<label id="recordStateLabel" for="recordState" class="col-sm-1 control-label">备案状态</label>
		<div class="col-sm-2">
			<input type="text" readOnly  class="form-control" id="recordState" value="<#if baseConstruct??>${baseConstruct.recordStateName!}</#if>" isNotNull />
		</div>
	</div>
	<#--其它信息-->
	<div class="form-group has-feedback">
		<label class="col-sm-2 control-label ct_tit"><span>其它信息</span></label>
		<div class="col-sm-9">
			<input type="hidden" class="form-control"/>
		</div>
	</div>
	<div class="form-group has-feedback">
		<label id="baseLngLabel" for="baseLng" class="col-sm-2 control-label">基站经度</label>
		<div class="col-sm-2">
			<input type="text" readOnly class="form-control" id="baseLng"  value="<#if baseConstruct??>${baseConstruct.baseLng!}</#if>"/>
		</div>
		
		<label id="baseLatLabel" for="baseLat" class="col-sm-1 control-label">基站纬度</label>
		<div class="col-sm-2">
			<input type="text" readOnly class="form-control" id="baseLat"  value="<#if baseConstruct??>${baseConstruct.baseLat!}</#if>" isNotNull />
		</div>
		
		<label id="baseElevationLabel" for="baseElevation" class="col-sm-1 control-label">基站高程</label>
		<div class="col-sm-2">
			<input type="text" readOnly  class="form-control" id="baseElevation" value="<#if baseConstruct??>${baseConstruct.baseElevation!}</#if>" isNotNull />
		</div>
	</div>
	<div class="form-group has-feedback">
		<label id="stationTypeLabel" for="stationType" class="col-sm-2 control-label">站点类型</label>
		<div class="col-sm-2">
			<input type="text" readOnly class="form-control" id="stationType"  value="<#if baseConstruct??>${baseConstruct.stationType!}</#if>"/>
		</div>
		
		<label id="receiverIpLabel" for="receiverIp" class="col-sm-1 control-label">接收机IP</label>
		<div class="col-sm-2">
			<input type="text" readOnly class="form-control" id="receiverIp"  value="<#if baseConstruct??>${baseConstruct.receiverIp!}</#if>" isNotNull />
		</div>
		
		<label id="powerConditionLabel" for="powerCondition" class="col-sm-1 control-label">电力条件</label>
		<div class="col-sm-2">
		<#assign powerName=""/>
			<#if baseConstruct?? && baseConstruct.powerCondition??>
				<#list baseConstruct.powerCondition?split(",") as netP>
					<#if netP?? && netP=='1' >
						<input type="hidden" name="powerName" value="不间断供电">
					<#elseif netP?? && netP=='2' >
						<input type="hidden" name="powerName" value="220V市电">
					<#elseif netP?? && netP=='3'>
						<input type="hidden" name="powerName" value="备电">
					<#else>
						<input type="hidden" name="powerName" value="${netP}">
					</#if>
				</#list>
			</#if>
			<input type="text" readOnly  class="form-control" id="powerCondition" value="" isNotNull />
		</div>
	</div>
	<div class="form-group has-feedback">
		<label id="netConditionLabel" for="netCondition" class="col-sm-2 control-label">网络条件</label>
		<div class="col-sm-2">
		 <#assign netCName=""/>
			<#if baseConstruct?? && baseConstruct.netCondition??>
				<#list baseConstruct.netCondition?split(",") as net>
					<#if net?? && net=='1' >
						<input type="hidden" name="netCName" value="不间断网络">
					<#elseif net?? && net=='2' >
						<input type="hidden" name="netCName" value="外网">
					<#elseif net?? && net=='3'>
						<input type="hidden" name="netCName" value="独占带宽>2M">
					<#elseif net?? && net=='4'>
						<input type="hidden" name="netCName" value="固定IP">
					<#else>
						<input type="hidden" name="netCName" value="${net}">
					</#if>
				</#list>
			</#if>
			<input type="text" readOnly class="form-control" id="netCondition"  value=""/>
		</div>
		
		<label id="netTypeLabel" for="netType" class="col-sm-1 control-label">网络类别</label>
		<div class="col-sm-2">
		<#assign netTName=""/>
			<#if baseConstruct?? && baseConstruct.netType??>
				<#list baseConstruct.netType?split(",") as netT>
					<#if netT?? && netT=='1' >
						<input type="hidden" name="netTName" value="光纤">
					<#elseif netT?? && netT=='2'>
						<input type="hidden" name="netTName" value="ADSL">
					<#else>
						<input type="hidden" name="netTName" value="${netT}">
					</#if>
				</#list>
			</#if>
			<input type="text" readOnly class="form-control" id="netType"  value="" isNotNull />
		</div>
		
		<label id="netConfigLabel" for="netConfig" class="col-sm-1 control-label">网络配置</label>
		<div class="col-sm-2">
		<#assign netGName=""/>
			<#if baseConstruct?? && baseConstruct.netConfig??>
				<#list baseConstruct.netConfig?split(",") as netG>
					<#if netG?? && netG=='1' >
					<input type="hidden" name="netGName" value="交换机">
					<#elseif netG?? && netG=='2'>
					<input type="hidden" name="netGName" value="路由器">
					<#else>
					<input type="hidden" name="netGName" value="${netG}">
					</#if>
				</#list>
			</#if>
			<input type="text" readOnly  class="form-control" id="netConfig" value="" isNotNull />
		</div>
	</div>
	<div class="form-group has-feedback">
		<label id="stationMapNoLabel" for="stationMapNo" class="col-sm-2 control-label">测绘编号</label>
		<div class="col-sm-2">
			<input type="text" readOnly class="form-control" id="stationMapNo"  value="<#if baseConstruct??>${baseConstruct.stationMapNo!}</#if>"/>
		</div>
		
		<label id="serverPositoinLabel" for="serverPositoin" class="col-sm-1 control-label">服务器位置</label>
		<div class="col-sm-2">
			<input type="text" readOnly class="form-control" id="serverPositoin"  value="<#if baseConstruct??>${baseConstruct.serverPositoin!}</#if>" isNotNull />
		</div>
		
		<label id="serverFixIpLabel" for="serverFixIp" class="col-sm-1 control-label">服务器IP</label>
		<div class="col-sm-2">
			<input type="text" readOnly  class="form-control" id="serverFixIp" value="<#if baseConstruct??>${baseConstruct.serverFixIp!}</#if>" isNotNull />
		</div>
	</div>
	<div class="form-group has-feedback">
		<label id="netServerPortLabel" for="netServerPort" class="col-sm-2 control-label">网络服务端口</label>
		<div class="col-sm-2">
			<input type="text" readOnly class="form-control" id="netServerPort"  value="<#if baseConstruct??>${baseConstruct.netServerPort!}</#if>"/>
		</div>
		
		<label id="ownIndustryLabel" for="ownIndustry" class="col-sm-1 control-label">所属行业</label>
		<div class="col-sm-2">
			<input type="text" readOnly class="form-control" id="ownIndustry"  value="<#if baseConstruct??>${baseConstruct.ownIndustry!}</#if>" isNotNull />
		</div>
	</div>
	<#--验收详情-->
	<div class="form-group has-feedback">
		<label class="col-sm-2 control-label ct_tit"><span>验收详情</span></label>
		<div class="col-sm-9">
			<input type="hidden" class="form-control"/>
		</div>
	</div>
	<div class="form-group">
		<label id="checkOpinion" for="checkOpinion" class="col-sm-2 control-label">验收意见</label>
		<div class="col-sm-7">
			<textarea class="form-control" readOnly name='checkOpinion' rows="3">${baseConstruct.checkOpinion!}</textarea>
		</div>
	</div>
	<#--备案详情-->
	<div class="form-group has-feedback">
		<label class="col-sm-2 control-label ct_tit"><span>备案详情</span></label>
		<div class="col-sm-9">
			<input type="hidden" class="form-control"/>
		</div>
	</div>
	<div class="form-group">
		<label id="recordNoLabel" for="recordNo"  class="col-sm-2 control-label">备案编号</label>
		<div class="col-sm-2">
			<input type="text" readOnly class="form-control" id="recordNo" name="recordNo" maxlength="6" isNotNull value="<#if baseConstruct??>${baseConstruct.recordNo!}</#if>" />
		</div>
		<label id="recordNoTip" class="control-label" style="color:red">*</label>
	</div>
	<div class="form-group">
		<div class="form-group">
			<label id="recordAttachesLabel" for="recordAttaches" class="col-sm-2 control-label">备案附件</label>
			<div class="col-sm-7">
	      		<div id="recordAttaches" name="recordAttaches" class="fj_box">
	      		</div>
	      	</div>
      		<label id="recordAttachesTip" class="control-label" style="color:red"></label>
		</div>
	</div>
</form>
</body>
</html>