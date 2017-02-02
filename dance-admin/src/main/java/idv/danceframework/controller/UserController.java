package idv.danceframework.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import idv.danceframework.lo.PageResult;
import idv.danceframework.qo.PageRequest;
import idv.danceframework.vo.UserVO;

@Controller
@Scope("prototype")
@RequestMapping("/user")
public class UserController extends BaseController {

	@RequestMapping("/list")
	public ModelAndView list() {
		super.contentHeader.setTitle("使用者管理");
		super.contentHeader.setIcon("fa fa-fw fa-users");

		return modelAndView("user-list");
	}

	@RequestMapping(value = "/query", method = RequestMethod.POST)
	public @ResponseBody PageResult query(PageRequest<UserVO> pageRequest,
			HttpServletRequest requestPageRequest) {

		PageResult result = new PageResult();

		pageRequest.getSortList();
		
		List<UserVO> userList = new ArrayList<UserVO>();

		userList.add(new UserVO(1L, UUID.randomUUID().toString(), "123@gmail.com", 1));
		userList.add(new UserVO(17L, UUID.randomUUID().toString(), "123@gmail.com", 1));
		userList.add(new UserVO(28L, UUID.randomUUID().toString(), "123@gmail.com", 1));
		userList.add(new UserVO(138L, UUID.randomUUID().toString(), "123@gmail.com", 1));
		userList.add(new UserVO(2L, UUID.randomUUID().toString(), "123@gmail.com", 1));
		userList.add(new UserVO(2L, UUID.randomUUID().toString(), "123@gmail.com", 1));
		userList.add(new UserVO(2L, UUID.randomUUID().toString(), "123@gmail.com", 1));
		userList.add(new UserVO(2L, UUID.randomUUID().toString(), "123@gmail.com", 1));
		userList.add(new UserVO(2L, UUID.randomUUID().toString(), "123@gmail.com", 1));
		userList.add(new UserVO(2L, UUID.randomUUID().toString(), "123@gmail.com", 1));
		userList.add(new UserVO(2L, UUID.randomUUID().toString(), "123@gmail.com", 1));
		userList.add(new UserVO(2L, UUID.randomUUID().toString(), "123@gmail.com", 1));
		userList.add(new UserVO(2L, UUID.randomUUID().toString(), "123@gmail.com", 1));
		userList.add(new UserVO(2L, UUID.randomUUID().toString(), "123@gmail.com", 1));
		userList.add(new UserVO(2L, UUID.randomUUID().toString(), "123@gmail.com", 1));
		userList.add(new UserVO(2L, UUID.randomUUID().toString(), "123@gmail.com", 1));

		result.setData(userList);

		return result;
	}
}
