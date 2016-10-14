package idv.danceframework.service;

import java.io.Serializable;

import idv.danceframework.lo.PageResult;
import idv.danceframework.qo.PageRequest;

public interface BaseService<T, PK extends Serializable> {

	T save(T t);

	T update(T t);

	void delete(T t);

	void delete(PK id);

	T findOne(PK id);

	<R> PageResult findAll(R queryObject, PageRequest pageRequest);
}
