<link rel="stylesheet" href="${rc.contextPath}/public/css/location.css"/>
<script type="text/javascript" src="${rc.contextPath}/public/js/accountView/common.js"></script>
<form  class="form-horizontal" id="CorsRegionForm">
	<div class="form-group has-feedback">
		 <label class="col-sm-2 control-label">用途</label> 
    	<div class="col-sm-8">	
    		<select class="form-control" id="taskStatus" name="taskStatus">
				<option></option>
				<option value="110">110</option>
				<option value="120">120</option>
				<option value="119">119</option>
				<option value="QJC">清洁车</option>
				<option value="ZTC">渣土车</option>
				<option value="XLJC">泄漏检测</option>
				<option value="ZNXJ">智能巡检</option>
				<option value="GCCL">工程测量</option>
			</select>
  		</div>
  	</div>
  	<input type="hidden" id="corsAccountIds" name="corsAccountIds" value="${corsAccountIds!}"/>
  	<div class="form-group">
      <label class="col-sm-2 control-label"></label>
      <div class="col-sm-8" style="text-align:center;">
	<a  class="btn btn-success" onclick="saveCorsAccoutUse();">
		<i class="glyphicon glyphicon-save"></i>
		<span>保存</span>
	</a>
	</div>
</div>
</form>




