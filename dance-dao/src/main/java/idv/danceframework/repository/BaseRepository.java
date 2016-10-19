package idv.danceframework.repository;

import java.io.Serializable;
import java.util.List;

public interface BaseRepository<T, PK extends Serializable> {

	T findOne(PK id);

	<R> List findAll(R queryObject);
}
