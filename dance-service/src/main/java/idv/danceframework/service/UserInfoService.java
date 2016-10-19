package idv.danceframework.service;

import idv.danceframework.entity.UserInfo;
import idv.danceframework.lo.UserInfoLO;
import idv.danceframework.qo.UserInfoQO;

public interface UserInfoService extends BaseService<UserInfo, Long>, BasePageService<UserInfoQO, UserInfoLO> {

	boolean checkPassword(String email, String password);

	UserInfo findByEmail(String email);
}
