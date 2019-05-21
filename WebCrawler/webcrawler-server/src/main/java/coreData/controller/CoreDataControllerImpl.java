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
        //初次跳转主页面时,为页面上价格,朝向,面积,排序方式等几个查询条件富裕初值,并且保存在session中
        modelAndView.addObject("querySort","1");
        modelAndView.addObject("queryPrice","0");
        modelAndView.addObject("queryArea","0");
        modelAndView.addObject("queryToward","0");
        //分页查询有效信息,默认分类方式为数据库顺序
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
            //把前台的搜索信息都保存在session中
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
        //获取七个查询条件中的历史查询记录,即session中保存的记录
        CoreDataQueryDTO queryDTO = this.getCoreDataInSession(session);
        //根据查询条件分页查询所需信息
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
        //获取上一次输入的搜索条件
        CoreDataQueryDTO queryDTO = this.getCoreDataInSession(session);
        //把最新的价格条件更新到session中
        modelAndView.addObject("queryPrice",price);
        queryDTO.setPrice(Integer.valueOf(price));
        //按所有查询条件分页查询有效信息
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
        //获取上一次输入的搜索条件
        CoreDataQueryDTO queryDTO = this.getCoreDataInSession(session);
        //把最新的面积条件更新到session中
        modelAndView.addObject("queryArea",area);
        queryDTO.setArea(Integer.valueOf(area));
        //根据当前最新的条件分页查询有效信息
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
        //获取上一次输入的搜索条件
        CoreDataQueryDTO queryDTO = this.getCoreDataInSession(session);
        //把最新的朝向搜索条件更新到session中
        modelAndView.addObject("queryToward",toward);
        queryDTO.setToward(this.getToward(toward));
        //根据当前最新的搜索条件分页查询有效信息
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
        //获取上次输入的搜索信息
        CoreDataQueryDTO queryDTO = this.getCoreDataInSession(session);
        //把最新选择的排序方式更新到session中
        modelAndView.addObject("querySort",sort);
        //根据当前最新的搜索条件分页查询有效信息
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
        //通过id查询详细的有效信息
        CoreData target = coreDataService.getDetails(queryDTO);
        //图片链接原本是通过逗号分隔,存在一个字段中,调用这个方法是将逗号去掉,保存在一个list中.
        //只有当前功能--展示详情的时候会需要展示所有的图片信息,所以把这个方法单独抽取出来
        target.setPictures();
        modelAndView.addObject("details",target);
        return modelAndView;
    }

    /**
     * 获取session中的搜索信息
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
