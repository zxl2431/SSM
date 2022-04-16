package cn.agree.interceptor;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/*
*  拦截器
*
* */
public class LoginInterceptor implements HandlerInterceptor {

    /*
    * 目标方法执行之前执行
    *
    * */
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        System.out.println("===================preHandle===============AAA");
        // 如果返回false, 则目标方法终端
        // return false;

        return true;
    }

    /*
    *  目标方法执行完毕之后执行
    *
    * */
    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        System.out.println("-------------------postHandle----------------AAA");
    }

    /*
    *  完成视图渲染后执行
    *
    * */

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        System.out.println("====================afterCompletion====================AAA");
    }
}
