package com.cnten.bdlocation.forum.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cnten.bdlocation.forum.service.ForumService;
import com.cnten.platform.dao.Page;
import com.cnten.platform.web.SuccessOrFailure;
import com.cnten.po.Post;
import com.cnten.po.PostUser;
import com.cnten.po.ReplyPost;

@Controller
@RequestMapping("/forum")
public class ForumController {
	@Autowired
	private ForumService forumService;
/**
 * 论坛的所有相关跳转
 * 
 */
	
	//社区登录
	@RequestMapping("/forumLogin")
	public void forumLogin(){}
		
		
	//进入论坛首页
	@RequestMapping(value="/forumIndex")
	public void forumIndex(){}
	
	//跳转到论坛界面
	@RequestMapping("/showForum")
	public void showForum(){
		
		
	}
	
	//跳转到版块
	@RequestMapping("/showBoard")
	public void showBoard(String boardId,Model model){
		
		model.addAttribute("boardId",boardId);
	}
	
	//跳转到发帖界面
	@RequestMapping("/showSendPost")
	public void showDoMinePost(HttpServletRequest request,Model model){
		model.addAttribute("postUser", forumService.getPostUser(request));
	}
	
	//跳转到当前帖子
	@RequestMapping("/showPost")
	public void showPost(HttpServletRequest request,String postId,Model model){
		Map<String,Object> map = forumService.getPost(request,postId);
		model.addAttribute("map", map);
	}
	
	//查询所有跟帖
	@ResponseBody
	@RequestMapping("/showReplyedPost")
	public List<ReplyPost> showReplyedPost(String postId,Model model){
		return forumService.getReplyedPost(postId);
	}

	
/**
 * 论坛的所有相关操作
 * 
 */
	
	//查询所有主题帖
	@RequestMapping("/queryMinePosts")
	@SuppressWarnings("unchecked")
	public void getMinePosts(Integer pageIndex,Integer pageSize,Model model){
		pageSize = 5;
		Page page = forumService.getMinePostsByPage(pageIndex,pageSize);
		List<Post> posts = (List<Post>) page.getResult();
		for (Post post : posts) {
			post.setPostContent(post.getPostContent().replaceAll("<img[^>]*/>",""));  
		}
		model.addAttribute("page", page);
	}
	
	//查询当前贴的所有回复帖
	@RequestMapping("/queryReplyPosts")
	public void queryReplyPosts(ReplyPost replyPost,Integer pageIndex,Integer pageSize,Model model){
		pageSize = 5;
		if(pageIndex == null){
			pageIndex = 1;
		}
		Page page = forumService.getReplyPostsByPage(replyPost,pageIndex,pageSize);
		model.addAttribute("floor",(pageIndex-1)*pageSize);
		model.addAttribute("page", page);
	}
		
	//发主题帖
	@ResponseBody
	@RequestMapping("/doMinePost")
	public SuccessOrFailure doMinePost(HttpServletRequest request,Post post){
		forumService.savePost(request,post);
		return SuccessOrFailure.SUCCESS;
	}
	//修改主题贴
	@RequestMapping("/updateMinePost")
	public SuccessOrFailure updateMinePost(){
		return null;
	}
	//删除主题贴
	@RequestMapping("/deleteMinePost")
	public SuccessOrFailure deleteMinePost(String postId){
		
		return null;
	}
	//发回复贴
	@ResponseBody
	@RequestMapping(value="/doReplyPost", method = RequestMethod.POST)
	public SuccessOrFailure replyPost(HttpServletRequest request,ReplyPost replyPost){
			forumService.saveReplyPost(request,replyPost);
			return SuccessOrFailure.SUCCESS;
		
	}
	//删除回复贴
	@RequestMapping("/deleteReplyPost")
	public SuccessOrFailure deleteReplyPost(ReplyPost replyPost){
		
		return null;
	}
	
	//查询新手上路的帖子
	@RequestMapping("/queryBoardPost")
	public void getPostGuide(String boardId,Integer pageIndex,Integer pageSize,Model model){
		HashMap<String,Object> params = new HashMap<String,Object>();
		pageSize = 5;
		Page page = forumService.getBoardPost(boardId,pageIndex, pageSize);
		Long todayPost = forumService.getTodayPost();
		Long totalGuidePost = forumService.getTotalGuidePost(boardId);
		params.put("page", page);
		params.put("todayPost", todayPost);
		params.put("totalGuidePost", totalGuidePost);
		model.addAllAttributes(params);
	}
		
	//搜索（帖子主题）
	@RequestMapping("/querySubject")
	public void getPostSubject(Post post,Integer pageIndex,Integer pageSize,Model model){
		pageSize = 5;
		Page page = forumService.getPostBySubject(post, pageIndex, pageSize);
		model.addAttribute(page);
	}
	
	//登录信息简示
	@ResponseBody
	@RequestMapping("/header")
	public SuccessOrFailure getPostUserBasic(HttpServletRequest request){
		PostUser postUser = forumService.getPostUser(request);
		return SuccessOrFailure.SUCCESS(postUser);
	}

}
