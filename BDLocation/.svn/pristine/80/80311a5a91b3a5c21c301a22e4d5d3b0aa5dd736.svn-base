<!doctype html>
<html>
<head>
<#include "/head.ftl"/>
<script type="text/javascript" src="${rc.contextPath}/public/js/stakeoutPoint/stakeoutPoints.js"></script>
</head>
<body>
<form id="stakeoutPointsForm" action="${rc.contextPath}/stakeoutPoint/queryStakeoutPoints">
		<div>
			<input type="hidden" id="affiliationStakeoutTaskId" name="affiliationStakeoutTaskId" value="${RequestParameters["stakeoutTaskId"]!}" />
		</div>
		<div class="command-div">
			 <a style="display:none;" class="btn btn-primary" onclick="refreshPage('stakeoutPointsForm','stakeoutPointsDiv',1);">
				<i class="glyphicon glyphicon-search"></i>
    			<span>查询</span>
			</a> 
			<a  class="btn btn-info" onclick="viewStakeoutPoint();">
				<i class="glyphicon glyphicon-zoom-in"></i>
    			<span>查看</span>
			</a>
			<a  class="btn btn-primary" onclick="exportStakeoutPoints();">
				<i class="glyphicon glyphicon-log-out"></i>
    			<span>导出</span>
			</a>
			<#if !RequestParameters["isQuery"]?? || RequestParameters["isQuery"]=="">
			<a  class="btn btn-success" onclick="showStakeoutPoint();">
				<i class="glyphicon glyphicon-plus"></i>
    			<span>新增</span>
			</a>
			<a  class="btn btn-warning" onclick="editStakeoutPoint();">
				<i class="glyphicon glyphicon-edit"></i>
    			<span>编辑</span>
			</a>
			<a  class="btn btn-danger" onclick="deleteStakeoutPoint();">
				<i class="glyphicon glyphicon-trash"></i>
    			<span>删除</span>
			</a>
			</#if>
		</div>
	<div id="stakeoutPointsDiv"></div>
</form>
</body>
</html>
