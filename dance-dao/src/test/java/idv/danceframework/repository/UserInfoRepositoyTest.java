package idv.danceframework.repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

	private Map<String, Integer> mappingMap = new HashMap<String, Integer>();

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
		int imeiIndex = 1;
		for (String imei : imeiList) {
			List<Integer> pidList = repository.findPidListByImei(imei);
			List<Mapping> mappingList = transfer(pidList);

			for (Mapping mapping : mappingList) {

				int p1 = mapping.getPrimary();
				int p2 = mapping.getRemain();

				transferToMap(p1, p2);
			}
			repository.updateImei(imei);
			System.out.println("imeiList : " + imeiIndex + " --- finish ---");
			imeiIndex++;
		}

		int mappingIndex = 1;
		int remainIndex = mappingMap.size();
		if (mappingMap.size() > 0) {
			for (String k : mappingMap.keySet()) {
				String[] keys = k.split("_");

				int k1 = Integer.parseInt(keys[0]);
				int k2 = Integer.parseInt(keys[1]);
				int v = mappingMap.get(k);

				Integer weight = repository.findAppWeight(k1, k2);
				// if not exist insert
				if (weight == null) {
					repository.insertAppWeight(k1, k2, v);
				}
				// or update
				else {
					repository.updateAppWeight(k1, k2, weight + v);
				}
				System.out.println("mappingMap : " + mappingIndex + " --- finish --- " + " remain :" + remainIndex);
				mappingIndex++;
				remainIndex--;
			}
		}
	}

	private void transferToMap(int p1, int p2) {
		String key = Integer.toString(p1) + "_" + Integer.toString(p2);
		if (!mappingMap.containsKey(key)) {
			mappingMap.put(key, 0);
		}
		mappingMap.put(key, mappingMap.get(key) + 1);
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
