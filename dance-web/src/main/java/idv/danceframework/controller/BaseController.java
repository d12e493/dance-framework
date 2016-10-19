package idv.danceframework.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import idv.danceframework.bo.CurrentUser;
import idv.danceframework.lo.PageResult;
import idv.danceframework.session.SessionWrapper;

@EnableWebMvc
public abstract class BaseController {

	protected PageResult pageResult;

	@Autowired
	private SessionWrapper sessionWrapper;

	public SessionWrapper getSessionWrapper() {
		return sessionWrapper;
	}

	public CurrentUser getCurrentUser() {
		return this.sessionWrapper.getUser();
	}
}
