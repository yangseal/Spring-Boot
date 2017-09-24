//正则校验的变量
var validStringValue="";

$(function() {
    $('#validString').magicSuggest({
          placeholder:'请在此框中输入内容或下拉选择',
		  allowFreeEntries: true,
		  maxSelection: 1,
		  data: [{
                    id: 1,
                    name: '数字',
                    value: '\\\\d'
                }, {
                    id: 2,
                    name: '字母',
                    value: '[a-z]'
                }],
		 selectionStacked: true,    
         selectionRenderer: function(data){ 	//在标签里显示的值
         			if(data.id == 1 || data.id == 2){
         				validStringValue = data.value;
                    	return data.value;
         			}else{
         				validStringValue = data.name;
         				return data.name;
         			}
                }
    });
});
function saveDynamicField(){
	if(!validateForm("dynamicFieldForm")){
		return;
	}
	var url = CONTEXT_PATH + "/pointType/saveDynamicField";
	var detailValues;
	var fieldValue1 = document.getElementById("dataCode").value;
	var fieldValue2 = document.getElementById("dataName").value;
	var fieldValue3 = document.getElementById("viewType").value;
	var fieldValue4 = document.getElementById("isNotNull").value;
	var fieldValue5 = document.getElementById("isVisible").value;
	var fieldValue6 = document.getElementById("defaultValue").value;
	var fieldValue7 = document.getElementById("dictionary").value;
	var fieldValue8 = validStringValue;
	detailValues = "{"+"\"dataCode\":\""+fieldValue1+"\",\"dataName\":\""+fieldValue2+"\",\"viewType\":\""+fieldValue3+"\",\"isNotNull\":\""+fieldValue4+"\",\"isVisible\":\""+fieldValue5+"\",\"defaultValue\":\""+fieldValue6+"\",\"dictionary\":\""+fieldValue7+"\",\"validString\":\""+fieldValue8+"\"}"; 
	var pointTypeId = $("#pointTypeId").val();
	var params = {"dynamicField":detailValues,"pointTypeId":pointTypeId};
	if($.QueryString()._queryString_.indexOf('isEdit') > -1) {
		url = CONTEXT_PATH + "/pointType/editDynamicField";
	}
	jQuery.post(url, params, function(data) {
		if(data.success) {
			var opener = window.top.getOpener();
			opener.refreshPage("dynamicFieldForm","dynamicFieldsDiv");
			if($("#dataCode").val()){
				myAlert(globalSaveSuccessTip,closeTab);
				var detailValuesNew;
				var detailValuesOld = parent.$("#mainContentDiv").children("[code='pointType']")[0].contentWindow.$("#dynamicField").val();	
				if(detailValuesOld){
					detailValuesNew = "["+detailValuesOld.substring(1, detailValuesOld.length-1)+","+detailValues+"]";
				}else{
					detailValuesNew = "["+detailValues+"]";
				}
				detailValuesNew = data.message;
				parent.$("#mainContentDiv").children("[code='pointType']")[0].contentWindow.$("#dynamicField").val(detailValuesNew);
				
				return;
			}
			alert(globalSaveSuccessTip);
			opener.showDynamicField(data.message);
		}else{
			myAlert(data.message);
		}
	});
}

function saveEdit() {
	
}

function closeTab() {
	parent.closeTab("dynamicField");
}

function viewTypeChange() {
	var viewType = document.getElementById("viewType").value;
	if(viewType == "RadioGroup" || viewType == "CheckBoxGroup" || viewType == "DropDownList" || viewType == "ToggleButton") {
		$("#dictionaryDiv").removeClass("hidden");
		$("#dictionary").attr("isNotNull",true);
	} else {
		$("#dictionaryDiv").addClass("hidden");
		$("#dictionary").removeAttr("isNotNull");
		$("#dictionary").val("");
	}
}
