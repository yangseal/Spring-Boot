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

var companyTree;
var params = {};
var companyNodes;
var companySetting = {
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
				title: "companyName",
				name: "companyName"
			},
			simpleData: {
				enable:true,
				idKey: "companyId",
				pIdKey: "pId",
				rootPId: ""
			}
		}
		
};
var menuTree;
var menuNodes;
var initCheckedNodes = null; //菜单树初始选择的节点
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
	        url: CONTEXT_PATH+"/company/getCompanys",  
	        error: function () {//请求失败处理函数  
	        	myAlert('获取企业数据失败');  
	        },  
	        success:function(data){ //请求成功后处理函数。
	        	companyNodes = [{id: 1, pId: 0,companyName:"企业", iconOpen:CONTEXT_PATH+"/public/js/lib/zTree_v3/css/zTreeStyle/img/diy/1_open.png", iconClose:CONTEXT_PATH+"/public/js/lib/zTree_v3/css/zTreeStyle/img/diy/1_close.png",nocheck:true,open: true,children:data}];
	        }  
	    });  
	 companyTree = $.fn.zTree.init($("#companyTree"), companySetting, companyNodes);
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
	 
	 //监听企业筛选框的内容变化
	 $('#companyTreeName').bind('input propertychange', function() {
		    var value = $('#companyTreeName').val();
		    nodeList = companyTree.getNodesByParamFuzzy('companyName', value);
		    nodes = companyTree.getNodes();
		    companyTree.hideNodes(nodes[0].children);
		    companyTree.showNodes(nodeList);
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

var expandcompany = true;
var showAuthorizeOnly = false;
/**
 * 选中一个企业显示该企业下的所有菜单
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
		companyTree.expandAll(!expandcompany);
		expandcompany = !expandcompany;
		return;
	}
	menuTree.checkAllNodes(false);
	
	if(!treeNode.checked) {
		return;
	}
	var companyId = treeNode.companyId;
	$.ajax({  
        async : false,  
        cache : false,
        type: 'POST',  
        dataType : "json",
        data: {"companyId":companyId},
        url: CONTEXT_PATH+"/companyMenu/queryCompanyMenus",//请求的action路径  
        error: function () {//请求失败处理函数  
        	myAlert('获得企业菜单数据失败');  
        },  
        success:function(data){ //请求成功后处理函数。
        	for(var i=0; i<data.length; i++) {
        		var nodes = menuTree.getNodeByParam("menuId",data[i].menu.menuId,null);
        		if(nodes != null) {
        			menuTree.checkNode(nodes,true,false);
        		}
        	}
        	initCheckedNodes = menuTree.getCheckedNodes();//获取企业当前菜单数据 	
        }  
    });
	
	if(showAuthorizeOnly) {
		menuTree.hideNodes(nodes[0].children);
	    menuTree.showNodes(initCheckedNodes);
	}
}

/**
 * 单击企业树节点时，勾选相应节点
 * @param event
 * @param treeId
 * @param treeNode
 */
function cTreeOnClick(event, treeId, treeNode) {
	companyTree.checkNode(treeNode, true, true);
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

function saveCompanyMenu(){
	var nodesCompany = companyTree.getCheckedNodes();
	var nodesMenu = unionList(menuCheckedNow, menuTree.getCheckedNodes());//将筛选前后选中的点进行合并
	if(nodesCompany.length === 0) {
		myAlert("请选择一个企业");
		return;
	}
	
	var addNodeList = subList(nodesMenu, initCheckedNodes); //增加的节点列表
	var delNodeList = subList(initCheckedNodes, nodesMenu); //删除的节点列表
	if((null === addNodeList && null === delNodeList) || (addNodeList.length == 0 && delNodeList.length == 0) ) {
		myAlert("未改变授权");
		return;
	}
	
	var url = CONTEXT_PATH + "/companyMenu/saveCompanyMenu";
	var params = {"companyId":nodesCompany[0].companyId,addNodeList:addNodeList,delNodeList:delNodeList};
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