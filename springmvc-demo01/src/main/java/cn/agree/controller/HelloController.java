package cn.agree.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(path = "/say")
public class HelloController {

    /*
    *  接收请求
    *  加了method = RequestMethod.GET
    *  此时方法只能接收get提交方式
    *
    * */
    @RequestMapping(params = {"name", "!age", "address!=usa", "working=sz"},
            value = "/hello", method = RequestMethod.GET)
    public String sayHello() {
        System.out.println("Hello SpringMVC!!调用了GET方法");
        return "success";
    }

    @RequestMapping(value = "/yourname", method = RequestMethod.POST)
    public String sayYourName() {
        System.out.println("YourName SpringMVC!!调用了POST方法");
        return "success";
    }




}
