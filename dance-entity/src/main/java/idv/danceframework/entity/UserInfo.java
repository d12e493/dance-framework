package idv.danceframework.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Created by Davis on 2016/9/18.
 */
@Entity
@Table(schema = "SYSTEM", name = "USER_INFO")
public class UserInfo {
	@Id
	@GeneratedValue
	private Long usid;

	private String name;
	private String password;

	public Long getUsid() {
		return usid;
	}

	public void setUsid(Long usid) {
		this.usid = usid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
}
