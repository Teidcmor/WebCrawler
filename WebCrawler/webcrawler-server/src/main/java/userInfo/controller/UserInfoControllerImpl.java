package userInfo.controller;

import common.pojo.UserInfo;
import common.utils.BeanUtils;
import common.utils.CommonUtils;
import common.utils.ConstantUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;
import userInfo.dto.UserInfoDTO;
import userInfo.dto.UserInfoQueryDTO;
import userInfo.service.interfaces.UserInfoService;

import javax.servlet.http.HttpSession;


@Controller
@RequestMapping(value = "/user")
@SessionAttributes(names = "currentUser")
public class UserInfoControllerImpl {

    @Autowired
    private UserInfoService userInfoService;

    @RequestMapping(value = "register.do",method = RequestMethod.POST)
    public ModelAndView register(UserInfoQueryDTO queryDTO) throws Exception{
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
            modelAndView.setViewName("redirect:/coreData/goMain.do");
            UserInfo target = this.userInfoService.getUserInfoByUserName(queryDTO.getUserName());
            //获取用户信息保存session中
            modelAndView.addObject("currentUser",target);
            return modelAndView;
        }
        //登录失败，重新加载登录页面，附带错误信息
        modelAndView.setViewName("userInfo/login");
        modelAndView.addObject("errorMessage",ConstantUtils.LOGIN_FAILED);
        return modelAndView;
    }

    /**
     * 跳转个人中心页面
     * @param session
     * @return
     */
    @RequestMapping(value = "/goPersonal.do")
    public ModelAndView goPersonal(HttpSession session){
        ModelAndView modelAndView = new ModelAndView("personal");
        //获取当前登录用户信息
        UserInfo currentUser = (UserInfo) session.getAttribute("currentUser");
        //通过id重新在数据库中查询当前登录用户的信息
        UserInfo target = this.userInfoService.getUserInfoById(currentUser.getId());
        modelAndView.addObject("currentUser",target);
        return modelAndView;
    }

    /**
     * 修改用户密码
     * @param session
     * @param password
     * @return
     */
    @RequestMapping(value = "/changePassword.do")
    public ModelAndView changePassword(HttpSession session,String password){
        ModelAndView modelAndView = new ModelAndView("personal");
        //获取当前登录用户信息
        UserInfo currentUser = (UserInfo) session.getAttribute("currentUser");
        //创建用于保存修改信息的对象，将id和新密码赋值
        UserInfo userInfo = new UserInfo();
        userInfo.setId(currentUser.getId());
        userInfo.setPassword(password);
        //调用service层方法修改密码
        this.userInfoService.updateUserPassword(userInfo);
        //从数据库中查询修改后的用户信息
        userInfo = this.userInfoService.getUserInfoById(currentUser.getId());
        modelAndView.addObject("currentUser",userInfo);
        return modelAndView;
    }

    /**
     * 修改用户性别
     * @param session
     * @param sex
     * @return
     */
    @RequestMapping(value = "/changeSex.do")
    public ModelAndView changeSex(HttpSession session,String sex){
        ModelAndView modelAndView = new ModelAndView("personal");
        //获取当前登录用户信息
        UserInfo currentUser = (UserInfo) session.getAttribute("currentUser");
        //创建用于保存修改信息的对象，将id和新性别赋值
        UserInfo userInfo = new UserInfo();
        userInfo.setId(currentUser.getId());
        //将前台传值进行转换，如果合法则保存在数据库中
        if(!CommonUtils.isNull(this.getSex(sex))) {
            userInfo.setReserve1(this.getSex(sex));
            //从数据库中读取出修改后的用户信息，并传给前台
            this.userInfoService.updateUserSex(userInfo);
        }
        userInfo = this.userInfoService.getUserInfoById(currentUser.getId());
        modelAndView.addObject("currentUser",userInfo);
        return modelAndView;
    }

    /**
     * 前台性别的传值为男女，这里需要转换为0和1,如果传过来的值不是男或女则不保存
     *  0 - 女
     *  1 - 男
     * @param sex
     * @return
     */
    private String  getSex(String sex){
        if("男".equals(sex))
            return ConstantUtils.USER_SEX_MAN;
        else if("女".equals(sex))
            return ConstantUtils.USER_SEX_WUMAN;
        else
            return "";
    }


}
