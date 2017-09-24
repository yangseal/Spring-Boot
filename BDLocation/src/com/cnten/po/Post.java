package com.cnten.po;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

import org.hibernate.annotations.GenericGenerator;

import com.cnten.platform.util.StringUtil;

@Entity
public class Post {
	@Id
	@GenericGenerator(name="generator",strategy="uuid.hex")
	@GeneratedValue(generator="generator")
	@Column(unique=true,nullable=false,length=32)
	private String postId;
	@Column
	private String postSubject;
	@Column
	private String postContent;
	@Temporal(TemporalType.TIMESTAMP)
	private Date postTime = new Date(); 
	@ManyToOne
	@JoinColumn(name="post_user_id")
	private PostUser postUser;
	@Column
	private Integer postVisitCount;
	@Column
	private Integer postReplyCount;
	@Column
	private Integer postStatus;
	@Column
	private Integer postPlate;
	@Column
	private String isDelete;
	@ManyToOne
	@JoinColumn(name="board_id")
	private Board board;
	public String getPostId() {
		return postId;
	}
	public void setPostId(String postId) {
		this.postId = postId;
	}
	public String getPostSubject() {
		return postSubject;
	}
	public void setPostSubject(String postSubject) {
		this.postSubject = postSubject;
	}
	public String getPostContent() {
		return postContent;
	}
	public void setPostContent(String postContent) {
		this.postContent = postContent;
	}
	public Date getPostTime() {
		return postTime;
	}
	public void setPostTime(Date postTime) {
		this.postTime = postTime;
	}
	public Integer getPostVisitCount() {
		return postVisitCount;
	}
	public void setPostVisitCount(Integer postVisitCount) {
		this.postVisitCount = postVisitCount;
	}
	public Integer getPostReplyCount() {
		return postReplyCount;
	}
	public void setPostReplyCount(Integer postReplyCount) {
		this.postReplyCount = postReplyCount;
	}
	public Integer getPostStatus() {
		return postStatus;
	}
	public void setPostStatus(Integer postStatus) {
		this.postStatus = postStatus;
	}
	public Integer getPostPlate() {
		return postPlate;
	}
	public void setPostPlate(Integer postPlate) {
		this.postPlate = postPlate;
	}
	public String getIsDelete() {
		return isDelete;
	}
	public void setIsDelete(String isDelete) {
		this.isDelete = isDelete;
	}
	public PostUser getPostUser() {
		return postUser;
	}
	public void setPostUser(PostUser postUser) {
		this.postUser = postUser;
	}
	public Board getBoard() {
		return board;
	}
	public void setBoard(Board board) {
		this.board = board;
	}
}
