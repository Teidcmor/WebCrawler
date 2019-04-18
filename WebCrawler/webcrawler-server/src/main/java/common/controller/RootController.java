package common.controller;

import common.mapper.InitialUrlMapper;
import common.pojo.InitialUrl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping(value = "/root")
public class RootController {

    @Autowired
    private InitialUrlMapper initialUrlMapper;


    @RequestMapping(value = "/toLogin.do")
    public ModelAndView toLogin(){
        ModelAndView modelAndView = new ModelAndView("userInfo/login");
        return modelAndView;
    }

    @RequestMapping(value = "/test.do",method = RequestMethod.POST)
    public ModelAndView test(){
        ModelAndView modelAndView = new ModelAndView("main");
        String info = this.doIt();
        modelAndView.addObject("info",info);
        return modelAndView;
    }

    private String doIt(){
        /*InitialUrl url = new InitialUrl();
        url.setCity("杭州");
        url.setDistrict("滨江");
        url.setCommunity("惠园盛谷");
        url.setUrl("https://www.danke.com/room/hz");
        this.initialUrlMapper.insertUrl(url);
        return "success";*/


        System.out.println("getInitialUrl="+this.initialUrlMapper.getInitialUrl().size());
        System.out.println("getAllInitialUrl="+this.initialUrlMapper.getAllInitialUrl().size());
        System.out.println("getInitialUrlByName="+this.initialUrlMapper.getInitialUrlByName("https://www.danke.com/room/hz").getUrl());
        System.out.println("getInitialUrlById="+this.initialUrlMapper.getInitialUrlById(1L).getUrl());
        return "success";
    }

}
