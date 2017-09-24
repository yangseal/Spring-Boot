//设置节点字体样式
function getFontCss(treeId, treeNode) {
	return (!!treeNode.highlight) ? {color:"#FF0000", "font-weight":"bold"} : {background:"#FFFFFF",color:"#333", "font-weight":"normal"};
}

var orgTree;
var orgNodes;
var initCheckedNodes = null; //菜单树初始选择的节点
var initCheckedMenus = null;
var nodeList = [];
var orgSetting = {
		view: {
			dblClickExpand: false,
			showLine: true,
			selectedMulti: false,
			fontCss: getFontCss,
			addHoverDom: addHoverDom,
			removeHoverDom: removeHoverDom
		},
		edit: {
			enable: true,
			editNameSelectAll: false,
			showRemoveBtn: showRemoveBtn,
			showRenameBtn: true
		},
		callback: {
			onClick: displayAdmin,
			onCheck: displayAdmin,
			onRename: pTreeOnClick,
			beforeRemove: zTreeBeforeRemove
		},
		check: {
			enable:true,
			chkboxType:{ "Y": "", "N": "" }
		},
		data: {
			key:{
				title: "orgName",
				name: "orgName"
			},
			simpleData: {
				enable:true,
				idKey: "companyOrgId",
				pIdKey: "parentOrgId",
				nodeLevel:"orgLevel",
				rootPId: ""
			}
		}	
};

var newCount = 1;
function addHoverDom(treeId, treeNode) {
	var sObj = $("#" + treeNode.tId + "_span");
	if (treeNode.editNameFlag || $("#addBtn_"+treeNode.tId).length>0) return;
	var addStr = "<span class='button add' id='addBtn_" + treeNode.tId
		+ "' title='添加' onfocus='this.blur();'></span>";
	sObj.after(addStr);
	//添加
	var addBtn = $("#addBtn_"+treeNode.tId);
	if (addBtn) addBtn.bind("click",treeNode, function(e){
		addOrEditOrg('add', e.data);
		return false;
	});
	
	//添加
	var editBtn = $("#" + treeNode.tId + "_edit");
	if (editBtn) editBtn.bind("click",treeNode, function(e){
		addOrEditOrg('edit', e.data);
		return false;
	});
	
};

function removeHoverDom(treeId, treeNode) {
	$("#addBtn_"+treeNode.tId).unbind().remove();
};

var menuCheckedNow;//用于保存筛选前选中的结点
$(document).ready(function(){ 
	 $.ajax({  
	        async : false,  
	        cache:false,  
	        type: 'POST',  
	        dataType : "json",  
	        url: CONTEXT_PATH+"/companyOrg/getCompanyOrgs",//请求的action路径  
	        error: function () {//请求失败处理函数  
	        	myAlert('获得机构数据失败');  
	        },  
	        success:function(data){ //请求成功后处理函数。	
	        	orgNodes = data;
	        }  
	    });
	 orgTree = $.fn.zTree.init($("#companyOrgTree"), orgSetting, orgNodes);
	 orgTree.expandAll(true);
//
//	 //监听菜单筛选框的内容变化
//	 $('#menuTreeName').bind('input propertychange', function() {
//	 		updateNodes(false);
//		 	menuCheckedNow = unionList(menuCheckedNow,orgTree.getCheckedNodes());
//		    var value = $('#menuTreeName').val();
//		    nodeList = orgTree.getNodesByParamFuzzy('menuName', value);
//		    nodes = orgTree.getNodes();
//		    
//		    var tempList = [];
//		    for(var i=0; i<menuCheckedNow.length; i++) {
//		    	var node = menuCheckedNow[i];
//		    	if(!isExisted(nodeList, node)) {
//		    		tempList.push(node);
//		    	}
//		    }
//		    menuCheckedNow = tempList; //暂存筛选前选中的点 
//		    if(value === "") {
//		    	return;
//		    }   
//		    updateNodes(true);
//	 });
//	 
//	 //监听企业筛选框的内容变化
//	 $('#companyTreeName').bind('input propertychange', function() {
//		    var value = $('#companyTreeName').val();
//		    nodeList = companyTree.getNodesByParamFuzzy('companyName', value);
//		    nodes = companyTree.getNodes();
//		    companyTree.hideNodes(nodes[0].children);
//		    companyTree.showNodes(nodeList);
//	 });
});



//更新节点
//function updateNodes(highlight) {
//	for( var i=0, l=nodeList.length; i<l; i++) {
//		nodeList[i].highlight = highlight;
//		orgTree.updateNode(nodeList[i]);
//	}
//}


//---------------------------------------------------------------有用的部分----------------------------------------------------------------------------
function showRemoveBtn(treeId, treeNode) {
	return !treeNode.isParent && treeNode.parentOrgId;
}
/**
 * 删除节点 之前回调
 */
function zTreeBeforeRemove(treeId, treeNode) {
	var result = false;
	myConfirm("您确定删除该节点吗?",function(){
		var url = CONTEXT_PATH + "/companyOrg/delCompanyOrg",
		params = {'companyOrgId':treeNode.companyOrgId};
		commonPost(url, params, function(data){
			if(data.success){
				var companyOrgTree = $.fn.zTree.getZTreeObj("companyOrgTree");
				companyOrgTree.removeNode(treeNode);
				myAlert("删除成功");
				return;
			}
			myAlert(data.message);
				
		});
	});
	return false;
}

/**
 * 单击菜单树节点，反选相应节点
 * @param event
 * @param treeId
 * @param treeNode
 */
function pTreeOnClick(event, treeId, treeNode) {
	orgTree.cancelSelectedNode();
	orgTree.checkAllNodes(false);  		//取消以前的选中状态
	orgTree.checkNode(treeNode, !treeNode.checked, true);
}

function displayAdmin(event, treeId, treeNode){
	debugger;
	pTreeOnClick(event, treeId, treeNode);
	
	var url = CONTEXT_PATH + "/companyOrg/getAdmin",
		params = {"companyOrgId":treeNode.companyOrgId},
		modelId = $("#companyAdminTbody").attr("modelId");
	if(modelId && modelId == treeNode.companyOrgId)
		return false;
	commonPost(url,params,function(data){
		$("#companyAdminTbody").empty();
		$("#companyAdminTbody").attr("modelId",treeNode.companyOrgId);
		if(data.length){
			for (var k = 0, length = data.length; k < length; k++) {
				var temp = $("#companyAdminTemplate").clone().removeAttr("id").removeAttr("style");
				temp.attr("entityId",data[k].userId);
				temp.find("td[owe='userName']").first().text(data[k].userName);
				temp.find("td[owe='userCode']").first().text(data[k].userCode);
				temp.find("td[owe='userPwd']").first().text(data[k].password);
				$("#companyAdminTbody").append(temp);
			}
				
		}
		
	});
	
}

function addOrEditOrg(sender,param){
	var dom = $("<div/>");
	var url = CONTEXT_PATH + "/companyOrg/orgMgt/showOrg";
	var params = {};
	if(sender == 'add'){
		title = "新增机构";
		params.parentOrgId = param.companyOrgId;
		params.orgLevel = (param.orgLevel-0+1);
	}else{
		title = "编辑机构";
		params.companyOrgId  = param.companyOrgId;
	}
	dom.load(url,params,function(){
		dialog({
			title : title,
			content : dom,
			width:550
		}).showModal();
		validateRealTime('orgForm');
	});
}

/**
 * 保存组织机构
 */
function saveOrg(){
	validateForm('orgForm');
	var url = CONTEXT_PATH + "/companyOrg/orgMgt/saveOrg",
		parentOrgId = $("#parentOrgId").val(),
		companyOrgId = $("#companyOrgId").val(),
		nodeName = $("#orgName").val(),
		nodeLevel = $("#orgLevel").val(),
		params = $("#orgForm").serialize();
	commonPost(url,params,function(data){
		if(data.success){
			var companyOrgTree = $.fn.zTree.getZTreeObj("companyOrgTree");
			if(data.message){
				var parentNode = companyOrgTree.getNodeByParam("companyOrgId", parentOrgId, null);
				companyOrgTree.addNodes(parentNode, {id:data.message, companyOrgId:data.message, parentOrgId:parentOrgId, orgLevel:nodeLevel, pId:parentNode.id, orgName:nodeName});
			}else{
				var currNode = companyOrgTree.getNodeByParam("companyOrgId", companyOrgId, null);
				currNode.orgName = nodeName;
				companyOrgTree.updateNode(currNode);
			}
			removeDialog();
			myAlert("操作成功")
		}else{
			removeDialog();
			myAlert("操作失败")
		}
	});
}

/**
 * 添加 子机构管理员
 */
function addCompanyAdmin(){
	var dom = $("<div/>");
	var url = CONTEXT_PATH + "/companyOrg/orgMgt/showOrgUser";
	var params = {"companyOrgId":$("#companyAdminTbody").attr("modelId")};
	if(!params.companyOrgId){
		myAlert("请选择对应的机构");
		return false;
	}
	dom.load(url,params,function(){
		dialog({
			title : "新增管理员",
			content : dom,
			width:550
		}).showModal();
		validateRealTime('orgUserForm');
	});
}

function saveCompanyAdmin(){
	validateForm('orgUserForm');
	var url = CONTEXT_PATH + "/companyOrg/saveOrgAdmin",
		userCode = $("#userCode").val(),
		password = $("#userCode").val(),
		userName = $("#userName").val(),
		params = $("#orgUserForm").serialize();
	commonPost(url,params,function(data){
		removeDialog();
		if(data.success){
			myAlert("添加成功");
			var temp = $("#companyAdminTemplate").clone().removeAttr("id").removeAttr("style");
			temp.attr("entityId",data.message);
			temp.find("td[owe='userName']").first().text(userName);
			temp.find("td[owe='userCode']").first().text(userCode);
			temp.find("td[owe='userPwd']").first().text(password);
			$("#companyAdminTbody").append(temp);
		}
		
	});
}

/**
 * 删除 管理原账号
 * @param self
 */
function delAdmin(self){
	var url = CONTEXT_PATH +"/companyOrg/delOrgAdmin",
		params = {"userId":$(self).closest("tr").attr("entityId")};
	myConfirm("您确定删除?",function(){
		commonPost(url,params,function(data){
			debugger;
			if(data.success){
				myAlert("删除成功");
				$("tr[entityid='" + data.message + "']",$("#companyAdminTbody")).remove();
				return ;
			}
			myAlert("删除失败");
		});
	});
}
