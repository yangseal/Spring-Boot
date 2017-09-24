<table id="dynamicFieldsTable" class="table table-striped table-hover">
	<thead>
	<tr>
		<th><input type="checkbox" onclick="checkAll(this);" /></th>
		<th>字段编码</th>
		<th>字段名称</th>
		<th>字段类型</th>
		<th>是否可空</th>
		<th>是否显示</th>
		<th>默认值</th>
		<th>字典</th>
		<th>正则校验</th>
	</tr>
	</thead>
	
	<tbody>
	
	<#list page.result as dynamicField>
	<tr entityId="${dynamicField.dataCode}" onclick="selectEntity(this);">
		<td><input type="checkbox" /></td>
		<td>${dynamicField.dataCode}</td>
		<td>${dynamicField.dataName!}</td>
		<td><#if "EditText"==dynamicField.viewType>编辑框
			<#elseif "NumberTextBox"==dynamicField.viewType>数字编辑框
			<#elseif "RadioGroup"==dynamicField.viewType>单选组
			<#elseif "CheckBoxGroup"==dynamicField.viewType>复选组 
			<#elseif "ToggleButton"==dynamicField.viewType>滑动开关 
			<#elseif "DropDownList"==dynamicField.viewType>下拉列表框
			<#elseif "Date"==dynamicField.viewType>日期型
			<#elseif "DateTime"==dynamicField.viewType>日期时间型
			<#elseif "MultLineTextBox"==dynamicField.viewType>多行文本输入框
		</#if>
		</td>
		<td><#if "false"==dynamicField.isNotNull>是<#elseif "true"==dynamicField.isNotNull>否</#if></td>
		<td><#if "true"==dynamicField.isVisible>是<#elseif "false"==dynamicField.isVisible>否</#if></td>
		<td>${dynamicField.defaultValue!}</td>
		<td>${dynamicField.dictionary!}</td>
		<td>${dynamicField.validString!}</td>
	</tr>
	</#list>
	</tbody>
</table>
<@common.pager page.pageBean "dynamicFieldsForm" "dynamicFieldsDiv"/>