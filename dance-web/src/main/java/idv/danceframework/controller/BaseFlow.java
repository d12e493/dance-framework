package idv.danceframework.controller;

import org.springframework.web.bind.annotation.RequestMapping;

public interface BaseFlow {

	@RequestMapping("/list")
	String list();
}
