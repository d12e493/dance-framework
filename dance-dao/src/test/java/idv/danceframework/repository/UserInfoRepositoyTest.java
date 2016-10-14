package idv.danceframework.repository;

import java.util.List;

import org.junit.Ignore;
import org.junit.Test;

import com.github.pagehelper.PageHelper;

import idv.danceframework.entity.UserInfo;
import idv.danceframework.lo.PageResult;
import idv.danceframework.lo.UserInfoLO;
import idv.danceframework.qo.UserInfoQO;

public class UserInfoRepositoyTest extends BaseRepositoryTest<UserInfoRepository> {

	@Test
	@Ignore
	public void findOne() {
		UserInfo user = repository.findOne((long) 1);
		System.out.println(user);
	}

	@Test
	public void findAll() {
		UserInfoQO qo = new UserInfoQO();

		PageHelper.startPage(1, 10);
		List<UserInfoLO> list = repository.findAll(qo);
		PageResult<UserInfoLO> page = new PageResult<UserInfoLO>(list);

		System.out.println(page);
	}
}
