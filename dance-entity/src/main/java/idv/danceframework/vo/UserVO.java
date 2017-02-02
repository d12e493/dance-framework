package idv.danceframework.vo;

import javax.persistence.Entity;
import javax.persistence.Id;

import idv.danceframework.sql.CustomNativeQuery;

@CustomNativeQuery(query = "SELECT u.user_id,u.name,u.email,u.status " + " FROM user_ u ")
@Entity
public class UserVO {
	@Id
	private long userId;
	private String name;
	private String email;
	private Integer status;

	public UserVO() {

	}

	public UserVO(long userId, String name, String email, Integer status) {
		super();
		this.userId = userId;
		this.name = name;
		this.email = email;
		this.status = status;
	}

	public long getUserId() {
		return userId;
	}

	public void setUserId(long userId) {
		this.userId = userId;
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

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}
}
