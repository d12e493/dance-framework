package idv.danceframework.repository;

import java.io.Serializable;
import java.util.List;

import org.apache.ibatis.annotations.Param;

import idv.danceframework.qo.PageRequest;

public interface BaseRepository<T, PK extends Serializable> {

	T findOne(PK id);

	<R> List findAll(@Param("qo") R queryObject, @Param("pr") PageRequest pageRequest);
}
