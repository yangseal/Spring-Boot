$(function(){
	refreshPage("corsContractShowForm","corsContractShowDiv",0);
	Location.init(["","",0,0,$("#corsContractCusName").val()], $('#corsContractShowForm'));
	validateRealTime('corsContractShowForm');
});

function  addCorsContract(){
	showCorsContract();
}

function editCorsContract(){
	if(getSelectedEntityIdForOne("corsContractTable")){
		var entityId = getSelectedEntityIdForOne("corsContractTable");
		showCorsContract(entityId);
	}
	return;
}


function deleteCorsContract(){
	var corsContractIds = getCheckedEntityIds("corsContractTable");
	if(!corsContractIds){
		myAlert("请勾选待删除数据");
		return;
	}	
	myConfirm(globalDeleteTip,function(){
			var url = CONTEXT_PATH + "/corsContract/deleteCorsContract";
			var params = {corsContractIds:corsContractIds};
			jQuery.post(url, params, function(data) {
				if(data.success){
					refreshPage("corsContractShowForm","corsContractShowDiv");
				}else{
					myAlert(data.message);
				}
			});
		});
}
	

function showCorsContract(corsContractId,isQuery)
{
	var url = CONTEXT_PATH+"/corsContract/addCorsContract";
	var title = "新增账号合同";
	if(corsContractId){
		title = "修改账号合同";
		url += "?corsContractId="+corsContractId;
	}
	if(isQuery){
		title = "新增账号合同";
	}
	openTab("corsContractForm",title,url);
}

function saveCorsContract(){
	if(!validateForm("corsContractForm"))
	{
		myAlert("信息不完整,请检查无误后再次保存!");
		return false;
	}
	var url= CONTEXT_PATH + "/corsContract/saveCorsConstract";
	var params = $("#corsContractForm").serialize();
	commonPost(url, params, function(data){
		if(data.success){
			var opener = window.top.getOpener();
			opener.refreshPage("corsContractShowForm","corsContractShowDiv");
			if(!$("#corsContractId").val())
				$("#corsContractId").val(data.message);
			   myAlert(globalSaveSuccessTip);
		}else
		{
			myAlert(data.message);
		}
	});
}