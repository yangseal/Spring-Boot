<form id="myApplySuggestionForm" class="form-horizontal" style="width:500px;">
	<#if (common.isSystemUser || common.isCaiWuUser) && RequestParameters["action"] == "true">
	<div class="form-group">
		<label id="contractNoLabel" for="contractNo" class="col-sm-3 control-label">合同编号</label>
		<div class="col-sm-6">
			<input type="text" class="form-control" id="contractNo" name="contractNo" isNotNull maxlength="30"/>
		</div>
		<label id="contractNoTip" class="control-label" style="color:red">*</label>
	</div>	
	<div class="form-group">
		<label id="invoiceNoLabel" for="invoiceNo" class="col-sm-3 control-label">发票编号</label>
		<div class="col-sm-6">
			<input type="text" class="form-control" id="invoiceNo" name="invoiceNo" isNotNull maxlength="30"/>
		</div>
		<label id="invoiceNoTip" class="control-label" style="color:red">*</label>
	</div>
	<div class="form-group">
		<label id="applyPaymentLabel" for="applyPayment" class="col-sm-3 control-label">是否到账</label>
		<div class="col-sm-6">
			<select class="form-control" id="applyPayment" name="applyPayment" >
				<option value="paid">已付款</option>
				<option value="unpaid">未付款</option>
			</select>
		</div>
	</div>	
	<div class="form-group">	
		<label id="accountPrefixLabel" for="accountPrefix" class="col-sm-3 control-label">账号前缀</label>
		<div class="col-sm-6">
			<input type="text" class="form-control" id="accountPrefix" name="accountPrefix" isNotNull maxlength="14"/>
		</div>
		<label id="accountPrefixTip" class="control-label" style="color:red">*</label>
	</div>
	<div class="form-group has-feedback">
		<label id="effectiveDateLabel" for="effectiveDate" class="col-sm-3 control-label">起效日期</label>
		<div class="col-sm-6">
			<input type="text" class="form-control" id="effectiveDate" name="effectiveDate" isNotNull onclick="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm:ss'});"/>
			<span class="glyphicon glyphicon-menu-hamburger form-control-feedback"></span>
		</div>
		<label id="effectiveDateTip" class="control-label" style="color:red">*</label>
	</div>	
	<div class="form-group has-feedback">	
		<label id="exprieDateLabel" for="exprieDate" class="col-sm-3 control-label">失效日期</label>
		<div class="col-sm-6">
			<input type="text" class="form-control" id="exprieDate" name="exprieDate" isNotNull onclick="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm:ss'});"/>
			<span class="glyphicon glyphicon-menu-hamburger form-control-feedback"></span>
		</div>
		<label id="exprieDateTip" class="control-label" style="color:red">*</label>
	</div>
	<input type="hidden" id="financialHandler" name="financialHandler.userId" value="<#if CURRENT_USER??>${CURRENT_USER.userId!}</#if>" />
	</#if>
	<div class="form-group">
		<label id="applyCommentLabel" for="applyComment" class="col-sm-3 control-label">审批意见</label>
		<div class="col-sm-6">
			<textarea class="form-control" rows="3" cols="30" id="applyComment" name="applyComment" ></textarea>
		</div>
		<label id="applyCommentTip" class="control-label" style="color:red"></label>
	</div>
	<input type="hidden" id="corsApplyId" name="corsApplyId" value='<#if RequestParameters["applyId"]??>${RequestParameters["applyId"]}</#if>' />
	<div style="text-align:right;" >
		<a  class="btn btn-info" onclick="selectCorsApplyCancel(this);">
			<i class="glyphicon glyphicon-remove"></i>
			<span>取消</span>
		</a>
		<a  class="btn btn-success" onclick="selectCorsApplyOk(this);">
			<i class="glyphicon glyphicon-ok"></i>
			<span>确定</span>
		</a>
	</div>
</form>

<script type="text/javascript">
	function selectCorsApplyOk(sender){
		if(!validateForm("myApplySuggestionForm")){
			return;
		}
		<#if !RequestParameters["action"]?? || RequestParameters["action"]=="true">
		var url = CONTEXT_PATH + "/corsApply/approval";
		<#else>
		var url = CONTEXT_PATH + "/corsApply/reject";
		</#if>
		$('.btn-success').addClass('disabled'); 
		var params = $("#myApplySuggestionForm").serialize();
		jQuery.post(url, params, function(data) {
			if(data.success){
				refreshPage("corsApplysForm","corsApplysDiv");
				var fkFieldCode = $(sender).closest("div[fkFieldCode]").attr("fkFieldCode");
				dialog.get(fkFieldCode).remove();
			}else{
			$('.btn-success').removeClass('disabled'); 
				if(data.message) {
					myAlert(data.message);
				} else {
					myAlert("输入中存在非法字符!");
				}
			}
		});
	}
	function selectCorsApplyCancel(sender){
		var fkFieldCode = $(sender).closest("div[fkFieldCode]").attr("fkFieldCode");
		dialog.get(fkFieldCode).remove();
	}
</script>