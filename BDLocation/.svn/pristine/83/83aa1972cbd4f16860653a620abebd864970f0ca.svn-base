<!doctype html>
<html>
<head>
<#include "/head.ftl"/>
<script type="text/javascript" src="${rc.contextPath}/public/js/oamStationTesting/oamStationTesting.js"></script>
</head>
<body>

<form id="oamStationTestingForm" class="form-horizontal">
	<#if !RequestParameters["oamProjectTestingId"]?? || RequestParameters["oamProjectTestingId"]=="">
	<div class="form-group has-feedback">
		<label id="oamProjectTestingLabel" for="oamProjectTesting" class="col-sm-2 control-label">所属项目测试</label>
		<div class="col-sm-7">
			<input type="text" class="form-control" style="cursor:pointer" id="oamProjectTesting" name="oamProjectTesting" value="<#if oamStationTesting?? && oamStationTesting.oamProjectTesting??>${oamStationTesting.oamProjectTesting.oamProjectTestingName!}</#if>" onclick="selectOamProjectTesting();" />
			<span class="glyphicon glyphicon-menu-hamburger form-control-feedback"></span>
		</div>
		<label id="oamProjectTestingTip" class="control-label" style="color:red"></label>
	</div>
	</#if>
	<input type="hidden" id="oamProjectTestingId" name="oamProjectTesting.oamProjectTestingId" value="<#if oamStationTesting?? && oamStationTesting.oamProjectTesting??>${oamStationTesting.oamProjectTesting.oamProjectTestingId!}<#else>${RequestParameters["oamProjectTestingId"]!}</#if>" />
	<#if !RequestParameters["oamBaseStationId"]?? || RequestParameters["oamBaseStationId"]=="">
	<div class="form-group has-feedback">
		<label id="oamBaseStationLabel" for="oamBaseStation" class="col-sm-2 control-label">基站</label>
		<div class="col-sm-7">
			<input type="text" class="form-control" style="cursor:pointer" id="oamBaseStation" name="oamBaseStation" value="<#if oamStationTesting?? && oamStationTesting.oamBaseStation??>${oamStationTesting.oamBaseStation.oamBaseStationName!}</#if>" onclick="selectOamBaseStation();" />
			<span class="glyphicon glyphicon-menu-hamburger form-control-feedback"></span>
		</div>
		<label id="oamBaseStationTip" class="control-label" style="color:red"></label>
	</div>
	</#if>
	<input type="hidden" id="oamBaseStationId" name="oamBaseStation.oamBaseStationId" value="<#if oamStationTesting?? && oamStationTesting.oamBaseStation??>${oamStationTesting.oamBaseStation.oamBaseStationId!}<#else>${RequestParameters["oamBaseStationId"]!}</#if>" />
	<div class="form-group">
		<label id="entranceLabel" for="entrance" class="col-sm-2 control-label">进场</label>
		<div class="col-sm-7">
			<select class="form-control" id="entrance" name="entrance">
				<option></option>
				<option <#if oamStationTesting?? && oamStationTesting.entrance?? && "1"==oamStationTesting.entrance || !oamStationTesting?? && "1"=="1">selected</#if> value="1">是</option>
				<option <#if oamStationTesting?? && oamStationTesting.entrance?? && "0"==oamStationTesting.entrance || !oamStationTesting?? && "0"=="1">selected</#if> value="0">否</option>
			</select>
		</div>
		<label id="entranceTip" class="control-label" style="color:red"></label>
	</div>
	<div class="form-group">
		<label id="summitLabel" for="summit" class="col-sm-2 control-label">登顶</label>
		<div class="col-sm-7">
			<select class="form-control" id="summit" name="summit">
				<option></option>
				<option <#if oamStationTesting?? && oamStationTesting.summit?? && "1"==oamStationTesting.summit || !oamStationTesting?? && "1"=="1">selected</#if> value="1">是</option>
				<option <#if oamStationTesting?? && oamStationTesting.summit?? && "0"==oamStationTesting.summit || !oamStationTesting?? && "0"=="1">selected</#if> value="0">否</option>
			</select>
		</div>
		<label id="summitTip" class="control-label" style="color:red"></label>
	</div>
	<div class="form-group">
		<label id="wiringLabel" for="wiring" class="col-sm-2 control-label">布线</label>
		<div class="col-sm-7">
			<select class="form-control" id="wiring" name="wiring">
				<option></option>
				<option <#if oamStationTesting?? && oamStationTesting.wiring?? && "1"==oamStationTesting.wiring || !oamStationTesting?? && "1"=="1">selected</#if> value="1">是</option>
				<option <#if oamStationTesting?? && oamStationTesting.wiring?? && "0"==oamStationTesting.wiring || !oamStationTesting?? && "0"=="1">selected</#if> value="0">否</option>
			</select>
		</div>
		<label id="wiringTip" class="control-label" style="color:red"></label>
	</div>
	<div class="form-group">
		<label id="powerLabel" for="power" class="col-sm-2 control-label">电源</label>
		<div class="col-sm-7">
			<select class="form-control" id="power" name="power">
				<option></option>
				<option <#if oamStationTesting?? && oamStationTesting.power?? && "1"==oamStationTesting.power || !oamStationTesting?? && "1"=="1">selected</#if> value="1">是</option>
				<option <#if oamStationTesting?? && oamStationTesting.power?? && "0"==oamStationTesting.power || !oamStationTesting?? && "0"=="1">selected</#if> value="0">否</option>
			</select>
		</div>
		<label id="powerTip" class="control-label" style="color:red"></label>
	</div>
	<div class="form-group">
		<label id="netWorkLabel" for="netWork" class="col-sm-2 control-label">网络</label>
		<div class="col-sm-7">
			<select class="form-control" id="netWork" name="netWork">
				<option></option>
				<option <#if oamStationTesting?? && oamStationTesting.netWork?? && "1"==oamStationTesting.netWork || !oamStationTesting?? && "1"=="1">selected</#if> value="1">是</option>
				<option <#if oamStationTesting?? && oamStationTesting.netWork?? && "0"==oamStationTesting.netWork || !oamStationTesting?? && "0"=="1">selected</#if> value="0">否</option>
			</select>
		</div>
		<label id="netWorkTip" class="control-label" style="color:red"></label>
	</div>
	<div class="form-group">
		<label id="devSaveLabel" for="devSave" class="col-sm-2 control-label">设备保存</label>
		<div class="col-sm-7">
			<select class="form-control" id="devSave" name="devSave">
				<option></option>
				<option <#if oamStationTesting?? && oamStationTesting.devSave?? && "1"==oamStationTesting.devSave || !oamStationTesting?? && "1"=="1">selected</#if> value="1">是</option>
				<option <#if oamStationTesting?? && oamStationTesting.devSave?? && "0"==oamStationTesting.devSave || !oamStationTesting?? && "0"=="1">selected</#if> value="0">否</option>
			</select>
		</div>
		<label id="devSaveTip" class="control-label" style="color:red"></label>
	</div>
	<div class="form-group">
		<label id="otherGTLabel" for="otherGT" class="col-sm-2 control-label">其他沟通项目</label>
		<div class="col-sm-7">
			<input type="text" class="form-control" id="otherGT" name="otherGT" value="<#if oamStationTesting??>${oamStationTesting.otherGT!}<#else></#if>" />
		</div>
		<label id="otherGTTip" class="control-label" style="color:red"></label>
	</div>
	<div class="form-group">
		<label id="shelterEffectivityLabel" for="shelterEffectivity" class="col-sm-2 control-label">遮挡环境是否达标</label>
		<div class="col-sm-7">
			<select class="form-control" id="shelterEffectivity" name="shelterEffectivity">
				<option></option>
				<option <#if oamStationTesting?? && oamStationTesting.shelterEffectivity?? && "1"==oamStationTesting.shelterEffectivity || !oamStationTesting?? && "1"=="1">selected</#if> value="1">是</option>
				<option <#if oamStationTesting?? && oamStationTesting.shelterEffectivity?? && "0"==oamStationTesting.shelterEffectivity || !oamStationTesting?? && "0"=="1">selected</#if> value="0">否</option>
			</select>
		</div>
		<label id="shelterEffectivityTip" class="control-label" style="color:red"></label>
	</div>
	<div class="form-group">
		<label id="electromagneticEffectivityLabel" for="electromagneticEffectivity" class="col-sm-2 control-label">电磁环境是否达标</label>
		<div class="col-sm-7">
			<select class="form-control" id="electromagneticEffectivity" name="electromagneticEffectivity">
				<option></option>
				<option <#if oamStationTesting?? && oamStationTesting.electromagneticEffectivity?? && "1"==oamStationTesting.electromagneticEffectivity || !oamStationTesting?? && "1"=="1">selected</#if> value="1">是</option>
				<option <#if oamStationTesting?? && oamStationTesting.electromagneticEffectivity?? && "0"==oamStationTesting.electromagneticEffectivity || !oamStationTesting?? && "0"=="1">selected</#if> value="0">否</option>
			</select>
		</div>
		<label id="electromagneticEffectivityTip" class="control-label" style="color:red"></label>
	</div>
	<div class="form-group has-feedback">
		<label id="observationStartTimeLabel" for="observationStartTime" class="col-sm-2 control-label">连续观测开始时间</label>
		<div class="col-sm-7">
			<input type="text" class="form-control" id="observationStartTime" name="observationStartTime" value="<#if oamStationTesting??>${oamStationTesting.observationStartTime!}<#else>${.now?string("yyyy-MM-dd HH:mm:ss")}</#if>" onclick="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm:ss'});" />
			<span class="glyphicon glyphicon-menu-hamburger form-control-feedback"></span>
		</div>
		<label id="observationStartTimeTip" class="control-label" style="color:red"></label>
	</div>
	<div class="form-group">
		<label id="connectBJLabel" for="connectBJ" class="col-sm-2 control-label">连接北京服务器是否成功</label>
		<div class="col-sm-7">
			<select class="form-control" id="connectBJ" name="connectBJ">
				<option></option>
				<option <#if oamStationTesting?? && oamStationTesting.connectBJ?? && "1"==oamStationTesting.connectBJ || !oamStationTesting?? && "1"=="1">selected</#if> value="1">是</option>
				<option <#if oamStationTesting?? && oamStationTesting.connectBJ?? && "0"==oamStationTesting.connectBJ || !oamStationTesting?? && "0"=="1">selected</#if> value="0">否</option>
			</select>
		</div>
		<label id="connectBJTip" class="control-label" style="color:red"></label>
	</div>
	<div class="form-group">
		<label id="observationServicesLabel" for="observationServices" class="col-sm-2 control-label">主机安放位置是否考察</label>
		<div class="col-sm-7">
			<select class="form-control" id="observationServices" name="observationServices">
				<option></option>
				<option <#if oamStationTesting?? && oamStationTesting.observationServices?? && "1"==oamStationTesting.observationServices || !oamStationTesting?? && "1"=="1">selected</#if> value="1">是</option>
				<option <#if oamStationTesting?? && oamStationTesting.observationServices?? && "0"==oamStationTesting.observationServices || !oamStationTesting?? && "0"=="1">selected</#if> value="0">否</option>
			</select>
		</div>
		<label id="observationServicesTip" class="control-label" style="color:red"></label>
	</div>
	<div class="form-group has-feedback">
		<label id="observationEndTimeLabel" for="observationEndTime" class="col-sm-2 control-label">连续观测结束时间</label>
		<div class="col-sm-7">
			<input type="text" class="form-control" id="observationEndTime" name="observationEndTime" value="<#if oamStationTesting??>${oamStationTesting.observationEndTime!}<#else>${.now?string("yyyy-MM-dd HH:mm:ss")}</#if>" onclick="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm:ss'});" />
			<span class="glyphicon glyphicon-menu-hamburger form-control-feedback"></span>
		</div>
		<label id="observationEndTimeTip" class="control-label" style="color:red"></label>
	</div>
	<div class="form-group">
		<label id="observationSizeLabel" for="observationSize" class="col-sm-2 control-label">建站尺寸测量是否完成</label>
		<div class="col-sm-7">
			<select class="form-control" id="observationSize" name="observationSize">
				<option></option>
				<option <#if oamStationTesting?? && oamStationTesting.observationSize?? && "1"==oamStationTesting.observationSize || !oamStationTesting?? && "1"=="1">selected</#if> value="1">是</option>
				<option <#if oamStationTesting?? && oamStationTesting.observationSize?? && "0"==oamStationTesting.observationSize || !oamStationTesting?? && "0"=="1">selected</#if> value="0">否</option>
			</select>
		</div>
		<label id="observationSizeTip" class="control-label" style="color:red"></label>
	</div>
	<div class="form-group">
		<label id="devTrusteeLabel" for="devTrustee" class="col-sm-2 control-label">收取仪器托管人</label>
		<div class="col-sm-7">
			<input type="text" class="form-control" id="devTrustee" name="devTrustee" value="<#if oamStationTesting??>${oamStationTesting.devTrustee!}<#else></#if>" />
		</div>
		<label id="devTrusteeTip" class="control-label" style="color:red"></label>
	</div>
	<div class="form-group">
		<label id="contactsTrusteeLabel" for="contactsTrustee" class="col-sm-2 control-label">托管人联系方式</label>
		<div class="col-sm-7">
			<input type="text" class="form-control" id="contactsTrustee" name="contactsTrustee" value="<#if oamStationTesting??>${oamStationTesting.contactsTrustee!}<#else></#if>" />
		</div>
		<label id="contactsTrusteeTip" class="control-label" style="color:red"></label>
	</div>
	<div class="form-group">
		<label id="dataReportValidLabel" for="dataReportValid" class="col-sm-2 control-label">数据报告是否合格</label>
		<div class="col-sm-7">
			<select class="form-control" id="dataReportValid" name="dataReportValid">
				<option></option>
				<option <#if oamStationTesting?? && oamStationTesting.dataReportValid?? && "1"==oamStationTesting.dataReportValid || !oamStationTesting?? && "1"=="1">selected</#if> value="1">是</option>
				<option <#if oamStationTesting?? && oamStationTesting.dataReportValid?? && "0"==oamStationTesting.dataReportValid || !oamStationTesting?? && "0"=="1">selected</#if> value="0">否</option>
			</select>
		</div>
		<label id="dataReportValidTip" class="control-label" style="color:red"></label>
	</div>
	<div class="form-group">
		<label id="networkValidLabel" for="networkValid" class="col-sm-2 control-label">网络情况是否合格</label>
		<div class="col-sm-7">
			<select class="form-control" id="networkValid" name="networkValid">
				<option></option>
				<option <#if oamStationTesting?? && oamStationTesting.networkValid?? && "1"==oamStationTesting.networkValid || !oamStationTesting?? && "1"=="1">selected</#if> value="1">是</option>
				<option <#if oamStationTesting?? && oamStationTesting.networkValid?? && "0"==oamStationTesting.networkValid || !oamStationTesting?? && "0"=="1">selected</#if> value="0">否</option>
			</select>
		</div>
		<label id="networkValidTip" class="control-label" style="color:red"></label>
	</div>
	<div class="form-group">
		<label id="powerValidLabel" for="powerValid" class="col-sm-2 control-label">电力情况是否合格</label>
		<div class="col-sm-7">
			<select class="form-control" id="powerValid" name="powerValid">
				<option></option>
				<option <#if oamStationTesting?? && oamStationTesting.powerValid?? && "1"==oamStationTesting.powerValid || !oamStationTesting?? && "1"=="1">selected</#if> value="1">是</option>
				<option <#if oamStationTesting?? && oamStationTesting.powerValid?? && "0"==oamStationTesting.powerValid || !oamStationTesting?? && "0"=="1">selected</#if> value="0">否</option>
			</select>
		</div>
		<label id="powerValidTip" class="control-label" style="color:red"></label>
	</div>
	<input type="hidden" id="oamStationTestingId" name="oamStationTestingId" value="<#if oamStationTesting??>${oamStationTesting.oamStationTestingId!}</#if>" />
</form>
<#if !RequestParameters["isQuery"]?? || RequestParameters["isQuery"]=="">
<div class="card-page-command">
	<a  class="btn btn-success" onclick="saveOamStationTesting();">
		<i class="glyphicon glyphicon-save"></i>
		<span>保存</span>
	</a>
</div>
</#if>

</body>
</html>