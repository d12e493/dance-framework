package idv.danceframework.bo;

import java.io.Serializable;

import idv.danceframework.entity.UserInfo;

/**
 * about user information for save in session
 * 
 * @author Davis Chen
 *
 */
public class CurrentUser implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public CurrentUser() {

	}

	public CurrentUser(Long usid, String name, String email) {
		super();
		this.usid = usid;
		this.name = name;
		this.email = email;
	}

	public CurrentUser(UserInfo userInfo) {
		this.usid = userInfo.getUsid();
		this.name = userInfo.getName();
		this.email = userInfo.getEmail();
	}

	private Long usid;

	private String name;

	private String email;

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
}
