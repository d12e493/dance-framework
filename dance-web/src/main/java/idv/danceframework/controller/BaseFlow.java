package idv.danceframework.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import idv.danceframework.lo.PageResult;
import idv.danceframework.qo.PageRequest;
import idv.danceframework.test.Test;
import idv.danceframework.wrapper.BaseWrapper;

public interface BaseFlow<Query, List> {

	@RequestMapping(value = "/test", method = RequestMethod.GET, produces = "application/json")
	@ResponseBody
	Test test();

	@RequestMapping("/list")
	String list();

	@RequestMapping(value = "/query", method = { RequestMethod.POST, RequestMethod.GET }, produces = "application/json")
	@ResponseBody
	PageResult<List> query(Query queryObject, PageRequest pageRequest);

	@RequestMapping(value = "/prepareAdd", method = { RequestMethod.POST })
	<BW extends BaseWrapper> String prepareAdd(BW bw, HttpServletRequest request, HttpServletResponse response);

	@RequestMapping(value = "/add", method = { RequestMethod.POST })
	<O> String add(O o, HttpServletRequest request, HttpServletResponse response);
}
