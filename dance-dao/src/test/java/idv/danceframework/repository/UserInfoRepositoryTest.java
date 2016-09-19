package idv.danceframework.repository;

import org.junit.Test;

import idv.danceframework.entity.UserInfo;

public class UserInfoRepositoryTest extends BaseTest<UserInfoRepository, UserInfo> {

	@Test
	public void test() {
		repository.findAll();
	}

}
