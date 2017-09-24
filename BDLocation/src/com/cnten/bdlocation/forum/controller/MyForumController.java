package com.cnten.bdlocation.forum.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cnten.bdlocation.constants.ForumConsts;
import com.cnten.bdlocation.forum.service.ForumService;
import com.cnten.bdlocation.forum.service.MyForumService;
import com.cnten.platform.dao.Page;
import com.cnten.platform.web.SuccessOrFailure;
import com.cnten.po.PostUser;

@Controller
@RequestMapping("/forum/myForum")
public class MyForumController {
	
	@Autowired
	private ForumService forumService;
	@Autowired
	private MyForumService myForumService;
	
	@RequestMapping("/myForumNav")
	public void getMyBasic(HttpServletRequest request, Model model){
		PostUser postUser = forumService.getPostUser(request);
		model.addAttribute("postUser", postUser);
	}
	
	//我发表的
	@RequestMapping("/myPublished")
	public void getMyPublished(HttpServletRequest request,Integer pageIndex,Integer pageSize,Model model){
		pageSize = ForumConsts.PAGE_SIZE;
		Page page = myForumService.getMyPublishedPosts(request, pageIndex, pageSize);
		model.addAttribute(page);
	}
	
	//我收藏的
	@RequestMapping("/myCollections")
	public void getMyStored(HttpServletRequest request,Integer pageIndex,Integer pageSize,Model model){
		pageSize = ForumConsts.PAGE_SIZE;
		Page page = myForumService.getMyStoredPosts(request, pageIndex, pageSize);
		model.addAttribute(page);
	}
	
	//基本资料
	@RequestMapping("/myBasicInfo")
	public void getBasicInfo(HttpServletRequest request,Model model){
		PostUser postUser = forumService.getPostUser(request);
		model.addAttribute("postUser", postUser);
	}
	
	//我的积分
	@RequestMapping("/myPoints")
	public void getMyPoints(HttpServletRequest request,Model model){
		PostUser postUser = forumService.getPostUser(request);
		model.addAttribute("postUser", postUser);
	}
	
	//保存基本资料
	@ResponseBody
	@RequestMapping("/updateUserInfo")
	public SuccessOrFailure updateUserInfo(HttpServletRequest request,PostUser postUser) {
		
		 myForumService.updateUserInfo(request,postUser);
		 return SuccessOrFailure.SUCCESS;
	}

}
