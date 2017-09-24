package com.cnten.po;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Transient;

import org.hibernate.annotations.GenericGenerator;

import com.cnten.platform.util.StringUtil;

@Entity
public class PostUser {
	
	@Id
	@GenericGenerator(name="generator",strategy="uuid.hex")
	@GeneratedValue(generator="generator")
	@Column(unique=true,nullable=false,length=32)
	private String postUserId;
	@OneToOne
	@JoinColumn(name="user_id")
	private User user;
	@Column
	private String postUserNickname;
	@Column
	private String postUserSex;
	@Column
	private String postUserBirth;
	@Column
	private String postUserBloodType;
	@Column
	private String postUserDomicile;
	@Column
	private String postUserIntroduction;
	@Column
	private String postUserGrade;
	@Transient
	private String postUserGradeName;
	public static final String postUserGradeDictStatement = "1,初入江湖;2,虾兵蟹将;3,小有名气;4,登堂入室;5,一代大侠";
	@Column
	private Integer postUserExperience;
	@Column
	private Integer postUserPoints;
	@Column
	private Integer postCount;
	
	
	public String getPostUserId() {
		return postUserId;
	}
	public void setPostUserId(String postUserId) {
		this.postUserId = postUserId;
	}
	public String getPostUserNickname() {
		return postUserNickname;
	}
	public void setPostUserNickname(String postUserNickname) {
		this.postUserNickname = postUserNickname;
	}
	
	public String getPostUserSex() {
		return postUserSex;
	}
	public void setPostUserSex(String postUserSex) {
		this.postUserSex = postUserSex;
	}
	
	public String getPostUserBirth() {
		return postUserBirth;
	}
	public void setPostUserBirth(String postUserBirth) {
		this.postUserBirth = postUserBirth;
	}
	public String getPostUserBloodType() {
		return postUserBloodType;
	}
	public void setPostUserBloodType(String postUserBloodType) {
		this.postUserBloodType = postUserBloodType;
	}
	public String getPostUserDomicile() {
		return postUserDomicile;
	}
	public void setPostUserDomicile(String postUserDomicile) {
		this.postUserDomicile = postUserDomicile;
	}
	public String getPostUserIntroduction() {
		return postUserIntroduction;
	}
	public void setPostUserIntroduction(String postUserIntroduction) {
		this.postUserIntroduction = postUserIntroduction;
	}
	public String getPostUserGrade() {
		return postUserGrade;
	}
	public void setPostUserGrade(String postUserGrade) {
		this.postUserGrade = postUserGrade;
	}
	public Integer getPostUserExperience() {
		return postUserExperience;
	}
	public void setPostUserExperience(Integer postUserExperience) {
		this.postUserExperience = postUserExperience;
	}
	public Integer getPostUserPoints() {
		return postUserPoints;
	}
	public void setPostUserPoints(Integer postUserPoints) {
		this.postUserPoints = postUserPoints;
	}
	public Integer getPostCount() {
		return postCount;
	}
	public void setPostCount(Integer postCount) {
		this.postCount = postCount;
	}
	public String getPostUserGradeName() {
		return StringUtil.getDictName(getPostUserGrade(), postUserGradeDictStatement);
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
}
