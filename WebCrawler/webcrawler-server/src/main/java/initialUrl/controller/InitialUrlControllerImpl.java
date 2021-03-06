package initialUrl.controller;

import common.pojo.InitialUrl;
import common.threadPool.InitialUrlThread;
import common.utils.ThreadPoolUtils;
import initialUrl.service.interfaces.InitialUrlService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.Iterator;

@Controller
@RequestMapping(value = "/initialUrl")
public class InitialUrlControllerImpl {

    Logger logger = LogManager.getLogger(LogManager.ROOT_LOGGER_NAME);

    @Autowired
    private InitialUrlService initialUrlService;

    public InitialUrlControllerImpl() {
    }

    @RequestMapping(value = "/get.do" ,method = RequestMethod.POST)
    public ModelAndView get(){
//        logger.info("info level");
        ModelAndView modelAndView = new ModelAndView("info");
////        String info = this.initialUrlService.getUrl();
//        modelAndView.addObject("url",info);
//        modelAndView.setViewName("userInfo/login");
        return modelAndView;
    }


}
