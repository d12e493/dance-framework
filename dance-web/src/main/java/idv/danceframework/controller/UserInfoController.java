package idv.danceframework.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import idv.danceframework.lo.PageResult;
import idv.danceframework.qo.PageRequest;
import idv.danceframework.service.UserInfoService;

@Controller
@Scope("prototype")
@RequestMapping("/user")
public class UserInfoController extends BaseController implements BaseFlow {

	@Autowired
	private UserInfoService userInfoService;

	private final static Logger LOG = LoggerFactory.getLogger(UserInfoController.class);

	@Override
	public String list() {

		LOG.debug("list");

		return "user-list";
	}

	@Override
	public <UserInfoQO> PageResult query(UserInfoQO queryObject, PageRequest pageRequest) {

		return userInfoService.findAll(queryObject, pageRequest);
	}

}
