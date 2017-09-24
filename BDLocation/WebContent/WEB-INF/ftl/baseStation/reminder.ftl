/**	后台  常用操作 用法  */
1. 弹出框模式
function doActive(sender){
	
	var checkbox = $("input[type='checkbox']:checked",$("#corsActivesTable"));
	if(checkbox && checkbox.length != 1 ) {
		myAlert("请选择一条数据");
		return;
	}
	
	var entityId = $(checkbox[0]).closest('tr').attr('entityId'),
		sender = $(checkbox[0]).closest('tr').attr('corsAccountType'),
		url = CONTEXT_PATH + "/corsActive/showAccounts?doAction="+sender+"&activeId="+entityId+"&corsActiveType="+sender,
		params = {corsActiveId:entityId};
		dom = $("<div/>");
		dom.load(url,params,function(){
			dialog({
				title : "账号信息",
				content : dom,
				width:1200
			}).showModal();
		});
}
2.保存案例
function saveProUser(){
	if(!validateForm("proUserForm")){
		return;
	}
	var url = CONTEXT_PATH + "/baseStation/provider/saveProUser";
	var params = $("#proUserForm").serialize();
	jQuery.post(url, params, function(data) {
		if(data.success){
			var opener = window.top.getOpener();
			opener.refreshPage("providerUserForm","providerUserDiv");
			if(!$("#baseProviderUserId").val())
				$("#baseProviderUserId").val(data.message);
			myAlert(globalSaveSuccessTip);
		}else{
			myAlert(data.message);
		}
	});
}

3.后台使用视图封装对象方式：
	public List<OamAreaVO> getMonitorOamAreaVOs() {
		String hql = "select new com.cnten.vo.OamAreaVO(a.oamAreaId,a.oamAreaName,a.longitude,a.latitude,"
				+ "(select count(oamBaseStationId) from OamBaseStation where isDelete is null and oamArea.oamAreaId=a.oamAreaId and isEffectivity='1' and buildStage='1'),"
				+ "(select count(oamBaseStationId) from OamBaseStation where isDelete is null and oamArea.oamAreaId=a.oamAreaId and isEffectivity='1' and buildStage='1' and (state is null or state='1')),"
				+ "0) from OamArea a where a.isDelete is null and exists(select 1 from OamBaseStation s where s.isDelete is null and s.oamArea.oamAreaId=a.oamAreaId and s.isEffectivity='1' and s.buildStage='1')";
		return commonDAO.queryListByVariableParam(hql);
	}

4.spring时间格式化方法
	@InitBinder
	protected void initBinder(HttpServletRequest request, ServletRequestDataBinder binder) throws Exception {
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		CustomDateEditor editor = new CustomDateEditor(df, true);
		binder.registerCustomEditor(Date.class, editor);
	}