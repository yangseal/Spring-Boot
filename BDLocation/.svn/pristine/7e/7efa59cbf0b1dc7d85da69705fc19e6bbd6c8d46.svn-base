package com.cnten.bdlocation.forum.service;

import org.springframework.stereotype.Service;

import com.cnten.bdlocation.constants.ForumConsts;
import com.cnten.po.PostUser;

@Service
public class PointsService {
	
	public void getExperience(String type,PostUser postUser){
		if(type.equals(ForumConsts.POST_POINTS_FT) || type.equals(ForumConsts.POST_POINTS_WS)){
			postUser.setPostUserExperience(postUser.getPostUserExperience() + 5);
		}else if(type.equals(ForumConsts.POST_POINTS_GT) || type.equals(ForumConsts.POST_POINTS_HT)){
			postUser.setPostUserExperience(postUser.getPostUserExperience() + 1);
		}else if(type.equals(ForumConsts.POST_POINTS_ST)){
//			PostCollection postCollection = new PostCollection();
//			String hql1 = "select a.postUserIdDone from PostCollection a where a.postUserId = :postUserId and a.postId = :postId";
//			String hql2 = "select a.postUserExperience from PostUser a where a.postUserId = :postUserIdDone";
//			String hql = "update PostUser a set a.postUserExperience = :experience where a.postUserId = :postUserIdDone";
//			HashMap<String, Object> params = new HashMap<String, Object>();
//			params.put("experience", 0);
		}else{ //人气帖
			postUser.setPostUserExperience(postUser.getPostUserExperience() + 10);
		}
	}

}
