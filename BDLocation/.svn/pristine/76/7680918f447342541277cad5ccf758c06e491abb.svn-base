<!doctype html>
<html>
<head>
<#include "/head.ftl"/>
<script type="text/javascript" src="${rc.contextPath}/public/js/oamArea/oamAreas.js"></script>
</head>
<body>
<div class="cont_box">
<a  class="btn btn-success" onclick="addOamArea();">
	<i class="glyphicon glyphicon-plus"></i>
	<span>新增一级地区</span>
</a>
<table id="oamAreasTable" class="table">
	<thead>
		<tr>
			<th>地区名称</th>
			<th>地区编码</th>
			<th>经度</th>
			<th>纬度</th>
			<th>创建日期</th>
			<th>操作</th>
		</tr>
	</thead>
	<tbody>
		<#list oamAreas as oamArea>
		<tr id="${oamArea.oamAreaId!}" entityId="${oamArea.oamAreaId!}" <#if oamArea.parentId??>pid="${oamArea.parentId}"</#if> onclick="selectEntity(this);">
			<td style="text-align:left"><span>${oamArea.oamAreaName!}</span></td>
			<td><span>${oamArea.oamAreaCode!}</span></td>
			<td><span><#if oamArea.longitude??>${oamArea.longitude?c}</#if></span></td>
			<td><span><#if oamArea.latitude??>${oamArea.latitude?c}</#if></span></td>
			<td><span>${oamArea.createDate!}</span></td>
			<td>
				<div>
					<a onclick='addOamArea(this)' href='javascript:;' class="btn btn-success"><i class="glyphicon glyphicon-plus"></i></a>
					<a onclick='editOamArea(this)' href='javascript:;' class="btn btn-warning"><i class="glyphicon glyphicon-edit"></i></a>
					<a onclick='deleteOamArea(this)' href='javascript:;' class="btn btn-danger"><i class="glyphicon glyphicon-trash"></i></a>
				</div>
			</td>
		</tr>
		</#list>
	</tbody>
</table>
</div>
</body>
</html>
