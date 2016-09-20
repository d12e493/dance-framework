package idv.danceframework.service;

import java.io.Serializable;

public interface BaseService<T, PK extends Serializable> {

	T save(T t);

	T update(T t);

	void delete(T t);

	void delete(PK id);

}
