package idv.danceframework.service.impl;

import java.io.Serializable;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import idv.danceframework.service.BaseService;

@Component
@Transactional
public class BaseServiceImpl<T, PK extends Serializable> implements BaseService<T, PK> {

	@Autowired
	protected JpaRepository<T, PK> repository;

	@Override
	public T save(T t) {
		return repository.save(t);
	}

	@Override
	public T update(T t) {
		return repository.saveAndFlush(t);
	}

	@Override
	public void delete(T t) {
		repository.delete(t);
	}

	@Override
	public void delete(PK id) {
		repository.delete(id);
	}

}
