package idv.danceframework.controller;

import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import idv.danceframework.lo.PageResult;
import idv.danceframework.qo.PageRequest;

public interface BaseFlow {

	@RequestMapping("/list")
	String list();

	@RequestMapping(value = "/query", method = RequestMethod.POST)
	@ResponseBody
	<Query> PageResult query(@ModelAttribute("qo") Query queryObject, @ModelAttribute("pr") PageRequest pageRequest);
}
