package idv.danceframework.repository;

import java.io.Serializable;

public interface BaseRepository<T, PK extends Serializable> {

	T findOne(PK id);
}
