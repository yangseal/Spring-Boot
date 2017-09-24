<!doctype html>
<html>
<head>
<#include "/head.ftl"/>
<script type="text/javascript" src="${rc.contextPath}/public/js/conversionParam/conversionParams.js"></script>
</head>
<body>
<a  class="btn btn-success" onclick="addConversionParam();">
	<i class="glyphicon glyphicon-plus"></i>
	<span>新增一级转换参数</span>
</a>
<table id="conversionParamsTable" class="table">
	<thead>
		<tr>
			<th>转换参数名称</th>
			<th>转换参数编码</th>
			<th>源椭球体系</th>
			<th>目标椭球体系</th>
			<th>北边界</th>
			<th>南边界</th>
			<th>西边界</th>
			<th>东边界</th>
			<th>北边纬度</th>
			<th>南边纬度</th>
			<th>西边经度</th>
			<th>东边经度</th>
			<th>X平移</th>
			<th>y平移</th>
			<th>z平移</th>
			<th>比例因子</th>
			<th>X轴旋转</th>
			<th>Y轴旋转</th>
			<th>Z轴旋转</th>
			<th>转换类型</th>
			<th>参照点1纬度</th>
			<th>参照点1经度</th>
			<th>参照点1高程</th>
			<th>参照点1X坐标</th>
			<th>参照点1Y坐标</th>
			<th>参照点1Z坐标</th>
			<th>参照点2纬度</th>
			<th>参照点2经度</th>
			<th>参照点2高程</th>
			<th>参照点2X坐标</th>
			<th>参照点2Y坐标</th>
			<th>参照点2Z坐标</th>
			<th>参照点3纬度</th>
			<th>参照点3经度</th>
			<th>参照点3高程</th>
			<th>参照点3X坐标</th>
			<th>参照点3Y坐标</th>
			<th>参照点3Z坐标</th>
			<th>备注</th>
			<th>对应转换投影</th>
			<th>操作</th>
		</tr>
	</thead>
	<tbody>
		<#list conversionParams as conversionParam>
		<tr id="${conversionParam.conversionParamId!}" entityId="${conversionParam.conversionParamId!}" <#if conversionParam.parentId??>pid="${conversionParam.parentId}"</#if> onclick="selectEntity(this);">
			<td style="text-align:left"><span>${conversionParam.conversionParamName!}</span></td>
			<td><span>${conversionParam.conversionParamCode!}</span></td>
			<td><span>${conversionParam.ellipoidSys!}</span></td>
			<td><span>${conversionParam.ellipoidSys2!}</span></td>
			<td><span>${conversionParam.north!}</span></td>
			<td><span>${conversionParam.south!}</span></td>
			<td><span>${conversionParam.west!}</span></td>
			<td><span>${conversionParam.east!}</span></td>
			<td><span>${conversionParam.northLat!}</span></td>
			<td><span>${conversionParam.southLat!}</span></td>
			<td><span>${conversionParam.westLng!}</span></td>
			<td><span>${conversionParam.eastLng!}</span></td>
			<td><span>${conversionParam.x!}</span></td>
			<td><span>${conversionParam.y!}</span></td>
			<td><span>${conversionParam.z!}</span></td>
			<td><span>${conversionParam.k!}</span></td>
			<td><span>${conversionParam.xt!}</span></td>
			<td><span>${conversionParam.yt!}</span></td>
			<td><span>${conversionParam.zt!}</span></td>
			<td><span>${conversionParam.conversionType!}</span></td>
			<td><span>${conversionParam.pt1B!}</span></td>
			<td><span>${conversionParam.pt1L!}</span></td>
			<td><span>${conversionParam.pt1H!}</span></td>
			<td><span>${conversionParam.pt1X!}</span></td>
			<td><span>${conversionParam.pt1Y!}</span></td>
			<td><span>${conversionParam.pt1Z!}</span></td>
			<td><span>${conversionParam.pt2B!}</span></td>
			<td><span>${conversionParam.pt2L!}</span></td>
			<td><span>${conversionParam.pt2H!}</span></td>
			<td><span>${conversionParam.pt2X!}</span></td>
			<td><span>${conversionParam.pt2Y!}</span></td>
			<td><span>${conversionParam.pt2Z!}</span></td>
			<td><span>${conversionParam.pt3B!}</span></td>
			<td><span>${conversionParam.pt3L!}</span></td>
			<td><span>${conversionParam.pt3H!}</span></td>
			<td><span>${conversionParam.pt3X!}</span></td>
			<td><span>${conversionParam.pt3Y!}</span></td>
			<td><span>${conversionParam.pt3Z!}</span></td>
			<td><span>${conversionParam.info!}</span></td>
			<td><span><#if conversionParam.conversionProjection??>${conversionParam.conversionProjection.conversionProjectionName!}</#if></span></td>
			<td>
				<div>
					<a onclick='addConversionParam(this)' href='javascript:;' class="btn btn-success"><i class="glyphicon glyphicon-plus"></i></a>
					<a onclick='editConversionParam(this)' href='javascript:;' class="btn btn-warning"><i class="glyphicon glyphicon-edit"></i></a>
					<a onclick='deleteConversionParam(this)' href='javascript:;' class="btn btn-danger"><i class="glyphicon glyphicon-trash"></i></a>
				</div>
			</td>
		</tr>
		</#list>
	</tbody>
</table>
</body>
</html>
