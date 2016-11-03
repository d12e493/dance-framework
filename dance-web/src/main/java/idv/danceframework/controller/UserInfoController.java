package idv.danceframework.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import idv.danceframework.bo.CurrentUser;
import idv.danceframework.lo.PageResult;
import idv.danceframework.lo.UserInfoLO;
import idv.danceframework.qo.PageRequest;
import idv.danceframework.qo.UserInfoQO;
import idv.danceframework.service.UserInfoService;
import idv.danceframework.test.Test;
import idv.danceframework.wrapper.BaseWrapper;

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

	@Override
	public <BW extends BaseWrapper> String prepareAdd(BW bw, HttpServletRequest request, HttpServletResponse response) {

		return "user-add";
	}

	@Override
	public <UserInfoWrapper> String add(UserInfoWrapper userInfoWrapper, HttpServletRequest request,
			HttpServletResponse response) {

		return list();
	}

}
