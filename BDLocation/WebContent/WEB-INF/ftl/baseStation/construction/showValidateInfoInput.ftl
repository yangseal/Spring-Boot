<script type="text/javascript" src="${rc.contextPath}/public/js/baseStation/construction/buidlMaterialInfo.js"></script>
	<#--基本信息-->
	<div class="form-group has-feedback">
		<label id="oamProjectLabel" for="oamProject" class="col-sm-2 control-label ct_tit"><span>基本信息</span></label>
		<div class="col-sm-8">
			<input type="hidden" class="form-control"/>
		</div>
	</div>
	
	<div class="form-group">
		<label id="baseLngLabel" for="baseLng" class="col-sm-2 control-label">基站经度</label>
		<div class="col-sm-4">
			<input type="text" class="form-control" style="width:65%; float:left;" id="baseLng" name="baseLng" value="<#if baseCheckMatetial??>${baseCheckMatetial.baseLng!}</#if>" isNotNull />
			<span id="baseLngTip" class="ct_tips">*</span>
		</div>
		
		<label id="baseLatLabel" for="baseLat" class="col-sm-1  control-label">基站纬度</label>
		<div class="col-sm-4">
			<input type="text" class="form-control"  style="width:65%; float:left;"  id="baseLat" name="baseLat" value="<#if baseCheckMatetial??>${baseCheckMatetial.baseLat!}</#if>" isNotNull />
			<span id="baseLatTip" class="ct_tips">*</span>
		</div>
	</div> 
	
	<div class="form-group">
		<label id="baseElevationLabel" for="baseElevation" class="col-sm-2 control-label">基站高程</label>
		<div class="col-sm-4">
			<input type="text" class="form-control" style="width:65%; float:left;" id="baseElevation" name="baseElevation" value="<#if baseCheckMatetial??>${baseCheckMatetial.baseElevation!}</#if>" isNotNull />
			<span id="baseElevationTip" class="ct_tips">*</span>
		</div>
		
		<label id="stationTypeLabel" for="stationType" class="col-sm-1 control-label">站点类型</label>
		<div class="col-sm-4">
			<input type="text" class="form-control" style="width:65%; float:left;" id="stationType" name="stationType" value="<#if baseCheckMatetial??>${baseCheckMatetial.stationType!}</#if>" isNotNull />
			<span id="stationTypeTip" class="ct_tips">*</span>
		</div>
	</div>
	
	<div class="form-group">
		<label id="receiverIpLabel" for="receiverIp" class="col-sm-2 control-label">接收机IP</label>
		<div class="col-sm-4">
			<input type="text" class="form-control" style="width:65%; float:left;" id="receiverIp" name="receiverIp" value="<#if baseCheckMatetial??>${baseCheckMatetial.receiverIp!}</#if>" isNotNull />
			<span id="receiverIpTip" class="ct_tips">*</span>	
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
		<label id="checkReportsLabel" for="checkReports" class="col-sm-2 control-label">验收报告</label>
		<div class="col-sm-8">
      		<div id="checkReports" name="checkReports" class="fj_box">
      		</div>
      	</div>
      	<label id="checkReportsTip" class="control-label" style="color:red"></label>
	</div>
	
	<input type="hidden" id="baseCheckMatetialId" name="baseCheckMatetialId" value="<#if baseCheckMatetial??>${baseCheckMatetial.baseCheckMatetialId!}</#if>" />
	
	<#if !RequestParameters["isQuery"]?? || RequestParameters["isQuery"]!="true">
	<div class="form-group">
      <label class="col-sm-2 control-label"></label>
      <div class="col-sm-8" style="text-align:center;">
		<a  class="btn btn-success" onclick="saveCheckInfo();">
			<i class="glyphicon glyphicon-save"></i>
			<span>保存</span>
		</a>
		<a  class="btn btn-success" onclick="submitConstructMaterial();">
			<i class="glyphicon glyphicon-save"></i>
			<span>提交</span>
		</a>
	  </div>
	</div>
	</#if>