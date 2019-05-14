package userInfo.controller;

import com.github.pagehelper.PageInfo;
import common.pojo.UserInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import userInfo.dto.UserInfoDTO;
import userInfo.service.interfaces.UserInfoService;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping(value = "/admin")
public class AdminControllerImpl {

    @Autowired
    private UserInfoService userInfoService;

    /**
     * 跳转用户管理页面
     * @param session
     * @return
     */
    @RequestMapping(value = "/goUserManage.do")
    public ModelAndView goUserManage(HttpSession session){
        ModelAndView modelAndView = new ModelAndView("personal-ban");
        PageInfo<UserInfo> pageInfo = this.userInfoService.getAllSimpleUser();
        modelAndView.addObject("users",pageInfo);
        return modelAndView;
    }

}
