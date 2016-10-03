package idv.danceframework.entity.mapping;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;

import idv.danceframework.entity.ids.RoleToMenuId;
@Entity
@Table(schema = "SYSTEM", name = "ROLE_TO_MENU")
@IdClass(RoleToMenuId.class)
public class RoleToMenu implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	private Long roleId;
	
	@Id
	private Long menuId;

	public Long getRoleId() {
		return roleId;
	}

	public void setRoleId(Long roleId) {
		this.roleId = roleId;
	}

	public Long getMenuId() {
		return menuId;
	}

	public void setMenuId(Long menuId) {
		this.menuId = menuId;
	}
}
