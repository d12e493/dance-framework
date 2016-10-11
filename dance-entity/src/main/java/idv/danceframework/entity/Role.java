package idv.danceframework.entity;

import java.io.Serializable;

public class Role extends BaseEntity implements Serializable {

	private static final long serialVersionUID = 1L;

	private Long roleId;
	
	private String name;
	
	private Long parentRoleId;

	public Long getRoleId() {
		return roleId;
	}

	public void setRoleId(Long roleId) {
		this.roleId = roleId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Long getParentRoleId() {
		return parentRoleId;
	}

	public void setParentRoleId(Long parentRoleId) {
		this.parentRoleId = parentRoleId;
	}
}
