package idv.danceframework.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import idv.danceframework.core.Message;
import idv.danceframework.core.enums.ErrorMessage;
import idv.danceframework.core.enums.MessageType;
import idv.danceframework.core.enums.SessionAttribute;
import idv.danceframework.core.enums.SuccessMessage;
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

	public ModelAndView modelAndView(String viewName) {
		modelAndView.setViewName(viewName);

		if (contentHeader.isNotEmpty()) {
			modelAndView.addObject("contentHeader", contentHeader);
		}
		return modelAndView;
	}

	protected void addErrorMessage(ErrorMessage e) {

		Message message = new Message();
		message.setType(MessageType.ERROR);
		message.setTemplate(e.name());

		addSessionAttribute(SessionAttribute.SYSTEM_MESSAGE, message);
	}

	protected void addSeccessMessage(SuccessMessage s) {

		Message message = new Message();
		message.setType(MessageType.SUCCESS);
		message.setTemplate(s.name());

		addSessionAttribute(SessionAttribute.SYSTEM_MESSAGE, message);
	}

	protected void addSessionAttribute(SessionAttribute attribute, Object obj) {
		ServletRequestAttributes attr = (ServletRequestAttributes) RequestContextHolder.currentRequestAttributes();
		HttpSession session = attr.getRequest().getSession();
		session.setAttribute(attribute.toString(), obj);
	}
}
