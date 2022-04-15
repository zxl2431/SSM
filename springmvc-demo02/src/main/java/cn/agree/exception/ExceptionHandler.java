package cn.agree.exception;

import org.apache.log4j.Logger;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;
import java.io.StringWriter;


public class ExceptionHandler implements HandlerExceptionResolver {

    // 异常对象
    Logger logger = Logger.getLogger(ExceptionHandler.class);

    /*
     * 全局异常处理
     *
     * */
    @Override
    public ModelAndView resolveException(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) {
        // 获取异常信息
        StringWriter stringWriter = new StringWriter();
        //将异常信息由控制台输出转化到StringWrite中
        ex.printStackTrace(new PrintWriter(stringWriter));

        // 将异常信息转成字符类型数据
        String errorinfo = stringWriter.toString();

        // 直接将异常信息记录日志
        logger.info("发生了异常", ex);

        ModelAndView modelAndView = new ModelAndView();

        //友好提示信息
        modelAndView.addObject("msg","对不起，你的网络不稳定！");
        //设置视图页面
        modelAndView.setViewName("error");
        return modelAndView;
    }





}
