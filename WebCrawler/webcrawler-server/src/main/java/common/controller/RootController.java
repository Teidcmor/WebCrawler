package common.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping(value = "/root")
public class RootController {

    @RequestMapping(value = "/toLogin.do")
    public ModelAndView toLogin(){
        ModelAndView modelAndView = new ModelAndView("userInfo/login");
        return modelAndView;
    }

}
