<!doctype html>
<html>
<head>
<#include "/head.ftl"/>
<script type="text/javascript" src="${rc.contextPath}/public/js/oamStationAddress/oamStationAddress.js"></script>
</head>
<body>

<form id="oamStationAddressForm" class="form-horizontal">
	<#if !RequestParameters["oamProjectId"]?? || RequestParameters["oamProjectId"]=="">
	<div class="form-group has-feedback pt15">
		<label id="oamProjectLabel" for="oamProject" class="col-sm-1 control-label">所属项目</label>
		<div class="col-sm-5">
			<input type="text" class="form-control" style="cursor:pointer" id="oamProject" name="oamProject" value="<#if oamStationAddress?? && oamStationAddress.oamProject??>${oamStationAddress.oamProject.oamProjectName!}</#if>" onclick="selectOamProject();" />
			<span class="glyphicon glyphicon-menu-hamburger form-control-feedback"></span>
		</div>
		<label id="oamProjectTip" class="control-label" style="color:red"></label>
	</div>
	</#if>
	<input type="hidden" id="oamProjectId" name="oamProject.oamProjectId" value="<#if oamStationAddress?? && oamStationAddress.oamProject??>${oamStationAddress.oamProject.oamProjectId!}<#else>${RequestParameters["oamProjectId"]!}</#if>" />
	<#if !RequestParameters["oamBaseStationId"]?? || RequestParameters["oamBaseStationId"]=="">
	<div class="form-group has-feedback">
		<label id="oamBaseStationLabel" for="oamBaseStation" class="col-sm-1 control-label">基站</label>
		<div class="col-sm-5">
			<input type="text" class="form-control" style="cursor:pointer" id="oamBaseStation" name="oamBaseStation" value="<#if oamStationAddress?? && oamStationAddress.oamBaseStation??>${oamStationAddress.oamBaseStation.oamBaseStationName!}</#if>" onclick="selectOamBaseStation();" />
			<span class="glyphicon glyphicon-menu-hamburger form-control-feedback"></span>
		</div>
		<label id="oamBaseStationTip" class="control-label" style="color:red"></label>
	</div>
	</#if>
	<input type="hidden" id="oamBaseStationId" name="oamBaseStation.oamBaseStationId" value="<#if oamStationAddress?? && oamStationAddress.oamBaseStation??>${oamStationAddress.oamBaseStation.oamBaseStationId!}<#else>${RequestParameters["oamBaseStationId"]!}</#if>" />
	<div class="form-group">
		<label id="addressLabel" for="address" class="col-sm-1 control-label">地址</label>
		<div class="col-sm-5">
			<input type="text" class="form-control" id="address" name="address" value="<#if oamStationAddress??>${oamStationAddress.address!}<#else></#if>" />
		</div>
		<label id="addressTip" class="control-label" style="color:red"></label>
	</div>
	<div class="form-group">
		<label id="contactsLabel" for="contacts" class="col-sm-1 control-label">联系人</label>
		<div class="col-sm-5">
			<input type="text" class="form-control" id="contacts" name="contacts" value="<#if oamStationAddress??>${oamStationAddress.contacts!}<#else></#if>" />
		</div>
		<label id="contactsTip" class="control-label" style="color:red"></label>
	</div>
	<div class="form-group">
		<label id="contactLabel" for="contact" class="col-sm-1 control-label">联系方式</label>
		<div class="col-sm-5">
			<input type="text" class="form-control" id="contact" name="contact" value="<#if oamStationAddress??>${oamStationAddress.contact!}<#else></#if>" />
		</div>
		<label id="contactTip" class="control-label" style="color:red"></label>
	</div>
	<div class="form-group">
		<label id="shelterInfoLabel" for="shelterInfo" class="col-sm-1 control-label">遮挡物及程度</label>
		<div class="col-sm-5">
			<input type="text" class="form-control" id="shelterInfo" name="shelterInfo" value="<#if oamStationAddress??>${oamStationAddress.shelterInfo!}<#else></#if>" />
		</div>
		<label id="shelterInfoTip" class="control-label" style="color:red"></label>
	</div>
	<div class="form-group">
		<label id="interferenceInfoLabel" for="interferenceInfo" class="col-sm-1 control-label">干扰源及程度</label>
		<div class="col-sm-5">
			<input type="text" class="form-control" id="interferenceInfo" name="interferenceInfo" value="<#if oamStationAddress??>${oamStationAddress.interferenceInfo!}<#else></#if>" />
		</div>
		<label id="interferenceInfoTip" class="control-label" style="color:red"></label>
	</div>
	<div class="form-group">
		<label id="electrification220Label" for="electrification220" class="col-sm-1 control-label">不间断供电220V</label>
		<div class="col-sm-5">
			<select class="form-control" id="electrification220" name="electrification220">
				<option></option>
				<option <#if oamStationAddress?? && oamStationAddress.electrification220?? && "1"==oamStationAddress.electrification220 || !oamStationAddress?? && "1"=="1">selected</#if> value="1">是</option>
				<option <#if oamStationAddress?? && oamStationAddress.electrification220?? && "0"==oamStationAddress.electrification220 || !oamStationAddress?? && "0"=="1">selected</#if> value="0">否</option>
			</select>
		</div>
		<label id="electrification220Tip" class="control-label" style="color:red"></label>
	</div>
	<div class="form-group">
		<label id="electrificationLabel" for="electrification" class="col-sm-1 control-label">不间断网络</label>
		<div class="col-sm-5">
			<select class="form-control" id="electrification" name="electrification">
				<option></option>
				<option <#if oamStationAddress?? && oamStationAddress.electrification?? && "1"==oamStationAddress.electrification || !oamStationAddress?? && "1"=="1">selected</#if> value="1">是</option>
				<option <#if oamStationAddress?? && oamStationAddress.electrification?? && "0"==oamStationAddress.electrification || !oamStationAddress?? && "0"=="1">selected</#if> value="0">否</option>
			</select>
		</div>
		<label id="electrificationTip" class="control-label" style="color:red"></label>
	</div>
	<div class="form-group">
		<label id="wANLabel" for="wAN" class="col-sm-1 control-label">外网</label>
		<div class="col-sm-5">
			<select class="form-control" id="wAN" name="wAN">
				<option></option>
				<option <#if oamStationAddress?? && oamStationAddress.wAN?? && "1"==oamStationAddress.wAN || !oamStationAddress?? && "1"=="1">selected</#if> value="1">是</option>
				<option <#if oamStationAddress?? && oamStationAddress.wAN?? && "0"==oamStationAddress.wAN || !oamStationAddress?? && "0"=="1">selected</#if> value="0">否</option>
			</select>
		</div>
		<label id="wANTip" class="control-label" style="color:red"></label>
	</div>
	<div class="form-group">
		<label id="out2MLabel" for="out2M" class="col-sm-1 control-label">独占带宽大于2M</label>
		<div class="col-sm-5">
			<select class="form-control" id="out2M" name="out2M">
				<option></option>
				<option <#if oamStationAddress?? && oamStationAddress.out2M?? && "1"==oamStationAddress.out2M || !oamStationAddress?? && "1"=="1">selected</#if> value="1">是</option>
				<option <#if oamStationAddress?? && oamStationAddress.out2M?? && "0"==oamStationAddress.out2M || !oamStationAddress?? && "0"=="1">selected</#if> value="0">否</option>
			</select>
		</div>
		<label id="out2MTip" class="control-label" style="color:red"></label>
	</div>
	<div class="form-group">
		<label id="ipInfoLabel" for="ipInfo" class="col-sm-1 control-label">固定IP情况及说明</label>
		<div class="col-sm-5">
			<input type="text" class="form-control" id="ipInfo" name="ipInfo" value="<#if oamStationAddress??>${oamStationAddress.ipInfo!}<#else></#if>" />
		</div>
		<label id="ipInfoTip" class="control-label" style="color:red"></label>
	</div>
	<div class="form-group">
		<label id="aDSLLabel" for="aDSL" class="col-sm-1 control-label">ADSL</label>
		<div class="col-sm-5">
			<select class="form-control" id="aDSL" name="aDSL">
				<option></option>
				<option <#if oamStationAddress?? && oamStationAddress.aDSL?? && "1"==oamStationAddress.aDSL || !oamStationAddress?? && "1"=="1">selected</#if> value="1">是</option>
				<option <#if oamStationAddress?? && oamStationAddress.aDSL?? && "0"==oamStationAddress.aDSL || !oamStationAddress?? && "0"=="1">selected</#if> value="0">否</option>
			</select>
		</div>
		<label id="aDSLTip" class="control-label" style="color:red"></label>
	</div>
	<div class="form-group">
		<label id="opticalFiberLabel" for="opticalFiber" class="col-sm-1 control-label">光纤</label>
		<div class="col-sm-5">
			<select class="form-control" id="opticalFiber" name="opticalFiber">
				<option></option>
				<option <#if oamStationAddress?? && oamStationAddress.opticalFiber?? && "1"==oamStationAddress.opticalFiber || !oamStationAddress?? && "1"=="1">selected</#if> value="1">是</option>
				<option <#if oamStationAddress?? && oamStationAddress.opticalFiber?? && "0"==oamStationAddress.opticalFiber || !oamStationAddress?? && "0"=="1">selected</#if> value="0">否</option>
			</select>
		</div>
		<label id="opticalFiberTip" class="control-label" style="color:red"></label>
	</div>
	<div class="form-group">
		<label id="interchangerLabel" for="interchanger" class="col-sm-1 control-label">交换机</label>
		<div class="col-sm-5">
			<select class="form-control" id="interchanger" name="interchanger">
				<option></option>
				<option <#if oamStationAddress?? && oamStationAddress.interchanger?? && "1"==oamStationAddress.interchanger || !oamStationAddress?? && "1"=="1">selected</#if> value="1">是</option>
				<option <#if oamStationAddress?? && oamStationAddress.interchanger?? && "0"==oamStationAddress.interchanger || !oamStationAddress?? && "0"=="1">selected</#if> value="0">否</option>
			</select>
		</div>
		<label id="interchangerTip" class="control-label" style="color:red"></label>
	</div>
	<div class="form-group">
		<label id="routerLabel" for="router" class="col-sm-1 control-label">路由器</label>
		<div class="col-sm-5">
			<select class="form-control" id="router" name="router">
				<option></option>
				<option <#if oamStationAddress?? && oamStationAddress.router?? && "1"==oamStationAddress.router || !oamStationAddress?? && "1"=="1">selected</#if> value="1">是</option>
				<option <#if oamStationAddress?? && oamStationAddress.router?? && "0"==oamStationAddress.router || !oamStationAddress?? && "0"=="1">selected</#if> value="0">否</option>
			</select>
		</div>
		<label id="routerTip" class="control-label" style="color:red"></label>
	</div>
	<div class="form-group">
		<label id="otherNetworkLabel" for="otherNetwork" class="col-sm-1 control-label">其它网络类别</label>
		<div class="col-sm-5">
			<input type="text" class="form-control" id="otherNetwork" name="otherNetwork" value="<#if oamStationAddress??>${oamStationAddress.otherNetwork!}<#else></#if>" />
		</div>
		<label id="otherNetworkTip" class="control-label" style="color:red"></label>
	</div>
	<div class="form-group">
		<label id="lightningShieldingLabel" for="lightningShielding" class="col-sm-1 control-label">公共避雷</label>
		<div class="col-sm-5">
			<select class="form-control" id="lightningShielding" name="lightningShielding">
				<option></option>
				<option <#if oamStationAddress?? && oamStationAddress.lightningShielding?? && "1"==oamStationAddress.lightningShielding || !oamStationAddress?? && "1"=="1">selected</#if> value="1">是</option>
				<option <#if oamStationAddress?? && oamStationAddress.lightningShielding?? && "0"==oamStationAddress.lightningShielding || !oamStationAddress?? && "0"=="1">selected</#if> value="0">否</option>
			</select>
		</div>
		<label id="lightningShieldingTip" class="control-label" style="color:red"></label>
	</div>
	<div class="form-group">
		<label id="lightningArresterLabel" for="lightningArrester" class="col-sm-1 control-label">避雷针</label>
		<div class="col-sm-5">
			<select class="form-control" id="lightningArrester" name="lightningArrester">
				<option></option>
				<option <#if oamStationAddress?? && oamStationAddress.lightningArrester?? && "1"==oamStationAddress.lightningArrester || !oamStationAddress?? && "1"=="1">selected</#if> value="1">是</option>
				<option <#if oamStationAddress?? && oamStationAddress.lightningArrester?? && "0"==oamStationAddress.lightningArrester || !oamStationAddress?? && "0"=="1">selected</#if> value="0">否</option>
			</select>
		</div>
		<label id="lightningArresterTip" class="control-label" style="color:red"></label>
	</div>
	<div class="form-group">
		<label id="lightningNetWorkLabel" for="lightningNetWork" class="col-sm-1 control-label">避雷网</label>
		<div class="col-sm-5">
			<select class="form-control" id="lightningNetWork" name="lightningNetWork">
				<option></option>
				<option <#if oamStationAddress?? && oamStationAddress.lightningNetWork?? && "1"==oamStationAddress.lightningNetWork || !oamStationAddress?? && "1"=="1">selected</#if> value="1">是</option>
				<option <#if oamStationAddress?? && oamStationAddress.lightningNetWork?? && "0"==oamStationAddress.lightningNetWork || !oamStationAddress?? && "0"=="1">selected</#if> value="0">否</option>
			</select>
		</div>
		<label id="lightningNetWorkTip" class="control-label" style="color:red"></label>
	</div>
	<div class="form-group">
		<label id="otherArresterLabel" for="otherArrester" class="col-sm-1 control-label">其它避雷设施</label>
		<div class="col-sm-5">
			<input type="text" class="form-control" id="otherArrester" name="otherArrester" value="<#if oamStationAddress??>${oamStationAddress.otherArrester!}<#else></#if>" />
		</div>
		<label id="otherArresterTip" class="control-label" style="color:red"></label>
	</div>
	<div class="form-group">
		<label id="smoothRoofLabel" for="smoothRoof" class="col-sm-1 control-label">平整天台</label>
		<div class="col-sm-5">
			<select class="form-control" id="smoothRoof" name="smoothRoof">
				<option></option>
				<option <#if oamStationAddress?? && oamStationAddress.smoothRoof?? && "1"==oamStationAddress.smoothRoof || !oamStationAddress?? && "1"=="1">selected</#if> value="1">是</option>
				<option <#if oamStationAddress?? && oamStationAddress.smoothRoof?? && "0"==oamStationAddress.smoothRoof || !oamStationAddress?? && "0"=="1">selected</#if> value="0">否</option>
			</select>
		</div>
		<label id="smoothRoofTip" class="control-label" style="color:red"></label>
	</div>
	<div class="form-group">
		<label id="nickelcladRoofLabel" for="nickelcladRoof" class="col-sm-1 control-label">斜面钢板屋顶</label>
		<div class="col-sm-5">
			<select class="form-control" id="nickelcladRoof" name="nickelcladRoof">
				<option></option>
				<option <#if oamStationAddress?? && oamStationAddress.nickelcladRoof?? && "1"==oamStationAddress.nickelcladRoof || !oamStationAddress?? && "1"=="1">selected</#if> value="1">是</option>
				<option <#if oamStationAddress?? && oamStationAddress.nickelcladRoof?? && "0"==oamStationAddress.nickelcladRoof || !oamStationAddress?? && "0"=="1">selected</#if> value="0">否</option>
			</select>
		</div>
		<label id="nickelcladRoofTip" class="control-label" style="color:red"></label>
	</div>
	<div class="form-group">
		<label id="otherRoofLabel" for="otherRoof" class="col-sm-1 control-label">其它天台情况</label>
		<div class="col-sm-5">
			<input type="text" class="form-control" id="otherRoof" name="otherRoof" value="<#if oamStationAddress??>${oamStationAddress.otherRoof!}<#else></#if>" />
		</div>
		<label id="otherRoofTip" class="control-label" style="color:red"></label>
	</div>
	<div class="form-group">
		<label id="usedWaterprooferLabel" for="usedWaterproofer" class="col-sm-1 control-label">是否有防水层</label>
		<div class="col-sm-5">
			<select class="form-control" id="usedWaterproofer" name="usedWaterproofer">
				<option></option>
				<option <#if oamStationAddress?? && oamStationAddress.usedWaterproofer?? && "1"==oamStationAddress.usedWaterproofer || !oamStationAddress?? && "1"=="1">selected</#if> value="1">是</option>
				<option <#if oamStationAddress?? && oamStationAddress.usedWaterproofer?? && "0"==oamStationAddress.usedWaterproofer || !oamStationAddress?? && "0"=="1">selected</#if> value="0">否</option>
			</select>
		</div>
		<label id="usedWaterprooferTip" class="control-label" style="color:red"></label>
	</div>
	<div class="form-group">
		<label id="waterprooferInfoLabel" for="waterprooferInfo" class="col-sm-1 control-label">防水层描述</label>
		<div class="col-sm-5">
			<input type="text" class="form-control" id="waterprooferInfo" name="waterprooferInfo" value="<#if oamStationAddress??>${oamStationAddress.waterprooferInfo!}<#else></#if>" />
		</div>
		<label id="waterprooferInfoTip" class="control-label" style="color:red"></label>
	</div>
	<div class="form-group">
		<label id="usedPapersLabel" for="usedPapers" class="col-sm-1 control-label">是否需要特殊证件</label>
		<div class="col-sm-5">
			<select class="form-control" id="usedPapers" name="usedPapers">
				<option></option>
				<option <#if oamStationAddress?? && oamStationAddress.usedPapers?? && "1"==oamStationAddress.usedPapers || !oamStationAddress?? && "1"=="1">selected</#if> value="1">是</option>
				<option <#if oamStationAddress?? && oamStationAddress.usedPapers?? && "0"==oamStationAddress.usedPapers || !oamStationAddress?? && "0"=="1">selected</#if> value="0">否</option>
			</select>
		</div>
		<label id="usedPapersTip" class="control-label" style="color:red"></label>
	</div>
	<div class="form-group">
		<label id="papersInfoLabel" for="papersInfo" class="col-sm-1 control-label">特殊证件描述</label>
		<div class="col-sm-5">
			<select class="form-control" id="papersInfo" name="papersInfo">
				<option></option>
				<option <#if oamStationAddress?? && oamStationAddress.papersInfo?? && "1"==oamStationAddress.papersInfo || !oamStationAddress?? && "1"=="1">selected</#if> value="1">是</option>
				<option <#if oamStationAddress?? && oamStationAddress.papersInfo?? && "0"==oamStationAddress.papersInfo || !oamStationAddress?? && "0"=="1">selected</#if> value="0">否</option>
			</select>
		</div>
		<label id="papersInfoTip" class="control-label" style="color:red"></label>
	</div>
	<div class="form-group">
		<label id="remarkLabel" for="remark" class="col-sm-1 control-label">备注</label>
		<div class="col-sm-5">
			<input type="text" class="form-control" id="remark" name="remark" value="<#if oamStationAddress??>${oamStationAddress.remark!}<#else></#if>" />
		</div>
		<label id="remarkTip" class="control-label" style="color:red"></label>
	</div>
	<input type="hidden" id="oamStationAddressId" name="oamStationAddressId" value="<#if oamStationAddress??>${oamStationAddress.oamStationAddressId!}</#if>" />
</form>
<#if !RequestParameters["isQuery"]?? || RequestParameters["isQuery"]=="">
<div class="card-page-command">
<label class="col-sm-1 control-label"></label>
      <div class="col-sm-5" style="text-align:center;">
	<a  class="btn btn-success" onclick="saveOamStationAddress();">
		<i class="glyphicon glyphicon-save"></i>
		<span>保存</span>
	</a>
	</div>
</div>
</#if>

</body>
</html>