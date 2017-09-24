<form id="conversionParamForm" class="form-horizontal">
	<div class="form-group">
		<label id="conversionParamNameLabel" for="conversionParamName" class="col-sm-2 control-label">转换参数名称</label>
		<div class="col-sm-7">
			<input type="text" class="form-control" id="conversionParamName" name="conversionParamName" isNotNull value="<#if conversionParam??>${conversionParam.conversionParamName!}<#else></#if>" />
		</div>
		<label id="conversionParamNameTip" class="control-label" style="color:red">*</label>
	</div>
	<div class="form-group">
		<label id="conversionParamCodeLabel" for="conversionParamCode" class="col-sm-2 control-label">转换参数编码</label>
		<div class="col-sm-7">
			<input type="text" class="form-control" id="conversionParamCode" name="conversionParamCode" isNotNull value="<#if conversionParam??>${conversionParam.conversionParamCode!}<#else></#if>" />
		</div>
		<label id="conversionParamCodeTip" class="control-label" style="color:red">*</label>
	</div>
	<div class="form-group">
		<label id="ellipoidSysLabel" for="ellipoidSys" class="col-sm-2 control-label">源椭球体系</label>
		<div class="col-sm-7">
			<input type="text" class="form-control" id="ellipoidSys" name="ellipoidSys" value="<#if conversionParam??>${conversionParam.ellipoidSys!}<#else></#if>" />
		</div>
		<label id="ellipoidSysTip" class="control-label" style="color:red"></label>
	</div>
	<div class="form-group">
		<label id="ellipoidSys2Label" for="ellipoidSys2" class="col-sm-2 control-label">目标椭球体系</label>
		<div class="col-sm-7">
			<input type="text" class="form-control" id="ellipoidSys2" name="ellipoidSys2" value="<#if conversionParam??>${conversionParam.ellipoidSys2!}<#else></#if>" />
		</div>
		<label id="ellipoidSys2Tip" class="control-label" style="color:red"></label>
	</div>
	<div class="form-group">
		<label id="northLabel" for="north" class="col-sm-2 control-label">北边界</label>
		<div class="col-sm-7">
			<input type="text" class="form-control" id="north" name="north" validateExp="^(\d{1,}\.?\d*)$" validateTip="北边界应为数值" value="<#if conversionParam??>${conversionParam.north!}<#else></#if>" />
		</div>
		<label id="northTip" class="control-label" style="color:red"></label>
	</div>
	<div class="form-group">
		<label id="southLabel" for="south" class="col-sm-2 control-label">南边界</label>
		<div class="col-sm-7">
			<input type="text" class="form-control" id="south" name="south" validateExp="^(\d{1,}\.?\d*)$" validateTip="南边界应为数值" value="<#if conversionParam??>${conversionParam.south!}<#else></#if>" />
		</div>
		<label id="southTip" class="control-label" style="color:red"></label>
	</div>
	<div class="form-group">
		<label id="westLabel" for="west" class="col-sm-2 control-label">西边界</label>
		<div class="col-sm-7">
			<input type="text" class="form-control" id="west" name="west" validateExp="^(\d{1,}\.?\d*)$" validateTip="西边界应为数值" value="<#if conversionParam??>${conversionParam.west!}<#else></#if>" />
		</div>
		<label id="westTip" class="control-label" style="color:red"></label>
	</div>
	<div class="form-group">
		<label id="eastLabel" for="east" class="col-sm-2 control-label">东边界</label>
		<div class="col-sm-7">
			<input type="text" class="form-control" id="east" name="east" validateExp="^(\d{1,}\.?\d*)$" validateTip="东边界应为数值" value="<#if conversionParam??>${conversionParam.east!}<#else></#if>" />
		</div>
		<label id="eastTip" class="control-label" style="color:red"></label>
	</div>
	<div class="form-group">
		<label id="northLatLabel" for="northLat" class="col-sm-2 control-label">北边纬度</label>
		<div class="col-sm-7">
			<input type="text" class="form-control" id="northLat" name="northLat" validateExp="^(\d{1,}\.?\d*)$" validateTip="北边纬度应为数值" value="<#if conversionParam??>${conversionParam.northLat!}<#else></#if>" />
		</div>
		<label id="northLatTip" class="control-label" style="color:red"></label>
	</div>
	<div class="form-group">
		<label id="southLatLabel" for="southLat" class="col-sm-2 control-label">南边纬度</label>
		<div class="col-sm-7">
			<input type="text" class="form-control" id="southLat" name="southLat" validateExp="^(\d{1,}\.?\d*)$" validateTip="南边纬度应为数值" value="<#if conversionParam??>${conversionParam.southLat!}<#else></#if>" />
		</div>
		<label id="southLatTip" class="control-label" style="color:red"></label>
	</div>
	<div class="form-group">
		<label id="westLngLabel" for="westLng" class="col-sm-2 control-label">西边经度</label>
		<div class="col-sm-7">
			<input type="text" class="form-control" id="westLng" name="westLng" validateExp="^(\d{1,}\.?\d*)$" validateTip="西边经度应为数值" value="<#if conversionParam??>${conversionParam.westLng!}<#else></#if>" />
		</div>
		<label id="westLngTip" class="control-label" style="color:red"></label>
	</div>
	<div class="form-group">
		<label id="eastLngLabel" for="eastLng" class="col-sm-2 control-label">东边经度</label>
		<div class="col-sm-7">
			<input type="text" class="form-control" id="eastLng" name="eastLng" validateExp="^(\d{1,}\.?\d*)$" validateTip="东边经度应为数值" value="<#if conversionParam??>${conversionParam.eastLng!}<#else></#if>" />
		</div>
		<label id="eastLngTip" class="control-label" style="color:red"></label>
	</div>
	<div class="form-group">
		<label id="xLabel" for="x" class="col-sm-2 control-label">X平移</label>
		<div class="col-sm-7">
			<input type="text" class="form-control" id="x" name="x" validateExp="^(\d{1,}\.?\d*)$" validateTip="X平移应为数值" value="<#if conversionParam??>${conversionParam.x!}<#else></#if>" />
		</div>
		<label id="xTip" class="control-label" style="color:red"></label>
	</div>
	<div class="form-group">
		<label id="yLabel" for="y" class="col-sm-2 control-label">y平移</label>
		<div class="col-sm-7">
			<input type="text" class="form-control" id="y" name="y" validateExp="^(\d{1,}\.?\d*)$" validateTip="y平移应为数值" value="<#if conversionParam??>${conversionParam.y!}<#else></#if>" />
		</div>
		<label id="yTip" class="control-label" style="color:red"></label>
	</div>
	<div class="form-group">
		<label id="zLabel" for="z" class="col-sm-2 control-label">z平移</label>
		<div class="col-sm-7">
			<input type="text" class="form-control" id="z" name="z" validateExp="^(\d{1,}\.?\d*)$" validateTip="z平移应为数值" value="<#if conversionParam??>${conversionParam.z!}<#else></#if>" />
		</div>
		<label id="zTip" class="control-label" style="color:red"></label>
	</div>
	<div class="form-group">
		<label id="kLabel" for="k" class="col-sm-2 control-label">比例因子</label>
		<div class="col-sm-7">
			<input type="text" class="form-control" id="k" name="k" validateExp="^(\d{1,}\.?\d*)$" validateTip="比例因子应为数值" value="<#if conversionParam??>${conversionParam.k!}<#else></#if>" />
		</div>
		<label id="kTip" class="control-label" style="color:red"></label>
	</div>
	<div class="form-group">
		<label id="xtLabel" for="xt" class="col-sm-2 control-label">X轴旋转</label>
		<div class="col-sm-7">
			<input type="text" class="form-control" id="xt" name="xt" validateExp="^(\d{1,}\.?\d*)$" validateTip="X轴旋转应为数值" value="<#if conversionParam??>${conversionParam.xt!}<#else></#if>" />
		</div>
		<label id="xtTip" class="control-label" style="color:red"></label>
	</div>
	<div class="form-group">
		<label id="ytLabel" for="yt" class="col-sm-2 control-label">Y轴旋转</label>
		<div class="col-sm-7">
			<input type="text" class="form-control" id="yt" name="yt" validateExp="^(\d{1,}\.?\d*)$" validateTip="Y轴旋转应为数值" value="<#if conversionParam??>${conversionParam.yt!}<#else></#if>" />
		</div>
		<label id="ytTip" class="control-label" style="color:red"></label>
	</div>
	<div class="form-group">
		<label id="ztLabel" for="zt" class="col-sm-2 control-label">Z轴旋转</label>
		<div class="col-sm-7">
			<input type="text" class="form-control" id="zt" name="zt" validateExp="^(\d{1,}\.?\d*)$" validateTip="Z轴旋转应为数值" value="<#if conversionParam??>${conversionParam.zt!}<#else></#if>" />
		</div>
		<label id="ztTip" class="control-label" style="color:red"></label>
	</div>
	<div class="form-group">
		<label id="conversionTypeLabel" for="conversionType" class="col-sm-2 control-label">转换类型</label>
		<div class="col-sm-7">
			<input type="text" class="form-control" id="conversionType" name="conversionType" validateExp="^-?[1-9]\d*$" validateTip="转换类型应为整数值" value="<#if conversionParam??>${conversionParam.conversionType!}<#else></#if>" />
		</div>
		<label id="conversionTypeTip" class="control-label" style="color:red"></label>
	</div>
	<div class="form-group">
		<label id="pt1BLabel" for="pt1B" class="col-sm-2 control-label">参照点1纬度</label>
		<div class="col-sm-7">
			<input type="text" class="form-control" id="pt1B" name="pt1B" validateExp="^(\d{1,}\.?\d*)$" validateTip="参照点1纬度应为数值" value="<#if conversionParam??>${conversionParam.pt1B!}<#else></#if>" />
		</div>
		<label id="pt1BTip" class="control-label" style="color:red"></label>
	</div>
	<div class="form-group">
		<label id="pt1LLabel" for="pt1L" class="col-sm-2 control-label">参照点1经度</label>
		<div class="col-sm-7">
			<input type="text" class="form-control" id="pt1L" name="pt1L" validateExp="^(\d{1,}\.?\d*)$" validateTip="参照点1经度应为数值" value="<#if conversionParam??>${conversionParam.pt1L!}<#else></#if>" />
		</div>
		<label id="pt1LTip" class="control-label" style="color:red"></label>
	</div>
	<div class="form-group">
		<label id="pt1HLabel" for="pt1H" class="col-sm-2 control-label">参照点1高程</label>
		<div class="col-sm-7">
			<input type="text" class="form-control" id="pt1H" name="pt1H" validateExp="^(\d{1,}\.?\d*)$" validateTip="参照点1高程应为数值" value="<#if conversionParam??>${conversionParam.pt1H!}<#else></#if>" />
		</div>
		<label id="pt1HTip" class="control-label" style="color:red"></label>
	</div>
	<div class="form-group">
		<label id="pt1XLabel" for="pt1X" class="col-sm-2 control-label">参照点1X坐标</label>
		<div class="col-sm-7">
			<input type="text" class="form-control" id="pt1X" name="pt1X" validateExp="^(\d{1,}\.?\d*)$" validateTip="参照点1X坐标应为数值" value="<#if conversionParam??>${conversionParam.pt1X!}<#else></#if>" />
		</div>
		<label id="pt1XTip" class="control-label" style="color:red"></label>
	</div>
	<div class="form-group">
		<label id="pt1YLabel" for="pt1Y" class="col-sm-2 control-label">参照点1Y坐标</label>
		<div class="col-sm-7">
			<input type="text" class="form-control" id="pt1Y" name="pt1Y" validateExp="^(\d{1,}\.?\d*)$" validateTip="参照点1Y坐标应为数值" value="<#if conversionParam??>${conversionParam.pt1Y!}<#else></#if>" />
		</div>
		<label id="pt1YTip" class="control-label" style="color:red"></label>
	</div>
	<div class="form-group">
		<label id="pt1ZLabel" for="pt1Z" class="col-sm-2 control-label">参照点1Z坐标</label>
		<div class="col-sm-7">
			<input type="text" class="form-control" id="pt1Z" name="pt1Z" validateExp="^(\d{1,}\.?\d*)$" validateTip="参照点1Z坐标应为数值" value="<#if conversionParam??>${conversionParam.pt1Z!}<#else></#if>" />
		</div>
		<label id="pt1ZTip" class="control-label" style="color:red"></label>
	</div>
	<div class="form-group">
		<label id="pt2BLabel" for="pt2B" class="col-sm-2 control-label">参照点2纬度</label>
		<div class="col-sm-7">
			<input type="text" class="form-control" id="pt2B" name="pt2B" validateExp="^(\d{1,}\.?\d*)$" validateTip="参照点2纬度应为数值" value="<#if conversionParam??>${conversionParam.pt2B!}<#else></#if>" />
		</div>
		<label id="pt2BTip" class="control-label" style="color:red"></label>
	</div>
	<div class="form-group">
		<label id="pt2LLabel" for="pt2L" class="col-sm-2 control-label">参照点2经度</label>
		<div class="col-sm-7">
			<input type="text" class="form-control" id="pt2L" name="pt2L" validateExp="^(\d{1,}\.?\d*)$" validateTip="参照点2经度应为数值" value="<#if conversionParam??>${conversionParam.pt2L!}<#else></#if>" />
		</div>
		<label id="pt2LTip" class="control-label" style="color:red"></label>
	</div>
	<div class="form-group">
		<label id="pt2HLabel" for="pt2H" class="col-sm-2 control-label">参照点2高程</label>
		<div class="col-sm-7">
			<input type="text" class="form-control" id="pt2H" name="pt2H" validateExp="^(\d{1,}\.?\d*)$" validateTip="参照点2高程应为数值" value="<#if conversionParam??>${conversionParam.pt2H!}<#else></#if>" />
		</div>
		<label id="pt2HTip" class="control-label" style="color:red"></label>
	</div>
	<div class="form-group">
		<label id="pt2XLabel" for="pt2X" class="col-sm-2 control-label">参照点2X坐标</label>
		<div class="col-sm-7">
			<input type="text" class="form-control" id="pt2X" name="pt2X" validateExp="^(\d{1,}\.?\d*)$" validateTip="参照点2X坐标应为数值" value="<#if conversionParam??>${conversionParam.pt2X!}<#else></#if>" />
		</div>
		<label id="pt2XTip" class="control-label" style="color:red"></label>
	</div>
	<div class="form-group">
		<label id="pt2YLabel" for="pt2Y" class="col-sm-2 control-label">参照点2Y坐标</label>
		<div class="col-sm-7">
			<input type="text" class="form-control" id="pt2Y" name="pt2Y" validateExp="^(\d{1,}\.?\d*)$" validateTip="参照点2Y坐标应为数值" value="<#if conversionParam??>${conversionParam.pt2Y!}<#else></#if>" />
		</div>
		<label id="pt2YTip" class="control-label" style="color:red"></label>
	</div>
	<div class="form-group">
		<label id="pt2ZLabel" for="pt2Z" class="col-sm-2 control-label">参照点2Z坐标</label>
		<div class="col-sm-7">
			<input type="text" class="form-control" id="pt2Z" name="pt2Z" validateExp="^(\d{1,}\.?\d*)$" validateTip="参照点2Z坐标应为数值" value="<#if conversionParam??>${conversionParam.pt2Z!}<#else></#if>" />
		</div>
		<label id="pt2ZTip" class="control-label" style="color:red"></label>
	</div>
	<div class="form-group">
		<label id="pt3BLabel" for="pt3B" class="col-sm-2 control-label">参照点3纬度</label>
		<div class="col-sm-7">
			<input type="text" class="form-control" id="pt3B" name="pt3B" validateExp="^(\d{1,}\.?\d*)$" validateTip="参照点3纬度应为数值" value="<#if conversionParam??>${conversionParam.pt3B!}<#else></#if>" />
		</div>
		<label id="pt3BTip" class="control-label" style="color:red"></label>
	</div>
	<div class="form-group">
		<label id="pt3LLabel" for="pt3L" class="col-sm-2 control-label">参照点3经度</label>
		<div class="col-sm-7">
			<input type="text" class="form-control" id="pt3L" name="pt3L" validateExp="^(\d{1,}\.?\d*)$" validateTip="参照点3经度应为数值" value="<#if conversionParam??>${conversionParam.pt3L!}<#else></#if>" />
		</div>
		<label id="pt3LTip" class="control-label" style="color:red"></label>
	</div>
	<div class="form-group">
		<label id="pt3HLabel" for="pt3H" class="col-sm-2 control-label">参照点3高程</label>
		<div class="col-sm-7">
			<input type="text" class="form-control" id="pt3H" name="pt3H" validateExp="^(\d{1,}\.?\d*)$" validateTip="参照点3高程应为数值" value="<#if conversionParam??>${conversionParam.pt3H!}<#else></#if>" />
		</div>
		<label id="pt3HTip" class="control-label" style="color:red"></label>
	</div>
	<div class="form-group">
		<label id="pt3XLabel" for="pt3X" class="col-sm-2 control-label">参照点3X坐标</label>
		<div class="col-sm-7">
			<input type="text" class="form-control" id="pt3X" name="pt3X" validateExp="^(\d{1,}\.?\d*)$" validateTip="参照点3X坐标应为数值" value="<#if conversionParam??>${conversionParam.pt3X!}<#else></#if>" />
		</div>
		<label id="pt3XTip" class="control-label" style="color:red"></label>
	</div>
	<div class="form-group">
		<label id="pt3YLabel" for="pt3Y" class="col-sm-2 control-label">参照点3Y坐标</label>
		<div class="col-sm-7">
			<input type="text" class="form-control" id="pt3Y" name="pt3Y" validateExp="^(\d{1,}\.?\d*)$" validateTip="参照点3Y坐标应为数值" value="<#if conversionParam??>${conversionParam.pt3Y!}<#else></#if>" />
		</div>
		<label id="pt3YTip" class="control-label" style="color:red"></label>
	</div>
	<div class="form-group">
		<label id="pt3ZLabel" for="pt3Z" class="col-sm-2 control-label">参照点3Z坐标</label>
		<div class="col-sm-7">
			<input type="text" class="form-control" id="pt3Z" name="pt3Z" validateExp="^(\d{1,}\.?\d*)$" validateTip="参照点3Z坐标应为数值" value="<#if conversionParam??>${conversionParam.pt3Z!}<#else></#if>" />
		</div>
		<label id="pt3ZTip" class="control-label" style="color:red"></label>
	</div>
	<div class="form-group">
		<label id="infoLabel" for="info" class="col-sm-2 control-label">备注</label>
		<div class="col-sm-7">
			<input type="text" class="form-control" id="info" name="info" value="<#if conversionParam??>${conversionParam.info!}<#else></#if>" />
		</div>
		<label id="infoTip" class="control-label" style="color:red"></label>
	</div>
	<#if !RequestParameters["conversionProjectionId"]?? || RequestParameters["conversionProjectionId"]=="">
	<div class="form-group has-feedback">
		<label id="conversionProjectionLabel" for="conversionProjection" class="col-sm-2 control-label">对应转换投影</label>
		<div class="col-sm-7">
			<input type="text" class="form-control" style="cursor:pointer" id="conversionProjection" name="conversionProjection" value="<#if conversionParam?? && conversionParam.conversionProjection??>${conversionParam.conversionProjection.conversionProjectionName!}</#if>" onclick="selectConversionProjection();" />
			<span class="glyphicon glyphicon-menu-hamburger form-control-feedback"></span>
		</div>
		<label id="conversionProjectionTip" class="control-label" style="color:red"></label>
	</div>
	</#if>
	<input type="hidden" id="conversionProjectionId" name="conversionProjection.conversionProjectionId" value="<#if conversionParam?? && conversionParam.conversionProjection??>${conversionParam.conversionProjection.conversionProjectionId!}<#else>${RequestParameters["conversionProjectionId"]!}</#if>" />
	<input type="hidden" id="parentId" name="parentId" value="<#if conversionParam??>${conversionParam.parentId!}<#else>${RequestParameters["parentId"]!}</#if>" />
	<input type="hidden" id="conversionParamId" name="conversionParamId" value="<#if conversionParam??>${conversionParam.conversionParamId!}</#if>" />
</form>
<div style="text-align:center">
	<a  class="btn btn-success" onclick="saveConversionParam();">
		<i class="glyphicon glyphicon-save"></i>
		<span>保存</span>
	</a>
</div>
<script type="text/javascript">
</script>