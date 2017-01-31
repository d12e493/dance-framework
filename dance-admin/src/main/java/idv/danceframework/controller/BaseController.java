package idv.danceframework.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import idv.danceframework.service.BaseService;
import idv.danceframework.session.SessionWrapper;
import idv.danceframework.vo.ContentHeader;

@EnableWebMvc
public abstract class BaseController {

	protected ContentHeader contentHeader = new ContentHeader();
	
	protected ModelAndView modelAndView = new ModelAndView();
	
	@Autowired
	protected SessionWrapper sessionWrapper;
	
	@Autowired
	@Qualifier("baseService")
	protected BaseService baseService;

	public ContentHeader getContentHeader() {
		return contentHeader;
	}

	public void setContentHeader(ContentHeader contentHeader) {
		this.contentHeader = contentHeader;
	}

	public ModelAndView modelAndView(String viewName){
		modelAndView.setViewName(viewName);
		
		modelAndView.addObject("contentHeader", contentHeader);
		
		return modelAndView;
	}
}
