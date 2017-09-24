$(function(){
	var option = {
			theme : 'vsStyle',
			expandLevel : 1
	};
	window.oamAreasTable = $("#oamAreasTable").treeTable(option);
});

function addOamArea(sender){
	var dom = $("<div/>");
	var url = CONTEXT_PATH + "/oamArea/showOamArea";
	var params = {};
	if(sender){
		window.curRow = $(sender).closest("tr");
		params.parentId = curRow.attr("id");
	}else{
		window.curRow = null;
	}
	dom.load(url,params,function(){
		dialog({
			title : "新增地区",
			content : dom,
			width: 600
		}).showModal();
	});
}

function editOamArea(sender){
	var dom = $("<div/>");
	var url = CONTEXT_PATH + "/oamArea/showOamArea";
	window.curRow = $(sender).closest("tr");
	var params = {oamAreaId:curRow.attr("id")};
	dom.load(url,params,function(){
		dialog({
			title : "编辑地区",
			content : dom,
			width: 600
		}).showModal();
	});
}

function saveOamArea(){
	if(!validateForm("oamAreaForm")){
		return;
	}
	var url = CONTEXT_PATH + "/oamArea/saveOamArea";
	var params = $("#oamAreaForm").serialize();
	jQuery.post(url, params, function(data) {
		if(!data.success){
			removeDialog();
			myAlert(data.message);
			return;
		}
		var oamAreaId = $("#oamAreaId").val();
		if(!oamAreaId){
			var trHtml = "<tr id='" + data.message + "'";
			if(curRow){
				trHtml += " pid='" + curRow.attr("id") + "'";
			}
			trHtml += " onclick='selectEntity(this);'>";
			trHtml += "<td style='text-align:left'><span>" + $("#oamAreaName").val() + "</span></td>";
			trHtml += "<td><span>" + $("#oamAreaCode").val() + "</span></td>";
			trHtml += "<td><span>" + $("#longitude").val() + "</span></td>";
			trHtml += "<td><span>" + $("#latitude").val() + "</span></td>";
			trHtml += "<td><span>" + $("#createDate").val() + "</span></td>";
			trHtml += "<td><div><a href='javascript:;' onclick='addOamArea(this);' class='btn btn-success'><i class='glyphicon glyphicon-plus'></i></a>"
				+ "<a href='javascript:;' onclick='editOamArea(this);' class='btn btn-warning'><i class='glyphicon glyphicon-edit'></i></a>"
				+ "<a href='javascript:;' onclick='deleteOamArea(this);' class='btn btn-danger'><i class='glyphicon glyphicon-trash'></i></a></div></td></tr>";
			window.oamAreasTable.addRows(trHtml);
		}else{
			curRow.find("td:eq(0) span:last").text($("#oamAreaName").val());
			curRow.find("td:eq(1) span:last").text($("#oamAreaCode").val());
			curRow.find("td:eq(2) span:last").text($("#longitude").val());
			curRow.find("td:eq(3) span:last").text($("#latitude").val());
			curRow.find("td:eq(4) span:last").text($("#createDate").val());
		}
		removeDialog();
	});
}

function deleteOamArea(sender){
	var oamAreaId = $(sender).closest("tr").attr("id");
	var oamAreaName = $(sender).closest("tr").find("td:first span:last").text();
	myConfirm("确实要删除"+oamAreaName+"吗？",function(){
		var url = CONTEXT_PATH + "/oamArea/deleteOamArea";
		var params = {oamAreaId:oamAreaId};
		jQuery.post(url, params, function(data) {
			if(data.success){
				window.oamAreasTable.deleteRow(oamAreaId);
			}else{
				myAlert(data.message);
			}
		});
	});
}

