package idv.danceframework.wrapper;

import idv.danceframework.entity.UserInfo;

public class UserInfoWrapper extends BaseWrapper {

	private UserInfo userInfo;

	public UserInfo getUserInfo() {
		return userInfo;
	}

	public void setUserInfo(UserInfo userInfo) {
		this.userInfo = userInfo;
	}
}
