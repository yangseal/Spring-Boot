<script type="text/javascript" src="${rc.contextPath}/public/js/baseStation/baseStation.js"></script>
<form id="baseConstructCheckForm" class="form-horizontal">
<input type="hidden" id="baseConstructId" name="baseConstructId" value="${baseConstruct.baseConstructId!}" />
	<div class="form-group">
		<label id="checkOpinion" for="checkOpinion" class="col-sm-2 control-label">验收意见</label>
		<div class="col-sm-7">
			<textarea class="form-control" name='checkOpinion' rows="3">${baseConstruct.checkOpinion!}</textarea>
		</div>
	</div>
</form>	

<#if !RequestParameters['isQuery']?? || RequestParameters['isQuery'] != 'true'>
	<#if baseConstruct?? && baseConstruct.checkState?? && baseConstruct.checkState!='YYS'>
		<div id="footer" style="text-align:center">
			<a  class="btn btn-success" onclick="baseCheckApprove('YES');">
				<i class="glyphicon glyphicon-ok"></i>
				<span>通过</span>
			</a>
			<a  class="btn btn-danger " onclick="baseCheckApprove('NO');">
				<i class="glyphicon glyphicon-remove"></i>
				<span>拒绝</span>
			</a>
		</div>
	</#if>
</#if>