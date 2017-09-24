<script type="text/javascript" src="${rc.contextPath}/public/js/baseStation/construction/buidlMaterialInfo.js"></script>
	<input type="hidden" id="baseStationTestId" name="baseStationTestId" value="<#if baseStationTest??>${baseStationTest.baseStationTestId!}</#if>" />
	
	<#--坐标联测-->
	<div class="form-group has-feedback">
		<label  class="col-sm-2 control-label ct_tit"><span>坐标联测</span></label>
		<div class="col-sm-8">
			<input type="hidden" class="form-control"/>
		</div>
	</div>
	
	<div class="form-group">
		<label id="coorStartTimeLabel" for="coorStartTime" class="col-sm-2 control-label">坐标联测开始时间</label>
		<div class="col-sm-4 tips_icon">
			<input type="text" class="form-control" style="width:65%; float:left;" readOnly id="coorStartTime" name="coorStartTime" isNotNull value="<#if baseStationTest??>${baseStationTest.coorStartTime!}<#else>${.now?string("yyyy-MM-dd HH:mm:ss")}</#if>" onclick="testInitSelectTime();" />
			<span class="glyphicon glyphicon-menu-hamburger form-control-feedback"></span>
			<span id="coorStartTimeTip" class="ct_tips">*</span>
		</div>
		
		<label id="coorEndTimeLabel" for="coorEndTime" class="col-sm-1 control-label">坐标联测结束时间</label>
		<div class="col-sm-4 tips_icon">
			<input type="text" class="form-control" style="width:65%; float:left;" readOnly id="coorEndTime" name="coorEndTime" isNotNull value="<#if baseStationTest??>${baseStationTest.coorEndTime!}</#if>" onclick="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm:ss',minDate:'#F{$dp.$D(\'coorStartTime\')}'})" />
			<span class="glyphicon glyphicon-menu-hamburger form-control-feedback"></span>
			<span id="coorEndTimeTip" class="ct_tips">*</span>
		</div>
	</div> 
	
	<div class="form-group">
		<label id="coorChargerLabel" for="coorCharger" class="col-sm-2 control-label">坐标联测负责人</label>
		<div class="col-sm-4">
			<input type="text" class="form-control" style="width:65%; float:left;" id="coorCharger" name="coorCharger" value="<#if baseStationTest??>${baseStationTest.coorCharger!}</#if>" isNotNull />
			<span id="coorChargerTip" class="ct_tips">*</span>
		</div>
		
		
		<label id="coorChargerPhoneLabel" for="coorChargerPhone" class="col-sm-1 control-label">测试负责人电话</label>
		<div class="col-sm-4">
			<input type="text" class="form-control" style="width:65%; float:left;" id="coorChargerPhone" name="coorChargerPhone"  value="<#if baseStationTest??>${baseStationTest.coorChargerPhone!}</#if>" isNotNull /> <#--validateExp="(^(1\d{10})$|^((\d{7,8})|(\d{4}|\d{3})-(\d{7,8})|(\d{4}|\d{3})-(\d{7,8})-(\d{4}|\d{3}|\d{2}|\d{1})|(\d{7,8})-(\d{4}|\d{3}|\d{2}|\d{1}))$)"-->
			<span id="coorChargerPhoneTip" class="ct_tips">*</span>
		</div>
	</div>
	
	<div class="form-group">
		<label id="coorStandardLabel" for="coorStandard" class="col-sm-2 control-label">坐标基准</label>
		<div class="col-sm-4">
			<input type="text" class="form-control" style="width:65%; float:left;" id="coorStandard" name="coorStandard" value="<#if baseStationTest??>${baseStationTest.coorStandard!}</#if>" isNotNull />
			<span id="coorStandardTip" class="ct_tips">*</span>
		</div>
		<label id="dataAdjustSoftLabel" for="dataAdjustSoft" class="col-sm-1 control-label">数据处理平差软件</label>
		<div class="col-sm-4">
			<input type="text" class="form-control" style="width:65%; float:left;" id="dataAdjustSoft" name="dataAdjustSoft" value="<#if baseStationTest??>${baseStationTest.dataAdjustSoft!}</#if>" isNotNull />
			<span id="dataAdjustSoftTip" class="ct_tips">*</span>
		</div>
	</div>
	<#-- 起算点 数据  start-->
	<div class="form-group">
		<label id="stationNameLabel" for="stationName" class="col-sm-2 control-label">起算点</label>
		<div class="col-sm-8">
			<table id="constructsTable" style="width:600px; float:left;" class="table table-striped table-hover">
				<thead>
					<tr>
						<th>起算点</th>
						<th>位置</th>
						<th>统一编号</th>
						<#if !RequestParameters["isQuery"]?? || RequestParameters["isQuery"]!="true">
						<th>删除</th>
						</#if>
					</tr>
				</thead>
		
				<tbody id="testParamsTable">
					<tr id="testParamsTemp" style="display:none">
						<td><input type="text" data_name="pointName" class="form-control" value="" /></td>
						<td><input type="text" data_name="pointPosition" class="form-control" value="" /></td>
						<td><input type="text" data_name="uniteNo" class="form-control" value="" /></td>
						<td><a onclick="delParam(this)">删除</a></td>
					</tr>
						<#if baseStationTest?? && baseStationTest.baseLinkPoint??>
							<#list baseStationTest.baseLinkPoint as baseLinkPoint>
								<tr datatr>
									<td><input type="text" data_name="pointName" class="form-control" value="${baseLinkPoint.pointName!}" /></td>
									<td><input type="text" data_name="pointPosition" class="form-control" value="${baseLinkPoint.pointPosition!}" /></td>
									<td><input type="text" data_name="uniteNo" class="form-control" value="${baseLinkPoint.uniteNo!}" /></td>
									<#if !RequestParameters["isQuery"]?? || RequestParameters["isQuery"]!="true">
									<td><a onclick="delParam(this)">删除</a></td>
									</#if>
								</tr>
							</#list>
						</#if>
					</tr>
				</tbody>
			</table>
			<#if !RequestParameters["isQuery"]?? || RequestParameters["isQuery"]!="true">
			<span style="float:left; margin:5px 0 0 20px;" class="btn btn-success" onclick="addTableLine()">添加行</span>
			</#if>
		</div>
	</div>
	<#-- 起算点 数据  end  -->
	
	<div class="form-group">
		<label id="unionPlanLabel" for="unionPlan" class="col-sm-2 control-label">坐标联测方案</label>
		<div class="col-sm-8">
      		<div id="unionPlan" name="unionPlan" class="fj_box">
      		</div>
      	</div>
	</div>
	
	<div class="form-group">
		<label id="dataDealLabel" for="dataDeal" class="col-sm-2 control-label">数据处理报告</label>
		<div class="col-sm-8">
      		<div id="dataDeal" name="dataDeal" class="fj_box">
      		</div>
      	</div>
	</div>
	
	<div class="form-group">
		<label id="localControlLabel" for="localControl" class="col-sm-2 control-label">当地控制点</label>
		<div class="col-sm-8">
      		<div id="localControl" name="localControl" class="fj_box">
      		</div>
      	</div>
	</div>
	
	<div class="form-group">
		<label id="testPhotoLabel" for="testPhoto" class="col-sm-2 control-label">现场测试照片</label>
		<div class="col-sm-8">
      		<div id="testPhoto" name="testPhoto" class="fj_box">
      		</div>
      	</div>
	</div>
	<div class="form-group has-feedback">
		<label id="coorRemarkLabel" for="coorRemark" class="col-sm-2 control-label">备注</label>
		<div class="col-sm-6">
			<textarea class="form-control" rows="3" name="coorRemark"><#if baseStationTest??>${baseStationTest.coorRemark}</#if></textarea>
		</div>
	</div>
	<hr style="width:auto;height:1px;border:none;border-top:1px dashed grey;" />
	
	<#--系统测试-->
	<div class="form-group has-feedback ">
		<label  class="col-sm-2 control-label ct_tit"><span>系统测试</span></label>
		<div class="col-sm-8">
			<input type="hidden" class="form-control"/>
		</div>
	</div>
	
	<div class="form-group">
		<label id="sysStartTimeLabel" for="sysStartTime" class="col-sm-2 control-label">系统测试开始时间</label>
		<div class="col-sm-4 tips_icon">
			<input type="text" class="form-control" style="width:65%; float:left;" readOnly id="sysStartTime" name="sysStartTime" isNotNull value="<#if baseStationTest??>${baseStationTest.coorStartTime!}<#else>${.now?string("yyyy-MM-dd HH:mm:ss")}</#if>" onclick="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm:ss'});" />
			<span class="glyphicon glyphicon-menu-hamburger form-control-feedback"></span>
		</div>
		<label id="sysEndTimeLabel" for="sysEndTime" class="col-sm-1 control-label">系统测试结束时间</label>
		<div class="col-sm-4 tips_icon">
			<input type="text" class="form-control" style="width:65%; float:left;" readOnly id="sysEndTime" name="sysEndTime" isNotNull value="<#if baseStationTest??>${baseStationTest.sysEndTime!}<#else>${.now?string("yyyy-MM-dd HH:mm:ss")}</#if>" onclick="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm:ss'});" />
			<span class="glyphicon glyphicon-menu-hamburger form-control-feedback"></span>
		</div>
	</div>
	
	<div class="form-group has-feedback">
		<label id="sysChargerLabel" for="sysCharger" class="col-sm-2 control-label">测试负责人</label>
		<div class="col-sm-4">
			<input type="text" class="form-control" style="width:65%; float:left;" id="sysCharger" name="sysCharger"  value="<#if baseStationTest??>${baseStationTest.sysCharger!}</#if>" isNotNull />
			<span id="sysChargerTip" class="ct_tips">*</span>
		</div>
		
		<label id="sysChargerPhoneLabel" for="sysChargerPhone" class="col-sm-1 control-label">测试负责人电话</label>
		<div class="col-sm-4">
			<input type="text" class="form-control" style="width:65%; float:left;" id="sysChargerPhone" name="sysChargerPhone"   value="<#if baseStationTest??>${baseStationTest.sysChargerPhone!}</#if>" isNotNull /> <#--validateExp="(^(1\d{10})$|^((\d{7,8})|(\d{4}|\d{3})-(\d{7,8})|(\d{4}|\d{3})-(\d{7,8})-(\d{4}|\d{3}|\d{2}|\d{1})|(\d{7,8})-(\d{4}|\d{3}|\d{2}|\d{1}))$)"-->
			<span id="sysChargerPhoneTip" class="ct_tips">*</span>
		</div>
	</div>
	
	<div class="form-group">
		<label  class="col-sm-2 control-label">测试内容</label>
		<div class="col-sm-8">
			<label class="ct_la">
			   <input type="checkbox"  value="1"> <span>功能性测试</span>
			</label>
			<label class="ct_la">
			   <input type="checkbox"  value="2"> <span>指标测试</span>
			</label>
			<label class="ct_la">
			   <input type="checkbox"  value="3"> <span>系统空间可用性测试</span>
			</label>
			<label class="ct_la">
			   <input type="checkbox"  value="4"> <span>系统实时定位精度测试</span>
			</label>
			<label class="ct_la">
			   <input type="checkbox"  value="5"> <span>系统事后精密定位精度测试</span>
			</label>
			<label class="ct_la">
			   <input type="checkbox"  value="6"> <span>设备兼容性测试</span>
			</label>
		</div><br/>
	</div>
	<span></span>
	<div class="form-group" name="addData">
		<label  class="col-sm-2 control-label">其他补充</label>
		<div class="col-sm-8">
			   <input type="text" class="form-control" style="cursor:pointer"   value="<#if baseStationTest??>${baseStationTest.sysContent}</#if>" />
		</div>
	</div>
	<input type="hidden" name="sysContent"  value=""/>
	<div class="form-group">
		<label id="systemPlanLabel" for="systemPlan" class="col-sm-2 control-label">系统测试方案</label>
		<div class="col-sm-8">
      		<div id="systemPlan" name="systemPlan" class="fj_box">
      		</div>
      	</div>
	</div>
	
	<div class="form-group">
		<label id="testPlanTableLabel" for="testPlanTable" class="col-sm-2 control-label">测试进度计划表</label>
		<div class="col-sm-8">
      		<div id="testPlanTable" name="testPlanTable" class="fj_box">
      		</div>
      	</div>
	</div>
	
	<div class="form-group">
		<label id="sysTestRepLabel" for="sysTestRep" class="col-sm-2 control-label">系统测试报告</label>
		<div class="col-sm-8">
      		<div id="sysTestRep" name="sysTestRep" class="fj_box">
      		</div>
      	</div>
	</div>
	
	<div class="form-group">
		<label id="sceneTestLabel" for="sceneTest" class="col-sm-2 control-label">现场测试照片</label>
		<div class="col-sm-8">
      		<div id="sceneTest" name="sceneTest" class="fj_box">
      		</div>
      	</div>
	</div>
	
	<div class="form-group has-feedback">
		<label id="oamProjectLabel" for="oamProject" class="col-sm-2 control-label">备注</label>
		<div class="col-sm-6">
			<textarea class="form-control" rows="3" name="sysRemark"><#if baseStationTest??>${baseStationTest.sysRemark!}</#if></textarea>
		</div>
	</div>
<#if !RequestParameters["isQuery"]?? || RequestParameters["isQuery"]!="true">
<div class="form-group">
	<label class="col-sm-2 control-label"></label>
	<div class="col-sm-8" style="text-align:center">
	<a  class="btn btn-success" onclick="saveBaseStationTest();">
		<i class="glyphicon glyphicon-save"></i>
		<span>保存</span>
	</a>
	</div>
</div>
</#if>