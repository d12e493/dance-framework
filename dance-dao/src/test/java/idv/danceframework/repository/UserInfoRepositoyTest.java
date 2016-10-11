package idv.danceframework.repository;

import org.junit.Test;

import idv.danceframework.entity.UserInfo;

public class UserInfoRepositoyTest extends BaseRepositoryTest<UserInfoRepository> {

	@Test
	public void findOne(){
		UserInfo user=repository.findOne((long) 1);
		System.out.println(user);
	}
}
