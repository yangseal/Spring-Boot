package com.cnten.po;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.GenericGenerator;

@Entity
public class PostCollection {
	
	@Id
	@GenericGenerator(name="generator",strategy="uuid.hex")
	@GeneratedValue(generator="generator")
	@Column(unique=true,nullable=false,length=32)
	private String postCollectionId;
	@Column
	private String postUserId;
	@Column
	private String  postId;
	@Temporal(TemporalType.TIMESTAMP)
	private Date collectionTime = new Date();
	@Column
	private String postUserIdDone;
	
	public String getPostCollectionId() {
		return postCollectionId;
	}
	public void setPostCollectionId(String postCollectionId) {
		this.postCollectionId = postCollectionId;
	}
	
	public String getPostUserId() {
		return postUserId;
	}
	public void setPostUserId(String postUserId) {
		this.postUserId = postUserId;
	}
	public String getPostId() {
		return postId;
	}
	public void setPostId(String postId) {
		this.postId = postId;
	}
	public Date getCollectionTime() {
		return collectionTime;
	}
	public void setCollectionTime(Date collectionTime) {
//		this.collectionTime = collectionTime;
	}
	public String getPostUserIdDone() {
		return postUserIdDone;
	}
	public void setPostUserIdDone(String postUserIdDone) {
		this.postUserIdDone = postUserIdDone;
	}
	
}
