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
public class RoleMenu {

	@Id
    @GenericGenerator(name = "generator", strategy = "uuid.hex")
    @GeneratedValue(generator = "generator")
    @Column(unique = true, nullable = false, length = 32)
    private String roleMenuId;
	@ManyToOne
    @JoinColumn(name="role_id")
    private Role role;
    @Transient
    private String roleId;
	@ManyToOne
    @JoinColumn(name="menu_id")
    private Menu menu;
    @Transient
    private String menuId;
    @Column(length = 1)
    private String isDelete;
    
	public String getRoleMenuId() {
		return roleMenuId;
	}
	public void setRoleMenuId(String roleUserId) {
		this.roleMenuId = roleUserId;
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
	public Menu getMenu() {
		return menu;
	}
	public void setMenu(Menu menu) {
		this.menu = menu;
	}
	public String getMenuId() {
		return menuId;
	}
	public void setMenuId(String menuId) {
		this.menuId = menuId;
	}
	public String getIsDelete() {
		return isDelete;
	}
	public void setIsDelete(String isDelete) {
		this.isDelete = isDelete;
	}
    
}
