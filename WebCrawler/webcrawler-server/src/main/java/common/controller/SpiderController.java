package common.controller;

import common.pojo.InitialUrl;
import common.pojo.SysParam;
import initialUrl.service.interfaces.InitialUrlService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import sysParam.service.interfaces.SysParamService;

import java.util.ArrayList;

@Controller
@RequestMapping(value = "/spider")
public class SpiderController {

    //初始URL模块service层
    @Autowired
    private InitialUrlService initialUrlService;

    //系统参数模块service层
    @Autowired
    private SysParamService sysParamService;


    /**
     * 跳转爬虫控制页面
     * @return
     */
    @RequestMapping(value = "/goSpiderController.do")
    public ModelAndView goSpiderController(){
        ModelAndView modelAndView = new ModelAndView("personal-controller");
        ArrayList<SysParam> sysParams = this.sysParamService.getAllSysParam();
        modelAndView.addObject("sysParams",sysParams);
        return modelAndView;
    }

    /**
     * 新增UEL功能
     * @param city
     * @param url
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/addNewUrl.do")
    public ModelAndView addNewUrl(String city,String url) throws Exception {
        ModelAndView modelAndView = new ModelAndView("personal-controller");
        InitialUrl initialUrl = new InitialUrl();
        initialUrl.setCity(city);
        initialUrl.setUrl(url);
        this.initialUrlService.addNewUrl(initialUrl);
        ArrayList<SysParam> sysParams = this.sysParamService.getAllSysParam();
        modelAndView.addObject("sysParams",sysParams);
        return modelAndView;
    }

}
