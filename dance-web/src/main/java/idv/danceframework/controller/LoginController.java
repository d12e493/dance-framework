package idv.danceframework.controller;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@Scope("prototype")
public class LoginController extends BaseController {

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String welcome(ModelMap model) {
		System.out.println("welcome");
		return "home";
	}

	@RequestMapping(value = "home", method = RequestMethod.GET)
	public String dashboard(ModelMap model) {
		System.out.println("dashboard");
		return "dashboard";
	}

	@RequestMapping("/login")
	public String login(ModelMap model) {
		System.out.println("login");
		return "login";
	}
}
