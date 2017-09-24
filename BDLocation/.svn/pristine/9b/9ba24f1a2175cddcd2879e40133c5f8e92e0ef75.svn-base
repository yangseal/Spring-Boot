<!doctype html>
<html>
<head>
<#include "/head.ftl"/>
<script type="text/javascript" src="${rc.contextPath}/public/js/corsApprove/fastCorsApply.js"></script>
</head>
<body>
<form id="corsApplyForm" class="form-horizontal">
 <div class="class="form-horizontal"">
	  	  <div class="col-md-6 left">
				<div class="form-group has-feedback">
					<label id="applyCountLabel" for="applyCount" class="col-sm-3 control-label">申请公司</label>
					<div class="col-sm-6">
						<input type="text" class="form-control" id="company" style="cursor:pointer" onclick="selectCompany();" />
			    		<span class="glyphicon glyphicon-menu-hamburger form-control-feedback"></span>
			    		<input type="hidden" id="companyId" name="companyId" />
					</div>
					<label id="applyCountTip" class="control-label" style="color:red">*</label>
				</div>
				
				<div class="form-group">
					<label id="applyCountLabel" for="applyCount" class="col-sm-3 control-label">申请数量</label>
					<div class="col-sm-6">
						<input type="number" class="form-control"  id="applyCount" name="applyCount" maxlength="6" isNotNull validateExp="^[1-9]\d*$" validateTip="请输入整数数字" value="<#if corsApply??>${(corsApply.applyCount?c)!}<#else></#if>" />
					</div>
					<label id="applyCountTip" class="control-label" style="color:red">*</label>
				</div>
				<div class="form-group">
					<label id="bdDeviceAccuracyLabel" for="bdDeviceAccuracy" class="col-sm-3 control-label">入网精度</label>
					<div class="col-sm-6">
						<label class="checkbox-inline">
					    	<input type="radio" name="bdDeviceAccuracy" id="optionsRadios3" value="centimeter" nameValue="厘米" checked>厘米
					  	</label>
					  	
					  	<label class="checkbox-inline">
					    	<input type="radio" name="bdDeviceAccuracy" id="optionsRadios3" value="meter" nameValue="亚米">亚米
					  	</label>
					  	
					  	<label class="checkbox-inline">
					    	<input type="radio" name="bdDeviceAccuracy" id="optionsRadios3" value="milevel" nameValue="米级">米级
					  	</label>
					</div>
					<label id="applyCountTip" class="control-label" style="color:red">*</label>
				</div>
				<div class="form-group">
					<label id="accountTypeLabel" for="accountType" class="col-sm-3 control-label">账户类型</label>
					<div class="col-sm-6">
						<label class="checkbox-inline">
					    	<input type="radio" name="accountType" id="accountTypeTest" value="test" nameValue="测试">测试
					  	</label>
					  	<label class="checkbox-inline">
					    	<input type="radio" name="accountType" id="accountTypeFormal" value="formal" nameValue="正式" checked>正式
					  	</label>
					</div>
					<label id="applyCountTip" class="control-label" style="color:red">*</label>
				</div>
				<div class="form-group">
					<label id="accountTypeLabel" for="accountUserPeriod" class="col-sm-3 control-label">使用期限</label>
					<div class="col-sm-6" id="col-sm-6_test">
						<label class="checkbox-inline">
					    	3个月
					  	</label>
					</div>
					
					
					<div class="col-sm-6" id="col-sm-6_formal">
						<label class="checkbox-inline">
					    	<input type="radio" name="accountPeriod" id="optionsRadios3" value="1" checked>1年
					  	</label>
					  	<label class="checkbox-inline">
					   		<input type="radio" name="accountPeriod" id="optionsRadios4" value="2">2年
					  	</label>
					  	
					  	<label class="checkbox-inline">
					   		<input type="radio" name="accountPeriod" id="optionsRadios4" value="3">3年
					  	</label>
						<label class="checkbox-inline">
							其他:<input type="text" style="width:35px;margin-left:5px;" id="inputAccountPeriod" name="accountPeriod" >年	
						</label>		
					</div>
					<label id="applyCountTip" class="control-label" style="color:red">*</label>
				</div>
				
				 <div class="card-page-command">
					 <a  class="btn btn-success" onclick="addRightCard();">
						 <i class="glyphicon glyphicon-save"></i>
						 <span>添加</span>
					 </a>
			  	</div> 
		  </div>
		  
		  <div class="col-md-6 right form-inline">
		  	  	<table id="rightServiceRegionTable" class="table">
					<tr>
						<th>服务类型</th>
						<th>服务时长</th>
						<th>账号类型</th>
						<th>账号数量</th>
						<th>操作</th>
					</tr>
					
					<tr id="rightServiceRegionTr" style="display:none;">
						<td name="bdDeviceAccuracy">服务类型1</td>
						<td name="accountPeriod">服务时长</td>
						<td name="accountType">账号类型</td>
						<td name="applyCount">账号数量</td>
						<td><a onclick="delSelectList(this)" style="cursor:pointer;">删除</a></th>
					</tr>
					
				</table>  
		  	    
		  	    
		  	   <div class="card-page-command">
					<a  class="btn btn-success" onclick="saveFastCorsApply();">
						<i class="glyphicon glyphicon-save"></i>
						<span>提交</span>
					</a>
			  </div> 
		  	    
		  </div>
</div>
</form>
</body>
</html>