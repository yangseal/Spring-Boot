(function($) {
	function initFileInput(_self,_option){
		/*具体文件上传规则查看jquery.fileupload-validate.js*/
		_self.find(":file").fileupload({
			url : CONTEXT_PATH + "/attachment/upload",
			formData : _option,
			dataType: 'json',
			maxFileSize : (!!_option.rules) ? _option.rules.maxFileSize : undefined,
			minFileSize : (!!_option.rules) ? _option.rules.minFileSize : undefined,
			acceptFileTypes : (!!_option.rules) ? _option.rules.acceptFileTypes : undefined,		
			maxNumberOfFiles : (!!_option.rules) ? _option.rules.maxNumberOfFiles : undefined,
			processfail: function (e, data) {
	            if(data.files.error){
//	            	myAlert(data.files[0].error);
	            	myAlert("不支持上传文件格式");
	            }
	        },
	        done: function (e, data) {
	            if(data.result.success){
	            	_self.myFileUpload(_option);
	            }else{
	            	myAlert(data.result.message);
	            }
	        }
		});
	}
	
	function initDeleteButton(_self,_option){
		_self.find("#deleteAttachment").click(function(){
//			var attachmentId = getSelectedEntityIdByAttach(_self);
			var attachmentId = getSelectedEntityId("attachmentsTable");
			if(!attachmentId){
				myAlert("请选择待删除附件");
				return;
			}
			myConfirm(globalDeleteTip,function(){
				var url = CONTEXT_PATH + "/attachment/deleteAttachment";
				var params = {attachmentId:attachmentId};
				jQuery.post(url, params, function(data) {
					if(data.success){
						_self.myFileUpload(_option);
					}else{
						myAlert(data.message);
					}
				});
			});
		});
	}
	
	$.fn.myFileUpload = function(option) {
		var _self = this;
		var url = CONTEXT_PATH + "/attachment/showAttachments";
		this.load(url,option,function(){
			initFileInput(_self, option);
			initDeleteButton(_self, option);
		});
	};      
})(jQuery);