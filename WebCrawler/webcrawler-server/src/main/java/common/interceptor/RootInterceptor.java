package common.interceptor;

import common.pojo.UserInfo;
import common.utils.ConstantUtils;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;
import userInfo.dto.UserInfoDTO;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class RootInterceptor implements HandlerInterceptor {

    public boolean preHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o) throws Exception {
        HttpSession session = httpServletRequest.getSession();
        String requestUrl = httpServletRequest.getRequestURI();
        if(requestUrl.contains("/user/login.do")||requestUrl.contains("/user/register.do"))
            return true;
        UserInfo currentUser = (UserInfo) session.getAttribute("currentUser");
        //如果没有登录，驳回
        if(currentUser==null) {
            httpServletResponse.sendRedirect("/view/userInfo/login.jsp");
            return false;
        }
        //如果普通用户访问了管理员权限下的内容，驳回
        if(requestUrl.contains("/admin")){
            if(ConstantUtils.USER_TYPE_SIMPLE.equals(currentUser.getType()))
                return false;
        }
        return true;
    }

    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {

    }

    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {

    }
}
