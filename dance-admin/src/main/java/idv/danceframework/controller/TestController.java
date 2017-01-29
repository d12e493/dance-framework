package idv.danceframework.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by Davis on 2016/9/17.
 */
@Controller
@RequestMapping("/")
public class TestController {

    @RequestMapping("/test")
    @ResponseBody
    public String test() {
        System.out.println("test");
        return "ok";
    }
}
