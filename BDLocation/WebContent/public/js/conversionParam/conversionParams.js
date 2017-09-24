$(function(){
	var option = {
			theme : 'vsStyle',
			expandLevel : 1
	};
	window.conversionParamsTable = $("#conversionParamsTable").treeTable(option);
});

function addConversionParam(sender){
	var dom = $("<div/>");
	var url = CONTEXT_PATH + "/conversionParam/showConversionParam";
	var params = {};
	if(sender){
		window.curRow = $(sender).closest("tr");
		params.parentId = curRow.attr("id");
	}else{
		window.curRow = null;
	}
	dom.load(url,params,function(){
		dialog({
			title : "新增转换参数",
			content : dom,
			width:$("body").width()-100
		}).showModal();
	});
}

function editConversionParam(sender){
	var dom = $("<div/>");
	var url = CONTEXT_PATH + "/conversionParam/showConversionParam";
	window.curRow = $(sender).closest("tr");
	var params = {conversionParamId:curRow.attr("id")};
	dom.load(url,params,function(){
		dialog({
			title : "编辑转换参数",
			content : dom,
			width:$("body").width()-100
		}).showModal();
	});
}

function saveConversionParam(){
	if(!validateForm("conversionParamForm")){
		return;
	}
	var url = CONTEXT_PATH + "/conversionParam/saveConversionParam";
	var params = $("#conversionParamForm").serialize();
	jQuery.post(url, params, function(data) {
		if(!data.success){
			removeDialog();
			myAlert(data.message);
			return;
		}
		var conversionParamId = $("#conversionParamId").val();
		if(!conversionParamId){
			var trHtml = "<tr id='" + data.message + "'";
			if(curRow){
				trHtml += " pid='" + curRow.attr("id") + "'";
			}
			trHtml += " onclick='selectEntity(this);'>";
			trHtml += "<td style='text-align:left'><span>" + $("#conversionParamName").val() + "</span></td>";
			trHtml += "<td><span>" + $("#conversionParamCode").val() + "</span></td>";
			trHtml += "<td><span>" + $("#ellipoidSys").val() + "</span></td>";
			trHtml += "<td><span>" + $("#ellipoidSys2").val() + "</span></td>";
			trHtml += "<td><span>" + $("#north").val() + "</span></td>";
			trHtml += "<td><span>" + $("#south").val() + "</span></td>";
			trHtml += "<td><span>" + $("#west").val() + "</span></td>";
			trHtml += "<td><span>" + $("#east").val() + "</span></td>";
			trHtml += "<td><span>" + $("#northLat").val() + "</span></td>";
			trHtml += "<td><span>" + $("#southLat").val() + "</span></td>";
			trHtml += "<td><span>" + $("#westLng").val() + "</span></td>";
			trHtml += "<td><span>" + $("#eastLng").val() + "</span></td>";
			trHtml += "<td><span>" + $("#x").val() + "</span></td>";
			trHtml += "<td><span>" + $("#y").val() + "</span></td>";
			trHtml += "<td><span>" + $("#z").val() + "</span></td>";
			trHtml += "<td><span>" + $("#k").val() + "</span></td>";
			trHtml += "<td><span>" + $("#xt").val() + "</span></td>";
			trHtml += "<td><span>" + $("#yt").val() + "</span></td>";
			trHtml += "<td><span>" + $("#zt").val() + "</span></td>";
			trHtml += "<td><span>" + $("#conversionType").val() + "</span></td>";
			trHtml += "<td><span>" + $("#pt1B").val() + "</span></td>";
			trHtml += "<td><span>" + $("#pt1L").val() + "</span></td>";
			trHtml += "<td><span>" + $("#pt1H").val() + "</span></td>";
			trHtml += "<td><span>" + $("#pt1X").val() + "</span></td>";
			trHtml += "<td><span>" + $("#pt1Y").val() + "</span></td>";
			trHtml += "<td><span>" + $("#pt1Z").val() + "</span></td>";
			trHtml += "<td><span>" + $("#pt2B").val() + "</span></td>";
			trHtml += "<td><span>" + $("#pt2L").val() + "</span></td>";
			trHtml += "<td><span>" + $("#pt2H").val() + "</span></td>";
			trHtml += "<td><span>" + $("#pt2X").val() + "</span></td>";
			trHtml += "<td><span>" + $("#pt2Y").val() + "</span></td>";
			trHtml += "<td><span>" + $("#pt2Z").val() + "</span></td>";
			trHtml += "<td><span>" + $("#pt3B").val() + "</span></td>";
			trHtml += "<td><span>" + $("#pt3L").val() + "</span></td>";
			trHtml += "<td><span>" + $("#pt3H").val() + "</span></td>";
			trHtml += "<td><span>" + $("#pt3X").val() + "</span></td>";
			trHtml += "<td><span>" + $("#pt3Y").val() + "</span></td>";
			trHtml += "<td><span>" + $("#pt3Z").val() + "</span></td>";
			trHtml += "<td><span>" + $("#info").val() + "</span></td>";
			trHtml += "<td><span>" + $("#conversionProjection").val() + "</span></td>";
			trHtml += "<td><div><a href='javascript:;' onclick='addConversionParam(this);' class='btn btn-success'><i class='glyphicon glyphicon-plus'></i></a>"
				+ "<a href='javascript:;' onclick='editConversionParam(this);' class='btn btn-warning'><i class='glyphicon glyphicon-edit'></i></a>"
				+ "<a href='javascript:;' onclick='deleteConversionParam(this);' class='btn btn-danger'><i class='glyphicon glyphicon-trash'></i></a></div></td></tr>";
			window.conversionParamsTable.addRows(trHtml);
		}else{
			curRow.find("td:eq(0) span:last").text($("#conversionParamName").val());
			curRow.find("td:eq(1) span:last").text($("#conversionParamCode").val());
			curRow.find("td:eq(2) span:last").text($("#ellipoidSys").val());
			curRow.find("td:eq(3) span:last").text($("#ellipoidSys2").val());
			curRow.find("td:eq(4) span:last").text($("#north").val());
			curRow.find("td:eq(5) span:last").text($("#south").val());
			curRow.find("td:eq(6) span:last").text($("#west").val());
			curRow.find("td:eq(7) span:last").text($("#east").val());
			curRow.find("td:eq(8) span:last").text($("#northLat").val());
			curRow.find("td:eq(9) span:last").text($("#southLat").val());
			curRow.find("td:eq(10) span:last").text($("#westLng").val());
			curRow.find("td:eq(11) span:last").text($("#eastLng").val());
			curRow.find("td:eq(12) span:last").text($("#x").val());
			curRow.find("td:eq(13) span:last").text($("#y").val());
			curRow.find("td:eq(14) span:last").text($("#z").val());
			curRow.find("td:eq(15) span:last").text($("#k").val());
			curRow.find("td:eq(16) span:last").text($("#xt").val());
			curRow.find("td:eq(17) span:last").text($("#yt").val());
			curRow.find("td:eq(18) span:last").text($("#zt").val());
			curRow.find("td:eq(19) span:last").text($("#conversionType").val());
			curRow.find("td:eq(20) span:last").text($("#pt1B").val());
			curRow.find("td:eq(21) span:last").text($("#pt1L").val());
			curRow.find("td:eq(22) span:last").text($("#pt1H").val());
			curRow.find("td:eq(23) span:last").text($("#pt1X").val());
			curRow.find("td:eq(24) span:last").text($("#pt1Y").val());
			curRow.find("td:eq(25) span:last").text($("#pt1Z").val());
			curRow.find("td:eq(26) span:last").text($("#pt2B").val());
			curRow.find("td:eq(27) span:last").text($("#pt2L").val());
			curRow.find("td:eq(28) span:last").text($("#pt2H").val());
			curRow.find("td:eq(29) span:last").text($("#pt2X").val());
			curRow.find("td:eq(30) span:last").text($("#pt2Y").val());
			curRow.find("td:eq(31) span:last").text($("#pt2Z").val());
			curRow.find("td:eq(32) span:last").text($("#pt3B").val());
			curRow.find("td:eq(33) span:last").text($("#pt3L").val());
			curRow.find("td:eq(34) span:last").text($("#pt3H").val());
			curRow.find("td:eq(35) span:last").text($("#pt3X").val());
			curRow.find("td:eq(36) span:last").text($("#pt3Y").val());
			curRow.find("td:eq(37) span:last").text($("#pt3Z").val());
			curRow.find("td:eq(38) span:last").text($("#info").val());
			curRow.find("td:eq(39) span:last").text($("#conversionProjection").val());
		}
		removeDialog();
	});
}

function deleteConversionParam(sender){
	var conversionParamId = $(sender).closest("tr").attr("id");
	var conversionParamName = $(sender).closest("tr").find("td:first span:last").text();
	myConfirm("确实要删除"+conversionParamName+"吗？",function(){
		var url = CONTEXT_PATH + "/conversionParam/deleteConversionParam";
		var params = {conversionParamId:conversionParamId};
		jQuery.post(url, params, function(data) {
			if(data.success){
				window.conversionParamsTable.deleteRow(conversionParamId);
			}else{
				myAlert(data.message);
			}
		});
	});
}

function selectConversionProjection(){
	var dom = $("<div fkFieldCode='conversionProjection'/>");
	var url = CONTEXT_PATH + "/conversionProjection/selectConversionProjection";
	dom.load(url,null,function(){
		dialog({
			title : "选择对应转换投影",
			content : dom,
			id : "conversionProjection"
		}).showModal();
	});
}
