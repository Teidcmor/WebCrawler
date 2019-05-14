package coreData.controller;


import com.github.pagehelper.PageInfo;
import common.pojo.CoreData;
import common.utils.CommonUtils;
import coreData.dto.CoreDataQueryDTO;
import coreData.service.CoreDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;

@Controller
@RequestMapping(value = "/coreData")
@SessionAttributes(names = {"queryCity","queryRegion","queryDistrict","querySort","queryPrice","queryArea","queryToward"})
public class CoreDataControllerImpl {

    @Autowired
    private CoreDataService coreDataService;


    @RequestMapping(value = "/goMain.do")
    public ModelAndView goMain() throws Exception {
        ModelAndView modelAndView = new ModelAndView("main");
        modelAndView.addObject("querySort","1");
        modelAndView.addObject("queryPrice","0");
        modelAndView.addObject("queryArea","0");
        modelAndView.addObject("queryToward","0");
        PageInfo<CoreData> pageInfo = coreDataService.getCoreDataWithPaging(new CoreDataQueryDTO(),1,"1");
        ArrayList<CoreData> target = (ArrayList<CoreData>) pageInfo.getList();
        modelAndView.addObject("page",pageInfo);
        modelAndView.addObject("coreDatas",target);
        return modelAndView;
    }

    /**
     * 根据地址搜索功能
     * @param coreDataQueryDTO
     * @param session
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/getCoreDataPage.do")
    public ModelAndView getCoreDataPage(CoreDataQueryDTO coreDataQueryDTO, HttpSession session) throws Exception {
        ModelAndView modelAndView = new ModelAndView("main");
        CoreDataQueryDTO queryDTO = this.getCoreDataInSession(session);
        if(coreDataQueryDTO!=null){
            modelAndView.addObject("queryCity",coreDataQueryDTO.getCity());
            modelAndView.addObject("queryRegion",coreDataQueryDTO.getRegion());
            modelAndView.addObject("queryDistrict",coreDataQueryDTO.getDistrict());
            queryDTO.setCity(coreDataQueryDTO.getCity());
            queryDTO.setDistrict(coreDataQueryDTO.getDistrict());
            queryDTO.setRegion(coreDataQueryDTO.getRegion());
        }
        //按默认顺序排序，当前分页为第一页
        //从session获取sort值，
        String sort = (String) session.getAttribute("querySort");
        if(CommonUtils.isNull(sort))
            sort = "1";
        PageInfo<CoreData> pageInfo = coreDataService.getCoreDataWithPaging(queryDTO,1,sort);
        ArrayList<CoreData> target = (ArrayList<CoreData>) pageInfo.getList();
        modelAndView.addObject("page",pageInfo);
        modelAndView.addObject("coreDatas",target);
        return modelAndView;
    }

    /**
     * 翻页功能
     * @param pageNum
     * @param session
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/changePages.do")
    public ModelAndView changePages(String pageNum,HttpSession session) throws Exception {
        ModelAndView modelAndView = new ModelAndView("main");
        CoreDataQueryDTO queryDTO = this.getCoreDataInSession(session);
        PageInfo<CoreData> pageInfo = coreDataService.getCoreDataWithPaging(queryDTO,Integer.valueOf(pageNum),queryDTO.getSort());
        ArrayList<CoreData> target = (ArrayList<CoreData>) pageInfo.getList();
        modelAndView.addObject("page",pageInfo);
        modelAndView.addObject("coreDatas",target);
        return modelAndView;
    }

    /**
     * 根据价格分段搜索功能
     * @param price
     * @param session
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/getCoreDataByPrice.do")
    public ModelAndView getCoreDataByPrice(String price,HttpSession session) throws Exception {
        ModelAndView modelAndView = new ModelAndView("main");
        CoreDataQueryDTO queryDTO = this.getCoreDataInSession(session);
        modelAndView.addObject("queryPrice",price);
        queryDTO.setPrice(Integer.valueOf(price));
        PageInfo<CoreData> pageInfo = coreDataService.getCoreDataWithPaging(queryDTO,1,queryDTO.getSort());
        ArrayList<CoreData> target = (ArrayList<CoreData>) pageInfo.getList();
        modelAndView.addObject("page",pageInfo);
        modelAndView.addObject("coreDatas",target);
        return modelAndView;
    }

    /**
     * 根据面积分段搜索功能
     * @param area
     * @param session
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/getCoreDataByArea.do")
    public ModelAndView getCoreDataByArea(String area,HttpSession session) throws Exception {
        ModelAndView modelAndView = new ModelAndView("main");
        CoreDataQueryDTO queryDTO = this.getCoreDataInSession(session);
        modelAndView.addObject("queryArea",area);
        queryDTO.setArea(Integer.valueOf(area));
        PageInfo<CoreData> pageInfo = coreDataService.getCoreDataWithPaging(queryDTO,1,queryDTO.getSort());
        ArrayList<CoreData> target = (ArrayList<CoreData>) pageInfo.getList();
        modelAndView.addObject("page",pageInfo);
        modelAndView.addObject("coreDatas",target);
        return modelAndView;
    }

    /**
     * 根据房间朝向搜索功能
     * @param toward
     * @param session
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/getCoreDataByToward.do")
    public ModelAndView getCoreDataByToward(String toward,HttpSession session) throws Exception {
        ModelAndView modelAndView = new ModelAndView("main");
        CoreDataQueryDTO queryDTO = this.getCoreDataInSession(session);
        modelAndView.addObject("queryToward",toward);
        queryDTO.setToward(this.getToward(toward));
        PageInfo<CoreData> pageInfo = coreDataService.getCoreDataWithPaging(queryDTO,1,queryDTO.getSort());
        ArrayList<CoreData> target = (ArrayList<CoreData>) pageInfo.getList();
        modelAndView.addObject("page",pageInfo);
        modelAndView.addObject("coreDatas",target);
        return modelAndView;
    }

    /**
     * 排序展示功能
     * @param sort
     * @param session
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/getCoreDataSort.do")
    public ModelAndView getCoreDataSort(String sort,HttpSession session) throws Exception {
        ModelAndView modelAndView = new ModelAndView("main");
        CoreDataQueryDTO queryDTO = this.getCoreDataInSession(session);
        modelAndView.addObject("querySort",sort);
        PageInfo<CoreData> pageInfo = coreDataService.getCoreDataWithPaging(queryDTO,1,sort);
        ArrayList<CoreData> target = (ArrayList<CoreData>) pageInfo.getList();
        modelAndView.addObject("page",pageInfo);
        modelAndView.addObject("coreDatas",target);
        return modelAndView;
    }

    /**
     * 通过id获取租房详细信息
     * @param id
     * @return
     */
    @RequestMapping(value = "/goDetails.do")
    public ModelAndView goDetails(String id){
        CoreDataQueryDTO queryDTO = new CoreDataQueryDTO();
        queryDTO.setId(Long.valueOf(id));
        ModelAndView modelAndView = new ModelAndView("details");
        CoreData target = coreDataService.getDetails(queryDTO);
        target.setPictures(target.getReserve2());
        modelAndView.addObject("details",target);
        return modelAndView;
    }

    /**
     * 获取session中的位置信息
     * @param session
     * @return
     */
    private CoreDataQueryDTO getCoreDataInSession(HttpSession session){
        CoreDataQueryDTO queryDTO = new CoreDataQueryDTO();
        //获取用户上次输入的城市信息
        String city = (String) session.getAttribute("queryCity");
        if(!CommonUtils.isNull(city))
            queryDTO.setCity(city);
        //获取上次用户输入的行政区信息
        String district = (String) session.getAttribute("queryDistrict");
        if(!CommonUtils.isNull(district))
            queryDTO.setDistrict(district);
        //获取上次用户输入的街道信息
        String region = (String) session.getAttribute("queryRegion");
        if(!CommonUtils.isNull(region))
            queryDTO.setRegion(region);
        //获取上次用户输入的面积信息
        String area = (String) session.getAttribute("queryArea");
        if(!CommonUtils.isNull(area))
            queryDTO.setArea(Integer.valueOf(area));
        //获取用户上次输入的价格信息
        String price = (String) session.getAttribute("queryPrice");
        if(!CommonUtils.isNull(price))
            queryDTO.setPrice(Integer.valueOf(price));
        //获取上次用户输入的朝向信息
        String toward = (String) session.getAttribute("queryToward");
        if(!CommonUtils.isNull(toward))
            queryDTO.setToward(this.getToward(toward));
        //获取用户选择的排序方式
        String sort = (String) session.getAttribute("querySort");
        if(CommonUtils.isNull(sort))
            sort = "1";
        queryDTO.setSort(sort);
        return queryDTO;
    }

    /**
     * 房间朝向转换
     * @param toward
     * @return
     */
    private String getToward(String toward){
        if("1".equals(toward))
            return "南";
        else if("2".equals(toward))
            return "北";
        else if("3".equals(toward))
            return "东";
        else if("4".equals(toward))
            return "西";
        else
            return "";
    }
}
