<!doctype html>
<html>
<head>
<#include "/head.ftl"/>
</head>

<body>
<form id="importFunc" action="${rc.contextPath}/import/uploadStakeoutTasks" method="post" enctype="multipart/form-data">
	<div style="padding-top:20px; padding-left:20px;">
		<div><h3>导入数据</h3></div><br>
		<div><input type="file" name="filename"></div><br>
		<div><input type="submit" value="提交"></div>
	</div>
</form>
</body>
</html>