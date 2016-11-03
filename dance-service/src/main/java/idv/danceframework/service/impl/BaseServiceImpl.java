package idv.danceframework.service.impl;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Scope;
import org.springframework.transaction.annotation.Transactional;

import com.github.pagehelper.PageHelper;

import idv.danceframework.bo.CurrentUser;
import idv.danceframework.lo.PageResult;
import idv.danceframework.qo.PageRequest;
import idv.danceframework.repository.BaseRepository;
import idv.danceframework.service.BaseService;
import idv.danceframework.session.SessionWrapper;
import idv.danceframework.util.PropertyUtils;

@Transactional
public abstract class BaseServiceImpl<R extends BaseRepository, T, PK extends Serializable>
		implements BaseService<T, PK> {

	@Autowired
	private ApplicationContext context;

	@Autowired
	private SessionWrapper sessionWrapper;
	
	@Autowired
	protected R repository;

	private void setCreateTime(T t) {
		final String createTimeFieldName = "createTime";
		
		if (PropertyUtils.hasProperty(t, createTimeFieldName)) {
			PropertyUtils.setProperty(t, createTimeFieldName, new Date());
		}
	}

	private void setCreateUserId(T t) {

		final String createUserIdFieldName = "createUserId";

		if (PropertyUtils.hasProperty(t, createUserIdFieldName) && getSessionWrapper() != null) {

			// 預設是 0 表示是系統新增的
			Long currentUserId = 0L;

			CurrentUser user = getSessionWrapper().getUser();

			if (user != null) {
				currentUserId = user.getUsid();
			}
			PropertyUtils.setProperty(t, createUserIdFieldName, currentUserId);
		}
	}

	protected SessionWrapper getSessionWrapper() {
//		SessionWrapper sessionWrapper = context.getBean(SessionWrapper.class);
//		return sessionWrapper;
		System.out.println("sessionWrapper:"+sessionWrapper.hashCode());
		return this.sessionWrapper;
	}

	@Override
	public Long save(T t) {

		setCreateTime(t);
		setCreateUserId(t);

		return repository.save(t);
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
		List<W> list = repository.findAll(queryObject, pageRequest);
		return new PageResult<W>(list);
	}

}
