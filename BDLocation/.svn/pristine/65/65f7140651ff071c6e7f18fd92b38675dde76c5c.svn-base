<div>
	<a  class="btn btn-success" onclick="selectOamAreaOk(this);">
		<i class="glyphicon glyphicon-ok"></i>
    	<span>确定</span>
	</a>
	<a  class="btn btn-info" onclick="selectOamAreaClear(this);">
		<i class="glyphicon glyphicon-remove"></i>
    	<span>清空</span>
	</a>
</div>
<table id="oamAreasTable" class="table">
	<thead>
		<tr>
			<th>地区名称</th>
			<th>地区编码</th>
			<th>经度</th>
			<th>纬度</th>
			<th>创建日期</th>
		</tr>
	</thead>
	<tbody>
		<#list oamAreas as oamArea>
		<tr id="${oamArea.oamAreaId!}" entityId="${oamArea.oamAreaId!}" <#if oamArea.parentId??>pid="${oamArea.parentId}"</#if> onclick="selectEntity(this);">
			<td style="text-align:left"><span>${oamArea.oamAreaName!}</span></td>
			<td><span>${oamArea.oamAreaCode!}</span></td>
			<td><span>${oamArea.longitude!}</span></td>
			<td><span>${oamArea.latitude!}</span></td>
			<td><span>${oamArea.createDate!}</span></td>
		</tr>
		</#list>
	</tbody>
</table>
<script type="text/javascript">
	$("#oamAreasTable").treeTable({theme:'vsStyle',expandLevel:1});
	function selectOamAreaOk(sender){
		var oamAreaId = getSelectedEntityId("oamAreasTable");
		if(!oamAreaId){
			myAlert("请选择地区");
			return;
		}
		var fk;
		var fkFieldCode = $(sender).closest("div[fkFieldCode]").attr("fkFieldCode");
		if(fkFieldCode){
			fk = fkFieldCode;
		}else{
			fk = _fkFieldCode;
		}
		$("#"+fk+"Id").val(oamAreaId);
		$("#"+fk).val($("#oamAreasTable tr[id='"+$("#oamAreasTable tr.active").attr('pid')+"']").find('td:first').text()+" "+$("#oamAreasTable tr.active td:first").text());
		$("#company_city_id").val($("#oamAreasTable tr.active").attr("id"));
		$("#company_province_id").val($("#oamAreasTable tr.active").attr("pid"));
		if(fkFieldCode){
			dialog.get(fkFieldCode).remove();
		}else{
			removeDialog();
		}
	}
	function selectOamAreaClear(sender){
		var fk;
		var fkFieldCode = $(sender).closest("div[fkFieldCode]").attr("fkFieldCode");
		if(fkFieldCode){
			fk = fkFieldCode;
		}else{
			fk = _fkFieldCode;
		}
		$("#"+fk+"Id").val("");
		$("#"+fk).val("");
		if(fkFieldCode){
			dialog.get(fkFieldCode).remove();
		}else{
			removeDialog();
		}
	}
</script>
