package idv.danceframework.controller;

import org.springframework.beans.factory.annotation.Autowired;

import idv.danceframework.bo.CurrentUser;
import idv.danceframework.session.SessionWrapper;

public abstract class BaseController {

	@Autowired
	private SessionWrapper sessionWrapper;

	public SessionWrapper getSessionWrapper() {
		return sessionWrapper;
	}

	public CurrentUser getCurrentUser() {
		return this.sessionWrapper.getUser();
	}
}
