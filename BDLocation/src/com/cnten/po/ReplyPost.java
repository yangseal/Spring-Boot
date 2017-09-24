package com.cnten.po;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.GenericGenerator;

import com.fasterxml.jackson.annotation.JsonFormat;


@Entity
public class ReplyPost {

	@Id
	@GenericGenerator(name="generator",strategy="uuid.hex")
	@GeneratedValue(generator="generator")
	@Column(unique=true,nullable=false,length=32)
	private String replyPostId;
	@OneToOne
	@JoinColumn(name="post_id")
	private Post post;
	@Column
	private String replyedPostId;
	@ManyToOne
	@JoinColumn(name="post_user_id")
	private PostUser postUser;
	@Column
	private String replyPostContent;
	@Temporal(TemporalType.TIMESTAMP)
	private Date replyPostTime = new Date();
	@Column
	private Integer isReplyMainPost;
	@Column
	private String isDelete;
	public String getReplyPostId() {
		return replyPostId;
	}
	public void setReplyPostId(String replyPostId) {
		this.replyPostId = replyPostId;
	}
	public Post getPost() {
		return post;
	}
	public void setPost(Post post) {
		this.post = post;
	}
	public String getReplyedPostId() {
		return replyedPostId;
	}
	public void setReplyedPostId(String replyedPostId) {
		this.replyedPostId = replyedPostId;
	}
	public 	PostUser getPostUser() {
		return postUser;
	}
	public void setPostUser(PostUser postUser) {
		this.postUser = postUser;
	}
	public String getReplyPostContent() {
		return replyPostContent;
	}
	public void setReplyPostContent(String replyPostContent) {
		this.replyPostContent = replyPostContent;
	}
	@JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
	public Date getReplyPostTime() {
		return replyPostTime;
	}
	public void setReplyPostTime(Date replyPostTime) {
		this.replyPostTime = replyPostTime;
	}
	public Integer getIsReplyMainPost() {
		return isReplyMainPost;
	}
	public void setIsReplyMainPost(Integer isReplyMainPost) {
		this.isReplyMainPost = isReplyMainPost;
	}
	public String getIsDelete() {
		return isDelete;
	}
	public void setIsDelete(String isDelete) {
		this.isDelete = isDelete;
	}
	
}
