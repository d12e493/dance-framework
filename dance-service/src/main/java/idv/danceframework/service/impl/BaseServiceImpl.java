package idv.danceframework.service.impl;

import java.io.Serializable;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.github.pagehelper.PageHelper;

import idv.danceframework.lo.PageResult;
import idv.danceframework.qo.PageRequest;
import idv.danceframework.repository.BaseRepository;
import idv.danceframework.service.BaseService;

@Transactional
public abstract class BaseServiceImpl<R extends BaseRepository, T, PK extends Serializable>
		implements BaseService<T, PK> {

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

	protected <W> PageResult findAll(Object queryObject, PageRequest pageRequest, Class<W> clazz) {
		PageHelper.startPage(pageRequest.getCurrentPage(), pageRequest.getRowsPerPage());
		List<W> list = repository.findAll(queryObject,pageRequest);
		return new PageResult<W>(list);
	}

}
