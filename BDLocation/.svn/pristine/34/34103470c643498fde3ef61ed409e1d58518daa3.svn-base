<!doctype html>
<html>
<head>
<#include "/head.ftl"/>
<script type="text/javascript" src="${rc.contextPath}/public/js/oamProject/oamProject.js"></script>
</head>
<body>

<form id="oamProjectForm" class="form-horizontal">
	<div class="form-group pt15">
		<label id="oamProjectNameLabel" for="oamProjectName" class="col-sm-1 control-label">项目名称</label>
		<div class="col-sm-5">
			<input type="text" class="form-control" id="oamProjectName" name="oamProjectName" isNotNull value="<#if oamProject??>${oamProject.oamProjectName!}<#else></#if>" />
		</div>
		<label id="oamProjectNameTip" class="control-label" style="color:red">*</label>
	</div>
	<div class="form-group">
		<label id="oamProjectCodeLabel" for="oamProjectCode" class="col-sm-1 control-label">项目编号</label>
		<div class="col-sm-5">
			<input type="text" class="form-control" id="oamProjectCode" name="oamProjectCode" isNotNull value="<#if oamProject??>${oamProject.oamProjectCode!}<#else></#if>" />
		</div>
		<label id="oamProjectCodeTip" class="control-label" style="color:red">*</label>
	</div>
	<#if !RequestParameters["oamCustomerId"]?? || RequestParameters["oamCustomerId"]=="">
	<div class="form-group has-feedback">
		<label id="oamCustomerLabel" for="oamCustomer" class="col-sm-1 control-label">所属客户</label>
		<div class="col-sm-5">
			<input type="text" class="form-control" style="cursor:pointer" id="customer" name="customer" value="<#if oamProject?? && oamProject.oamCustomer??>${oamProject.oamCustomer.oamCustomerName!}</#if>" onclick="selectOamCustomer();" />
			<span class="glyphicon glyphicon-menu-hamburger form-control-feedback"></span>
		</div>
		<label id="oamCustomerTip" class="control-label" style="color:red"></label>
	</div>
	</#if>
	<input type="hidden" id="customerId" name="customerId" value="<#if oamProject?? && oamProject.oamCustomer??>${oamProject.oamCustomer.oamCustomerId!}<#else>${RequestParameters["oamCustomerId"]!}</#if>" />
	<#if !RequestParameters["userId"]?? || RequestParameters["userId"]=="">
	<div class="form-group has-feedback">
		<label id="userLabel" for="user" class="col-sm-1 control-label">记录人</label>
		<div class="col-sm-5">
			<input type="text" class="form-control" style="cursor:pointer" id="user" name="user" value="<#if oamProject?? && oamProject.user??>${oamProject.user.userName!}<#elseif !oamProject??>${CURRENT_USER.userName!}</#if>" onclick="selectUser();" />
			<span class="glyphicon glyphicon-menu-hamburger form-control-feedback"></span>
		</div>
		<label id="userTip" class="control-label" style="color:red"></label>
	</div>
	</#if>
	<input type="hidden" id="userId" name="user.userId" value="<#if oamProject?? && oamProject.user??>${oamProject.user.userId!}<#elseif RequestParameters["userId"]??>${RequestParameters["userId"]!}<#elseif !oamProject??>${CURRENT_USER.userId!}</#if>" />
	<div class="form-group">
		<label id="stationNumLabel" for="stationNum" class="col-sm-1 control-label">建站数量</label>
		<div class="col-sm-5">
			<input type="text" class="form-control" id="stationNum" name="stationNum" validateExp="^(\d{1,}\.?\d*)$" validateTip="数量应为数值" value="<#if oamProject??>${oamProject.stationNum!}<#else></#if>" />
		</div>
		<label id="stationNumTip" class="control-label" style="color:red"></label>
	</div>
	<div class="form-group">
		<label id="programmeLabel" for="programme" class="col-sm-1 control-label">规划数量</label>
		<div class="col-sm-5">
			<input type="text" class="form-control" id="programme" name="programme" validateExp="^(\d{1,}\.?\d*)$" validateTip="数量应为数值" value="<#if oamProject??>${oamProject.programme!}<#else></#if>" />
		</div>
		<label id="programmeTip" class="control-label" style="color:red"></label>
	</div>
	<div class="form-group">
		<label id="installationSiteLabel" for="installationSite" class="col-sm-1 control-label">服务器安装位置</label>
		<div class="col-sm-5">
			<input type="text" class="form-control" id="installationSite" name="installationSite" value="<#if oamProject??>${oamProject.installationSite!}<#else></#if>" />
		</div>
		<label id="installationSiteTip" class="control-label" style="color:red"></label>
	</div>
	<div class="form-group">
		<label id="ipAddressLabel" for="ipAddress" class="col-sm-1 control-label">服务器IP</label>
		<div class="col-sm-5">
			<input type="text" class="form-control" id="ipAddress" name="ipAddress" value="<#if oamProject??>${oamProject.ipAddress!}<#else></#if>" />
		</div>
		<label id="ipAddressTip" class="control-label" style="color:red"></label>
	</div>
	<div class="form-group">
		<label id="electrificationLabel" for="electrification" class="col-sm-1 control-label">不间断供电</label>
		<div class="col-sm-5">
			<select class="form-control" id="electrification" name="electrification">
				<option></option>
				<option <#if oamProject?? && oamProject.electrification?? && "1"==oamProject.electrification || !oamProject?? && "1"=="1">selected</#if> value="1">是</option>
				<option <#if oamProject?? && oamProject.electrification?? && "0"==oamProject.electrification || !oamProject?? && "0"=="1">selected</#if> value="0">否</option>
			</select>
		</div>
		<label id="electrificationTip" class="control-label" style="color:red"></label>
	</div>
	<div class="form-group">
		<label id="serversLabel" for="servers" class="col-sm-1 control-label">准备服务器</label>
		<div class="col-sm-5">
			<select class="form-control" id="servers" name="servers">
				<option></option>
				<option <#if oamProject?? && oamProject.servers?? && "1"==oamProject.servers || !oamProject?? && "1"=="1">selected</#if> value="1">是</option>
				<option <#if oamProject?? && oamProject.servers?? && "0"==oamProject.servers || !oamProject?? && "0"=="1">selected</#if> value="0">否</option>
			</select>
		</div>
		<label id="serversTip" class="control-label" style="color:red"></label>
	</div>
	<div class="form-group">
		<label id="serversPortLabel" for="serversPort" class="col-sm-1 control-label">开通服务器相应端口</label>
		<div class="col-sm-5">
			<input type="text" class="form-control" id="serversPort" name="serversPort" value="<#if oamProject??>${oamProject.serversPort!}<#else></#if>" />
		</div>
		<label id="serversPortTip" class="control-label" style="color:red"></label>
	</div>
	<div class="form-group">
		<label id="remoteLabel" for="remote" class="col-sm-1 control-label">开通远程桌面</label>
		<div class="col-sm-5">
			<select class="form-control" id="remote" name="remote">
				<option></option>
				<option <#if oamProject?? && oamProject.remote?? && "1"==oamProject.remote || !oamProject?? && "1"=="1">selected</#if> value="1">是</option>
				<option <#if oamProject?? && oamProject.remote?? && "0"==oamProject.remote || !oamProject?? && "0"=="1">selected</#if> value="0">否</option>
			</select>
		</div>
		<label id="remoteTip" class="control-label" style="color:red"></label>
	</div>
	<div class="form-group">
		<label id="accendantLabel" for="accendant" class="col-sm-1 control-label">服务器维护方</label>
		<div class="col-sm-5">
			<input type="text" class="form-control" id="accendant" name="accendant" value="<#if oamProject??>${oamProject.accendant!}<#else></#if>" />
		</div>
		<label id="accendantTip" class="control-label" style="color:red"></label>
	</div>
	<div class="form-group">
		<label id="localPrincipalInfoLabel" for="localPrincipalInfo" class="col-sm-1 control-label">当地负责人员及联系方式</label>
		<div class="col-sm-5">
			<input type="text" class="form-control" id="localPrincipalInfo" name="localPrincipalInfo" value="<#if oamProject??>${oamProject.localPrincipalInfo!}<#else></#if>" />
		</div>
		<label id="localPrincipalInfoTip" class="control-label" style="color:red"></label>
	</div>
	<div class="form-group">
		<label id="localCooperateInfoLabel" for="localCooperateInfo" class="col-sm-1 control-label">当地配合人员及联系方式</label>
		<div class="col-sm-5">
			<input type="text" class="form-control" id="localCooperateInfo" name="localCooperateInfo" value="<#if oamProject??>${oamProject.localCooperateInfo!}<#else></#if>" />
		</div>
		<label id="localCooperateInfoTip" class="control-label" style="color:red"></label>
	</div>
	<div class="form-group">
		<label id="preliminaryMeetingLabel" for="preliminaryMeeting" class="col-sm-1 control-label">召开建站筹备会议</label>
		<div class="col-sm-5">
			<input type="text" class="form-control" id="preliminaryMeeting" name="preliminaryMeeting" value="<#if oamProject??>${oamProject.preliminaryMeeting!}<#else></#if>" />
		</div>
		<label id="preliminaryMeetingTip" class="control-label" style="color:red"></label>
	</div>
	<div class="form-group">
		<label id="driverLabel" for="driver" class="col-sm-1 control-label">车辆司机</label>
		<div class="col-sm-5">
			<input type="text" class="form-control" id="driver" name="driver" value="<#if oamProject??>${oamProject.driver!}<#else></#if>" />
		</div>
		<label id="driverTip" class="control-label" style="color:red"></label>
	</div>
	<div class="form-group">
		<label id="constructionTeamLabel" for="constructionTeam" class="col-sm-1 control-label">施工队伍及联系方式</label>
		<div class="col-sm-5">
			<input type="text" class="form-control" id="constructionTeam" name="constructionTeam" value="<#if oamProject??>${oamProject.constructionTeam!}<#else></#if>" />
		</div>
		<label id="constructionTeamTip" class="control-label" style="color:red"></label>
	</div>
	<div class="form-group">
		<label id="instrumentLabel" for="instrument" class="col-sm-1 control-label">建站仪器</label>
		<div class="col-sm-5">
			<input type="text" class="form-control" id="instrument" name="instrument" value="<#if oamProject??>${oamProject.instrument!}<#else></#if>" />
		</div>
		<label id="instrumentTip" class="control-label" style="color:red"></label>
	</div>
	<div class="form-group">
		<label id="testingDevLabel" for="testingDev" class="col-sm-1 control-label">测试设备</label>
		<div class="col-sm-5">
			<input type="text" class="form-control" id="testingDev" name="testingDev" value="<#if oamProject??>${oamProject.testingDev!}<#else></#if>" />
		</div>
		<label id="testingDevTip" class="control-label" style="color:red"></label>
	</div>
	<div class="form-group">
		<label id="mainFrameRegisterLabel" for="mainFrameRegister" class="col-sm-1 control-label">主机注册</label>
		<div class="col-sm-5">
			<input type="text" class="form-control" id="mainFrameRegister" name="mainFrameRegister" value="<#if oamProject??>${oamProject.mainFrameRegister!}<#else></#if>" />
		</div>
		<label id="mainFrameRegisterTip" class="control-label" style="color:red"></label>
	</div>
	<div class="form-group">
		<label id="nrsLabel" for="nrs" class="col-sm-1 control-label">NRS软件狗</label>
		<div class="col-sm-5">
			<input type="text" class="form-control" id="nrs" name="nrs" value="<#if oamProject??>${oamProject.nrs!}<#else></#if>" />
		</div>
		<label id="nrsTip" class="control-label" style="color:red"></label>
	</div>
	<div class="form-group">
		<label id="implementationLabel" for="implementation" class="col-sm-1 control-label">实施人员</label>
		<div class="col-sm-5">
			<input type="text" class="form-control" id="implementation" name="implementation" value="<#if oamProject??>${oamProject.implementation!}<#else></#if>" />
		</div>
		<label id="implementationTip" class="control-label" style="color:red"></label>
	</div>
	<div class="form-group">
		<label id="trainOrFlightLabel" for="trainOrFlight" class="col-sm-1 control-label">车次或航班号</label>
		<div class="col-sm-5">
			<input type="text" class="form-control" id="trainOrFlight" name="trainOrFlight" value="<#if oamProject??>${oamProject.trainOrFlight!}<#else></#if>" />
		</div>
		<label id="trainOrFlightTip" class="control-label" style="color:red"></label>
	</div>
	<div class="form-group">
		<label id="grogshopLabel" for="grogshop" class="col-sm-1 control-label">酒店</label>
		<div class="col-sm-5">
			<input type="text" class="form-control" id="grogshop" name="grogshop" value="<#if oamProject??>${oamProject.grogshop!}<#else></#if>" />
		</div>
		<label id="grogshopTip" class="control-label" style="color:red"></label>
	</div>
	<input type="hidden" id="oamProjectId" name="oamProjectId" value="<#if oamProject??>${oamProject.oamProjectId!}</#if>" />
</form>
<#if !RequestParameters["isQuery"]?? || RequestParameters["isQuery"]=="">
<div class="card-page-command">
   <label class="col-sm-1 control-label"></label>
      <div class="col-sm-5" style="text-align:center;">
	<a  class="btn btn-success" onclick="saveOamProject();">
		<i class="glyphicon glyphicon-save"></i>
		<span>保存</span>
	</a>
	</div>
</div>
</#if>

</body>
</html>