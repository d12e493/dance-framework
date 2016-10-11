package idv.danceframework.entity;

import java.io.Serializable;

/**
 * Created by Davis on 2016/9/18.
 */
public class UserInfo extends BaseEntity implements Serializable {

	private static final long serialVersionUID = 1L;

	private Long usid;

	private String name;

	private String email;

	private String password;

	public UserInfo() {

	}

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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
}
