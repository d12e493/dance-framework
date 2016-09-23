package idv.danceframework.controller;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@Scope("prototype")
public class LoginController extends BaseController {

	@RequestMapping({ "/", "/login" })
	public String welcome() {
		System.out.println("login");
		return "aa";
	}
}
