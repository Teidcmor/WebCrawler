package common.controller;

import common.mapper.InitialUrlMapper;
import common.pojo.InitialUrl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.Enumeration;

@Controller
@RequestMapping(value = "/root")
public class RootController {

    @RequestMapping(value = "/toLogin.do")
    public ModelAndView toLogin(HttpSession session){
        ModelAndView modelAndView = new ModelAndView("userInfo/login");
        Enumeration<String> names = session.getAttributeNames();
        while (names.hasMoreElements()){
            String name = names.nextElement();
            session.removeAttribute(name);
        }
        return modelAndView;
    }

}
