package idv.danceframework.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@Scope("prototype")
@RequestMapping("/user")
public class UserInfoController extends BaseController implements BaseFlow {

	private final static Logger LOG = LoggerFactory.getLogger(UserInfoController.class);
	
	@Override
	public String list() {

		LOG.debug("list");

		return "user-list";
	}

}
