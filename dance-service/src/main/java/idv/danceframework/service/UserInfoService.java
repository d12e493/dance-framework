package idv.danceframework.service;

import idv.danceframework.entity.UserInfo;

public interface UserInfoService extends BaseService<UserInfo, Long> {

	boolean checkPassword(String email, String password);

	UserInfo findByEmail(String email);
}
