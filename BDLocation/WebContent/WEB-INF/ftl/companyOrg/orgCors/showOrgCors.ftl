<!doctype html>
<html>
<head>
<#include "/head.ftl"/>
<link rel="stylesheet" href="${rc.contextPath}/public/js/lib/zTree_v3/css/metroStyle/metroStyle.css">
<link rel="stylesheet" href="${rc.contextPath}/public/js/lib/multiselect2side/css/jquery.multiselect2side.css">
<script type="text/javascript" src="${rc.contextPath}/public/js/lib/zTree_v3/js/jquery.ztree.core.min.js"></script>
<script type="text/javascript" src="${rc.contextPath}/public/js/lib/zTree_v3/js/jquery.ztree.excheck.min.js"></script>
<script type="text/javascript" src="${rc.contextPath}/public/js/lib/zTree_v3/js/jquery.ztree.exhide.min.js"></script>
<script type="text/javascript" src="${rc.contextPath}/public/js/lib/zTree_v3/js/jquery.ztree.exedit.min.js"></script>
<script type="text/javascript" src="${rc.contextPath}/public/js/lib/multiselect2side/js/jquery.multiselect2side.js"></script>
<script type="text/javascript" src="${rc.contextPath}/public/js/companyOrg/orgCors/companyOrgCors.js"></script>
</head>
<body>
<form id="companyOrgCorsForm" class="form-horizontal">
	<div class="form-group">
        <a  class="btn btn-success" onclick="saveCompanyOrg();">
			<i class="glyphicon glyphicon-save"></i>
			<span>保存</span>
		</a>
		<a  class="btn btn-primary" onclick="cancelSelect();">
			<i class="glyphicon glyphicon-ok"></i>
    		<span>取消</span>
		</a>
	</div>

	<div class="container-fluid">
	  <div class="row">	
		<div class="col-md-5 left form-inline">
		   <ul id="companyOrgTree" name="companyOrgTree" class="pull-left ztree"></ul>
		</div>
		
		<div class="col-md-6 right">
		   <!--<ul id="companyTree" name="companyTree" class="pull-left ztree"></ul>-->
		   <div id="rightContent" class="entry">
				<select name="corsAccountMutil" id="corsAccountMutil" multiple="multiple" size="6" style="display: none; ">
					<#list blankCorsList as bCors>
						<option value="${bCors.corsAccountId!}"><font>${bCors.corsAccountCode!}</font></option>
					</#list>
				</select>
			</div>
		   
		</div>
		
	  </div>
	</div>
			
</form>
</body>
</html>