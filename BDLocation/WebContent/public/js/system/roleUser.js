$(function(){
	
});

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
var userTree;
var userNodes;
var initCheckedNodes = null; //角色用户树初始选择的节点
var userSetting = {
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
				title: "userName",
				name: "userName"
			},
			simpleData: {
				enable:true,
				idKey: "userId",
				pIdKey: "pId",
				rootPId: ""
			}
		}	
};


var userCheckedNow;//用于保存筛选前选中的结点
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
	        url: CONTEXT_PATH+"/user/getUsers",//请求的action路径  
	        error: function () {//请求失败处理函数  
	        	myAlert('获得用户数据失败');  
	        },  
	        success:function(data){ //请求成功后处理函数。
	        	for(var i=0; i<data.length; i++) {
	        		data[i].iconSkin = 'user';
	        	}
	        	userNodes = [{id: 1, pId: 0,userName:"用户",halfCheck:true,open: true,children:data}];
	        }  
	    });
	 userTree = $.fn.zTree.init($("#userTree"), userSetting, userNodes);

	 //监听用户筛选框的内容变化
	 $('#userTreeName').bind('input propertychange', function() {
		 	userCheckedNow = unionList(userCheckedNow,userTree.getCheckedNodes());
		    var value = $('#userTreeName').val();
		    nodeList = userTree.getNodesByParamFuzzy('userName', value);
		    nodes = userTree.getNodes();
		    userTree.hideNodes(nodes[0].children);
		    userTree.showNodes(nodeList);
		    
		    var tempList = [];
		    for(var i=0; i<userCheckedNow.length; i++) {
		    	var node = userCheckedNow[i];
		    	if(!isExisted(nodeList, node)) {
		    		tempList.push(node);
		    	}
		    }
		    userCheckedNow = tempList; //暂存筛选前选中的点    
		    console.log(userCheckedNow);
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

var expandrole = true;
var showAuthorizeOnly = false;
/**
 * 选中一个角色显示该角色下的所有用户
 * @param event
 * @param treeId
 * @param treeNode
 */
function cTreeOnCheck(event, treeId, treeNode) {
	$("#userTreeName").val("");
	userCheckedNow = undefined;
	nodes = userTree.getNodes();
    userTree.showNodes(nodes[0].children);
	if(treeNode.level === 0) {
		initCheckedNodes = null;
		roleTree.expandAll(!expandrole);
		expandrole = !expandrole;
		return;
	}
	userTree.checkAllNodes(false);
	
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
        url: CONTEXT_PATH+"/roleUser/queryRoleUsers",//请求的action路径  
        error: function () {//请求失败处理函数  
        	myAlert('获得角色用户数据失败');  
        },  
        success:function(data){ //请求成功后处理函数。
        	for(var i=0; i<data.length; i++) {
        		var nodes = userTree.getNodeByParam("userId",data[i].user.userId,null);
        		if(nodes != null) {
        			userTree.checkNode(nodes,true,true);
        		}
        	}
        	initCheckedNodes = userTree.getCheckedNodes();//获取角色当前用户数据 	
        }  
    });
	
	if(showAuthorizeOnly) {
		userTree.hideNodes(nodes[0].children);
	    userTree.showNodes(initCheckedNodes);
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
 * 单击用户树节点，反选相应节点
 * @param event
 * @param treeId
 * @param treeNode
 */
function pTreeOnClick(event, treeId, treeNode) {
	userTree.checkNode(treeNode, !treeNode.checked, true);
}

function saveRoleUser(){
	var nodesRole = roleTree.getCheckedNodes();
	var nodesUser = unionList(userCheckedNow, userTree.getCheckedNodes());//将筛选前后选中的点进行合并
	if(nodesRole.length === 0) {
		myAlert("请选择一个角色");
		return;
	}
	
	var addNodeList = subList(nodesUser, initCheckedNodes); //增加的节点列表
	var delNodeList = subList(initCheckedNodes, nodesUser); //删除的节点列表
	if((null === addNodeList && null === delNodeList) || (addNodeList.length == 0 && delNodeList.length == 0) ) {
		myAlert("未改变授权");
		return;
	}
	
	var url = CONTEXT_PATH + "/roleUser/saveRoleUser";
	var params = {"roleId":nodesRole[0].roleId,addNodeList:addNodeList,delNodeList:delNodeList};
	jQuery.post(url, params, function(data) {
		if(data.success){
			myAlert(globalSaveSuccessTip);
			initCheckedNodes = nodesUser;//保存成功后将现有选中节点集合作为初始选中节点集合
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
        	if(node.userId != undefined) {
        		subList.push(node.userId);
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
        if(node.userId == item.userId){
            r = true;
            break;
        }
    }
    return r;
};

//取消点授权勾选改变
function cancelSelect() {
	userTree.checkAllNodes(false);
	for (var i=0, l=initCheckedNodes.length; i < l; i++) {
		if(!initCheckedNodes[i].halfCheck) {
			userTree.checkNode(initCheckedNodes[i], true, true);
		}
	}
};