<!doctype html>
<html>
<head>
<#include "/head.ftl"/>
</head>
<body>
<script type="text/javascript" src="${rc.contextPath}/public/js/corsInit/corsInit.js"></script>
<form id="" class="form-horizontal">
	
	<div class="form-group">
		<label id="applyCountLabel" for="applyCount" class="col-sm-3 control-label">账号前缀</label>
		<div class="col-sm-7">
			<input type="text"  class="form-control" placeholder="例如北京燃气，bjrq_" id="accountPrefix" name="accountPrefix"  />
		</div>
	</div>
	
	<div class="form-group">
		<label id="applyCommentLabel" for="applyComment" class="col-sm-3 control-label">备注</label>
		<div class="col-sm-7">
			<textarea class="form-control" rows="4" id="remark" name="remark"></textarea>
		</div>
	</div>

</form>
	<div style="text-align:center">
		<a  class="btn btn-success" onclick="doneInit('<#if corsApply??>${corsApply.corsApplyId!}<#else></#if>');">
			<i class="glyphicon glyphicon-ok"></i>
			<span>生成</span>
		</a>
		<a  class="btn btn-info" onclick="clearMsg()">
			<i class="glyphicon glyphicon-minus"></i>
			<span>重置</span>
		</a>
	</div>


</body>
</html>