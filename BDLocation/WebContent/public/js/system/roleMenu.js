$(function(){
	
});

function setCheck() {
	var zTree = $.fn.zTree.getZTreeObj("menuTree");
	py = $("#py").prop("checked")? "p":"";
	sy = $("#sy").prop("checked")? "s":"";
	pn = $("#pn").prop("checked")? "p":"";
	sn = $("#sn").prop("checked")? "s":"";
	type = { "Y":py + sy, "N":pn + sn};
	zTree.setting.check.chkboxType = type;
}

var roleTree;
var params = {};
var roleNodes;
var roleSetting = {
		view: {
			dblClickExpand: false,
			showLine: true,
			selectedMulti: false
		},
		callback: {
			onCheck: cTreeOnCheck,
			onClick: cTreeOnClick
		},
		check: {
			chkStyle: "radio",
			enable: true.
			radioType = "all"
		},
		data: {
			key:{
				title: "roleName",
				name: "roleName"
			},
			simpleData: {
				enable:true,
				idKey: "roleId",
				pIdKey: "pId",
				rootPId: ""
			}
		}
		
};
var menuTree;
var menuNodes;
var initCheckedNodes = null; //角色菜单树初始选择的节点
var initCheckedMenus = null;
var nodeList = [];
var menuSetting = {
		view: {
			dblClickExpand: false,
			showLine: true,
			selectedMulti: false,
			fontCss: getFontCss
		},
		callback: {
			onClick: pTreeOnClick
		},
		check: {
			chkStyle: "checkbox",
			enable: true
		},
		data: {
			key:{
				title: "menuName",
				name: "menuName"
			},
			simpleData: {
				enable:true,
				idKey: "menuId",
				pIdKey: "parentId",
				rootPId: ""
			}
		}	
};


var menuCheckedNow;//用于保存筛选前选中的结点
$(document).ready(function(){
	 $.ajax({  
	        async : false,  
	        cache:false,  
	        type: 'POST',  
	        dataType : "json",  
	        url: CONTEXT_PATH+"/role/getRoles",  
	        error: function () {//请求失败处理函数  
	        	myAlert('获取角色数据失败');  
	        },  
	        success:function(data){ //请求成功后处理函数。
	        	for(var i=0; i<data.length; i++) {
	        		data[i].iconSkin = 'user';
	        	}
	        	roleNodes = [{id: 1, pId: 0,roleName:"角色", iconOpen:CONTEXT_PATH+"/public/js/lib/zTree_v3/css/zTreeStyle/img/diy/1_open.png", iconClose:CONTEXT_PATH+"/public/js/lib/zTree_v3/css/zTreeStyle/img/diy/1_close.png",nocheck:true,open: true,children:data}];
	        }  
	    });  
	 roleTree = $.fn.zTree.init($("#roleTree"), roleSetting, roleNodes);
	 $.ajax({  
	        async : false,  
	        cache:false,  
	        type: 'POST',  
	        dataType : "json",  
	        url: CONTEXT_PATH+"/menu/getMenus",//请求的action路径  
	        error: function () {//请求失败处理函数  
	        	myAlert('获得菜单数据失败');  
	        },  
	        success:function(data){ //请求成功后处理函数。	
	        	menuNodes = data;
	        }  
	    });
	 menuTree = $.fn.zTree.init($("#menuTree"), menuSetting, menuNodes);
	 setCheck();
	 $("#py").bind("change", setCheck);
	 $("#sy").bind("change", setCheck);
	 $("#pn").bind("change", setCheck);
	 $("#sn").bind("change", setCheck);
	 menuTree.expandAll(true);

	 //监听菜单筛选框的内容变化
	 $('#menuTreeName').bind('input propertychange', function() {
	 		updateNodes(false);
		 	menuCheckedNow = unionList(menuCheckedNow,menuTree.getCheckedNodes());
		    var value = $('#menuTreeName').val();
		    nodeList = menuTree.getNodesByParamFuzzy('menuName', value);
		    nodes = menuTree.getNodes();
		    
		    var tempList = [];
		    for(var i=0; i<menuCheckedNow.length; i++) {
		    	var node = menuCheckedNow[i];
		    	if(!isExisted(nodeList, node)) {
		    		tempList.push(node);
		    	}
		    }
		    menuCheckedNow = tempList; //暂存筛选前选中的点 
		    if(value === "") {
		    	return;
		    }   
		    updateNodes(true);
	 });
	 
	 //监听角色筛选框的内容变化
	 $('#roleTreeName').bind('input propertychange', function() {
		    var value = $('#roleTreeName').val();
		    nodeList = roleTree.getNodesByParamFuzzy('roleName', value);
		    nodes = roleTree.getNodes();
		    roleTree.hideNodes(nodes[0].children);
		    roleTree.showNodes(nodeList);
	 });
});

//更新节点
function updateNodes(highlight) {
	for( var i=0, l=nodeList.length; i<l; i++) {
		nodeList[i].highlight = highlight;
		menuTree.updateNode(nodeList[i]);
	}
}
//设置节点字体样式
function getFontCss(treeId, treeNode) {
	return (!!treeNode.highlight) ? {color:"#FF0000", "font-weight":"bold"} : {background:"#FFFFFF",color:"#333", "font-weight":"normal"};
}

var expandrole = true;
var showAuthorizeOnly = false;
/**
 * 选中一个角色显示该角色下的所有菜单
 * @param event
 * @param treeId
 * @param treeNode
 */
function cTreeOnCheck(event, treeId, treeNode) {
	$("#menuTreeName").val("");
	var value = $('#menuTreeName').val();
	menuCheckedNow = undefined;
	nodeList = menuTree.getNodesByParamFuzzy('menuName', value);
	updateNodes(false);
	nodes = menuTree.getNodes();
    menuTree.showNodes(nodes[0].children);
	if(treeNode.level === 0) {
		initCheckedNodes = null;
		roleTree.expandAll(!expandrole);
		expandrole = !expandrole;
		return;
	}
	menuTree.checkAllNodes(false);
	
	if(!treeNode.checked) {
		return;
	}
	var roleId = treeNode.roleId;
	$.ajax({  
        async : false,  
        cache : false,
        type: 'POST',  
        dataType : "json",
        data: {"roleId":roleId},
        url: CONTEXT_PATH+"/roleMenu/queryRoleMenus",//请求的action路径  
        error: function () {//请求失败处理函数  
        	myAlert('获得角色菜单数据失败');  
        },  
        success:function(data){ //请求成功后处理函数。
        	for(var i=0; i<data.length; i++) {
        		var nodes = menuTree.getNodeByParam("menuId",data[i].menu.menuId,null);
        		if(nodes != null) {
        			menuTree.checkNode(nodes,true,false);
        		}
        	}
        	initCheckedNodes = menuTree.getCheckedNodes();//获取角色当前菜单数据 	
        }  
    });
	
	if(showAuthorizeOnly) {
		menuTree.hideNodes(nodes[0].children);
	    menuTree.showNodes(initCheckedNodes);
	}
}

/**
 * 单击角色树节点时，勾选相应节点
 * @param event
 * @param treeId
 * @param treeNode
 */
function cTreeOnClick(event, treeId, treeNode) {
	roleTree.checkNode(treeNode, true, true);
	cTreeOnCheck(event, treeId, treeNode);
}

/**
 * 单击菜单树节点，反选相应节点
 * @param event
 * @param treeId
 * @param treeNode
 */
function pTreeOnClick(event, treeId, treeNode) {
	menuTree.checkNode(treeNode, !treeNode.checked, true);
}

function saveRoleMenu(){
	var nodesRole = roleTree.getCheckedNodes();
	var nodesMenu = unionList(menuCheckedNow, menuTree.getCheckedNodes());//将筛选前后选中的点进行合并
	if(nodesRole.length === 0) {
		myAlert("请选择一个角色");
		return;
	}
	
	var addNodeList = subList(nodesMenu, initCheckedNodes); //增加的节点列表
	var delNodeList = subList(initCheckedNodes, nodesMenu); //删除的节点列表
	if((null === addNodeList && null === delNodeList) || (addNodeList.length == 0 && delNodeList.length == 0) ) {
		myAlert("未改变授权");
		return;
	}
	
	var url = CONTEXT_PATH + "/roleMenu/saveRoleMenu";
	var params = {"roleId":nodesRole[0].roleId,addNodeList:addNodeList,delNodeList:delNodeList};
	jQuery.post(url, params, function(data) {
		if(data.success){
			myAlert(globalSaveSuccessTip);
			initCheckedNodes = nodesMenu;//保存成功后将现有选中节点集合作为初始选中节点集合
			return;
		}else{
			myAlert(data.message);
		}
	});
};

//合并两个集合
function unionList(firstNodeList,secondNodeList) {
	if(firstNodeList === undefined){
		return secondNodeList;
	}
	
	var unionList = [];
	for(var i=0; i<firstNodeList.length; i++) {
		unionList.push(firstNodeList[i]);
	}
	
	for(var j=0; j<secondNodeList.length; j++) {
		var node = secondNodeList[j];
		if(!isExisted(firstNodeList,node)){
			unionList.push(node);
        }
	}
	return unionList;
};

//返回firstNodeList中在secondNodeList中不存在的项
function subList(firstNodeList,secondNodeList){
    var subList = [];
    for(var i=0; i<firstNodeList.length; i++){
        var node = firstNodeList[i];
        if(!isExisted(secondNodeList,node)){
        	if(node.menuId != undefined) {
        		subList.push(node.menuId);
        	}    
        }
    };
    return subList;
};

//node在nodeList中是否存在
function isExisted(nodeList,node){
    var r = false;
    for(var i=0; i<nodeList.length; i++){
        var item = nodeList[i];
        if(node.menuId == item.menuId){
            r = true;
            break;
        }
    }
    return r;
};

//取消点授权勾选改变
function cancelSelect() {
	menuTree.checkAllNodes(false);
	for (var i=0, l=initCheckedNodes.length; i < l; i++) {
		if(!initCheckedNodes[i].halfCheck) {
			menuTree.checkNode(initCheckedNodes[i], true, true);
		}
	}
};