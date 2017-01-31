package idv.danceframework.service.impl;

import java.io.Serializable;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import idv.danceframework.service.BaseService;

@Service("baseService")
public class BaseServiceImpl implements BaseService {

	@Autowired
	private EntityManager em;
	
	@Override
	public <T> T save(T t) {
		em.persist(t);
		return t;
	}

	@Override
	public <T> T update(T t) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <T> void delete(T t) {
		// TODO Auto-generated method stub

	}

	@Override
	public void delete(Serializable id) {
		// TODO Auto-generated method stub

	}

	@Override
	public <T> void remove(T t) {
		// TODO Auto-generated method stub

	}

	@Override
	public <T> T findOne(Class<T> clazz, Serializable id) {
		// TODO Auto-generated method stub
		return null;
	}

}
