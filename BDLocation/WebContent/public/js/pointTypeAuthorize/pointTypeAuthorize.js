$(function(){
	
});

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
var pointTypeTree;
var pointTypeNodes;
var initCheckedNodes = null; //点类型菜单树初始选择的节点
var pointTypeSetting = {
		view: {
			dblClickExpand: false,
			showLine: true,
			selectedMulti: false
		},
		callback: {
			onClick: pTreeOnClick
		},
		check: {
			chkStyle: "checkbox",
			enable: true,
			chkboxType: { "Y": "ps", "N": "ps" }
		},
		data: {
			key:{
				title: "pointTypeName",
				name: "pointTypeTreeName"
			},
			simpleData: {
				enable:true,
				idKey: "pointTypeId",
				pIdKey: "pId",
				rootPId: ""
			}
		}	
};


var pointTypeCheckedNow;//用于保存筛选前选中的结点
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
	        url: CONTEXT_PATH+"/pointType/getPointTypes",//请求的action路径  
	        error: function () {//请求失败处理函数  
	        	myAlert('获得节点类型数据失败');  
	        },  
	        success:function(data){ //请求成功后处理函数。
	        	pointTypeNodes = [{id: 1, pId: 0,pointTypeTreeName:"点类型",halfCheck:true,open: true,children:data}];
	        }  
	    });
	 pointTypeTree = $.fn.zTree.init($("#pointTypeTree"), pointTypeSetting, pointTypeNodes);

	 //监听筛选框的内容变化
	 $('#pointTypeTreeName').bind('input propertychange', function() {
		 	pointTypeCheckedNow = unionList(pointTypeCheckedNow,pointTypeTree.getCheckedNodes());
		    var value = $('#pointTypeTreeName').val();
		    nodeList = pointTypeTree.getNodesByParamFuzzy('pointTypeTreeName', value);
		    nodes = pointTypeTree.getNodes();
		    pointTypeTree.hideNodes(nodes[0].children);
		    pointTypeTree.showNodes(nodeList);
		    
		    var tempList = [];
		    for(var i=0; i<pointTypeCheckedNow.length; i++) {
		    	var node = pointTypeCheckedNow[i];
		    	if(!isExisted(nodeList, node)) {
		    		tempList.push(node);
		    	}
		    }
		    pointTypeCheckedNow = tempList; //暂存筛选前选中的点
		    
		    console.log(pointTypeCheckedNow);
	 });
});

var expandCompany = true;
var showAuthorizeOnly = false;
/**
 * 选中一个企业显示已授权的点类型
 * @param event
 * @param treeId
 * @param treeNode
 */
function cTreeOnCheck(event, treeId, treeNode) {
	$("#pointTypeTreeName").val("");
	pointTypeCheckedNow = undefined;
	nodes = pointTypeTree.getNodes();
    pointTypeTree.showNodes(nodes[0].children);
	if(treeNode.level === 0) {
		initCheckedNodes = null;
		companyTree.expandAll(!expandCompany);
		expandCompany = !expandCompany;
		return;
	}
	pointTypeTree.checkAllNodes(false);
	if(!treeNode.checked) {
		return;
	}
	var companyId = treeNode.companyId;
	$.ajax({  
        async : false,  
        cache : false,
        type: 'POST',  
        dataType : "json",
        data: {"affiliationCompanyId":companyId},
        url: CONTEXT_PATH+"/pointTypeAuthorize/queryPointTypeAuthorizes",//请求的action路径  
        error: function () {//请求失败处理函数  
        	myAlert('获得已授权点类型数据失败');  
        },  
        success:function(data){ //请求成功后处理函数。
        	for(var i=0; i<data.length; i++) {
        		var nodes = pointTypeTree.getNodeByParam("pointTypeId",data[i].affiliationPointType.pointTypeId,null);
        		if(nodes != null) {
        			pointTypeTree.checkNode(nodes,true,true);
        		}
        	}
        	initCheckedNodes = pointTypeTree.getCheckedNodes();//获取已授权的点类型数据
        }  
    });
	
	if(showAuthorizeOnly) {
		pointTypeTree.hideNodes(nodes[0].children);
	    pointTypeTree.showNodes(initCheckedNodes);
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
 * 单击点类型树节点，反选相应节点
 * @param event
 * @param treeId
 * @param treeNode
 */
function pTreeOnClick(event, treeId, treeNode) {
	pointTypeTree.checkNode(treeNode, !treeNode.checked, true);
}

function savePointTypeAuthorize(){
	var nodesCompany = companyTree.getCheckedNodes();
	var nodesPointType = unionList(pointTypeCheckedNow, pointTypeTree.getCheckedNodes());//将筛选前后选中的点进行合并
	if(nodesCompany.length === 0) {
		myAlert("请选择一个企业");
		return;
	}
	
	var addNodeList = subList(nodesPointType, initCheckedNodes); //增加的节点列表
	var delNodeList = subList(initCheckedNodes, nodesPointType); //删除的节点列表
	if((null === addNodeList && null === delNodeList) || (addNodeList.length == 0 && delNodeList.length == 0) ) {
		myAlert("未改变授权");
		return;
	}
	
	var url = CONTEXT_PATH + "/pointTypeAuthorize/savePointTypeAuthorize";
	var params = {"affiliationCompanyId":nodesCompany[0].companyId,addNodeList:addNodeList,delNodeList:delNodeList};
	jQuery.post(url, params, function(data) {
		if(data.success){
			myAlert(globalSaveSuccessTip);
			initCheckedNodes = nodesPointType;//保存成功后将现有选中节点集合作为初始选中节点集合
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
        	if(node.pointTypeId != undefined) {
        		subList.push(node.pointTypeId);
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
        if(node.pointTypeId == item.pointTypeId){
            r = true;
            break;
        }
    }
    return r;
};

//取消点授权勾选改变
function cancelSelect() {
	pointTypeTree.checkAllNodes(false);
	for (var i=0, l=initCheckedNodes.length; i < l; i++) {
		if(!initCheckedNodes[i].halfCheck) {
			pointTypeTree.checkNode(initCheckedNodes[i], true, true);
		}
	}
};

//改变仅显示授权结点复选框状态时
function showAuthorOnly() {
	if($("#showAuthor").is(':checked')) {
		showAuthorizeOnly = true;
		pointTypeTree.hideNodes(nodes[0].children);
	    pointTypeTree.showNodes(initCheckedNodes);
	} else {
		showAuthorizeOnly = false;
		pointTypeTree.showNodes(nodes[0].children);
	}
}
