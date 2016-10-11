package idv.danceframework.service.impl;

import java.io.Serializable;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import idv.danceframework.repository.BaseRepository;
import idv.danceframework.service.BaseService;

@Transactional
public class BaseServiceImpl<R extends BaseRepository,T,PK extends Serializable> implements BaseService<T, PK> {

	@Autowired
	protected R repository;

	@Override
	public T save(T t) {
		return null;
	}

	@Override
	public T update(T t) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void delete(T t) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(PK id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public T findOne(PK id) {
		return (T) repository.findOne(id);
	}

}
