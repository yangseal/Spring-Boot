package com.cnten.bdlocation.forum.service;

import java.net.URLDecoder;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cnten.bdlocation.constants.ForumConsts;
import com.cnten.platform.dao.CommonDAO;
import com.cnten.platform.dao.Page;
import com.cnten.platform.web.Constants;
import com.cnten.po.Post;
import com.cnten.po.PostUser;
import com.cnten.po.ReplyPost;
import com.cnten.po.User;

@Service
public class ForumService {
	@Autowired 
	private CommonDAO commonDAO;
	@Autowired
	private PointsService pointsService;

	private static final String TODAY_POST_SQL = "select COUNT(1) as todayPost from Post a where a.postTime = SYSDATE()";
	
	public Page getBoardPost(String boardId,Integer pageIndex,Integer pageSize){
		String sql = " from Post where board.boardId = " + boardId;
		HashMap<String, Object> params = new HashMap<String,Object>();
		return commonDAO.getPage(sql, pageIndex, pageSize, params);
	}
	
	public Long getTodayPost(){
		HashMap<String, Object> params = new HashMap<String,Object>();
		return commonDAO.getCount(TODAY_POST_SQL, params);
	}
	
	public Long getTotalGuidePost(String boardId){
		HashMap<String, Object> params = new HashMap<String,Object>();
		String sql = "SELECT COUNT(2) as totalPostOfGuide from Post a where a.postPlate = " + boardId;
		return commonDAO.getCount(sql, params);
	}
	public Page getMinePostsByPage(Integer pageSize,Integer pageIndex){
		String hql = "from Post p where p.postStatus = :postStatus  order by p.postTime desc";
		HashMap <String, Object> params = new HashMap<String,Object>();
		params.put("postStatus", ForumConsts.POST_STATUS_PUBLISH);
		return commonDAO.getPage(hql,pageSize,pageIndex,params);
	}
	public Page getReplyPostsByPage(ReplyPost replyPost,Integer pageSize,Integer pageIndex){
		String hql = "from ReplyPost  where post.postId = :postId and isReplyMainPost = :isReplyMainPost order by replyPostTime asc";
		HashMap <String, Object> params = new HashMap<String,Object>();
		params.put("postId", replyPost.getPost().getPostId());
		params.put("isReplyMainPost", ForumConsts.REPLY_MAIN_POST_YES);
		return commonDAO.getPage(hql,pageSize,pageIndex,params);
	}
	
	public Page getPostBySubject(Post post,Integer pageIndex,Integer pageSize){
		String hql = " from Post where isDelete is null ";
		HashMap<String,Object> params = new HashMap<String,Object>();
		if(post.getPostSubject() != null && StringUtils.isNotBlank(post.getPostSubject())){
			hql += " and postSubject like :postSubject";
			params.put("postSubject", "%" + post.getPostSubject() + "%");
		}
		hql += " order by postTime desc";
		return commonDAO.getPage(hql, pageIndex, pageSize, params);
	}
	
//	public PostUser getPostUserBasic(HttpServletRequest request){
//		User user = (User)request.getSession().getAttribute(Constants.USER_SESSION_KEY);
//		
//		return 	user.getPostUser();
//		
//		/*if(postUser.getPostUserPoints() < 10){
//			
//		}else if(10 < postUser.getPostUserPoints() && postUser.getPostUserPoints() < 80){
//			
//		}else if(80 < postUser.getPostUserPoints() && postUser.getPostUserPoints() < 100){
//			
//		}else if(100 < postUser.getPostUserPoints() && postUser.getPostUserPoints() < 150){
//			
//		}else{
//			
//		}*/
//	}
	public Map<String,Object> getPost(HttpServletRequest request,String postId){
		Map<String,Object> map = new HashMap<String,Object>();
		String hql= "from ReplyPost r where r.post.postId = :postId and r.isReplyMainPost = :isReplyMainPost order by r.replyPostTime asc";
		HashMap<String,Object> params = new HashMap<String,Object>();
		params.put("postId", postId);
		params.put("isReplyMainPost", ForumConsts.REPLY_MAIN_POST_YES);
		List<ReplyPost>replyPosts = commonDAO.queryList(hql, params);
		Post post = commonDAO.get(Post.class,postId);
		post.setPostVisitCount(post.getPostVisitCount()+1);
		commonDAO.update(post);
		PostUser postUser = getPostUser(request);
		map.put("postUser", postUser);
		map.put("post", post);
		map.put("replyPosts", replyPosts);
		return map;
	}
	
	public List<ReplyPost> getReplyedPost(String postId){
		String hql= "from ReplyPost r where r.post.postId = :postId and r.isReplyMainPost = :isReplyMainPost order by r.replyPostTime asc";
		HashMap<String, Object> params = new HashMap<String,Object>();
		params.put("postId", postId);
		params.put("isReplyMainPost", ForumConsts.REPLY_MAIN_POST_NO);
		return commonDAO.queryList(hql, params);
	}
	
	public void saveReplyPost(HttpServletRequest request,ReplyPost replyPost){
		replyPost.setReplyPostContent(URLDecoder.decode(replyPost.getReplyPostContent()));
		replyPost.setPostUser(getPostUser(request));
		if(replyPost.getReplyedPostId() == null){
			replyPost.setIsReplyMainPost(ForumConsts.REPLY_MAIN_POST_YES);
		}else{
			replyPost.setIsReplyMainPost(ForumConsts.REPLY_MAIN_POST_NO);
		}
		commonDAO.save(replyPost);
		Post post = commonDAO.get(Post.class,replyPost.getPost().getPostId());
		post.setPostReplyCount(post.getPostReplyCount()+1);
		commonDAO.update(post);
		PostUser postUser = replyPost.getPostUser();
		pointsService.getExperience(ForumConsts.POST_POINTS_GT, postUser);
	}
	
	public void savePost(HttpServletRequest request,Post post){
		post.setPostContent(URLDecoder.decode(post.getPostContent()));
		post.setPostUser(getPostUser(request));
		post.setPostVisitCount(ForumConsts.POST_VISIT_COUNT);
		post.setPostReplyCount(ForumConsts.POST_REPLY_COUNT);
		post.setPostStatus(ForumConsts.POST_STATUS_PUBLISH);
		commonDAO.save(post);
		PostUser postUser = post.getPostUser();
		postUser.setPostCount(postUser.getPostCount() + 1);
		pointsService.getExperience(ForumConsts.POST_POINTS_FT, postUser);
	}
	
	//公用方法
	public PostUser getPostUser(HttpServletRequest request){
		User user = (User) request.getSession().getAttribute(Constants.USER_SESSION_KEY);
		if(user == null){
			return null;
		}else{
			String hql = "from PostUser p where p.user =:user";
			HashMap<String, Object> params = new HashMap<String,Object>();
			params.put("user", user);
			PostUser postUser = commonDAO.get(hql, params);
			return postUser;
		}
	}
}
