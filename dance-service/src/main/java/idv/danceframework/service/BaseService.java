package idv.danceframework.service;

import java.io.Serializable;

public interface BaseService {

	<T> T save(T t);

	<T> T update(T t);

	<T> void delete(T t);

	void delete(Serializable id);

	<T> void remove(T t);

	<T> T findOne(Class<T> clazz, Serializable id);
}
