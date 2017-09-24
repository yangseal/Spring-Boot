<#if (!RequestParameters["isQuery"]?? || RequestParameters["isQuery"] == "") && RequestParameters["entityId"]?? && RequestParameters["entityId"] != "">
<a class="btn btn-success" style="position:relative;">
    <i class="glyphicon glyphicon-plus"></i>
    <span>上传附件...</span>
    <input type="file" name="files[]" multiple class="btn" style="position:absolute;top:0;right:0;opacity:0;margin:0" />
</a>
<a class="btn btn-danger" id="deleteAttachment">
    <i class="glyphicon glyphicon-trash"></i>
    <span>删除附件</span>
</a>
</#if>
<table id="attachmentsTable" class="table">
	<tr>
		<th>附件名称</th>
		<th>上传时间</th>
		<th>上传人</th>
		<th>缩略图</th>
	</tr>
	<#if attachments??>
	<#list attachments as attachment>
	<tr entityId="${attachment.attachmentId!}" onclick="javascript:selectEntity(this);">
		<td><a href="${rc.contextPath}/attachment/download?attachmentId=${attachment.attachmentId!}">${attachment.attachmentName!}</a></td>
		<td>${attachment.createDate!}</td>
		<td><#if attachment.user??>${attachment.user.userName!}</#if></td>
		<td><#if attachment.attachmentType?? && attachment.attachmentType=="PICTURE"><img src="${rc.contextPath}/attachment/showPicture?attachmentId=${attachment.attachmentId!}&isThumbnail=true" style="cursor:pointer" onclick="showPicture('${attachment.attachmentId!}');"/></#if></td>
	</tr>
	</#list>
	</#if>
</table>
<script type="text/javascript">
	function showPicture(attachmentId){
		var html = "<img src='${rc.contextPath}/attachment/showPicture?attachmentId=";
		html += attachmentId;
		html += "'/>";
		var dom = $(html).appendTo("body");
		dom.load(function(){
			var width = dom.width();
			var height =dom.height();
			var maxWidth = $("body").width();
			var maxHeight = $("body").height()-80;
			var Ratio = 1;
			var wRatio = maxWidth / width;
			var hRatio = maxHeight / height;
			if (wRatio<1 || hRatio<1){
				Ratio = (wRatio<=hRatio?wRatio:hRatio);
			}
			width = width * Ratio;
			height = height * Ratio;
			dom.css("width", width);
			dom.css("height",height);
		  	dialog({
				title: "查看图片",
				content: dom
			}).showModal();
		});
	}
</script>