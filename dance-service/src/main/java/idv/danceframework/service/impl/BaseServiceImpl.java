package idv.danceframework.service.impl;

import java.io.Serializable;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.transaction.annotation.Transactional;

import idv.danceframework.service.BaseService;

@Transactional
public class BaseServiceImpl<T, PK extends Serializable> implements BaseService<T, PK> {

	@PersistenceContext(unitName="system")
	@Qualifier(value = "entityManagerFactory")
	private EntityManager entityManager;

	private Class<T> clazz;

	@Override
	public T save(T t) {
		entityManager.persist(t);
		return t;
	}

	@Override
	public T update(T t) {
		return entityManager.merge(t);
	}

	@Override
	public void delete(T t) {
		entityManager.remove(t);
	}

	@Override
	public void delete(PK id) {
		entityManager.remove(findOne(id));
	}

	@Override
	public T findOne(PK id) {

		return entityManager.find(clazz, id);
	}

}
