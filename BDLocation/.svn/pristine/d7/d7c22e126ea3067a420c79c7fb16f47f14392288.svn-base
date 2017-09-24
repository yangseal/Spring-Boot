$(function(){
	var option = {
			theme : 'vsStyle',
			expandLevel : 1
	};
	window.departmentsTable = $("#departmentsTable").treeTable(option);
});

function addDepartment(sender){
	var dom = $("<div/>");
	var url = CONTEXT_PATH + "/department/showDepartment";
	var params = {};
	if(sender){
		window.curRow = $(sender).closest("tr");
		params.parentId = curRow.attr("id");
	}else{
		window.curRow = null;
	}
	dom.load(url,params,function(){
		dialog({
			title : "新增部门",
			content : dom,
			width:$("body").width()-100
		}).showModal();
	});
}

function editDepartment(sender){
	var dom = $("<div/>");
	var url = CONTEXT_PATH + "/department/showDepartment";
	window.curRow = $(sender).closest("tr");
	var params = {departmentId:curRow.attr("id")};
	dom.load(url,params,function(){
		dialog({
			title : "编辑部门",
			content : dom,
			width:$("body").width()-100
		}).showModal();
	});
}

function saveDepartment(){
	if(!validateForm("departmentForm")){
		return;
	}
	var url = CONTEXT_PATH + "/department/saveDepartment";
	var params = $("#departmentForm").serialize();
	jQuery.post(url, params, function(data) {
		if(!data.success){
			removeDialog();
			myAlert(data.message);
			return;
		}
		var departmentId = $("#departmentId").val();
		if(!departmentId){
			var trHtml = "<tr id='" + data.message + "'";
			if(curRow){
				trHtml += " pid='" + curRow.attr("id") + "'";
			}
			trHtml += " onclick='selectEntity(this);'>";
			trHtml += "<td style='text-align:left'><span>" + $("#departmentName").val() + "</span></td>";
			trHtml += "<td><span>" + $("#departmentCode").val() + "</span></td>";
			trHtml += "<td><div><a href='javascript:;' onclick='addDepartment(this);' class='btn btn-success'><i class='glyphicon glyphicon-plus'></i></a>"
				+ "<a href='javascript:;' onclick='editDepartment(this);' class='btn btn-warning'><i class='glyphicon glyphicon-edit'></i></a>"
				+ "<a href='javascript:;' onclick='deleteDepartment(this);' class='btn btn-danger'><i class='glyphicon glyphicon-trash'></i></a></div></td></tr>";
			window.departmentsTable.addRows(trHtml);
		}else{
			curRow.find("td:eq(0) span:last").text($("#departmentName").val());
			curRow.find("td:eq(1) span:last").text($("#departmentCode").val());
		}
		removeDialog();
	});
}

function deleteDepartment(sender){
	var departmentId = $(sender).closest("tr").attr("id");
	var departmentName = $(sender).closest("tr").find("td:first span:last").text();
	myConfirm("确实要删除"+departmentName+"吗？",function(){
		var url = CONTEXT_PATH + "/department/deleteDepartment";
		var params = {departmentId:departmentId};
		jQuery.post(url, params, function(data) {
			if(data.success){
				window.departmentsTable.deleteRow(departmentId);
			}else{
				myAlert(data.message);
			}
		});
	});
}

