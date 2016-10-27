package idv.danceframework.repository;

import java.util.ArrayList;
import java.util.List;

import org.junit.Ignore;
import org.junit.Test;
import org.springframework.test.annotation.Rollback;

import com.github.pagehelper.PageHelper;

import idv.danceframework.entity.UserInfo;
import idv.danceframework.lo.PageResult;
import idv.danceframework.lo.UserInfoLO;
import idv.danceframework.qo.PageRequest;
import idv.danceframework.qo.UserInfoQO;

@Rollback(value = false)
public class UserInfoRepositoyTest extends BaseRepositoryTest<UserInfoRepository> {

	private class Mapping {
		private int primary;
		private int remain;

		public Mapping(int x, int y) {
			this.primary = x;
			this.remain = y;
		}

		public int getPrimary() {
			return primary;
		}

		public void setPrimary(int primary) {
			this.primary = primary;
		}

		public int getRemain() {
			return remain;
		}

		public void setRemain(int remain) {
			this.remain = remain;
		}

	}

	@Test
	@Ignore
	public void findOne() {
		UserInfo user = repository.findOne((long) 1);
		System.out.println(user);
	}

	@Test
	@Ignore
	public void findAll() {
		UserInfoQO qo = new UserInfoQO();

		PageHelper.startPage(1, 10);
		List<UserInfoLO> list = repository.findAll(qo, new PageRequest());
		PageResult<UserInfoLO> page = new PageResult<UserInfoLO>(list);

		System.out.println(page);
	}

	@Test
	public void forSna() {
		List<String> imeiList = repository.findAllImei();
		for (String imei : imeiList) {
			List<Integer> pidList = repository.findPidListByImei(imei);
			List<Mapping> mappingList = transfer(pidList);

			for (Mapping mapping : mappingList) {

				int p1 = mapping.getPrimary();
				int p2 = mapping.getRemain();

				// find mapping row
				Integer weight = repository.findAppWeight(p1, p2);
				// if not exist insert
				if (weight == null) {
					repository.insertAppWeight(p1, p2);
				}
				// or update
				else {
					repository.updateAppWeight(p1, p2, weight + 1);
				}
			}
			repository.updateImei(imei);
		}
	}

	private List<Mapping> transfer(List<Integer> list) {
		List<Mapping> mappingList = new ArrayList<Mapping>();
		for (Integer primary : list) {

			List<Integer> remainList = list.subList(list.indexOf(primary) + 1, list.size());

			for (Integer remain : remainList) {
				mappingList.add(new Mapping(primary, remain));
			}
		}
		return mappingList;
	}

}
