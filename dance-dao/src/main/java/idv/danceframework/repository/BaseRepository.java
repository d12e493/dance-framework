package idv.danceframework.repository;

import java.io.Serializable;
import java.util.List;

import org.apache.ibatis.annotations.Param;

import idv.danceframework.qo.PageRequest;

public interface BaseRepository<T, PK extends Serializable> {

	T findOne(PK id);

	<R> List findAll(@Param("qo") R queryObject, @Param("pr") PageRequest pageRequest);

	Long save(T t);

	void update(T t);

	/**
	 * 會直接從資料庫，真正刪除的資料
	 * 
	 * @param id
	 * 
	 * @author Davis Chen
	 */
	void delete(PK id);

	/**
	 * 單純只是更改資料的狀態，在後台查詢不到
	 * 
	 * @param id
	 * 
	 * @author Davis Chen
	 */
	void remove(PK id);
}
