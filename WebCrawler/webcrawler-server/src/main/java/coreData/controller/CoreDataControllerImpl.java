package coreData.controller;


import com.github.pagehelper.PageInfo;
import common.pojo.CoreData;
import coreData.service.CoreDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;

@Controller
@RequestMapping(value = "/coreData")
public class CoreDataControllerImpl {

    @Autowired
    private CoreDataService coreDataService;

    @RequestMapping(value = "/getCoreDataPage.do" ,method = RequestMethod.POST)
    public ModelAndView getCoreDataPage(){
        ModelAndView modelAndView = new ModelAndView("main");
        PageInfo<CoreData> pageInfo = coreDataService.getCoreDataWithPaging();
        ArrayList<CoreData> target = (ArrayList<CoreData>) pageInfo.getList();
        modelAndView.addObject("page",pageInfo);
        modelAndView.addObject("coreDatas",target);
        return modelAndView;
    }

}
