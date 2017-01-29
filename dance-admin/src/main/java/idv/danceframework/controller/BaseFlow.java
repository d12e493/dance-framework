package idv.danceframework.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import idv.danceframework.test.Test;

public interface BaseFlow<Query, List> {

	@RequestMapping(value = "/test", method = RequestMethod.GET, produces = "application/json")
	@ResponseBody
	Test test();

	@RequestMapping("/list")
	String list();

	@RequestMapping(value = "/add", method = { RequestMethod.POST })
	<O> String add(O o, HttpServletRequest request, HttpServletResponse response);
}
