package idv.danceframework.repository;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import idv.danceframework.entity.UserInfo;

public interface UserInfoRepository extends BaseRepository<UserInfo, Long> {

	UserInfo findByEmail(String email);

	@Select("select pid from sna.pkg_list where pid <=10 order by pid asc")
	List<Integer> findPidList();

	@Select("select imei from sna.imei_list where status = 0 limit 1000")
	List<String> findAllImei();

	@Select("select distinct pid from sna.imei_app where imei = #{imei} order by pid asc")
	List<Integer> findPidListByImei(String imei);

	@Select("select weight from sna.app_weight where pid1 = #{0} and pid2 = #{1}")
	Integer findAppWeight(int p1, int p2);

	@Insert("insert into sna.app_weight values(#{0},#{1},1)")
	void insertAppWeight(int p1, int p2);

	@Update("update sna.app_weight set weight = #{count} where pid1 = #{0} and pid2 = #{1}")
	void updateAppWeight(int p1, int p2, @Param("count") int count);

	@Update("update sna.imei_list set status = 1 where imei = #{imei}")
	void updateImei(String imei);
}
