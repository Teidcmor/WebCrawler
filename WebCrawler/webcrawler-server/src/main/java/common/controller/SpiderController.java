package common.controller;

import common.pojo.InitialUrl;
import common.pojo.SysParam;
import common.threadPool.InitialUrlThread;
import common.utils.CommonUtils;
import common.utils.ThreadPoolUtils;
import initialUrl.service.interfaces.InitialUrlService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import sysParam.service.interfaces.SysParamService;

import java.util.ArrayList;
import java.util.Iterator;

@Controller
@RequestMapping(value = "/spider")
public class SpiderController {

    Logger logger = LogManager.getLogger(LogManager.ROOT_LOGGER_NAME);


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
    @RequestMapping(value = "/addNewUrl.do" ,produces ="application/text;charset=utf-8")
    @ResponseBody
    public String addNewUrl(String city,String url) throws Exception {
        if(CommonUtils.isNull(city)|| CommonUtils.isNull(url))
            return "请输入完整信息！！";
        try{
            InitialUrl initialUrl = new InitialUrl();
            initialUrl.setCity(city);
            initialUrl.setUrl(url);
            this.initialUrlService.addNewUrl(initialUrl);
        }catch (Exception e){
            return "新增失败！！";
        }
        return "新增成功！！";
    }

    /**
     * 修改系统参数值
     * @param id
     * @param value
     * @return
     */
    @RequestMapping(value = "/updateSysParam.do")
    public ModelAndView updateSysParam(String id,String value){
        ModelAndView modelAndView = new ModelAndView("personal-controller");
        SysParam target = new SysParam();
        target.setId(Long.valueOf(id));
        target.setParamValue(value);
        this.sysParamService.updateSysParam(target);
        ArrayList<SysParam> sysParams = this.sysParamService.getAllSysParam();
        modelAndView.addObject("sysParams",sysParams);
        return modelAndView;
    }

}
