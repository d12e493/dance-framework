package idv.danceframework.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import idv.danceframework.session.SessionWrapper;

@EnableWebMvc
public abstract class BaseController {

	@Autowired
	private SessionWrapper sessionWrapper;

}
