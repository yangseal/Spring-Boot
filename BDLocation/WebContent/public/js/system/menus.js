$(function(){
	var option = {
			theme : 'vsStyle',
			expandLevel : 1
	};
	window.menusTable = $("#menusTable").treeTable(option);
});

function addMenu(sender){
	var dom = $("<div/>");
	var url = CONTEXT_PATH + "/menu/showMenu";
	var params = {};
	if(sender){
		window.curRow = $(sender).closest("tr");
		params.parentId = curRow.attr("id");
	}else{
		window.curRow = null;
	}
	dom.load(url,params,function(){
		dialog({
			title : "新增菜单",
			content : dom,
			width:600
		}).showModal();
	});
}

function editMenu(sender){
	var dom = $("<div/>");
	var url = CONTEXT_PATH + "/menu/showMenu";
	window.curRow = $(sender).closest("tr");
	var params = {menuId:curRow.attr("id")};
	dom.load(url,params,function(){
		dialog({
			title : "编辑菜单",
			content : dom,
			width:600
		}).showModal();
	});
}

function saveMenu(){
	if(!validateForm("menuForm")){
		return;
	}
	var url = CONTEXT_PATH + "/menu/saveMenu";
	var params = $("#menuForm").serialize();
	jQuery.post(url, params, function(data) {
		if(!data.success){
			removeDialog();
			alert(data.message);
			return;
		}
		if(data.message){
			var trHtml = "<tr id='" + data.message + "'";
			if(curRow){
				trHtml += " pid='" + curRow.attr("id") + "'";
			}
			var action = $("#action").val();
			if( action.length > 50) {
				action = action.substring(0,50)+'...';
			}
			trHtml += "><td style='text-align:left'><span>" + $("#menuName").val()
				+ "</span></td><td><span>" + $("#menuCode").val()
				+ "</span></td><td><span>" + action
				+ "</span></td><td><span>" + $("#menuOrder").val()
				+ "</span></td><td><div><a href='javascript:;' onclick='addMenu(this);' class='btn btn-success'><i class='glyphicon glyphicon-plus'></i></a>"
				+ "<a href='javascript:;' onclick='editMenu(this);' class='btn btn-warning'><i class='glyphicon glyphicon-edit'></i></a>"
				+ "<a href='javascript:;' onclick='deleteMenu(this);' class='btn btn-danger'><i class='glyphicon glyphicon-trash'></i></a></div></td></tr>";
			window.menusTable.addRows(trHtml);
		}else{
			curRow.find("td:first span:last").text($("#menuName").val());
			curRow.find("td:eq(1) span:last").text($("#menuCode").val());
			curRow.find("td:eq(2) span:last").text(action);
			curRow.find("td:eq(3) span:last").text($("#menuOrder").val());
		}
		removeDialog();
	});
}

function deleteMenu(sender){
	var menuId = $(sender).closest("tr").attr("id");
	var menuName = $(sender).closest("tr").find("td:first span:last").text();
	myConfirm("确实要删除"+menuName+"吗？",function(){
		var url = CONTEXT_PATH + "/menu/deleteMenu";
		var params = {menuId:menuId};
		jQuery.post(url, params, function(data) {
			if(data.success){
				window.menusTable.deleteRow(menuId);
			}else{
				alert(data.message);
			}
		});
	});
}