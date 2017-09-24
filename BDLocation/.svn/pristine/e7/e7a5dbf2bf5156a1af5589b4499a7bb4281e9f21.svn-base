package com.cnten.bdlocation.feedback.controller;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.ServletRequestDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import com.cnten.platform.dao.Page;
import com.cnten.bdlocation.feedback.service.FeedbackService;
import com.cnten.platform.web.SuccessOrFailure;
import com.cnten.po.Feedback;

@Controller
@RequestMapping(value = "/feedback")
public class FeedbackController {

	@InitBinder
	protected void initBinder(HttpServletRequest request, ServletRequestDataBinder binder) throws Exception {
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		CustomDateEditor editor = new CustomDateEditor(df, true);
		binder.registerCustomEditor(Date.class, editor);
	}

	@Autowired
	private FeedbackService feedbackService;
	
	@RequestMapping(value = "/showFeedbacks")
	public void showFeedbacks() {
	}
	
	@RequestMapping(value = "/showFeedback")
	public void showFeedback(String feedbackId, Model model) {
		Feedback feedback = feedbackService.getFeedback(feedbackId);
		model.addAttribute("feedback", feedback);
	}
	
	@RequestMapping(value = "/queryFeedbacks")
	public void queryFeedbacks(Feedback feedback, Integer pageIndex, Integer pageSize, Model model) {
		Page page = feedbackService.getFeedbacksPage(feedback, pageIndex, pageSize);
		model.addAttribute(page);
	}
	
	@RequestMapping(value = "/selectFeedback")
	public void selectFeedback() {
	}
	
	@RequestMapping(value = "/selectFeedbacks")
	public void selectFeedbacks(Feedback feedback, Integer pageIndex, Integer pageSize, Model model) {
		Page page = feedbackService.getFeedbacksPage(feedback, pageIndex, pageSize);
		model.addAttribute(page);
	}
	
	@ResponseBody
	@RequestMapping(value = "/saveFeedback")
	public SuccessOrFailure saveFeedback(Feedback feedback){
		try {
			feedbackService.saveFeedback(feedback);
			return SuccessOrFailure.SUCCESS(feedback.getFeedbackId());
		} catch (Exception e) {
			return SuccessOrFailure.FAILURE(e.getMessage());
		}
	}
	
	@ResponseBody
	@RequestMapping(value = "/deleteFeedback")
	public SuccessOrFailure deleteFeedback(String feedbackIds){
		try {
			feedbackService.deleteFeedback(feedbackIds);
			return SuccessOrFailure.SUCCESS;
		} catch (Exception e) {
			return SuccessOrFailure.FAILURE(e.getMessage());
		}
	}
	
	@RequestMapping(value = "/exportFeedbacks")
	public void exportFeedbacks(Feedback feedback, HttpServletResponse response) {
		try {
			feedbackService.exportFeedbacks(feedback, response);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
