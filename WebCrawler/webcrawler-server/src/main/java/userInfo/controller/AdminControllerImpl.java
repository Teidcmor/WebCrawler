package userInfo.controller;

import com.github.pagehelper.PageInfo;
import common.pojo.UserInfo;
import common.utils.ConstantUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import userInfo.dto.UserInfoDTO;
import userInfo.service.interfaces.UserInfoService;

import javax.jws.WebParam;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;

@Controller
@RequestMapping(value = "/admin")
public class AdminControllerImpl {

    @Autowired
    private UserInfoService userInfoService;

    /**
     * 跳转用户管理页面
     *
     * @return
     */
    @RequestMapping(value = "/goUserManage.do")
    public ModelAndView goUserManage(){
        ModelAndView modelAndView = new ModelAndView("personal-ban");
        //默认跳转第一页
        PageInfo<UserInfo> pageInfo = this.userInfoService.getAllSimpleUser(1);
        ArrayList<UserInfo> users = (ArrayList<UserInfo>) pageInfo.getList();
        modelAndView.addObject("users",users);
        modelAndView.addObject("page",pageInfo);
        return modelAndView;
    }

    @RequestMapping(value = "/changePage.do")
    public ModelAndView changePage(String pageNum){
        ModelAndView modelAndView = new ModelAndView("personal-ban");
        PageInfo<UserInfo> pageInfo = this.userInfoService.getAllSimpleUser(Integer.valueOf(pageNum));
        ArrayList<UserInfo> users = (ArrayList<UserInfo>) pageInfo.getList();
        modelAndView.addObject("users",users);
        modelAndView.addObject("page",pageInfo);
        return modelAndView;

    }

    /**
     * 禁用用户或解禁用户
     * @param id
     * @param status
     * @param pageNum
     * @return
     */
    @RequestMapping(value = "/banUser.do")
    public ModelAndView changeUserStatus(String id,String status,String pageNum){
        ModelAndView modelAndView = new ModelAndView("personal-ban");
        UserInfo userInfo = new UserInfo();
        userInfo.setId(Long.valueOf(id));
        //如果要将用户设为可用
        if(ConstantUtils.USER_ENABLE.equals(status)) {
            userInfo.setEnabled(ConstantUtils.USER_ENABLE);
            this.userInfoService.setUserEnable(userInfo);
        }
        else {//如果要将用户设为不可用
            userInfo.setEnabled(ConstantUtils.USER_UNENABLE);
            this.userInfoService.setUserUnEnable(userInfo);
        }
        //重新查询分页结果展示
        PageInfo<UserInfo> pageInfo = this.userInfoService.getAllSimpleUser(Integer.valueOf(pageNum));
        ArrayList<UserInfo> users = (ArrayList<UserInfo>) pageInfo.getList();
        modelAndView.addObject("users",users);
        modelAndView.addObject("page",pageInfo);
        return modelAndView;
    }

}
