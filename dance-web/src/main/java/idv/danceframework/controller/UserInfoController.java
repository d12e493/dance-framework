package idv.danceframework.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import idv.danceframework.lo.PageResult;
import idv.danceframework.lo.UserInfoLO;
import idv.danceframework.qo.PageRequest;
import idv.danceframework.qo.UserInfoQO;
import idv.danceframework.service.UserInfoService;
import idv.danceframework.test.Test;

@Controller
@Scope("prototype")
@RequestMapping("/user")
public class UserInfoController extends BaseController implements BaseFlow<UserInfoQO, UserInfoLO> {

	@Autowired
	private UserInfoService userInfoService;

	private final static Logger LOG = LoggerFactory.getLogger(UserInfoController.class);

	@Override
	public String list() {

		LOG.debug("list");

		return "user-list";
	}

	@Override
	public PageResult<UserInfoLO> query(UserInfoQO queryObject, PageRequest pageRequest) {

		PageResult<UserInfoLO> page = userInfoService.findAll(queryObject, pageRequest);

		return page;
	}

	@Override
	public Test test() {

		return new Test();
	}

}
