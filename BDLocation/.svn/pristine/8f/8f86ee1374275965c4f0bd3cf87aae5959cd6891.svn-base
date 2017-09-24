package com.cnten.bdlocation.forum.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cnten.platform.dao.CommonDAO;
import com.cnten.platform.dao.Page;
import com.cnten.po.PostCollection;
import com.cnten.po.PostUser;

@Service
public class MyForumService {
	
	@Autowired
	CommonDAO commonDAO;
	@Autowired
	ForumService forumService;
	
	public Page getMyPublishedPosts(HttpServletRequest request,Integer pageIndex,Integer pageSize){
		String hql = " from Post where postUser.postUserId = :postUserId";
		HashMap<String, Object> params = new HashMap<String, Object>();
		PostUser postUser =  forumService.getPostUser(request);
		params.put("postUserId", postUser.getPostUserId());
		return commonDAO.getPage(hql, pageIndex, pageSize, params);
	}
	
	public Page getMyStoredPosts(HttpServletRequest request,Integer pageIndex,Integer pageSize){
		PostUser postUser =  forumService.getPostUser(request);
		String hql = "from Post p where p.postId in (:postId)";
		String hql1 = "from PostCollection where postUserId = :postUserId";
		HashMap<String, Object> params = new HashMap<String, Object>();
		params.put("postUserId", postUser.getPostUserId());
		List<PostCollection> postCollections = commonDAO.queryList(hql1, params);
		if(postCollections.size() == 0){
			Page page = new Page();
			page.setResult(postCollections);
			return page;
		}else{
			List<String> postUserIds = new ArrayList<String>();
			for (PostCollection postCollection : postCollections) {
				postUserIds.add(postCollection.getPostId());
			}
			params.put("postId", postUserIds);
			return commonDAO.getPage(hql, pageIndex, pageSize, params);
		}
	}
	
	public void updateUserInfo(HttpServletRequest request,PostUser postUser){
		PostUser oldPostUser =  forumService.getPostUser(request);
		oldPostUser.setPostUserNickname(postUser.getPostUserNickname());
		oldPostUser.setPostUserBirth(postUser.getPostUserBirth());
		oldPostUser.setPostUserDomicile(postUser.getPostUserDomicile());
		oldPostUser.setPostUserSex(postUser.getPostUserSex());
		oldPostUser.setPostUserIntroduction(postUser.getPostUserIntroduction());
		commonDAO.update(oldPostUser);
	}

}
