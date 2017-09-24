package com.cnten.platform.system.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cnten.platform.system.service.AttachmentService;
import com.cnten.platform.web.SuccessOrFailure;
import com.cnten.po.Attachment;

@Controller
public class AttachmentController {

	@Autowired
	private AttachmentService attachmentService;
	
	@RequestMapping(value = "/attachment/showAttachments")
	public void showAttachments(Attachment attachment, Model model) {
		model.addAttribute("attachments", attachmentService.getAttachments(attachment));
	}
	
	@ResponseBody
	@RequestMapping(value = "/attachment/deleteAttachment")
	public SuccessOrFailure deleteAttachment(String attachmentId){
		try {
			attachmentService.deleteAttachment(attachmentId);
			return SuccessOrFailure.SUCCESS;
		} catch (Exception e) {
			return SuccessOrFailure.FAILURE(e.getMessage());
		}
	}
	
	@RequestMapping(value = "/attachment/download")
	public void download(String attachmentId, HttpServletResponse response){
		try{
			attachmentService.download(attachmentId, response);
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	@ResponseBody
	@RequestMapping(value = "/attachment/getAttachments")
	public SuccessOrFailure getAttachments(Attachment attachment){
		try {
			return SuccessOrFailure.SUCCESS(attachmentService.getAttachments(attachment));
		} catch (Exception e) {
			return SuccessOrFailure.FAILURE(e.getMessage());
		}
	}
	
	@ResponseBody
	@RequestMapping(value = "/attachment/upload", method = RequestMethod.POST)
	public SuccessOrFailure upload(Attachment attachment, HttpServletRequest request, HttpServletResponse response){
		try{
			attachmentService.save(attachment, request, response);
			return SuccessOrFailure.SUCCESS;
		}catch(Exception e){
			return SuccessOrFailure.FAILURE(e.getMessage());
		}
	}
	
	@RequestMapping(value = "/attachment/showPicture")
	public void showPicture(String attachmentId, boolean isThumbnail, HttpServletResponse response){
		try{
			attachmentService.showPicture(attachmentId, isThumbnail,true, response);
		}catch(Exception e){
			e.printStackTrace();
		}
	}
}
