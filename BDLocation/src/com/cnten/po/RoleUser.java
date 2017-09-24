package com.cnten.po;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Transient;

import org.hibernate.annotations.GenericGenerator;

@Entity
public class RoleUser {

	@Id
    @GenericGenerator(name = "generator", strategy = "uuid.hex")
    @GeneratedValue(generator = "generator")
    @Column(unique = true, nullable = false, length = 32)
    private String roleUserId;
	@ManyToOne
    @JoinColumn(name="role_id",updatable=false)
    private Role role;
    @Transient
    private String roleId;
	@ManyToOne
    @JoinColumn(name="user_id",updatable=false)
    private User user;
    @Transient
    private String userId;
    @Column(length = 1)
    private String isDelete;
    
	public String getRoleUserId() {
		return roleUserId;
	}
	public void setRoleUserId(String roleUserId) {
		this.roleUserId = roleUserId;
	}
	public Role getRole() {
		return role;
	}
	public void setRole(Role role) {
		this.role = role;
	}
	public String getRoleId() {
		return roleId;
	}
	public void setRoleId(String roleId) {
		this.roleId = roleId;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getIsDelete() {
		return isDelete;
	}
	public void setIsDelete(String isDelete) {
		this.isDelete = isDelete;
	}
    
}
