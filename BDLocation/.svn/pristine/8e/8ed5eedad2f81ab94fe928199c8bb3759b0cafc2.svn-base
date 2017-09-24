<table id="pointTypesTable" class="table table-striped table-hover">
	<thead>
	<tr>
		<th><input type="checkbox" onclick="checkAll(this);" /></th>
		<th>编码</th>
		<th>名称</th>
		<th>创建日期</th>
		<th>是否可用</th>
		<th>描述</th>
	</tr>
	</thead>
	
	<tbody>
	<#list page.result as pointType>
	<tr entityId="${pointType.pointTypeId!}" onclick="selectEntity(this);">
		<td><input type="checkbox" /></td>
		<td>${pointType.pointTypeCode!}</td>
		<td>${pointType.pointTypeName!}</td>
		<td>${pointType.createDate!}</td>
		<td><#if "Y"==pointType.typeState>是<#elseif "N"==pointType.typeState>否</#if></td>
		<td>${pointType.typeDesc!}</td>
	</tr>
	</#list>
	</tbody>
</table>
<@common.pager page.pageBean "pointTypesForm" "pointTypesDiv"/>