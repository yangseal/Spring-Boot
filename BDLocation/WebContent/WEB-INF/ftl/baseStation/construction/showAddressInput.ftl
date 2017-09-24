<script type="text/javascript" src="${rc.contextPath}/public/js/baseStation/construction/buidlMaterialInfo.js"></script>
	<input type="hidden" id="baseAddressId" name="baseAddressId" value="<#if baseAddress??>${baseAddress.baseAddressId!}</#if>" />
	<#--基本信息-->
	<div class="form-group has-feedback">
		<label id="oamProjectLabel" for="oamProject" class="col-sm-2 control-label ct_tit"><span>基本信息</span></label>
		<div class="col-sm-8">
			<input type="hidden" class="form-control"/>
		</div>
	</div>
	
	<div class="form-group has-feedback">
		<label id="finalAddressLabel" for="finalAddress" class="col-sm-2 control-label">最终选址地址</label>
		<div class="col-sm-4">
			<input type="text" class="form-control" style="width:65%; float:left;" id="finalAddress" name="finalAddress" value="<#if baseAddress?? && baseAddress.finalAddress??>${baseAddress.finalAddress!}</#if>" isNotNull/>
			<span id="finalAddressTip" class="ct_tips">*</span>
		</div>
	</div>
	
	<div class="form-group">
		<label id="senceChargerLabel" for="senceCharger" class="col-sm-2 control-label">现场选址负责人</label>
		<div class="col-sm-4">
			<input type="text" class="form-control" style="width:65%; float:left;" id="senceCharger" name="senceCharger" value="<#if baseAddress??>${baseAddress.senceCharger!}</#if>" isNotNull />
		    <span id="senceChargerTip" class="ct_tips">*</span>
		</div>
		
		<label id="senceChargerPhoneLabel" for="senceChargerPhone" class="col-sm-1 control-label">现场负责人电话</label>
		<div class="col-sm-4">
			<input type="text" class="form-control" style="width:65%; float:left;" id="senceChargerPhone" name="senceChargerPhone"  value="<#if baseAddress??>${baseAddress.senceChargerPhone!}</#if>" isNotNull />  <#--validateExp="(^(1\d{10})$|^((\d{7,8})|(\d{4}|\d{3})-(\d{7,8})|(\d{4}|\d{3})-(\d{7,8})-(\d{4}|\d{3}|\d{2}|\d{1})|(\d{7,8})-(\d{4}|\d{3}|\d{2}|\d{1}))$)"-->
		    <span id="senceChargerPhoneTip" class="ct_tips">*</span>
		</div>
		
	</div> 
	
	<div class="form-group">
		<label id="addrStartTimeLabel" for="addrStartTime" class="col-sm-2 control-label">选址开始时间</label>
		<div class="col-sm-4 tips_icon">
			<input type="text" class="form-control" style="width:65%; float:left;" readOnly id="addrStartTime" name="addrStartTime" isNotNull value="<#if baseAddress??>${baseAddress.addrStartTime!}<#else>${.now?string("yyyy-MM-dd HH:mm:ss")}</#if>" onclick="addrInitSelectTime();" />
			<span class="glyphicon glyphicon-menu-hamburger form-control-feedback"></span>
			<span id="addrStartTimeTip" class="ct_tips">*</span>
		</div>
		
		<label id="addrEndTimeLabel" for="addrEndTime" class="col-sm-1 control-label">选址结束时间</label>
		<div class="col-sm-4 tips_icon">
			<input type="text" class="form-control" style="width:65%; float:left;" readOnly id="addrEndTime" name="addrEndTime" isNotNull value="<#if baseAddress??>${baseAddress.addrEndTime!}</#if>" onclick="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm:ss',minDate:'#F{$dp.$D(\'addrStartTime\')}'})" />
			<span class="glyphicon glyphicon-menu-hamburger form-control-feedback"></span>
			<span id="addrEndTimeTip" class="ct_tips">*</span>
		</div>
	</div>
	<hr style="width:auto;height:1px;border:none;border-top:1px dashed grey;" />
	
	<#--环境信息-->
	<div class="form-group has-feedback">
		<label id="oamProjectLabel" for="oamProject" class="col-sm-2 control-label ct_tit"><span>环境信息</span></label>
		<div class="col-sm-8">
			<input type="hidden" class="form-control"/>
		</div>
	</div>
	
	<div class="form-group has-feedback">
		<label id="shelterOverviewLabel" for="shelterOverview" class="col-sm-2 control-label">遮挡概况</label>
		<div class="col-sm-4">
			<input type="text" class="form-control" style="width:65%; float:left;" id="shelterOverview"  name="shelterOverview"  value="<#if baseAddress??>${baseAddress.shelterOverview!}</#if>"  />
			<span id="shelterOverviewTip" class="ct_tips"></span>
		</div>
		
		<label id="trafficOverviewLabel" for="trafficOverview" class="col-sm-1 control-label">交通概况</label>
		<div class="col-sm-4">
			<input type="text" class="form-control" style="width:65%; float:left;" id="trafficOverview"  name="trafficOverview"  value="<#if baseAddress??>${baseAddress.trafficOverview!}</#if>"  />
			<span id="trafficOverviewTip" class="ct_tips"></span>
		</div>
	</div>
	
	<div class="form-group has-feedback">
		<label id="interOverviewLabel" for="interOverview" class="col-sm-2 control-label">干扰概况</label>
		<div class="col-sm-4">
			<input type="text" class="form-control" style="width:65%; float:left;" id="interOverview" name="interOverview" value="<#if baseAddress??>${baseAddress.interOverview!}</#if>"  />
			<span id="interOverviewTip" class="ct_tips"></span>
		</div>
		
		<label id="lightningOverviewLabel" for="lightningOverview" class="col-sm-1 control-label">避雷概况</label>
		<div class="col-sm-4">
			<input type="text" class="form-control" style="width:65%; float:left;" id="lightningOverview" name="lightningOverview" value="<#if baseAddress??>${baseAddress.lightningOverview!}</#if>"  />
			<span id="lightningOverviewTip" class="ct_tips"></span>
		</div>
	</div>
	
	<div class="form-group has-feedback">
		<label id="waterOverviewLabel" for="waterOverview" class="col-sm-2 control-label">防水概况</label>
		<div class="col-sm-4">
			<input type="text" class="form-control" style="width:65%; float:left;" id="waterOverview" name="waterOverview"  value="<#if baseAddress??>${baseAddress.waterOverview!}</#if>"  />
			<span id="waterOverviewTip" class="ct_tips"></span>
		</div>
		
		<label id="roofOverviewLabel" for="roofOverview" class="col-sm-1 control-label">屋顶概况</label>
		<div class="col-sm-4">
			<input type="text" class="form-control" style="width:65%; float:left;" id="roofOverview" name="roofOverview" value="<#if baseAddress??>${baseAddress.roofOverview!}</#if>"  />
			<span id="roofOverviewTip" class="ct_tips"></span>
		</div>
	</div>
	<div class="form-group has-feedback">
		<label id="envRemarkLabel" for="oamProject" class="col-sm-2 control-label">环境备注</label>
		<div class="col-sm-4">
			<textarea class="form-control" rows="3" name="envRemark" id="envRemark" "><#if baseAddress?? && baseAddress.envRemark??>${baseAddress.envRemark!}</#if></textarea>
		</div>
	</div>
	<hr style="width:auto;height:1px;border:none;border-top:1px dashed grey;" />
	
	<#--网络信息-->
	<div class="form-group has-feedback">
		<label id="oamProjectLabel" for="oamProject" class="col-sm-2 control-label ct_tit"><span>网络信息</span></label>
		<div class="col-sm-8">
			<input type="hidden" class="form-control"/>
		</div>
	</div>
	
	<div class="form-group">
		<label id="oamProjectLabel" for="oamProject" class="col-sm-2 control-label">网络条件</label>
		<div class="col-sm-4">
			<label class="ct_la">
			  <input type="checkbox" value="1"  > <span>不间断网络</span>
			</label>
			<label class="ct_la">
			  <input type="checkbox"  value="2" > <span>外网</span>
			</label>
			<label class="ct_la">
			  <input type="checkbox"  value="3" > <span>独占带宽>2M</span>
			</label>
			<label class="ct_la">
			  <input type="checkbox"  value="4" > <span>固定IP</span>
			</label>
		</div>
		<label id="netConditionLabel" for="netCondition" class="col-sm-1 control-label">其他补充</label>
			<div class="col-sm-3" name="addData">
				<input type="text" class="form-control" id="netCondition" value="<#if baseAddress??>${baseAddress.netCondition!}</#if>" />
			</div>
			<input type="hidden" class="form-control" style="cursor:pointer"  name="netCondition"  value="" />
	</div>
	
	<div class="form-group">
		<label id="oamProjectLabel" for="oamProject" class="col-sm-2 control-label">网络类别</label>
		<div class="col-sm-4">
			<label class="ct_la">
			  <input type="checkbox"  value="1" > <span>光纤</span>
			</label>
			<label class="ct_la">
			  <input type="checkbox"  value="2" > <span>ADSL</span>
			</label>
		</div>
		<label id="netTypeLabel" for="netType" class="col-sm-1 control-label">其他补充</label>
			<div class="col-sm-3" name="addData">
				<input type="text" class="form-control" id="netType"  value="<#if baseAddress?? && baseAddress.netType??>${baseAddress.netType!}</#if>" />
			</div>
			<input type="hidden" class="form-control" style="cursor:pointer"  name="netType"  value="" />
			
	</div>
	
	<div class="form-group">
		<label id="oamProjectLabel" for="oamProject" class="col-sm-2 control-label">网络配置</label>
		<div class="col-sm-4">
			<label class="ct_la">
			  <input type="checkbox"   value="1" > <span>交换机</span>
			</label>
			<label class="ct_la">
			  <input type="checkbox"  value="2" > <span>路由器</span>
			</label>
		</div>
		<label id="netConfigLabel" for="netConfig" class="col-sm-1 control-label">其他补充</label>
			<div class="col-sm-3" name="addData">
				<input type="text" class="form-control" id="netConfig"   value="<#if baseAddress?? && baseAddress.netConfig??>${baseAddress.netConfig!}</#if>" />
			</div>
				<input type="hidden" class="form-control" style="cursor:pointer"  name="netConfig"  value="" />
	</div>
	
	<div class="form-group has-feedback">
		<label id="netRemarkLabel" for="netRemark" class="col-sm-2 control-label">网络备注</label>
		<div class="col-sm-6">
			<textarea class="form-control" rows="3" name="netRemark" id="netRemark"><#if baseAddress?? && baseAddress.netRemark??>${baseAddress.netRemark!}</#if></textarea>
		</div>
	</div>
	<hr style="width:auto;height:1px;border:none;border-top:1px dashed grey;" />
	
	<#--电力信息-->
	<div class="form-group has-feedback">
		<label id="oamProjectLabel" for="oamProject" class="col-sm-2 control-label ct_tit"><span>电力信息</span></label>
		<div class="col-sm-4">
			<input type="hidden" class="form-control"/>
		</div>
	</div>
	
	<div class="form-group">
		<label id="oamProjectLabel" for="oamProject" class="col-sm-2 control-label">电力条件</label>
		<div class="col-sm-4">
			<label class="ct_la">
			  <input type="checkbox"  value="1" > <span>不间断供电</span>
			</label>
			<label class="ct_la">
			  <input type="checkbox"  value="2" > <span>220V市电</span>
			</label>
			<label class="ct_la">
			  <input type="checkbox"  value="3" > <span>备电</span>
			</label>
		</div>
		<label id="powerConditionLabel" for="powerCondition" class="col-sm-1 control-label">其他补充</label>
			<div class="col-sm-3" name="addData">
				<input type="text" class="form-control" id="powerCondition"   value="<#if baseAddress?? && baseAddress.powerCondition??>${baseAddress.powerCondition!}</#if>"/>
			</div>
			<input type="hidden" class="form-control" style="cursor:pointer" name="powerCondition"  value="" />
	</div>
	<div class="form-group has-feedback">
		<label id="oamProjectLabel" for="oamProject" class="col-sm-2 control-label">电力备注</label>
		<div class="col-sm-6">
			<textarea class="form-control" rows="3" name="powerRemark" id="powerRemark"><#if baseAddress?? && baseAddress.powerRemark??>${baseAddress.powerRemark!}</#if></textarea>
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
		<label id="addressPhoLabel" for="addressPho" class="col-sm-2 control-label">选址照片</label>
		<div class="col-sm-8">
      		<div id="addressPho" class="fj_box" name="addressPho">
      		</div>
      	</div>
      	<label id="addressPhoTip" class="control-label" style="color:red"></label>
	</div>
	
	<div class="form-group">
		<label id="testReportLabel" for="testReport" class="col-sm-2 control-label">测试报告</label>
		<div class="col-sm-8">
      		<div id="testReport" name="testReport" class="fj_box">
      		</div>
      	</div>
      	<label id="testReportTip" class="control-label" style="color:red"></label>
	</div>
	
	<div class="form-group">
		<label id="otherDataLabel" for="otherData" class="col-sm-2 control-label">其他资料</label>
		<div class="col-sm-8">
      		<div id="otherData" name="otherData" class="fj_box">
      		</div>
      	</div>
      	<label id="otherDataTip" class="control-label" style="color:red"></label>
	</div>
	
	<div class="form-group has-feedback">
		<label id="oamProjectLabel" for="oamProject" class="col-sm-2 control-label">备注</label>
		<div class="col-sm-6">
			<textarea class="form-control" rows="3" id="addressRemark" name="addressRemark"><#if baseAddress?? && baseAddress.addressRemark??>${baseAddress.addressRemark!}</#if></textarea>
		</div>
	</div>
<#if !RequestParameters["isQuery"]?? || RequestParameters["isQuery"]!="true">
<div class="form-group">
    <label class="col-sm-2 control-label"></label>
    <div class="col-sm-8" style="text-align:center;">
	<a  class="btn btn-success" onclick="saveBaseAddress();">
		<i class="glyphicon glyphicon-save"></i>
		<span>保存</span>
	</a>
	</div>
</div>
</#if>