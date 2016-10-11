package idv.danceframework.repository;

import idv.danceframework.entity.UserInfo;

public interface UserInfoRepository extends BaseRepository<UserInfo, Long> {
	
	UserInfo findByEmail(String email);
}
