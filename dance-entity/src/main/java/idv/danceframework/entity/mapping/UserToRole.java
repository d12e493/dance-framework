package idv.danceframework.entity.mapping;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;

import idv.danceframework.entity.ids.UserToRoleId;

@Entity
@Table(schema = "SYSTEM", name = "USER_TO_ROLE")
@IdClass(UserToRoleId.class)
public class UserToRole implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	private Long usid;

	@Id
	private Long roleId;

	public Long getUsid() {
		return usid;
	}

	public void setUsid(Long usid) {
		this.usid = usid;
	}

	public Long getRoleId() {
		return roleId;
	}

	public void setRoleId(Long roleId) {
		this.roleId = roleId;
	}
}
