package userInfo.controller;

import common.pojo.UserInfo;
import common.utils.BeanUtils;
import common.utils.CommonUtils;
import common.utils.ConstantUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;
import userInfo.dto.UserInfoDTO;
import userInfo.dto.UserInfoQueryDTO;
import userInfo.service.UserInfoService;


@Controller
@RequestMapping(value = "/user")
@SessionAttributes(names = "currentUser")
public class UserInfoControllerImpl {

    @Autowired
    private UserInfoService userInfoService;

    @RequestMapping(value = "register.do",method = RequestMethod.POST)
    public ModelAndView register(UserInfoQueryDTO queryDTO){
        ModelAndView modelAndView = new ModelAndView();
        //调用注册方法，获取返回值
        String result = this.userInfoService.resister(queryDTO);
        if(CommonUtils.stringEquals(result,ConstantUtils.SUCCESS)){//注册成功
            modelAndView.setViewName("userInfo/login");//跳转登录页面
            modelAndView.addObject("userName",queryDTO.getUserName());//附带用户名信息
            return modelAndView;
        }
        //注册失败，重新加载注册页面，附带错误信息
        modelAndView.setViewName("userInfo/register");
        modelAndView.addObject("errorMessage",result);
        return modelAndView;
    }

    @RequestMapping(value = "login.do",method = RequestMethod.POST)
    public ModelAndView login(UserInfoQueryDTO queryDTO) throws Exception {
        ModelAndView modelAndView = new ModelAndView();
        if(this.userInfoService.login(queryDTO)){//登录成功
            modelAndView.setViewName("main");
            UserInfo target = this.userInfoService.getUserInfoByUserName(queryDTO.getUserName());
            //获取用户信息保存session中
            UserInfoDTO userInfoDTO = BeanUtils.copyObject(target,UserInfoDTO.class);
            modelAndView.addObject("currentUser",userInfoDTO);
            return modelAndView;
        }
        //登录失败，重新加载登录页面，附带错误信息
        modelAndView.setViewName("userInfo/login");
        modelAndView.addObject("errorMessage",ConstantUtils.LOGIN_FAILED);
        return modelAndView;
    }

}
